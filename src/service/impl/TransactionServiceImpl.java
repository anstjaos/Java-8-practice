package service.impl;

import model.Trader;
import model.Transaction;
import service.TransactionService;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class TransactionServiceImpl implements TransactionService {
    private List<Transaction> transactions;

    public TransactionServiceImpl() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    @Override
    public List<Integer> getTransactionsByAsc(int year) {
        return transactions.stream()
                .filter(transaction -> transaction.getYear() == year)
                .map(Transaction::getValue)
                .sorted()
                .collect(toList());

        // map과 sorted를 합치는게 좋다.
        // sorted(comparing(Transaction::getValue));
    }

    @Override
    public List<String> getTradersCities() {
        return transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(toList());

        // map을 두 번 쓰지말고 한 번만
        // map(transaction -> transaction.getTrader().getCity());
    }

    @Override
    public List<String> getTradersNameByCity(String city) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals(city))
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(toList());
        // sorted와 map 합치
    }

    @Override
    public List<String> getOrderedTradersName() {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .collect(toList());
    }

    @Override
    public boolean isTradersExist(String city) {
        return transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals(city));
    }

    @Override
    public List<Integer> getTransactionValues(String city) {
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals(city))
                .map(Transaction::getValue)
                .collect(toList());
        // 마지막에 forEach로 출력도 가능
    }

    @Override
    public Optional<Integer> getMaxTransactionValue() {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
    }

    @Override
    public Optional<Integer> getMinTransactionValue() {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
    }
}
