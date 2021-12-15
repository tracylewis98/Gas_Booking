package com.gasbooking.service;

import com.gasbooking.entity.GasBooking;
import com.gasbooking.exception.GasBookingNotFoundException;

public interface IGasBookingService {
	
	public GasBooking insertGasBooking(GasBooking gasBooking);
	
	public GasBooking updateGasBooking(int gasBookingId, GasBooking gasBooking) throws GasBookingNotFoundException;
	
	public GasBooking deleteGasBooking(int gasBookingId) throws GasBookingNotFoundException;
	
	public GasBooking getBill(int customerId) throws GasBookingNotFoundException;

}