package com.mmlogistica.bolsavalores.configurations;

import com.mmlogistica.bolsavalores.handler.QuoteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.*;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
@EnableWebFlux
public class WebConfig {
    @Bean
    public RouterFunction<ServerResponse> routeQuote(QuoteHandler quoteHandler){
        return route(GET("/quotes"), quoteHandler::getAllQuotes);
    }

}
