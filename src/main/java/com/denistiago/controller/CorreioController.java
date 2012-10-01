package com.denistiago.controller;

import java.util.List;

import com.denistiago.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.denistiago.service.CorreioService;

@Controller
@RequestMapping(value="/address")
public class CorreioController {
	
	@Autowired
	private CorreioService correioService;
	
	@RequestMapping(value="/findByAddress", method=RequestMethod.GET)
	public List<Address> findByEndereco(@RequestParam("address") String endereco) {
		return correioService.findByAddress(endereco);
	}

	@RequestMapping(value="/findByPostalCode", method=RequestMethod.GET)
	public List<Address> findByCEP(@RequestParam("pcode") String postalCode) {
		return correioService.findByPostalCode(postalCode);
	}

}
