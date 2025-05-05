package money;

// Abstract class that has basic financial transactions
public abstract class Transactions {
    // Common attributes shared by all transactions
    // Let's protect these attr for privacy but can still use when extended
    protected double amount;
    protected String category;
    protected String description;

    // Constructor that initializes data
    public Transactions(double amount, String category, String description){
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    // Amount getter
    public double getAmount() {
        return amount;
    }

    // Category getter
    public String getCategory() {
        return category;
    }

    // Description getter
    public String getDescription() {
        return description;
    }

    // Abstract method meant to be overwritten
    // Abstract method to be implemented by subclasses (Income or Expenses)
    // This distinguishes the type of transaction
    public abstract String getType();
}