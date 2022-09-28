package org.choicehotels.springrest.mapper.impl;

import org.choicehotels.springrest.client.gen.UpdateHotelAmenitiesResponse;
import org.choicehotels.springrest.mapper.Mapper;
import org.choicehotels.springrest.model.UpdatedAmenitiesResponseDto;

public class UpdateAmenitiesMapperImpl implements Mapper<UpdateHotelAmenitiesResponse, UpdatedAmenitiesResponseDto> {


    @Override
    public UpdatedAmenitiesResponseDto map(UpdateHotelAmenitiesResponse source) {
        return UpdatedAmenitiesResponseDto.builder().setHotelId(source.getHotelId())
                .setAmenities(source.getAmenities()).build();
    }
}
