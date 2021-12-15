package com.gasbooking.controller;


import java.util.List;

import javax.validation.Valid;

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

import com.gasbooking.entity.Cylinder;
import com.gasbooking.exception.CylinderNotFoundException;
import com.gasbooking.service.ICylinderService;

@RestController
	@RequestMapping("/cylinder")
	@CrossOrigin
	public class CylinderController {
	@Autowired
	ICylinderService cylinderService;
	@PostMapping("/insert")
	public ResponseEntity<?> insertCylinder(@Valid @RequestBody Cylinder cylinder) {
		Cylinder addedCylinder = cylinderService.insertCylinder(cylinder);
		return new ResponseEntity<Cylinder>(addedCylinder, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCylinder/{cylinderId}")
	public ResponseEntity<?> updateCylinder(@PathVariable int cylinderId, @RequestBody Cylinder cylinder) throws CylinderNotFoundException {
		Cylinder updatedCylinder = cylinderService.updateCylinder(cylinderId, cylinder);
		return new ResponseEntity<Cylinder>(updatedCylinder, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCylinder/{cylinderId}")
	public ResponseEntity<?> deleteCylinder(@PathVariable int cylinderId) throws CylinderNotFoundException {
		Cylinder deletedCylinder = cylinderService.deleteCylinder(cylinderId);
		return new ResponseEntity<Cylinder>(deletedCylinder, HttpStatus.OK);
	}
	
	@GetMapping("/viewCylindres")
	public ResponseEntity<?> viewCylinderByType(String type) throws  CylinderNotFoundException {
		List<Cylinder> viewCylinders = cylinderService.viewCylinderByType(type);
		return new ResponseEntity<List<Cylinder>>(viewCylinders, HttpStatus.OK);

	}	


}