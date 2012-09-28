package com.denistiago.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.denistiago.core.CorreioService;
import com.denistiago.model.Endereco;

@Controller
@RequestMapping(value="/endereco")
public class CorreioController {
	
	@Autowired
	private CorreioService correioService;
	
	@RequestMapping(value="/findBy", method=RequestMethod.GET)
	public List<Endereco> findByEndereco(@RequestParam("endereco") String endereco) {		
		return correioService.findByAddress(endereco);
	}

}
