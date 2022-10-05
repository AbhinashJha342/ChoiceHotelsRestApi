package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.choicehotels.springrest.model.CreateHotelRequestDto;
import org.choicehotels.springrest.service.BasicHotelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;
import util.HotelTestUtil;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static util.HotelTestUtil.soapHotelResponse;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:mvc-dispatcher-test-servlet.xml")
//@EnableWebMvc
public class HotelControllerIntegrationTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private WebServiceTemplate template;

    @BeforeEach
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
        template = mock(WebServiceTemplate.class);
    }

    @Test
    public void createHotel() throws Exception {
        when(this.template.marshalSendAndReceive("http://localhost:8088/wsdlfirst/hotels.wsdl", HotelTestUtil.soapHotelRequest()))
                .thenReturn(soapHotelResponse());
        this.mockMvc.perform(post("/hotels")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(HotelTestUtil.MEDIA_TYPE_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(HotelTestUtil.createHotel())))
                .andExpect(status().isCreated());
        //java.lang.AssertionError: Status expected:<201> but was:<415> to remove add contentType(MEDIA_TYPE_JSON_UTF8)
    }
}
