package games.shop.entity;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
@Audited
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "LATEST_VERSION")
    private Long version;

    @NotEmpty
    @Column(name = "CUSTOMER_FIRSTNAME")
    private String firstName;

    @NotEmpty
    @Column(name = "CUSTOMER_LASTNAME")
    private String lastName;

    @NotEmpty
    @Column(name = "CUSTOMER_ADDRESS")
    private String address;

    @NotEmpty
    @Column(name = "CUSTOMER_EMAIL")
    private String email;

    public Customer(){
    }

    public Customer(String firstName, String lastName, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
