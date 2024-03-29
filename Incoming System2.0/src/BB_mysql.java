import javax.swing.*;
import java.sql.*;

class BB_mysql {
	String password = "mysql";//mySQL登入密碼
	Connection connection;
    Statement statement;
    
    
    BB_mysql(){}
	
	public void DB_precedingOperation() {//資料庫前置作業
		try{
            Class.forName("com.mysql.jdbc.Driver");
		} 
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
		}
		
		try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming" + "?user=root&password=mysql");
            statement = connection.createStatement();
      } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
      }
	}
	
	
	
	public void updateRD_in_TB_productInfo(int Qty,String Item){//更新庫存資料
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;
        
        DB_precedingOperation();

        try{  
              cmdData = "UPDATE stock SET Qty= ? WHERE Item= ?";
              connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
              statement = connection.prepareStatement(cmdData);
              statement.setInt(1,Qty);
              statement.setString(2,Item);
              statement.executeUpdate();
              JOptionPane.showMessageDialog(null,"庫存更新成功!");
              statement.close();
        } 
        catch(SQLException e){
           JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        }           
	}
	
	public int get_rowSize_of_tradingRecord_by_date(String sDate,String eDate){//取得用日期查詢的交易紀錄資料筆數
		Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;
        int size=0;
        
        DB_precedingOperation();
        
        try{
               cmdData = "SELECT * FROM tradingRecord WHERE date BETWEEN ? AND ?";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,sDate);
               statement.setString(2,eDate);
               result = statement.executeQuery();
               while( result.next() ){ 
               		size = result.getRow();
               }
               statement.close();
        } 
        catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        } 
        return(size);            
	}
	
