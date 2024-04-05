package com.dev.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction{
    private final String transactionId;
    private final String Discription;
    private final double amount;

    public Transaction(String transactionId, String discription, double amount) {
        this.transactionId = transactionId;
        Discription = discription;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getDiscription() {
        return Discription;
    }

    public double getAmount() {
        return amount;
    }
}

public class TransactionReader {
    public static void main(String[] args) {


    }

    private static List<Transaction> readTransactionFromCsv(String filepath) throws IOException {
        return Files.lines(Paths.get(filepath))
                .skip(1)
                .map(line->{
                    String [] parts = line.split(", ");
                    return new Transaction(parts[0], parts[1], Double.parseDouble(parts[2]));
                })
                .collect(Collectors.toList());
    }

    private static Map<String, List<Transaction>> groupTransactionByTransactionId(List<Transaction> transactions){
        return transactions.stream().collect(Collectors.groupingBy(Transaction::getTransactionId));

    }
}
