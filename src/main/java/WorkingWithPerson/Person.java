package WorkingWithPerson;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс человека.
 * 
 * @author Aleksey
*/

public class Person {

	/** Поле Фамилия Имя и Отчество человека */
	private String FIO;
	
	/** Поле Дата рождения */
	private Date bDay;
	
	/** Поле Пол человека */
	private String gender;
	
	/**
	 * Конструктор - создание нового объекта с определенными значениями
	 * 
	 * @param aFIO - фамилия, Имя и Отчество
	 * @param aBDay - дата рождения
	 * @param aGender - пол человека
	 */
	public Person(String aFIO, Date aBDay, String aGender) {
		
		FIO = aFIO;
		bDay = aBDay;
		gender = aGender;
		
	}
	
	@Override
	  public String toString() {
		  SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	      return "[FIO=" + this.FIO + ", Birth Day=" + sdf.format(this.bDay) + 
	             ", Gender=" + this.gender + "]";
	  }
}
