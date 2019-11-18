package WorkingWithPerson;

public class Division implements IDivision{

	/** id отдела */
	private Integer id;
	
	/** Название отдала */
	private String name;
	
	public Division(String name) {
		this.name = name;
		id =  name.hashCode();
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
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
