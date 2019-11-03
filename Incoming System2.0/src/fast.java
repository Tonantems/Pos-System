import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.plaf.*;
import javax.swing.table.*;
import javax.swing.*;
import java.util.*;
class fast {
	JFrame f = new JFrame();
	JPanel p1 = new JPanel();
	
	JButton[][] mealBtn = new JButton[3][3];
	JButton[][] mealBtn2 = new JButton[3][3];
	JButton[][] mealBtn3 = new JButton[3][3];
    String[][] mealBtnString = {{"蘋果","香蕉","芭樂"},
                                {"榴槤","奇異果","柳丁"},
                                {"哈密瓜","西瓜","橘子"}};
    
    String[][] mealBtnString2 = {{"蘋果","香蕉","芭樂"},
                                {"榴槤","奇異果","柳丁"},
                                {"哈密瓜","西瓜","橘子"}};
    
    String[][] mealBtnString3 = {{"蘋果","香蕉","芭樂"},
                                {"榴槤","奇異果","柳丁"},
                                {"哈密瓜","西瓜","橘子"}};
    
    
    String[][] mealPriceString = {{"180","150","120"},
                                  {"70","60","50"},
                                  {"30","30","30"}};
    
    String[][] mealPriceString2 = {{"180","150","120"},
                                  {"70","60","50"},
                                  {"30","30","30"}};
    
    String[][] mealPriceString3 = {{"180","150","120"},
                                  {"70","60","50"},
                                  {"30","30","30"}};
	
	JTabbedPane mytabpane = new JTabbedPane();
	Font font1 = new Font("標楷體",Font.BOLD,20);
	 String tabTxt1 = "快捷鍵1";
	 String tabTxt2 = "快捷鍵2";
	 String tabTxt3 = "快捷鍵3";
	 	
	fast(){
		mytabpane.setBounds(0,0,530,260);//頁籤容器
		
		 p1.setBounds(0,0,1000,740);      
	     p1.setBackground(new Color(255,222,173));     
	     p1.setLayout(null);               
	     f.add(p1);
	   //-----設定容器panel裡擺放的物件   
	     JPanel mypanel = new JPanel();
	     mytabpane.add(tabTxt1,mypanel);//頁籤容器內第一個頁籤的索引及內容
	     mypanel.setBackground(Color.green);     
	     mypanel.setLayout(null);
	     
	     for(int i=0; i<mealBtn.length; i++){
	       		for(int j=0; j<mealBtn[0].length; j++){
	              		mealBtn[i][j] = new JButton(mealBtnString[i][j]);
	              		mealBtn[i][j].setFont(font1);
	              		mealBtn[i][j].setBounds(0+j*105,0+i*55,100,50);                 
	              		mealBtn[i][j].setBackground(Color.orange);
	                    mealBtn[i][j].addActionListener(ProcessMealBtn);     //將每一個mealBtn[][]註冊到傾聽程式ProcessMealBtn
	              		mypanel.add(mealBtn[i][j]);                              
	       		}
	  		}
	     
	   //-----設定容器panel2裡擺放的物件
	     JPanel mypanel2 = new JPanel();
	     mytabpane.add(tabTxt2,mypanel2);//頁籤容器內第二個頁籤的索引及內容
	     mypanel2.setBackground(Color.green);     
	     mypanel2.setLayout(null);
	     
	     for(int i=0; i<mealBtn2.length; i++){
	       		for(int j=0; j<mealBtn2[0].length; j++){
	              		mealBtn2[i][j] = new JButton(mealBtnString2[i][j]);
	              		mealBtn2[i][j].setFont(font1);
	              		mealBtn2[i][j].setBounds(0+j*105,0+i*55,100,50);                 
	              		mealBtn2[i][j].setBackground(Color.orange);
	                    mealBtn2[i][j].addActionListener(ProcessMealBtn2);     //將每一個mealBtn[][]註冊到傾聽程式ProcessMealBtn
	              		mypanel2.add(mealBtn2[i][j]);                              
	       		}
	  		}
	     
	    //-----設定容器panel3裡擺放的物件
	     JPanel mypanel3 = new JPanel();
	     mytabpane.add(tabTxt3,mypanel3);//頁籤容器內第二個頁籤的索引及內容
	     mypanel3.setBackground(Color.green);     
	     mypanel3.setLayout(null);
	     
	     for(int i=0; i<mealBtn3.length; i++){
	       		for(int j=0; j<mealBtn3[0].length; j++){
	              		mealBtn3[i][j] = new JButton(mealBtnString3[i][j]);
	              		mealBtn3[i][j].setFont(font1);
	              		mealBtn3[i][j].setBounds(0+j*105,0+i*55,100,50);                 
	              		mealBtn3[i][j].setBackground(Color.orange);
	                    mealBtn3[i][j].addActionListener(ProcessMealBtn3);     //將每一個mealBtn[][]註冊到傾聽程式ProcessMealBtn
	              		mypanel3.add(mealBtn3[i][j]);                              
	       		}
	  		}
	     
	     p1.add(mytabpane);
	     
	      //--------------
		f.setTitle("品項快捷鍵");
		f.setBounds(330,320,330,230);
		f.setLayout(null);
		f.setResizable(false);
	}
	          //品項鍵傾聽
	public  ActionListener ProcessMealBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<mealBtn.length; i++){
                for(int j=0; j<mealBtn[0].length; j++){
                           if( e.getSource() == mealBtn[i][j] ){
                        	   menu.goodstxt.setText(mealBtn[i][j].getText());  //顯示[品項]
                        	   String d = mealPriceString[i][j];
                                      menu.priceone.setText(d);   //顯示[單價]
                                      String one = "1";      
                                      menu.numtxt.setText(one);  //預設數量為1
                                         //預設小計為[單價]x1
                           } } }    
		}
};

public  ActionListener ProcessMealBtn2 = new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<mealBtn2.length; i++){
            for(int j=0; j<mealBtn2[0].length; j++){
                       if( e.getSource() == mealBtn2[i][j] ){
                    	   menu.goodstxt.setText(mealBtn2[i][j].getText());  //顯示[品項]
                    	   String d = mealPriceString2[i][j];
                                  menu.priceone.setText(d);   //顯示[單價]
                                  String one = "1";      
                                  menu.numtxt.setText(one);  //預設數量為1
                                     //預設小計為[單價]x1
                       } } }    
	}
};

public  ActionListener ProcessMealBtn3 = new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<mealBtn3.length; i++){
            for(int j=0; j<mealBtn3[0].length; j++){
                       if( e.getSource() == mealBtn3[i][j] ){
                    	   menu.goodstxt.setText(mealBtn3[i][j].getText());  //顯示[品項]
                    	   String d = mealPriceString3[i][j];
                                  menu.priceone.setText(d);   //顯示[單價]
                                  String one = "1";      
                                  menu.numtxt.setText(one);  //預設數量為1
                                     //預設小計為[單價]x1
                       } } }    
	}
};


}
