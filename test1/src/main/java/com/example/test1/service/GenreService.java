package com.example.test1.service;

import com.example.test1.model.Anime;
import com.example.test1.service.client.AnimeClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final AnimeClient animeClient;

    @Value("${server.port}")
    private int port;

    public GenreService(AnimeClient animeClient) {
        this.animeClient = animeClient;
    }

    public List<Anime> getAnimeByGenre(String genre) {
        List<Anime> anime = animeClient.animeList();

        if(anime == null) {
            return List.of(Anime.of(
                    "No Anime! Study time",
                    "No genre",
                    "No description",
                    port
            ));
        }

        return anime
                .stream()
                .filter(m -> m.genre().equalsIgnoreCase(genre))
                .toList();
    }
}
