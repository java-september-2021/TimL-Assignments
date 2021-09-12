public class BankAccount {
    protected double checkingBalance = 0;
    protected double savingsBalance = 0;
    private static int numberOfAccounts = 0;
    private static double accountBalance = 0;

    public BankAccount() {
        numberOfAccounts ++;
    }

    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        numberOfAccounts ++;
    }

    public void getCheckingBalance() {
        System.out.println("Checking account balance: " + this.checkingBalance);
    }
    public void getSavingsBalance() {
        System.out.println("Savings account balance: " + this.savingsBalance);
    }

    public void deposit(String account, double amount){
        if(account.equals("checking")) {
            this.checkingBalance += amount;
            accountBalance += amount;
            System.out.println("Checking account balance: " + this.checkingBalance);
        } else if (account.equals("saving")){
            this.savingsBalance += amount;
            accountBalance += amount;
            System.out.println("Saving account balance: " + this.savingsBalance);
        } else{
            System.out.println("Enter account");
        }
    }

    public void withdraw(String account, double amount){
        if(account.equals("checking")) {
            if (this.checkingBalance > amount) {
            this.checkingBalance -= amount;
            accountBalance -= amount;
            System.out.println("Checking account balance: " + this.checkingBalance);
            } else {
                System.out.println("Insufficient fund.");
            }
        } else if (account.equals("saving")){
            if (this.savingsBalance > amount) {
            this.savingsBalance -= amount;
            accountBalance -= amount;
            System.out.println("Saving account balance: " + this.savingsBalance);
            } else {
                System.out.println("Insufficient fund.");
            }
        } else{
            System.out.println("Enter account");
        }
    }

    public static void accountBalance(){
        System.out.println("Total Balance: " + accountBalance);
    }
    public static void numberOfAccounts(){
        System.out.println("Total number of accounts: " + numberOfAccounts);
    }

}