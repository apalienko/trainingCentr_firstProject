package WorkingWithPerson;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * ����� ��������.
 * 
 * @author Aleksey
*/

@XmlRootElement(name ="person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements IPerson {

	/** ���� ������� ��� � �������� �������� */
	@XmlElement(required=true)
	private String FIO;
	
	/** ���� ���� �������� */
	@XmlElement(required=true)
	private LocalDate birthDate;
	
	/** ���� ��� �������� */
	@XmlElement(required=true)
	private Gender gender;
	
	/** ������������ id �������� */
	@XmlElement(required=true)
	private Integer id;
	
	/** �����, � ������� ������� �������� */
	@XmlElement(required=true)
	private IDivision division;
	
	/** �������� */
	@XmlElement(required=true)
	private BigDecimal salary;
	
	public String getFIO() {
		return FIO;
	}

	public void setFIO(String fIO) {
		FIO = fIO;
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
		birthDate = aBDay;
		gender = aGender;
		
	}
	
	public Person() {
		FIO = "";
		this.birthDate = null;
		this.gender = Gender.MALE;
		this.id = 0;
		this.division = new Division();
		this.salary = new BigDecimal(0);
	}
	
	public Person(String fIO, LocalDate bDay, Gender gender, Integer id, IDivision division, BigDecimal salary) {
		super();
		FIO = fIO;
		this.birthDate = bDay;
		this.gender = gender;
		this.id = id;
		this.division = division;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [FIO=" + FIO + ", birthDate=" + birthDate + ", gender=" + gender + ", id=" + id + ", division="
				+ division + ", salary=" + salary + "]";
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
		return birthDate;
	}

	@Override
	public void setBirthdate(LocalDate birthdate) {
		this.birthDate = birthdate;
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
