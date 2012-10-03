package com.denistiago.fetcher.impl;

import com.denistiago.fetcher.exception.AddressDataFetcherException;
import com.denistiago.model.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class CorreioBuscaCepAddressDataFetcherTest {


    CorreioBuscaCepAddressDataFetcher fetcher;

    @Before
    public void setUp() {
        fetcher = new CorreioBuscaCepAddressDataFetcher();
    }


    @Test
    public void testFetchAddressByDescription() throws AddressDataFetcherException {
        List<Address> addresses = fetcher.fetchAddressByAddressDescription("av fagundes filho");
        Assert.assertNotNull(addresses);
        Assert.assertTrue(addresses.size() > 0);
    }

    @Test
    public void testFetchAddressByPostalCode() throws AddressDataFetcherException {
        List<Address> addresses = fetcher.fetchAddressByPostalCode("04304000");
        Assert.assertNotNull(addresses);
        Assert.assertTrue(addresses.size() == 1);

    }

}
