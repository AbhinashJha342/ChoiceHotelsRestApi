package org.choicehotels.springrest.controller;

import org.choicehotels.springrest.client.ChoiceHotelSoapClient;
import org.choicehotels.springrest.client.gen.CreateHotelRequest;
import org.choicehotels.springrest.client.gen.CreateHotelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    ChoiceHotelSoapClient choiceHotelSoapClient;

    @GetMapping()
    public String getEmployees() {
        return "Hello!";
    }

    @PostMapping
    public ResponseEntity<CreateHotelResponse> createHotel(@Valid CreateHotelRequest hotelRequest) {
        System.out.println("before calling client");
        return new ResponseEntity(choiceHotelSoapClient.createHotel(hotelRequest), HttpStatus.CREATED);
    }
}
