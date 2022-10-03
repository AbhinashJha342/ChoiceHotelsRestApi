package org.choicehotels.springrest.model;

public class AddressLinesRequestDto {

    private String exterior;

    private String street;

    public AddressLinesRequestDto(String exterior, String street) {
        this.exterior = exterior;
        this.street = street;
    }

    public AddressLinesRequestDto() {
    }

    public String getExterior() {
        return exterior;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "AddressLinesRequestDto{" +
                "exterior='" + exterior + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
