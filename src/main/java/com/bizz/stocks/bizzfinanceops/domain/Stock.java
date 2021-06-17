package com.bizz.stocks.bizzfinanceops.domain;

import java.util.Objects;

public class Stock {

    private final String symbol;
    private final StockType type;
    private final Double lastDividend;
    private final Double fixedDivided;
    private final Double parValue;
    private final Double tickerPrice;

    public Stock(String symbol,
                 StockType type,
                 double lastDividend,
                 double fixedDivided,
                 double parValue,
                 double tickerPrice) {
        /*checkArgument(isNotBlank(symbol), "stock symbol is mandatory");
        checkArgument(type != null, "stock type is mandatory");
        checkArgument(lastDividend >= 0.0, "last dividend should be >=0");
        checkArgument(fixedDivided >= 0.0 && fixedDivided <= 1.0, "fixed dividend should be between 0 and 1");
        checkArgument(parValue >= 0.0, "par value should be >=0");
        checkArgument(tickerPrice >= 0.0, "ticker price should be >=0");*/

        this.symbol = symbol;
        this.type = type;
        this.lastDividend = lastDividend;
        this.fixedDivided = fixedDivided;
        this.parValue = parValue;
        this.tickerPrice = tickerPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public StockType getType() {
        return type;
    }

    public Double getLastDividend() {
        return lastDividend;
    }

    public Double getFixedDividend() {
        return fixedDivided;
    }

    public Double getParValue() {
        return parValue;
    }

    public Double getTickerPrice() {
        return tickerPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stock stock = (Stock) o;
        // symbol uniquely identifies a stock
        return Objects.equals(symbol, stock.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol);
    }

    

    @Override
    public String toString() {
        return "Stock [fixedDivided=" + fixedDivided + ", lastDividend=" + lastDividend + ", parValue=" + parValue
                + ", symbol=" + symbol + ", tickerPrice=" + tickerPrice + ", type=" + type + "]";
    }

    public Double getDividendYield() {
        //checkArgument(tickerPrice != 0.0, "ticker price cannot be zero");

        if (type.equals(StockType.COMMON)) {
            return calculateCommonDividedYield(tickerPrice);
        }

        return calculatePreferredDividedYield(tickerPrice);
    }

    public Double getPERatio() {
        return tickerPrice / getDividendYield();
    }

    private Double calculatePreferredDividedYield(Double tickerPrice) {
        return getFixedDividend() / tickerPrice;
    }

    private Double calculateCommonDividedYield(Double tickerPrice) {
        return getLastDividend() / tickerPrice;
    }
}
