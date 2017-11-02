import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class CreateUser extends JFrame implements ActionListener
{
	private JLabel lblusrnm,lblpasswd,lblconfirmpasswd,header,img;
	private JTextArea footer;
	private TextField usrnm,txtpasswd,txtconfirmpasswd;
	private JButton create,cancel,del;
	private JRadioButton rb1,rb2;
	private ButtonGroup gp;
	private int c,x;
	private Connection conn;
	private Statement stat;
	private ResultSet rs;
	private String str1,str2,str3,tp;
	private Container cn;
	public String us;
	public CreateUser(String usr)
	{
		setTitle("Computerized Databank System of Bihar");
		cn=getContentPane();
		cn.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cn.setBackground(new Color(250, 216, 217));
		us=usr;
			
			img=new JLabel(new ImageIcon("Copy of 1658221146.jpg"));
			img.setBounds(0,0,400,410);
			JPanel pn=new JPanel();
			pn.setBounds(100,10,200,45);
			pn.setBackground(new Color(255,240,255));
			
			header=new JLabel(" New User Form ");
			header.setForeground(Color.BLUE);
			header.setFont(new Font("luxury",Font.BOLD,20));
			
			lblusrnm=new JLabel("USER NAME :");
			lblusrnm.setBounds(50,70,100,25);
			lblusrnm.setForeground(Color.blue);
			
			lblpasswd=new JLabel("PASSWORD :");
			lblpasswd.setBounds(50,110,100,25);
			lblpasswd.setForeground(Color.blue);
			
			lblconfirmpasswd=new JLabel("Confirm PASSWORD :");
			lblconfirmpasswd.setBounds(50,145,150,25);
			lblconfirmpasswd.setForeground(Color.blue);
			
			gp=new ButtonGroup();
			rb1=new JRadioButton("ADMINISTRATOR",true);
			rb2=new JRadioButton("LOCAL");
			rb1.setBounds(50,180,150,25);
			rb2.setBounds(230,180,150,25);
			rb1.addActionListener(new rbListener());
			rb2.addActionListener(new rbListener());
			gp.add(rb1);
			gp.add(rb2);
			tp="ADMINISTATOR";
			
			txtpasswd=new TextField(10);
			txtpasswd.setBounds(200,110,150,25);
			txtpasswd.setEchoChar('*');
			
			txtconfirmpasswd=new TextField(10);
			txtconfirmpasswd.setBounds(200,145,150,25);
			txtconfirmpasswd.setEchoChar('*');
			
			create=new JButton("  Create User   ");
			create.setBounds(50,290,150,25);
			create.addActionListener(this);
			create.setToolTipText("press to Create User");
			create.setMnemonic('U');
			
			cancel=new JButton("  Cancel   ");
			cancel.setBounds(220,290,150,25);
			cancel.addActionListener(this);
			cancel.setToolTipText("press to exit");
			cancel.setMnemonic('c');
			
			del=new JButton(" Delete User Account  ");
			del.setBounds(70,330,250,25);
			del.setForeground(Color.blue);
			del.addActionListener(this);
			del.setToolTipText("press to Delete User Account");
			del.setMnemonic('D');
			
			usrnm=new TextField();
			usrnm.setBounds(200,70,150,25);
			
			footer=new JTextArea(3,1);
			footer.setText("IF YOU WILL CREATE ADMINSTATOR USER \nTHEN YOU WILL SET ALL THE PROPERTY OF ENTRY FORM  \nBE CAREFULL IT WILL HARMS THE SOFTWARE IN WRONG EMPLOYEE");
				footer.setBounds(0,220,400,50);
				footer.setEditable(false);
				cn.add(footer);
			
			pn.add(header);
			cn.add(lblusrnm);
			cn.add(lblpasswd);
			cn.add(txtpasswd);
			cn.add(usrnm);
			cn.add(lblconfirmpasswd);
			cn.add(txtconfirmpasswd);
			cn.add(create);
			cn.add(cancel);
			cn.add(del);
			cn.add(rb1);
			cn.add(rb2);
			cn.add(pn);
			cn.add(img);
			
			Dimension wind=Toolkit.getDefaultToolkit().getScreenSize();
			
			pack();
			setBounds((wind.width-400)/2,(wind.height-410)/2,400,410);
			setVisible(true);
			connect();
			
			try
			{
				rs=stat.executeQuery("select type from login where name='"+usr.trim()+"'");
				rs.next();
				str1=rs.getString(1);
			}
				catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"could not update User"+sqle,"USER ACCOUNT",JOptionPane.ERROR_MESSAGE);
			}
			if(str1.equalsIgnoreCase("ADMINISTRATOR"))
			{del.setEnabled(true);
			rb1.setEnabled(true);}
			else
			{del.setEnabled(false);
			rb1.setEnabled(false);
			rb2.setSelected(true);
			tp="LOCAL";
			footer.setText("IF YOU WILL CREATE Local USER \n  THEN YOU WILL SET MOST OF THE PROPERTY OF ENTRY FORM  \n RECOMMENDED FOR MOST EMPLOYEE");
				footer.setBounds(0,220,400,50);
				cn.add(footer);
			}
	}
	
	private void createuserid()
	{
		str1=usrnm.getText();
		str2=txtpasswd.getText();
		str3=txtconfirmpasswd.getText();
		if(str1.compareTo("")!=0|| str2.compareTo("")!=0|| str3.compareTo("")!=0)
		if(str2.compareTo(str3.trim())==0)
		{
			try
			{
				stat.executeUpdate("insert into login values('"+str1.trim()+"','"+str2.trim()+"','"+tp.trim()+"')");
				stat.executeUpdate("commit");
				JOptionPane.showMessageDialog(null,"User Create Succesfully","USER ACCOUNT",JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
				catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"could not Create User"+sqle,"USER ACCOUNT",JOptionPane.ERROR_MESSAGE);
			}
		}
			else
			{
				JOptionPane.showMessageDialog(null,"Password doesn't match","USER ACCOUNT",JOptionPane.WARNING_MESSAGE);
				
			}
			else
			JOptionPane.showMessageDialog(null,"Fill All The Field in New User Form","USER ACCOUNT",JOptionPane.WARNING_MESSAGE);	
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		String tmp=e.getActionCommand();
		tmp=tmp.trim();
		if(e.getSource()==create)
		{
			createuserid();	
		}
		else if(e.getSource()==cancel)
		{
			dispose();
		}
		else if(e.getSource()==del)
		new delDialog(this,"Computerized Databank System of Bihar");
		
	}
	
	
	private class rbListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			tp=e.getActionCommand();
			if(tp.compareTo("ADMINISTRATOR")==0)
			{
				footer.setText("IF YOU WILL CREATE ADMINSTATOR USER \n  THEN YOU WILL SET ALL THE PROPERTY OF ENTRY FORM  \n BE CAREFULL IT WILL HARMS THE SOFTWARE IN WRONG EMPLOYEE");
				footer.setBounds(0,220,400,50);
				cn.add(footer);
			}
			else if(tp.compareTo("LOCAL")==0)
			{
				footer.setText("IF YOU WILL CREATE Local USER \n  THEN YOU WILL SET MOST OF THE PROPERTY OF ENTRY FORM  \n RECOMMENDED FOR MOST EMPLOYEE");
				footer.setBounds(0,220,400,50);
				cn.add(footer);
			}
					
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
	
	private class delDialog extends JDialog implements ActionListener
{
	private JLabel lblusrnm,lblpasswd,header;
	private TextField txtpasswd;
	private JButton del,cancel;
	private Choice usrnm;
	private String str1,str2;
	private Container cn;
	
