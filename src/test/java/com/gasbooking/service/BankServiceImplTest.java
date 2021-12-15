package com.gasbooking.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gasbooking.entity.Bank;
import com.gasbooking.entity.Customer;
import com.gasbooking.exception.BankNotFoundException;
import com.gasbooking.repository.IBankRepository;

@SpringBootTest
public class BankServiceImplTest {
	@Autowired
	IBankService bankService;
	
	@MockBean
	IBankRepository bankRepository;
	@Test
	void testInsertBank() {
		
		Bank b1=new Bank();
		Customer c=new Customer();
		b1.setBankId(3);
		b1.setCustomer(c);
		b1.setBankName("ICICI");
		b1.setAddress("msg");
	
	Mockito.when(bankRepository.save(b1)).thenReturn(b1);
	assertThat(bankService.insertBank(b1)).isEqualTo(b1);
	}
	@Test
	void testUpdateBank() throws BankNotFoundException{
		int bankId = 1;
		Bank b1=new Bank();
		Customer c=new Customer();
//		b1.setBankId(3);
		b1.setCustomer(c);
		b1.setBankName("ICICI");
		b1.setAddress("msg");
		Optional<Bank> b2=Optional.of(b1);
		Mockito.when(bankRepository.findById(1)).thenReturn(b2);
		Mockito.when(bankRepository.save(b1)).thenReturn(b1);
//		b1.setBankId(1);
		b1.setCustomer(c);
		b1.setBankName("AXIS");
		b1.setAddress("Udupi");
		assertThat(bankService.updateBank(bankId, b1)).isEqualTo(b1);
	}
	@Test
      void testDeleteBank() throws BankNotFoundException{
		Bank b1=new Bank();
		Customer c=new Customer();
		b1.setBankId(1);
		b1.setBankName("AXIS");
		b1.setAddress("Udupi");
		b1.setCustomer(c);
		Optional<Bank> b2=Optional.of(b1);
		Mockito.when(bankRepository.findById(1424)).thenReturn(b2);
		assertThat(bankService.deleteBank(1424)).isEqualTo(b1);
	}
}