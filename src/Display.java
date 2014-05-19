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
	private JMenu menu_add, menu_del, menu_ac, menu_pl;
	private JMenuItem item_addop, item_addmo, item_delop, item_delmo;
	private JMenuItem item_dl, item_sv, item_org;
	private JPanel pan;
	private JTextArea jta;
	
	
	/* test */
	private final Display dis;
	private final Start s;
	private ArrayList<Operator> op_list;
	private ArrayList<Monitor> mo_list;
	/*----- */
	
	private String nm, srnm, type;
	private int count_op, count_mo;
	
	public Display(String title, Dimension dim, ArrayList<Operator> op_l, ArrayList<Monitor> mo_l, Start st){
	
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
		
		/* numérote les op et les mo*/
		count_op =0;
		count_mo =0;
	}
	
	/* 
	* Creation de la barre de menu 
	*/
	private void createMenu(Display dis){
	
		final Display d = dis;
	
		menu_add = new JMenu("Ajouter  ");
		menu_del = new JMenu("Supprimer");
		menu_ac = new JMenu("Action   ");
		menu_pl = new JMenu("Planning ");
		
		item_addop = new JMenuItem("Operateur");
		item_addop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				Popup pop = new Popup("Operator", "Ajouter un operateur", d, "add");		  
			}        
		});
		
		item_addmo = new JMenuItem("Moniteur");
		item_addmo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				Popup pop = new Popup("Monitor", "Ajouter un moniteur", d, "add");
			}        
		});
		
		item_delop = new JMenuItem("Operateur");
		item_delop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				Popup pop = new Popup("Operator", "Supprimer un operateur", d, "del");		  
			}        
		});
		
		item_delmo = new JMenuItem("Moniteur");
		item_delmo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				Popup pop = new Popup("Monitor", "Supprimer un moniteur", d, "del");
			}        
		});
		
		item_dl = new JMenuItem("Charger");
		item_dl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg){
				System.out.println("En travaux :) ");
			}
		});
		
		item_sv = new JMenuItem("Sauvegarder");
		item_sv.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg){
				System.out.println("En travaux :) ");
			}
		});
		
		item_org = new JMenuItem("Organiser");
		item_org.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg){
				s.computePlanning();
			}
		});
		
		menu_add.add(item_addop);
		menu_add.add(item_addmo);
		
		menu_del.add(item_delop);
		menu_del.add(item_delmo);
		
		menu_ac.add(item_dl);
		menu_ac.add(item_sv);
		
		menu_pl.add(item_org);
		
		menu_bar.add(menu_add);
		menu_bar.add(menu_del);
		menu_bar.add(menu_ac);
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
	* la popup a envoyé les infos et avant qu'elle se ferme
	*/
	public void addPpl(String def){
		if(def == "Operator"){
			Operator op = new Operator(nm, srnm, type);
			count_op ++;
			op.setNumOp(count_op);
			op_list.add(op);
			//jta.append(nm+", "+srnm+" - Operateur "+Integer.toString(count_op)+"\n");
			
			refreshJTA();
			
			/* test de l'ajout d'un operator */
			s.affList(def);
			
		}else{
			Monitor mo = new Monitor(nm, srnm, type);
			count_mo ++;
			mo.setNumMo(count_mo);
			mo_list.add(mo);
			//jta.append(nm+", "+srnm+" - Moniteur "+Integer.toString(count_mo)+"\n");
			
			refreshJTA();

			/* test de l'ajout d'un operator */
			s.affList(def);
		}
		
	}
	
	/*
	* def is for "Operator", "Monitor"
	* nmsrm is formed like "nom,prenom"
	*/
	public void rmPpl(String def, String nmsrnm){
		String[] parts = nmsrnm.split(",");
		
		if(def == "Operator"){
			Operator tmp;
			//System.out.println(">'"+parts[0]+"'"+"--"+"'"+parts[1]+"'");
			for(int i=0; i<op_list.size(); i++){
				tmp = op_list.get(i);
				if(tmp.getName().equals(parts[0]) && tmp.getSurname().equals(parts[1])){
					//System.out.println("Operator found at "+Integer.toString(i));
					op_list.remove(i);
				}
			}
			
			refreshJTA();
			
			/*  test de la suppression d'un operator */
			s.affList(def);
			
		}else{
			Monitor tmp;
			//System.out.println(">'"+parts[0]+"'"+"--"+"'"+parts[1]+"'");
			for(int i=0; i<mo_list.size(); i++){
				tmp = mo_list.get(i);
				if(tmp.getName().equals(parts[0]) && tmp.getSurname().equals(parts[1])){
					//System.out.println("Operator found at "+Integer.toString(i));
					mo_list.remove(i);
				}
			}
			
			refreshJTA();
			
			/* test de la suppression d'un monitor */
			s.affList(def);
		}
	}
	
	private void refreshJTA(){
		Monitor mo_tmp;
		Operator op_tmp;
		jta.setText(null);
		for(int i=0; i<op_list.size(); i++){
			op_tmp = op_list.get(i);
			jta.append(op_tmp.getName()+", "+op_tmp.getSurname()+" - Operator "+op_tmp.getNumOp()+"\n");
		}
		
		for(int i=0; i<mo_list.size(); i++){
			mo_tmp = mo_list.get(i);
			jta.append(mo_tmp.getName()+", "+mo_tmp.getSurname()+" - Monitor "+mo_tmp.getNumMo()+"\n");
		}
			
	
	}
	
	/*
	* return list of op, mo
	*/
	public ArrayList<Operator> getOpList(){
		return op_list;
	}
	
	public ArrayList<Monitor> getMoList(){
		return mo_list;
	}
	
}