import java.awt.Color;
import java.awt.Font;
import javax.swing.border.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.awt.*;    
import javax.swing.*;
import javax.swing.plaf.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing. table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Toolkit;

class sale {
	
	
	JFrame f = new JFrame();
	JPanel p1 = new JPanel();
	JButton rebtn = new JButton("返回");
	
	JButton payBtn = new JButton("付現");
	JButton totalBtn = new JButton("結 帳");
	
	JLabel totalLab = new JLabel("Total:");
	
	JTextField shiftTxtFd = new JTextField("");//班別
    JTextField userTxtFd = new JTextField();//使用者
    JTextField digitTxtFd = new JTextField("0");
	
	JTable myTable;
	JScrollPane  mySPane;
	String table_title[] = {"品項","單價","數量","小計(元)"};
	String[][] table_Data = new String[100][4];
	
	JButton[] operateBtn = new JButton[3];
    String[] operateBtnString = {"清空所有","重新選取","商品確認"};
    JTextField totalTxtFd = new JTextField("");
	
	//計算機
	JButton[][] digitBtn = new JButton[4][3];
    String[][] digitBtnString = {{"7","8","9"},{"4","5","6"},{"1","2","3"},{"0","00","C"}};
    
    
    //
    JTabbedPane mytabpane = new JTabbedPane();
    
     String tabTxt1 = "快捷鍵1";
	 String tabTxt2 = "快捷鍵2";
	 String tabTxt3 = "快捷鍵3";
	 
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
	
	
	
	Font font1 = new Font("標楷體" , Font.BOLD, 25);
	Font font2 = new Font("標楷體" , Font.BOLD, 17);
	
	Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension dimension = kit.getScreenSize();
    
    Date now = new Date();//取得時間
    
    int rowIndex = 0;
	int amount;
	int price;
	int total;
	int pay;
    
