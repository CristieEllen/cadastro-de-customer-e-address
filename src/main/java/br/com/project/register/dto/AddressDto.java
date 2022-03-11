package br.com.project.register.dto;

import br.com.project.register.entities.Address;

public class AddressDto {
    private Long id;
    private String name;
    private Integer number;
    private String district;
    private String city;
    private String cep;
    private String state;

    public AddressDto(Address address) {
        this.id = address.getId();
        this.name = address.getName();
        this.number = address.getNumber();
        this.district = address.getDistrict();
        this.city = address.getCity();
        this.cep = address.getCep();
        this.state = address.getState();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public String getCep() {
        return cep;
    }

    public String getState() {
        return state;
    }
}
