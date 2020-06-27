package com.zzm.applications.redis.config;

/**
 * <b>Description</b>  CustomizedRedisConfig
 *
 * @Author Zhenzhen
 * @Since 2020-06-26 周五 19:56
 * @Info CustomizedRedisConfig
 * 原理：
 * 1。引入Redis的starter之后，容易保存的是 RedisCacheManager
 * 2。RedisCacheManager帮创建 RedisCache来作为缓存自建，RedisCache通过操作redis缓存数据
 * 3。 默认保存数据 K/V都是Object，利用序列化保存数据。 如何保存Json
 * 1。引入Redis的starter，CacheManager变为RedisCacheManager
 * 2。默认创建RedisCacheManager 操作Redis的时候，使用的是 RedisTemplate<String, Object>
 * 3。RedisTemplate<String, Object> 默认使用的是JDK的序列化机制
 * 4。自定CacheManager
 */

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
//import com.zzm.applications.beans.Customers;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.*;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.time.Duration;

@Configuration
public class CustomizedRedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 配置连接工厂
        template.setConnectionFactory(factory);
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer<Object> jacksonSerial = new Jackson2JsonRedisSerializer<>(Object.class);
        jacksonSerial.setObjectMapper(getObjectMapper());
        // value序列化方式采用jackson
        template.setValueSerializer(jacksonSerial);
        // key采用String的序列化方式
        template.setKeySerializer(keySerializer());
        // 对hash的key采用String的序列化方式
        template.setHashKeySerializer(keySerializer());
        // 对hash的value采用jackson的序列化方式
        template.setHashValueSerializer(jacksonSerial);
        template.afterPropertiesSet();

        return template;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(getObjectMapper());
        // 配置序列化（解决乱码的问题）,过期时间30秒
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(18000))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                .disableCachingNullValues();// 不允许缓存value为空值的情况，如果Value为null，会导致报错
        return RedisCacheManager.builder(factory).cacheDefaults(config).build();
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(keySerializer());
        redisTemplate.setHashKeySerializer(keySerializer());
        redisTemplate.setValueSerializer(valueSerializer());
        redisTemplate.setHashValueSerializer(valueSerializer());
        return redisTemplate;
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return  new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return target.getClass().getSimpleName() + "#"+ method.getName() + "#(" + StringUtils.arrayToDelimitedString(params, "#")+")";

            }
        };
    }

    private RedisSerializer<String> keySerializer() {
        return new StringRedisSerializer();
    }

    private RedisSerializer<Object> valueSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);//已过期的方法，直接调用activateDefaultTyping
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.WRAPPER_ARRAY);
        return objectMapper;
    }

}
