package org.choicehotels.springrest.service;

import org.choicehotels.springrest.client.gen.CreateHotelAmenitiesRequest;
import org.choicehotels.springrest.client.gen.CreateHotelRequest;
import org.choicehotels.springrest.client.gen.UpdateHotelAmenitiesRequest;
import org.choicehotels.springrest.model.AmenitiesResponseDto;
import org.choicehotels.springrest.model.CreateHotelResponseDto;
import org.choicehotels.springrest.model.HotelDetailsResponseDto;
import org.choicehotels.springrest.model.UpdatedAmenitiesResponseDto;

import java.util.List;

public interface BasicHotelService {

    CreateHotelResponseDto createHotel(CreateHotelRequest createHotelRequest);

    HotelDetailsResponseDto getHotelDetails(String hotelId);

    AmenitiesResponseDto createHotelAmenities(CreateHotelAmenitiesRequest createHotelAmenitiesRequest);

    UpdatedAmenitiesResponseDto updatedAmenities(UpdateHotelAmenitiesRequest amenitiesRequest);

    List<HotelDetailsResponseDto> getHotelDetailsByName(String hotelId);

    void archive(String hotelId);
}
