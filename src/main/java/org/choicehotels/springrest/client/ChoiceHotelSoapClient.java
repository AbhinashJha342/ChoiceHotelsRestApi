package org.choicehotels.springrest.client;

import org.choicehotels.springrest.client.gen.CreateHotelRequest;
import org.choicehotels.springrest.client.gen.CreateHotelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class ChoiceHotelSoapClient {

    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public CreateHotelResponse createHotel(CreateHotelRequest createHotelRequest){
        template = new WebServiceTemplate(marshaller);
        CreateHotelResponse hotelResponse = (CreateHotelResponse) template.marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", createHotelRequest);
        return  hotelResponse;
    }
}
