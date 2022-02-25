package org.millenium.functional.stockserver;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import org.millenium.functional.stockinfo.CustomStockInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class StockServer {

        private static final Logger logger = LoggerFactory.getLogger(StockServer.class);
        private static final CustomStockInfo stockInfo = new CustomStockInfo();

        public Observable<CustomStockInfo> getFeed(List<String> shares){
            logger.info("%%%%%% created... %%%%%");
            return Observable.create(emitter -> sendPrice(emitter, shares));
        }

        public StockServer(){
            stockInfo.setTicker("APPLE");
            stockInfo.setValue(78.894984);
        }

        private static void sendPrice(ObservableEmitter<CustomStockInfo> emitter, List<String> symbols) {
            int counter = 0;
            while(counter <= 20) {
                float data = new Random().nextFloat();
                logger.info("\033[1;31m |||||||||| emitting inital data: \033[0m \033[1;32m" + Math.floor(data) + "\033[0m\033[1;31m......\033[0m");
                for (String ticker : symbols) {
                    CustomStockInfo fetch = stockInfo.fetch(ticker);
                    emitter.onNext(fetch);
                }
                wait(1000);
                logger.info("\033[1;31m  ...sending more data: \033[0m \033[1;32m" + Math.floor(data) + "\033[0m\033[1;31m. ||||||||||\033[0m");
                logger.info(" [ counter = " + counter + " ]");
                emitter.onNext(stockInfo);
                counter++;
            }
        }

        private static void wait(int ms){
            try {
                Thread.sleep(ms);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
}

