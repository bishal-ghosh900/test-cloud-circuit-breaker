package com.example.test2.service;

import com.example.test2.model.Anime;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnimeService {

    @Value("classpath:data/anime.json")
    private Resource resource;

    @Value("${server.port}")
    private int serverPort;

    public List<Anime> getAnimeList() {
        List<Anime> anime = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ArrayNode node = (ArrayNode) objectMapper.readTree(resource.getFile());
            node.forEach(jsonNode -> anime.add(Anime.of(
                    jsonNode.get("animeName").asText(),
                    jsonNode.get("genre").asText(),
                    jsonNode.get("description").asText(),
                    serverPort
            )));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return anime;
    }
}
