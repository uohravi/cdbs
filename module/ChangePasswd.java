import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ChangePasswd extends JFrame implements ActionListener
{
	private JLabel lblusrnm,lblusrtype,lblpasswd,lblconfirmpasswd,lblcurrent,header;
	private JTextArea footer;
	private TextField txtcurrent,txtpasswd,txtconfirmpasswd;
	private JButton upd,cancel;
	private ButtonGroup gp;
	private int c,x;
	private Connection conn;
	private Statement stat;
	private ResultSet rs;
	private String str1,str2,str3,str4,tmp,tp;
	private Container cn;
	
	public ChangePasswd(String usr)
	{
		setTitle("Computerized Databank System of Bihar");
		cn=getContentPane();
		cn.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			JPanel pn=new JPanel();
			pn.setBounds(100,0,200,45);
			pn.setBackground(new Color(255,240,255));
			
			str4=usr;
			
			JLabel	img=new JLabel(new ImageIcon("Copy of 1658221146.jpg"));
			img.setBounds(0,0,400,300);
			
			header=new JLabel(" Change User Setting ");
			header.setForeground(Color.BLUE);
			header.setFont(new Font("luxury",Font.BOLD,20));
			
			lblusrnm=new JLabel("USER NAME :");
			lblusrnm.setBounds(50,60,100,25);
			lblusrnm.setForeground(Color.blue);
			
			lblusrtype=new JLabel("USER TYPE :");
			lblusrtype.setBounds(50,90,100,25);
			lblusrtype.setForeground(Color.blue);
			
			lblcurrent=new JLabel("  Current Password  ");
			lblcurrent.setBounds(30,130,150,25);
			lblcurrent.setForeground(Color.blue);
			
			lblpasswd=new JLabel("  New PASSWORD :");
			lblpasswd.setBounds(30,165,150,25);
			lblpasswd.setForeground(Color.blue);
			
			lblconfirmpasswd=new JLabel("  Confirm PASSWORD :");
			lblconfirmpasswd.setBounds(30,200,150,25);
			lblconfirmpasswd.setForeground(Color.blue);
			
			tp="ADMINISTATOR";
			
			JTextField usrnm=new JTextField();
			usrnm.setText(usr.toUpperCase());
			usrnm.setBorder(new BevelBorder(BevelBorder.RAISED));
			usrnm.setForeground(Color.blue);
			usrnm.setEditable(false);
			usrnm.setBackground(new Color(255,240,255));
			usrnm.setBounds(200,60,150,25);
			
			JTextField usrtype=new JTextField();
			usrtype.setBorder(new BevelBorder(BevelBorder.RAISED));
			usrtype.setForeground(Color.blue);
			usrtype.setEditable(false);
			usrtype.setBackground(new Color(255,240,255));
			usrtype.setBounds(200,90,150,25);
			
			txtcurrent=new TextField(10);
			txtcurrent.setBounds(200,130,150,25);
			txtcurrent.setEchoChar('*');
			
			txtpasswd=new TextField(10);
			txtpasswd.setBounds(200,165,150,25);
			txtpasswd.setEchoChar('*');
			
			txtconfirmpasswd=new TextField(10);
			txtconfirmpasswd.setBounds(200,200,150,25);
			txtconfirmpasswd.setEchoChar('*');
			
			upd=new JButton("  Update   ");
			upd.setBounds(50,235,150,25);
			upd.addActionListener(this);
			upd.setToolTipText("press to Change The Password");
			upd.setMnemonic('U');
			
			cancel=new JButton("  Cancel   ");
			cancel.setBounds(220,235,150,25);
			cancel.addActionListener(this);
			cancel.setToolTipText("press to exit");
			cancel.setMnemonic('c');
			
				
				cn.setBackground(new Color(250, 216, 217));
			pn.add(header);
			cn.add(lblusrnm);
			cn.add(lblpasswd);
			cn.add(txtpasswd);
			cn.add(lblcurrent);
			cn.add(lblusrtype);
			cn.add(usrnm);
			cn.add(usrtype);
			cn.add(txtcurrent);
			cn.add(lblconfirmpasswd);
			cn.add(txtconfirmpasswd);
			cn.add(upd);
			cn.add(cancel);
			cn.add(pn);
			cn.add(img);
			
			Dimension wind=Toolkit.getDefaultToolkit().getScreenSize();
			
			pack();
			setBounds((wind.width-400)/2,(wind.height-300)/2,400,300);
			setVisible(true);
			connect();
			txtcurrent.requestFocus();
			try
					{
						rs=stat.executeQuery("select type from login where name='"+usr.trim()+"'");
						rs.next();
						usrtype.setText(rs.getString(1));
					}
						catch(SQLException sqle)
					{
						JOptionPane.showMessageDialog(null,"could not Change User Password"+sqle,"USER ACCOUNT",JOptionPane.ERROR_MESSAGE);
					}
		}
	
	private void upduserid()
	{
		str1=txtcurrent.getText();
		str2=txtpasswd.getText();
		str3=txtconfirmpasswd.getText();
			try
			{
				rs=stat.executeQuery("select passwd from login where name='"+str4.trim()+"'");
				rs.next();
				tmp=rs.getString(1);
			}
				catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"could not update User"+sqle,"USER ACCOUNT",JOptionPane.ERROR_MESSAGE);
			}
			if(str1.compareTo(tmp.trim())==0)
			{
				if(str2.compareTo("")!=0||str3.compareTo("")!=0)
		if(str2.compareTo(str3.trim())==0)
				{
					try
					{
						stat.executeUpdate("update login set passwd='"+str2.trim()+"'");
						stat.executeUpdate("commit");
						JOptionPane.showMessageDialog(null,"User Password Changes Succesfully","USER ACCOUNT",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
						catch(SQLException sqle)
					{
						JOptionPane.showMessageDialog(null,"could not Change User Password"+sqle,"USER ACCOUNT",JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				JOptionPane.showMessageDialog(null,"new Password and Confirm Password does not match \n                  Try Again","USER ACCOUNT",JOptionPane.WARNING_MESSAGE);
				else
				JOptionPane.showMessageDialog(null,"Please Fill the New Password Or confirm Password","USER ACCOUNT",JOptionPane.WARNING_MESSAGE);
		}
			else
			{
				JOptionPane.showMessageDialog(null,"Incorrect Current Password","USER ACCOUNT",JOptionPane.WARNING_MESSAGE);
				
			}	
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		String tmp=e.getActionCommand();
		tmp=tmp.trim();
		if(e.getSource()==upd)
		{
			upduserid();	
		}
		else if(e.getSource()==cancel)
		{
			dispose();
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
	
	public static void main(String args[])
	{
		new ChangePasswd("Ravi kumar");
	}
}