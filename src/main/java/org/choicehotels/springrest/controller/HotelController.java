package org.choicehotels.springrest.controller;

import org.choicehotels.springrest.client.gen.CreateHotelRequest;
import org.choicehotels.springrest.model.CreateHotelResponseDto;
import org.choicehotels.springrest.model.HotelDetailsResponseDto;
import org.choicehotels.springrest.service.BasicHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        HotelDetailsResponseDto getHotelDetailsResponseDto = hotelService.getHotelDetailsResponseDto(hotelId);
        return ObjectUtils.isEmpty(getHotelDetailsResponseDto)
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(getHotelDetailsResponseDto, HttpStatus.FOUND);
    }
}
