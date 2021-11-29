//package com.som.springboot.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.core.RedisTemplate;
//
//@Configuration
//public class RedisConfiguration {
////重写Redis序列化方式，使用Json方式:
////当数据存储到Redis时，键(key) 和值(value) 都是通过Spring提供的Serializer序列化到Redis的
//// RedisTemplate默认使用的是JdkSerializationRedisSerializer,StringRedisTemplate默认使用的是StringRedisSerializer。
//// Spring Data JPA提供了下面的Serializer:
//// GenericToStringSerializer/Jackson2JsonRedisSerializer/JacksonJsonRedisSerializer/JdkSerializationRedisSerializer/OxmSerializer/StringRedisSerializer。
////在此配置RedisTemplate并定义Serializer。
//@Bean
//public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate. setConnectionFactory(redisConnectionFactory) ;
//        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();//创建一个json的序列化对象
//        redisTemplate. setValueSerializer(jackson2JsonRedisSerializer);//设置value的序列化方式json
//        redisTemplate. setKeySerializer (new StringRedisSerializer());//设置key序列化方式string
//        redisTemplate. setHashKeySerializer(new StringRedisSerializer()) ;//设置hash key序列化方式string
//        redisTemplate. setHashValueSerializer(jackson2JsonRedisSerializer);//设置hash value的序列化方式json
//        redisTemplate. afterPropertiesSet();
//        return redisTemplate;
//        }
//}
