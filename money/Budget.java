package money;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Budget {
    private double income;
    private double goal;
    private List<Transactions> transactions;

    //make constructor with set transactions
    public Budget(){
        transactions = new ArrayList<>();
    }

    //setter
    public void setIncome(double income){
        this.income = income;
    }
    //getter
    public double getIncome(){
        return income;
    }

    //setter
    public void setGoal(double goal){
        this.goal = goal;
    }
    //getter
    public double getGoal(){
        return goal;
    }
    
    public void addTransactions(Transactions T){
        transactions.add(T);
    }
    
    public double getTotalExpenses() {
        double total = 0.0;
        for (int i = 0; i < transactions.size(); i++) {
            Transactions t = transactions.get(i);
            if (t instanceof Expenses) {
                total += t.getAmount();
            }
        }
        return total;
    }

    public double getAdditionalIncome() {
        return transactions.stream()
            .filter(t -> t instanceof Income)
            .mapToDouble(Transactions::getAmount)
            .sum();
    }
    
    public double getRemainingBudget() {
        return (income + getAdditionalIncome()) - goal - getTotalExpenses();
    }

    public double getDailyBudget() {
        return getRemainingBudget() / 30.0; // assuming 30 days in a month
    }
}
