package WorkingWithPerson;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����� ��������.
 * 
 * @author Aleksey
*/

public class Person {

	/** ���� ������� ��� � �������� �������� */
	private String FIO;
	
	/** ���� ���� �������� */
	private Date bDay;
	
	/** ���� ��� �������� */
	private String gender;
	
	/**
	 * ����������� - �������� ������ ������� � ������������� ����������
	 * 
	 * @param aFIO - �������, ��� � ��������
	 * @param aBDay - ���� ��������
	 * @param aGender - ��� ��������
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
