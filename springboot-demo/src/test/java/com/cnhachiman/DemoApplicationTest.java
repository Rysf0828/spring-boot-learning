package com.cnhachiman;


import com.cnhachiman.framework.RedisClient;
import com.cnhachiman.web.domain.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Autowired
//  自定义redistemplate封装工具类
    private RedisClient redisClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Before
    public void setUp() throws Exception {
        // TODO 因为我们修改了 content-path 所以请求后面要带上
        this.base = new URL("http://localhost:" + port + "/demo/get");
    }

    @Test
    public void demo1() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        assertEquals(response.getBody(), "just test!");
    }

    @Test
    public void redisTest()
    {

        stringRedisTemplate.opsForValue().set("name","bob");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
        redisClient.set("student::1", new Student("jackMa",50,1,"阿驴巴巴"));

        redisClient.set("key1", "value1");

        Student e = (Student) redisClient.get("student::1");
        String value = (String) redisClient.get("key1");
        System.out.println(e);
        System.out.println(value);

        redisClient.hset("myHash","student::1", new Student("jackMa",50,1,"阿驴巴巴"));
        redisClient.hset("myHash","student::2", new Student("ponyMa",49,1,"疼迅"));
        redisClient.hset("myHash","student::3", new Student("RobinLi",48,1,"白度"));

        e = (Student) redisClient.hget("myHash", "student::1");
        System.out.println(e);

        Map<Object,Object> maps = redisClient.hmget("myHash");
        System.out.println(maps);
    }

}
