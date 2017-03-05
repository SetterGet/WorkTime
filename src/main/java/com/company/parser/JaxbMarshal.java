package com.company.parser;

import com.company.persons.People;
import com.company.persons.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by Dell on 05.03.2017.
 */
public class JaxbMarshal {
    public void marshalObj(Object o) {
        try {
            File xmlPath = new File("C:\\Users\\Dell\\IdeaProjects\\WorkTime\\src\\main\\resources\\obj.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(o, xmlPath);
            marshaller.marshal(o, System.out);
        } catch (JAXBException e) {
            System.out.println("Problems with class");
        }
    }
}
