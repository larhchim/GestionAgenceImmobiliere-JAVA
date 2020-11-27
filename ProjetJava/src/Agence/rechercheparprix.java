package Agence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class rechercheparprix extends JDialog{
	
	JPanel ty1=new JPanel();
	JPanel ty2=new JPanel();
	
	JLabel min=new JLabel("    Entrer le prix minimum    ");
	JLabel max=new JLabel("    Entrer le prix maxixum    ");
	
	JTextField prixmin =new JTextField("250000",20);
//	prixmin.setPreferredSize(new Dimension(100, 20));
	JTextField prixmax =new JTextField("1000000",20);

	loginpassconn mb=new loginpassconn();
	JButton continuer =new JButton("continuer");
	paneau_arriereplan co =new paneau_arriereplan();
	
	public rechercheparprix(JFrame g,String title,boolean a) throws Exception {
		
		super(g,title,a);
		this.setSize(500,200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	prixmin.setPreferredSize(new Dimension(100,50));
	prixmax.setPreferredSize(new Dimension(100,50));

	    this.setModal(false);
	   // mb.add(continuer);

	    continuer.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent arg0) {
				   try {
					   double x,y;
					   x=(double)Integer.parseInt(prixmin.getText());
					   y=(double)Integer.parseInt(prixmax.getText());;
					new listerechercheparprix(null,"Liste de la recherche par prix", true,x,y);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane error=new JOptionPane();
					error.showMessageDialog(null,"veuillez inserer des donnees valides","ERREUR!", JOptionPane.ERROR_MESSAGE);
				}
			   }

		   });
	    ty1.add(min);
	    ty1.add(prixmin);
	    ty1.setSize(100, 10);
	    
	    ty2.add(max);
	    ty2.add(prixmax);
	    ty2.setSize(100, 10);
	    
	    ty1.setPreferredSize(new Dimension(490,60));
	    ty2.setPreferredSize(new Dimension(490,60));

	    co.add(ty1);
	    co.add(ty2);
	   // co.add(mb);
	    co.add(continuer);
	    this.add(co);
	    
		this.setVisible(true);
	}
	
	
}
