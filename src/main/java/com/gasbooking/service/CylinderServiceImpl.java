package com.gasbooking.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasbooking.entity.Cylinder;
import com.gasbooking.exception.CylinderNotFoundException;
import com.gasbooking.repository.ICylinderRepository;

@Service
public  class CylinderServiceImpl implements ICylinderService{
	
	@Autowired
	ICylinderRepository cylinderrepository;

	Logger logger=LoggerFactory.getLogger(CylinderServiceImpl.class);
	
	@Override
	public Cylinder insertCylinder(Cylinder cylinder) {
		logger.info("****************Inserting cylinder Details****************");
		
		return cylinderrepository.save(cylinder);
	}

	@Override
	public Cylinder updateCylinder(int cylinderId, Cylinder cylinder) throws CylinderNotFoundException  {
		
		logger.info("****************updating cylinder Details****************");
		
		Optional<Cylinder> optional = cylinderrepository.findById(cylinderId);
		if(optional.isPresent()) {
			Cylinder c1=optional.get();
			c1.setType(cylinder.getType());
			c1.setWeight(cylinder.getWeight());
			c1.setStrapColor(cylinder.getStrapColor());
			c1.setPrice(cylinder.getPrice());
			cylinderrepository.save(c1);
			return c1;
		}
		else {
			throw new CylinderNotFoundException("Cylinder details not found");
		}
	}

	@Override
	public Cylinder deleteCylinder(int cylinderId) throws CylinderNotFoundException {
		logger.info("****************deleting cylinder Details****************");

		Optional<Cylinder> optional=cylinderrepository.findById(cylinderId);
		if(optional.isPresent()) {
			Cylinder deletedCylinder=optional.get();
			cylinderrepository.delete(deletedCylinder);
			return deletedCylinder;
		}
		else {
			throw new CylinderNotFoundException(" Cylinder details not found");
		}
	}

	@Override
	public List<Cylinder> viewCylinderByType(String type) throws CylinderNotFoundException {
		
		logger.info("****************Getting cylinder by type Details****************");

		
		Optional<List<Cylinder>> optional=cylinderrepository.findByType(type);
		if(optional.isPresent()) {
			List<Cylinder> list = optional.get();
			return list;
	}
       else {
	     throw new CylinderNotFoundException("Cylinder detalis not found");
      }
	}
}