package com.db.awmd.challenge.repository;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.domain.AmountTransaction;
import com.db.awmd.challenge.exception.DuplicateAccountIdException;
import com.db.awmd.challenge.service.NotificationService;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountsRepositoryInMemory implements AccountsRepository {
	@Autowired
	private NotificationService notificationService;
	private final Map<String, Account> accounts = new ConcurrentHashMap<>();
	private final Logger log = LoggerFactory.getLogger(AccountsRepositoryInMemory.class);

	@Override
	public void createAccount(Account account) throws DuplicateAccountIdException {
		Account previousAccount = accounts.putIfAbsent(account.getAccountId(), account);
		if (previousAccount != null) {
			throw new DuplicateAccountIdException("Account id " + account.getAccountId() + " already exists!");
		}
	}

	@Override
	public Account getAccount(String accountId) {
		return accounts.get(accountId);
	}

	@Override
	public void clearAccounts() {
		accounts.clear();
	}

	/*
	 * The below method has been created to transfer amount from one account to other
	 * @ param accountFromId
	 * @ param accountToId
	 * @ param transferAmount
	 */

	@Override
	public void transfer(Account accountFromId, Account accountToId, BigDecimal transferAmount) {
		if (accountFromId.getAccountId().equalsIgnoreCase(accountToId.getAccountId())) {
			log.info("sender and receiver account id cann't be same");
			return;

		}
		if (transferAmount.doubleValue() < accountFromId.getBalance().doubleValue()) {
			BigDecimal netFromAmount = new BigDecimal(
					accountFromId.getBalance().doubleValue() - transferAmount.doubleValue());
			BigDecimal netToAmount = new BigDecimal(
					accountToId.getBalance().doubleValue() + transferAmount.doubleValue());
			accountFromId.setBalance(netFromAmount);
			accountToId.setBalance(netToAmount);
			accounts.put(accountFromId.getAccountId(), accountFromId);
			accounts.put(accountToId.getAccountId(), accountToId);
			notificationService.notifyAboutTransfer(accountFromId,
					"amount " + transferAmount + " has been credited to account " + accountToId.getAccountId());

		} else {
			notificationService.notifyAboutTransfer(accountFromId, "Insufficient balance");

		}

	}

}
