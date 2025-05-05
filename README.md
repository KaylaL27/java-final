# 💰 Budget Buddy 💰

**Budget Buddy** is a simple, text-based budgeting tool built in Java that helps users manage their income, track expenses, and stay on target with savings goals.

---

## 🌟 Features 🌟

- Set monthly income and savings goal
- Add expense and income transactions with descriptions & categories
- View a full budget summary with:
  - Total income and expenses
  - Remaining budget
  - Recommended daily budget
- View all transactions with type, amount, category, and description

---

## ✨ OOP Concepts Demonstrated ✨

| Principle       | How It’s Used                                                                 |
|------------------|------------------------------------------------------------------------------|
| **Classes & Objects** | Main classes include `Budget`, `Income`, `Expenses`, `Transactions`, and `Service`. Objects are created for each. |
| **Encapsulation**     | Private fields with public getters/setters in `Budget` ensure data protection.          |
| **Inheritance**       | `Income` and `Expenses` inherit from the `Transactions` abstract class.               |
| **Polymorphism**      | All transactions are stored as `Transactions`. `getType()` is overridden and called polymorphically. |
| **Abstraction**       | `Transactions` is an abstract class that defines a shared interface for child classes. |

