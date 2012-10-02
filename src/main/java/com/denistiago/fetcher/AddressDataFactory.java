package com.denistiago.fetcher;

import com.denistiago.fetcher.impl.CorreioMobileServiceAddressDataFetcher;

public final class AddressDataFactory {

    public enum AddressDataEnum {
        CORREIO_MOBILE,
        BUSCACEP
    }

    private AddressDataFactory() {}

    public static AddressDataFetcher getInstance(AddressDataEnum addressDataEnum) {

        switch (addressDataEnum) {
            case BUSCACEP:
                throw new IllegalArgumentException();
            case CORREIO_MOBILE:
                return new CorreioMobileServiceAddressDataFetcher();
        }

        return null;
    }

}
