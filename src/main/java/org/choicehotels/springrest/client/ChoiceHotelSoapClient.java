package org.choicehotels.springrest.client;

import org.choicehotels.springrest.client.gen.CreateHotelRequest;
import org.choicehotels.springrest.client.gen.CreateHotelResponse;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class ChoiceHotelSoapClient extends WebServiceGatewaySupport {


    public CreateHotelResponse createHotel(CreateHotelRequest createHotelRequest){
        System.out.println("before soap call");
        CreateHotelResponse hotelResponse = (CreateHotelResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", createHotelRequest,
        new SoapActionCallback("http://localhost:8088/hotels"));
        System.out.println("after soap call");
        return hotelResponse;
    }
}
