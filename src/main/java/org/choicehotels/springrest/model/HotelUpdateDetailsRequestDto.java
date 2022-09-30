package org.choicehotels.springrest.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelUpdateDetailsRequestDto that = (HotelUpdateDetailsRequestDto) o;
        return Objects.equals(name, that.name) && Objects.equals(rating, that.rating) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating, address);
    }
}
