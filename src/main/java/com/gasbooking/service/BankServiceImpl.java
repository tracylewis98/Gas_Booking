package com.gasbooking.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasbooking.entity.Bank;
import com.gasbooking.entity.Customer;
import com.gasbooking.exception.BankNotFoundException;
import com.gasbooking.exception.CustomerNotFoundException;
import com.gasbooking.repository.IBankRepository;

@Service
public class BankServiceImpl implements IBankService {

	@Autowired
	IBankRepository bankRepository;

	Logger logger=LoggerFactory.getLogger(BankServiceImpl.class);
	
	@Override
	public Bank insertBank(Bank bank) {

		logger.info("****************Inserting Bank Details****************");

		return bankRepository.save(bank);
	}

	@Override
	public Bank updateBank(int bankId, Bank bank) throws BankNotFoundException {
		
		logger.info("****************Updating Bank Details****************");

		Optional<Bank> optional = bankRepository.findById(bankId);
		
		if (optional.isPresent()) {
			Bank b1 = optional.get();
			b1.setBankName(bank.getBankName());
			b1.setAddress(bank.getAddress());
			Bank updatedBank = bankRepository.save(b1);
			return updatedBank;
		} else {
			throw new BankNotFoundException("Bank not found");
		}
	}


	@Override
	public Bank deleteBank(int bankId) throws BankNotFoundException {
		
		logger.info("****************Deleting Bank Details****************");

		Optional<Bank> optional = bankRepository.findById(bankId);
		
		if (optional.isPresent()) {
			Bank deletedBank = optional.get();
			bankRepository.deleteById(bankId);
			return deletedBank;
		} else {
			throw new BankNotFoundException("Bank not found");
		}
	}
	@Override
	public List<Bank> getAllBank() throws BankNotFoundException {
		logger.info("****Get All BankDetails****");
		List<Bank> list = bankRepository.findAll();
		if (list.isEmpty()) {
			throw new BankNotFoundException("There are no such customer present in the database.");
		}
		return list;
	
}

	@Override
	public Bank getBankById(int bankId) throws BankNotFoundException,NumberFormatException {
		logger.info("***View bank Details By bank Id ****");
		Integer getId = Integer.valueOf(bankId);

		if (getId instanceof Integer) {
			Optional<Bank> optional =bankRepository.findById(bankId);

			if (optional.isPresent()) {
				Bank gotBank = optional.get();
				return gotBank;
			} else {
				throw new BankNotFoundException("There is no such bank is present in the database.");
				
			}} else 
				{
				throw new NumberFormatException("Id shld be a number");
				}
			 
	
	}
		
	}
	