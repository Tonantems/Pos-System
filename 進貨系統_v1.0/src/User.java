import java.awt.Color;
import java.awt.Font;
import javax.swing.border.*;
import javax.swing.event.ListSelectionListener;

import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.Statement;

import java.awt.Dimension;
import java.awt.Toolkit;

class User {
	// 聲明組件 JTable_model
		// private DefaultTableModel model;
		DefaultTableModel model;

		JFrame f = new JFrame();
		JPanel p1 = new JPanel();

		JLabel number = new JLabel("進貨單號");
		JLabel conpanycode = new JLabel("廠商代號");
		JLabel conpany = new JLabel("廠商名稱");
		JLabel phonecode = new JLabel("電    話");
		JLabel phonecode2 = new JLabel("/");
		JLabel address = new JLabel("交貨地址");
		JLabel remarks = new JLabel("備    註");
		JLabel goods = new JLabel("品  項");
		JLabel Date1 = new JLabel("進貨日期");
		JLabel total = new JLabel("進貨小計");
		JLabel tax = new JLabel("加值稅");
		JLabel all = new JLabel("總金額");
		JLabel number1 = new JLabel("數  量");
		JLabel price1 = new JLabel("單  價");
		JTextField numbertxt = new JTextField("");
		JComboBox numberbox = new JComboBox();
		JTextField conpanycodetxt = new JTextField("");
		JTextField conpanytxt = new JTextField("");
		JTextField phonecodetxt = new JTextField("");
		JTextField phonecodetxt2 = new JTextField("");
		JTextField addresstxt = new JTextField("");
		JTextField remarkstxt = new JTextField("");
		static JTextField goodstxt = new JTextField("");
		JTextField Datetxt = new JTextField("");
		JTextField totaltxt = new JTextField("");
		JTextField alltxt = new JTextField("");
		JTextField taxtxt = new JTextField("");
		static JTextField numtxt = new JTextField("");
		static JTextField priceone = new JTextField("");
		JTextField shiftTxtFd = new JTextField("");// 班別
		JTextField userTxtFd = new JTextField();// 使用者
		JButton add = new JButton("新增");
		JButton cler = new JButton("清空");
		JButton del = new JButton("重選");
		JButton back = new JButton("後台");
		JButton goodsfast = new JButton("..");
		JButton save = new JButton("存入庫存");
		JButton loginout = new JButton("返回");
		JRadioButton[] rBtn = new JRadioButton[3];
		ButtonGroup group = new ButtonGroup();
		String[] rBtnString = { "內含", "外加", "免稅" };

		String table_title[] = { "進貨單號", "廠商代號", "品項", "單價", "數量(箱)", "進貨日期", "小計(元)", "備註" };
		String[][] table_Data = new String[100][8];
		String[] input = new String[8];

		JTable myTable;
		JScrollPane mySPane;
		Font font1 = new Font("標楷體", Font.BOLD, 25);
		Font font2 = new Font("標楷體", Font.BOLD, 15);

		Date date = new Date();// 取得日期
		Date now = new Date();// 取得時間
		SimpleDateFormat dateformt = new SimpleDateFormat("yyyy/ MM/ dd");
		String d = dateformt.format(date);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dimension = kit.getScreenSize();

		int rowIndex = 0;
		int mealPrice = 0;
		int totalPrice = 0;
		String t = "0";

		String supData;
		Connection sup_connection;
		Statement sup_statement;

		//fast myfast = new fast();

