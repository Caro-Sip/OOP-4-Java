package Ex2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankManagement {
	private final List<Account> accounts = new ArrayList<>();

	public List<Account> getAccounts() {
		return accounts;
	}

	public void addAccount(Account acc) {
		if (findById(acc.getAccId()) != null) throw new IllegalArgumentException("Account ID already exists");
		accounts.add(acc);
	}

	public Account findById(String accId) {
		for (Account a : accounts) if (a.getAccId().equals(accId)) return a;
		return null;
	}

	public void depositTo(String accId, BigDecimal amount) {
		Account a = findById(accId);
		if (a == null) throw new IllegalArgumentException("Account not found");
		a.deposit(amount);
	}

	public void withdrawFrom(String accId, BigDecimal amount) {
		Account a = findById(accId);
		if (a == null) throw new IllegalArgumentException("Account not found");
		a.withdraw(amount);
	}

	public void transfer(String fromId, String toId, BigDecimal amount) {
		if (fromId.equals(toId)) throw new IllegalArgumentException("Cannot transfer to same account");
		Account from = findById(fromId);
		Account to = findById(toId);
		if (from == null || to == null) throw new IllegalArgumentException("Source or destination account not found");
		// perform atomic-like operation: validate then apply
		from.withdraw(amount);
		try {
			to.deposit(amount);
		} catch (RuntimeException ex) {
			// rollback
			from.deposit(amount);
			throw ex;
		}
	}
}
