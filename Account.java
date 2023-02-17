package assigment2;

public class Account {
	//Fields
	protected String _customerName;
	protected int _id;
	protected double _balance;
	protected double _annualInterestRate;
	protected int _accountType;

	//No-arg constructor
	public Account() {}

	//Argument constructor
	public Account(int id, double balance) {
		this._id = id;
		this._balance = balance;
	}

	//getters and setters

	public String getCustomerName() {
		return _customerName;
	}

	public void setCustomerName(String _customerName) {
		this._customerName = _customerName;
	}

	public int getId() {
		return _id;
	}

	public void setId(int _id) {
		this._id = _id;
	}

	public double getBalance() {
		return _balance;
	}

	public void setBalance(double _balance) {
		this._balance = _balance;
	}

	public double getAnnualInterestRate() {
		return _annualInterestRate;
	}

	public void setAnnualInterestRate(double _annualInterestRate) {
		this._annualInterestRate = _annualInterestRate;
	}
	
	public void setAccountType(int type) {
		this._accountType = type;
	}
	
	public int getAccountType() {
		return _accountType;
	}

	//Methods 
	public double deposit(double amount) {
		return this._balance = this._balance + amount;
	}

	public double withdraw(double amount) {
		double newAmount = 0;
		if(this._balance> amount) {
			newAmount = this._balance -= amount;
		}		
		
		return newAmount;
	}

	public double monthlyInterest() {
		double newInterest;
		newInterest = this._balance * ((this._annualInterestRate/12)/100);
		return newInterest;
	}
	
	@Override
	public String toString() {
		return getId() +"" +getBalance() +"" +getAccountType();
	}

	//End of Account class
}
