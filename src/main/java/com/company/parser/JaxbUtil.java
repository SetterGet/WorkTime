package com.company.parser;

import com.company.persons.People;
import com.company.persons.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Dell on 05.03.2017.
 */
public class JaxbUtil {
    public void marshalObj(People people) {
        try {
            File xmlPath = new File("C:\\Users\\Dell\\IdeaProjects\\WorkTime\\src\\main\\resources\\obj.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(people, xmlPath);
            marshaller.marshal(people, System.out);
        } catch (JAXBException e) {
            System.out.println("Problems with class");
        }
    }

    public void unmarshallerObj() {
        try {
            File file = new File("C:\\Users\\Dell\\IdeaProjects\\WorkTime\\src\\main\\resources\\obj.xml");
            JAXBContext context = JAXBContext.newInstance(People.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            People people = (People) unmarshaller.unmarshal(file);
            for (Person p : people.getPeoples()) {
                System.out.println(p.getId() + "=id || name = " + p.getName());
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
