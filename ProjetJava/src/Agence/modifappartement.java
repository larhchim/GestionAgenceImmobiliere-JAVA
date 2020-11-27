package Agence;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import methodes.appartement;
import methodes.maison;
import methodes.methodes;
import methodes.villa;

public class modifappartement extends JDialog{
	
	public modifappartement(JFrame a,String b , boolean c) throws Exception {
		 super(a,b,c);
		 this.setSize(new Dimension(1100,500));
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setModal(false);
			 ArrayList<appartement> tab=methodes.liste_des_appartements() ;
			 Object [][] data = new Object[tab.size()][10] ;
			 
				  for(int i=0;i<tab.size();i++) 
				  {
					  for(int j=0;j<10;j++) 
					  {
						  switch(j) 
						  {
						  case 0 : data[i][j]=(int) tab.get(i).getIda();
						  break;
						  case 1 : data[i][j]=(double)tab.get(i).getPrix();
						  break;
						  case 2 : data[i][j]=(String)tab.get(i).getVille();
						  break;
						  case 3 : data[i][j]=(String) tab.get(i).getSuperficie() ;
						  break;
						  case 4 : data[i][j]=(String)tab.get(i).getAdresse();
						  break;
						  case 5 : data[i][j]=(int)tab.get(i).getNbrechambres();
						  break;
						  case 6 : data[i][j]=(int)tab.get(i).getNumeetage();
						  break;
						  case 7 : data[i][j]=(int)tab.get(i).getNbrecuisines();
						  break;
						  case 8 : data[i][j]=(int)tab.get(i).getNbrebains();
						  break;
						  case 9:  data[i][j]=(int)tab.get(i).getNbretoilettes();
							  break;
						 
						  }
					  }
				  }
				  
				  String titre[]={"ida","prix","ville","superficie","Adresse","nombre de chambres","nombre d etages","nombre de cuisines","nombre de bains","nombre de toilletes" };
				  JTable tabRes = new JTable(data,titre);
				  this.add(new JScrollPane(tabRes));
				  
				  
				  tabRes.addMouseListener( new MouseListener() {

						@Override
						public void mouseClicked(MouseEvent evt) 
						{
							
					            int row = tabRes.rowAtPoint( evt.getPoint() );
					            int s=(int) tabRes.getModel().getValueAt(row, 0);
					            JOptionPane confirmation = new JOptionPane();
					            int conf = confirmation.showConfirmDialog(null, "voulez vous Modifier cette appartement ?","Confirmation de Modification",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					         if(conf==JOptionPane.OK_OPTION) {
					        
					        	 try {
					        
						        		
                                new insermodifappartement(null,"Boite De Confirmation De Modification appartement",true,s);
                                dispose();
					        	
					        	 }catch(Exception e) {
					        		 e.printStackTrace();
					        	 }

					         }
						}

						@Override
						public void mouseEntered(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseExited(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mousePressed(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseReleased(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}
				  });
					            
				
				  
				  
			      this.setVisible(true);
	}

}
