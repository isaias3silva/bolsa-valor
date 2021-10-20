package com.mmlogistica.bolsavalores;

import com.mmlogistica.bolsavalores.Entities.Quote;
import com.mmlogistica.bolsavalores.repository.QuoteRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Log4j2
@EnableScheduling
@SpringBootApplication
public class ProjetoBolsaDeValoresApplication {

	@Autowired
	private QuoteRepository quoteRepository;

	public static void main(String[] args) {SpringApplication.run(ProjetoBolsaDeValoresApplication.class, args);}

		@Scheduled(fixedDelay = 1000)
		public void generateDate(){
			log.info(quoteRepository.findFirstBySymbolOrderByTimestampDesc("Teste")
					.map(this::generateNewData)
					.orElseGet(this::initilizeData));
		}

	private Quote initilizeData() {
		return Quote.builder()
				.symbol("TESTE")
				.openValue(0.22222)
				.closeValue(0.222222)
				.timestamp(new Date())
				.build();
	}

	private Quote generateNewData(Quote quote) {
		return Quote.builder()
				.symbol(quote.getSymbol())
				.openValue(quote.getOpenValue())
				.closeValue(quote.getCloseValue())
				.timestamp(new Date())
				.build();
	}
}
