package transaction;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.util.Date;

public class Transaction {

    @CsvBindByName
    private String id;

    @CsvBindByName
    @CsvDate("dd/MM/yyyy HH:mm:ss")
    private Date date;

    @CsvBindByName
    private double amount;

    @CsvBindByName
    private String merchant;

    @CsvBindByName
    private TransactionType type;

    @CsvBindByName(column = "Related Transaction")
    private String relatedTransaction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getRelatedTransaction() {
        return relatedTransaction;
    }

    public void setRelatedTransaction(String relatedTransaction) {
        this.relatedTransaction = relatedTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", merchant='" + merchant + '\'' +
                ", type=" + type +
                ", relatedTransaction='" + relatedTransaction + '\'' +
                '}';
    }
}
