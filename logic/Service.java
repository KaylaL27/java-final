package logic;

import java.util.Scanner;
import money.*;

public class Service{
    private Budget budget;
    private Scanner scanner;

    public Service(){
        this.budget = new Budget();
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        int choice;
        do{
            System.out.println("\n=== Budget Buddy ===");
            System.out.println("1. Set Monthly Income");
            System.out.println("2. Set Savings Goal");
            System.out.println("3. Add Expense");
            System.out.println("4. Add Income");
            System.out.println("5. View Budget Summary");
            System.out.println("6. Exit");
            System.out.println("Choose an option: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
            case 1:
                setIncome();
                break;
            case 2: 
                setSavingsGoal();
                break;
            case 3:
                addExpense();
                break;
            case 4:
                addIncome();
                break;
            case 5:
                viewSummary();
                break;
            case 6:
                System.out.println("Goodbye! Enjoy saving!");
                break;
            default:
                System.out.println("Invalid choice.");
            }
        
        }   while (choice!=6);
    }

    private void setIncome(){
        System.out.print("Enter your monthly income: $");
        double income = Double.parseDouble(scanner.nextLine());
        budget.setIncome(income);
        System.out.println("Income set successfully.");
    }

    private void setSavingsGoal(){
        System.out.print("Enter your savings goal: $");
        double goal = Double.parseDouble(scanner.nextLine());
        budget.setGoal(goal);
        System.out.println("Saving goal set successfully.");
    }

    private void addExpense(){
        System.out.print("Enter expense amount: $");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter category (e.g. Food, Rent, etc.): ");
        String category = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Expenses expense = new Expenses (amount, category, description);
        budget.addTransactions(expense);
        System.out.println("Expense added.");
    }

    private void addIncome(){
        System.out.print("Enter income amount: $");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter source (e.g. Job, Gift, etc.): ");
        String category = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Income income = new Income(amount, category, description);
        budget.addTransactions(income);
        System.out.println("Income added");
    }

    private void viewSummary(){
        System.out.println("\n=== Budget Summary ===");
        System.out.println("Income: $" + budget.getIncome());
        System.out.println("Savings Goal: $" + budget.getGoal());
        System.out.println("Total Expenses: $" + budget.getTotalExpenses());
        System.out.println("Additional Income: $" + budget.getAdditionalIncome());
        System.out.println("Remaining Budget: $" + budget.getRemainingBudget());
        System.out.println("Recommended Daily Budget: $" + String.format("%.2f", budget.getDailyBudget()));
    }
}