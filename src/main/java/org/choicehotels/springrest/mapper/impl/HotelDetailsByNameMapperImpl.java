package org.choicehotels.springrest.mapper.impl;

import org.choicehotels.springrest.client.gen.HotelsByNameResponse;
import org.choicehotels.springrest.mapper.Mapper;
import org.choicehotels.springrest.model.HotelDetailsResponseDto;

public class HotelDetailsByNameMapperImpl implements Mapper<HotelsByNameResponse, HotelDetailsResponseDto> {

    @Override
    public HotelDetailsResponseDto map(HotelsByNameResponse source) {
        return HotelDetailsResponseDto.builder().setHotelId(source.getHotelId())
                .setName(source.getName()).setRating(source.getRating())
                .setAmenities(source.getAmenities())
                .setAddress(new AddressResponseMapperImpl().map(source.getAddress()))
                .build();
    }
}
