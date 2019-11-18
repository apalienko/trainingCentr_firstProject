package ru.apache_maven;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import PersonsContainer.PersonDynamicMass;
import WorkingWithPerson.Division;
import WorkingWithPerson.Gender;
import WorkingWithPerson.Person;


public class App 
{
public static void main(String[] args){
		
		PersonDynamicMass pdm = new PersonDynamicMass();
		
		String filename = "persons.txt";
		try {
			Scanner sc = new Scanner(new File(filename));			
			List<String> lines = new ArrayList<String>();
			while(sc.hasNextLine())
				lines.add(sc.nextLine());
			
			Person temp;
			String[] persData;
			Gender tempGen;
			Division tempDiv;
			LocalDate tempDate;
			for(int i = 0; i < lines.size(); i++) {
				persData = lines.get(i).split(";");
				
				if(persData[2].contentEquals("Male"))
					tempGen = Gender.MALE;
				else
					tempGen = Gender.FEMALE;
				
				tempDiv = new Division(persData[4]);
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
				tempDate = LocalDate.parse(persData[3], dtf);
				
				temp = new Person(persData[1], tempDate, tempGen, Integer.parseInt(persData[0]), tempDiv, new BigDecimal(persData[5]));
				pdm.add(temp);
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
