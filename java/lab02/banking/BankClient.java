
class BankClient
{
    private String name, id;
    private double balance;

    BankClient(String name, String id, double balance)
    {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    void deleteAccount()
    {
        this.name = this.id = null;
        this.balance = 0.0;
    }

    void deposite(double amount)
    {
        balance += amount;
    }

    boolean withdraw(double amount)
    {
        if(amount <= balance)
        {
            balance -= amount;
            return true;
        }
        return false;
    }

    double checkBalance()
    {
        return balance;
    }

    boolean transferTo(BankClient client, double amount)
    {
        if(withdraw(amount)){
            client.deposite(amount);
            return true;
        }
        return false;
    }

    String getName()
    {
        return name;
    }

    String getId()
    {
        return id;
    }
}

class Main
{
    public static void main(String []args)
    {
        BankClient client1 = new BankClient("Sami", "30001201201204", 1000.0);
        BankClient client2 = new BankClient("Sami", "30001201201205", 1000.0);

        System.out.println("Client 1 initial balance = " + client1.checkBalance());
        System.out.println("Client 2 inital balance = " + client1.checkBalance());
        
        System.out.println("For client 1");
        System.out.println("depositing...");
        client1.deposite(2000);
        System.out.println("Balance = " + client1.checkBalance());
        
        System.out.println("withdrawing...");
        if(client1.withdraw(1500))
            System.out.println("Balance = " + client1.checkBalance());
        else
            System.out.println("Invalid Operation");

        System.out.println("Transferring to client 2...");
        if(client1.transferTo(client2, 1000))
            System.out.println("Balance = " + client1.checkBalance());
        else
            System.out.println("Invalid Operation");


        System.out.println("For client 2");
        System.out.println("Balance = " + client2.checkBalance());
    }
}