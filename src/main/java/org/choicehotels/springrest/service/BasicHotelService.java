package org.choicehotels.springrest.service;

import org.choicehotels.springrest.client.gen.CreateHotelRequest;
import org.choicehotels.springrest.model.CreateHotelResponseDto;

public interface BasicHotelService {

    CreateHotelResponseDto createHotel(CreateHotelRequest createHotelRequest);


}
