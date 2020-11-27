package Agence;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import methodes.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class insermaison extends JDialog{
	
	public insermaison(JFrame g,String title,boolean a) {
		super(g,title,a);
		this.setSize(new Dimension(800,300));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		paneau_arriereplan p=new paneau_arriereplan();
		p.setLayout(new GridLayout(5,4,5,5));
		this.setModal(false);
		
		
		//JLabels
		JLabel prix=new JLabel("     Prix");
		JLabel ville=new JLabel("     ville");
		JLabel superficie=new JLabel("     superficie");
		JLabel adresse=new JLabel("     adresse");
		JLabel nbrchambres=new JLabel("     nombre de chambres");
		JLabel nbretages=new JLabel("     nombre d tages");
		JLabel nbrcuisines=new JLabel("     nombre de cuisines");
		JLabel nbrbains=new JLabel("     nombre de bains");
		JLabel nbrtoilettes=new JLabel("     nombre de toilettes");
		
		
		//JTextFiels
		
		JTextField prixselect =new JTextField();
		JTextField villeselect =new JTextField();
		JFormattedTextField superficieselect =new JFormattedTextField(NumberFormat.getIntegerInstance());
		JTextField adresseselect =new JTextField();
		JTextField nbrchambresselect =new JTextField();
		JTextField nbretagesselect =new JTextField();
		JTextField nbrcuisinesselect =new JTextField();
		JTextField nbrbainsselect =new JTextField();
		JTextField nbrtoilettesselect =new JTextField();
		
		
		
		//bouton inserer
				JButton inserer=new JButton("inserer");
				inserer.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
						double pr=(double)Integer.parseInt(prixselect.getText());
						String vi=villeselect.getText();
						String su=superficieselect.getText();
						String ad=adresseselect.getText();
						int nc=Integer.parseInt(nbrchambresselect.getText());
						int ne=Integer.parseInt(nbretagesselect.getText());
						int ncu=Integer.parseInt(nbrcuisinesselect.getText());
						int nb=Integer.parseInt(nbrbainsselect.getText());
						int nt=Integer.parseInt(nbrtoilettesselect.getText());
						JOptionPane.showMessageDialog(null, "Votre Maison est compt� ins�r� avec succ�s","Message Informatif",JOptionPane.INFORMATION_MESSAGE);

							methodes.inserer_dans_maison(pr,vi,su,ad,nc,ne,ncu,nb,nt);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							JOptionPane error=new JOptionPane();
							error.showMessageDialog(null,"veuillez inserer des donnees valides","ERREUR!", JOptionPane.ERROR_MESSAGE);
						}
						
					}
				});
		
		
		
		
		p.add(prix);
		p.add(prixselect);
		p.add(ville);
		p.add(villeselect);
		p.add(superficie);
		p.add(superficieselect);
		p.add(adresse);
		p.add(adresseselect);
		p.add(nbrchambres);
		p.add(nbrchambresselect);
		p.add(nbretages);
		p.add(nbretagesselect);
		p.add(nbrcuisines);
		p.add(nbrcuisinesselect);
		p.add(nbrbains);
		p.add(nbrbainsselect);
		p.add(nbrtoilettes);
		p.add(nbrtoilettesselect);
		p.add(inserer);
		
		this.add(p);
		this.setVisible(true);
		
	}

}