//	public int get_rowSize_of_tradingRecord_by_customerID(String customerID){//取得用顧客編號查詢的交易紀錄資料筆數
//		Connection connection;
//        PreparedStatement statement;
//        ResultSet result;
//        String cmdData;
//        int size=0;
//        
//        DB_precedingOperation();
//        
//        try{
//               cmdData = "SELECT * FROM tradingRecord WHERE customerID = ?";
//               connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
//               statement = connection.prepareStatement(cmdData);
//               statement.setString(1,customerID);
//               result = statement.executeQuery();
//               while( result.next() ){ 
//               		size = result.getRow();
//               }
//               statement.close();
//        } 
//        catch(SQLException e){
//                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
//        } 
//        return(size);            
//	}
//	
//	public int get_rowSize_of_staffInfo_by_date(String sDate,String eDate){//用日期取得員工資料筆數
//		Connection connection;
//        PreparedStatement statement;
//        ResultSet result;
//        String cmdData;
//        int size=0;
//        
//        DB_precedingOperation();
//        
//        try{
//               cmdData = "SELECT * FROM staffInfo WHERE date BETWEEN ? AND ?";
//               connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
//               statement = connection.prepareStatement(cmdData);
//               statement.setString(1,sDate);
//               statement.setString(2,eDate);
//               result = statement.executeQuery();
//               while( result.next() ){ 
//               		size = result.getRow();
//               }
//               statement.close();
//        } 
//        catch(SQLException e){
//                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
//        } 
//        return(size);            
//	}
//	
//	public int get_rowSize_of_staffInfo_by_staffID(String staffID){//用職員工號取得員工資料筆數
//		Connection connection;
//        PreparedStatement statement;
//        ResultSet result;
//        String cmdData;
//        int size=0;
//        
//        DB_precedingOperation();
//        
//        try{
//               cmdData = "SELECT * FROM staffInfo WHERE staffID = ?";
//               connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
//               statement = connection.prepareStatement(cmdData);
//               statement.setString(1,staffID);
//               result = statement.executeQuery();
//               while( result.next() ){ 
//               		size = result.getRow();
//               }
//               statement.close();
//        } 
//        catch(SQLException e){
//                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
//        } 
//        return(size);            
//	}
//	
//	public int get_rowSize_of_deliveryInfo(String sDate,String eDate){//取得宅配紀錄資料筆數
//		Connection connection;
//        PreparedStatement statement;
//        ResultSet result;
//        String cmdData;
//        int size=0;
//        
//        DB_precedingOperation();
//        
//        try{
//               cmdData = "SELECT * FROM deliveryInfo WHERE date BETWEEN ? AND ?";
//               connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
//               statement = connection.prepareStatement(cmdData);
//               statement.setString(1,sDate);
//               statement.setString(2,eDate);
//               result = statement.executeQuery();
//               while( result.next() ){ 
//               		size = result.getRow();
//               }
//               statement.close();
//        } 
//        catch(SQLException e){
//                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
//        } 
//        return(size);            
//	}
//	
//	public int get_rowSize_of_productInfo(String productType){//取得商品庫存資料筆數
//		Connection connection;
//        PreparedStatement statement;
//        ResultSet result;
//        String cmdData;
//        int size=0;
//        
//        DB_precedingOperation();
//        
//        try{
//               cmdData = "SELECT * FROM stock WHERE sid LIKE ?";
//               connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
//               statement = connection.prepareStatement(cmdData);
//               statement.setString(1,productType);
//               result = statement.executeQuery();
//               while( result.next() ){ 
//               		size = result.getRow();
//               }
//               statement.close();
//        } 
//        catch(SQLException e){
//                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
//        } 
//        return(size);            
//	}
//	
//	public String[][] findRD_in_TB_tradingRecord_by_date(String sDate,String eDate,int rowSize){//用日期搜尋交易紀錄
//         Connection connection;
//         PreparedStatement statement;
//         ResultSet result;
//         String cmdData;
//
//         String date="", time="", productID="", item="", discount="", customer="";
//         int quantity=0, subtotal=0;
//         String[][] searchResult = new String[rowSize][8];
// 
//         DB_precedingOperation();
//
//         try{
//                cmdData = "SELECT * FROM tradingRecord WHERE date BETWEEN ? AND ?";
//                connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
//                statement = connection.prepareStatement(cmdData);
//                statement.setString(1,sDate);
//                statement.setString(2,eDate);
//                result = statement.executeQuery();
//                int i=0;
//                while( result.next() ){
//                	date = result.getString("date");
//                	time = result.getString("time");
//                	productID = result.getString("productID");
//                	item = result.getString("item");
//                	quantity = result.getInt("quantity");
//                	subtotal = result.getInt("subtotal");
//                	discount = result.getString("discount");
//                	customer = result.getString("customerID");
//                	searchResult[i][0] = date;
//                    searchResult[i][1] = time;
//                    searchResult[i][2] = productID;
//                    searchResult[i][3] = item;
//                    searchResult[i][4] = String.valueOf(quantity);
//                    searchResult[i][5] = String.valueOf(subtotal);
//                    searchResult[i][6] = discount;
//                    searchResult[i][7] = customer;
//                    i++;
//                }
//                statement.close();
//         } 
//         catch(SQLException e){
//                 JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
//         } 
//         return(searchResult);            
//	}
//	
//	public String[][] findRD_in_TB_tradingRecord_by_customerID(String customerID,int rowSize){//用顧客編號搜尋交易紀錄
//        Connection connection;
//        PreparedStatement statement;
//        ResultSet result;
//        String cmdData;
//
//        String date="", time="", productID="", item="", discount="", customer="";
//        int quantity=0, subtotal=0;
//        String[][] searchResult = new String[rowSize][8];
//
//        DB_precedingOperation();
//
//        try{
//               cmdData = "SELECT * FROM tradingRecord WHERE customerID = ? ";
//               connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
//               statement = connection.prepareStatement(cmdData);
//               statement.setString(1,customerID);
//               result = statement.executeQuery();
//               int i=0;
//               while( result.next() ){
//            	   date = result.getString("date");
//               	   time = result.getString("time");
//               	   productID = result.getString("productID");
//               	   item = result.getString("item");
//               	   quantity = result.getInt("quantity");
//               	   subtotal = result.getInt("subtotal");
//               	   discount = result.getString("discount");
//               	   customer = result.getString("customerID");
//               	   searchResult[i][0] = date;
//               	   searchResult[i][1] = time;
//               	   searchResult[i][2] = productID;
//               	   searchResult[i][3] = item;
//               	   searchResult[i][4] = String.valueOf(quantity);
//               	   searchResult[i][5] = String.valueOf(subtotal);
//               	   searchResult[i][6] = discount;
//               	   searchResult[i][7] = customer;
//               	   i++;
//               }
//               statement.close();
//        } 
//        catch(SQLException e){
//                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
//        } 
//        return(searchResult);            
//	}
//	
//	public String[][] findRD_in_TB_staffInfo_by_date(String sDate,String eDate,int rowSize){//用日期搜尋員工資訊
//        Connection connection;
//        PreparedStatement statement;
//        ResultSet result;
//        String cmdData;
//
//        String date="",staffID="",name="",position="",clockON="",clockOFF="";
//        int hours=0;
//        String[][] searchResult = new String[rowSize][7];
//
//        DB_precedingOperation();
//
//        try{
//               cmdData = "SELECT * FROM staffInfo WHERE date BETWEEN ? AND ?";
//               connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
//               statement = connection.prepareStatement(cmdData);
//               statement.setString(1,sDate);
//               statement.setString(2,eDate);
//               result = statement.executeQuery();
//               int i=0;
//               while( result.next() ){
//               	   date = result.getString("date");
//               	   staffID = result.getString("staffID");
//               	   name = result.getString("staffName");
//               	   position = result.getString("position");
//               	   clockON = result.getString("clockON");
//               	   clockOFF = result.getString("clockOFF");
//               	   hours = result.getInt("hours");
//               	   searchResult[i][0] = date;
//                   searchResult[i][1] = staffID;
//                   searchResult[i][2] = name;
//                   searchResult[i][3] = position;
//                   searchResult[i][4] = clockON;
//                   searchResult[i][5] = clockOFF;
//                   searchResult[i][6] = String.valueOf(hours);
//                   i++;
//               }
//               statement.close();
//        } 
//        catch(SQLException e){
//                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
//        } 
//        return(searchResult);            
//	}
//	
//	public String[][] findRD_in_TB_staffInfo_by_staffID(String staffID,int rowSize){//用職員工號搜尋員工資訊
//        Connection connection;
//        PreparedStatement statement;
//        ResultSet result;
//        String cmdData;
//
//        String date="",staff="",name="",position="",clockON="",clockOFF="";
//        int hours=0;
//        String[][] searchResult = new String[rowSize][7];
//
//        DB_precedingOperation();
//
//        try{
//               cmdData = "SELECT * FROM staffInfo WHERE staffID = ?";
//               connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
//               statement = connection.prepareStatement(cmdData);
//               statement.setString(1,staffID);
//               result = statement.executeQuery();
//               int i=0;
//               while( result.next() ){
//               	   date = result.getString("date");
//               	   staff = result.getString("staffID");
//               	   name = result.getString("staffName");
//               	   position = result.getString("position");
//               	   clockON = result.getString("clockON");
//               	   clockOFF = result.getString("clockOFF");
//               	   hours = result.getInt("hours");
//               	   searchResult[i][0] = date;
//                   searchResult[i][1] = staff;
//                   searchResult[i][2] = name;
//                   searchResult[i][3] = position;
//                   searchResult[i][4] = clockON;
//                   searchResult[i][5] = clockOFF;
//                   searchResult[i][6] = String.valueOf(hours);
//                   i++;
//               }
//               statement.close();
//        } 
//        catch(SQLException e){
//                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
//        } 
//        return(searchResult);            
//	}
//	
//	public String[][] findRD_in_TB_deliveryInfo(String sDate,String eDate,int rowSize){//搜尋宅配資訊
//        Connection connection;
//        PreparedStatement statement;
//        ResultSet result;
//        String cmdData;
//
//        String date="",customerID="",customerName="",contact="",address="";
//        String[][] searchResult = new String[rowSize][5];
//
//        DB_precedingOperation();
//
//        try{
//               cmdData = "SELECT * FROM deliveryInfo WHERE date BETWEEN ? AND ?";
//               connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
//               statement = connection.prepareStatement(cmdData);
//               statement.setString(1,sDate);
//               statement.setString(2,eDate);
//               result = statement.executeQuery();
//               int i=0;
//               while( result.next() ){
//               	   date = result.getString("date");
//               	   customerID = result.getString("customerID");
//               	   customerName = result.getString("customerName");
//               	   contact = result.getString("contact");
//               	   address = result.getString("address");
//               	   searchResult[i][0] = date;
//                   searchResult[i][1] = customerID;
//                   searchResult[i][2] = customerName;
//                   searchResult[i][3] = contact;
//                   searchResult[i][4] = address;
//                   i++;
//               }
//               statement.close();
//        } 
//        catch(SQLException e){
//                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
//        } 
//        return(searchResult);            
//	}
//	
	public String[][] findRD_in_TB_productInfo(String productType, int rowSize){//搜尋產品庫存
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;

        String sid="",item="";
        int productCount = 0;
        String[][] searchResult = new String[rowSize][3];

        DB_precedingOperation();
        try{
               cmdData = "SELECT * FROM stock WHERE sid LIKE ?";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,productType);
               result = statement.executeQuery();
               int i=0;
               while( result.next() ){
            	   sid = result.getString("sid");
            	   item = result.getString("item");
            	   productCount = result.getInt("Qty");
               	   searchResult[i][0] = sid;
                   searchResult[i][1] = item;
                   searchResult[i][2] = String.valueOf(productCount);
                   i++;
               }
               statement.close();
        } 
        catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        } 
        return(searchResult);            
	}
	
    public void insertRD_into_TB_tradingRecord(String[] trading){//傳入交易紀錄資料
    	Connection connection;
        PreparedStatement statement;
        String cmdData;

        DB_precedingOperation();

        try{//新增一筆交易紀錄資料到資料表  
        	cmdData = "INSERT INTO trade(cid,product,Qity,money,date)VALUES(?,?,?,?,?)";
        	connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
            statement = connection.prepareStatement(cmdData);
            statement.setString(1,trading[0]);
            statement.setString(2,trading[1]);
            statement.setString(3,trading[2]);
            statement.setString(4,trading[3]);
            statement.setInt(5,Integer.parseInt(trading[4]));
            statement.executeUpdate();
            statement.close();
        } 
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"寫入交易紀錄發生錯誤!");
        }
    } 
    
    public void insertRD_into_TB_staffInfo(String[] staff){//傳入員工資料
    	Connection connection;
        PreparedStatement statement;
        String cmdData;

        DB_precedingOperation();

        try{//新增一筆交易紀錄資料到資料表  
        	cmdData = "INSERT INTO employee(eid,staff_name,status,office_hour,date)VALUES(?,?,?,?,?)";
        	connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
            statement = connection.prepareStatement(cmdData);
            statement.setString(1,staff[0]);
            statement.setString(2,staff[1]);
            statement.setString(3,staff[2]);
            statement.setString(4,staff[3]);
            statement.setString(5,staff[4]);
            statement.executeUpdate();
            statement.close();
        } 
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"寫入打卡資料發生錯誤!");
        }
    }
    
