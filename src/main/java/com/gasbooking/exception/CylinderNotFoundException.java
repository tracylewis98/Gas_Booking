package com.gasbooking.exception;

public class CylinderNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7176917789375606324L;
	
	public CylinderNotFoundException( String errormessage) {
		super(errormessage);
	}
	
    public CylinderNotFoundException () {
    	 
    }
	
}