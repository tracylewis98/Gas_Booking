package com.gasbooking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gasbooking.entity.Customer;
import com.gasbooking.entity.GasBooking;

@Repository
public interface IGasBookingRepository extends JpaRepository<GasBooking, Integer> {
	
	List<GasBooking> findAllByCustomerId(int customerId);
	
	
	@Query("from Customer c inner join fetch c.gasBooking where c.id = :customerId")
	public Customer findBycustomerId(@Param("customerId") int customerId);
	
	@Query("select g from GasBooking g where g.customer.id=:custId and g.localDate between :fromDate and :toDate")
	List<GasBooking> getAllBookingsForDays(@Param("custId") int customerId,@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);


}