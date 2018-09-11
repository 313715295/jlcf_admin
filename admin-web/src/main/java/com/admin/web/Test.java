package com.admin.web;

import com.admin.commons.serializer.FastJsonRedisSerializer;
import com.admin.module.entity.Menu;
import com.admin.module.entity.Role;
import com.admin.module.entity.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

/**
 * created by zwq on 2018/9/8
 */
public class Test {

    public static void main(String[] args) {
        String json = "{\n" +
                "\t\"delFlag\": false,\n" +
                "\t\"email\": \"b@qq.com\",\n" +
                "\t\"icon\": \"https://static.mysiteforme.com/3c5b69f4-2e39-4f88-b302-a6eb48e4c43a.jpg\",\n" +
                "\t\"id\": 1,\n" +
                "\t\"locked\": false,\n" +
                "\t\"loginName\": \"test\",\n" +
                "\t\"tel\": \"13776055179\"\n" +
                "}";
        User user = new User();
        Set<Role> roles = new HashSet<>();
        roles.add(new Role().setName("test1"));
        roles.add(new Role().setName("test2"));
        Set<Menu> menus = new HashSet<>();
        menus.add(new Menu().setName("menu1"));
        menus.add(new Menu().setName("menu2"));
        user.setEmail("b@qq.com").setIcon("icon").setLoginName("test")
                .setRoleLists(roles).setMenus(menus)
        ;
        JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
        byte[] bytes1 = jdkSerializationRedisSerializer.serialize(user);
        System.out.println(bytes1.length);
        FastJsonRedisSerializer<Object> redisSerializer = new FastJsonRedisSerializer<>(Object.class);
        byte[] bytes = redisSerializer.serialize(user);
//        byte[] bytes = JSON.toJSONString(user, SerializerFeature.WriteClassName).getBytes(Charset.forName("UTF-8"));
//        System.out.println(bytes.length);
//////        System.out.println(Arrays.toString(bytes));
//////        User user1 = JSON.parseObject(bytes, User.class, redisSerializer.getFastJsonConfig().getFeatures());
//        User user1 = redisSerializer.deserialize(bytes);
        String str = new String(bytes,  Charset.forName("UTF-8"));
        User user1 = JSON.parseObject(str, User.class);
        System.out.println(str);
        System.out.println(user1);
    }
}
