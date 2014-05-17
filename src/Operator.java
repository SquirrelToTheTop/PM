public class Operator{

	private String name, surname;
	private String poste;
	private int num_poste;
	
	public Operator(String name, String surname){
	
		System.out.println("\n-> create new Operator ");
		
		this.name = name;
		this.surname = surname;
		num_poste = 0;
		poste = new String("");
	}
	
	/* fonction d'accès aux variables  de la classe */
	public String getName(){
		return name;
	}
	
	public String getSurname(){
		return surname;
	}
	
	public String getPoste(){
		return poste;
	}
	
	public int getNumPoste(){
		return num_poste;
	}
	/*------------------------------------------------------------*/
	
	/* fonction de modification des variables de la classe */
	public void setPoste(String p){
		poste = p;
	}
	
	public void setNumPoste(int n){
		num_poste = n;
	}
	/*------------------------------------------------------------*/
}