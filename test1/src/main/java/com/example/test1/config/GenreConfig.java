package com.example.test1.config;

import com.example.test1.commons.HorrorGenre;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenreConfig {

    @Bean("horror")
    public HorrorGenre horrorGenre() {
        return new HorrorGenre();
    }
}
