class BankAccount
{
    String userName, passwd;
    boolean authenticated;
    double balance;

    BankAccount(String userName, String passwd)
    {
        this.userName = userName;
        this.passwd = passwd;
        this.authenticated = false;
    }

    synchronized boolean login(String userName, String passwd)
    {
        if(this.userName==userName && this.passwd==passwd)
        {
            authenticated = true;
            return true; // authenticated
        }
        return false;
    }
    
    synchronized boolean deposit(double amount)
    {
        if(authenticated) 
        {
            balance += amount;
            return true;
        }
        return false;
    }

    synchronized boolean withdraw(double amount)
    {
        if(authenticated && amount<=balance)
        {
            balance -= amount;
            return true;
        }
        return false;
    }

    synchronized boolean transferTo(BankAccount acconut, double amount)
    {
        if(authenticated && acconut.authenticated)
        {
            acconut.deposit(amount);
            this.withdraw(amount);
            return true;
        }
        return false;
    }

    synchronized double checkBalance()
    {
        if(authenticated)
            return balance;
        return -1;
    }

    synchronized void displayInfo()
    {
        System.out.printf("User Name: %s, Current Balance: %0.2f\n", userName, balance);
    }

    synchronized void logout()
    {
        authenticated = false;
    }
}

public class MyBankAccount 
{
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John", "1234");
        account.login("John", "1234");
        account.deposit(500.0);

        Thread balanceThread = new Thread(() -> {
            double balance = account.checkBalance();
            if (balance >= 0.0) {
                System.out.printf("[Thread] Current Balance: %.2f\n", balance);
            } else {
                System.out.println("[Thread] Access Denied: User not authenticated.");
            }
        });

        System.out.println("Before the balance thread");
        balanceThread.start();
        System.out.println("After the balance thread");
    }
}