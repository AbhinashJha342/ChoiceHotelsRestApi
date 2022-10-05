package org.choicehotels.springrest.mapper.impl;

import org.choicehotel.generated.CreateHotelRequest;
import org.choicehotels.springrest.mapper.Mapper;
import org.choicehotels.springrest.model.CreateHotelRequestDto;

public class CreateHotelRequestMapperImpl implements Mapper<CreateHotelRequestDto, CreateHotelRequest> {


    @Override
    public CreateHotelRequest map(CreateHotelRequestDto source) {
        CreateHotelRequest createHotelRequest = new CreateHotelRequest();
        createHotelRequest.setName(source.getName());
        createHotelRequest.setRating(String.valueOf(source.getRating()));
        createHotelRequest.setAddress(new AddressDtoMapperImpl().map(source.getAddress()));
        return createHotelRequest;
    }
}
