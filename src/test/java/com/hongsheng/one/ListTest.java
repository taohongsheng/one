package com.hongsheng.one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis操作列表（List）
 * @author pan_junbiao
 **/
@SpringBootTest
public class ListTest {

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void list1(){
        String[] user1 = new String[]{"1","2","3"};
        String[] user2 = new String[]{"4","5","6"};
        String[] user3 = new String[]{"7","8","9"};

        redisTemplate.opsForList().leftPushAll("1",user1);
        redisTemplate.opsForList().rightPushAll("2",user2);
        redisTemplate.opsForList().leftPushAll("3",user3);
        System.out.println(redisTemplate.opsForList().range("1",0,-1));
        System.out.println(redisTemplate.opsForList().range("2",0,-1));
        System.out.println(redisTemplate.opsForList().range("3",0,-1));


    }
    @Test
    public void test2(){
        redisTemplate.opsForList().rightPush("13","1");
        redisTemplate.opsForList().rightPush("13","2");
        redisTemplate.opsForList().leftPush("13","3");
        redisTemplate.opsForList().rightPush("13","4");
        System.out.println(redisTemplate.opsForList().index("13",0));
        System.out.println(redisTemplate.opsForList().index("13",1));
        System.out.println(redisTemplate.opsForList().index("13",2));
        System.out.println(redisTemplate.opsForList().index("13",3));

    }
    @Test
    public void list3(){
        String[] user = new String[]{"1","2","3","4","5"};
        redisTemplate.opsForList().leftPushAll("one",user);
        System.out.println(redisTemplate.opsForList().size("one"));

    }
    @Test
    public void list4(){
        String[] user = new String[]{"1","2","3","4"};
        redisTemplate.opsForList().leftPushAll("123",user);
        System.out.println(redisTemplate.opsForList().range("123",0,-1));
        redisTemplate.opsForList().set("123",2,"123341");
        System.out.println(redisTemplate.opsForList().range("123",0,-1));
    }
    @Test
    public void test6(){
        String[] user = new String[]{"1","3","3","3","5"};
        redisTemplate.opsForList().rightPushAll("user",user);
        System.out.println(redisTemplate.opsForList().range("user",0,-1));
        redisTemplate.opsForList().remove("user",2,"3");
        System.out.println(redisTemplate.opsForList().range("user",0,-1));

    }
    @Test
    public void main(){
        String[] happy = new String[]{"1","2","3","4","5"};
        System.out.println(redisTemplate.opsForList().rightPushAll("happy",happy));
        System.out.println(redisTemplate.opsForList().range("happy",0,-1));
        System.out.println(redisTemplate.opsForList().rightPop("happy"));
        System.out.println(redisTemplate.opsForList().range("happy",0,-1));
    }

}