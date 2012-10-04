package com.denistiago.rest;

import com.denistiago.model.Address;
import com.denistiago.service.CorreioService;
import com.denistiago.service.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value="/address")
public class CorreioRest {
	
	@Autowired
	private CorreioService correioService;
	
	@RequestMapping(value="/findByAddress", method=RequestMethod.GET)
	public Response<List<Address>> findByEndereco(@RequestParam("address") String addressDescription, @RequestParam(defaultValue = "mobile") String engine) {
		return correioService.findByAddress(addressDescription,engine);
	}

	@RequestMapping(value="/findByPostalCode", method=RequestMethod.GET)
	public Response<List<Address>> findByCEP(@RequestParam("pcode") String postalCode,@RequestParam(defaultValue = "mobile") String engine) {
		return correioService.findByPostalCode(postalCode,engine);
	}

}
