package org.choicehotels.springrest.client;

import org.choicehotels.springrest.client.gen.CreateHotelRequest;
import org.choicehotels.springrest.client.gen.CreateHotelResponse;
import org.choicehotels.springrest.client.gen.GetHotelDetailsRequest;
import org.choicehotels.springrest.client.gen.GetHotelDetailsResponse;
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
        new CreateHotelResponse();
        CreateHotelResponse hotelResponse;
        hotelResponse = (CreateHotelResponse) template.marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", createHotelRequest);
        return hotelResponse;
    }

    public GetHotelDetailsResponse getHotelDetails(GetHotelDetailsRequest getHotelDetailsRequest){
        template = new WebServiceTemplate(marshaller);
        new GetHotelDetailsResponse();
        GetHotelDetailsResponse hotelResponse;
        hotelResponse = (GetHotelDetailsResponse) template.marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", getHotelDetailsRequest);
        System.out.println("after client is called");
        return hotelResponse;
    }
}
