package WorkingWithPerson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import PersonsContainer.PersonDynamicMass;

/**
 * ��������������� ����� ��� ������ � �������������
 * 
 * @author Aleksey
 *
 */
public class UserInterfaceUtils {

	/** ����� ������������ */
	private int item = -1;
	
	/** ������ ������ ������ ��� ����� � ������� */
	private Scanner in = new Scanner(System.in);
	
	/**
	 * @return ����� ������������
	 */
	public int getItem() {
		return item;
	}
	
	/**
	 * ������� ��� ������ ���� �� ������� � ��������� ����� ������������
	 */
	public void readItem() {
		System.out.println("�������� ��������:");
		System.out.println("1. �������� �������");
		System.out.println("2. �������� ������� �� �������");
		System.out.println("3. ������� ������� �� �������");
		System.out.println("4. ������� ������� �� �������");
		System.out.println("5. ���������� ������� ���������� ��������� � �������");
		System.out.println("6. ���������� ������������ ���������� ��������� � �������");
		System.out.println("0. �����.");
		item = in.nextInt();
	}
	
	/**
	 * ��������������� <b>String</b> � <b>Date</b> � ������� dd.MM.yyyy
	 * 
	 * @param str - ������������� ������
	 * @return ������ ���� Date
	 * @throws ParseException ������������ ������ ����� ������������� ����
	 */
	public Date convertDate(String str) throws ParseException {
		SimpleDateFormat frm = new SimpleDateFormat("dd.MM.yyyy");
		Date res =  frm.parse(str);
		return res;
	}
	
	/**
	 * ��������� ������ � ������� � ���������� ���������
	 * 
	 * @param size - ������� ������ �������
	 * @return ������, �������� � ��������
	 * @throws IndexOutOfBoundsException ������ ������� �� ���������� ��������
	 */
	public int readIndex(int size) throws IndexOutOfBoundsException{
		int res = -1;
		
		while(res == -1){
			System.out.println("������� ������: ");
			res = in.nextInt();
			if(res < 0 || res > size)
				throw(new IndexOutOfBoundsException());
		} 
		
		return res;
	}
	
	/**
	 * ��������������� ��������� � ������� ��� ����������� ������ � ��������,
	 * �������� ������������ �������� ������, � ������� �� �� ������ ������ <b>Person</b>
	 * 
	 * @return ������ <b>Person</b>
	 */
	public Person readPerson() {
		
		String FIO = null;
		Date bDay = null;
		String gender;
		
		System.out.println("������� ���: ");
		FIO = in.next();
	
		do{
			try {
			System.out.println("������� ���� �������� � ������� dd.mm.yyyy");
			bDay = convertDate(in.next());
		
			}
			catch(ParseException prsExc) {
				System.out.println("������ ������� ����� ����. ��������� ����\n");
			}
		} while (bDay == null);
		
		System.out.println("������� ���: ");
		gender = in.next();
		
		return new Person(FIO, bDay, gender);
	}
	
	public static void main(String[] args) {
		
		// ������ ���������������� ������ ��� ������ � �������������
		UserInterfaceUtils utils = new UserInterfaceUtils();

		// ��������������� ���������� ���� Person
		Person temp;
		
		// ��������������� ���������� �������
		int index;
		
		// ���������, � ������� ����� ����������� ������
		PersonDynamicMass dynMass = new PersonDynamicMass();
		
		utils.readItem();
		while(utils.getItem() != 0) {
			
			switch(utils.getItem()) {
				case 1:{
					temp = utils.readPerson();
					dynMass.push(temp);
					System.out.println("���������� ������� ���������\n");
					break;
				}
				case 2:{
					try {
						temp = utils.readPerson();
						index = utils.readIndex(dynMass.length());
						dynMass.put(temp, index);
						System.out.println("���������� ������� ���������\n");
					} catch(IndexOutOfBoundsException indexExc) {
						System.out.println("������ ������ ��������� ��� ����������� ���������\n");
					}
					break;
				}
				case 3:{
					try {
						index = utils.readIndex(dynMass.length());
						System.out.println(dynMass.get(index).toString());
					} catch(IndexOutOfBoundsException indexExc) {
						System.out.println("������ ������ ��������� ��� ����������� ���������\n");
					} catch(NullPointerException nullExc) {
						System.out.println("������ ������ � ������ �������� �� �������� ������\n");
					} 
					break;
				}
				case 4:{
					try {
						index = utils.readIndex(dynMass.length());
						dynMass.delete(index);
						System.out.println("�������� ������� ���������\n");
					} catch(IndexOutOfBoundsException indexExc) {
						System.out.println("������ ������ ��������� ��� ����������� ���������\n");	
					}
					break;
				}
				case 5:{
					System.out.println("������� ���������� ��������� � �������: " + dynMass.curSize());					
					break;
				}
				case 6:{
					System.out.println("����������� ���������� ��������� � �������: " + dynMass.length());
					break;
				}
			}
			
			utils.readItem();
		}
	}

}
