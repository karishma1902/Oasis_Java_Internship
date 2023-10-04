import java.util.*;
class CurrentAccount {
	float balance = 10000f;
	String AccountHistory = "";
    int records = 0;
	
    public boolean login() {
		boolean isLogin = false;
		Scanner a = new Scanner(System.in);
        System.out.println("Welcome to the ATM System!");
        System.out.print("Enter Login ID: ");
        String loginId = a.nextLine();
        System.out.print("Enter Login PIN: ");
        String loginPin = a.nextLine();
        System.out.println("Login Successful!");
	    isLogin = true;
        return isLogin;
	}
	
    public void AccountHistroy() {
		if ( records == 0 ) {
			System.out.println("\nEmpty!!");
		}
		else {
			System.out.println("\n" + AccountHistory);
		}
	}

	public void Withdraw() {
		System.out.print("\nEnter amount to withdraw - ");
		Scanner a = new Scanner(System.in);
		float amount = a.nextFloat();
			if ( balance >= amount ) {
				records++;
				balance -= amount;
				System.out.println("\nWithdraw Successfully!");
				String total = amount + " Rs Withdrawed\n";
				AccountHistory = AccountHistory + total;
			}
			else {
				System.out.println("\nSorry! Insufficient Balance");
			}
	}
	
	public void Deposit() {
		System.out.print("\nEnter amount to deposit - ");
		Scanner b = new Scanner(System.in);
		float amount = b.nextFloat();
			if ( amount <= 10000f ) {
				records++;
				balance += amount;
				System.out.println("\nSuccessfully Deposited!");
				String total = amount + " Rs deposited\n";
				AccountHistory = AccountHistory + total;
			}
			else {
				System.out.println("\nSorry! Limit is 10000.00");
			}
	}
	
	public void Transfer() {
		Scanner c = new Scanner(System.in);
		System.out.print("\nEnter Account Name - ");
		String Account = c.nextLine();
		System.out.print("\nEnter amount to transfer - ");
		float amount = c.nextFloat();
			if ( balance >= amount ) {
				if ( amount <= 50000f ) {
					records++;
					balance -= amount;
					System.out.println("\nSuccessfully Transfered to " + Account);
					String total = amount + " Rs transfered to " + Account + "\n";
					AccountHistory = AccountHistory + total;
				}
				else {
					System.out.println("\nSorry! Limit is 5000.00");
				}
			}
			else {
				System.out.println("\nSorry! Insufficient Balance");
			}
	}

	
}

public class ATMINTERFACE {
	public static void main(String[] args) {
		System.out.println("\n**********WELCOME TO OASIS INFOBYTE ATM INTERFACE**********\n");
        System.out.println("\n1.Login \n2.Exit");
		System.out.print("Enter Your Choice - ");
        Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
			CurrentAccount ac = new CurrentAccount();
			while(true) {
				if ( ch == 1 ) {
					if (ac.login()) {
						System.out.println("\n\n**********WELCOME BACK**********\n");
						while (true) {
							System.out.println("\n1.Transaction History \n2.Withdraw \n3.Deposit \n4.Transfer \n5.Quit");
							System.out.print("\nEnter Your Choice - ");
							int i = sc.nextInt();
							switch(i) {
								case 1:ac.AccountHistroy();
								break;
								case 2:ac.Withdraw();
								break;
								case 3:ac.Deposit();
								break;
								case 4:ac.Transfer();
								break;
								case 5:	System.out.println("Thank You! Have A Good Day Ahead.");
								System.exit(0);
								break;
							}
						}
					}
				}
				else {
				System.exit(0);
				}
			}
	}
}	
