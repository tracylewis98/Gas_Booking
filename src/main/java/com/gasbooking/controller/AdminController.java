package com.gasbooking.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gasbooking.entity.Admin;
import com.gasbooking.entity.GasBooking;
import com.gasbooking.exception.AdminNotFoundException;
import com.gasbooking.exception.CustomerNotFoundException;
import com.gasbooking.exception.GasBookingNotFoundException;
import com.gasbooking.service.IAdminService;

@RestController
public class AdminController {

	@Autowired
	IAdminService adminService;
	

	@PostMapping("/admin/insert")
	public ResponseEntity<Admin> insertAdmin(@Valid @RequestBody Admin admin) {
		Admin serviceAdmin = adminService.insertAdmin(admin);
		return new ResponseEntity<>(serviceAdmin, HttpStatus.CREATED);
	}

	@PutMapping("/admin/update/{adminId}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable int adminId,@Valid @RequestBody Admin admin) throws AdminNotFoundException, Exception {
		
		Admin serviceAdmin = adminService.updateAdmin(adminId,admin);
		return new ResponseEntity<>(serviceAdmin, HttpStatus.OK);
	}

	@DeleteMapping("/admin/delete/{adminId}")
	public ResponseEntity<Admin> deleteAdmin(@PathVariable int adminId) throws AdminNotFoundException, Exception {
		
		Admin serviceAdmin = adminService.deleteAdmin(adminId);
		return new ResponseEntity<>(serviceAdmin, HttpStatus.OK);
	}

	@GetMapping("admin/customer/getBookings")
	public ResponseEntity<List<GasBooking>> getAllBookings(@RequestParam("id") int customerId) throws CustomerNotFoundException {
		List<GasBooking> serviceGasBookings = adminService.getAllBookings(customerId);
		return new ResponseEntity<List<GasBooking>>(serviceGasBookings, HttpStatus.OK);
	}

	@GetMapping("admin/customer/getBookings/betweenDays/")
	public ResponseEntity<List<GasBooking>> getAllBookingsForDays(@RequestParam("customerId") int customerId,@RequestParam("fromDate") LocalDate fromDate,
			@RequestParam("toDate") LocalDate toDate) throws GasBookingNotFoundException {
		List<GasBooking> servicebookingBetweenDays = adminService.getAllBookingsForDays(customerId, fromDate, toDate);
		return new ResponseEntity<List<GasBooking>>(servicebookingBetweenDays, HttpStatus.OK);
	}

}