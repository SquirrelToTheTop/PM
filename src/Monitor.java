public class Monitor{
	
	private String name, surname, type;
	private String poste;
	
	public Monitor(String name, String surname, String type){
	
		System.out.println("\n-> create new Monitor ");
		System.out.println("\t-> "+name+","+surname);
	
		this.name = name;
		this.surname = surname;
		this.type = type;
		poste = new String("");
	}

	/* fonction d'accès aux variables  de la classe */
	public String getName(){
		return name;
	}
	
	public String getSurname(){
		return surname;
	}
	/*------------------------------------------------------------*/
	
	/* fonction de modification des variables de la classe */
	public void setPoste(String p){
		poste = p;
	}
	/*------------------------------------------------------------*/
}