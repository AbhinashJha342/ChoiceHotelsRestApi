package org.choicehotels.springrest.client;

import org.choicehotels.springrest.client.gen.*;
import org.choicehotels.springrest.model.AmenitiesResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.net.ConnectException;

@Service
public class ChoiceHotelSoapClient {

    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public CreateHotelResponse createHotel(CreateHotelRequest createHotelRequest){
        template = new WebServiceTemplate(marshaller);
        CreateHotelResponse hotelResponse;
        hotelResponse = (CreateHotelResponse) template.marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", createHotelRequest);
        return hotelResponse;
    }

    public GetHotelDetailsResponse getHotelDetails(GetHotelDetailsRequest getHotelDetailsRequest){
        template = new WebServiceTemplate(marshaller);
        GetHotelDetailsResponse hotelResponse;
        hotelResponse = (GetHotelDetailsResponse) template.marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", getHotelDetailsRequest);
        return hotelResponse;
    }

    public CreateHotelAmenitiesResponse createHotelAmenities(CreateHotelAmenitiesRequest createHotelAmenitiesRequest){
        template = new WebServiceTemplate(marshaller);
        CreateHotelAmenitiesResponse amenitiesResponseDto;
        amenitiesResponseDto = (CreateHotelAmenitiesResponse) template.marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", createHotelAmenitiesRequest);
        return amenitiesResponseDto;
    }
}
