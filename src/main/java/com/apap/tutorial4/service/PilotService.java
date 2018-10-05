package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.PilotModel;

public interface PilotService {
	void addPilot(PilotModel pilot);
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	void deletePilot (PilotModel pilot) ;
	List <PilotModel> getListPilot();
	void updatePilot(PilotModel pilot, String licenseNumber);
	
}
