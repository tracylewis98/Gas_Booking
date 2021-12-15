package com.gasbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gasbooking.entity.Bank;

@Repository
public interface IBankRepository extends JpaRepository<Bank, Integer>{

}