     sale(){
    	 
    	 
    	 
    	 //表格
    	myTable = new JTable(table_Data, table_title);   
 		myTable.setEnabled(true); 
 		myTable.setRowSelectionAllowed(true);    //選取表格整行
 		myTable.setColumnSelectionAllowed(false);
 		myTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 		myTable.setRowHeight(30);                        		
 		myTable.setFont(new Font("新細明體", Font.PLAIN, 16));
    	 
 		for(int i=0; i<table_Data.length; i++)
            for(int j=0; j<table_Data[0].length; j++)
                    myTable.setValueAt("",i,j);
		mySPane = new JScrollPane(myTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);  
  		mySPane.setBounds(5,5,500,dimension.height-50);    //表格位置
  		mySPane.setVisible(true);                
  		p1.add(mySPane);
  		
  		//
		mytabpane.setBounds(850,70,500,500);//頁籤容器
		
		 p1.setBounds(0,0,1000,740);      
	     p1.setBackground(new Color(255,222,173));     
	     p1.setLayout(null);               
	     f.add(p1);
	   //-----設定容器panel裡擺放的物件   
	     JPanel mypanel = new JPanel();
	     mytabpane.add(tabTxt1,mypanel);//頁籤容器內第一個頁籤的索引及內容
	     mypanel.setBackground(Color.green);     
	     mypanel.setLayout(null);

	   //-----設定容器panel2裡擺放的物件
	     JPanel mypanel2 = new JPanel();
	     mytabpane.add(tabTxt2,mypanel2);//頁籤容器內第二個頁籤的索引及內容
	     mypanel2.setBackground(Color.green);     
	     mypanel2.setLayout(null);
	     
	    //-----設定容器panel3裡擺放的物件
	     JPanel mypanel3 = new JPanel();
	     mytabpane.add(tabTxt3,mypanel3);//頁籤容器內第二個頁籤的索引及內容
	     mypanel3.setBackground(Color.green);     
	     mypanel3.setLayout(null);
	     
	     //-------------p1
	     
	     for(int i=0; i<mealBtn.length; i++){
	       		for(int j=0; j<mealBtn[0].length; j++){
	              		mealBtn[i][j] = new JButton(mealBtnString[i][j]);
	              		mealBtn[i][j].setFont(font1);
	              		mealBtn[i][j].setBounds(0+j*160,0+i*55,150,50);                 
	              		mealBtn[i][j].setBackground(Color.orange);
	                    mealBtn[i][j].addActionListener(ProcessProductBtn);     //將每一個mealBtn[][]註冊到傾聽程式ProcessMealBtn
	              		mypanel.add(mealBtn[i][j]);                              
	       		}
	  		}
	     
	     //---------------p2
	     
	     for(int i=0; i<mealBtn2.length; i++){
	       		for(int j=0; j<mealBtn2[0].length; j++){
	              		mealBtn2[i][j] = new JButton(mealBtnString2[i][j]);
	              		mealBtn2[i][j].setFont(font1);
	              		mealBtn2[i][j].setBounds(0+j*155,0+i*55,150,50);                 
	              		mealBtn2[i][j].setBackground(Color.orange);
	                    mealBtn2[i][j].addActionListener(ProcessProductBtn2);     //將每一個mealBtn[][]註冊到傾聽程式ProcessMealBtn
	              		mypanel2.add(mealBtn2[i][j]);                              
	       		}
	  		}
	     
	     //---------------p3
	     
	     for(int i=0; i<mealBtn3.length; i++){
	       		for(int j=0; j<mealBtn3[0].length; j++){
	              		mealBtn3[i][j] = new JButton(mealBtnString3[i][j]);
	              		mealBtn3[i][j].setFont(font1);
	              		mealBtn3[i][j].setBounds(0+j*155,0+i*55,150,50);                 
	              		mealBtn3[i][j].setBackground(Color.orange);
	                    mealBtn3[i][j].addActionListener(ProcessProductBtn3);     //將每一個mealBtn[][]註冊到傾聽程式ProcessMealBtn
	              		mypanel3.add(mealBtn3[i][j]);                              
	       		}
	  		}
	     
	     p1.add(mytabpane);
  		
  		
  		
  		
  		
  		
  		//班別
  		shiftTxtFd.setBounds(900,10,105,45);
 		shiftTxtFd.setFont(font1);
 		shiftTxtFd.setHorizontalAlignment(JTextField.CENTER);
 		shiftTxtFd.setEditable(false);
 		if(now.getHours()>=8 && now.getHours()<12)
 			shiftTxtFd.setText("早班");
 		else if(now.getHours()>=12 && now.getHours()<18)
 			shiftTxtFd.setText("中班");
 		else if(now.getHours()>=18 && now.getHours()<22)
 			shiftTxtFd.setText("晚班");
 		else {
 			shiftTxtFd.setText("休息中");
 		}	
 		p1.add(shiftTxtFd);
 		
 		//使用者
		
 				userTxtFd.setBounds(1020,10,220,45);
 				userTxtFd.setFont(font1);
 				userTxtFd.setHorizontalAlignment(JTextField.CENTER);
 				userTxtFd.setEditable(false);
 				p1.add(userTxtFd);
 		//計算機
 				
 				for(int i=0; i<digitBtn.length; i++) {
 					for(int j=0; j<digitBtn[0].length; j++) {
 						digitBtn[i][j] = new JButton(digitBtnString[i][j]);
 						digitBtn[i][j].setBounds(570+j*90,100+i*90,80,80);
 						//digitBtn[i][j].setBackground(color9);
 						digitBtn[i][j].setFont(font1);
 						digitBtn[i][j].addActionListener(ProcessDigitBtn);
 						p1.add(digitBtn[i][j]);
 					}
 				}
 				
 				digitTxtFd.setBounds(585,25,216,50);
 				digitTxtFd.setFont(font1);
 				digitTxtFd.setHorizontalAlignment(JTextField.RIGHT);
 				digitTxtFd.setEditable(false);
 				digitTxtFd.setBorder(BorderFactory.createLineBorder(Color.black,2));
 				p1.add(digitTxtFd);
  		 //功能鍵
 				for(int i=0; i<operateBtn.length; i++) {
 					operateBtn[i] = new JButton(operateBtnString[i]);
 					operateBtn[i].setBounds(510+i*115,460,105,50);
 					operateBtn[i].setFont(font2);
 					switch(i) {

 					case 0:
 						operateBtn[i].setBorder(BorderFactory.createLoweredBevelBorder());
 						//operateBtn[i].setBackground(color9);
 					break;
 					case 1:
 						operateBtn[i].setBorder(BorderFactory.createLoweredBevelBorder());
 						//operateBtn[i].setBackground(color6);
 					break;
 					case 2:
 						operateBtn[i].setBorder(BorderFactory.createRaisedBevelBorder());
 						//operateBtn[i].setBackground(color8);
 					}
 					operateBtn[i].addActionListener(ProcessOperateBtn);
 					p1.add(operateBtn[i]);
 				}//以上為p1
  		//
 				totalLab.setBounds(510,520,100,50);
 				totalLab.setFont(font1);
 				p1.add(totalLab);
 				
 				totalTxtFd.setBounds(600,525,250,50);
 				totalTxtFd.setFont(font1);
 				totalTxtFd.setEditable(false);
 				totalTxtFd.setBorder(BorderFactory.createRaisedBevelBorder());
 				p1.add(totalTxtFd);
  		//
 				payBtn.setBounds(750,580,90,65);
 				payBtn.setFont(font1);
 				//payBtn.setBackground(color1);
 				payBtn.setBorder(BorderFactory.createRaisedBevelBorder());
 				payBtn.addActionListener(ProcessPayBtn);
 				p1.add(payBtn);
 				
 		//
 				totalBtn.setBounds(520,580,190,85);
 				totalBtn.setFont(font1);
 				totalBtn.setBackground(Color.red);
 				totalBtn.setForeground(Color.white);
 				totalBtn.setBorder(BorderFactory.createLineBorder(Color.black,3));
 				totalBtn.addActionListener(ProcessTotalBtn);
 				p1.add(totalBtn);
 				
 				
  		
  		
  		
//--------------------------------------------------------------------------------------------//
  		
    	 
    	 
    	 
    	p1.setBounds(0,0,1500,1500);       
 		p1.setBackground(Color.gray);    
 		p1.setLayout(null);   
 		f.add(p1);

 		rebtn.setBounds(dimension.width-110,10,100,50);
 		rebtn.setBackground(Color.green);
 		rebtn.setBorder(new BevelBorder(BevelBorder.RAISED));
 		rebtn.setFont(font1);
 		p1.add(rebtn);
 		
//-------------------------------------------------------------------------//
 		f.add(p1);  
		f.setTitle("Sale System");      
		f.setLayout(null);  
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setBounds(0, 0, dimension.width, dimension.height);
		f.setVisible(true);            
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
} 
     
     
     private void totalPrice() {//設定算總金額的方法
 		for(int i=0; i<rowIndex; i++) {
 			price = Integer.parseInt((String)myTable.getValueAt(i,3));//抓取[小計]字串，再轉為整數
 			total = total + price;
 			totalTxtFd.setText(" $ "+String.valueOf(total));//將(總金額)的整數值轉為字串,並顯示在totalTxtFd
 		}
 	}
 	

