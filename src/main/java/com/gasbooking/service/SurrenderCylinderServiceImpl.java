package com.gasbooking.service;

import java.util.Optional;
import java.util.function.Supplier;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gasbooking.entity.SurrenderCylinder;
import com.gasbooking.exception.CylinderNotFoundException;
import com.gasbooking.repository.ISurrenderCylinderRepository;

@Service
public class SurrenderCylinderServiceImpl implements ISurrenderCylinderService {

	@Autowired
	ISurrenderCylinderRepository surrendercylinderrepository;
	
	Logger logger=LoggerFactory.getLogger(SurrenderCylinderServiceImpl.class);

	@Override
	public SurrenderCylinder insertSurrenderCylinder(SurrenderCylinder sc) {

		logger.info("****************Inserting SurrenderCylinder Details****************");

		return surrendercylinderrepository.save(sc);
	}

	@Override
	public SurrenderCylinder updateSurrenderCylinder(int surrenderCylinderId, SurrenderCylinder sc) {
		
		logger.info("****************Updating SurrenderCylinder Details****************");

		Supplier s1 = () -> new ServiceException("Given Id is not found in the Database");
		SurrenderCylinder g1 = null;
		try {
			g1 = surrendercylinderrepository.findById(surrenderCylinderId).orElseThrow(s1);
			g1.setSurrenderDate(sc.getSurrenderDate());
			g1.setSurrenderId(sc.getSurrenderId());

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return g1;
	}

	@Override
	public SurrenderCylinder deleteSurrenderCylinder(int surrenderCylinderId) throws CylinderNotFoundException {
		
		logger.info("****************Deleting SurrenderCylinder Details****************");

		Optional<SurrenderCylinder> optional = surrendercylinderrepository.findById(surrenderCylinderId);
		
		if(optional.isPresent()) {
			SurrenderCylinder gotCylinder = optional.get();
			surrendercylinderrepository.delete(gotCylinder);
			return gotCylinder;
		}
		else {
			throw new CylinderNotFoundException("Cylinder not found");
		}

	}

	@Override
	public int CountSurrenderCylinders() {

		logger.info("****************Getting SurrenderCylinder Count****************");

		return (int) this.surrendercylinderrepository.count();
	}
}