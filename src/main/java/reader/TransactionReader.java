package reader;

import transaction.Transaction;

import java.io.Closeable;
import java.io.IOException;
import java.util.stream.Stream;

public interface TransactionReader extends Closeable {
    Stream<Transaction> getTransactionsStream() throws IOException;
}
