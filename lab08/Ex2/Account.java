package Ex2;

import java.math.BigDecimal;

public class Account {
	private String accId;
	private String accHolder;
	private BigDecimal balance;

	public static final BigDecimal MIN_BALANCE = new BigDecimal("0.00");
	public static final BigDecimal MAX_BALANCE = new BigDecimal("100000.00");

	public Account(String accId, String accHolder, BigDecimal initialBalance) {
		setAccId(accId);
		setAccHolder(accHolder);
		setBalance(initialBalance);
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		if (accId == null || accId.isBlank()) throw new IllegalArgumentException("Account ID required");
		this.accId = accId;
	}

	public String getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(String accHolder) {
		if (accHolder == null || accHolder.isBlank()) throw new IllegalArgumentException("Account holder required");
		this.accHolder = accHolder;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		if (balance == null) throw new IllegalArgumentException("Balance required");
		if (balance.scale() > 2) throw new IllegalArgumentException("Only two decimal places allowed");
		if (balance.compareTo(MIN_BALANCE) < 0) throw new IllegalArgumentException("Balance cannot be below " + MIN_BALANCE);
		if (balance.compareTo(MAX_BALANCE) > 0) throw new IllegalArgumentException("Balance cannot exceed " + MAX_BALANCE);
		this.balance = balance;
	}

	public void deposit(BigDecimal amount) {
		if (amount == null) throw new IllegalArgumentException("Amount required");
		if (amount.scale() > 2) throw new IllegalArgumentException("Only two decimal places allowed");
		if (amount.compareTo(BigDecimal.ZERO) <= 0 || amount.compareTo(new BigDecimal("1000.00")) > 0)
			throw new IllegalArgumentException("Deposit range: 0 < amount <= 1000");
		BigDecimal newBal = balance.add(amount);
		if (newBal.compareTo(MAX_BALANCE) > 0) throw new IllegalArgumentException("Deposit would exceed maximum balance");
		balance = newBal;
	}

	public void withdraw(BigDecimal amount) {
		if (amount == null) throw new IllegalArgumentException("Amount required");
		if (amount.scale() > 2) throw new IllegalArgumentException("Only two decimal places allowed");
		if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Withdraw amount must be positive");
		BigDecimal newBal = balance.subtract(amount);
		if (newBal.compareTo(MIN_BALANCE) < 0) throw new IllegalArgumentException("Insufficient funds or would go below minimum balance");
		balance = newBal;
	}

	@Override
	public String toString() {
		return String.format("ACC_ID: %s\nACC_HOLDER: %s\nACC_BALANCE: %s$", accId, accHolder, balance.setScale(2));
	}
}
