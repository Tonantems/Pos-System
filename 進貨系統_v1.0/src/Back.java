import java.awt.*;
import javax.swing.*;
class Back {
	JFrame f = new JFrame();                
    JPanel p1 = new JPanel(); 
    
    JScrollPane  mySPane;//�ŧimySPane1���ưʮe��
    JScrollPane  mySPane2;
    
    JTable myTable;//�ŧimyTable���C��
    String table_title[] = {"No","Item","Qty",}; 
    String[][] table_Data = new String[100][3];
    JTable myTable2;
    String table_title2[] = {"�m�W","�^��","�ɼ�",};
    String[][] table_Data2 = new String[30][3];
    
//    JButton UsrBtn = new JButton("�e�x"); //---�e�x
    JButton LogoutBtn = new JButton("��^���");   //---�n�X
    JButton mybtn = new JButton("�s�W");
    JButton mybtn2 = new JButton("�h�f");
    JButton mybtn3 = new JButton("�s��");
    JButton mybtn4 = new JButton("����");
    JButton mybtn5 = new JButton("�v�L");

    JTabbedPane mytabpane = new JTabbedPane();
    String tabTxt1 = "����O��";
    String tabTxt2 = "�w�s�d��";
    String tabTxt3 = "���u��T";
    
    JLabel mylabel = new JLabel("����έp�\���");
    
    Back(){
    	mytabpane.setBounds(0,40,1000,700);//���Үe��
        
        mylabel.setBounds(10,20,700,500);
        
//        UsrBtn.setBounds(750,0,100,25);  //---�e�x
        LogoutBtn.setBounds(850,0,100,25);    //---�n�X
        mybtn.setBounds(700,100,150,30);
        mybtn2.setBounds(700,150,150,30);
        mybtn3.setBounds(800,100,150,30);
        mybtn4.setBounds(800,150,150,30);
        mybtn5.setBounds(600,500,150,30);
     
//        f.add(UsrBtn);                   //---�e�x
        f.add(LogoutBtn);                     //---�n�X
        
        p1.setBounds(0,0,1000,740);      
        p1.setBackground(new Color(255,222,173));     
        p1.setLayout(null);               
        f.add(p1);
        
        //-----�]�w�e��panel���\�񪺪���
      
        JPanel mypanel = new JPanel();
        mytabpane.add(tabTxt1,mypanel);//���Үe�����Ĥ@�ӭ��Ҫ����ޤΤ��e
        mypanel.setBackground(Color.green);     
        mypanel.setLayout(null);
        mypanel.add(mylabel);
        mypanel.add(mybtn5);
        
        //-----�]�w�e��panel2���\�񪺪���
        
        JPanel mypanel2 = new JPanel();
        mytabpane.add(tabTxt2,mypanel2);//���Үe�����ĤG�ӭ��Ҫ����ޤΤ��e 
        mypanel2.setBackground(Color.lightGray);     
        mypanel2.setLayout(null);
       
        myTable = new JTable(table_Data, table_title);
        myTable.setEnabled(false);
        myTable.setRowHeight(30);
        myTable.setFont(new Font("�s�ө���", Font.PLAIN, 16));
        mySPane = new JScrollPane(myTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        mySPane.setBounds(5,5,500,500);
        mySPane.setVisible(true);
        mypanel2.add(mySPane,myTable);
        mypanel2.add(mybtn);
        mypanel2.add(mybtn2);
          
      //-----�]�w�e��panel3���\�񪺪���
        
        JPanel mypanel3 = new JPanel();
        mytabpane.add(tabTxt3,mypanel3);
        mypanel3.setBackground(new Color(65,105,225));     
        mypanel3.setLayout(null);
        
        myTable2 = new JTable(table_Data2, table_title2);
        myTable2.setEnabled(true);
        myTable2.setRowHeight(30);
        myTable2.setFont(new Font("�s�ө���", Font.PLAIN, 16));
        mySPane2 = new JScrollPane(myTable2,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        mySPane2.setBounds(5,5,700,500);
        mySPane2.setVisible(true);
        mypanel3.add(mySPane2,myTable2);
        mypanel3.add(mybtn3);
        mypanel3.add(mybtn4);
       
        p1.add(mytabpane);   

        //-----�̩��h������f�A���ݩʳ]�w���\�b�{�����̥��q�A���M�{���������ܷ|���p���D
        f.setTitle("��x�޲z�t��");
        f.setBounds(10,10,1000,740);
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
}
