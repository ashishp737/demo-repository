package com.db.awmd.challenge.service;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.domain.AmountTransaction;
import com.db.awmd.challenge.repository.AccountsRepository;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public @Data class AccountsService {

	@Getter
	private final AccountsRepository accountsRepository;
	private AmountTransaction amountTransaction;
	public AccountsService getAccountsService() {
		return AccountsService;
	}

	public void setAccountsService(AccountsService accountsService) {
		AccountsService = accountsService;
	}

	@Autowired
	private AccountsService AccountsService;
	@Autowired
	public AccountsService(AccountsRepository accountsRepository) {
		this.accountsRepository = accountsRepository;
	}

	public void createAccount(Account account) {
		this.accountsRepository.createAccount(account);
	}

	public Account getAccount(String accountId) {
		return this.accountsRepository.getAccount(accountId);
	}

	public AccountsService getAccountsRepository() {

		return AccountsService;

	}

	public void clearAccounts() {
		accountsRepository.clearAccounts();

	}

	public void transfer(Account accountFromId, Account accountToId, BigDecimal transferAmount) {
		accountsRepository.transfer(accountFromId, accountToId, transferAmount);

	}
	public AmountTransaction getAmountTransaction() {
		return amountTransaction;
	}

	public void setAmountTransaction(AmountTransaction amountTransaction) {
		this.amountTransaction = amountTransaction;
	}

}
