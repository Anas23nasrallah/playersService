package org.example.playersservice.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.caffeine.CaffeineCacheManager;

import com.github.benmanes.caffeine.cache.Caffeine;


@Configuration
public class CacheConfig {
    public static final String PLAYERS_CACHE_NAME = "players";

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager(PLAYERS_CACHE_NAME);
        Caffeine<Object, Object> caffeineCache = Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.DAYS).maximumSize(1000);
        cacheManager.setCaffeine(caffeineCache);
        return cacheManager;
    }
}
