package ru.apache_maven;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import PersonsContainer.MassFromFileReader;
import PersonsContainer.PersonDynamicMass;
import WorkingWithPerson.Division;
import WorkingWithPerson.Person;


public class App 
{
public static void main(String[] args){
		final Logger LOG = Logger.getLogger(App.class.getName());
	
		PersonDynamicMass pdm = new PersonDynamicMass();
		MassFromFileReader.read(pdm);
		
		try {
			JAXBContext context = JAXBContext.newInstance(PersonDynamicMass.class, Person.class, Division.class);
			Marshaller mar = context.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			mar.marshal(pdm, new File("./pdm.xml"));
			pdm =  new PersonDynamicMass();
			
			LOG.log(Level.INFO, "Marshalling completed successfuly");
			
			Unmarshaller un = context.createUnmarshaller(); 
			pdm = (PersonDynamicMass) un.unmarshal(new File("./pdm.xml"));
			
			LOG.log(Level.INFO, "Unmarshalling completed successfuly");
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
}
