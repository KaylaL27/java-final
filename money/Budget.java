package money;

import java.util.ArrayList;
import java.util.List;

// The Budget class stores and manages the user's income, goal, and transactions
public class Budget {
    // Let's encapsulate income, goal, and transactions for privacy
    private double income;
    private double goal;
    private List<Transactions> transactions;

    //make constructor with set transactions
    public Budget(){
        transactions = new ArrayList<>();
    }

    // Sets the user's monthly income
    public void setIncome(double income){
        this.income = income;
    }
    // Returns the user's monthly income
    public double getIncome(){
        return income;
    }

    // Sets the user's savings goal
    public void setGoal(double goal){
        this.goal = goal;
    }
    // Returns the user's savings goal
    public double getGoal(){
        return goal;
    }
    
    // TRANSACTIONS

    // Adds a transaction (either income or expense) to the list
    public void addTransactions(Transactions T){
        transactions.add(T);
    }

    // Returns all Transaction made
    public List<Transactions> getTransactions() {
        return transactions;
    }

    // Calculates and returns the total amount spent on expenses
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

    // Calculates and returns the total additional income
    public double getAdditionalIncome() {
        return transactions.stream()
            .filter(t -> t instanceof Income)
            .mapToDouble(Transactions::getAmount)
            .sum();
    }
    
    // Function to calculate and retunr Remaing Budget
    public double getRemainingBudget() {
        return (income + getAdditionalIncome()) - goal - getTotalExpenses();
    }

    // Function that returns recommended daily budget
    public double getDailyBudget() {
        return getRemainingBudget() / 30.0; // assuming 30 days in a month
    }
}
