package com.crio.warmup.stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlphavantageDailyResponse {

    @JsonProperty("Time Series (Daily)")
    private Map<String, AlphavantageCandle> candles;

    public Map<String, AlphavantageCandle> getCandles() {
        return candles;
    }

    public void setCandles(Map<String, AlphavantageCandle> candles) {
        this.candles = candles;
    }
}
