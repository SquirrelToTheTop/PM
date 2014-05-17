import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Display extends JFrame{

	private JMenuBar menu_bar;
	private JMenu menu_action, menu_add;
	private JMenuItem item_op, item_mo;

	public Display(String title, Dimension dim){
	
		System.out.println("\n-> create display ");
		
		/* Creation de la barre menu */
		menu_bar = new JMenuBar();
		createMenu();
		
		/* Options pour la fenetre */
		this.setJMenuBar(menu_bar);
		this.setTitle(title);
		this.setSize( (int)dim.getWidth(), (int)dim.getHeight() );
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/* 
	* Creation de la barre de menu 
	*/
	private void createMenu(){
	
		menu_add = new JMenu("Ajouter");
		/*itemAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				new Operator("Loic", "Stra");
			}        
		});*/
		
		item_op = new JMenuItem("Opérateur");
		item_op.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				addOperator();
			}        
		});
		
		item_mo = new JMenuItem("Moniteur");
		item_mo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				new Monitor("Loic", "Stra");
			}        
		});
		
		menu_add.add(item_op);
		menu_add.add(item_mo);
		
		menu_bar.add(menu_add);
	}
	
	/*
	* Pop-up pour ajout d'operateur
	*/
	private void addOperator(){
		JFrame f = new JFrame("Nouvel opérateur");
		JPanel pan = new JPanel();
		JTextField nm = new JTextField();
		
		JLabel label_name = new JLabel("Nom :");
		JLabel label_surname = new JLabel("Prénom :");
		
		nm.setPreferredSize(new Dimension(100,20));
		
		pan.add(label_name);
		pan.add(label_surname);
		pan.add(nm);
		
		f.setContentPane(pan); 
		f.setAlwaysOnTop(true);
		f.setSize(300,150);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
}