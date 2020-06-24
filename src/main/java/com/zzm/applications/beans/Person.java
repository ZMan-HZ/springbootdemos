package com.zzm.applications.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <b>Description</b>  Person
 *
 * @Author Zhenzhen
 * @Since 2020-06-20 周六 13:40
 * @Info Person
 */
/*
 @ConfigurationProperties tell spring, set all attribute and value bind to yml properties
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    /**
     *  @Value 支持 普通变量，${key} 从环境变量/配置文件中获取。 #{SpEL}
     */
   // @Value("${person.name}")
    private String name;
    //@Value("#{11*3}")
    private Integer age;
    //@Value("true")
    private Boolean isBoss;
    private Date birthday;
    private List<String> list;
    private Map<String, String> maps;
    private Dog dog;

    public Person() {
    }


    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public Boolean getIsBoss() {
        return this.isBoss;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public List<String> getList() {
        return this.list;
    }

    public Map<String, String> getMaps() {
        return this.maps;
    }

    public Dog getDog() {
        return this.dog;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setIsBoss(Boolean isBoss) {
        this.isBoss = isBoss;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        final Person other = (Person) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$age = this.getAge();
        final Object other$age = other.getAge();
        if (this$age == null ? other$age != null : !this$age.equals(other$age)) return false;
        final Object this$isBoss = this.getIsBoss();
        final Object other$isBoss = other.getIsBoss();
        if (this$isBoss == null ? other$isBoss != null : !this$isBoss.equals(other$isBoss)) return false;
        final Object this$birthday = this.getBirthday();
        final Object other$birthday = other.getBirthday();
        if (this$birthday == null ? other$birthday != null : !this$birthday.equals(other$birthday)) return false;
        final Object this$list = this.getList();
        final Object other$list = other.getList();
        if (this$list == null ? other$list != null : !this$list.equals(other$list)) return false;
        final Object this$maps = this.getMaps();
        final Object other$maps = other.getMaps();
        if (this$maps == null ? other$maps != null : !this$maps.equals(other$maps)) return false;
        final Object this$dog = this.getDog();
        final Object other$dog = other.getDog();
        if (this$dog == null ? other$dog != null : !this$dog.equals(other$dog)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Person;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $age = this.getAge();
        result = result * PRIME + ($age == null ? 43 : $age.hashCode());
        final Object $isBoss = this.getIsBoss();
        result = result * PRIME + ($isBoss == null ? 43 : $isBoss.hashCode());
        final Object $birthday = this.getBirthday();
        result = result * PRIME + ($birthday == null ? 43 : $birthday.hashCode());
        final Object $list = this.getList();
        result = result * PRIME + ($list == null ? 43 : $list.hashCode());
        final Object $maps = this.getMaps();
        result = result * PRIME + ($maps == null ? 43 : $maps.hashCode());
        final Object $dog = this.getDog();
        result = result * PRIME + ($dog == null ? 43 : $dog.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Person(name=" + this.getName() + ", age=" + this.getAge() + ", isBoss=" + this.getIsBoss() + ", birthday=" + this.getBirthday() + ", list=" + this.getList() + ", maps=" + this.getMaps() + ", dog=" + this.getDog() + ")";
    }
}
