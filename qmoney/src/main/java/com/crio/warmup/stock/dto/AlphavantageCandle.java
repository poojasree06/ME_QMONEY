package com.crio.warmup.stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlphavantageCandle implements Candle {

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("1. open")
    private Double open;

    @JsonProperty("2. high")
    private Double high;

    @JsonProperty("3. low")
    private Double low;

    @JsonProperty("4. close")
    private Double close;

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public Double getOpen() {
        return open;
    }

    @Override
    public Double getClose() {
        return close;
    }

    @Override
    public Double getHigh() {
        return high;
    }

    @Override
    public Double getLow() {
        return low;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public void setLow(Double low) {
        this.low = low;
    }
}
