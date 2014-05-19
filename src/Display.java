import java.util.ArrayList;

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
import javax.swing.JTextArea;

public class Display extends JFrame{

	private JMenuBar menu_bar;
	private JMenu menu_add, menu_del, menu_pl;
	private JMenuItem item_op, item_mo;
	private JPanel pan;
	private JTextArea jta;
	
	
	/* test */
	private final Display dis;
	private final Start s;
	private ArrayList op_list, mo_list;
	/*----- */
	
	private String nm, srnm, type;
	
	public Display(String title, Dimension dim, ArrayList op_l, ArrayList mo_l, Start st){
	
		System.out.println("\n-> create display ");
		
		op_list = op_l;
		mo_list = mo_l;
		s = st;
		
		/* Creation du panel */
		pan = new JPanel();
		
		/* Creation de la barre menu */
		menu_bar = new JMenuBar();
		createMenu(this);
		
		/* Creation des JTextArea */
		jta = new JTextArea(5,20);
		jta.setEditable(false);
		
		pan.setLayout(null);
		pan.add(jta);
		jta.setBounds(475,10,250,300);
		
		
		/* Options pour la fenetre */
		this.setJMenuBar(menu_bar);
		this.setContentPane(pan);
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
		menu_del = new JMenu("Supprimer");
		menu_pl = new JMenu("Planning");
		
		item_op = new JMenuItem("Operateur");
		item_op.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				Popup pop = new Popup("Operator", "Nouveau operateur", d);		  
			}        
		});
		
		item_mo = new JMenuItem("Moniteur");
		item_mo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				Popup pop = new Popup("Monitor", "Nouveau Moniteur", d);
			}        
		});
		
		menu_add.add(item_op);
		menu_add.add(item_mo);
		
		menu_bar.add(menu_add);
		menu_bar.add(menu_del);		
		menu_bar.add(menu_pl);
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
			op_list.add(op);
			jta.append(nm+","+srnm+" - Operateur\n");
		}else{
			Monitor mo = new Monitor(nm, srnm, type);
			mo_list.add(mo);
			jta.append(nm+","+srnm+" - Moniteur\n");
		}
		
		s.affList();
		
	}
	
}