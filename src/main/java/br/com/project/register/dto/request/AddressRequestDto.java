package br.com.project.register.dto.request;

import br.com.project.register.entities.Address;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class AddressRequestDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty(message = "Preenchimento obrigatório!") @Length(min = 5,max = 80, message = "Mín 5, Max: 80 caracteres.")
    private String name;

    @NotNull @Range(min = 1, max = 2000) @NotEmpty
    private String number;

    @NotNull @NotEmpty(message = "Preenchimento obrigatório!") @Length(min = 5,max = 50, message = "Mín 5, Max: 50 caracteres.")
    private String district;

    @NotNull @NotEmpty(message = "Preenchimento obrigatório!") @Length(min = 5,max = 50, message = "Mín 5, Max: 50 caracteres.")
    private String city;

    @NotNull @NotEmpty(message = "Preenchimento obrigatório!") @Length(min = 8,max = 8, message = "Digite o cep sem a pontuação.")
    private String cep;

    @NotNull @NotEmpty(message = "Preenchimento obrigatório!") @Length(min = 5,max = 50, message = "Digite o nome da cidade por extenso.")
    private String state;

    private Boolean principalAddress;

    public AddressRequestDto() {
    }

    public AddressRequestDto(Long id, String name, String number, String district, String city, String cep, String state, Boolean principalAddress) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.district = district;
        this.city = city;
        this.cep = cep;
        this.state = state;
        this.principalAddress = principalAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
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

    public Boolean getPrincipalAddress() {
        return principalAddress;
    }

    @Override
    public String toString() {
        return "AddressRequestDtoPost{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", cep='" + cep + '\'' +
                ", state='" + state + '\'' +
                ", principalAddress=" + principalAddress +
                '}';
    }

    public Address converterAddress() {
        return new Address(id, name, number, district, city, cep, state, principalAddress);
    }
}
