package com.gasbooking.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasbooking.entity.Admin;
import com.gasbooking.entity.GasBooking;
import com.gasbooking.exception.AdminNotFoundException;
import com.gasbooking.exception.CustomerNotFoundException;
import com.gasbooking.exception.GasBookingNotFoundException;
import com.gasbooking.repository.IAdminRepository;
import com.gasbooking.repository.IGasBookingRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository adminDao;

	@Autowired
	IGasBookingRepository gasBookingDao;
	
	Logger logger=LoggerFactory.getLogger(AdminServiceImpl.class);
	
	
	@Override
	public Admin insertAdmin(Admin admin) {
		logger.info("***********Inserting Admin Details*********************");
		
		return adminDao.save(admin);

	}

	
	@Override
	public Admin updateAdmin(int adminId,Admin admin) throws AdminNotFoundException,Exception {
		
		logger.info("****Updating Admin Details********");
		
						
			if (adminId>0) {
				Optional<Admin> daoAdmin = adminDao.findById(adminId);

				if (daoAdmin.isPresent()) {
					Admin adminSave=daoAdmin.get();
					adminSave.setUsername(admin.getUsername());
					adminSave.setPassword(admin.getPassword());
					adminSave.setAddress(admin.getAddress());
					adminSave.setMobileNumber(admin.getMobileNumber());
					adminSave.setEmail(admin.getEmail());
					return adminDao.save(adminSave);
				}
				else {
					throw new AdminNotFoundException("Admin Not Found");
				}
			} else {
                 throw new Exception("Please Provide A Valid Id To Update");
			}
	}

	
	
	@Override
	public Admin deleteAdmin(int adminId) throws AdminNotFoundException,Exception{
		logger.info("****Deleting Admin Details********");
		
		
		if (adminId>0) {
			Optional<Admin> optional=adminDao.findById(adminId);
			if(optional.isPresent()) {
				Admin gotAdmin=optional.get();
				adminDao.delete(gotAdmin);
				return gotAdmin;
				
			}
			else {
				throw new AdminNotFoundException("Please Give proper id to delete");
			}

		} else {
           throw new Exception("Please Provide A Valid Email Id");
		}
	}

	

	@Override
	public List<GasBooking> getAllBookings(int customerId) throws CustomerNotFoundException   {
		logger.info("***********Fetching List Of GasBookings For Given CustomerId*********************");
        
		if (customerId <0) {
		throw new CustomerNotFoundException("Please Provide A valid customer Id");
	} else {
			return gasBookingDao.findAllByCustomerId(customerId);
		}

	}
	
	

	@Override
	public List<GasBooking> getAllBookingsForDays(int customerId, LocalDate fromDate, LocalDate toDate) throws GasBookingNotFoundException {
		logger.info("**********Fecting All Bookings Between Given Days For A Customer*********************");
		if (customerId<0) {
			throw new GasBookingNotFoundException("Please Provide A Valid Customer Id To Find Gas Bookings");
		} else {
			return gasBookingDao.getAllBookingsForDays(customerId, fromDate, toDate);
		}
	}

}