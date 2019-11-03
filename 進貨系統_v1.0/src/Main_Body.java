import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

class Cpos{
	User myUser = new User();
	Singnin mySingnin = new Singnin();
	Back myBack = new Back();
	body mybody = new body();
	Sale mySale = new Sale();
	Cpos(){
		mySingnin.f.setVisible(true);
		myUser.f.setVisible(false);;
		myBack.f.setVisible(false);
		mybody.f.setVisible(false);
		
	    mySingnin.act2.addActionListener(ProcessSwitchInterface);
		myUser.loginout.addActionListener(ProcessSwitchInterface);
		myUser.back.addActionListener(ProcessSwitchInterface);
		myBack.LogoutBtn.addActionListener(ProcessSwitchInterface);
		//myback.UsrBtn.addActionListener(ProcessSwitchInterface);
		//mysale.rebtn.addActionListener(ProcessSwitchInterface);
	}
	  //------------------------------------------//
	 class body{
		 JFrame f = new JFrame();
		 JPanel p1 = new JPanel();
		 
		 JButton inlogin  = new JButton("�i�J�i�f����");
		 JButton outlogin = new JButton("�i�J�P�f����");
		 JButton backbtn  = new JButton("�i�J��x");
		 JButton outsystem= new JButton("�n�X");
		 
		 Font font1 = new Font("�з���" , Font.BOLD, 25);
		 
		     Toolkit kit = Toolkit.getDefaultToolkit();
		     Dimension dimension = kit.getScreenSize();
		body(){
			p1.setBounds(0,0,3000,3000);       
			p1.setBackground(Color.black);    
			p1.setLayout(null);   
			f.add(p1);
			
			//�i�f���s
			inlogin.setBounds(5, 5,200,50);
			inlogin.setFont(font1);
			inlogin.setLayout(null);
			inlogin.addActionListener(ProcessSwitch);
			p1.add(inlogin);
			//�P�f���s
			outlogin.setBounds(5,60,200,50);
			outlogin.setFont(font1);
			outlogin.setLayout(null);
			outlogin.addActionListener(ProcessSwitch);
			p1.add(outlogin);
			//��x
			backbtn.setBounds(5,115,200,50);
			backbtn.setFont(font1);
			backbtn.setLayout(null);
			backbtn.addActionListener(ProcessSwitch);
			p1.add(backbtn);
			//�n�X
			outsystem.setBounds(5,170,200,50);
			outsystem.setFont(font1);
			outsystem.addActionListener(ProcessSwitch);
			outsystem.setLayout(null);
			p1.add(outsystem);
			
//------------------------------------------------------------------------------------------------------------//
			f.add(p1);  
			f.setTitle("���G�L�I���x");      
			f.setLayout(null);  
			//f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			f.setBounds(200,200,500,500);
			f.setVisible(true);            
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		public ActionListener ProcessSwitch = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == inlogin) {
					mybody.f.setVisible(false);
					myUser.f.setVisible(true);
				}
				
				if(e.getSource() == outlogin) {
					mybody.f.setVisible(false);
					//mysale.f.setVisible(true);
				}
				if(e.getSource() == backbtn) {
					for(int j=0; j<mySingnin.magerString.length; j++) {
					if(mySingnin.act1.getText().equals(mySingnin.magerString[j][1])) {
							  mySingnin.state = 1;
							  mybody.f.setVisible(false);
							  mySingnin.f.setVisible(true);
							  mySingnin.clearAction();
						} else {
							  JOptionPane.showMessageDialog(null,"��p�A�z�L��x�޲z�v���A�L�k�n�J�I","�S���v��",JOptionPane.WARNING_MESSAGE);
						  }
				}
			}
				if(e.getSource() == outsystem) {
				    mySingnin.state = 0;
					int ask = JOptionPane.showConfirmDialog(null,"�T�w�n���}���t��?","�n�X",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if( ask == JOptionPane.YES_OPTION ) {
						mybody.f.setVisible(false);
						mySingnin.f.setVisible(true);
					    mySingnin.clearAction();
					}	
				}
		};		
	 };
	 }
	 
	 
	  //------------------------------------------//
	public ActionListener ProcessSwitchInterface = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == mySingnin.act2) {
				 for(int i=0; i<mySingnin.UserString.length; i++) {
					  if(mySingnin.state == 0 && mySingnin.act1.getText().equals(mySingnin.UserString[i][1]) && mySingnin.pwt1.getText().equals(mySingnin.UserString[i][2])){
						  mySingnin.f.setVisible(false);
						  mybody.f.setVisible(true);
						  //myUsrInt.userTxtFd.setText(myLogin.UsrDataString[i][0]);
					  }
				  }
				 for(int j=0; j<mySingnin.magerString.length; j++) {
					  if(mySingnin.state == 1 && mySingnin.act1.getText().equals(mySingnin.magerString[j][1]) && mySingnin.pwt1.getText().equals(mySingnin.magerString[j][2])){
						  mySingnin.f.setVisible(false);
						  myBack.f.setVisible(true);
					  }
				  }
			}
			 if(e.getSource() == myUser.loginout) {
				  int ask = JOptionPane.showConfirmDialog(null,"�T�w�n��^���?","��^���",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				  if( ask == JOptionPane.YES_OPTION ) {
					  mySingnin.state = 0;
					  myUser.f.setVisible(false);
					  mybody.f.setVisible(true);
				  }
			  }
			 if(e.getSource() == mySale.rebtn) {
				  int ask = JOptionPane.showConfirmDialog(null,"�T�w�n��^���?","��^���",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				  if( ask == JOptionPane.YES_OPTION ) {
					  mySingnin.state = 0;
					  //mysale.f.setVisible(false);
					  mybody.f.setVisible(true);
				  }
			  }
 		 if(e.getSource() == myUser.back ) {
			  for(int j=0; j<mySingnin.magerString.length; j++) {
		  //
				  if(mySingnin.act1.getText().equals(mySingnin.magerString[j][1])){
						  mySingnin.state = 1;
						  myUser.f.setVisible(false);
						  mySingnin.f.setVisible(true);
						  mySingnin.clearAction();
					  }
					  else {
						  JOptionPane.showMessageDialog(null,"��p�A�z�L��x�޲z�v���A�L�k�n�J�I","�S���v��",JOptionPane.WARNING_MESSAGE);
					  }
				  }
			  }
 		 //
//			 if(e.getSource() == myback.UsrBtn) {
//				  mySingnin.state = 0;
//				  myback.f.setVisible(false);
//				  mymenu.f.setVisible(true);
//			  }
		//
			  if(e.getSource() == myBack.LogoutBtn) {
				  int ask = JOptionPane.showConfirmDialog(null,"�T�w�n��^���?","�O",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				  if( ask == JOptionPane.YES_OPTION ) {
					  myBack.f.setVisible(false);
					  mybody.f.setVisible(true);
				  }
			  }
		}
	};
}

public class Main_Body {
	public static void main(String[] args) {
		Cpos mypos = new Cpos();
	}
}
