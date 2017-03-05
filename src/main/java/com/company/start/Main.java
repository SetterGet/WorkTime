package com.company.start;

import com.company.parser.JaxbMarshal;
import com.company.persons.People;
import com.company.persons.Person;

public class Main {

    public static void main(String[] args) {

        //String xmlPath = "C:\\Users\\Dell\\IdeaProjects\\WorkTime\\src\\main\\resources\\file.xml";
        //new DomParser().parse(xmlPath);
        //new SaxParser().parse(xmlPath);

        People people = new People();

        for (int i = 1; i < 6; i++) {
            people.getPeoples().add(new Person(i, "name "+ i));
        }

        new JaxbMarshal().marshalObj(people);

    }
}
