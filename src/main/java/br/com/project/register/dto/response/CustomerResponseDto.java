package br.com.project.register.dto.response;

import br.com.project.register.entities.Customer;
import br.com.project.register.enums.CustomerTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerResponseDto {

    private Long id;
    private String name;
    private String email;
    private String documentNumber;
    private String cellphone;
    private CustomerTypes type;

    private List<AddressResponseDto> addresses;

    public CustomerResponseDto(Customer costumer) {

        this.id = costumer.getId();
        this.name = costumer.getName();
        this.email = costumer.getEmail();
        this.documentNumber = costumer.getDocumentNumber();
        this.cellphone = costumer.getCellphone();
        this.type = costumer.getCustomerType();
        this.addresses = new ArrayList<>();
        this.addresses.addAll(costumer.getAddresses().stream().map(AddressResponseDto::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumentNumber(){ return documentNumber;}

    public String getCellphone() {
        return cellphone;
    }

    public CustomerTypes getType() {
        return type;
    }

    public List<AddressResponseDto> getAddresses() {
        return addresses;
    }

}