		User() {
			// p1設置
			p1.setBounds(0, 0, 1500, 1500);
			p1.setBackground(Color.gray);
			p1.setLayout(null);
			f.add(p1);
			// 表格設置

			// myTable = new JTable(table_Data, table_title);
			model = new DefaultTableModel(table_Data, table_title);
			myTable = new JTable(model);
			myTable.setEnabled(true);
			myTable.setRowSelectionAllowed(true); // 選取表格整行
			myTable.setColumnSelectionAllowed(false);
			myTable.setCellSelectionEnabled(true);
			myTable.setColumnSelectionAllowed(true);
			ListSelectionModel lsm = myTable.getSelectionModel();
			myTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			myTable.setRowHeight(30);
			myTable.setFont(new Font("新細明體", Font.PLAIN, 16));

			for (int i = 0; i < table_Data.length; i++)
				for (int j = 0; j < table_Data[0].length; j++)
					myTable.setValueAt("", i, j);
			mySPane = new JScrollPane(myTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			mySPane.setBounds(5, 250, dimension.width - 10, 375); // 表格位置
			mySPane.setVisible(true);
			p1.add(mySPane);
			// 單號
			number.setBounds(5, -25, 200, 100);
			number.setFont(font1);
			p1.add(number);

			numbertxt.setBounds(115, 10, 200, 30);
			numbertxt.setFont(font1);
			p1.add(numbertxt);
			// ----------------------------------------------------------------// <-廠商代號下拉選單
			String numberboxStr[] = { "請選擇", "000001", "000002", "000003", "000004", "000005", "000006", "000007", "000008",
					"000009" };

			for (int i = 0; i < numberboxStr.length; i++) {
				numberbox.addItem(numberboxStr[i]);
			}

			// numberbox.addItemListener(this);

			numberbox.setBounds(325, 50, 190, 30); // 下拉選單代號
			numberbox.setFont(font2);
			// input[0] = String.valueOf(numbertxt.getText()); //<----------
			p1.add(numberbox);

			numberbox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					conpanycodetxt.setText(numberboxStr[numberbox.getSelectedIndex()]);
					if (e.getStateChange() == ItemEvent.SELECTED) {
						if (numberbox.getSelectedItem() == "000001") {
							numbertxt.setText("001");
							conpanytxt.setText("123公司");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("高雄市左營區民族一路333號");
							remarkstxt.setText("無");
							goodstxt.setText("芒果");
							numtxt.setText("1");
							priceone.setText("100");
						}
						if (numberbox.getSelectedItem() == "000002") {
							numbertxt.setText("002");
							conpanytxt.setText("123公司");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("台北市天母區北七路652號");
							remarkstxt.setText("無");
							goodstxt.setText("香蕉");
							numtxt.setText("1");
							priceone.setText("120");
						}
						if (numberbox.getSelectedItem() == "000003") {
							numbertxt.setText("003");
							conpanytxt.setText("123公司");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("高雄市左營區民族一路333號");
							remarkstxt.setText("無");
							goodstxt.setText("柳丁");
							numtxt.setText("1");
							priceone.setText("1100");
						}
						if (numberbox.getSelectedItem() == "000004") {
							numbertxt.setText("004");
							conpanytxt.setText("123公司");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("高雄市左營區民族一路333號");
							remarkstxt.setText("無");
							goodstxt.setText("榴槤");
							numtxt.setText("1");
							priceone.setText("2000");
						}
						if (numberbox.getSelectedItem() == "000005") {
							numbertxt.setText("005");
							conpanytxt.setText("789公司");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("高雄市左營區民族一路333號");
							remarkstxt.setText("無");
							goodstxt.setText("芭樂");
							numtxt.setText("1");
							priceone.setText("2000");
						}
						if (numberbox.getSelectedItem() == "000006") {
							numbertxt.setText("006");
							conpanytxt.setText("789公司");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("高雄市左營區民族一路333號");
							remarkstxt.setText("無");
							goodstxt.setText("蓮霧");
							numtxt.setText("1");
							priceone.setText("2100");
						}
						if (numberbox.getSelectedItem() == "000007") {
							numbertxt.setText("007");
							conpanytxt.setText("456公司");
							phonecodetxt.setText("07-12245678");
							phonecodetxt2.setText("09-121111111");
							addresstxt.setText("高雄市大社區中山路666號");
							remarkstxt.setText("無");
							goodstxt.setText("芭蕉");
							numtxt.setText("1");
							priceone.setText("1500");
						}
						if (numberbox.getSelectedItem() == "000008") {
							numbertxt.setText("008");
							conpanytxt.setText("456公司");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("高雄市楠梓區楠梓路553號");
							remarkstxt.setText("無");
							goodstxt.setText("西瓜");
							numtxt.setText("1");
							priceone.setText("2600");
						}
						if (numberbox.getSelectedItem() == "000009") {
							numbertxt.setText("009");
							conpanytxt.setText("456公司");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("高雄市三民區民族四路447號");
							remarkstxt.setText("無");
							goodstxt.setText("橘子");
							numtxt.setText("1");
							priceone.setText("2500");
						}
					}
				}
			});

			// 班別
			shiftTxtFd.setBounds(900, 10, 105, 45);
			shiftTxtFd.setFont(font2);
			shiftTxtFd.setHorizontalAlignment(JTextField.CENTER);
			shiftTxtFd.setEditable(false);
			if (now.getHours() >= 8 && now.getHours() < 12)
				shiftTxtFd.setText("早班");
			else if (now.getHours() >= 12 && now.getHours() < 18)
				shiftTxtFd.setText("中班");
			else if (now.getHours() >= 18 && now.getHours() < 22)
				shiftTxtFd.setText("晚班");
			else {
				shiftTxtFd.setText("休息中");
			}
			p1.add(shiftTxtFd);

			// 使用者

			userTxtFd.setBounds(1030, 10, 255, 45);
			userTxtFd.setFont(font2);
			userTxtFd.setHorizontalAlignment(JTextField.CENTER);
			userTxtFd.setEditable(false);
			p1.add(userTxtFd);

			// 廠商代號
			conpanycode.setBounds(5, 15, 200, 100);
			conpanycode.setFont(font1);
			p1.add(conpanycode);

			conpanycodetxt.setBounds(115, 50, 200, 30);
			conpanycodetxt.setFont(font1);
			// input[1] = String.valueOf(conpanycodetxt.getText()); //<----------
			p1.add(conpanycodetxt);
			// 廠商名稱
			conpany.setBounds(5, 55, 200, 100);
			conpany.setFont(font1);
			p1.add(conpany);

			conpanytxt.setBounds(115, 90, 400, 30);
			conpanytxt.setFont(font1);
			p1.add(conpanytxt);
			// 電話
			phonecode.setBounds(5, 95, 200, 100);
			phonecode.setFont(font1);
			p1.add(phonecode);
			phonecode2.setBounds(315, 130, 30, 30);
			phonecode2.setFont(font1);
			p1.add(phonecode2);

			phonecodetxt.setBounds(115, 130, 200, 30);
			phonecodetxt.setFont(font1);
			p1.add(phonecodetxt);

			phonecodetxt2.setBounds(330, 130, 185, 30);
			phonecodetxt2.setFont(font1);
			p1.add(phonecodetxt2);
			// 交貨地址
			address.setBounds(5, 135, 200, 100);
			address.setFont(font1);
			p1.add(address);

			addresstxt.setBounds(115, 170, 400, 30);
			addresstxt.setFont(font1);
			p1.add(addresstxt);
			// 備註
			remarks.setBounds(5, 175, 200, 100);
			remarks.setFont(font1);
			p1.add(remarks);

			remarkstxt.setBounds(115, 210, 400, 30);
			remarkstxt.setFont(font1);
			// input[6] = String.valueOf(remarkstxt.getText()); //<-----
			p1.add(remarkstxt);
			// 品項
			goods.setBounds(540, -25, 200, 100);
			goods.setFont(font1);
			p1.add(goods);

			goodstxt.setBounds(625, 10, 200, 30);
			goodstxt.setFont(font1);
			// input[2] = String.valueOf(goodstxt.getText()); //<---------
			p1.add(goodstxt);
			// 快捷鍵
			goodsfast.setBounds(830, 10, 30, 30);
			goodsfast.setFont(font2);
			goodsfast.addActionListener(Processgoodsfast);
			p1.add(goodsfast);
			// 數量
			number1.setBounds(540, 55, 200, 100);
			number1.setFont(font1);
			p1.add(number1);

			numtxt.setBounds(650, 90, 210, 30);
			numtxt.setFont(font1);
			// input[4] = String.valueOf(numtxt.getText()); //<-------
			p1.add(numtxt);
			// 日期
			Date1.setBounds(540, 15, 200, 100);
			Date1.setFont(font1);
			p1.add(Date1);

			Datetxt.setBounds(650, 50, 210, 30);
			Datetxt.setFont(font1);
			Datetxt.setText(d);
			input[5] = String.valueOf(Datetxt.getText()); // <--------
			p1.add(Datetxt);
			// 單價
			price1.setBounds(540, 95, 200, 100);
			price1.setFont(font1);
			p1.add(price1);

			priceone.setBounds(650, 125, 210, 30);
			priceone.setFont(font1);
			// input[3] = String.valueOf(priceone.getText()); //<--------
			p1.add(priceone);
			// 清空 重選 新增
			add.setBounds(540, 195, 100, 50);
			add.setBackground(new Color(135, 206, 235));
			add.setBorder(new BevelBorder(BevelBorder.RAISED));
			add.setFont(font1);
			add.addActionListener(addBtn);
			p1.add(add);

			cler.setBounds(760, 195, 100, 50);
			cler.setBackground(new Color(64, 224, 208));
			cler.setBorder(new BevelBorder(BevelBorder.RAISED));
			cler.setFont(font1);
			cler.addActionListener(ProcessRightControlBtn);
			p1.add(cler);

			del.setBounds(650, 195, 100, 50);
			del.setBackground(new Color(240, 230, 140));
			del.setBorder(new BevelBorder(BevelBorder.RAISED));
			del.setFont(font1);
			del.addActionListener(ProcessRightControlBtn);
			p1.add(del);
			// 進貨小計 總金額
			total.setBounds(5, 605, 200, 100);
			total.setFont(font1);
			p1.add(total);

			totaltxt.setBounds(115, 640, 200, 30);
			totaltxt.setFont(font1);
			p1.add(totaltxt);

			all.setBounds(dimension.width - 500, 605, 200, 100);
			all.setFont(font1);
			p1.add(all);

			alltxt.setBounds(dimension.width - 420, 640, 200, 30);
			alltxt.setFont(font1);
			// alltxt.addActionListener(ProcessRightControlBtn);
			p1.add(alltxt);
			// 稅
			tax.setBounds(dimension.width - 730, 605, 200, 100);
			tax.setFont(font1);
			p1.add(tax);

			taxtxt.setBounds(dimension.width - 650, 640, 150, 30);
			taxtxt.setFont(font1);
			taxtxt.setText(t);
			p1.add(taxtxt);

			// 三選一
			for (int i = 0; i < rBtn.length; i++) {
				if (i == 0)
					rBtn[i] = new JRadioButton(rBtnString[i], true);
				else
					rBtn[i] = new JRadioButton(rBtnString[i]);
				rBtn[i].setBounds(325 + i * 100, 635, 100, 40);
				rBtn[i].setBackground(Color.gray);
				rBtn[i].setFont(font1);
				group.add(rBtn[i]);
				p1.add(rBtn[i]);
			}

			// 登出
			loginout.setBounds(dimension.width - 420, 195, 100, 50);
			loginout.setBackground(Color.green);
			loginout.setBorder(new BevelBorder(BevelBorder.RAISED));
			loginout.setFont(font1);
			p1.add(loginout);

			// 存入庫存
			save.setBounds(dimension.width - 215, 630, 200, 50);
			save.setFont(font1);
			save.setBackground(new Color(233, 150, 122));
			save.setBorder(new BevelBorder(BevelBorder.RAISED));
			 save.addActionListener(Btn);
			p1.add(save);
			// 後台
			// back.setBounds(1080,5,100,50);
			// back.setBackground(Color.red);
			// back.setBorder(new BevelBorder(BevelBorder.RAISED));
			// back.setFont(font1);
			// p1.add(back);

			// ----------- ---------- ----------
			f.add(p1);
			f.setTitle("POS System");
			f.setLayout(null);
			f.setExtendedState(JFrame.MAXIMIZED_BOTH);
			f.setBounds(0, 0, dimension.width, dimension.height);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		// 品項快捷鍵
		public ActionListener Processgoodsfast = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == goodsfast) {
					//myfast.f.setVisible(true);
				}
			}
		};
		// 新增建
		public ActionListener addBtn = new ActionListener() {
			public void actionPerformed(ActionEvent f) {

				if (f.getSource() == add) {
					// 進貨單號
					input[0] = String.valueOf(numbertxt.getText());
					myTable.setValueAt(input[0], rowIndex, 0);
					numbertxt.setText("");

					// 廠商代號
					input[1] = String.valueOf(conpanycodetxt.getText());
					myTable.setValueAt(input[1], rowIndex, 1);
					conpanycodetxt.setText("");

					// 品項
					input[2] = String.valueOf(goodstxt.getText());
					myTable.setValueAt(input[2], rowIndex, 2);
					goodstxt.setText("");

					// 單價
					input[3] = String.valueOf(priceone.getText());
					myTable.setValueAt(input[3], rowIndex, 3);
					priceone.setText("");
					// 數量
					input[4] = String.valueOf(numtxt.getText());
					myTable.setValueAt(input[4], rowIndex, 4);
					numtxt.setText("");

					// 進貨日期
					input[5] = String.valueOf(Datetxt.getText());
					myTable.setValueAt(input[5], rowIndex, 5);

					// 備註
					input[7] = String.valueOf(remarkstxt.getText());
					myTable.setValueAt(input[7], rowIndex, 7);
					remarkstxt.setText("");
					// 更新稅
					taxtxt.getText();
					// 其他空格初始化
					conpanytxt.setText("");
					phonecodetxt.setText("");
					phonecodetxt2.setText("");
					addresstxt.setText("");
					
				     //金額計算
			   		//myTable.setValueAt(digitBtnString[i][j],rowIndex,2);    //顯示[數量]
			        int price = Integer.parseInt(input[3]);                   //抓取[單價]字串，再轉為整數int
			        int amount = Integer.parseInt(input[4]);                  //抓取[數量]字串，再轉為整數int
			        int taxPrice = Integer.parseInt(taxtxt.getText());        //抓取稅字串，轉成int
			        int pa = price*amount;
			        myTable.setValueAt(String.valueOf(pa),rowIndex,6);        //將(單價x數量)的整數值轉為字串並顯示  小計
			        totaltxt.setText(String.valueOf(pa));                     //最下面的進貨小計
			        totalPrice = totalPrice+ taxPrice + pa;                             //總金額
			        alltxt.setText(String.valueOf(totalPrice));           
			        
					
					rowIndex++;
				}

			}
		};// 清空建+重選建 //重選建無法運作 //返回建

		public ActionListener ProcessRightControlBtn = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == del) {
					int row = myTable.getSelectedRow(); // 這句選擇要刪除的行
					if (row != -1) // 這句判斷是否有選中的行
						model.removeRow(row); // 這句刪除指定行
				}

				if (e.getSource() == cler) {
					int ans = JOptionPane.showConfirmDialog(null, "確定要全部清空表格項目?", "再確認", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (ans == JOptionPane.YES_OPTION) {
						rowIndex = 0;
						for (int i = 0; i < table_Data.length; i++)
							for (int j = 0; j < table_Data[0].length; j++)
								myTable.setValueAt("", i, j);
						totalPrice = 0;
					}
				}
			}
		};
		
		public ActionListener Btn = new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				
				if( f.getSource() == save ) {
				
				try {
					supData = "INSERT INTO supplier(order_number,sup_number,sup_name,production,number,one_price,in_date,phone_number,phone_number2,address,remark)"
							+ "VALUES('" + numbertxt.getText() + "','" + conpanycodetxt.getText() + "','"
							+ conpanytxt.getText() + "'" + ",'" + goods.getText() + "','" + numtxt.getText() + "','"
							+ priceone.getText() + "'" + ",'" + Datetxt.getText() + "','" + phonecodetxt.getText()
							+ "','" + phonecodetxt2.getText() + "'" + ",'" + addresstxt.getText() + "','"
							+ remarkstxt.getText() + "')";

					sup_connection = DriverManager.getConnection("jdbc:mysql://localhost/incoming" + "?user=root&password=mysql");
					sup_statement = sup_connection.createStatement();
					sup_statement.executeUpdate(supData);
					JOptionPane.showMessageDialog(null, "成功寫入一筆[廠商記錄]到資料表中!");

					sup_statement.close();

				} catch (SQLException e) {
					System.out.println(e.getMessage());
					JOptionPane.showMessageDialog(null, "寫入一筆[廠商記錄]到資料表中發生錯誤!");

				}
				// BB_mysql.mysql_searchsup();
				// BB_mysql.mysql_sup(CC_Home.SearchSup.supData[0][0]);
				}	// dispose();
			}			
				
			
				
			};
}
