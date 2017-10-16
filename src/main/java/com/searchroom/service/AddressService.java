package com.searchroom.service;

import com.searchroom.model.Address;

public interface AddressService {

    Address getLatLngByAddress(String address) throws Exception;

}
