package WorkingWithPerson;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlType(name="gender")
public enum Gender {	
	@XmlEnumValue("MALE")
	MALE,
	@XmlEnumValue("FEMALE")
	FEMALE
}
