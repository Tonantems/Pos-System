import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;

class Singnin{
	JFrame f = new JFrame();
	JPanel p1 = new JPanel();
	JLabel act = new JLabel("�ϥΪ� :");
	JLabel pwt = new JLabel("�K�X :");
	JTextField act1 = new JTextField("");
	JPasswordField pwt1 = new JPasswordField("");
	JButton act2 = new JButton("�n�J");
	JButton clear = new JButton("����");
	
	Font font1 = new Font("�з���", Font.BOLD,40);
	Font font2 = new Font("�з���", Font.BOLD,20);
	
	String [][] UserString = {{"001","123","123"},
			                  {"002 PeterMueler","456","456"}
	
	};
	String [][] magerString = {{"002","456","456"},
			
	};
	
	int state = 0;//�n�����A�A�e�x�ϥΪ�=0, ��x�޲z��=1
	
	Singnin(){
		//p1 set
		p1.setBounds(0,0,500,340);
		p1.setLayout(null);
		f.add(p1);
		//act
		act.setBounds(70,110,105,40);
		act.setFont(font2);
		act.setLayout(null);
		p1.add(act);
		
		act1.setBounds(175,110,220,40);
		act1.setFont(font2);
		act1.setLayout(null);
		p1.add(act1);
		
		act2.setBounds(120,240,100,45);
		act2.setFont(font2);
		act2.setLayout(null);
		p1.add(act2);
		//pwt
		pwt.setBounds(70,170,105,40);
		pwt.setFont(font2);
		pwt.setLayout(null);
		p1.add(pwt);
		
		pwt1.setBounds(175,170,220,40);
		pwt1.setFont(font2);
		pwt1.setLayout(null);
		p1.add(pwt1);
		//clear
		clear.setBounds(270,240,100,45);
		clear.setFont(font2);
		clear.setLayout(null);
		clear.addActionListener(ProcessclearAction);
		p1.add(clear);
		//f.set
		f.setTitle("�i�P�s�n�J�e��");
        f.setLayout(null);
        f.setBounds(200,200,500,360);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void clearAction() {
		act1.setText("");
		pwt1.setText("");
	}
	 public ActionListener ProcessclearAction = new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	             if(e.getSource() ==  clear) {  
	            	 clearAction();//�I�s��kclearAcntPwd�h����M�űb���K�X��
	             }
	        }    
	    };
}

