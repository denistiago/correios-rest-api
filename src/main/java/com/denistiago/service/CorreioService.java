package com.denistiago.service;

import java.io.IOException;
import java.util.*;

import com.denistiago.fetcher.AddressDataFactory;
import com.denistiago.fetcher.AddressDataFetcher;
import com.denistiago.fetcher.exception.AddressDataFetcherException;
import com.denistiago.model.Address;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CorreioService {
	
	@Cacheable("address")
	public List<Address> findByAddress(String street) {
        AddressDataFetcher fetcher = AddressDataFactory.getInstance(AddressDataFactory.AddressDataEnum.CORREIO_MOBILE);
        try {
            return fetcher.fetchAddressByAddressDescription(street);
        } catch (AddressDataFetcherException e) {
            return Collections.emptyList();
        }
    }

    @Cacheable("address")
    public List<Address> findByPostalCode(String postalCode) {
        AddressDataFetcher fetcher = AddressDataFactory.getInstance(AddressDataFactory.AddressDataEnum.CORREIO_MOBILE);
        try {
            return fetcher.fetchAddressByPostalCode(postalCode);
        } catch (AddressDataFetcherException e) {
            return Collections.emptyList();
        }
    }
	
}
