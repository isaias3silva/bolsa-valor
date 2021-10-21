package com.mmlogistica.bolsavalores.handler;

import com.mmlogistica.bolsavalores.Entities.Quote;
import com.mmlogistica.bolsavalores.repository.QuoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class QuoteHandler {
    private final QuoteRepository quoteRepository;

    public Mono<ServerResponse> getAllQuotes(ServerRequest req){
        Flux<Quote> quotes = quoteRepository.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(quotes, Quote.class);
    }

}
