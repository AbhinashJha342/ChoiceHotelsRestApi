package org.choicehotels.springrest.model;

public class AddressRequestDto {

    private String city;

    private String state;

    private String postalCode;

    private AddressLinesRequestDto addressLines;

    public AddressRequestDto(String city, String state, String postalCode, AddressLinesRequestDto addressLines) {
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.addressLines = addressLines;
    }

    public AddressRequestDto() {
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public AddressLinesRequestDto getAddressLines() {
        return addressLines;
    }

    @Override
    public String toString() {
        return "AddressRequestDto{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", addressLines=" + addressLines +
                '}';
    }
}
