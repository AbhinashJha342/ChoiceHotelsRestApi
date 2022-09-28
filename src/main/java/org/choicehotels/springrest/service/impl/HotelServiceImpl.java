package org.choicehotels.springrest.service.impl;

import org.choicehotels.springrest.client.ChoiceHotelSoapClient;
import org.choicehotels.springrest.client.gen.CreateHotelRequest;
import org.choicehotels.springrest.client.gen.CreateHotelResponse;
import org.choicehotels.springrest.client.gen.GetHotelDetailsRequest;
import org.choicehotels.springrest.client.gen.GetHotelDetailsResponse;
import org.choicehotels.springrest.mapper.impl.CreateHotelResponseMapperImpl;
import org.choicehotels.springrest.mapper.impl.HotelDetailsResponseMapperImpl;
import org.choicehotels.springrest.model.CreateHotelResponseDto;
import org.choicehotels.springrest.model.HotelDetailsResponseDto;
import org.choicehotels.springrest.service.BasicHotelService;
import org.springframework.stereotype.Service;

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
    public HotelDetailsResponseDto getHotelDetailsResponseDto(String hotelId) {
        System.out.println("before calling soap client");
        GetHotelDetailsRequest getHotelDetailsRequest = new GetHotelDetailsRequest();
        getHotelDetailsRequest.setHotelId(hotelId);
        GetHotelDetailsResponse getHotelDetailsResponse = soapClient.getHotelDetails(getHotelDetailsRequest);
        System.out.println(getHotelDetailsResponse);
        return new HotelDetailsResponseMapperImpl().map(getHotelDetailsResponse);
    }
}
