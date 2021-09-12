public class BankAccountTest {
    public static void main (String[] args) {
        BankAccount customer1 = new BankAccount();
        customer1.deposit("checking", 500.50);
        customer1.deposit("checking", 200.25);
        customer1.withdraw("checking", 100);
        customer1.deposit("saving", 1000.75);
        customer1.withdraw("saving", 300);
        BankAccount.accountBalance();
        BankAccount.numberOfAccounts();

        BankAccount customer2 = new BankAccount();
        customer2.deposit("checking", 1200.99);
        customer2.deposit("checking", 150.06);
        customer2.withdraw("checking", 200.40);
        customer2.deposit("saving", 1800.88);
        customer2.withdraw("saving", 25);
        BankAccount.accountBalance();
        BankAccount.numberOfAccounts();
    }
    
}
