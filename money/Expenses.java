package money;

public class Expenses extends Transactions {
    public Expenses (double amount, String category, String description){
        super(amount, category, description);
    }
    @Override 
    public String getType(){
        return "Expense";
    }
}
