package org.choicehotels.springrest.service;

import org.choicehotel.generated.CreateHotelAmenitiesRequest;
import org.choicehotel.generated.UpdateHotelAmenitiesRequest;
import org.choicehotels.springrest.model.*;

import java.util.List;

public interface BasicHotelService {

    CreateHotelResponseDto createHotel(CreateHotelRequestDto createHotelRequest);

    HotelDetailsResponseDto getHotelDetails(String hotelId);

    AmenitiesResponseDto createHotelAmenities(CreateHotelAmenitiesRequest createHotelAmenitiesRequest);

    HotelUpdateDetailsResponseDto updateHotelDetails(HotelUpdateDetailsRequestDto hotelUpdateDetailsRequestDto, String hotelId);

    UpdatedAmenitiesResponseDto updatedAmenities(UpdateHotelAmenitiesRequest amenitiesRequest);

    List<HotelDetailsResponseDto> getHotelDetailsByName(String hotelId);

    void archive(String hotelId);
}
