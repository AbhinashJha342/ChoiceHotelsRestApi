package org.choicehotels.springrest.mapper.impl;

import org.choicehotels.springrest.client.gen.GetHotelDetailsResponse;
import org.choicehotels.springrest.mapper.Mapper;
import org.choicehotels.springrest.model.HotelDetailsResponseDto;

public class HotelDetailsResponseMapperImpl implements Mapper<GetHotelDetailsResponse, HotelDetailsResponseDto> {


    @Override
    public HotelDetailsResponseDto map(GetHotelDetailsResponse source) {
        if(null == source)
            return null;

        return HotelDetailsResponseDto.builder().setHotelId(source.getHotelId())
                .setName(source.getName()).setRating(source.getRating()).setAmenities(source.getAmenities())
                .setAddress(new AddressResponseMapperImpl().map(source.getAddress())).build();
    }
}
