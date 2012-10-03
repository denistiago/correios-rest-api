package com.denistiago.fetcher;

import com.denistiago.fetcher.impl.CorreioBuscaCepAddressDataFetcher;
import com.denistiago.fetcher.impl.CorreioMobileServiceAddressDataFetcher;

public final class AddressDataFetcherFactory {



    private AddressDataFetcherFactory() {}

    public static AddressDataFetcher getInstance(AddressSearchType addressDataEnum) {

        switch (addressDataEnum) {
            case BUSCACEP:
                return new CorreioBuscaCepAddressDataFetcher();
            case MOBILE:
                return new CorreioMobileServiceAddressDataFetcher();
        }

        return null;
    }

}
