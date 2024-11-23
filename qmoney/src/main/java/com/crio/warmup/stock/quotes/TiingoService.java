package com.crio.warmup.stock.quotes;

import com.crio.warmup.stock.dto.Candle;
import com.crio.warmup.stock.dto.TiingoCandle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.client.RestTemplate;

public class TiingoService implements StockQuotesService {

    private RestTemplate restTemplate;

    public TiingoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Candle> getStockQuote(String symbol, LocalDate from, LocalDate to) throws JsonProcessingException {
        String url = createUrl(symbol, from, to);
        String response = restTemplate.getForObject(url, String.class);
        TiingoCandle[] candles = new ObjectMapper()
                                   .registerModule(new JavaTimeModule())
                                   .readValue(response, TiingoCandle[].class);
        return Arrays.asList(candles);
    }

    private String createUrl(String symbol, LocalDate startDate, LocalDate endDate) {
        String token = "8a3f3d575c34407725517e744b86504fe2d0a6b9"; 
        return String.format("https://api.tiingo.com/tiingo/daily/%s/prices?startDate=%s&endDate=%s&token=%s",
                symbol, startDate.toString(), endDate.toString(), token);
    }
}
