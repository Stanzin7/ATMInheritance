package assigment2;

public class SavingsAccount extends Account{
	//SavingsAccount cannot be overdrawn and has a interest rate of 3% 
	
	public SavingsAccount() {}
	
	public SavingsAccount(int id, double balance) {
		super(id, balance);
	}
	
	@Override
	public double withdraw(double amount) {
		double newAmount;
		newAmount = this._balance - amount;		
	
		return newAmount;
	}
	
	public double annualInterestRate() {
		return this._annualInterestRate = 3;
	}
}
