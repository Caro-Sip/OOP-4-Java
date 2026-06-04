package Ex2;

import java.math.BigDecimal;
import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		BankManagement bank = new BankManagement();
		// sample accounts
		bank.addAccount(new Account("00000000111", "Mesa Mina", new BigDecimal("403.34")));
		bank.addAccount(new Account("00000000222", "Tola Kompheak", new BigDecimal("803.34")));
		bank.addAccount(new Account("00000000333", "Tola Mokara", new BigDecimal("603.34")));
		bank.addAccount(new Account("000000004444", "Tola Seyha", new BigDecimal("203.34")));

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(":::: The Bank :::::");
			System.out.println("1. Account List");
			System.out.println("2. Create an account");
			System.out.println("3. Deposit to an account");
			System.out.println("4. Withdraw from an account");
			System.out.println("5. Transfer to another account");
			System.out.println("6. Quit");
			System.out.print("Choose an opt: ");
			int opt = sc.nextInt();
            sc.nextLine();
			System.out.println();
			try {
				switch (opt) {
					case 1 -> showAccounts(bank);
					case 2 -> createAccount(bank, sc);
					case 3 -> deposit(bank, sc);
					case 4 -> withdraw(bank, sc);
					case 5 -> transfer(bank, sc);
					case 6 -> { System.out.println("Goodbye"); sc.close(); return; }
					default -> System.out.println("Invalid option\n");
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage() + "\n");
			}
		}
	}

	private static void showAccounts(BankManagement bank) {
		System.out.println("Option: 1");
		System.out.println(":::: Account List :::::");
		int i = 1;
		for (Account a : bank.getAccounts()) {
			System.out.println("No #" + i);
			System.out.println(a);
			i++;
		}
		System.out.println();
	}

	private static void createAccount(BankManagement bank, Scanner sc) {
		System.out.print("Enter ACC_ID: ");
		String id = sc.nextLine().trim();
		System.out.print("Enter ACC_HOLDER: ");
		String holder = sc.nextLine().trim();
		System.out.print("Enter initial balance: ");
		String balStr = sc.nextLine().trim();
		BigDecimal bal = parseAmount(balStr, true);
		bank.addAccount(new Account(id, holder, bal));
		System.out.println("Account created\n");
	}

	private static void deposit(BankManagement bank, Scanner sc) {
		System.out.print("Enter ACC_ID: ");
		String id = sc.nextLine().trim();
		System.out.print("Enter amount to deposit: ");
		BigDecimal amt = parseAmount(sc.nextLine().trim(), false);
		bank.depositTo(id, amt);
		System.out.println("Deposit successful\n");
	}

	private static void withdraw(BankManagement bank, Scanner sc) {
		System.out.print("Enter ACC_ID: ");
		String id = sc.nextLine().trim();
		System.out.print("Enter amount to withdraw: ");
		BigDecimal amt = parseAmount(sc.nextLine().trim(), false);
		bank.withdrawFrom(id, amt);
		System.out.println("Withdraw successful\n");
	}

	private static void transfer(BankManagement bank, Scanner sc) {
		System.out.print("Enter SOURCE ACC_ID: ");
		String src = sc.nextLine().trim();
		System.out.print("Enter DEST ACC_ID: ");
		String dst = sc.nextLine().trim();
		System.out.print("Enter amount to transfer: ");
		BigDecimal amt = parseAmount(sc.nextLine().trim(), false);
		bank.transfer(src, dst, amt);
		System.out.println("Transfer successful\n");
	}

	private static BigDecimal parseAmount(String s, boolean allowZero) {
		try {
			if (s.startsWith("$")) s = s.substring(1);
			BigDecimal v = new BigDecimal(s);
			if (v.scale() > 2) throw new IllegalArgumentException("Only two decimal places allowed");
			if (!allowZero && v.compareTo(BigDecimal.ZERO) == 0) throw new IllegalArgumentException("Amount must be non-zero");
			return v.setScale(Math.min(2, v.scale()));
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException("Amount must be numeric");
		}
	}
}
