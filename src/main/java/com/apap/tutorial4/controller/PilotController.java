package com.apap.tutorial4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.service.FlightService;
import com.apap.tutorial4.service.PilotService;

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	private PilotModel pilotUpdate;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
	private String view(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel archive= pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		
		List<FlightModel> flightList = archive.getPilotFlight();
		
		model.addAttribute("flightList", flightList);
		model.addAttribute("pilot", archive);
		
		
		
		return "view-pilot";
	}
	
	@RequestMapping(value = "/pilot/viewallflight/", method = RequestMethod.GET)
	private String viewall(Model model) {
		List<PilotModel> pilotList = pilotService.getListPilot();
		
		model.addAttribute("pilotList", pilotList);
		
		
		
		return "viewall-flight";
	}
	
	@RequestMapping(value = "/pilot/deletePilot", method = RequestMethod.GET)
	private String deletePilot(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel archive= pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		
		pilotService.deletePilot(archive);
		return "delete";
	}


	
	
	
	
	

	
	@RequestMapping(value="/pilot/updatePilot/{licenseNumber}", method= RequestMethod.GET)
	private String updatePilot(@PathVariable String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", pilot);
		return "updatePilot";
	}
	
	@RequestMapping(value="/pilot/updatePilot/{licenseNumber}", method=RequestMethod.POST)
	private String updatePilot(@PathVariable String licenseNumber, @ModelAttribute PilotModel pilot) {
		pilotService.updatePilot(pilot, licenseNumber);
		return "update";
	}
	
	
}
