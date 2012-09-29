package com.denistiago.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.denistiago.model.Endereco;

@Service
public class CorreioService {
	
	@Cacheable("enderecos")
	public List<Endereco> findByAddress(String rua) {

		List<Endereco> enderecos = new ArrayList<Endereco>();
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("cepEntrada", rua);
		parameters.put("metodo", "buscarCep");

		Document doc = null;
		try {
			doc = Jsoup
					.connect("http://m.correios.com.br/movel/buscaCepConfirma.do")
					.data(parameters)
					.post();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements divEnderecos = doc.select(".caixacampobranco, .caixacampoazul");

		Iterator<Element> iterator = divEnderecos.iterator();
		while (iterator.hasNext()) {
			
			Endereco endereco = new Endereco();
			
			Element divEndereco = iterator.next();
			Elements spanLogradouro = divEndereco.select(".respostadestaque").eq(0);
			endereco.setLogradouro(spanLogradouro.text());
			Elements bairro = divEndereco.select(".respostadestaque").eq(1);
			endereco.setBairro(bairro.text());
			Elements cidade = divEndereco.select(".respostadestaque").eq(2);
			endereco.setLocalidade(cidade.text());
			Elements cep = divEndereco.select(".respostadestaque").eq(3);
			endereco.setCep(cep.text());
			
			
			enderecos.add(endereco);

		}

		return enderecos;
	}
	
}
