package com.apap.tutorial4.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.repository.PilotDB;

@Service
@Transactional
public class PilotServiceImpl implements PilotService{
	
	@Autowired
	private PilotDB pilotDb;
	

	@Override
	public void addPilot(PilotModel pilot) {
		// TODO Auto-generated method stub
		pilotDb.save(pilot);
		
	}

	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}

	@Override
	public void deletePilot(PilotModel pilot) {
		// TODO Auto-generated method stub
		pilotDb.delete(pilot);
		
	}

	@Override
	public List<PilotModel> getListPilot() {
		// TODO Auto-generated method stub
		return pilotDb.findAll();
	}

	@Override
	public void updatePilot(PilotModel pilot, String licenseNumber) {
		// TODO Auto-generated method stub
		PilotModel old = pilotDb.findByLicenseNumber(licenseNumber);
		old.setFlyHour(pilot.getFlyHour());
		old.setName(pilot.getName());
		old.setLicenseNumber(old.getLicenseNumber());
		old.setId(old.getId());
		pilotDb.save(old);
		
	}

	


}
