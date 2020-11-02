package reader;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import transaction.Transaction;

import java.io.*;
import java.util.stream.Stream;

public class OpenCsvTransactionReader implements TransactionReader {

    private Reader reader;
    private String fileName;

    public OpenCsvTransactionReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Stream<Transaction> getTransactionsStream() throws IOException {
        reader = new BufferedReader(new FileReader(fileName));

        CsvToBean<Transaction> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Transaction.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

        return csvToBean.stream();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
