import analyzer.TransactionAnalyzer;
import reader.OpenCsvTransactionReader;
import reader.TransactionReader;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.DoubleSummaryStatistics;

public class Executor {
    public static void main(String[] args) throws ParseException, IOException {

        var fileName = "./src/main/resources/test.csv";

        var parser = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        var fromDate = parser.parse("20/08/2018 12:00:00");
        var toDate = parser.parse("20/08/2018 13:00:00");

        var merchant = "Kwik-E-Mart";

        DoubleSummaryStatistics statistics;

        try(TransactionReader reader = new OpenCsvTransactionReader(fileName)) {
            statistics = TransactionAnalyzer.getTransactionsStatisticsFromStream(
                    reader.getTransactionsStream(),
                    merchant,
                    fromDate,
                    toDate);
        }

        System.out.printf("Number of transactions = %d \nAverage Transaction Value = %.2f",
                statistics.getCount(),
                statistics.getAverage());
    }
}
