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
	// �n���ե� JTable_model
		// private DefaultTableModel model;
		DefaultTableModel model;

		JFrame f = new JFrame();
		JPanel p1 = new JPanel();

		JLabel number = new JLabel("�i�f�渹");
		JLabel conpanycode = new JLabel("�t�ӥN��");
		JLabel conpany = new JLabel("�t�ӦW��");
		JLabel phonecode = new JLabel("�q    ��");
		JLabel phonecode2 = new JLabel("/");
		JLabel address = new JLabel("��f�a�}");
		JLabel remarks = new JLabel("��    ��");
		JLabel goods = new JLabel("�~  ��");
		JLabel Date1 = new JLabel("�i�f���");
		JLabel total = new JLabel("�i�f�p�p");
		JLabel tax = new JLabel("�[�ȵ|");
		JLabel all = new JLabel("�`���B");
		JLabel number1 = new JLabel("��  �q");
		JLabel price1 = new JLabel("��  ��");
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
		JTextField shiftTxtFd = new JTextField("");// �Z�O
		JTextField userTxtFd = new JTextField();// �ϥΪ�
		JButton add = new JButton("�s�W");
		JButton cler = new JButton("�M��");
		JButton del = new JButton("����");
		JButton back = new JButton("��x");
		JButton goodsfast = new JButton("..");
		JButton save = new JButton("�s�J�w�s");
		JButton loginout = new JButton("��^");
		JRadioButton[] rBtn = new JRadioButton[3];
		ButtonGroup group = new ButtonGroup();
		String[] rBtnString = { "���t", "�~�[", "�K�|" };

		String table_title[] = { "�i�f�渹", "�t�ӥN��", "�~��", "���", "�ƶq(�c)", "�i�f���", "�p�p(��)", "�Ƶ�" };
		String[][] table_Data = new String[100][8];
		String[] input = new String[8];

		JTable myTable;
		JScrollPane mySPane;
		Font font1 = new Font("�з���", Font.BOLD, 25);
		Font font2 = new Font("�з���", Font.BOLD, 15);

		Date date = new Date();// ���o���
		Date now = new Date();// ���o�ɶ�
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
			// p1�]�m
			p1.setBounds(0, 0, 1500, 1500);
			p1.setBackground(Color.gray);
			p1.setLayout(null);
			f.add(p1);
			// ���]�m

			// myTable = new JTable(table_Data, table_title);
			model = new DefaultTableModel(table_Data, table_title);
			myTable = new JTable(model);
			myTable.setEnabled(true);
			myTable.setRowSelectionAllowed(true); // ��������
			myTable.setColumnSelectionAllowed(false);
			myTable.setCellSelectionEnabled(true);
			myTable.setColumnSelectionAllowed(true);
			ListSelectionModel lsm = myTable.getSelectionModel();
			myTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			myTable.setRowHeight(30);
			myTable.setFont(new Font("�s�ө���", Font.PLAIN, 16));

			for (int i = 0; i < table_Data.length; i++)
				for (int j = 0; j < table_Data[0].length; j++)
					myTable.setValueAt("", i, j);
			mySPane = new JScrollPane(myTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			mySPane.setBounds(5, 250, dimension.width - 10, 375); // ����m
			mySPane.setVisible(true);
			p1.add(mySPane);
			// �渹
			number.setBounds(5, -25, 200, 100);
			number.setFont(font1);
			p1.add(number);

			numbertxt.setBounds(115, 10, 200, 30);
			numbertxt.setFont(font1);
			p1.add(numbertxt);
			// ----------------------------------------------------------------// <-�t�ӥN���U�Կ��
			String numberboxStr[] = { "�п��", "000001", "000002", "000003", "000004", "000005", "000006", "000007", "000008",
					"000009" };

			for (int i = 0; i < numberboxStr.length; i++) {
				numberbox.addItem(numberboxStr[i]);
			}

			// numberbox.addItemListener(this);

			numberbox.setBounds(325, 50, 190, 30); // �U�Կ��N��
			numberbox.setFont(font2);
			// input[0] = String.valueOf(numbertxt.getText()); //<----------
			p1.add(numberbox);

			numberbox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					conpanycodetxt.setText(numberboxStr[numberbox.getSelectedIndex()]);
					if (e.getStateChange() == ItemEvent.SELECTED) {
						if (numberbox.getSelectedItem() == "000001") {
							numbertxt.setText("001");
							conpanytxt.setText("123���q");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("����������ϥ��ڤ@��333��");
							remarkstxt.setText("�L");
							goodstxt.setText("�~�G");
							numtxt.setText("1");
							priceone.setText("100");
						}
						if (numberbox.getSelectedItem() == "000002") {
							numbertxt.setText("002");
							conpanytxt.setText("123���q");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("�x�_���ѥ��ϥ_�C��652��");
							remarkstxt.setText("�L");
							goodstxt.setText("����");
							numtxt.setText("1");
							priceone.setText("120");
						}
						if (numberbox.getSelectedItem() == "000003") {
							numbertxt.setText("003");
							conpanytxt.setText("123���q");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("����������ϥ��ڤ@��333��");
							remarkstxt.setText("�L");
							goodstxt.setText("�h�B");
							numtxt.setText("1");
							priceone.setText("1100");
						}
						if (numberbox.getSelectedItem() == "000004") {
							numbertxt.setText("004");
							conpanytxt.setText("123���q");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("����������ϥ��ڤ@��333��");
							remarkstxt.setText("�L");
							goodstxt.setText("�h��");
							numtxt.setText("1");
							priceone.setText("2000");
						}
						if (numberbox.getSelectedItem() == "000005") {
							numbertxt.setText("005");
							conpanytxt.setText("789���q");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("����������ϥ��ڤ@��333��");
							remarkstxt.setText("�L");
							goodstxt.setText("�ݼ�");
							numtxt.setText("1");
							priceone.setText("2000");
						}
						if (numberbox.getSelectedItem() == "000006") {
							numbertxt.setText("006");
							conpanytxt.setText("789���q");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("����������ϥ��ڤ@��333��");
							remarkstxt.setText("�L");
							goodstxt.setText("����");
							numtxt.setText("1");
							priceone.setText("2100");
						}
						if (numberbox.getSelectedItem() == "000007") {
							numbertxt.setText("007");
							conpanytxt.setText("456���q");
							phonecodetxt.setText("07-12245678");
							phonecodetxt2.setText("09-121111111");
							addresstxt.setText("�������j���Ϥ��s��666��");
							remarkstxt.setText("�L");
							goodstxt.setText("�ݿ�");
							numtxt.setText("1");
							priceone.setText("1500");
						}
						if (numberbox.getSelectedItem() == "000008") {
							numbertxt.setText("008");
							conpanytxt.setText("456���q");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("����������Ϸ����553��");
							remarkstxt.setText("�L");
							goodstxt.setText("���");
							numtxt.setText("1");
							priceone.setText("2600");
						}
						if (numberbox.getSelectedItem() == "000009") {
							numbertxt.setText("009");
							conpanytxt.setText("456���q");
							phonecodetxt.setText("07-12345678");
							phonecodetxt2.setText("09-12345678");
							addresstxt.setText("�������T���ϥ��ڥ|��447��");
							remarkstxt.setText("�L");
							goodstxt.setText("��l");
							numtxt.setText("1");
							priceone.setText("2500");
						}
					}
				}
			});

			// �Z�O
			shiftTxtFd.setBounds(900, 10, 105, 45);
			shiftTxtFd.setFont(font2);
			shiftTxtFd.setHorizontalAlignment(JTextField.CENTER);
			shiftTxtFd.setEditable(false);
			if (now.getHours() >= 8 && now.getHours() < 12)
				shiftTxtFd.setText("���Z");
			else if (now.getHours() >= 12 && now.getHours() < 18)
				shiftTxtFd.setText("���Z");
			else if (now.getHours() >= 18 && now.getHours() < 22)
				shiftTxtFd.setText("�߯Z");
			else {
				shiftTxtFd.setText("�𮧤�");
			}
			p1.add(shiftTxtFd);

			// �ϥΪ�

			userTxtFd.setBounds(1030, 10, 255, 45);
			userTxtFd.setFont(font2);
			userTxtFd.setHorizontalAlignment(JTextField.CENTER);
			userTxtFd.setEditable(false);
			p1.add(userTxtFd);

			// �t�ӥN��
			conpanycode.setBounds(5, 15, 200, 100);
			conpanycode.setFont(font1);
			p1.add(conpanycode);

			conpanycodetxt.setBounds(115, 50, 200, 30);
			conpanycodetxt.setFont(font1);
			// input[1] = String.valueOf(conpanycodetxt.getText()); //<----------
			p1.add(conpanycodetxt);
			// �t�ӦW��
			conpany.setBounds(5, 55, 200, 100);
			conpany.setFont(font1);
			p1.add(conpany);

			conpanytxt.setBounds(115, 90, 400, 30);
			conpanytxt.setFont(font1);
			p1.add(conpanytxt);
			// �q��
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
			// ��f�a�}
			address.setBounds(5, 135, 200, 100);
			address.setFont(font1);
			p1.add(address);

			addresstxt.setBounds(115, 170, 400, 30);
			addresstxt.setFont(font1);
			p1.add(addresstxt);
			// �Ƶ�
			remarks.setBounds(5, 175, 200, 100);
			remarks.setFont(font1);
			p1.add(remarks);

			remarkstxt.setBounds(115, 210, 400, 30);
			remarkstxt.setFont(font1);
			// input[6] = String.valueOf(remarkstxt.getText()); //<-----
			p1.add(remarkstxt);
			// �~��
			goods.setBounds(540, -25, 200, 100);
			goods.setFont(font1);
			p1.add(goods);

			goodstxt.setBounds(625, 10, 200, 30);
			goodstxt.setFont(font1);
			// input[2] = String.valueOf(goodstxt.getText()); //<---------
			p1.add(goodstxt);
			// �ֱ���
			goodsfast.setBounds(830, 10, 30, 30);
			goodsfast.setFont(font2);
			goodsfast.addActionListener(Processgoodsfast);
			p1.add(goodsfast);
			// �ƶq
			number1.setBounds(540, 55, 200, 100);
			number1.setFont(font1);
			p1.add(number1);

			numtxt.setBounds(650, 90, 210, 30);
			numtxt.setFont(font1);
			// input[4] = String.valueOf(numtxt.getText()); //<-------
			p1.add(numtxt);
			// ���
			Date1.setBounds(540, 15, 200, 100);
			Date1.setFont(font1);
			p1.add(Date1);

			Datetxt.setBounds(650, 50, 210, 30);
			Datetxt.setFont(font1);
			Datetxt.setText(d);
			input[5] = String.valueOf(Datetxt.getText()); // <--------
			p1.add(Datetxt);
			// ���
			price1.setBounds(540, 95, 200, 100);
			price1.setFont(font1);
			p1.add(price1);

			priceone.setBounds(650, 125, 210, 30);
			priceone.setFont(font1);
			// input[3] = String.valueOf(priceone.getText()); //<--------
			p1.add(priceone);
			// �M�� ���� �s�W
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
			// �i�f�p�p �`���B
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
			// �|
			tax.setBounds(dimension.width - 730, 605, 200, 100);
			tax.setFont(font1);
			p1.add(tax);

			taxtxt.setBounds(dimension.width - 650, 640, 150, 30);
			taxtxt.setFont(font1);
			taxtxt.setText(t);
			p1.add(taxtxt);

			// �T��@
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

			// �n�X
			loginout.setBounds(dimension.width - 420, 195, 100, 50);
			loginout.setBackground(Color.green);
			loginout.setBorder(new BevelBorder(BevelBorder.RAISED));
			loginout.setFont(font1);
			p1.add(loginout);

			// �s�J�w�s
			save.setBounds(dimension.width - 215, 630, 200, 50);
			save.setFont(font1);
			save.setBackground(new Color(233, 150, 122));
			save.setBorder(new BevelBorder(BevelBorder.RAISED));
			 save.addActionListener(Btn);
			p1.add(save);
			// ��x
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

		// �~���ֱ���
		public ActionListener Processgoodsfast = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == goodsfast) {
					//myfast.f.setVisible(true);
				}
			}
		};
		// �s�W��
		public ActionListener addBtn = new ActionListener() {
			public void actionPerformed(ActionEvent f) {

				if (f.getSource() == add) {
					// �i�f�渹
					input[0] = String.valueOf(numbertxt.getText());
					myTable.setValueAt(input[0], rowIndex, 0);
					numbertxt.setText("");

					// �t�ӥN��
					input[1] = String.valueOf(conpanycodetxt.getText());
					myTable.setValueAt(input[1], rowIndex, 1);
					conpanycodetxt.setText("");

					// �~��
					input[2] = String.valueOf(goodstxt.getText());
					myTable.setValueAt(input[2], rowIndex, 2);
					goodstxt.setText("");

					// ���
					input[3] = String.valueOf(priceone.getText());
					myTable.setValueAt(input[3], rowIndex, 3);
					priceone.setText("");
					// �ƶq
					input[4] = String.valueOf(numtxt.getText());
					myTable.setValueAt(input[4], rowIndex, 4);
					numtxt.setText("");

					// �i�f���
					input[5] = String.valueOf(Datetxt.getText());
					myTable.setValueAt(input[5], rowIndex, 5);

					// �Ƶ�
					input[7] = String.valueOf(remarkstxt.getText());
					myTable.setValueAt(input[7], rowIndex, 7);
					remarkstxt.setText("");
					// ��s�|
					taxtxt.getText();
					// ��L�Ů��l��
					conpanytxt.setText("");
					phonecodetxt.setText("");
					phonecodetxt2.setText("");
					addresstxt.setText("");
					
				     //���B�p��
			   		//myTable.setValueAt(digitBtnString[i][j],rowIndex,2);    //���[�ƶq]
			        int price = Integer.parseInt(input[3]);                   //���[���]�r��A�A�ର���int
			        int amount = Integer.parseInt(input[4]);                  //���[�ƶq]�r��A�A�ର���int
			        int taxPrice = Integer.parseInt(taxtxt.getText());        //����|�r��A�নint
			        int pa = price*amount;
			        myTable.setValueAt(String.valueOf(pa),rowIndex,6);        //�N(���x�ƶq)����ƭ��ର�r������  �p�p
			        totaltxt.setText(String.valueOf(pa));                     //�̤U�����i�f�p�p
			        totalPrice = totalPrice+ taxPrice + pa;                             //�`���B
			        alltxt.setText(String.valueOf(totalPrice));           
			        
					
					rowIndex++;
				}

			}
		};// �M�ū�+����� //����صL�k�B�@ //��^��

		public ActionListener ProcessRightControlBtn = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == del) {
					int row = myTable.getSelectedRow(); // �o�y��ܭn�R������
					if (row != -1) // �o�y�P�_�O�_���襤����
						model.removeRow(row); // �o�y�R�����w��
				}

				if (e.getSource() == cler) {
					int ans = JOptionPane.showConfirmDialog(null, "�T�w�n�����M�Ū�涵��?", "�A�T�{", JOptionPane.YES_NO_OPTION,
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
					JOptionPane.showMessageDialog(null, "���\�g�J�@��[�t�ӰO��]���ƪ�!");

					sup_statement.close();

				} catch (SQLException e) {
					System.out.println(e.getMessage());
					JOptionPane.showMessageDialog(null, "�g�J�@��[�t�ӰO��]���ƪ��o�Ϳ��~!");

				}
				// BB_mysql.mysql_searchsup();
				// BB_mysql.mysql_sup(CC_Home.SearchSup.supData[0][0]);
				}	// dispose();
			}			
				
			
				
			};
}
