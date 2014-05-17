public class Monitor{
	
	private String name, surname;
	private String poste;
	
	public Monitor(String name, String surname){
	
		System.out.println("\n-> create new Monitor ");
	
		this.name = name;
		this.surname = surname;
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