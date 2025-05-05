package logic;

import java.util.Scanner;
import money.*;

// The Service class handles
// budgeting logic and user interaction
public class Service{
    private Budget budget;   // Holds all budgeting data
    private Scanner scanner; // Scanner to read user input
    private String userName;      // Stores the name of the user for personalization

    // Constructor that initializes the budget and scanner
    public Service(){
        this.budget = new Budget();
        this.scanner = new Scanner(System.in);
    }

    // Runs the actually Budgeting service
    public void run(){
        System.out.println("\n=== $ Budget Buddy $ ===");

        // Let's ask user for their name
        System.out.print("Enter your name: ");
        userName = scanner.nextLine();
        System.out.println("Welcome, " + userName + "!");
        int choice;
        
        // Call function to set Income once
        setIncome();
        // Call function to set Goal once
        setSavingsGoal();
        do{
            // Output Menu
            System.out.println("\nChoose one of the following:");
            System.out.println("1. Add Expense");
            System.out.println("2. Add Income");
            System.out.println("3. View All Transactions");
            System.out.println("4. View Budget Summary");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");
            choice = Integer.parseInt(scanner.nextLine());

            // Run functions based on User input
            switch (choice){
            case 1:
                addExpense();
                break;
            case 2:
                addIncome();
                break;
            case 3:
                viewAllTransactions();
                break;
            case 4:
                viewSummary();
                break;
            case 5:
                System.out.println("Goodbye, " + userName + "! Enjoy saving!");
                break;
            default:
                System.out.println("Invalid choice.");
            }
        
        }   while (choice!=5);
        scanner.close();
    }

    // Ask user to add their income and save
    private void setIncome(){
        System.out.print("Enter your monthly income: $");
        double income = Double.parseDouble(scanner.nextLine());
        budget.setIncome(income); // use setter method from Budget
        System.out.println("Income set successfully.");
    }

    // Ask user to set their Saving Goal and save
    private void setSavingsGoal(){
        System.out.print("Enter your savings goal: $");
        double goal = Double.parseDouble(scanner.nextLine());
        budget.setGoal(goal); // use setter method from Budget
        System.out.println("Saving goal set successfully.");
    }

    // Allows users to add expense
    private void addExpense(){
        System.out.print("Enter expense amount: $");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter category (e.g. Food, Rent, etc.): ");
        String category = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        // Adds it to Expenses
        Expenses expense = new Expenses (amount, category, description);
        budget.addTransactions(expense);
        System.out.println("Expense added.");
    }

    // Allows user to add Additional Income
    private void addIncome(){
        System.out.print("Enter income amount: $");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter source (e.g. Job, Gift, etc.): ");
        String category = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        // Adds it to Income
        Income income = new Income(amount, category, description);
        budget.addTransactions(income);
        System.out.println("Income added");
    }

    // Allows user to view their Summary
    private void viewSummary(){
        System.out.println("\n=== Budget Summary ===");
        System.out.println("Income: $" + budget.getIncome());
        System.out.println("Savings Goal: $" + budget.getGoal());
        System.out.println("Total Expenses: $" + budget.getTotalExpenses());
        System.out.println("Additional Income: $" + budget.getAdditionalIncome());
        System.out.println("Remaining Budget: $" + budget.getRemainingBudget());
        System.out.println("Recommended Daily Budget: $" + String.format("%.2f", budget.getDailyBudget()));
    }

    // Allows user to view all their Transactions
    private void viewAllTransactions(){
        System.out.println("\n=== All Transactions ===");
        if (budget.getTransactions().isEmpty()) {
            System.out.println("No transactions recorded yet.");
            return;
        }

        for (Transactions t : budget.getTransactions()) {
            System.out.println(t.getType() + " | $" + t.getAmount() +
                " | Category: " + t.getCategory() +
                " | Description: " + t.getDescription());
        }
    }
}