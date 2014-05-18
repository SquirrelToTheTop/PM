import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class Popup extends JFrame{

	private JFrame f;
	private JPanel p;
	private BorderLayout l;
	private JTextField jtf_nm, jtf_srnm;
	private JLabel label_name, label_surname, label_jcb;
	private JButton ok;
	private JComboBox<String> jcb;
	
	private String nm, srnm, type;
	private final Display d;
	private final String defstr;

	public Popup(String def, String t, Display dis){
	
		defstr = def;
	
		p = new JPanel();
		l = new BorderLayout();
		jcb = new JComboBox();
		
		ok = new JButton("Valider");
		
		jtf_nm = new JTextField();
		jtf_srnm = new JTextField();

		label_name = new JLabel("Nom :");
		label_surname = new JLabel("Prenom :");
		label_jcb = new JLabel("Type :");
		
		d = dis;
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg) {
				
				d.setData(jtf_nm.getText(),jtf_srnm.getText(),(String)jcb.getSelectedItem());
				d.ok(defstr);
				dispose();
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
		
		this.setContentPane(p); 
		this.setAlwaysOnTop(true);
		this.setSize(300,200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
	}
}