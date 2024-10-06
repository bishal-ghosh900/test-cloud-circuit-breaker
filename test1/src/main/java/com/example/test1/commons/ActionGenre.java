package com.example.test1.commons;

import com.example.test1.commons.Genre;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("action")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ActionGenre implements Genre {
    @Override
    public String gereDescription() {
        return "Action genre all about fighting";
    }
}
