public class BankAccount {

	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	public static int numberOfAccounts = 0;
	public static int totalMoney = 0;
	
	/**
	 * Other fields are default 0
	 */
	public BankAccount() {
		accountNumber = this.generateAccountNum();
		numberOfAccounts++;
	}
	
	private String generateAccountNum() {
		return Long.toString((long) Math.floor(Math.random() * 9000000000L) + 1000000000L);

	}
	
	public double getCheckingBalance() {
		return checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

    /**
     * Deposit
     * @param args
     */
	public void deposit(double amount, String type) {
		if (type.equals("Savings")) {
			savingsBalance += amount;
		} else if (type.equals("Checking")) {
			checkingBalance += amount;
		} else {
			System.out.println("Wrong type specified");
			return;
		}
		totalMoney += amount;
		
	}
	
	
	/**
	 * Withdraw, with protection for insufficient funds
	 * @param amount
	 * @param type
	 */
	public void withdraw(double amount, String type) {
		if (type.equals("Savings")) {
			if (savingsBalance < amount) {
				System.out.println("Insufficient funds");
				return;
			}
			savingsBalance -= amount;
		} else if (type.equals("Checking")) {
			if (checkingBalance < amount) {
				System.out.println("Insufficient funds");
				return;
			}
			checkingBalance -= amount;
		} else {
			System.out.println("Wrong type specified");
			return;
		}
		totalMoney -= amount;
		
	}

	/**
	 * 	Create a method to see the total money from the checking and saving.
	 */
	public void viewMoney() {
		System.out.println("Total money from checking and saving is: " + (savingsBalance + checkingBalance));
	}


}
