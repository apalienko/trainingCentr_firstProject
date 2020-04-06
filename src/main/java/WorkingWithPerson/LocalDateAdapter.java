package WorkingWithPerson;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter 
    extends XmlAdapter<String, LocalDate>{
 
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.of(Integer.parseInt(v.split("-")[0]), Integer.parseInt(v.split("-")[1]), Integer.parseInt(v.split("-")[2]));
    }
 
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
 
}
