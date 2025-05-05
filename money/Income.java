package money;

// This is an Income transaction, a child of Transactions
public class Income extends Transactions{

    // Constructor for an Income, calls the parent Transactions constructor
    public Income(double amount, String category, String description){
        super(amount, category, description);
    }

    // Returns the type of this transaction
    @Override
    public String getType(){
        return "Income";
    }
}
