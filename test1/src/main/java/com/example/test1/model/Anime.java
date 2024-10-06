package com.example.test1.model;

public record Anime(
        String animeName,
        String genre,
        String description,
        int port
) {
    public static Anime of(String animeName, String genre, String description, int port) {
        return new Anime(animeName, genre, description, port);
    }
}
