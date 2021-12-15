package com.gasbooking.service;

import com.gasbooking.entity.SurrenderCylinder;
import com.gasbooking.exception.CylinderNotFoundException;

public interface ISurrenderCylinderService {
	
	public SurrenderCylinder insertSurrenderCylinder(SurrenderCylinder sc);
	
	public SurrenderCylinder updateSurrenderCylinder(int surrenderCylinderId, SurrenderCylinder sc);
	
	public SurrenderCylinder deleteSurrenderCylinder(int surrenderCylinderId) throws CylinderNotFoundException;
	
	public int CountSurrenderCylinders();

}