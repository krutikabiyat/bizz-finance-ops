package com.bizz.stocks.bizzfinanceops.mapping;

import java.util.function.Function;

import com.bizz.stocks.bizzfinanceops.domain.Stock;
import com.bizz.stocks.bizzfinanceops.domain.StockType;
import com.bizz.stocks.bizzfinanceops.dto.StockDto;

import org.springframework.stereotype.Component;

/**
 * Converts a Stock DTO into a Stock from the internal domain.
 */
@Component
public class StockFromDtoConverter implements Function<StockDto, Stock> {
    @Override
    public Stock apply(StockDto stockDto) {
        String symbol = stockDto.getSymbol();
        StockType type = StockType.valueOf(stockDto.getType());
        double fixedDividend = stockDto.getFixedDividend();
        double lastDividend = stockDto.getLastDividend();
        double parValue = stockDto.getParValue();
        double tickerPrice = stockDto.getTickerPrice();

        return new Stock(symbol, type, lastDividend, fixedDividend, parValue, tickerPrice);
    }
}
