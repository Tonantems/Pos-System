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
	JButton rebtn = new JButton("��^");
	
	JButton payBtn = new JButton("�I�{");
	JButton totalBtn = new JButton("�� �b");
	
	JLabel totalLab = new JLabel("Total:");
	
	JTextField shiftTxtFd = new JTextField("");//�Z�O
    JTextField userTxtFd = new JTextField();//�ϥΪ�
    JTextField digitTxtFd = new JTextField("0");
	
	JTable myTable;
	JScrollPane  mySPane;
	String table_title[] = {"�~��","���","�ƶq","�p�p(��)"};
	String[][] table_Data = new String[100][4];
	
	JButton[] operateBtn = new JButton[3];
    String[] operateBtnString = {"�M�ũҦ�","���s���","�ӫ~�T�{"};
    JTextField totalTxtFd = new JTextField("");
	
	//�p���
	JButton[][] digitBtn = new JButton[4][3];
    String[][] digitBtnString = {{"7","8","9"},{"4","5","6"},{"1","2","3"},{"0","00","C"}};
    
    
    //
    JTabbedPane mytabpane = new JTabbedPane();
    
     String tabTxt1 = "�ֱ���1";
	 String tabTxt2 = "�ֱ���2";
	 String tabTxt3 = "�ֱ���3";
	 
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
	
	
	
	Font font1 = new Font("�з���" , Font.BOLD, 25);
	Font font2 = new Font("�з���" , Font.BOLD, 17);
	
	Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension dimension = kit.getScreenSize();
    
    Date now = new Date();//���o�ɶ�
    
    int rowIndex = 0;
	int amount;
	int price;
	int total;
	int pay;
    
     sale(){
    	 
    	 
    	 
    	 //���
    	myTable = new JTable(table_Data, table_title);   
 		myTable.setEnabled(true); 
 		myTable.setRowSelectionAllowed(true);    //��������
 		myTable.setColumnSelectionAllowed(false);
 		myTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 		myTable.setRowHeight(30);                        		
 		myTable.setFont(new Font("�s�ө���", Font.PLAIN, 16));
    	 
 		for(int i=0; i<table_Data.length; i++)
            for(int j=0; j<table_Data[0].length; j++)
                    myTable.setValueAt("",i,j);
		mySPane = new JScrollPane(myTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);  
  		mySPane.setBounds(5,5,500,dimension.height-50);    //����m
  		mySPane.setVisible(true);                
  		p1.add(mySPane);
  		
  		//
		mytabpane.setBounds(850,70,500,500);//���Үe��
		
		 p1.setBounds(0,0,1000,740);      
	     p1.setBackground(new Color(255,222,173));     
	     p1.setLayout(null);               
	     f.add(p1);
	   //-----�]�w�e��panel���\�񪺪���   
	     JPanel mypanel = new JPanel();
	     mytabpane.add(tabTxt1,mypanel);//���Үe�����Ĥ@�ӭ��Ҫ����ޤΤ��e
	     mypanel.setBackground(Color.green);     
	     mypanel.setLayout(null);

	   //-----�]�w�e��panel2���\�񪺪���
	     JPanel mypanel2 = new JPanel();
	     mytabpane.add(tabTxt2,mypanel2);//���Үe�����ĤG�ӭ��Ҫ����ޤΤ��e
	     mypanel2.setBackground(Color.green);     
	     mypanel2.setLayout(null);
	     
	    //-----�]�w�e��panel3���\�񪺪���
	     JPanel mypanel3 = new JPanel();
	     mytabpane.add(tabTxt3,mypanel3);//���Үe�����ĤG�ӭ��Ҫ����ޤΤ��e
	     mypanel3.setBackground(Color.green);     
	     mypanel3.setLayout(null);
	     
	     //-------------p1
	     
	     for(int i=0; i<mealBtn.length; i++){
	       		for(int j=0; j<mealBtn[0].length; j++){
	              		mealBtn[i][j] = new JButton(mealBtnString[i][j]);
	              		mealBtn[i][j].setFont(font1);
	              		mealBtn[i][j].setBounds(0+j*160,0+i*55,150,50);                 
	              		mealBtn[i][j].setBackground(Color.orange);
	                    mealBtn[i][j].addActionListener(ProcessProductBtn);     //�N�C�@��mealBtn[][]���U���ť�{��ProcessMealBtn
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
	                    mealBtn2[i][j].addActionListener(ProcessProductBtn2);     //�N�C�@��mealBtn[][]���U���ť�{��ProcessMealBtn
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
	                    mealBtn3[i][j].addActionListener(ProcessProductBtn3);     //�N�C�@��mealBtn[][]���U���ť�{��ProcessMealBtn
	              		mypanel3.add(mealBtn3[i][j]);                              
	       		}
	  		}
	     
	     p1.add(mytabpane);
  		
  		
  		
  		
  		
  		
  		//�Z�O
  		shiftTxtFd.setBounds(900,10,105,45);
 		shiftTxtFd.setFont(font1);
 		shiftTxtFd.setHorizontalAlignment(JTextField.CENTER);
 		shiftTxtFd.setEditable(false);
 		if(now.getHours()>=8 && now.getHours()<12)
 			shiftTxtFd.setText("���Z");
 		else if(now.getHours()>=12 && now.getHours()<18)
 			shiftTxtFd.setText("���Z");
 		else if(now.getHours()>=18 && now.getHours()<22)
 			shiftTxtFd.setText("�߯Z");
 		else {
 			shiftTxtFd.setText("�𮧤�");
 		}	
 		p1.add(shiftTxtFd);
 		
 		//�ϥΪ�
		
 				userTxtFd.setBounds(1020,10,220,45);
 				userTxtFd.setFont(font1);
 				userTxtFd.setHorizontalAlignment(JTextField.CENTER);
 				userTxtFd.setEditable(false);
 				p1.add(userTxtFd);
 		//�p���
 				
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
  		 //�\����
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
 				}//�H�W��p1
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
     
     
     private void totalPrice() {//�]�w���`���B����k
 		for(int i=0; i<rowIndex; i++) {
 			price = Integer.parseInt((String)myTable.getValueAt(i,3));//���[�p�p]�r��A�A�ର���
 			total = total + price;
 			totalTxtFd.setText(" $ "+String.valueOf(total));//�N(�`���B)����ƭ��ର�r��,����ܦbtotalTxtFd
 		}
 	}
 	

 	public ActionListener ProcessDigitBtn = new ActionListener() {//�Ʀr��
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
							amount = Integer.parseInt(digitTxtFd.getText()+digitBtn[i][j].getText());//���JTextField���ȡA�A�ର���
							price = Integer.parseInt((String)myTable.getValueAt(rowIndex,1));//���[���]�r��A�A�ର���
							price = price*amount;//���*�ƶq
							digitTxtFd.setText(String.valueOf(amount));//����ର�r�ꪺ����b�Ʀr��r���
							myTable.setValueAt(String.valueOf(amount),rowIndex,2);//����ର�r�ꪺ����b���
				    		myTable.setValueAt(String.valueOf(price),rowIndex,3);//�N(���*�ƶq)�ର�r���b������
				    		//myTable.setValueAt("",rowIndex,4);//�p�G�ƶq����,��檺�馩�|�M��
						}
					}
					else if(e.getSource() == digitBtn[3][2] && !digitTxtFd.getText().equals("0")){
						digitTxtFd.setText("��J�I�ڪ��B");
					}
					else if(e.getSource() == digitBtn[i][j] && !digitTxtFd.getText().equals("0")) {
						if(digitTxtFd.getText().equals("��J�I�ڪ��B")) {
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
	
	public ActionListener ProcessOperateBtn = new ActionListener() {//��汱����
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == operateBtn[0] && !((String)myTable.getValueAt(0,0)).equals("")) {//�M�ũҦ�
				int ask = JOptionPane.showConfirmDialog(null,"�T�w�n�M�ũҦ��ӫ~����?","�T�{�M��",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
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
			if(e.getSource() == operateBtn[1]) {//���s���
				 for(int i=0; i<table_Data[0].length; i++) {
                 	myTable.setValueAt("",rowIndex,i);
                 }
				 digitTxtFd.setText("0");
            }
			if( e.getSource() == operateBtn[2] && !((String)myTable.getValueAt(rowIndex,0)).equals("")) {//�ӫ~�T�{
				if(((String)myTable.getValueAt(rowIndex,2)).equals("0") || ((String)myTable.getValueAt(rowIndex,2)).equals("")) {
					JOptionPane.showMessageDialog(null,"�ӫ~�ƶq���o�p��1�C","���~�I",JOptionPane.ERROR_MESSAGE);
				}
				else {
					rowIndex++;
				total = 0;
				totalPrice();//�I�s���`���B����k
				digitTxtFd.setText("0");
				}
			}
		}
	};
	
	//---------------------------------------------
	
	public ActionListener ProcessPayBtn = new ActionListener() {//�I�{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == payBtn && !((String)myTable.getValueAt(rowIndex,0)).equals(""))
				JOptionPane.showMessageDialog(null,"�|���T�{�ӫ~�A���I���u�T�{�ӫ~�v�I","���~�I",JOptionPane.ERROR_MESSAGE);
			else if(e.getSource() == payBtn && !((String)myTable.getValueAt(0,0)).equals(""))
				digitTxtFd.setText("��J�I�ڪ��B");
			else
				JOptionPane.showMessageDialog(null,"���I��ӫ~�I","���~�I",JOptionPane.ERROR_MESSAGE);
		}
	};
	
	//---------------------------------------------
	
	public ActionListener ProcessTotalBtn = new ActionListener() {//���b
		public void actionPerformed(ActionEvent e) {
			if( e.getSource() == totalBtn && !((String)myTable.getValueAt(rowIndex,0)).equals("")) {
				JOptionPane.showMessageDialog(null,"�|���T�{�ӫ~�A���I���u�T�{�ӫ~�v�I","���~�I",JOptionPane.ERROR_MESSAGE);
			}
			else if(e.getSource() == totalBtn && !((String)myTable.getValueAt(0,0)).equals("")) {
				total = 0;
				totalPrice();//�I�s���`���B����k
				if (!digitTxtFd.getText().equals("0")){
					if(pay>=total) {
						int ask = JOptionPane.showConfirmDialog(null,"�`���B�G"+total+"��\n�ꦬ�G"+pay+"��\n��s�G"+(pay-total)+"��\n�T�{�w�������T���B?","���b�T�{",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
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
						JOptionPane.showMessageDialog(null,"�ҥI�{�������I","�`�N�I",JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					int ask = JOptionPane.showConfirmDialog(null,"�`���B�G"+total+"��","���b�T�{",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
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
				JOptionPane.showMessageDialog(null,"���I��ӫ~�I","���~�I",JOptionPane.ERROR_MESSAGE);
			}
		}
	};
	
	//--------------------------------------
	public ActionListener ProcessProductBtn = new ActionListener() {//�ӫ~
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<mealBtn.length; i++) {
				for(int j=0; j<mealBtn[0].length; j++) {
					if(e.getSource() == mealBtn[i][j] && ! mealBtnString[i][j].equals("")) {
						myTable.setValueAt( mealBtnString[i][j],rowIndex,0);
						myTable.setValueAt( mealBtnString[i][j],rowIndex,1);
						myTable.setValueAt("1",rowIndex,2);//�w�]�ƶq��1
						myTable.setValueAt( mealBtnString[i][j],rowIndex,3);//�w�]�p�p��[���]x1
						myTable.setValueAt("",rowIndex,4);//�p�G���s�I���ӫ~,��檺�馩�|�M��
						price = (Integer.parseInt( mealBtnString[i][j]));//���[���]�ۦ��ର���price
						digitTxtFd.setText("0");
					}
				}
			}
		}
	};
	
	//------------------------------------
	
	public ActionListener ProcessProductBtn2 = new ActionListener() {//�ӫ~
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<mealBtn2.length; i++) {
				for(int j=0; j<mealBtn2[0].length; j++) {
					if(e.getSource() == mealBtn2[i][j] && ! mealBtnString2[i][j].equals("")) {
						myTable.setValueAt( mealBtnString2[i][j],rowIndex,0);
						myTable.setValueAt( mealBtnString2[i][j],rowIndex,1);
						myTable.setValueAt("1",rowIndex,2);//�w�]�ƶq��1
						myTable.setValueAt( mealBtnString2[i][j],rowIndex,3);//�w�]�p�p��[���]x1
						myTable.setValueAt("",rowIndex,4);//�p�G���s�I���ӫ~,��檺�馩�|�M��
						price = (Integer.parseInt( mealBtnString2[i][j]));//���[���]�ۦ��ର���price
						digitTxtFd.setText("0");
					}
				}
			}
		}
	};
	
	//-----------------------------------
	
	public ActionListener ProcessProductBtn3 = new ActionListener() {//�ӫ~
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<mealBtn3.length; i++) {
				for(int j=0; j<mealBtn3[0].length; j++) {
					if(e.getSource() == mealBtn3[i][j] && ! mealBtnString3[i][j].equals("")) {
						myTable.setValueAt( mealBtnString3[i][j],rowIndex,0);
						myTable.setValueAt( mealBtnString3[i][j],rowIndex,1);
						myTable.setValueAt("1",rowIndex,2);//�w�]�ƶq��1
						myTable.setValueAt( mealBtnString3[i][j],rowIndex,3);//�w�]�p�p��[���]x1
						myTable.setValueAt("",rowIndex,4);//�p�G���s�I���ӫ~,��檺�馩�|�M��
						price = (Integer.parseInt( mealBtnString3[i][j]));//���[���]�ۦ��ର���price
						digitTxtFd.setText("0");
					}
				}
			}
		}
	};
     
}    
     
     
     
     
     

