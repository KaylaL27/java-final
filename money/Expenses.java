package money;

// This is an Expense transaction, a child of Transactions
public class Expenses extends Transactions {

    // Constructor for an expense, calls the parent Transactions constructor
    public Expenses(double amount, String category, String description){
        super(amount, category, description);
    }

    // Returns the type of this transaction
    @Override
    public String getType(){
        return "Expense";
    }
}
