package org.choicehotels.springrest.mapper.impl;

import org.choicehotel.generated.CreateHotelResponse;
import org.choicehotels.springrest.mapper.Mapper;
import org.choicehotels.springrest.model.CreateHotelResponseDto;

public class CreateHotelResponseMapperImpl implements Mapper<CreateHotelResponse, CreateHotelResponseDto> {


    @Override
    public CreateHotelResponseDto map(CreateHotelResponse source) {
        CreateHotelResponseDto createHotelResponseDto = CreateHotelResponseDto.builder().setHotelId(source.getHotelId()).build();
        return createHotelResponseDto;
    }
}
