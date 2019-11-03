import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

class Cpos{
	menu mymenu = new menu();
	Singnin mySingnin = new Singnin();
	back myback = new back();
	body mybody = new body();
	sale mysale = new sale();
	Cpos(){
		mySingnin.f.setVisible(true);
		mymenu.f.setVisible(false);;
		myback.f.setVisible(false);
		mybody.f.setVisible(false);
		mysale.f.setVisible(false);
	    mySingnin.act2.addActionListener(ProcessSwitchInterface);
		mymenu.loginout.addActionListener(ProcessSwitchInterface);
		mymenu.back.addActionListener(ProcessSwitchInterface);
		myback.LogoutBtn.addActionListener(ProcessSwitchInterface);
		//myback.UsrBtn.addActionListener(ProcessSwitchInterface);
		mysale.rebtn.addActionListener(ProcessSwitchInterface);
	}
	  //------------------------------------------//
	 class body{
		 JFrame f = new JFrame();
		 JPanel p1 = new JPanel();
		 
		 JButton inlogin  = new JButton("進入進貨介面");
		 JButton outlogin = new JButton("進入銷貨介面");
		 JButton backbtn  = new JButton("進入後台");
		 JButton outsystem= new JButton("登出");
		 
		 Font font1 = new Font("標楷體" , Font.BOLD, 25);
		 
		     Toolkit kit = Toolkit.getDefaultToolkit();
		     Dimension dimension = kit.getScreenSize();
		body(){
			p1.setBounds(0,0,3000,3000);       
			p1.setBackground(Color.black);    
			p1.setLayout(null);   
			f.add(p1);
			
			//進貨按鈕
			inlogin.setBounds(5, 5,200,50);
			inlogin.setFont(font1);
			inlogin.setLayout(null);
			inlogin.addActionListener(ProcessSwitch);
			p1.add(inlogin);
			//銷貨按鈕
			outlogin.setBounds(5,60,200,50);
			outlogin.setFont(font1);
			outlogin.setLayout(null);
			outlogin.addActionListener(ProcessSwitch);
			p1.add(outlogin);
			//後台
			backbtn.setBounds(5,115,200,50);
			backbtn.setFont(font1);
			backbtn.setLayout(null);
			backbtn.addActionListener(ProcessSwitch);
			p1.add(backbtn);
			//登出
			outsystem.setBounds(5,170,200,50);
			outsystem.setFont(font1);
			outsystem.addActionListener(ProcessSwitch);
			outsystem.setLayout(null);
			p1.add(outsystem);
			
//------------------------------------------------------------------------------------------------------------//
			f.add(p1);  
			f.setTitle("水果盤點平台");      
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
					mymenu.f.setVisible(true);
				}
				
				if(e.getSource() == outlogin) {
					mybody.f.setVisible(false);
					mysale.f.setVisible(true);
				}
				if(e.getSource() == backbtn) {
					for(int j=0; j<mySingnin.magerString.length; j++) {
					if(mySingnin.act1.getText().equals(mySingnin.magerString[j][1])) {
							  mySingnin.state = 1;
							  mybody.f.setVisible(false);
							  mySingnin.f.setVisible(true);
							  mySingnin.clearAction();
						} else {
							  JOptionPane.showMessageDialog(null,"抱歉，您無後台管理權限，無法登入！","沒有權限",JOptionPane.WARNING_MESSAGE);
						  }
				}
			}
				if(e.getSource() == outsystem) {
				    mySingnin.state = 0;
					int ask = JOptionPane.showConfirmDialog(null,"確定要離開本系統?","登出",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
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
						  myback.f.setVisible(true);
					  }
				  }
			}
			 if(e.getSource() == mymenu.loginout) {
				  int ask = JOptionPane.showConfirmDialog(null,"確定要返回選單?","返回選單",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				  if( ask == JOptionPane.YES_OPTION ) {
					  mySingnin.state = 0;
					  mymenu.f.setVisible(false);
					  mybody.f.setVisible(true);
				  }
			  }
			 if(e.getSource() == mysale.rebtn) {
				  int ask = JOptionPane.showConfirmDialog(null,"確定要返回選單?","返回選單",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				  if( ask == JOptionPane.YES_OPTION ) {
					  mySingnin.state = 0;
					  mysale.f.setVisible(false);
					  mybody.f.setVisible(true);
				  }
			  }
 		 if(e.getSource() == mymenu.back ) {
			  for(int j=0; j<mySingnin.magerString.length; j++) {
		  //
				  if(mySingnin.act1.getText().equals(mySingnin.magerString[j][1])){
						  mySingnin.state = 1;
						  mymenu.f.setVisible(false);
						  mySingnin.f.setVisible(true);
						  mySingnin.clearAction();
					  }
					  else {
						  JOptionPane.showMessageDialog(null,"抱歉，您無後台管理權限，無法登入！","沒有權限",JOptionPane.WARNING_MESSAGE);
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
			  if(e.getSource() == myback.LogoutBtn) {
				  int ask = JOptionPane.showConfirmDialog(null,"確定要返回選單?","是",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				  if( ask == JOptionPane.YES_OPTION ) {
					  myback.f.setVisible(false);
					  mybody.f.setVisible(true);
				  }
			  }
		}
	};
}

public class body {
	public static void main(String[] args) {
		Cpos mypos = new Cpos();
	}
}
