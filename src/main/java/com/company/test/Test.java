package com.company.test;

import com.company.parser.JaxbUtil;

public class Test {

    public static void main(String[] args) {

        //String xmlPath = "C:\\Users\\Dell\\IdeaProjects\\WorkTime\\src\\main\\resources\\file.xml";
        //new DomParser().parse(xmlPath);
        //new SaxParser().parse(xmlPath);

//        People people = new People();
//
//        for (int i = 1; i < 6; i++) {
//            people.getPeoples().add(new Person(i, "name "+ i));
//        }
//
//        new JaxbUtil().marshalObj(people);
        new JaxbUtil().unmarshallerObj();

    }
}
