package com.gasbooking.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gasbooking.entity.Bank;
import com.gasbooking.entity.Customer;
import com.gasbooking.entity.Cylinder;
import com.gasbooking.entity.GasBooking;
import com.gasbooking.entity.SurrenderCylinder;
import com.gasbooking.exception.CustomerNotFoundException;
import com.gasbooking.repository.ICustomerRepository;


@SpringBootTest
public class CustomerServiceTestImpl {
	@Autowired
	ICustomerService customerService;
	
	@MockBean
	ICustomerRepository customerRepository;
	
	@Test
	void testInsertCustomer() {
		Customer c1 = new Customer();
		Bank b=new Bank();
		List<GasBooking> list=new ArrayList<>();
		Cylinder ci=new Cylinder();
		c1.setUsername("subham");
		c1.setPassword("subham@16");
		c1.setAddress("Kumrashol-");
		c1.setEmail("subhamshaw@gmail.com");
		c1.setMobileNumber("9576979049");
		c1.setIfscNo("ABCD0122344");
		c1.setPan("IORPS5530A");
		c1.setCylinder(ci);
		c1.setBank(b);
		c1.setGasBooking(list);
		
		
		Mockito.when(customerRepository.save(c1)).thenReturn(c1);
		
		assertThat(customerService.insertCustomer(c1)).isEqualTo(c1);
	}
	
