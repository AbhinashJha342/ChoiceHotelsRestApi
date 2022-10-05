package util;

import org.choicehotel.generated.AddressDto;
import org.choicehotel.generated.AddressLinesDto;
import org.choicehotel.generated.CreateHotelRequest;
import org.choicehotel.generated.CreateHotelResponse;
import org.choicehotels.springrest.model.AddressLinesRequestDto;
import org.choicehotels.springrest.model.AddressRequestDto;
import org.choicehotels.springrest.model.CreateHotelRequestDto;
import org.springframework.http.MediaType;

public class HotelTestUtil {

    public static final MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));

    public static CreateHotelRequestDto createHotel(){
        CreateHotelRequestDto createHotelRequestDto = new CreateHotelRequestDto();
        createHotelRequestDto.setName("Choice");
        createHotelRequestDto.setRating(4);
        createHotelRequestDto.setAddress(createHotelAddress());
        return createHotelRequestDto;
    }


    public static AddressRequestDto createHotelAddress() {
        AddressRequestDto addressRequestDto = new AddressRequestDto("Mexico City", "DF", "04230", new AddressLinesRequestDto("1", "Lx"));
        return addressRequestDto;
    }


    public static CreateHotelRequest soapHotelRequest(){
        CreateHotelRequest createHotelRequest = new CreateHotelRequest();
        createHotelRequest.setAddress(soapHotelAddress());
        createHotelRequest.setName("Choice");
        createHotelRequest.setRating("4");
        return createHotelRequest;
    }

    public static AddressDto soapHotelAddress() {
        AddressDto addressDto = new AddressDto();
        AddressRequestDto addressRequestDto = createHotelAddress();
        addressDto.setCity(addressRequestDto.getCity());
        addressDto.setState(addressRequestDto.getState());
        addressDto.setPostalCode(addressRequestDto.getPostalCode());
        addressDto.setAddressLines(addressLinesDto());
        return addressDto;
    }

    public static AddressLinesDto addressLinesDto() {
        AddressLinesDto addressLinesDto = new AddressLinesDto();
        addressLinesDto.setExterior("1");
        addressLinesDto.setStreet("Lx");
        return addressLinesDto;
    }

    public static CreateHotelResponse soapHotelResponse() {
        CreateHotelResponse hotelResponse = new CreateHotelResponse();
        hotelResponse.setAddress(soapHotelAddress());
        hotelResponse.setName("Choice");
        hotelResponse.setRating("4");
        return hotelResponse;
    }

}
