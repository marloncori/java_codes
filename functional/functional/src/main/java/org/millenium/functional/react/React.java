package org.millenium.functional.react;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import org.millenium.functional.stockinfo.CustomStockInfo;
import org.millenium.functional.stockserver.StockServer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class React {

        private static final Logger logger = LoggerFactory.getLogger(React.class);

        private static final String errMsg = "\033[1;32m Something went wrong... Sorry...\033[0m";

        private static final String line = "=============================================";

        private CustomStockInfo customStockInfo = new CustomStockInfo();

        private StockServer stockServer;

    public React(StockServer stockServer) {
        this.stockServer = stockServer;
    }

    private static Double apply(Double d) {
        logger.info("\033[1;32m>>>>>>>> VALUE: " + d + "\033[0m");
        return d;
    }

    public void init(){                                                                //DROP
            Flowable.<Integer>create(emitter -> dataPipeline(emitter), BackpressureStrategy.BUFFER)
                    .observeOn(Schedulers.io(), true, 2)
                    .filter(d -> d % 2 == 0)
                    .map(d -> d * 2)
                    .subscribe(React::processData,
                            err -> logger.info
("ERROR: " + err),
                            () -> logger.info
("\033[1;33m\n\t :::: DONE! :::: \033[0m"));
            logger.info
("\t\033[1;35m Data has been received and successfully sent!\033[0m");
            wait(2000);
        }

        private static void dataPipeline(FlowableEmitter<Integer> sender){
            logger.info
("\033[1;34m >>> sending the requested data...\033[0m");
            int count = 0;
            while(++count < 20){
                sender.onNext(count);
                if(count > 20) throw new RuntimeException(errMsg);
                logger.info
("\033[1;33m >>> Data \033[0m\033[1;36m\'" + count + "\'\033[0m\033[1;33m has been sent! <<<\033[0m");
                wait(500);
            }
            //if there is no error
            sender.onComplete();
        }

        private Function<Double, Double> forward = (n) -> apply(n);

        private static void wait(int ms) {
            try{
                Thread.sleep(ms);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private static void processData(Integer data){
            logger.info
(line);
            logger.info
("\033[1;31m ---> [ " + data + " ] <---\033[0m");
            logger.info
(line);
            wait(500);
        }

        public void stocks() throws Throwable {
            List<String> symbols = Arrays.asList("GOOGLE", "AMAZON", "INTEL");
            Observable<CustomStockInfo> feed = stockServer.getFeed(symbols);
            logger.info
(line);
            logger.info
("\033[1;30m /////// Got observable! ////// \033[0m");

            feed
                    .filter(stockInfo -> stockInfo.getTicker() != null && stockInfo.getValue() > 500.0)
                    .map(stockInfo -> stockInfo.getValue() * 0.9)
                    .subscribe(stockInfo -> logger.info("\033[1;33m--------->>>>>>" + stockInfo + "\033[0m"),
                            err -> logger.error(err + " \n " + errMsg),
                            () -> logger.info (" :::: Successfully DOME! ::::"));

            wait(1000);
            forward.apply(customStockInfo.getValue());
        }

}
