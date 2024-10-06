package com.example.test1.service.client;

import com.example.test1.model.Anime;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimeClientFallback implements AnimeClient{

    @Override
    public List<Anime> animeList() {
        return null;
    }
}
