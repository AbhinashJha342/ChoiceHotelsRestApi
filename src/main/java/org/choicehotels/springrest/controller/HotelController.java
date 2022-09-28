package org.choicehotels.springrest.controller;

import org.choicehotels.springrest.client.gen.CreateHotelAmenitiesRequest;
import org.choicehotels.springrest.client.gen.CreateHotelRequest;
import org.choicehotels.springrest.client.gen.UpdateHotelAmenitiesRequest;
import org.choicehotels.springrest.model.*;
import org.choicehotels.springrest.service.BasicHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {


    private final BasicHotelService hotelService;

    @Autowired
    public HotelController(BasicHotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<CreateHotelResponseDto> createHotel(@Valid @RequestBody CreateHotelRequest hotelRequest) {
        CreateHotelResponseDto createHotelResponseDto = hotelService.createHotel(hotelRequest);
        return ObjectUtils.isEmpty(createHotelResponseDto.getHotelId())
                ? new ResponseEntity<>(HttpStatus.CONFLICT)
                : new ResponseEntity<>(createHotelResponseDto, HttpStatus.CREATED);

    }

    @GetMapping(params = "hotelId")
    public ResponseEntity<HotelDetailsResponseDto> getHotelDetails(@RequestParam(name = "hotelId", required = true) String hotelId) {
        HotelDetailsResponseDto getHotelDetailsResponseDto = hotelService.getHotelDetails(hotelId);
        return ObjectUtils.isEmpty(getHotelDetailsResponseDto)
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(getHotelDetailsResponseDto, HttpStatus.FOUND);
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

}
