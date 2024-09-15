package com.bankservice;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService(endpointInterface = "com.bankservice.BankService")
public class BankServiceImpl implements BankService {
    private Map<String, Double> accounts = new HashMap<>();

    public BankServiceImpl() {
        // Initialiser quelques comptes pour le test
        accounts.put("123456", 1000.0);
        accounts.put("789012", 2000.0);
    }

    @Override
    public double getBalance(String accountNumber) {
        return accounts.getOrDefault(accountNumber, 0.0);
    }

    @Override
    public boolean deposit(String accountNumber, double amount) {
        if (amount <= 0) return false;
        accounts.put(accountNumber, getBalance(accountNumber) + amount);
        return true;
    }

    @Override
    public boolean withdraw(String accountNumber, double amount) {
        if (amount <= 0) return false;
        double currentBalance = getBalance(accountNumber);
        if (currentBalance < amount) return false;
        accounts.put(accountNumber, currentBalance - amount);
        return true;
    }
}