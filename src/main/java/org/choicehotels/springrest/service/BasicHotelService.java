package org.choicehotels.springrest.service;

import org.choicehotels.springrest.client.gen.CreateHotelAmenitiesRequest;
import org.choicehotels.springrest.client.gen.CreateHotelRequest;
import org.choicehotels.springrest.client.gen.UpdateHotelAmenitiesRequest;
import org.choicehotels.springrest.model.AmenitiesResponseDto;
import org.choicehotels.springrest.model.CreateHotelResponseDto;
import org.choicehotels.springrest.model.HotelDetailsResponseDto;
import org.choicehotels.springrest.model.UpdatedAmenitiesResponseDto;

public interface BasicHotelService {

    CreateHotelResponseDto createHotel(CreateHotelRequest createHotelRequest);

    HotelDetailsResponseDto getHotelDetailsResponseDto(String hotelId);

    AmenitiesResponseDto createHotelAmenities(CreateHotelAmenitiesRequest createHotelAmenitiesRequest);

    UpdatedAmenitiesResponseDto updatedAmenities(UpdateHotelAmenitiesRequest amenitiesRequest);
}
