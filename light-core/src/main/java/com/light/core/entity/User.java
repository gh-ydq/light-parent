package com.light.core.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@NamedQuery(name = "User.findByName", query = "select name,address from User u where u.name=?1")
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;

    public User(){
        super();
    }

    @Id
    long id;
    @Column(name = "name")
    String name;
    @Column(name = "address")
    String address;
    @Column(name = "city")
    String city;
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}