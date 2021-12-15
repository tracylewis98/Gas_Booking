package com.gasbooking.service;

import java.util.List;

import com.gasbooking.entity.Bank;
import com.gasbooking.exception.BankNotFoundException;

public interface IBankService {
	
	public Bank insertBank(Bank bank);
	
	public Bank updateBank(int bankId, Bank bank) throws BankNotFoundException;
	
	public Bank deleteBank(int bankId) throws BankNotFoundException;
    
	List<Bank> getAllBank() throws BankNotFoundException;
	
	public Bank getBankById(int bankId)throws BankNotFoundException;
}