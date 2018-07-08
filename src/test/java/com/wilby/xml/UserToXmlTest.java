package com.wilby.xml;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserToXmlTest {
    private XMLUser user;

    @Before
    public void setUp() {
        user = new XMLUser(99, "William", "Brosnan");
    }

    @After
    public void tearDown() {
        user = null;
    }

    @Test
    public void testObjectToXml() throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(XMLUser.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(user, new File("user.xml"));
        marshaller.marshal(user, System.out);
    }
}