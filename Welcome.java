import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Welcome extends JWindow implements ActionListener
{
	private JLabel title,message,pic;
	private JProgressBar pbar;
	private JTextArea area,devloper;
	Timer tm;
	int i,x,c;
	
	public Welcome()
	{
		Container cn=getContentPane();
		cn.setLayout(null);
		cn.setBackground(new Color(255,240,255));
		
		tm=new Timer(350,this);
		tm.start();
		i=0;x=0;c=0;
		JPanel pn=new JPanel();
		title=new JLabel("WELCOME TO THE COMPUTERIZED DATABANK SYSTEM OF BIHAR");
		title.setFont(new Font("monotype cursiva",Font.ITALIC+Font.BOLD,25));
		title.setBounds(20,0,900,40);
		pn.setBounds(0,5,900,40);
		pn.setLayout(null);
		pn.setBackground(new Color(140,250,140));
		pn.add(title);
		JLabel tmp=new JLabel(new ImageIcon("Copy of 1658221146.jpg"));
		tmp.setBounds(0,0,900,40);
		pn.add(tmp);
		
		
		devloper=new JTextArea(4,4);
		devloper.setText("DEVLOPED BY:-  RAVI KUMAR (BCA) \nPLEASE SEND FEEDBACK ABOUT THE PROJECT TO :  \nEMAIL :- RAVI.KUMAR567@YAHOO.COM");
		devloper.setBounds(550,210,400,100);
		devloper.setBackground(new Color(255,240,255));
		devloper.setForeground(Color.BLUE);
		
		pic=new JLabel();
		pic.setIcon(new ImageIcon("ravjpg.jpg"));
		pic.setBounds(550,60,300,150);
		
		message=new JLabel();
		message.setForeground(new Color(100,150,255));
		message.setBounds(10,230,250,25);
		
		pbar=new JProgressBar();
		pbar.setBounds(10,270,870,25);
		pbar.setBackground(Color.white);
		pbar.setForeground(new Color(140,250,240));
		pbar.setValue(i);
		
		area=new JTextArea();
		area.setText("computerized Databank System of Bihar has been created \n with the help of two languages known as java and oracle.\n computerized Databank system of Bihar is used for \n capturing storing, analyzing and managing data and associated attributes. \n It is a system based of computer system. \n It is Basically use to analyze the population, people poverty status,\n maintain various block, panchayat, village etc..  ");
		area.setBounds(10,60,520,150); 
		area.setBackground(new Color(255,240,255));
		area.setForeground(Color.RED);
		area.setFont(new Font("Times of New Roman",Font.BOLD,14));
		
		cn.add(pn);
		cn.add(area);
		cn.add(message);
		cn.add(pic);
		cn.add(pbar);
		cn.add(devloper);
		
		pack();
		setBounds(150,150,900,300);
		setVisible(true);
		
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
			x=x+20;
			if(x>=90)
			{
				i+=10;
				 pbar.setValue(i);
				 x=0;
				 c++;
			}
			switch (c)
			{
				case 0: message.setText("Please Waite While installing Component...............");break;
				case 1: message.setText("Mounting Database.....................................");break;
				case 2: message.setText("Checking Connection....................................");break;
				case 3: message.setText("Extracting Neccessory File.............................");break;
				case 4: message.setText("Checking For Space Nedded..............................");break;
				case 5: message.setText("Creating Backup of File.................................");break;
				case 6: message.setText("Installing Modules......................................");break;
				case 7: message.setText("Verifying Data...........................................");break;
				case 8: message.setText("Loading Component........................................");break;
				case 9: message.setText("Loading Module............................................");break;
				case 10: message.setText("Finishing Installation....................................");break;
			}
			if(i>=98)
			{
				tm.stop();
				dispose();
				new Login();
			}
	}
	
	public static void main(String args[])
	{
		new Welcome();
	}
}