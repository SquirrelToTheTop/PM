import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Start{

	private static int width = 600, height = 600;

	public static void main(String[] args){		
		
		System.out.println("\n********** Starting program **********\n");
		
		Dimension dim = new Dimension(width, height);	
		Display win = new Display("Emploi du temps", dim);
		
		/*-------------TEST MESSAGE D'INFOMATION----------------------------------------------*/
		JOptionPane jop1 = new JOptionPane();
		jop1.showMessageDialog(null, "Message informatif", "Information", JOptionPane.INFORMATION_MESSAGE);
		/*------------------------------------------------------------------------------------*/
		
		Personne p = new Personne("Jean", "Philippe");
		System.out.println("-> "+p.getName()+" , "+p.getSurname());
	}

}