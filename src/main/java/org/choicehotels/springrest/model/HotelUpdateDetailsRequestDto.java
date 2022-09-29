package org.choicehotels.springrest.model;

public class HotelUpdateDetailsRequestDto {

    private String name;
    private String rating;
    private AddressRequestDto address;

    public HotelUpdateDetailsRequestDto(String name, String rating, AddressRequestDto address) {
        this.name = name;
        this.rating = rating;
        this.address = address;
    }

    public HotelUpdateDetailsRequestDto() {
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public AddressRequestDto getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "HotelUpdateDetailsRequestDto{" +
                "name='" + name + '\'' +
                ", rating='" + rating + '\'' +
                ", address=" + address +
                '}';
    }
}
