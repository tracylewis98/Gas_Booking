package com.gasbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gasbooking.entity.Bank;
import com.gasbooking.exception.BankNotFoundException;
import com.gasbooking.service.BankServiceImpl;
import com.gasbooking.service.IBankService;

@RestController
@CrossOrigin
@RequestMapping("/bank")
public class BankController {
	@Autowired
	IBankService bankService;
	
	@PostMapping("/insertBank")
	public ResponseEntity<?>insertBank(@RequestBody Bank bank){
		Bank insertedBank=bankService.insertBank(bank);
		return new ResponseEntity<Bank>(insertedBank,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateBank/{bankId}")
	public ResponseEntity<?>updateBank(@PathVariable int bankId, @RequestBody Bank bank)throws BankNotFoundException{
		Bank updatedBank=bankService.updateBank(bankId ,bank);
	    return new ResponseEntity<Bank>(updatedBank,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteBank/{bankId}")
	public ResponseEntity<?>deleteBank(@PathVariable int bankId)throws BankNotFoundException{
		Bank deletedBank=bankService.deleteBank(bankId);
		return new ResponseEntity<Bank>(deletedBank,HttpStatus.OK);
	}
	@GetMapping("/getAllBank")
	public ResponseEntity<?> getAllGasBookings() throws BankNotFoundException {
		List<Bank> getAllBank = bankService.getAllBank();
		return new ResponseEntity<List<Bank>>(getAllBank, HttpStatus.OK);
	}
	@GetMapping("/getBankById/{bankId}")
	public ResponseEntity<?> getBankById(@PathVariable int bankId) throws BankNotFoundException,NumberFormatException {
		Bank getSingleBank= bankService.getBankById(bankId);
		return new ResponseEntity<Bank>(getSingleBank, HttpStatus.OK);
	}

}