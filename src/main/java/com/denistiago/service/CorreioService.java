package com.denistiago.service;

import java.util.*;

import com.denistiago.fetcher.AddressDataFetcherFactory;
import com.denistiago.fetcher.AddressDataFetcher;
import com.denistiago.fetcher.AddressSearchType;
import com.denistiago.fetcher.exception.AddressDataFetcherException;
import com.denistiago.model.Address;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CorreioService {
	
	@Cacheable("address")
	public List<Address> findByAddress(String addressDescription, String engine) {

        AddressDataFetcher fetcher = AddressDataFetcherFactory.getInstance(AddressSearchType.toEnum(engine));
        try {
            return fetcher.fetchAddressByAddressDescription(addressDescription);
        } catch (AddressDataFetcherException e) {
            return Collections.emptyList();
        }
    }

    @Cacheable("address")
    public List<Address> findByPostalCode(String postalCode, String engine) {
        AddressDataFetcher fetcher = AddressDataFetcherFactory.getInstance(AddressSearchType.toEnum(engine));
        try {
            return fetcher.fetchAddressByPostalCode(postalCode);
        } catch (AddressDataFetcherException e) {
            return Collections.emptyList();
        }
    }
	
}
