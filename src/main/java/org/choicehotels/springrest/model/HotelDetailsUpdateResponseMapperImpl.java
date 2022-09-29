package org.choicehotels.springrest.model;

import org.choicehotels.springrest.client.gen.UpdateHotelResponse;
import org.choicehotels.springrest.mapper.Mapper;
import org.choicehotels.springrest.mapper.impl.AddressResponseMapperImpl;

public class HotelDetailsUpdateResponseMapperImpl implements Mapper<UpdateHotelResponse, HotelUpdateDetailsResponseDto> {


    @Override
    public HotelUpdateDetailsResponseDto map(UpdateHotelResponse source) {
        return HotelUpdateDetailsResponseDto.builder().setName(source.getName())
                .setRating(source.getRating())
                .setHotelId(source.getHotelId())
                .setAddress(new AddressResponseMapperImpl().map(source.getAddress()))
                .build();
    }
}
