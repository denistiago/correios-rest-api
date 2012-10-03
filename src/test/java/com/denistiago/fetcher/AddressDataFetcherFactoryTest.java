package com.denistiago.fetcher;

import org.junit.Assert;
import org.junit.Test;

public class AddressDataFetcherFactoryTest {

    @Test
    public void testFactoryMethod() {

        for(AddressSearchType type : AddressSearchType.values())  {
            AddressDataFetcher addressDataFetcher = AddressDataFetcherFactory.getInstance(type);
            Assert.assertNotNull(addressDataFetcher);
        }
    }

}
