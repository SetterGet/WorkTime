package com.company.persons;

import javax.xml.bind.annotation.*;

/**
 * Created by Dell on 05.03.2017.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlAttribute(name = "id", required = true)
    private int id;

    @XmlElement(required = true)
    private String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
