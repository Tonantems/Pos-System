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
    String[][] mealBtnString = {{"ī�G","����","�ݼ�"},
                                {"�h��","�_���G","�h�B"},
                                {"���K��","���","��l"}};
    
    String[][] mealBtnString2 = {{"ī�G","����","�ݼ�"},
                                {"�h��","�_���G","�h�B"},
                                {"���K��","���","��l"}};
    
    String[][] mealBtnString3 = {{"ī�G","����","�ݼ�"},
                                {"�h��","�_���G","�h�B"},
                                {"���K��","���","��l"}};
    
    
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
	Font font1 = new Font("�з���",Font.BOLD,20);
	 String tabTxt1 = "�ֱ���1";
	 String tabTxt2 = "�ֱ���2";
	 String tabTxt3 = "�ֱ���3";
	 	
	fast(){
		mytabpane.setBounds(0,0,530,260);//���Үe��
		
		 p1.setBounds(0,0,1000,740);      
	     p1.setBackground(new Color(255,222,173));     
	     p1.setLayout(null);               
	     f.add(p1);
	   //-----�]�w�e��panel���\�񪺪���   
	     JPanel mypanel = new JPanel();
	     mytabpane.add(tabTxt1,mypanel);//���Үe�����Ĥ@�ӭ��Ҫ����ޤΤ��e
	     mypanel.setBackground(Color.green);     
	     mypanel.setLayout(null);
	     
	     for(int i=0; i<mealBtn.length; i++){
	       		for(int j=0; j<mealBtn[0].length; j++){
	              		mealBtn[i][j] = new JButton(mealBtnString[i][j]);
	              		mealBtn[i][j].setFont(font1);
	              		mealBtn[i][j].setBounds(0+j*105,0+i*55,100,50);                 
	              		mealBtn[i][j].setBackground(Color.orange);
	                    mealBtn[i][j].addActionListener(ProcessMealBtn);     //�N�C�@��mealBtn[][]���U���ť�{��ProcessMealBtn
	              		mypanel.add(mealBtn[i][j]);                              
	       		}
	  		}
	     
	   //-----�]�w�e��panel2���\�񪺪���
	     JPanel mypanel2 = new JPanel();
	     mytabpane.add(tabTxt2,mypanel2);//���Үe�����ĤG�ӭ��Ҫ����ޤΤ��e
	     mypanel2.setBackground(Color.green);     
	     mypanel2.setLayout(null);
	     
	     for(int i=0; i<mealBtn2.length; i++){
	       		for(int j=0; j<mealBtn2[0].length; j++){
	              		mealBtn2[i][j] = new JButton(mealBtnString2[i][j]);
	              		mealBtn2[i][j].setFont(font1);
	              		mealBtn2[i][j].setBounds(0+j*105,0+i*55,100,50);                 
	              		mealBtn2[i][j].setBackground(Color.orange);
	                    mealBtn2[i][j].addActionListener(ProcessMealBtn2);     //�N�C�@��mealBtn[][]���U���ť�{��ProcessMealBtn
	              		mypanel2.add(mealBtn2[i][j]);                              
	       		}
	  		}
	     
	    //-----�]�w�e��panel3���\�񪺪���
	     JPanel mypanel3 = new JPanel();
	     mytabpane.add(tabTxt3,mypanel3);//���Үe�����ĤG�ӭ��Ҫ����ޤΤ��e
	     mypanel3.setBackground(Color.green);     
	     mypanel3.setLayout(null);
	     
	     for(int i=0; i<mealBtn3.length; i++){
	       		for(int j=0; j<mealBtn3[0].length; j++){
	              		mealBtn3[i][j] = new JButton(mealBtnString3[i][j]);
	              		mealBtn3[i][j].setFont(font1);
	              		mealBtn3[i][j].setBounds(0+j*105,0+i*55,100,50);                 
	              		mealBtn3[i][j].setBackground(Color.orange);
	                    mealBtn3[i][j].addActionListener(ProcessMealBtn3);     //�N�C�@��mealBtn[][]���U���ť�{��ProcessMealBtn
	              		mypanel3.add(mealBtn3[i][j]);                              
	       		}
	  		}
	     
	     p1.add(mytabpane);
	     
	      //--------------
		f.setTitle("�~���ֱ���");
		f.setBounds(330,320,330,230);
		f.setLayout(null);
		f.setResizable(false);
	}
	          //�~�����ť
	public  ActionListener ProcessMealBtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<mealBtn.length; i++){
                for(int j=0; j<mealBtn[0].length; j++){
                           if( e.getSource() == mealBtn[i][j] ){
                        	   menu.goodstxt.setText(mealBtn[i][j].getText());  //���[�~��]
                        	   String d = mealPriceString[i][j];
                                      menu.priceone.setText(d);   //���[���]
                                      String one = "1";      
                                      menu.numtxt.setText(one);  //�w�]�ƶq��1
                                         //�w�]�p�p��[���]x1
                           } } }    
		}
};

public  ActionListener ProcessMealBtn2 = new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<mealBtn2.length; i++){
            for(int j=0; j<mealBtn2[0].length; j++){
                       if( e.getSource() == mealBtn2[i][j] ){
                    	   menu.goodstxt.setText(mealBtn2[i][j].getText());  //���[�~��]
                    	   String d = mealPriceString2[i][j];
                                  menu.priceone.setText(d);   //���[���]
                                  String one = "1";      
                                  menu.numtxt.setText(one);  //�w�]�ƶq��1
                                     //�w�]�p�p��[���]x1
                       } } }    
	}
};

public  ActionListener ProcessMealBtn3 = new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<mealBtn3.length; i++){
            for(int j=0; j<mealBtn3[0].length; j++){
                       if( e.getSource() == mealBtn3[i][j] ){
                    	   menu.goodstxt.setText(mealBtn3[i][j].getText());  //���[�~��]
                    	   String d = mealPriceString3[i][j];
                                  menu.priceone.setText(d);   //���[���]
                                  String one = "1";      
                                  menu.numtxt.setText(one);  //�w�]�ƶq��1
                                     //�w�]�p�p��[���]x1
                       } } }    
	}
};


}