 	public ActionListener ProcessDigitBtn = new ActionListener() {//數字鍵
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<digitBtn.length; i++) {
				for(int j=0; j<digitBtn[0].length; j++) {
					if(e.getSource() == digitBtn[3][2] && !((String)myTable.getValueAt(rowIndex,0)).equals("")) {
						digitTxtFd.setText("0");
						myTable.setValueAt("",rowIndex,2);
						myTable.setValueAt("",rowIndex,3);
					}
					else if(e.getSource() == digitBtn[i][j] && !((String)myTable.getValueAt(rowIndex,0)).equals("")){
						if(amount<=10000) {
							amount = Integer.parseInt(digitTxtFd.getText()+digitBtn[i][j].getText());//抓取JTextField的值，再轉為整數
							price = Integer.parseInt((String)myTable.getValueAt(rowIndex,1));//抓取[單價]字串，再轉為整數
							price = price*amount;//單價*數量
							digitTxtFd.setText(String.valueOf(amount));//顯示轉為字串的單價在數字文字欄位
							myTable.setValueAt(String.valueOf(amount),rowIndex,2);//顯示轉為字串的單價在表格
				    		myTable.setValueAt(String.valueOf(price),rowIndex,3);//將(單價*數量)轉為字串後在表格顯示
				    		//myTable.setValueAt("",rowIndex,4);//如果數量重選,表格的折扣會清空
						}
					}
					else if(e.getSource() == digitBtn[3][2] && !digitTxtFd.getText().equals("0")){
						digitTxtFd.setText("輸入付款金額");
					}
					else if(e.getSource() == digitBtn[i][j] && !digitTxtFd.getText().equals("0")) {
						if(digitTxtFd.getText().equals("輸入付款金額")) {
							digitTxtFd.setText(digitBtn[i][j].getText());
						}
						else {
							if(pay<=1000000) {
								pay = Integer.parseInt(digitTxtFd.getText()+digitBtn[i][j].getText());
								digitTxtFd.setText(String.valueOf(pay));	
							}
						}
					}
				}
			}
		}
	};
  
	//------------------------------------------------//
	
	public ActionListener ProcessOperateBtn = new ActionListener() {//表格控制鍵
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == operateBtn[0] && !((String)myTable.getValueAt(0,0)).equals("")) {//清空所有
				int ask = JOptionPane.showConfirmDialog(null,"確定要清空所有商品項目?","確認清空",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if( ask == JOptionPane.YES_OPTION ) {
					for(int i=0; i<table_Data.length; i++) {
						for(int j=0; j<table_Data[0].length; j++) {
							myTable.setValueAt("",i,j);
						}
					}
					rowIndex=0;
					totalTxtFd.setText("");
					digitTxtFd.setText("0");
				}
            }
			if(e.getSource() == operateBtn[1]) {//重新選取
				 for(int i=0; i<table_Data[0].length; i++) {
                 	myTable.setValueAt("",rowIndex,i);
                 }
				 digitTxtFd.setText("0");
            }
			if( e.getSource() == operateBtn[2] && !((String)myTable.getValueAt(rowIndex,0)).equals("")) {//商品確認
				if(((String)myTable.getValueAt(rowIndex,2)).equals("0") || ((String)myTable.getValueAt(rowIndex,2)).equals("")) {
					JOptionPane.showMessageDialog(null,"商品數量不得小於1。","錯誤！",JOptionPane.ERROR_MESSAGE);
				}
				else {
					rowIndex++;
				total = 0;
				totalPrice();//呼叫算總金額的方法
				digitTxtFd.setText("0");
				}
			}
		}
	};
	
	//---------------------------------------------
	
	public ActionListener ProcessPayBtn = new ActionListener() {//付現
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == payBtn && !((String)myTable.getValueAt(rowIndex,0)).equals(""))
				JOptionPane.showMessageDialog(null,"尚未確認商品，請點按「確認商品」！","錯誤！",JOptionPane.ERROR_MESSAGE);
			else if(e.getSource() == payBtn && !((String)myTable.getValueAt(0,0)).equals(""))
				digitTxtFd.setText("輸入付款金額");
			else
				JOptionPane.showMessageDialog(null,"請點選商品！","錯誤！",JOptionPane.ERROR_MESSAGE);
		}
	};
	
	//---------------------------------------------
	
	public ActionListener ProcessTotalBtn = new ActionListener() {//結帳
		public void actionPerformed(ActionEvent e) {
			if( e.getSource() == totalBtn && !((String)myTable.getValueAt(rowIndex,0)).equals("")) {
				JOptionPane.showMessageDialog(null,"尚未確認商品，請點按「確認商品」！","錯誤！",JOptionPane.ERROR_MESSAGE);
			}
			else if(e.getSource() == totalBtn && !((String)myTable.getValueAt(0,0)).equals("")) {
				total = 0;
				totalPrice();//呼叫算總金額的方法
				if (!digitTxtFd.getText().equals("0")){
					if(pay>=total) {
						int ask = JOptionPane.showConfirmDialog(null,"總金額："+total+"元\n實收："+pay+"元\n找零："+(pay-total)+"元\n確認已收取正確金額?","結帳確認",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(ask == JOptionPane.YES_OPTION){
							for(int i=0; i<table_Data.length; i++) {
								for(int j=0; j<table_Data[0].length; j++) {
									myTable.setValueAt("",i,j);
								}
							}
							rowIndex=0;
							totalTxtFd.setText("");
							digitTxtFd.setText("0");
						}	
					}
					else {
						JOptionPane.showMessageDialog(null,"所付現金不足！","注意！",JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					int ask = JOptionPane.showConfirmDialog(null,"總金額："+total+"元","結帳確認",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(ask == JOptionPane.YES_OPTION){
						for(int i=0; i<table_Data.length; i++) {
							for(int j=0; j<table_Data[0].length; j++) {
								myTable.setValueAt("",i,j);
							}
						}
						rowIndex=0;
						totalTxtFd.setText("");
						digitTxtFd.setText("0");
					}	
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"請點選商品！","錯誤！",JOptionPane.ERROR_MESSAGE);
			}
		}
	};
	
	//--------------------------------------
	public ActionListener ProcessProductBtn = new ActionListener() {//商品
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<mealBtn.length; i++) {
				for(int j=0; j<mealBtn[0].length; j++) {
					if(e.getSource() == mealBtn[i][j] && ! mealBtnString[i][j].equals("")) {
						myTable.setValueAt( mealBtnString[i][j],rowIndex,0);
						myTable.setValueAt( mealBtnString[i][j],rowIndex,1);
						myTable.setValueAt("1",rowIndex,2);//預設數量為1
						myTable.setValueAt( mealBtnString[i][j],rowIndex,3);//預設小計為[單價]x1
						myTable.setValueAt("",rowIndex,4);//如果重新點按商品,表格的折扣會清空
						price = (Integer.parseInt( mealBtnString[i][j]));//抓取[單價]自串轉為整數price
						digitTxtFd.setText("0");
					}
				}
			}
		}
	};
	
	//------------------------------------
	
	public ActionListener ProcessProductBtn2 = new ActionListener() {//商品
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<mealBtn2.length; i++) {
				for(int j=0; j<mealBtn2[0].length; j++) {
					if(e.getSource() == mealBtn2[i][j] && ! mealBtnString2[i][j].equals("")) {
						myTable.setValueAt( mealBtnString2[i][j],rowIndex,0);
						myTable.setValueAt( mealBtnString2[i][j],rowIndex,1);
						myTable.setValueAt("1",rowIndex,2);//預設數量為1
						myTable.setValueAt( mealBtnString2[i][j],rowIndex,3);//預設小計為[單價]x1
						myTable.setValueAt("",rowIndex,4);//如果重新點按商品,表格的折扣會清空
						price = (Integer.parseInt( mealBtnString2[i][j]));//抓取[單價]自串轉為整數price
						digitTxtFd.setText("0");
					}
				}
			}
		}
	};
	
	//-----------------------------------
	
	public ActionListener ProcessProductBtn3 = new ActionListener() {//商品
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<mealBtn3.length; i++) {
				for(int j=0; j<mealBtn3[0].length; j++) {
					if(e.getSource() == mealBtn3[i][j] && ! mealBtnString3[i][j].equals("")) {
						myTable.setValueAt( mealBtnString3[i][j],rowIndex,0);
						myTable.setValueAt( mealBtnString3[i][j],rowIndex,1);
						myTable.setValueAt("1",rowIndex,2);//預設數量為1
						myTable.setValueAt( mealBtnString3[i][j],rowIndex,3);//預設小計為[單價]x1
						myTable.setValueAt("",rowIndex,4);//如果重新點按商品,表格的折扣會清空
						price = (Integer.parseInt( mealBtnString3[i][j]));//抓取[單價]自串轉為整數price
						digitTxtFd.setText("0");
					}
				}
			}
		}
	};
     
}    
     
     
     
     
     

