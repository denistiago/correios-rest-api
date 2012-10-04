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

public class CorreioMobileServiceAddressDataFetcher implements AddressDataFetcher {

    private final String PARAM_CEP_OR_ADDRESS = "cepEntrada";
    private final String PARAM_METHOD_SEARCH = "metodo";
    private final String SEARCH_TYPE = "buscarCep";
    private final String MOBILE_CORREIO_SERVICE = "http://m.correios.com.br/movel/buscaCepConfirma.do";

    @Override
    public List<Address> fetchAddressByPostalCode(String postalCode) throws AddressDataFetcherException {
        return fetchAndParseData(postalCode);
    }

    @Override
    public List<Address> fetchAddressByAddressDescription(String description) throws AddressDataFetcherException{
        return fetchAndParseData(description);
    }
    
    private List<Address> fetchAndParseData(String descriptionOrPostalCode) throws AddressDataFetcherException {
        return parse(fetch(descriptionOrPostalCode));
    }

    private Document fetch(String descriptionOrPostalCode) throws AddressDataFetcherException {

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(PARAM_CEP_OR_ADDRESS, descriptionOrPostalCode);
        parameters.put(PARAM_METHOD_SEARCH, SEARCH_TYPE);

        Document doc = null;
        try {
            doc = Jsoup
                    .connect(MOBILE_CORREIO_SERVICE)
                    .timeout(10000)
                    .data(parameters)
                    .post();

        } catch (IOException e) {
            throw new AddressDataFetcherException("Can not connect to mobile service endpoint",e);
        }

        return doc;
    }

    private List<Address> parse(Document document) {

        List<Address> addressList = new ArrayList<Address>();

        Elements divAddress = document.select(".caixacampobranco, .caixacampoazul");

        Iterator<Element> iterator = divAddress.iterator();

        while (iterator.hasNext()) {

            Address address = new Address();

            Element divEndereco = iterator.next();
            Elements spanLogradouro = divEndereco.select(".respostadestaque").eq(0);
            address.setLogradouro(spanLogradouro.text());
            Elements spanBairro = divEndereco.select(".respostadestaque").eq(1);
            address.setBairro(spanBairro.text());
            Elements spanLocalidade = divEndereco.select(".respostadestaque").eq(2);
            address.setLocalidade(spanLocalidade.text());
            Elements spanPostalCode = divEndereco.select(".respostadestaque").eq(3);
            address.setCep(spanPostalCode.text());



            addressList.add(address);

        }

        return addressList;
    }

}
