package com.db.awmd.challenge.domain;

import java.math.BigDecimal;

/*
 * This class has been created for amount transfer
 * from one account to other 
 * Its properties accept the json value entered from front end
 */

public class AmountTransaction {
	private String accountFromId;
	private String accountToId;
	private BigDecimal senderBalance;
	private BigDecimal receiverBalance;
	private BigDecimal transferAmount;

	/*
	 * The below method return the sender account id
	 * 
	 * @return accountFromId
	 */
	public String getAccountFromId() {
		return accountFromId;
	}

	/*
	 * The below method set the sender account id
	 * 
	 * @param accountFromId
	 */
	public void setAccountFromId(String accountFromId) {
		this.accountFromId = accountFromId;
	}

	/*
	 * The below method return the receiver account id
	 * 
	 * @return accountToId
	 */
	public String getAccountToId() {
		return accountToId;
	}

	/*
	 * The below method sets the receiver account id
	 * 
	 * @param accountToId
	 */
	public void setAccountToId(String accountToId) {
		this.accountToId = accountToId;
	}

	/*
	 * The below method return the sender balance in account
	 * 
	 * @return senderBalance
	 */
	public BigDecimal getSenderBalance() {
		return senderBalance;
	}

	/*
	 * The below method sets the sender balance in account
	 * 
	 * @param senderBalance
	 */
	public void setSenderBalance(BigDecimal senderBalance) {
		this.senderBalance = senderBalance;
	}

	/*
	 * The below method return the receiver balance in account
	 * 
	 * @return receiverBalance
	 */
	public BigDecimal getReceiverBalance() {
		return receiverBalance;
	}
	/*
	 * The below method sets the receiver balance in account
	 * 
	 * @param receiverBalance
	 */

	public void setReceiverBalance(BigDecimal receiverBalance) {
		this.receiverBalance = receiverBalance;
	}

	/*
	 * The below method return transfer amount
	 * 
	 * @return transferAmount
	 */
	public BigDecimal getTransferAmount() {
		return transferAmount;
	}

	/*
	 * The below method sets transfer amount
	 * 
	 * @param transferAmount
	 */
	public void setTransferAmount(BigDecimal transferAmount) {
		this.transferAmount = transferAmount;
	}
}
