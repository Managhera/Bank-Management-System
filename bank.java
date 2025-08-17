import java.util.Scanner;

class bank {

    String[] usernames = new String[20];
    String[] passwords = new String[20];
    String[] emails = new String[20];
    double[] balances = new double[20];
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

    // If all are valid → register user
    usernames[countOfuser] = username;
    passwords[countOfuser] = password;
    emails[countOfuser] = email;
    balances[countOfuser] = 0.0;
    countOfuser++;

    System.out.println(" Registration successful!");
}

    // method of login
    void loginUser() {
        boolean logged_in = false;

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        for (i = 0; i < countOfuser; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
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
                balances[i] = balances[i] + amount;
                System.out.println(" Deposit Amount is = " + amount);
            } 
            else if (option == 2) 
            {
                if (amount <= balances[i]) 
                {
                    balances[i] = balances[i] - amount;
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

        System.out.println(" Current Balance is : " + balances[i]);
    }
}
