package com.denistiago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denistiago.fetcher.AddressDataFetcher;
import com.denistiago.fetcher.AddressDataFetcherFactory;
import com.denistiago.fetcher.AddressSearchType;
import com.denistiago.model.Address;

@Service
public class CorreioService {
	
	@Autowired
	private ResponseBuilder addressResponseBuilder;
	
	public Response<List<Address>> findByAddress(String addressDescription, String engine) {
		AddressDataFetcher fetcher = AddressDataFetcherFactory.getInstance(AddressSearchType.toEnum(engine));
        return buildResponse(fetcher.fetchAddressByAddressDescription(addressDescription));
    }

    public Response<List<Address>> findByPostalCode(String postalCode, String engine) {
        AddressDataFetcher fetcher = AddressDataFetcherFactory.getInstance(AddressSearchType.toEnum(engine));
        return buildResponse(fetcher.fetchAddressByPostalCode(postalCode));       
    }
	
	private Response<List<Address>> buildResponse(
			List<Address> addressList) {
		return addressResponseBuilder.buildResponse(addressList);
	}
	
}
