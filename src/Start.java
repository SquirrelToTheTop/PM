import java.util.ArrayList;
import java.awt.*;
import javax.swing.JOptionPane;

public class Start{

	private static final int width = 750, height = 600;
	
	
	private	ArrayList op_list;
	private	ArrayList mo_list;
	
	public Start(){
		
		op_list = new ArrayList();
		mo_list = new ArrayList();
		
		Dimension dim = new Dimension(width, height);	
		Display win = new Display("Emploi du temps", dim, op_list, mo_list, this);
		
	}
	
	public static void main(String[] args){		
		
		System.out.println("\n********** Starting program **********\n");
		Start st = new Start();
		
	}	

	/*
	* Fonction de test des arraylists
	*/
	public void affList(){	
        Operator op_tmp;
		for(int i = 0; i < op_list.size(); i++){
			op_tmp= (Operator)op_list.get(i);
			System.out.println("Operator : "+op_tmp.getName());
		}
	}
}