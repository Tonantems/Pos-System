import java.awt.*;
import javax.swing.*;
class Back {
	JFrame f = new JFrame();                
    JPanel p1 = new JPanel(); 
    
    JScrollPane  mySPane;//宣告mySPane1為滑動容器
    JScrollPane  mySPane2;
    
    JTable myTable;//宣告myTable為列表
    String table_title[] = {"No","Item","Qty",}; 
    String[][] table_Data = new String[100][3];
    JTable myTable2;
    String table_title2[] = {"姓名","崗位","時數",};
    String[][] table_Data2 = new String[30][3];
    
//    JButton UsrBtn = new JButton("前台"); //---前台
    JButton LogoutBtn = new JButton("返回選單");   //---登出
    JButton mybtn = new JButton("新增");
    JButton mybtn2 = new JButton("退貨");
    JButton mybtn3 = new JButton("存檔");
    JButton mybtn4 = new JButton("取消");
    JButton mybtn5 = new JButton("影印");

    JTabbedPane mytabpane = new JTabbedPane();
    String tabTxt1 = "交易記錄";
    String tabTxt2 = "庫存查詢";
    String tabTxt3 = "員工資訊";
    
    JLabel mylabel = new JLabel("交易統計功能區");
    
    Back(){
    	mytabpane.setBounds(0,40,1000,700);//頁籤容器
        
        mylabel.setBounds(10,20,700,500);
        
//        UsrBtn.setBounds(750,0,100,25);  //---前台
        LogoutBtn.setBounds(850,0,100,25);    //---登出
        mybtn.setBounds(700,100,150,30);
        mybtn2.setBounds(700,150,150,30);
        mybtn3.setBounds(800,100,150,30);
        mybtn4.setBounds(800,150,150,30);
        mybtn5.setBounds(600,500,150,30);
     
//        f.add(UsrBtn);                   //---前台
        f.add(LogoutBtn);                     //---登出
        
        p1.setBounds(0,0,1000,740);      
        p1.setBackground(new Color(255,222,173));     
        p1.setLayout(null);               
        f.add(p1);
        
        //-----設定容器panel裡擺放的物件
      
        JPanel mypanel = new JPanel();
        mytabpane.add(tabTxt1,mypanel);//頁籤容器內第一個頁籤的索引及內容
        mypanel.setBackground(Color.green);     
        mypanel.setLayout(null);
        mypanel.add(mylabel);
        mypanel.add(mybtn5);
        
        //-----設定容器panel2裡擺放的物件
        
        JPanel mypanel2 = new JPanel();
        mytabpane.add(tabTxt2,mypanel2);//頁籤容器內第二個頁籤的索引及內容 
        mypanel2.setBackground(Color.lightGray);     
        mypanel2.setLayout(null);
       
        myTable = new JTable(table_Data, table_title);
        myTable.setEnabled(false);
        myTable.setRowHeight(30);
        myTable.setFont(new Font("新細明體", Font.PLAIN, 16));
        mySPane = new JScrollPane(myTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        mySPane.setBounds(5,5,500,500);
        mySPane.setVisible(true);
        mypanel2.add(mySPane,myTable);
        mypanel2.add(mybtn);
        mypanel2.add(mybtn2);
          
      //-----設定容器panel3裡擺放的物件
        
        JPanel mypanel3 = new JPanel();
        mytabpane.add(tabTxt3,mypanel3);
        mypanel3.setBackground(new Color(65,105,225));     
        mypanel3.setLayout(null);
        
        myTable2 = new JTable(table_Data2, table_title2);
        myTable2.setEnabled(true);
        myTable2.setRowHeight(30);
        myTable2.setFont(new Font("新細明體", Font.PLAIN, 16));
        mySPane2 = new JScrollPane(myTable2,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        mySPane2.setBounds(5,5,700,500);
        mySPane2.setVisible(true);
        mypanel3.add(mySPane2,myTable2);
        mypanel3.add(mybtn3);
        mypanel3.add(mybtn4);
       
        p1.add(mytabpane);   

        //-----最底層的視窗f，其屬性設定請擺在程式的最末段，不然程式執行時顯示會有小問題
        f.setTitle("後台管理系統");
        f.setBounds(10,10,1000,740);
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
}
