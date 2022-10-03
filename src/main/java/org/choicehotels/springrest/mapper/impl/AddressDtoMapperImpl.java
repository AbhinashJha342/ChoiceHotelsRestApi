package org.choicehotels.springrest.mapper.impl;

import org.choicehotel.generated.AddressDto;
import org.choicehotel.generated.AddressLinesDto;
import org.choicehotels.springrest.mapper.Mapper;
import org.choicehotels.springrest.model.AddressRequestDto;

public class AddressDtoMapperImpl implements Mapper<AddressRequestDto, AddressDto> {


    @Override
    public AddressDto map(AddressRequestDto source) {
        if(source == null)
            return null;

        AddressDto addressDto = new AddressDto();
        addressDto.setCity(source.getCity());
        addressDto.setPostalCode(source.getPostalCode());
        addressDto.setState(source.getState());
        AddressLinesDto addressLinesDto = null;
        if(null!= source.getAddressLines()) {
            addressLinesDto = new AddressLinesDto();
            addressLinesDto.setExterior(source.getAddressLines().getExterior());
            addressLinesDto.setStreet(source.getAddressLines().getStreet());
        }
        addressDto.setAddressLines(addressLinesDto!=null ? addressLinesDto : new AddressLinesDto());
        return addressDto;
    }
}
