package org.choicehotels.springrest.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CreateHotelRequestDto {

    @NotNull(message = "Please provide a name for the hotel.")
    @NotEmpty(message = "Please provide a name for the hotel.")
    private String name;

    @Min(0)
    @Max(5)
    private Integer rating;

    @NotNull(message = "Please provide address of the hotel.")
    private AddressRequestDto address;

    public CreateHotelRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public AddressRequestDto getAddress() {
        return address;
    }

    public void setAddress(AddressRequestDto address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateHotelRequestDto that = (CreateHotelRequestDto) o;
        return Objects.equals(name, that.name) && Objects.equals(rating, that.rating) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating, address);
    }

    @Override
    public String toString() {
        return "CreateHotelRequestDto{" +
                "name='" + name + '\'' +
                ", rating='" + rating + '\'' +
                ", address=" + address +
                '}';
    }
}
