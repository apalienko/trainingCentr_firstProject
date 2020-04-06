package WorkingWithPerson;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name ="division")
@XmlAccessorType(XmlAccessType.FIELD)
public class Division implements IDivision{

	/** id ������ */
	private Integer id;
	
	/** �������� ������ */
	private String name;
	
	public Division(String name) {
		this.name = name;
		id =  name.hashCode();
	}
	
	public Division() {
		name = "";
		id = 0;
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
	public String toString() {
		return "Division [id=" + id + ", name=" + name + "]";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
