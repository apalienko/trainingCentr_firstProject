package WorkingWithPerson;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public interface IDivision {
	
	public Integer getId();
	
	public void setId(Integer id);
	
	public String getName();
	
	public void setName(String name);

}