//    public void insertRD_into_TB_deliveryInfo(String date,String customer,String[] delivery){//傳入宅配資訊
//    	Connection connection;
//        PreparedStatement statement;
//        String cmdData;
//
//        DB_precedingOperation();
//
//        try{//新增一筆宅配資訊到資料表  
//        	cmdData = "INSERT INTO deliveryInfo(date,customerID,customerName,contact,address)VALUES(?,?,?,?,?)";
//        	connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
//            statement = connection.prepareStatement(cmdData);
//            statement.setString(1,date);
//            statement.setString(2,customer);
//            statement.setString(3,delivery[0]);
//            statement.setString(4,delivery[1]);
//            statement.setString(5,delivery[2]);
//            statement.executeUpdate();
//            statement.close();
//        } 
//        catch(SQLException e){
//            JOptionPane.showMessageDialog(null,"寫入宅配資訊發生錯誤!");
//        }
//    }
//	
    public void insertRD_into_TB_productInfo(String productID, String productName){//傳入商品資訊
    	Connection connection;
        PreparedStatement statement;
        String cmdData;

        DB_precedingOperation();

        try{//新增商品資料表  
        	cmdData = "INSERT INTO productInfo(productID,item,productCount)VALUES(?,?,?)";
        	connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
            statement = connection.prepareStatement(cmdData);
            statement.setString(1,productID);
            statement.setString(2,productName);
            statement.setInt(3,0);
            statement.executeUpdate();
            //JOptionPane.showMessageDialog(null,"成功寫入商品資訊!");
            statement.close();
        } 
        catch(SQLException e){
            //JOptionPane.showMessageDialog(null,"寫入商品資訊發生錯誤!");
        }
        
    }
    
    public void createTB_tradingRecord(){//建立交易紀錄資料表
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
            statement = connection.createStatement();
            String createTB = "CREATE TABLE tradingRecord("+
            				  "cid              INT(20),"+                //cid
            				  "product          VARCHAR(20),"+            
                              "Qity             INT(20),"+			      //
							  "money           	INT(20),"+                //品項
                              "date             VARCHAR(20),";            //數量
            statement.executeUpdate(createTB);
            JOptionPane.showMessageDialog(null,"交易紀錄資料表建立成功!");
            statement.close();
        } 
		catch(SQLException e){
//            if(statement != null) 
//                JOptionPane.showMessageDialog(null,"交易紀錄資料表已存在,請繼續操作!"); 
//            else
//                JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
        } 
		catch(Exception e){
            JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        }
    }
    
    public void createTB_staffInfo(){//建立員工資料資料表
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
            statement = connection.createStatement();
            String createTB = "CREATE TABLE staffInfo("+
            				  "eid              INT(20),"+            //日期
            				  "staff_name       VARCHAR(20),"+            //工號
            				  "status           VARCHAR(20),"+            //姓名
            				  "office_hour      INT(20),"+            //職位
                              "date             VARCHAR(20),";             //時數
            statement.executeUpdate(createTB);
            JOptionPane.showMessageDialog(null,"員工資訊資料表建立成功!");
            statement.close();
        } 
		catch(SQLException e){
//            if(statement != null) 
//                  JOptionPane.showMessageDialog(null,"員工資訊資料表已存在,請繼續操作!"); 
//            else
//                JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
        } 
		catch(Exception e){
            JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        }
    }
    
