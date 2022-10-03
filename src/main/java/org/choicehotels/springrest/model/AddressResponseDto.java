package org.choicehotels.springrest.model;

public class AddressResponseDto {

    private String city;

    private String state;

    private String postalCode;

    private AddressLinesResponseDto addressLines;

    private AddressResponseDto(String city, String state, String postalCode, AddressLinesResponseDto addressLines) {
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.addressLines = addressLines;
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

    public AddressLinesResponseDto getAddressLines() {
        return addressLines;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {

        private String city;

        private String state;

        private String postalCode;

        private AddressLinesResponseDto addressLines;

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setAddressLines(AddressLinesResponseDto addressLines) {
            this.addressLines = addressLines;
            return this;
        }

        public AddressResponseDto build(){
            return new AddressResponseDto(this.city, this.state, this.postalCode, this.addressLines);
        }
    }
}
