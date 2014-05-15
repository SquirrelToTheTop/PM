import java.awt.*;
import javax.swing.JFrame;


public class Display extends JFrame{

	public Display(String title, Dimension dim){
	
		System.out.println("\n-> create display ");
		
		this.setTitle(title);
		this.setSize( (int)dim.getWidth(), (int)dim.getHeight() );
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}