package br.com.atarashi.controlemanutencaoequipamentos.config.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class WebFilter implements org.springframework.web.server.WebFilter {

    @Value("${server.context-path}")
    private String context;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        final ServerHttpRequest request = exchange.getRequest();
        if (request.getURI().getPath().startsWith(context)) {
            return chain.filter(
                    exchange.mutate()
                            .request(request.mutate()
                                    .contextPath(context)
                                    .build())
                            .build());
        }
        return chain.filter(exchange);
    }
}
