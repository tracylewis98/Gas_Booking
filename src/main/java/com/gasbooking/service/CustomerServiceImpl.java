package com.gasbooking.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasbooking.entity.Customer;
import com.gasbooking.exception.CustomerNotFoundException;
import com.gasbooking.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;
	
	Logger logger=LoggerFactory.getLogger(CustomerServiceImpl.class);

	// inserting a single object
	@Override
	public Customer insertCustomer(Customer customer) {
		
		logger.info("****************Inserting customer Details****************");
		
		Customer insertedCustomer = customerRepository.save(customer);
		return insertedCustomer;
	}

	// updating a single object
	@Override
	public Customer updateCustomer(int customerId, Customer customer) throws NumberFormatException, InputMismatchException, CustomerNotFoundException {
		
		logger.info("****************updating Customer Details****************");
		
		Integer getId = Integer.valueOf(customerId);

		if (getId instanceof Integer) {
			Optional<Customer> optional = customerRepository.findById(getId);

			if (optional.isPresent()) {
				Customer gotCustomer = optional.get();
				gotCustomer.setUsername(customer.getUsername());
				gotCustomer.setPassword(customer.getPassword());
				gotCustomer.setAddress(customer.getAddress());
				gotCustomer.setEmail(customer.getEmail());
				gotCustomer.setMobileNumber(customer.getMobileNumber());
				gotCustomer.setAccountNo(customer.getAccountNo());
				gotCustomer.setIfscNo(customer.getIfscNo());
				gotCustomer.setPan(customer.getPan());
				gotCustomer.setBank(customer.getBank());
				gotCustomer.setCylinder(customer.getCylinder());
				gotCustomer.setGasBooking(customer.getGasBooking());
				Customer updateCustomer = customerRepository.save(gotCustomer);
				return updateCustomer;
			}

			else {
				throw new CustomerNotFoundException("Given customer id is not present in the database.");
			}
		} else {
			throw new InputMismatchException("The ID should be a number type");
		}

	}

	// deleting a single object by id
	@Override
	public Customer deleteCustomer(int customerId) throws NumberFormatException, InputMismatchException, CustomerNotFoundException {

		logger.info("****************Deleting Customer Details****************");
		
		Integer id = Integer.valueOf(customerId);

		if (id instanceof Integer) {
			Optional<Customer> optional = customerRepository.findById(customerId);

			if (optional.isPresent()) {
				Customer gotCustomer = optional.get();
				customerRepository.delete(gotCustomer);
				return gotCustomer;
			}

			else {
				throw new CustomerNotFoundException("Given customer id is not present in the database");
			}
		} else {
			throw new InputMismatchException("Given Id should be a number");
		}
	}

	// getting list of object
	@Override
	public List<Customer> viewCustomers() throws NumberFormatException, InputMismatchException, CustomerNotFoundException {

		logger.info("****************Getting All Customers Details****************");
		
		List<Customer> getAllCustomer = customerRepository.findAll();
		if (getAllCustomer.isEmpty()) {
			throw new CustomerNotFoundException("There are no such customer present in the database.");
		}
		return getAllCustomer;
	}

	// getting a single object
	@Override
	public Customer viewCustomer(int customerId) throws NumberFormatException, InputMismatchException, CustomerNotFoundException {
		
		logger.info("****************Getting Single customer Details****************");
		
		Integer getId = Integer.valueOf(customerId);

		if (getId instanceof Integer) {
			Optional<Customer> optional = customerRepository.findById(customerId);

			if (optional.isPresent()) {
				Customer gotCustomer = optional.get();
				return gotCustomer;
			} else {
				throw new CustomerNotFoundException("There are no such customer is present in the database.");
			}
		} else {
			throw new NumberFormatException("ID should be a number type.");
		}
	}

	@Override
	public Customer validateCustomer(String username, String password) throws NullPointerException, NumberFormatException, InputMismatchException, CustomerNotFoundException {
		
		logger.info("****************Validating the customer username and password****************");
		
		if(username!=null) {
			if(password!=null) {
				Customer validCustomer = customerRepository.findByUsernameAndPassword(username, password);
				if(validCustomer != null) {
					return validCustomer;
				}
				else {
					throw new CustomerNotFoundException("Username or password is not exist. please try again.");
				}
			}
			else {
				throw new CustomerNotFoundException("Please provide the password.");
			}
		}
		else {
			throw new CustomerNotFoundException("Please provide the username.");
		}
		
	}

}