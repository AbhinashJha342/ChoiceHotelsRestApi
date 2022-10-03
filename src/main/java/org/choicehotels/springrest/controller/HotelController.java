package org.choicehotels.springrest.controller;

import org.choicehotel.generated.CreateHotelAmenitiesRequest;
import org.choicehotel.generated.UpdateHotelAmenitiesRequest;
import org.choicehotels.springrest.model.*;
import org.choicehotels.springrest.service.BasicHotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {


    private final BasicHotelService hotelService;

    public HotelController(BasicHotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<CreateHotelResponseDto> createHotel(@Valid @RequestBody CreateHotelRequestDto hotelRequest) {
        CreateHotelResponseDto createHotelResponseDto = hotelService.createHotel(hotelRequest);
        return ObjectUtils.isEmpty(createHotelResponseDto.getHotelId())
                ? new ResponseEntity<>(HttpStatus.CONFLICT)
                : new ResponseEntity<>(createHotelResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDetailsResponseDto> getHotelDetails(@PathVariable(required = false) String hotelId) {
        HotelDetailsResponseDto getHotelDetailsResponseDto = hotelService.getHotelDetails(hotelId);
        return ObjectUtils.isEmpty(getHotelDetailsResponseDto)
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(getHotelDetailsResponseDto, HttpStatus.FOUND);
    }

    @PatchMapping("/{hotelId}")
    public ResponseEntity<HotelUpdateDetailsResponseDto> updateHotelDetails(@RequestBody HotelUpdateDetailsRequestDto hotelUpdateDetailsRequestDto, @PathVariable String hotelId){
        HotelUpdateDetailsResponseDto hotelUpdateDetailsResponseDto = hotelService.updateHotelDetails(hotelUpdateDetailsRequestDto, hotelId);
        return ObjectUtils.isEmpty(hotelUpdateDetailsResponseDto)
                ? new ResponseEntity<>(HttpStatus.CONFLICT)
                : new ResponseEntity<>(hotelUpdateDetailsResponseDto, HttpStatus.FOUND);
    }

    @PostMapping("/{hotelId}/amenities")
    public ResponseEntity<AmenitiesResponseDto> createHotelAmenities(@Valid @PathVariable String hotelId, @RequestBody AmenitiesRequestDto amenitiesRequestDto) {
        CreateHotelAmenitiesRequest amenitiesRequest = new CreateHotelAmenitiesRequest();
        amenitiesRequest.setHotelId(hotelId);
        amenitiesRequest.getAmenities().addAll(amenitiesRequestDto.getAmenities());
        AmenitiesResponseDto amenitiesResponseDto = hotelService.createHotelAmenities(amenitiesRequest);
        return ObjectUtils.isEmpty(amenitiesResponseDto)
                ? new ResponseEntity<>(HttpStatus.CONFLICT)
                : new ResponseEntity<>(amenitiesResponseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{hotelId}/amenities")
    public ResponseEntity<UpdatedAmenitiesResponseDto> updateHotelAmenities(@Valid @PathVariable String hotelId, @RequestBody UpdatedAmenitiesRequestDto amenitiesRequestDto) {
        UpdateHotelAmenitiesRequest amenitiesRequest = new UpdateHotelAmenitiesRequest();
        amenitiesRequest.setHotelId(hotelId);
        amenitiesRequest.getAmenities().addAll(amenitiesRequestDto.getAmenities());
        UpdatedAmenitiesResponseDto updatedAmenities = hotelService.updatedAmenities(amenitiesRequest);
        return ObjectUtils.isEmpty(updatedAmenities)
                ? new ResponseEntity<>(HttpStatus.CONFLICT)
                : new ResponseEntity<>(updatedAmenities, HttpStatus.CREATED);
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<HotelDetailsResponseDto>> getHotelDetailsByName(@RequestParam(name = "name", required = false) String hotelName){
            return new ResponseEntity<>(hotelService.getHotelDetailsByName(hotelName), HttpStatus.FOUND);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity deleteHotel(@PathVariable String hotelId) {
        hotelService.archive(hotelId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
