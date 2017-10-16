package com.searchroom.service.impl;

import com.searchroom.model.Address;
import com.searchroom.service.AddressService;
import com.searchroom.utils.geolocation.AddressConverter;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    public Address getLatLngByAddress(String address) throws Exception {
        Address addr = new Address();
        addr.setAddress(address);
        String[] latlong = AddressConverter.getLatLongPositions(address);

        if (latlong == null) {
            addr.setLatitude("0");
            addr.setLongitude("0");
        } else {
            addr.setLatitude(latlong[0]);
            addr.setLongitude(latlong[1]);
        }

        return addr;
    }
}
