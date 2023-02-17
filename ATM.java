package assigment2;
import java.util.Arrays;
import java.util.Scanner;

public class ATM {
	public static void main(String []args) {
		//Create an ATM object
		ATM atmObject = new ATM();

		//Create an account array to hold 9 elements
		Account[] arrId = new Account[9];
		int id = 0;

		//Fill the array with id 0 so it can later be accessed and writen over
		for(int i = 0; i<arrId.length; i++) {
			arrId[i] = new Account();
			arrId[i].setId(id);
		}		

		//Use the atm object to access the menu method, and pass the array and the object
		atmObject.menu(arrId, atmObject);	

		//End of main method

	}

	//Menu method
	public void menu(Account[] arrId, ATM atmObject) {
		//Scanner object
		Scanner input = new Scanner(System.in);

		//Menu options
		System.out.println("-------------------");
		System.out.println("Main Menu");
		System.out.println("-------------------");
		System.out.println("1. Create Account");
		System.out.println("2. Account Info");
		System.out.println("3. Withdraw");
		System.out.println("4. Deposit");
		System.out.println("5. Exit");
		System.out.println(" ");

		System.out.print("Please choose what you'd like to do: ");
		int choice = input.nextInt();

		//Switch statement based on what the user inputs
		switch(choice) {
		case 1:			
			atmObject.createAccount(input, arrId, atmObject);
			break;
		case 2:
			atmObject.accountInfo(input, arrId, atmObject);
			break;
		case 3:
			atmObject.withdrawal(input, arrId, atmObject);
			break;
		case 4:
			atmObject.deposits(input, arrId, atmObject);
			break;
		case 5:
			System.out.println("Thank you");
			System.exit(0);
		}


	}

	//Method to create an account 
	public void createAccount(Scanner input, Account[] arrId, ATM atmObject) {
		double initialBalance;
		int accountType;

		System.out.println(" ");
		System.out.println("---------------");
		System.out.println("Create Account");
		System.out.println("---------------");
		System.out.print("Enter ID: ");
		int id = input.nextInt();

		//Loop through arrId to see if id already exists
		for(int i = 0; i<arrId.length; i++) {

			//Loops until the user enters an ID that does'nt exist
			while(arrId[i] != null && arrId[i].getId() == id) {
				System.out.print("Please enter another ID: ");
				id = input.nextInt();	
			}

			//If users wanted Id doesn't exist and arrid[i] = 0, add to the array
			if(arrId[i].getId() != id && arrId[i].getId() == 0 && arrId[i].getBalance() == 0 && arrId[i].getAccountType() == 0) {
				System.out.print("Enter your initial balance: ");
				initialBalance = input.nextDouble();
				arrId[i] = new Account();				
				arrId[i].setId(id);
				arrId[i+1].setBalance(initialBalance);
				System.out.print("Enter the type of account you want: (1=Savings/2=Chequings): ");
				accountType = input.nextInt();	

				if(accountType == 1) {
					arrId[i+2].setAccountType(1);
				}
				else if(accountType == 2) {
					arrId[i+2].setAccountType(2);
				}

				break;

			}				

			//End of for loop
		}
		
		//Go back to the menu method
		menu(arrId, atmObject);
		
		//End of creatAccount method
	}

	//Account info method
	public void accountInfo(Scanner input, Account[] arrId, ATM atmObject) {
		int id; 
		System.out.print("Enter your Id: ");
		id = input.nextInt();

		//Login to the account
		for(int i = 0; i<arrId.length; i++) {
			if(arrId[i].getId() == id) {
				System.out.println("");
				System.out.println("-------------");
				System.out.println("Account Info");
				System.out.println("-------------");
				System.out.println("Account Id: " +id);
				System.out.println("Balance: " +arrId[i+1].getBalance());
				System.out.print("Account Type: ");	

				if(arrId[i+2].getAccountType() == 1) {
					System.out.println("Savings");					
				}

				else if(arrId[i+2].getAccountType() == 2) {
					System.out.println("Chequings");					
				}

				System.out.print("Annual Interest Rate: ");

				if(arrId[i+2].getAccountType() == 1) {					
					SavingsAccount sa = new SavingsAccount(id, arrId[i+1].getBalance());
					System.out.println(sa.annualInterestRate() +"%");
				}

				else if(arrId[i+2].getAccountType() == 2) {					
					ChequingAccount ca = new ChequingAccount(id, arrId[i+1].getBalance());
					System.out.println(ca.annualInterestRate()+"%");
				}				
				System.out.println(" ");
				break;
			}

			//End of for loop
		}
		
		//Go back to the menu method
		menu(arrId, atmObject);

	}

	//Withdraw method
	public void withdrawal(Scanner input, Account[] arrId, ATM atmObject) {
		int id;
		double withdrawAmount;
		double currentAmount;
		double newAmount;

		System.out.print("Please enter your ID: ");
		id = input.nextInt();

		//Find the users id
		for(int i = 0; i<arrId.length; i++) {

			//If user id matches an array element
			if(arrId[i].getId() == id) {
				System.out.print("Enter the amount you'd like to withdraw: ");
				withdrawAmount = input.nextDouble();
				//Save the balance in the array to currentAmount
				currentAmount = arrId[i+1].getBalance();

				//If account type is 1(Savings)
				if(arrId[i+2].getAccountType() == 1) {
					SavingsAccount sa = new SavingsAccount(id, currentAmount);					
					newAmount = sa.withdraw(withdrawAmount);
					arrId[i+1].setBalance(newAmount);
					System.out.println("Withdraw successful! new amount: $" +newAmount);
				}

				//If account type is 2(Chequings)
				else if(arrId[i+2].getAccountType() == 2) {
					ChequingAccount ca = new ChequingAccount(id, currentAmount);
					newAmount = ca.withdraw(withdrawAmount);

					//If user doesn't have enough money to make the withdraw
					if(newAmount == 989898989) {
						System.out.println("Not enough in your account to withdraw $" +withdrawAmount);
					}
					else {
						arrId[i+1].setBalance(newAmount);
						System.out.println("Withdraw successful! new amount: $" +newAmount);
					}
				}
			}

			//End of for loop
		}
		
		//Go back to the menu method
		menu(arrId, atmObject);

		//End of withdrawal method
	}

	//Deposit method
	public void deposits(Scanner input, Account[] arrId, ATM atmObject) {
		int id;
		double depositAmount;
		double newAmount;

		System.out.print("Please enter your Id: ");
		id = input.nextInt();

		for(int i = 0; i<arrId.length; i++) {

			if(arrId[i].getId() == id) {
				System.out.print("Enter the amount you'd like to deposit: ");
				depositAmount = input.nextDouble();	
				
				double currentAmount = arrId[i+1].getBalance();

				//Create account object
				Account account = new Account(id, currentAmount);

				System.out.println("Deposit amount: " +depositAmount);
				//Use account to access the deposit method and save sum in newAmount
				newAmount = account.deposit(depositAmount);
				System.out.println("New amount is: " +newAmount);
				//Save the newAmount to the array
				arrId[i+1].setBalance(newAmount);
			}
		}

		//Go back to the menu method
		menu(arrId, atmObject);

		//End of deposits method
	}


	//End of ATM class
}
