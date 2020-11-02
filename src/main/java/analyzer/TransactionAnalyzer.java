package analyzer;

import transaction.Transaction;
import transaction.TransactionType;

import java.util.*;
import java.util.stream.Stream;

public class TransactionAnalyzer {
    public static DoubleSummaryStatistics getTransactionsStatisticsFromStream(
            Stream<Transaction> transactionStream, String merchant, Date fromDate, Date toDate) {

        Map<String, Transaction> transactionMap = new HashMap<>();

        transactionStream
                .filter(transaction -> transaction.getMerchant().contains(merchant))
                .filter(transaction -> transaction.getDate().after(fromDate))
                .filter(transaction ->
                        (transaction.getDate().before(toDate) && transaction.getType().equals(TransactionType.PAYMENT)) ||
                                (transaction.getType().equals(TransactionType.REVERSAL)))
                .forEach(transaction -> {
                    switch (transaction.getType()) {
                        case PAYMENT -> transactionMap.put(transaction.getId(), transaction);
                        case REVERSAL -> transactionMap.remove(transaction.getRelatedTransaction());
                    }
                });

        return transactionMap.values().stream()
                    .mapToDouble(Transaction::getAmount)
                    .summaryStatistics();
    }
}
