package org.choicehotels.springrest.client;

import org.choicehotel.generated.*;
import org.choicehotels.springrest.exception.GlobalExceptionResolver;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;

@Service
public class ChoiceHotelSoapClient {

    private final Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    private final GlobalExceptionResolver exceptionResolver;

    public ChoiceHotelSoapClient(Jaxb2Marshaller marshaller, GlobalExceptionResolver exceptionResolver) {
        this.marshaller = marshaller;
        template = new WebServiceTemplate(marshaller);
        this.exceptionResolver = exceptionResolver;
    }

    public CreateHotelResponse createHotel(CreateHotelRequest createHotelRequest){
        CreateHotelResponse hotelResponse = null;
        hotelResponse = (CreateHotelResponse) handleSoapCall(createHotelRequest);
        return hotelResponse;
    }

    public GetHotelDetailsResponse getHotelDetails(GetHotelDetailsRequest getHotelDetailsRequest){
        GetHotelDetailsResponse hotelResponse = null;
        hotelResponse = (GetHotelDetailsResponse) handleSoapCall(getHotelDetailsRequest);
        return hotelResponse;
    }

    public UpdateHotelResponse updateHotelDetails(UpdateHotelRequest updateHotelRequest){
        UpdateHotelResponse updateHotelResponse = null;
        updateHotelResponse = (UpdateHotelResponse) handleSoapCall(updateHotelRequest);
        return updateHotelResponse;
    }

    public CreateHotelAmenitiesResponse createHotelAmenities(CreateHotelAmenitiesRequest createHotelAmenitiesRequest){
        CreateHotelAmenitiesResponse amenitiesResponseDto;
        amenitiesResponseDto = (CreateHotelAmenitiesResponse) handleSoapCall(createHotelAmenitiesRequest);
        return amenitiesResponseDto;
    }

    public UpdateHotelAmenitiesResponse updateHotelAmenities(UpdateHotelAmenitiesRequest updateHotelAmenitiesRequest){
        UpdateHotelAmenitiesResponse amenitiesResponseDto;
        amenitiesResponseDto = (UpdateHotelAmenitiesResponse) handleSoapCall(updateHotelAmenitiesRequest);
        return amenitiesResponseDto;
    }

    public GetHotelByNameResponse getHotelDetailsByName(GetHotelByNameRequest getHotelByNameRequest){
        GetHotelByNameResponse hotelByNameResponse;
        hotelByNameResponse = (GetHotelByNameResponse) handleSoapCall(getHotelByNameRequest);
        return hotelByNameResponse;
    }

    public DeleteHotelResponse archive(DeleteHotelRequest deleteHotelRequest) {
        DeleteHotelResponse deleteHotelResponse;
        deleteHotelResponse = (DeleteHotelResponse) handleSoapCall(deleteHotelRequest);
        return deleteHotelResponse;
    }

    private Object handleSoapCall(Object object) {
       try{
           return template.marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", object);
       } catch(SoapFaultClientException ex){
           throw exceptionResolver.parseSoapException(ex);
       }
    }
}
