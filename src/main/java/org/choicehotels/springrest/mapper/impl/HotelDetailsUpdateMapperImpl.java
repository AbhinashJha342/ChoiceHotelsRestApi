package org.choicehotels.springrest.mapper.impl;

import org.choicehotel.generated.UpdateHotelRequest;
import org.choicehotels.springrest.mapper.Mapper;
import org.choicehotels.springrest.model.HotelUpdateDetailsRequestDto;

public class HotelDetailsUpdateMapperImpl implements Mapper<HotelUpdateDetailsRequestDto, UpdateHotelRequest> {

    @Override
    public UpdateHotelRequest map(HotelUpdateDetailsRequestDto source) {
        UpdateHotelRequest updateHotelRequest = new UpdateHotelRequest();
        updateHotelRequest.setName(source.getName());
        updateHotelRequest.setRating(source.getRating());
        updateHotelRequest.setAddress(new AddressDtoMapperImpl().map(source.getAddress()));
        return updateHotelRequest;
    }
}
