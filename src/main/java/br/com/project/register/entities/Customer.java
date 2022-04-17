package br.com.project.register.entities;

import br.com.project.register.annotations.Document;
import br.com.project.register.enums.CustomerTypes;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "Preenchimento obrigatório!") @Length(min = 10, max = 100, message = "Min: 10, Max: 100")
    private String name;

    @NotNull @NotEmpty(message = "Preenchimento obrigatório!")
    @Document
    private String documentNumber;

    @NotNull @NotEmpty(message = "Preenchimento obrigatório!") @Email(message = "Email inválido!")
    private String email;

    @NotNull @NotEmpty(message = "Preenchimento obrigatório!") @Length(min = 11, max= 11, message = "Digite apenas o número do DDD e do telefone sem pontuação.")
    private String cellphone;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Preenchimento obrigatório, o campo não pode ser nulo!")
    private CustomerTypes customerType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer") @NotNull
    private List<Address> addresses = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String documentNumber, String email, String cellphone, CustomerTypes customerType) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.email = email;
        this.cellphone = cellphone;
        this.customerType = customerType;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public CustomerTypes getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerTypes customerType) {
        this.customerType = customerType;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setFalseAllAddresss(){
        for (Address address: addresses) {
            address.setPrincipalAddress(false);

        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", email='" + email + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", customerType=" + customerType +
                ", addresses=" + addresses +
                '}';
    }

}