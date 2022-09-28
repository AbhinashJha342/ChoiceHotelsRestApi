package org.choicehotels.springrest.controller;

import org.choicehotels.springrest.client.gen.CreateHotelRequest;
import org.choicehotels.springrest.client.gen.CreateHotelResponse;
import org.choicehotels.springrest.model.CreateHotelResponseDto;
import org.choicehotels.springrest.service.BasicHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<CreateHotelResponseDto> createHotel(@Valid CreateHotelRequest hotelRequest) {
        CreateHotelResponseDto createHotelResponseDto = hotelService.createHotel(hotelRequest);
        return ObjectUtils.isEmpty(createHotelResponseDto.getHotelId())
                ? new ResponseEntity<>(HttpStatus.CONFLICT)
                : new ResponseEntity<>(createHotelResponseDto, HttpStatus.CREATED);

    }
}
