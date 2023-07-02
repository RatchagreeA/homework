package tech.kbtg.homework.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "relatives")
    private String relatives;

    @Column(name = "contact")
    private String contact;

    @Column(name = "time")
    private String time;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "hospital_id")
    private String  hospital;

    public Patient() {
    }

    public Patient(String name, String gender, String address, String relatives, String contact, String time) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.relatives = relatives;
        this.contact = contact;
        this.time = time;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRelatives() {
        return relatives;
    }

    public void setRelatives(String relatives) {
        this.relatives = relatives;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", relatives='" + relatives + '\'' +
                ", contact='" + contact + '\'' +
                ", time='" + time + '\'' +
                ", hospital='" + hospital + '\'' +
                '}';
    }
}
