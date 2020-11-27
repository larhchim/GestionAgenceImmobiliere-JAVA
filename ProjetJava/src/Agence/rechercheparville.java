package Agence;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class rechercheparville extends JDialog{
	
	//JPanel ty1=new JPanel();
	
	JLabel ville=new JLabel("Entrer la ville");
	
	
	//JTextField villeselect =new JTextField("casa",10);
	
	ArrayList<String> tabAr = methodes.methodes.methodeVilles();
	String tableau [] =new String[tabAr.size()];
	JButton continuer =new JButton("continuer");
	
	paneau_arriereplan co =new paneau_arriereplan();
	
	public rechercheparville(JFrame g,String title,boolean a) throws Exception {
		
		super(g,title,a);
		this.setSize(350,200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    this.setModal(false);
	    co.setLayout(new GridLayout(2,2,0,100));
	    for(int i=0;i<tableau.length;i++) 
	    {
	    	tableau[i]=tabAr.get(i);
	    }
	    
	    JComboBox villeselect =new JComboBox(tableau);

	    this.setLayout(new BorderLayout());
	   // ty1.setPreferredSize(new Dimension(460,120));
	    co.add(ville);
	    
	   co.add(villeselect,BorderLayout.EAST);
	  
	   continuer.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent arg0) {
			   String s=villeselect.getSelectedItem().toString();
			   try {
				new listerechercheparville(null,"Liste de la recherche par ville", true,s);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }

	   });
	    
	  //  co.add(ty1);
	    co.add(continuer,BorderLayout.SOUTH);
	    this.add(co);
	    
		this.setVisible(true);
	}
}
