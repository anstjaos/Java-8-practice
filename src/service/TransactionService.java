package service;

import model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    public List<Integer> getTransactionsByAsc(int year);
    public List<String> getTradersCities();
    public List<String> getTradersNameByCity(String city);
    public List<String> getOrderedTradersName();
    public boolean isTradersExist(String city);
    public List<Integer> getTransactionValues(String city);
    public Optional<Integer> getMaxTransactionValue();
    public Optional<Integer> getMinTransactionValue();
}
