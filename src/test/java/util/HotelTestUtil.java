package util;

import org.choicehotels.springrest.model.CreateHotelRequestDto;

public class HotelTestUtil {

    public static CreateHotelRequestDto createHotel(){
        CreateHotelRequestDto createHotelRequestDto = new CreateHotelRequestDto();
        createHotelRequestDto.setName("Choice");
        createHotelRequestDto.setRating(4);


        return createHotelRequestDto;
    }
}
