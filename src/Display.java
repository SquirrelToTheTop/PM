import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JOptionPane;

public class Display extends JFrame{

	private JMenuBar menu_bar;
	private JMenu menu_action, menu_add;
	private JMenuItem item_op, item_mo;
	
	/* test */
	private final Display dis;
	/*----- */
	
	/* a revoir c'est un peu ninja */
	public String nm, srnm, type;
	private	JFrame f;
	private	JPanel p;
	private	BorderLayout l;
	private	JTextField jtf_nm, jtf_srnm;
	private	JLabel label_name, label_surname, label_jcb;
	private	JButton ok;
	private	JComboBox<String> jcb;
	/* ----------------------------- */
	
	public Display(String title, Dimension dim){
	
		System.out.println("\n-> create display ");
		
		/* Creation de la barre menu */
		menu_bar = new JMenuBar();
		createMenu(this);
		
		/* Options pour la fenetre */
		this.setJMenuBar(menu_bar);
		this.setTitle(title);
		this.setSize( (int)dim.getWidth(), (int)dim.getHeight() );
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		dis = this;
		
	}
	
	/* 
	* Creation de la barre de menu 
	*/
	private void createMenu(Display dis){
	
		final Display d = dis;
	
		menu_add = new JMenu("Ajouter");
		
		item_op = new JMenuItem("Operateur");
		item_op.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				Popup pop = new Popup("Operator", "New Op", d);		  
			}        
		});
		
		item_mo = new JMenuItem("Moniteur");
		item_mo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				Popup pop = new Popup("Monitor", "New Op", d);
			}        
		});
		
		menu_add.add(item_op);
		menu_add.add(item_mo);
		
		menu_bar.add(menu_add);
		
	}
	
	/*
	* recupération des données lues dans la popup
	*/
	public void setData(String n, String m, String t){
		nm = n;
		srnm = m;
		type = t;
	}
	
	/*
	* creation des opérateurs, moniteurs seulement quand
	* la popup a envoyés les infos et avant qu'elle se ferme
	*/
	public void ok(String def){
		if(def == "Operator"){
			Operator op = new Operator(nm, srnm, type);
		}else{
			Monitor mo = new Monitor(nm, srnm, type);
		}
	}
	
}