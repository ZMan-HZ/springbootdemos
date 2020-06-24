package com.zzm.applications;

import com.zzm.applications.beans.Person;
import com.zzm.applications.service.AppService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import sun.awt.geom.AreaOp;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppTests {

private static  final Logger logger = LoggerFactory.getLogger(AppTests.class);


    @Autowired
    Person person;

    @Autowired
    ApplicationContext ctx;

@Test
public void testAppService(){
    boolean exists = ctx.containsBean("appService");
    logger.info("appService exist? "+exists);
}


    @Test
    void contextLoads() {
        logger.info(person.toString());
    }

}
