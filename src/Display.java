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

/*
* Probleme transfert des dates nm, srnm, type récupérer avec la popup
*/

public class Display extends JFrame{

	private JMenuBar menu_bar;
	private JMenu menu_action, menu_add;
	private JMenuItem item_op, item_mo;
	
	/* a revoir c'est un peu ninja */
	private String nm, srnm, type;
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
		
		item_op = new JMenuItem("Operateur");
		item_op.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				//addOperator();
				//JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
				//nm = jop.showInputDialog(null, "Nom : ", "Nouvel Operateur", JOptionPane.QUESTION_MESSAGE);
				Popup pop = new Popup("Operator", "New Op");
				/* 
				* Test ... 
				*/
				/*synchronized(this) {
				  while (pop.finish == false) {
					try {
					  wait();
					} catch (InterruptedException ie) {}
				  }
				}*/
		  
				Start.nm = pop.getName();
				System.out.println("Dans action listener "+nm);
			}        
		});
		
		System.out.println("Dans display "+nm);
		
		item_mo = new JMenuItem("Moniteur");
		item_mo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				System.out.println("En travaux ! ");
			}        
		});
		
		menu_add.add(item_op);
		menu_add.add(item_mo);
		
		menu_bar.add(menu_add);
	}
	
/*
	public void addOperator(){
		Popup("Operator", "Nouvel operateur");
		System.out.println("Popup intialized");	
		System.out.println(nm+"+"+srnm+"+"+type);
		Operator op = new Operator(nm, srnm, type);
	}

	public void Popup(String def, String t){
	
		f = new JFrame(t);
		p = new JPanel();
		l = new BorderLayout();
		jcb = new JComboBox();
		
		ok = new JButton("Valider");
		
		jtf_nm = new JTextField();
		jtf_srnm = new JTextField();

		label_name = new JLabel("Nom :");
		label_surname = new JLabel("Prenom :");
		label_jcb = new JLabel("Type :");
		
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				nm = jtf_nm.getText();
				srnm = jtf_srnm.getText();
				type = (String)jcb.getSelectedItem();
				f.dispose();
			}        
		});
		
		jcb.addItem("Plein temps");
		jcb.addItem("Mi-temps");
		jcb.addItem("4/5 temps");
		
		
		jtf_nm.setPreferredSize(new Dimension(120,20));
		jtf_srnm.setPreferredSize(new Dimension(120,20));
		
		// layout absolut
		p.setLayout(null);
		p.add(label_name);
		p.add(jtf_nm);
		p.add(label_surname);
		p.add(jtf_srnm);
		p.add(label_jcb);
		p.add(jcb);
		p.add(ok);
		
		label_name.setBounds(10,10,70,20);
		jtf_nm.setBounds(100,10,150,25);
		
		label_surname.setBounds(10,50,70,20);
		jtf_srnm.setBounds(100,50,150,25);
		
		label_jcb.setBounds(10,90,70,20);
		jcb.setBounds(100,90,150,25);
		
		ok.setBounds(100,130,80,30);
		
		f.setContentPane(p); 
		f.setAlwaysOnTop(true);
		f.setSize(300,200);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
		
	}*/
	
}