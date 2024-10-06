package com.example.test2.model;

public record Anime(
        String animeName,
        String genre,
        String description,

        int port // just to check load balancing is working or not
) {
    public static Anime of(String animeName, String genre, String description, int port) {
        return new Anime(animeName, genre, description, port);
    }
}
