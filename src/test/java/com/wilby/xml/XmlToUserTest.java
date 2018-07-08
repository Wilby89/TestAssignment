package com.wilby.xml;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class XmlToUserTest {
    private XMLUser user;
    @Test
    public void testXmlToObject() throws JAXBException, FileNotFoundException {
        File file = new File("user.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(XMLUser.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        user = (XMLUser) unmarshaller.unmarshal(file);
        System.out.println(user);
    }
}