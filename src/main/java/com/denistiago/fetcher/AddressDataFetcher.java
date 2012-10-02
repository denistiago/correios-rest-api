package com.denistiago.fetcher;

import com.denistiago.fetcher.exception.AddressDataFetcherException;
import com.denistiago.model.Address;

import java.util.List;

public interface AddressDataFetcher {

    public List<Address> fetchAddressByPostalCode(String postalCode) throws AddressDataFetcherException;

    public List<Address> fetchAddressByAddressDescription(String description) throws AddressDataFetcherException;

}
