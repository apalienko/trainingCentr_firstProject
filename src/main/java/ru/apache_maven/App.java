package ru.apache_maven;

import PersonsContainer.PersonDynamicMass;
import WorkingWithPerson.Person;
import WorkingWithPerson.UserInterfaceUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		
		// Объект вспомогательного класса для работы с пользователем
		UserInterfaceUtils utils = new UserInterfaceUtils();

		// Вспомогательная переменная типа Person
		Person temp;
		
		// Вспомогательная переменная индекса
		int index;
		
		// Контейнер, с которым будет происходить работа
		PersonDynamicMass dynMass = new PersonDynamicMass();
		
		utils.readItem();
		while(utils.getItem() != 0) {
			
			switch(utils.getItem()) {
				case 1:{
					temp = utils.readPerson();
					dynMass.push(temp);
					System.out.println("Добавление успешно выполнено\n");
					break;
				}
				case 2:{
					try {
						temp = utils.readPerson();
						index = utils.readIndex(dynMass.length());
						dynMass.put(temp, index);
						System.out.println("Добавление успешно выполнено\n");
					} catch(IndexOutOfBoundsException indexExc) {
						System.out.println("Ошибка индекс находится вне допустимого диапазона\n");
					}
					break;
				}
				case 3:{
					try {
						index = utils.readIndex(dynMass.length());
						System.out.println(dynMass.get(index).toString());
					} catch(IndexOutOfBoundsException indexExc) {
						System.out.println("Ошибка индекс находится вне допустимого диапазона\n");
					} catch(NullPointerException nullExc) {
						System.out.println("Ошибка ячейка с данным индексом не содержит данные\n");
					} 
					break;
				}
				case 4:{
					try {
						index = utils.readIndex(dynMass.length());
						dynMass.delete(index);
						System.out.println("Удаление успешно выполнено\n");
					} catch(IndexOutOfBoundsException indexExc) {
						System.out.println("Ошибка индекс находится вне допустимого диапазона\n");	
					}
					break;
				}
				case 5:{
					System.out.println("Текущее количество элементов в массиве: " + dynMass.curSize());					
					break;
				}
				case 6:{
					System.out.println("Максималное количество элементов в массиве: " + dynMass.length());
					break;
				}
			}
			
			utils.readItem();
		}
	}
}
