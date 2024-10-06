package com.example.test1.service.client;

import com.example.test1.model.Anime;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Primary
@FeignClient(name = "test2", fallback = AnimeClientFallback.class)
public interface AnimeClient {
    @GetMapping(value = "/animes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Anime> animeList();
}
