package com.denistiago.fetcher.impl;

import com.denistiago.fetcher.AddressDataFetcher;
import com.denistiago.fetcher.exception.AddressDataFetcherException;
import com.denistiago.model.Address;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class CorreioBuscaCepAddressDataFetcher implements AddressDataFetcher {

    @Override
    public List<Address> fetchAddressByPostalCode(String postalCode) throws AddressDataFetcherException {
        return fetchAndParseAddressData(postalCode);
    }

    @Override
    public List<Address> fetchAddressByAddressDescription(String description) throws AddressDataFetcherException {
        return fetchAndParseAddressData(description);
    }
    
    private List<Address> fetchAndParseAddressData(String postalCodeOrDescription) throws AddressDataFetcherException {
        return parse(fetchByAddressDescription(postalCodeOrDescription));
    }

    private org.jsoup.nodes.Document fetchByAddressDescription(String addressDescription) throws AddressDataFetcherException {

        Map<String, String> params = new HashMap<String, String>();
        params.put("relaxation",addressDescription);
        params.put("TipoCep","ALL");
        params.put("semelhante","N");
        params.put("cfm","1");
        params.put("Metodo","listaLogradouro");
        params.put("TipoConsulta","relaxation");
        params.put("StartRow","1");
        params.put("EndRow","10");

        try {

            return Jsoup.connect("http://www.buscacep.correios.com.br/servicos/dnec/consultaEnderecoAction.do")
                        .timeout(20000)
                        .data(params)
                        .header("Origin", "http://www.buscacep.correios.com.br")
                        .header("Referer", "http://www.buscacep.correios.com.br")
                        .header("Host", "www.buscacep.correios.com.br")
                        .header("User-Agent","Mozilla/5.0 (iPad; CPU OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3")
                        .post();

        } catch (IOException e) {
            throw new AddressDataFetcherException("Can´t connect to buscacep service endpoint",e);
        }

    }
    
    private List<Address> parse(Document doc) {

        List<Address> listAddress = new ArrayList<Address>();

        Elements elements = doc.select("table").eq(2);
        Elements rows = elements.select("tr");


        Iterator<Element> rowIterator = rows.iterator();
        while(rowIterator.hasNext()) {

            Address address = new Address();

            Element element = rowIterator.next();
            Elements street = element.children().select("td").eq(0);
            address.setLogradouro(street.text());
            Elements neighborhood = element.children().select("td").eq(1);
            address.setBairro(neighborhood.text());
            Elements city = element.children().select("td").eq(2);
            Elements state = element.children().select("td").eq(3);
            StringBuilder sbLocalidade = new StringBuilder();
            sbLocalidade.append(city.text());
            sbLocalidade.append("/");
            sbLocalidade.append(state.text());
            address.setLocalidade(sbLocalidade.toString());
            Elements postalCode = element.children().select("td").eq(4);
            address.setCep(postalCode.text());

            listAddress.add(address);
        }

        return listAddress;
    }
}
