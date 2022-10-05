package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.choicehotels.springrest.model.CreateHotelRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:mvc-dispatcher-test-servlet.xml")
//@EnableWebMvc
public class HotelControllerIntegrationTest {


    private static String BASE_URL = "/choice-hotel";

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void createHotel() throws Exception {
        CreateHotelRequestDto createHotelRequestDto = new CreateHotelRequestDto();
        createHotelRequestDto.setName("Choice");
        //createHotelRequestDto.setRating("4");
        MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
        this.mockMvc.perform(post("/hotels")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MEDIA_TYPE_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(createHotelRequestDto)))
                .andExpect(status().isCreated());
        //java.lang.AssertionError: Status expected:<201> but was:<415> to remove add contentType(MEDIA_TYPE_JSON_UTF8)
    }
}
