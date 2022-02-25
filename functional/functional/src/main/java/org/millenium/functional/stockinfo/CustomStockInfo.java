package org.millenium.functional.stockinfo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CustomStockInfo {

        public static String ticker;
        public static Double value;

    public static void setTicker(String ticker) {
        CustomStockInfo.ticker = ticker;
    }

    public static void setValue(Double value) {
        CustomStockInfo.value = value;
    }

    public String getTicker() {
        return ticker;
    }

    public Double getValue() {
        return value;
    }

        public static CustomStockInfo fetch(String ticker) {
            if(Math.random() > 0.9) throw new RuntimeException("\033[1;32m BOOOM! We have ran into trouble! \033[0m");
            double randValue = new Random().nextDouble();
            CustomStockInfo stockInfo = new CustomStockInfo();
            stockInfo.setTicker(ticker);
            stockInfo.setValue(randValue);
            return stockInfo;
        }

        public String toString() {
            return String.format("\033[1;35m >>>>>> %s\033[0m: \033[1;35m%f\033[0m", ticker, value);
        }
}

