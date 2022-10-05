package org.choicehotels.springrest.client;

import org.choicehotel.generated.*;
import org.choicehotels.springrest.exception.GlobalExceptionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;

@Service
public class ChoiceHotelSoapClient {

    private final WebServiceTemplate template;

    private final GlobalExceptionResolver exceptionResolver;

    @Autowired
    private Environment environment;

    public ChoiceHotelSoapClient(GlobalExceptionResolver exceptionResolver, WebServiceTemplate template) {
        this.exceptionResolver = exceptionResolver;
        this.template = template;
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
           return template.marshalSendAndReceive(environment.getProperty("soap.wsdl.path"), object);
       } catch(SoapFaultClientException ex){
           throw exceptionResolver.parseSoapException(ex);
       } catch(WebServiceIOException ex){
           throw ex;
       }
    }
}
