package com.company.persons;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Dell on 05.03.2017.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class People {

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    @XmlElement(name = "person")
    private ArrayList<Person> persons = new ArrayList<>();

    public ArrayList<Person> getPeoples() {
        return persons;
    }
}
