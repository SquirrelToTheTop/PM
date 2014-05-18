import java.awt.*;
import javax.swing.JOptionPane;

public class Start{

	private static final int width = 600, height = 600;
	public static String nm;

	public static void main(String[] args){		
		
		Operator [] ops = new Operator[10];
		
		System.out.println("\n********** Starting program **********\n");
			
		Dimension dim = new Dimension(width, height);	
		Display win = new Display("Emploi du temps", dim);
			
		/*-------------TEST MESSAGE D'INFOMATION----------------------------------------------*/
		JOptionPane jop1 = new JOptionPane();
		jop1.showMessageDialog(null, "Message informatif", "Information", JOptionPane.INFORMATION_MESSAGE);
		/*------------------------------------------------------------------------------------*/
		
	}	
}