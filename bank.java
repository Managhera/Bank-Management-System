import java.util.Scanner;
// User class-Encapsulation 
class User {
    String username;
    String password;
    String email;
    double balance;

    // para.. Constructor
    User(String username, String password, String email) 
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = 0.0; 
    }
}

class bank {

    User[] users = new User[20];
    int countOfuser = 0, i;

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) 
    {
        bank obj = new bank(); // Create object to use instance methods
        obj.getdata();
    }

    // method of get data
    void getdata() {
        while (true) {
            System.out.println("Enter your choice For Bank Management \n 1. Register \n 2. Login \n 3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Logout Successful");
                    return; // exit the loop
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

 // method of register
void registerUser() {
    System.out.print("Enter username: ");
    String username = sc.nextLine().trim();

    System.out.print("Enter Email: ");
    String email = sc.nextLine().trim();

    System.out.print("Enter password: ");
    String password = sc.nextLine().trim();

    // Call validate method
    if (!validate(username, password, email)) {
        return; // Stop if invalid
    }

    // If all are valid → register user
    users[countOfuser] = new User(username, password, email);
    countOfuser++;

    System.out.println(" Registration successful!");
}

// Validation Method
boolean validate(String username, String password, String email) {
    boolean isValid = true;

    if (username == null || username.length() < 3) {
        System.out.println(" Username must be 3 characters.");
        isValid = false;
    }

    if (password == null || password.length() < 8) {
        System.out.println(" Password must be 8 characters.");
        isValid = false;
    }

    if (email == null || email.length() < 5 || !email.contains("@") || !email.contains(".")) {
        System.out.println("Invalid email format.");
        isValid = false;
    }

    return isValid; // true if no errors, false if any error found
}


    // method of login
    void loginUser() {
        boolean logged_in = false;

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        for (i = 0; i < countOfuser; i++) {
            if (users[i].username.equals(username) && users[i].password.equals(password)) {
                logged_in = true;
                System.out.println(" Login successful!");
                balance(); // call balance deposit and withdraw
                break;
            }
        }

        if (!logged_in) {
            System.out.println("Login failed.");
        }
    }

    // method for balance
    void balance() {
        System.out.println("1. Deposit  2. Withdraw");
        int option = sc.nextInt();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        if (amount < 0) 
        {
            System.out.println(" Enter Correct Amount");
        } 
        else 
        {
            if (option == 1) 
            {
                users[i].balance = users[i].balance + amount;
                System.out.println(" Deposit Amount is = " + amount);
            } 
            else if (option == 2) 
            {
                if (amount <= users[i].balance) 
                {
                    users[i].balance = users[i].balance - amount;
                    System.out.println("Withdraw Amount is = " + amount);
                } 
                else 
                {
                    System.out.println(" Current balance is Low!");
                }
            } 
            else 
            {
                System.out.println(" Invalid transaction");
            }
        }

        System.out.println(" Current Balance is : " + users[i].balance);
    }
}
    