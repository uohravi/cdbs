import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
	private JLabel lblusrnm,lblpasswd,header,title;
	private JTextArea footer;
	private TextField txtpasswd;
	private JButton login,cancel;
	private Choice usrnm;
	private int c,x;
	private Connection conn;
	private Statement stat;
	private ResultSet rs;
	private String str1,str2;
	private Container cn;
	
	public Login()
	{
		setTitle("Computerized Databank System of Bihar");
		cn=getContentPane();
		cn.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cn.setBackground(new Color(250, 216, 217));
		
			Timer tm=new Timer(1000,new tmListener());
			tm.start();
			title=new JLabel("Computerized Databank System of Bihar");
			title.setBounds(0,0,300,30);
			title.setFont(new Font("Monotype cursiva",Font.ITALIC+Font.BOLD,15));
			title.setForeground(Color.blue);
			x=0;
			
			JLabel	img=new JLabel(new ImageIcon("Copy of 1658221146.jpg"));
			img.setBounds(0,0,400,350);
			
			JPanel pn=new JPanel();
			pn.setBounds(100,40,200,45);
			pn.setBackground(new Color(255,240,255));
			
			header=new JLabel("Login Form");
			header.setForeground(Color.RED);
			header.setFont(new Font("luxury",Font.BOLD,20));
			c=1;
			
			lblusrnm=new JLabel("USER NAME :");
			lblusrnm.setBounds(50,120,100,25);
			lblusrnm.setForeground(Color.blue);
			
			lblpasswd=new JLabel("PASSWORD :");
			lblpasswd.setBounds(50,170,100,25);
			lblpasswd.setForeground(Color.blue);
			
			txtpasswd=new TextField(10);
			txtpasswd.setBounds(150,170,150,25);
			txtpasswd.setBackground(Color.green);
			txtpasswd.addActionListener(new enterListener());
			txtpasswd.setEchoChar('*');
			
			login=new JButton("  Login   ");
			login.setBounds(60,220,100,25);
			login.addActionListener(this);
			login.setToolTipText("press to login");
			login.setMnemonic('l');
			
			cancel=new JButton("  Cancel   ");
			cancel.setBounds(190,220,100,25);
			cancel.addActionListener(this);
			cancel.setToolTipText("press to exit");
			cancel.setMnemonic('c');
			
			usrnm=new Choice();
			usrnm.setBounds(150,120,150,25);
			
			footer=new JTextArea(3,1);
			footer.setText("          Please   Fill  The  Password  Correct \n       YOU Have  Maximum Three (3) Chances To Try");
			footer.setWrapStyleWord(true);
			footer.setBounds(0,270,400,50);
			footer.setForeground(Color.blue);
			footer.setBackground(new Color(255,240,255));
			footer.setEditable(false);
			footer.setFont(new Font("Times of new Roman",Font.ITALIC,12));
			
			pn.add(header);
			cn.add(title);
			cn.add(lblusrnm);
			cn.add(lblpasswd);
			cn.add(txtpasswd);
			cn.add(usrnm);
			cn.add(login);
			cn.add(cancel);
			cn.add(pn);
			cn.add(footer);
			cn.add(img);
			
			Dimension wind=Toolkit.getDefaultToolkit().getScreenSize();
			
			pack();
			setBounds((wind.width-400)/2,(wind.height-350)/2,400,350);
			setVisible(true);
			connect();
			try
			{
				rs=stat.executeQuery("select name from login");
				while(rs.next())
				usrnm.addItem(rs.getString(1));
				
			}
				catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"error to load Form"+sqle,"Form loadin Error",JOptionPane.ERROR_MESSAGE);
			}	
	}
	
	private void log()
	{
		str1=usrnm.getSelectedItem().toString();
		str2=txtpasswd.getText();
		if(c==3)
			{
				JOptionPane.showMessageDialog(null,"Sorry Youre Chances Will No Longer \n  Please Try Again Later");
				System.exit(0);
			}
			try
			{
				rs=stat.executeQuery("select passwd from login where name='"+str1+"'");
				rs.next();
				String tmp=rs.getString(1);
				if(str2.compareTo(tmp.trim())==0)
				{
					new Menu_pages(str1);
					rs.close();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null," Youre   "+c+"  Chances Will go \n   Try Again");
					txtpasswd.setText("");
					txtpasswd.requestFocus();
					c++;
				}
			}
				catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"error to load Form"+sqle,"Form loadin Error",JOptionPane.ERROR_MESSAGE);
			}	
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		String tmp=e.getActionCommand();
		tmp=tmp.trim();
		if(tmp.equalsIgnoreCase("login"))
		{
			log();	
		}
		else if(tmp.equalsIgnoreCase("cancel"))
		{
			System.exit(0);
		}
	}
	
	private class enterListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			log();	
		}
	}
	
	private class tmListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(x>=130)
			x=0;
			title.setLocation(x,0);
			x=x+20;	
		}
	}
	
	
	public void connect()
	{
		try
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn=DriverManager.getConnection("jdbc:odbc:home","system","manager");
				stat=conn.createStatement();
			}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"error in Creating Connection","Database Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Not connected to Database","DataBase Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
/*	public static void main(String args[])
	{
		new Login();
	}*/
}