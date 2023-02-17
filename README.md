# console-atm-inheritance
console-atm-inheritance is console based ATM machaine and a more complex version of [ConsoleATM](https://github.com/Tripl3R/ConsoleATM#consoleatm). This program has four classes, Account.java, SavingsAccount.java, ChequingAccount.java and lastly ATM.java. 

## Class Description
Account.java is the superclass that provides the ability for created accounts to create their IDs, set or access the balance, annual interest rate and their account type (savings or chequings).

SavingsAccount.java is one of the sublcasses of Account.java. This class cannot be overdrawn and has the interest rate of 3%. 

ChequingAccount.java is another subclass of Account.java that can be overdrawn of a limit $500 and has the interest rate of 1%.

ATM.java is the console interface the users will interact with to create an account, set a balance and preform any deposits or withdrawals. 

## Demonstration
In this demonstration, the first account created, 101 will have a savings account and the second account created, 102 will have a chequings account. 

### Account Creation
![101 Creation](https://github.com/Tripl3R/console-atm-inheritance/blob/master/pictures/createaccount1.PNG?raw=true)
![102 Creation](https://github.com/Tripl3R/console-atm-inheritance/blob/master/pictures/createaccount2.PNG?raw=true)

### Account Info 
![101 Account Info](https://github.com/Tripl3R/console-atm-inheritance/blob/master/pictures/accountInfo1.PNG?raw=true) ![102 Account Info](https://github.com/Tripl3R/console-atm-inheritance/blob/master/pictures/accountInfo2.PNG?raw=true)

### Withdraw
![101 Withdraw](https://github.com/Tripl3R/console-atm-inheritance/blob/master/pictures/withdraw1.PNG?raw=true) ![102 Withdraw](https://github.com/Tripl3R/console-atm-inheritance/blob/master/pictures/withdraw2.PNG?raw=true)

### Deposit
![101 Deposit](https://github.com/Tripl3R/console-atm-inheritance/blob/master/pictures/deposit1.PNG?raw=true) ![102 Deposit](https://github.com/Tripl3R/console-atm-inheritance/blob/master/pictures/deposit2.PNG?raw=true)

### End
![101 Deposit](https://github.com/Tripl3R/console-atm-inheritance/blob/master/pictures/end.PNG?raw=true)
