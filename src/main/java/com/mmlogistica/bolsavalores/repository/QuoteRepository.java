package com.mmlogistica.bolsavalores.repository;

import com.mmlogistica.bolsavalores.Entities.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface QuoteRepository extends PagingAndSortingRepository <Quote, Long> {
    @RestResource(rel = "quotes", path = "quotes")
    Page<Quote> findAllBySymbol(@Param("symbol")String symbol, Pageable page);

    Optional<Quote> findFirstBySymbolOrderByTimestampDesc(String teste);
}
