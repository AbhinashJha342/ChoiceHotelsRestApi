package client;

import org.choicehotel.generated.CreateHotelRequest;
import org.choicehotels.springrest.client.ChoiceHotelSoapClient;
import org.choicehotels.springrest.exception.GlobalExceptionResolver;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.ws.client.core.WebServiceTemplate;
import util.HotelTestUtil;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChoiceHotelSoapClientTest {


    private ChoiceHotelSoapClient soapClient;

    private WebServiceTemplate template;

    private GlobalExceptionResolver exceptionResolver;


    //private MockEnvironment mockEnvironment;

    private Environment environment;

    @BeforeEach
    public void init(){
        //mockEnvironment = new MockEnvironment();
        //mockEnvironment.setProperty("soap.wsdl.path", "http://localhost:8088/wsdlfirst/hotels.wsdl");
        environment = Mockito.mock(Environment.class);
        template = Mockito.mock(WebServiceTemplate.class);
        exceptionResolver = Mockito.mock(GlobalExceptionResolver.class);
        soapClient = new ChoiceHotelSoapClient(exceptionResolver, template, environment);
    }


    @Test
    public void createHotelTest(){
        CreateHotelRequest createHotelRequest = HotelTestUtil.soapHotelRequest();
        when(environment.getProperty("soap.wsdl.path")).thenReturn("http://localhost:8088/wsdlfirst/hotels.wsdl");
        when(template.marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", createHotelRequest))
                .thenReturn(HotelTestUtil.soapHotelResponse());
        soapClient.createHotel(createHotelRequest);
    }

}
