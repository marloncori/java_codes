package org.millenium.functional.async;

import org.millenium.functional.react.React;
import org.millenium.functional.stockinfo.CustomStockInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
public class Async {

    private static final Logger logger = LoggerFactory.getLogger(Async.class);
    
    private  static CustomStockInfo stockInfo = new CustomStockInfo();

    private static final Float NUMBER = 7.4f;
    private static final Integer VALUE = 89;
    private Supplier<Integer> provide = () -> VALUE+78;
    private Function<Integer, CompletableFuture> convert = Async::apply;

    private static CompletableFuture apply(Integer n) {
        return CompletableFuture.completedFuture(n);
    }

    private CompletableFuture create(){
        CompletableFuture<Integer> future = new CompletableFuture<>();
                future.supplyAsync(provide);
                 wait(1000);
        return future.thenApply(convert);
    }

    private void calculate() {
        CompletableFuture.supplyAsync(() -> stockInfo.toString()).thenAccept(product -> {
            logger.info( " [MESSAGE FROM YET ANOTHER COMPLETABLE_FUTURE ]");
            logger.info("\033[1;31m >>>>> The detail about the new CustomStockInfo:\n\t" + stockInfo + "\033[0m");
        });
    }

    public CompletableFuture compute(){
            wait(1000);
            CompletableFuture<Integer> future = create();
            return future.thenApply(n -> n * 7).thenAccept(v -> logger.info("::::::: The CompletableFuture has \n yielded this value: " + v + " :::::"));
    }

    public void wait(int ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public Async(){
        stockInfo.setTicker("SONY");
        stockInfo.setValue(117.544984);
    }

    public void start(){
        wait(1000);
        compute();
        logger.info("\033[1;34m ====> After many computations that what \n we have get from the CompletableFuture: " + compute().complete(VALUE) + "! <<<====\033[0m");
        wait(1000);
        CompletableFuture<Float> newFuture = new CompletableFuture<>();
        newFuture.thenApply(n -> n * NUMBER)
                .thenApply(v -> NUMBER / v)
                .thenAccept(n -> logger.info("\033[1;34m :::: After new computations that is what we \n got from another CompletableFuture: \033[0m\033[1;32m" + n + "\033[0m \033[0m"))
                .thenAccept(a -> logger.info("\033[1;36m ::::::::: After EVEN MORE computations that is what we \n got from another CompletableFuture: \033[0m\033[1;32m" + a + "\033[1;36mand\033[0m \033[1;32m" + false + "\033[0m\033[0m"))
                .thenRun(() -> logger.info("++++++++++++++++++++  THE END!!! ++++++++++++++++++++"));
        wait(1000);
        calculate();
        wait(1000);
    }
}
