public class Personne{

	private String name, surname;
	
	public Personne(String name, String surname){
	
		System.out.println("-> Personne has been created !");
	
		this.name = name;
		this.surname = surname;
	}

	public String getName(){
		return this.name;
	}
	
	public String getSurname(){
		return this.surname;
	}
	
}