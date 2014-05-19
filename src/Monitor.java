public class Monitor{
	
	private String name, surname, type;
	private String poste;
	private int num_mo;
	
	public Monitor(String name, String surname, String type){	
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
	
	public String getNumMo(){
		return Integer.toString(num_mo);
	}
	
	/* fonction de modification des variables de la classe */
	public void setNumMo(int n){
		num_mo = n;
	}
	
	
	public void setPoste(String p){
		poste = p;
	}
	/*------------------------------------------------------------*/
}