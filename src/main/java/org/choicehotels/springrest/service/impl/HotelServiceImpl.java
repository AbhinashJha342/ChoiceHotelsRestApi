package org.choicehotels.springrest.service.impl;

import org.choicehotels.springrest.client.ChoiceHotelSoapClient;
import org.choicehotels.springrest.client.gen.CreateHotelRequest;
import org.choicehotels.springrest.client.gen.CreateHotelResponse;
import org.choicehotels.springrest.mapper.impl.CreateHotelResponseMapperImpl;
import org.choicehotels.springrest.model.CreateHotelResponseDto;
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
}
