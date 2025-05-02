package money;

public abstract class Transactions {
    protected double amount;
    protected String category;
    protected String description;

    public Transactions(double amount, String category, String description){
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public abstract String getType();
}