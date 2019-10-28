package WorkingWithPerson;

import java.text.ParseException;
import java.util.Scanner;

import org.joda.time.LocalDate;

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
	public LocalDate convertDate(String str) throws ParseException {
	//	System.out.println(Integer.parseInt(str.split("/")[0]));
		return new LocalDate(Integer.parseInt(str.split("/")[2]), Integer.parseInt(str.split("/")[1]), Integer.parseInt(str.split("/")[0]));
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
		LocalDate bDay = null;
		String gender;
		
		System.out.println("Введите ФИО: ");
		FIO = in.next();
	
		do{
			try {
			System.out.println("Введите дату рождения в формате dd/mm/yyyy");
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
	
	

}
