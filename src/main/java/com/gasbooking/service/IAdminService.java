package com.gasbooking.service;
import java.time.LocalDate;
import java.util.List;

import com.gasbooking.entity.Admin;
import com.gasbooking.entity.GasBooking;
import com.gasbooking.exception.AdminNotFoundException;
import com.gasbooking.exception.CustomerNotFoundException;
import com.gasbooking.exception.GasBookingNotFoundException;

public interface IAdminService {

	public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(int adminId,Admin admin)throws AdminNotFoundException,Exception;
	public Admin deleteAdmin(int adminId) throws AdminNotFoundException ,Exception;
    public List<GasBooking>getAllBookings(int customerId)throws CustomerNotFoundException;
    public List<GasBooking>getAllBookingsForDays(int customerId, LocalDate fromDate, LocalDate toDate) throws GasBookingNotFoundException;
}