	@Test
	public void updateCustomerTest() {
		int customerId=7;
		List<GasBooking> list=new ArrayList<>();
		
		GasBooking g1=new GasBooking();
		g1.setLocalDate(LocalDate.now());
		g1.setStatus(false);
		g1.setBill(206.97);
		
		GasBooking g2=new GasBooking();
		g2.setLocalDate(LocalDate.now());
		g2.setStatus(false);
		g2.setBill(340.76);
		
		list.add(g1);
		list.add(g2);
		
		Bank b=new Bank();
		b.setAddress("BLR");
		b.setBankName("AXIS");
		
		SurrenderCylinder su=new SurrenderCylinder();
		su.setSurrenderDate(LocalDate.now());
		
		Cylinder ci=new Cylinder();
		ci.setPrice(123.45);
		ci.setStrapColor("Blue");
		ci.setSurrenderCylinder(su);
		
		Customer cu=new Customer();
	    cu.setUsername("Mohan");
		cu.setPassword("Mohan@16");
		cu.setAddress("MohanKumar-143");
		cu.setEmail("MohanKumar@gmail.com");
		cu.setMobileNumber("9565479049");
		cu.setIfscNo("KTRE0122344");
		cu.setPan("IORPS5530A");
		cu.setCylinder(ci);
	    cu.setBank(b);
		cu.setGasBooking(list);
		
		Optional<Customer> customer=Optional.of(cu);
		
		when(customerRepository.findById(customerId)).thenReturn(customer);
		cu.setAddress("132-Maharastra");
		cu.setEmail("Mohan12345678@gmail.com");
		cu.setIfscNo("KTRE0234344");
		when(customerRepository.save(cu)).thenReturn(cu);
		
		try {
			assertEquals(cu,customerService.updateCustomer(customerId,cu) );
		} catch (NumberFormatException | InputMismatchException | CustomerNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void deleteCustomer() {
		
		int customerId=3;
		
		List<GasBooking> list=new ArrayList<>();
		GasBooking g1=new GasBooking();
		g1.setLocalDate(LocalDate.now());
		g1.setStatus(false);
		g1.setBill(206.97);
		
		GasBooking g2=new GasBooking();
		g2.setLocalDate(LocalDate.now());
		g2.setStatus(false);
		g2.setBill(206.97);
		
		list.add(g1);
		list.add(g2);
		
		Bank b=new Bank();
		b.setAddress("BLR");
		b.setBankName("AXIS");
		
		SurrenderCylinder su=new SurrenderCylinder();
		su.setSurrenderDate(LocalDate.now());
		
		Cylinder ci=new Cylinder();
		ci.setPrice(123.45);
		ci.setStrapColor("Blue");
		ci.setSurrenderCylinder(su);
		
		Customer cu=new Customer();
	    cu.setUsername("Akhil");
		cu.setPassword("Akhil@16");
		cu.setAddress("AkhilKumar-143");
		cu.setEmail("AkhilKumar@gmail.com");
		cu.setMobileNumber("9565476754");
		cu.setIfscNo("KTRE0128763");
		cu.setPan("IORPGRDH0A");
		cu.setCylinder(ci);
	    cu.setBank(b);
		cu.setGasBooking(list);
		
		Optional<Customer> customer=Optional.of(cu);
		
		when(customerRepository.findById(customerId)).thenReturn(customer);
		cu.setAddress("132-Maharastra");
		cu.setEmail("Mohan12345678@gmail.com");
		cu.setIfscNo("KTRE0234344");
		
		when(customerRepository.findById(customerId)).thenReturn(customer);
		try {
			assertEquals(cu, customerService.deleteCustomer(customerId));
		} catch (NumberFormatException | InputMismatchException | CustomerNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void viewCustomerTest() throws NumberFormatException, InputMismatchException, CustomerNotFoundException {
		
		List <Customer> customers=new ArrayList<>();
		
		List<GasBooking> list=new ArrayList<>();
		GasBooking g1=new GasBooking();
		g1.setLocalDate(LocalDate.now());
		g1.setStatus(false);
		g1.setBill(400.87);
		
		GasBooking g2=new GasBooking();
		g2.setLocalDate(LocalDate.now());
		g2.setStatus(false);
		g2.setBill(206.97);
		
		list.add(g1);
		list.add(g2);
		
		Bank b=new Bank();
		b.setAddress("BLR");
		b.setBankName("AXIS");
		
		SurrenderCylinder su=new SurrenderCylinder();
		su.setSurrenderDate(LocalDate.now());
		
		Cylinder ci=new Cylinder();
		ci.setPrice(123.45);
		ci.setStrapColor("Blue");
		ci.setSurrenderCylinder(su);
		
		Customer cu=new Customer();
	    cu.setUsername("Bava");
		cu.setPassword("Bava@16");
		cu.setAddress("BavaKhan-143");
		cu.setEmail("BavaKhan@gmail.com");
		cu.setMobileNumber("9823476754");
		cu.setIfscNo("KTRYTRE45DF");
		cu.setPan("IORPDRTUKG");
		cu.setCylinder(ci);
	    cu.setBank(b);
		cu.setGasBooking(list);
		
		List<GasBooking> list1=new ArrayList<>();
		GasBooking g3=new GasBooking();
		g3.setLocalDate(LocalDate.now());
		g3.setStatus(false);
		g3.setBill(123.76);
		
		GasBooking g4=new GasBooking();
		g4.setLocalDate(LocalDate.now());
		g4.setStatus(false);
		g4.setBill(206.97);
		
		list.add(g3);
		list.add(g4);
		
		Bank b1=new Bank();
		b.setAddress("HYD");
		b.setBankName("ICIC");
		
		SurrenderCylinder su1=new SurrenderCylinder();
		su.setSurrenderDate(LocalDate.now());
		
		Cylinder ci1=new Cylinder();
		ci.setPrice(143.67);
		ci.setStrapColor("Blue");
		ci.setSurrenderCylinder(su);
		
		Customer cu1=new Customer();
	    cu.setUsername("Bava");
		cu.setPassword("Bava@16");
		cu.setAddress("BavaKhan-143");
		cu.setEmail("BavaKhan@gmail.com");
		cu.setMobileNumber("9823476754");
		cu.setIfscNo("KTRYTRE45DF");
		cu.setPan("IORPDRTUKG");
		cu.setCylinder(ci1);
	    cu.setBank(b1);
		cu.setGasBooking(list1);
		
		customers.add(cu);
		customers.add(cu1);
		
		
		when(customerRepository.findAll()).thenReturn(customers);
		assertEquals(customers, customerService.viewCustomers());
		
	}
	
	@Test
	public void viewCustomer() {
		int customerId=8;
		List<GasBooking> list=new ArrayList<>();
		
		GasBooking g1=new GasBooking();
		g1.setLocalDate(LocalDate.now());
		g1.setStatus(false);
		g1.setBill(206.97);
		
		GasBooking g2=new GasBooking();
		g2.setLocalDate(LocalDate.now());
		g2.setStatus(false);
		g2.setBill(504.90);
		
		list.add(g1);
		list.add(g2);
		
		Bank b=new Bank();
		b.setAddress("BLR");
		b.setBankName("AXIS");
		
		SurrenderCylinder su=new SurrenderCylinder();
		su.setSurrenderDate(LocalDate.now());
		
		Cylinder ci=new Cylinder();
		ci.setPrice(123.45);
		ci.setStrapColor("Blue");
		ci.setSurrenderCylinder(su);
		
		Customer cu=new Customer();
	    cu.setUsername("Nazeeb");
		cu.setPassword("Nazeeb@16");
		cu.setAddress("NazeebKhan-143");
		cu.setEmail("NazeebKhan@gmail.com");
		cu.setMobileNumber("9675479049");
		cu.setIfscNo("KTREYU67344");
		cu.setPan("IO097T530A");
		cu.setCylinder(ci);
	    cu.setBank(b);
		cu.setGasBooking(list);
		
		Optional<Customer> optional=Optional.of(cu);
		
		
		when(customerRepository.findById(customerId)).thenReturn(optional);
		
		try {
			assertEquals(cu, customerService.viewCustomer(customerId));
		} catch (NumberFormatException | InputMismatchException | CustomerNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void validateCustomerTest() {
		
		String username="SubhamKumar1234";
		String password="Subham@1234";
		
		Customer c=new Customer();
		c.setUsername(username);
		c.setPassword(password);
		
		when(customerRepository.findByUsernameAndPassword(username, password)).thenReturn(c);
		try {
			assertEquals(c, customerService.validateCustomer(username, password));
		} catch (NumberFormatException | InputMismatchException | NullPointerException | CustomerNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
}