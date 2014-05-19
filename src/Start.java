import java.util.ArrayList;
import java.awt.*;
import java.lang.Math;

public class Start{

	private static final int width = 750, height = 600;
	
	private ArrayList<Operator> op_list;
	private ArrayList<Monitor> mo_list;
	
	public Start(ArrayList<Operator> o, ArrayList<Monitor> m){
		
		op_list = o;
		mo_list = m;
		
		Dimension dim = new Dimension(width, height);	
		Display win = new Display("Emploi du temps", dim, op_list, mo_list, this);
		
	}
	
	public static void main(String[] args){		
		
		System.out.println("\n********** Starting program **********\n");
		
		ArrayList<Operator> op_list = new ArrayList<Operator>();
		ArrayList<Monitor> mo_list = new ArrayList<Monitor>();
		
		Start st = new Start(op_list, mo_list);
		
	}	

	/*
	* Fonction de sauvegarde des arraylists dans des fichiers
	* SI TU TE FAIS CHIER AMUSE TOI XD 
	*/
	public void saveList(){
	
	}
	
	/*
	* Fonction de chargement des listes contenus dans des fichiers
	* SI TU TE FAIS CHIER AMUSE TOI XD 
	*/	
	public void downloadList(){
	
	}
	
	public void computePlanning(){
		/* Selection aléatoire de 10 opérateurs et 2 moniteurs */
		if( op_list.size() < 10 && mo_list.size() < 2){
			System.out.println("Can't run calculation for < 10 operators and < 2 monitors");
		}else{
			System.out.println("Starting calculation.... :)");
			System.out.println("But no yet, working on ... :)");
		}
	}
	
	/*
	* Fonction de test des arraylists
	*/
	public void affList(String def){	
		if(def == "Operator"){
			Operator op_tmp;
			System.out.println("\n********************************************");
			for(int i = 0; i < op_list.size(); i++){
				op_tmp= op_list.get(i);
				System.out.println("Operator : "+op_tmp.getName());
			}
			System.out.println("********************************************\n");
		}else{
			Monitor mo_tmp;
			System.out.println("\n********************************************");
			for(int i = 0; i < mo_list.size(); i++){
				mo_tmp= mo_list.get(i);
				System.out.println("Monitor : "+mo_tmp.getName());
			}
			System.out.println("********************************************\n");
		}
	}
}