//    public void createTB_deliveryInfo(){//建立宅配資訊資料表
//        try{
//            connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
//            statement = connection.createStatement();
//            String createTB = "CREATE TABLE deliveryInfo("+
//            				  "date             VARCHAR(15),"+		       //交易日期
//            				  "customerID       VARCHAR(15) PRIMARY KEY,"+ //顧客編號
//            				  "customerName     VARCHAR(15),"+             //顧客姓名
//            				  "contact          VARCHAR(15),"+             //連絡電話
//            				  "address          VARCHAR(40))";             //地址
//            statement.executeUpdate(createTB);
//            JOptionPane.showMessageDialog(null,"宅配資訊資料表建立成功!");
//            statement.close();
//        } 
//		catch(SQLException e){
////            if(statement != null) 
////                  JOptionPane.showMessageDialog(null,"員工資訊資料表已存在,請繼續操作!"); 
////            else
////                JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
//        } 
//		catch(Exception e){
//            JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
//        }
//    }

    public void createTB_productInfo(){//建立庫存資料表
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming?user=root&password="+password);
            statement = connection.createStatement();
            String createTB = "CREATE TABLE productInfo("+
            				  "productID        VARCHAR(20) PRIMARY KEY,"+//貨號
            				  "item             VARCHAR(20),"+            //商品
            				  "productCount     VARCHAR(20))";			  //商品庫存
            statement.executeUpdate(createTB);
            JOptionPane.showMessageDialog(null,"庫存資料表建立成功!");
            statement.close();
        } 
		catch(SQLException e){
//            if(statement != null) 
//                  JOptionPane.showMessageDialog(null,"庫存資料表已存在,請繼續操作!"); 
//            else
//                JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
        } 
		catch(Exception e){
            JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        }
    }
    
    public void createDB(){//建立資料庫incoming
    	DB_precedingOperation();

        try{//建立 posdb資料庫
            connection = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password="+password);
            statement = connection.createStatement();
            String createDB = "CREATE DATABASE incoming";
            
            statement.executeUpdate(createDB);
            JOptionPane.showMessageDialog(null,"歡迎使用進銷存資料庫！\n系統資料庫建立成功!");
            statement.close();   
        } 
        catch(SQLException e){
//            if(statement != null) 
//                JOptionPane.showMessageDialog(null,"歡迎使用飛速買科技myPos2.0！\nPOS系統資料庫已存在,請繼續操作!");
//            else
//                JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
        } 
        catch(Exception e){
             JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        }
    } //end for: public void createDB()
}