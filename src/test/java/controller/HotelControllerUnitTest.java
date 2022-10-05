package controller;

import org.choicehotels.springrest.controller.HotelController;
import org.choicehotels.springrest.model.CreateHotelRequestDto;
import org.choicehotels.springrest.model.CreateHotelResponseDto;
import org.choicehotels.springrest.service.BasicHotelService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HotelControllerUnitTest {

    private BasicHotelService hotelService;

    private HotelController hotelController;

    public HotelControllerUnitTest(){
        hotelService = mock(BasicHotelService.class);
        hotelController = new HotelController(hotelService);
    }

    @Test
    public void testCreateHotel(){
        String uuid = UUID.randomUUID().toString();
        CreateHotelRequestDto createHotelRequestDto = new CreateHotelRequestDto();
        createHotelRequestDto.setName("Choice");
        //createHotelRequestDto.setRating("4");

        CreateHotelResponseDto createHotelResponseDto = CreateHotelResponseDto.builder().setHotelId(uuid).build();

        when(hotelService.createHotel(createHotelRequestDto)).thenReturn(createHotelResponseDto);
        hotelController.createHotel(createHotelRequestDto);
        assertEquals(createHotelResponseDto.getHotelId(), uuid);

    }

}
