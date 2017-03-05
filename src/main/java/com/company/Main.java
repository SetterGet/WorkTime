package com.company;

import parser.DomParser;
import parser.SaxParser;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String xmlPath = "C:\\Users\\Dell\\IdeaProjects\\WorkTime\\src\\main\\resources\\file.xml";
       // new DomParser().parse(xmlPath);
        new SaxParser().parse(xmlPath);
    }
}
