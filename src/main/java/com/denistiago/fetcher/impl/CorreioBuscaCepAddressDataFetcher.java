package com.denistiago.fetcher.impl;

import com.denistiago.fetcher.AddressDataFetcher;
import com.denistiago.fetcher.exception.AddressDataFetcherException;
import com.denistiago.model.Address;

import java.util.List;

public class CorreioBuscaCepAddressDataFetcher implements AddressDataFetcher {

    @Override
    public List<Address> fetchAddressByPostalCode(String postalCode) throws AddressDataFetcherException {
        return null;
    }

    @Override
    public List<Address> fetchAddressByAddressDescription(String description) throws AddressDataFetcherException {
        return null;
    }
}
