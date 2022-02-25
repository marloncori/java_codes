package org.millenium.functional;

import org.millenium.functional.async.Async;
import org.millenium.functional.react.React;
import org.millenium.functional.stockserver.StockServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FunctionalApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(FunctionalApplication.class);

	private static final StockServer stockServer = new StockServer();

	public static void main(String[] args) {
		SpringApplication.run(FunctionalApplication.class, args);
	}

	@Override
	public void run(String...args) {
		try {
			Async promise = new Async();
			promise.start();
			Thread.sleep(1000);
			React reactive = new React(stockServer);
			reactive.stocks();
			Thread.sleep(1000);
			reactive.init();
			Thread.sleep(1000);
			promise.compute();
			Thread.sleep(1000);
		}catch(Throwable throwable){
				logger.info(throwable.getMessage() + " - " + throwable.getCause());
		}
	}

}
