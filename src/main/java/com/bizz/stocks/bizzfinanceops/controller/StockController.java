package com.bizz.stocks.bizzfinanceops.controller;

import com.bizz.stocks.bizzfinanceops.domain.Stock;
import com.bizz.stocks.bizzfinanceops.domain.StockType;
import com.bizz.stocks.bizzfinanceops.mapping.StockToDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
    @RequestMapping("/")
    public String home() {
        return "<html><head></head><body>Hello World!<br><a href=\"/stocks?ticker=GE\">Go To Stocks</a><br><a href=\"/books?ticker=GE\">Go To Books</a></body></html>";
    }

    /**
     * /stocks?ticker=GE
     * 
     * @param ticker
     * @return
     */
    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    public Stock getStock(@RequestParam String ticker) {
        Stock stock = new Stock("GE", StockType.COMMON, 10.0, 2.0, 34.0, 5.5);
        return stock;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public Stock getBook(@RequestParam String ticker) {
        Stock stock = new Stock("Book", StockType.COMMON, 10.0, 2.0, 34.0, 5.5);
        return stock;
    }

}
