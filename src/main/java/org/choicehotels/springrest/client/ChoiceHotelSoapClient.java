package org.choicehotels.springrest.client;

import org.choicehotels.springrest.client.gen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class ChoiceHotelSoapClient {

    private final Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    @Autowired
    public ChoiceHotelSoapClient(Jaxb2Marshaller marshaller) {
        this.marshaller = marshaller;
        template = new WebServiceTemplate(marshaller);
    }

    public CreateHotelResponse createHotel(CreateHotelRequest createHotelRequest){
        CreateHotelResponse hotelResponse;
        hotelResponse = (CreateHotelResponse) template.marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", createHotelRequest);
        return hotelResponse;
    }

    public GetHotelDetailsResponse getHotelDetails(GetHotelDetailsRequest getHotelDetailsRequest){
        GetHotelDetailsResponse hotelResponse;
        hotelResponse = (GetHotelDetailsResponse) template.marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", getHotelDetailsRequest);
        return hotelResponse;
    }

    public CreateHotelAmenitiesResponse createHotelAmenities(CreateHotelAmenitiesRequest createHotelAmenitiesRequest){
        CreateHotelAmenitiesResponse amenitiesResponseDto;
        amenitiesResponseDto = (CreateHotelAmenitiesResponse) template.marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", createHotelAmenitiesRequest);
        return amenitiesResponseDto;
    }

    public UpdateHotelAmenitiesResponse updateHotelAmenities(UpdateHotelAmenitiesRequest updateHotelAmenitiesRequest){
        UpdateHotelAmenitiesResponse amenitiesResponseDto;
        amenitiesResponseDto = (UpdateHotelAmenitiesResponse) template.marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", updateHotelAmenitiesRequest);
        return amenitiesResponseDto;
    }

    public GetHotelByNameResponse getHotelDetailsByName(GetHotelByNameRequest getHotelByNameRequest){
        GetHotelByNameResponse hotelByNameResponse;
        hotelByNameResponse = (GetHotelByNameResponse) template.marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", getHotelByNameRequest);
        return hotelByNameResponse;
    }

    public DeleteHotelResponse archive(DeleteHotelRequest deleteHotelRequest) {
        DeleteHotelResponse deleteHotelResponse;
        deleteHotelResponse = (DeleteHotelResponse) template.marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", deleteHotelRequest);
        return deleteHotelResponse;
    }
}
