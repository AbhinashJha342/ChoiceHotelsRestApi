package org.choicehotels.springrest.mapper.impl;

import org.choicehotel.generated.AddressDto;
import org.choicehotels.springrest.mapper.Mapper;
import org.choicehotels.springrest.model.AddressLinesResponseDto;
import org.choicehotels.springrest.model.AddressResponseDto;

public class AddressResponseMapperImpl implements Mapper<AddressDto, AddressResponseDto> {

    @Override
    public AddressResponseDto map(AddressDto source) {
        if(source == null)
            return null;
        return AddressResponseDto.builder().setCity(source.getCity())
                .setState(source.getState()).setPostalCode(source.getPostalCode())
                .setAddressLines(source.getAddressLines()!=null ?
                        AddressLinesResponseDto.builder().setExterior(source.getAddressLines().getExterior())
                                .setStreet(source.getAddressLines().getStreet()).build() : null).build();
    }
}
