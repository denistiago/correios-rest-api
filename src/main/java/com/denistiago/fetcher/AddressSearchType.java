package com.denistiago.fetcher;

public enum AddressSearchType {
    MOBILE,
    BUSCACEP;

    public static AddressSearchType toEnum(String value) {

        for(AddressSearchType adtype : AddressSearchType.values()) {
            if( value.equalsIgnoreCase(adtype.name()) ) {
                return adtype;
            }
        }
        return MOBILE;
    }
}
