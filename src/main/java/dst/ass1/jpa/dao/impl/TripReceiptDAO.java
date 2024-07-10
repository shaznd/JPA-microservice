package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.ITripReceiptDAO;
import dst.ass1.jpa.model.PaymentMethod;
import dst.ass1.jpa.util.TupleResult;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TripReceiptDAO implements ITripReceiptDAO {

    private EntityManager em;
    public TripReceiptDAO(EntityManager em)
    {
        this.em = em;
    }

    /**
     * Calculates the average tip per payment method within a given time range.
     * The result should be sorted descending by the average tip.
     *
     * @param start the start date of the time range, optional
     * @param end   the end date of the time range, optional
     */
    public class Transaction {
        private PaymentMethod paymentMethod;
        private double tip;
        private Date date;

        // getters
        public PaymentMethod getPaymentMethod() {
            return paymentMethod;
        }

        public double getTip() {
            return tip;
        }

        public Date getDate() {
            return date;
        }
    }







    @Override
    public List<TupleResult<PaymentMethod, Double>> calculateAverageTipPerPaymentMethod(Date start, Date end) {
        // Assuming you have a way to get the list of transactions
        List<Transaction> transactions = getTransactions();

        // Filter transactions by date range if dates are provided
        List<Transaction> filteredTransactions = transactions.stream()
                .filter(transaction -> (start == null || !transaction.getDate().before(start)) &&
                        (end == null || !transaction.getDate().after(end)))
                .collect(Collectors.toList());

        // Group transactions by payment method
        Map<PaymentMethod, List<Transaction>> transactionsByPaymentMethod = filteredTransactions.stream()
                .collect(Collectors.groupingBy(Transaction::getPaymentMethod));

        // Calculate the average tip for each payment method
        List<TupleResult<PaymentMethod, Double>> averageTips = transactionsByPaymentMethod.entrySet().stream()
                .map(entry -> {
                    PaymentMethod paymentMethod = entry.getKey();
                    List<Transaction> methodTransactions = entry.getValue();
                    double averageTip = methodTransactions.stream().mapToDouble(Transaction::getTip).average().orElse(0.0);
                    return new TupleResult<>(paymentMethod, averageTip);
                })
                .collect(Collectors.toList());

        // Sort the results by the average tip in descending order
        averageTips.sort((a, b) -> Double.compare(b.getSecond(), a.getSecond()));

        return averageTips;
    }

    // Dummy method to mimic fetching transactions
    private List<Transaction> getTransactions() {
        // This should return a list of transactions from your data source
        return new ArrayList<>();
    }

   // @Override
   // public List<TupleResult<PaymentMethod, Double>> calculateAverageTipPerPaymentMethod(Date start, Date end) {
   //     return null;
   // }
}
