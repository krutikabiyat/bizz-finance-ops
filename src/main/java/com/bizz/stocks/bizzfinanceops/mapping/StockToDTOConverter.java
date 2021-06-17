package com.bizz.stocks.bizzfinanceops.mapping;

import java.util.function.Function;

import com.bizz.stocks.bizzfinanceops.domain.Stock;
import com.bizz.stocks.bizzfinanceops.dto.StockDto;
import org.springframework.stereotype.Component;

/**
 * Converts a Stock from the internal domain into a Stock DTO.
 */
@Component
public class StockToDTOConverter implements Function<Stock, StockDto> {
    @Override
    public StockDto apply(Stock stock) {
        StockDto stockDto = new StockDto();

        stockDto.setSymbol(stock.getSymbol());
        stockDto.setType(stock.getType().name());
        stockDto.setFixedDividend(stock.getFixedDividend());
        stockDto.setLastDividend(stock.getLastDividend());
        stockDto.setParValue(stock.getParValue());
        stockDto.setTickerPrice(stock.getTickerPrice());

        return stockDto;
    }
}
