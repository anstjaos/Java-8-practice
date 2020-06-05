import model.Transaction;
import service.TransactionService;
import service.impl.TransactionServiceImpl;

import java.util.List;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        TransactionService ts = new TransactionServiceImpl();

        Logger logger = Logger.getLogger(Main.class.getName());

        logger.info("1. 2011 오름차순 출력");
        List<Integer> values = ts.getTransactionsByAsc(2011);
        values.forEach(value -> logger.info(String.valueOf(value)));
        logger.info("=====================");

        logger.info("2. 도시 출력");
        List<String> cities = ts.getTradersCities();
        cities.forEach(logger::info);
        logger.info("=====================");

        logger.info("3. 거래자 이름 출력 캠브릿");
        List<String> traders = ts.getTradersNameByCity("Cambridge");
        traders.forEach(logger::info);
        logger.info("=====================");

        logger.info("4. 거래자 이름 알파벳");
        traders = ts.getOrderedTradersName();
        traders.forEach(logger::info);
        logger.info("=====================");

        logger.info("5. 밀라노 거래자");
        logger.info(String.valueOf(ts.isTradersExist("Milan")));
        logger.info("=====================");

        logger.info("6. 케임브리지 트랜잭션");
        values = ts.getTransactionValues("Cambridge");
        values.forEach(value -> logger.info(String.valueOf(value)));
        logger.info("=====================");

        logger.info("7. 최대값");
        logger.info(String.valueOf(ts.getMaxTransactionValue()));
        logger.info("=====================");

        logger.info("8. 최소값");
        logger.info(String.valueOf(ts.getMinTransactionValue()));
        logger.info("=====================");
    }
}