	public delDialog(JFrame parent,String title)
	{
		super(parent,title,false);
		cn=getContentPane();
		cn.setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		cn.setBackground(new Color(250, 216, 217));
			
			JPanel pn=new JPanel();
			pn.setBounds(100,10,200,45);
			pn.setBackground(new Color(255,240,255));
			
			JLabel	img=new JLabel(new ImageIcon("Copy of 1658221146.jpg"));
			img.setBounds(0,0,400,200);
			
			header=new JLabel("Delete User Account");
			header.setForeground(Color.BLUE);
			header.setFont(new Font("luxury",Font.BOLD,20));
			
			lblusrnm=new JLabel("USER NAME :");
			lblusrnm.setBounds(50,70,100,25);
			lblusrnm.setForeground(Color.blue);
			
			lblpasswd=new JLabel("PASSWORD :");
			lblpasswd.setBounds(50,100,100,25);
			lblpasswd.setForeground(Color.blue);
			
			txtpasswd=new TextField(10);
			txtpasswd.setBounds(200,100,150,25);
			txtpasswd.setBackground(Color.green);
			txtpasswd.setEchoChar('*');
			
			del=new JButton("  Delete User   ");
			del.setBounds(50,135,150,25);
			del.addActionListener(this);
			del.setToolTipText("press to Delete User");
			del.setMnemonic('D');
			
			cancel=new JButton("  Cancel   ");
			cancel.setBounds(230,135,150,25);
			cancel.addActionListener(this);
			cancel.setToolTipText("press to exit");
			cancel.setMnemonic('c');
			
			usrnm=new Choice();
			usrnm.setBounds(200,70,150,25);
			
			pn.add(header);
			cn.add(lblusrnm);
			cn.add(lblpasswd);
			cn.add(txtpasswd);
			cn.add(usrnm);
			cn.add(del);
			cn.add(cancel);
			cn.add(pn);
			cn.add(img);
			
			Dimension wind=Toolkit.getDefaultToolkit().getScreenSize();
			
			pack();
			setBounds((wind.width-400)/2,(wind.height-200)/2,400,200);
			setVisible(true);
			connect();
			try
			{
				String tmp;
				rs=stat.executeQuery("select name from login order by name");
				while(rs.next())
				{
					tmp=rs.getString(1);
					if(us.compareTo(tmp.trim())==0);
					else
				usrnm.addItem(tmp);
				}
				
			}
				catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"error to load Form"+sqle,"Form loadin Error",JOptionPane.ERROR_MESSAGE);
			}	
	}
	
	private void Delete()
	{
		str1=usrnm.getSelectedItem().toString();
		str2=txtpasswd.getText();
		if(str2.compareTo("")!=0)
			try
			{
				rs=stat.executeQuery("select passwd from login where name='"+str1+"'");
				rs.next();
				String tmp=rs.getString(1);
				if(str2.compareTo(tmp.trim())==0)
				{
						stat.executeUpdate("delete  from login where name='"+str1+"'");
						stat.executeUpdate("commit");
						JOptionPane.showMessageDialog(null,"User Account Deleted Successfully","USER ACCOUNT",JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				else
				JOptionPane.showMessageDialog(null,"Incorrect Password","USER ACCOUNT",JOptionPane.WARNING_MESSAGE);
				
			}
				catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"error to load Form"+sqle,"User Account",JOptionPane.ERROR_MESSAGE);
			}
			else
			JOptionPane.showMessageDialog(null,"Please Fill The Password","USER ACCOUNT",JOptionPane.WARNING_MESSAGE);	
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		String tmp=e.getActionCommand();
		tmp=tmp.trim();
		if(tmp.equalsIgnoreCase("Delete User"))
		{
			Delete();	
		}
		else if(tmp.equalsIgnoreCase("cancel"))
		{
			dispose();
		}
	}

}
	
	public static void main(String args[])
	{
		new CreateUser("Ravi kumar");
	}
}

