package WorkingWithPerson;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
//import java.util.Date;

/**
 * ����� ��������.
 * 
 * @author Aleksey
*/

public class Person implements IPerson {

	/** ���� ������� ��� � �������� �������� */
	private String FIO;
	
	/** ���� ���� �������� */
	private LocalDate bDay;
	
	/** ���� ��� �������� */
	private Gender gender;
	
	/** ������������ id �������� */
	private Integer id;
	
	/** �����, � ������� ������� �������� */
	private IDivision division;
	
	/** �������� */
	private BigDecimal salary;
	
	public String getFIO() {
		return FIO;
	}

	public void setFIO(String fIO) {
		FIO = fIO;
	}

	public LocalDate getbDay() {
		return bDay;
	}

	public void setbDay(LocalDate bDay) {
		this.bDay = bDay;
	}

	
	/**
	 * ����������� - �������� ������ ������� � ������������� ����������
	 * 
	 * @param aFIO - �������, ��� � ��������
	 * @param aBDay - ���� ��������
	 * @param aGender - ��� ��������
	 */
	public Person(String aFIO, LocalDate aBDay, Gender aGender) {
		
		FIO = aFIO;
		bDay = aBDay;
		gender = aGender;
		
	}
	
	public Person(String fIO, LocalDate bDay, Gender gender, Integer id, IDivision division, BigDecimal salary) {
		super();
		FIO = fIO;
		this.bDay = bDay;
		this.gender = gender;
		this.id = id;
		this.division = division;
		this.salary = salary;
	}

	@Override
	  public String toString() {
		  SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	      return "[FIO=" + this.FIO + ", Birth Day=" + sdf.format(this.bDay) + 
	             ", Gender=" + this.gender + "]";
	  }

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;		
	}

	@Override
	public String getFirstName() {
		return FIO.split(" ")[0];
	}

	@Override
	public void setFirstName(String firstName) {
		String newName = firstName + " ";
		newName += FIO.split(" ")[1];
		FIO = newName;
	}

	@Override
	public String getLastName() {
		return FIO.split(" ")[1];
	}

	@Override
	public void setLastName(String lastName) {
		String newName = " " + lastName;
		newName = FIO.split(" ")[0] + newName;
		FIO = newName;
	}

	@Override
	public LocalDate getBirthdate() {
		return bDay;
	}

	@Override
	public void setBirthdate(LocalDate birthdate) {
		this.bDay = birthdate;
	}

	@Override
	public Integer getAge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gender getGender() {
		return gender;
	}

	@Override
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public IDivision getDivision() {
		return division;
	}

	@Override
	public void setDivision(IDivision division) {
		this.division = division;
	}

	@Override
	public BigDecimal getSalary() {
		return salary;
	}

	@Override
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}
