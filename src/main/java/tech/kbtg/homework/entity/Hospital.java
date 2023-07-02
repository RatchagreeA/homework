package tech.kbtg.homework.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "num_staff")
    private Integer numStaff;

    @Column(name = "email")
    private String email;

    @Column(name = "contact")
    private String contact;

    @Column(name = "hospital_size")
    private String hospitalSize;
    @Column(name = "status")
    private String status;


    public Hospital() {
    }

    public Hospital(String name, String address, int numStaff, String email, String contact, String hospitalSize, String status) {
        this.name = name;
        this.address = address;
        this.numStaff = numStaff;
        this.email = email;
        this.contact = contact;
        this.hospitalSize = hospitalSize;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHospitalSize() {
        return hospitalSize;
    }

    public void setHospitalSize(String hospitalSize) {
        this.hospitalSize = hospitalSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumStaff() {
        return numStaff;
    }

    public void setNumStaff(Integer numStaff) {
        this.numStaff = numStaff;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numStaff='" + numStaff + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
