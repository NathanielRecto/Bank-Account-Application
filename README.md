# Bank Account Application
## Instruction
The Bank Account Application project is a graphical user interface (GUI) based application developed using JavaFX. The application supports two types of users: Manager and Customer. Customers can manage their bank accounts, while the manager oversees account management and user operations.
## Features
- **Customer Operations:**
  - **Login/Logout:** Authenticate and manager user sessions.
  - **Deposit/Withdraw:** Add or withdraw money from the account.
  - **Get Balance:** Check the current balance.
  - **Online Purchase:** Perform online transactions with varying fees based on account level.
- **Manager Operations:**
  - **Login/Logout:** Authenticate and manage user sessions.
  - **Add/Delete Customer:** Create or remove customer accounts, with associated bank accounts.
 ## Account Levels
 - **Silver:** Balance < $10,000
 - **Gold:** $10,000 ≤ Balance < $20,000
 - **Platinum:** Balance ≥ $20,000
## Fees for Online Purchases:
- **Silver:** $20 fee + purchase amount
- **Gold:** $10 fee + purchase amount
- **Platinum:** No fee
## UML Diagrams
Develop UML diagrams using Violet UML Editor:
### Use-Case Diagram:
![case](https://github.com/user-attachments/assets/5430bd84-8ce8-4efd-94ef-3bc0c20462b1)
### Class Diagram:
![class](https://github.com/user-attachments/assets/8b23ee42-d47a-4aaa-b42c-d6b2e88edf1e)
## State Design Pattern
The application employs the State Design Pattern to manage customer account levels. Concrete state classes (e.g., Silver, Gold, Platinum) handle the transitions and behaviors associated with each account level. This design pattern ensures that level transitions are encapsulated and managed efficiently.
## Conclusion
The Bank Account Application successfully demonstrates a practical implementation of a GUI-based system for managing bank accounts. By integrating JavaFX for the graphical interface and employing the State Design Pattern for managing customer account levels, the application provides a user-friendly and efficient solution for both customers and managers. The application meets the specified requirements, including account management functionalities, fee structures based on account levels, and secure user authentication. Overall, this project demonstrates the ability to design and implement a functional banking application, with a focus on user experience and maintainability.
