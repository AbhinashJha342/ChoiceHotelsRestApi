package org.choicehotels.springrest.service.impl;

import org.choicehotels.springrest.client.ChoiceHotelSoapClient;
import org.choicehotels.springrest.client.gen.*;
import org.choicehotels.springrest.mapper.impl.*;
import org.choicehotels.springrest.model.AmenitiesResponseDto;
import org.choicehotels.springrest.model.CreateHotelResponseDto;
import org.choicehotels.springrest.model.HotelDetailsResponseDto;
import org.choicehotels.springrest.model.UpdatedAmenitiesResponseDto;
import org.choicehotels.springrest.service.BasicHotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements BasicHotelService {


    private final ChoiceHotelSoapClient soapClient;


    public HotelServiceImpl(ChoiceHotelSoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @Override
    public CreateHotelResponseDto createHotel(CreateHotelRequest createHotelRequest) {
        CreateHotelResponse createHotelResponse = soapClient.createHotel(createHotelRequest);
        return new CreateHotelResponseMapperImpl().map(createHotelResponse);
    }

    @Override
    public HotelDetailsResponseDto getHotelDetails(String hotelId) {
        GetHotelDetailsRequest getHotelDetailsRequest = new GetHotelDetailsRequest();
        getHotelDetailsRequest.setHotelId(hotelId);
        GetHotelDetailsResponse getHotelDetailsResponse = soapClient.getHotelDetails(getHotelDetailsRequest);
        return new HotelDetailsResponseMapperImpl().map(getHotelDetailsResponse);
    }

    @Override
    public AmenitiesResponseDto createHotelAmenities(CreateHotelAmenitiesRequest createHotelAmenitiesRequest) {
        CreateHotelAmenitiesResponse amenitiesResponseDto = soapClient.createHotelAmenities(createHotelAmenitiesRequest);
        return new AmenitiesResponseMapperImpl().map(amenitiesResponseDto);
    }

    @Override
    public UpdatedAmenitiesResponseDto updatedAmenities(UpdateHotelAmenitiesRequest amenitiesRequest) {
        UpdateHotelAmenitiesResponse updateHotelAmenitiesResponse = soapClient.updateHotelAmenities(amenitiesRequest);
        return new UpdateAmenitiesMapperImpl().map(updateHotelAmenitiesResponse);
    }

    @Override
    public List<HotelDetailsResponseDto> getHotelDetailsByName(String hotelName) {
        GetHotelByNameRequest hotelByNameRequest = new GetHotelByNameRequest();
        hotelByNameRequest.setName(hotelName);
        GetHotelByNameResponse hotelByNameResponse = soapClient.getHotelDetailsByName(hotelByNameRequest);
        return hotelByNameResponse.getHotelDetails().stream().map(hotelsByNameResponse -> new HotelDetailsByNameMapperImpl().map(hotelsByNameResponse)).collect(Collectors.toList());
    }

    @Override
    public void archive(String hotelId) {
        DeleteHotelRequest deleteHotelRequest = new DeleteHotelRequest();
        deleteHotelRequest.setHotelId(hotelId);
        soapClient.archive(deleteHotelRequest);
    }
}
