package com.example.test1.commons;

import com.example.test1.commons.Genre;
import org.springframework.stereotype.Component;

@Component("comedy")
public class ComedyGenre implements Genre {
    @Override
    public String gereDescription() {
        return "Comedy genre includes lots of crazy stuffs";
    }
}
