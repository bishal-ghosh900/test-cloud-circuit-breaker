package com.example.gatewayserver.service.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Configuration
public class CustomPreProstFilter {

    private static final String xAppHeader = "X-App-Id";

    @Bean
    public GlobalFilter customPreFilter() {
        return (exchange, chain) -> {
            List<String> values = exchange.getRequest().getHeaders().get(xAppHeader);
            if (values != null && !values.isEmpty()) {
                return chain.filter(exchange);
            }
            exchange.getRequest().mutate().header(xAppHeader, getConsumeAppID()).build();
            return chain.filter(exchange);
        };
    }

    @Bean
    public GlobalFilter customPostFilter() {
        return (exchange, chain) -> chain.filter(exchange)
                .then(Mono.just(exchange))
                .map(serverWebExchange -> {
                    List<String> values = serverWebExchange.getRequest().getHeaders().get(xAppHeader);
                    if(!serverWebExchange.getResponse().getHeaders().containsKey(xAppHeader)) {
                        serverWebExchange.getResponse().getHeaders().add(xAppHeader, Objects.requireNonNull(values).get(0));
                    }
                    return serverWebExchange;
                })
                .then();
    }

    private String getConsumeAppID() {
        return UUID.randomUUID().toString();
    }

}
