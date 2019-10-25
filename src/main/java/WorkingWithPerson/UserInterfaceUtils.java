package WorkingWithPerson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import PersonsContainer.PersonDynamicMass;

/**
 * Вспомогательный класс для работы с пользователем
 * 
 * @author Aleksey
 *
 */
public class UserInterfaceUtils {

	/** Выбор пользователя */
	private int item = -1;
	
	/** Объект класса сканер для ввода с консоли */
	private Scanner in = new Scanner(System.in);
	
	/**
	 * @return выбор пользователя
	 */
	public int getItem() {
		return item;
	}
	
	/**
	 * Выводит все пункты меню на консоль и считывает выбор пользователя
	 */
	public void readItem() {
		System.out.println("Выберете действие:");
		System.out.println("1. Добавить элемент");
		System.out.println("2. Добавить элемент по индексу");
		System.out.println("3. Вывести элемент по индексу");
		System.out.println("4. Удалить элемент по индексу");
		System.out.println("5. Посмотреть текущее количество элементов в массиве");
		System.out.println("6. Посмотреть максимальное количество элементов в массиве");
		System.out.println("0. Выход.");
		item = in.nextInt();
	}
	
	/**
	 * Преобразовывает <b>String</b> в <b>Date</b> в формате dd.MM.yyyy
	 * 
	 * @param str - преобразуемая строка
	 * @return объект типа Date
	 * @throws ParseException некорректный формат ввода пользователем даты
	 */
	public Date convertDate(String str) throws ParseException {
		SimpleDateFormat frm = new SimpleDateFormat("dd.MM.yyyy");
		Date res =  frm.parse(str);
		return res;
	}
	
	/**
	 * Считывает индекс с консоли в допустимом диапазоне
	 * 
	 * @param size - текущий размер массива
	 * @return индекс, входящий в диапазон
	 * @throws IndexOutOfBoundsException индекс выходит за допустимый диапазон
	 */
	public int readIndex(int size) throws IndexOutOfBoundsException{
		int res = -1;
		
		while(res == -1){
			System.out.println("Введите индекс: ");
			res = in.nextInt();
			if(res < 0 || res > size)
				throw(new IndexOutOfBoundsException());
		} 
		
		return res;
	}
	
	/**
	 * Последовательно считывает с консоли все необходимые данных о человеке,
	 * проверяя правильность введеных данных, и создает на их основе объект <b>Person</b>
	 * 
	 * @return объект <b>Person</b>
	 */
	public Person readPerson() {
		
		String FIO = null;
		Date bDay = null;
		String gender;
		
		System.out.println("Введите ФИО: ");
		FIO = in.next();
	
		do{
			try {
			System.out.println("Введите дату рождения в формате dd.mm.yyyy");
			bDay = convertDate(in.next());
		
			}
			catch(ParseException prsExc) {
				System.out.println("Ошибка формата ввода даты. Повторите ввод\n");
			}
		} while (bDay == null);
		
		System.out.println("Введите пол: ");
		gender = in.next();
		
		return new Person(FIO, bDay, gender);
	}
	
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
