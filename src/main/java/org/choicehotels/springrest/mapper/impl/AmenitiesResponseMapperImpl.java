package org.choicehotels.springrest.mapper.impl;

import org.choicehotel.generated.CreateHotelAmenitiesResponse;
import org.choicehotels.springrest.mapper.Mapper;
import org.choicehotels.springrest.model.AmenitiesResponseDto;

public class AmenitiesResponseMapperImpl implements Mapper<CreateHotelAmenitiesResponse, AmenitiesResponseDto> {

    @Override
    public AmenitiesResponseDto map(CreateHotelAmenitiesResponse source) {
        if(null == source)
            return null;

        return AmenitiesResponseDto.builder().setHotelId(source.getHotelId())
                .setAmenities(source.getAmenities()).build();
    }
}
