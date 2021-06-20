
public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount myBankAccount = new BankAccount();
		System.out.println(myBankAccount.getCheckingBalance());
		System.out.println(myBankAccount.getSavingsBalance());
		
		myBankAccount.deposit(98734.38, "Savings");
		myBankAccount.deposit(1.00, "Checking");
		System.out.println(myBankAccount.getCheckingBalance());
		System.out.println(myBankAccount.getSavingsBalance());
		
		myBankAccount.withdraw(2.00, "Checking");
		myBankAccount.withdraw(100, "Savings");
		System.out.println(myBankAccount.getCheckingBalance());
		System.out.println(myBankAccount.getSavingsBalance());
		
		myBankAccount.viewMoney();

	}

}
