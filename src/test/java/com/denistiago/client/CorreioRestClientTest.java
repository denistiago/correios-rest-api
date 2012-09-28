package com.denistiago.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.denistiago.model.Endereco;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-beans.xml" })
public class CorreioRestClientTest {

	@Autowired
	@Qualifier("restTemplate")
	private RestTemplate restTemplate;	
		
	@SuppressWarnings("unchecked")
	@Test
	public void testFindByAddress() {
		
		Map<String,String> parameters = new HashMap<String, String>();
		parameters.put("endereco", "rua irene garcia");
		List<Endereco> enderecos = (ArrayList<Endereco>) restTemplate.getForObject("http://localhost:8080/correios-rest/rest/endereco/findBy?endereco={endereco}", 
																				List.class,
																				parameters);
		Assert.assertNotNull(enderecos);
		Assert.assertTrue(enderecos.size() > 0);
	}
}
