public class Operator{

	private String name, surname, type;
	private String poste;
	private int num_poste;
	
	public Operator(String name, String surname, String type){
	
		System.out.println("\n-> create new Operator ");
		System.out.println("\t-> "+name+","+surname+","+type+"\n");
		
		this.name = name;
		this.surname = surname;
		this.type = type;
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
	
	public String getType(){
		return type;
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