package money;

public class Income extends Transactions {
    public Income (double amount, String category, String description){
        super (amount, category, description);
    }
    @Override
    public String getType(){
        return "Income";
    }
}