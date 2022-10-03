package org.choicehotels.springrest.mapper.impl;

import org.choicehotel.generated.UpdateHotelResponse;
import org.choicehotels.springrest.mapper.Mapper;
import org.choicehotels.springrest.mapper.impl.AddressResponseMapperImpl;
import org.choicehotels.springrest.model.HotelUpdateDetailsResponseDto;

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
