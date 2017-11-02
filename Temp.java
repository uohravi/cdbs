import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Temp extends JFrame
{
	private JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11;
	private JLabel title,l1,l2,l3,l4,logo;
	private JTextField t1,t2;
	private JButton sav,del,upd,neew,ser,ext,first,last,prev,nex,rec;
	private Container cn;
	String dscd,dsnm,tcd,tnm;
     Connection conn;
	 Statement stat;
	 ResultSet rs;
	 int f,c,k;
	
	public Temp()
	{
		super("Computerized Databank System of Bihar");
		setBounds(100,10,500,650);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		title=new JLabel("Welcome to District Entry Form");
		title.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,30));
		title.setForeground(Color.CYAN);
		title.setBackground(Color.LIGHT_GRAY);
		
		l1=new JLabel("District_code : ");
		l1.setFont(new Font("Arial",Font.BOLD,20));
		
		l2=new JLabel("District_Name : ");
		l2.setFont(new Font("Arial",Font.BOLD,20));
		
		l3=new JLabel("            ");
		l4=new JLabel("");
		
		Icon icn=new ImageIcon("5.jpg");
		logo=new JLabel(icn);
		
		
		t1=new JTextField(20);
		t2=new JTextField(20);
		t2.addActionListener(new enterListener());
		
		cn=getContentPane();
		cn.setLayout(null);
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		p8=new JPanel();
		p9=new JPanel();
		p10=new JPanel();
		p11=new JPanel();
		
		neew=new JButton("New");
		neew.addActionListener(new neewListener());
		neew.setMnemonic('N');
		neew.setToolTipText("press to enter new record");
		neew.setBackground(new Color(125,250,100));
		
		sav=new JButton("Save");
		sav.addActionListener(new saveListener());
		sav.setMnemonic('S');
		sav.setToolTipText("press  to save record");
		sav.setBackground(new Color(125,250,100));
		
		del=new JButton("Delete");
		del.addActionListener(new deletListener());
		del.setMnemonic('D');
		del.setToolTipText("press to Delete record");
		del.setBackground(new Color(125,250,100));
		
		ext=new JButton("eXit");
		ext.addActionListener(new exitListener());
		ext.setMnemonic('X');
		ext.setToolTipText("press to exit");
		ext.setBackground(new Color(125,250,100));
		
		upd=new JButton("Update");
		upd.addActionListener(new updateListener());
		upd.setMnemonic('U');
		upd.setToolTipText("press to update the exitisting record");
		upd.setBackground(new Color(125,250,100));
		
		ser=new JButton("sEarch");
		ser.addActionListener(new searchListener());
		ser.setMnemonic('E');
		ser.setToolTipText("press to search a record");
		ser.setBackground(new Color(125,250,100));
		
		first=new JButton("First");
		first.addActionListener(new firstListener());
		first.setMnemonic('F');
		first.setToolTipText("press to the first record");
		first.setBackground(new Color(125,250,100));
		
		last=new JButton("Last");
		last.addActionListener(new lastListener());
		last.setMnemonic('L');
		last.setToolTipText("press to show the last record");
		last.setBackground(new Color(125,250,100));
		
		nex=new JButton("nexT");
		nex.addActionListener(new nextListener());
		nex.setMnemonic('T');
		nex.setToolTipText("press to see the next record");
		nex.setBackground(new Color(125,250,100));
		
		prev=new JButton("Previous");
		prev.addActionListener(new previousListener());
		prev.setMnemonic('P');
		prev.setToolTipText("press to see previous record");
		prev.setBackground(new Color(125,250,100));
		
		rec=new JButton("Recover");
		rec.addActionListener(new recoverListener());
		rec.setMnemonic('R');
		rec.setToolTipText("Recover Modified Data");
		rec.setBackground(new Color(125,250,100));
		
			JLabel	foot=new JLabel("Devloped By:-        Ravi Kumar");
    	JLabel ln=new JLabel("============================================================================================================================================================");
    	ln.setBounds(0,560,900,20);
    	ln.setForeground(Color.red);
    	foot.setBounds(400,580,250,20);
    	foot.setForeground(Color.magenta);
		foot.setFont(new Font("legand",Font.BOLD,15));
		
		cn.setLayout(new GridLayout(14,1));
		
		p1.add(title);
		p1.add(logo);
		p1.setBackground(Color.LIGHT_GRAY);
		p2.add(l3);
		p3.add(l1);
		p3.add(t1);
		p4.add(l3);
		p5.add(l2);
		p5.add(t2);
		p6.add(l4);
		p7.add(l3);
		p8.add(l3);
		p9.add(neew);p9.add(sav);p9.add(del);p9.add(upd);p9.add(ser);p9.add(ext);
		p10.add(first);p10.add(nex);p10.add(prev);p10.add(last);
		p11.add(rec);
		
		cn.add(p1);
		cn.add(p2);
		cn.add(p3);
		cn.add(p4);
		cn.add(p5);
		cn.add(p6);
		cn.add(p7);
		cn.add(p8);
		cn.add(p9);
		cn.add(p10);
		cn.add(p11);
		cn.add(ln);
		cn.add(foot);
		//cn.add(l4);
	
                 t1.setEditable(false);
		 pack();
		 setVisible(true);
		 connect();
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
				JOptionPane.showMessageDialog(null,"error in Creating Connection","warning",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Not connected to Database");
		}
	}
			
				
			
	private class neewListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
                        rs=stat.executeQuery("select * from lookupdis");
                        rs.next();
                        tcd=rs.getString(1);
                        t1.setText(tcd);
                        t1.setEditable(false);
                        rs.close();
                         t2.setText("");
			t2.requestFocus();

                       }
		   catch(SQLException sqle)
		   {
                          JOptionPane.showMessageDialog(null,sqle,"Error",JOptionPane.ERROR_MESSAGE);
		  
		   }


		}
	}
	
	private class enterListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String st;
			st=t2.getText();
			st=st.trim()+".jpg";
			JOptionPane.showMessageDialog(null,st);
			Icon ic=new ImageIcon(st.trim());
			l4.setIcon(ic);


		}
	}
	
		private class recoverListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new recover_district();

		}
	}
	
	private class saveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		
         try{
					tnm=t2.getText();
					if(tnm.compareTo("")==0)
					JOptionPane.showMessageDialog(null,"Please Fill The Blank Field","ALERT MESSAGE",JOptionPane.WARNING_MESSAGE);
					else
					{
                    stat.executeUpdate("insert into District_master(district_name) values('"+tnm+"')");
					stat.executeUpdate("commit");
					JOptionPane.showMessageDialog(null,"Record has been successfully inserted","Information",JOptionPane.INFORMATION_MESSAGE);
                    t2.setText(""); 
                    } 
			}

		   catch(SQLException sqle)
		   {
		   	  JOptionPane.showMessageDialog(null,"could not Inserted"+sqle,"Error",JOptionPane.ERROR_MESSAGE);
		  
		   }
		
		}
	}
					
			
		
	private class deletListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int rst;
			
				try
			{
				dscd=JOptionPane.showInputDialog("Enter district code to be deleted");
				if(dscd.equals("")||dscd==null)
				{
					JOptionPane.showMessageDialog(null,"please enter a value","Information",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					rst=JOptionPane.showConfirmDialog(null,"ARE U SURE TO DELETE THE RECORD"+"  "+dscd,"Alert Message",JOptionPane.WARNING_MESSAGE);
					if(rst==JOptionPane.YES_OPTION)
					{
				stat.executeUpdate("delete from district_master where district_code='"+dscd+"'");
				stat.executeUpdate("commit");
				JOptionPane.showMessageDialog(null,"record deleted successfully","Information",JOptionPane.INFORMATION_MESSAGE);
			}
			}
		}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"could not deleted"+sqle,"Error",JOptionPane.ERROR_MESSAGE);
			}
		
		
		}
	}
	
	public class exitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				
				conn.close();
				dispose();
			}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,sqle,"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private class updateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		
			try
			{
				int rst;
				tcd=t1.getText();
				tnm=t2.getText();
				if(tcd.equals("")||tcd==null)
				{
					JOptionPane.showMessageDialog(null,"please enter a value to be updated","Information",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					rst=JOptionPane.showConfirmDialog(null,"ARE U SURE TO UPDATE THE RECORD"+"  "+tcd,"Alert Message",JOptionPane.WARNING_MESSAGE);
					if(rst==JOptionPane.YES_OPTION)
					{
				stat.executeUpdate("update district_master set district_name='"+tnm.trim()+"' where district_code='"+tcd+"'");
				stat.executeUpdate("commit");
				JOptionPane.showMessageDialog(null,"record updated successfully","Information",JOptionPane.INFORMATION_MESSAGE);
			}
			}
		}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"could not update"+sqle,"Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	
	private class searchListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String s1;	
			try
			{
				    s1=JOptionPane.showInputDialog("Enter the District_code to be search");
					rs=stat.executeQuery("select * from district_master where DISTRICT_CODE='"+s1+"'");
					rs.next();
					t1.setText(rs.getString(1));
					t2.setText(rs.getString(2));
					JOptionPane.showMessageDialog(null,"record found","Information",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(SQLException sqle)
				{
					JOptionPane.showMessageDialog(null,"not found","Error",JOptionPane.ERROR_MESSAGE);
				}			
			
		}
	}
	
	private class firstListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{rs=stat.executeQuery("select * from district_master order by district_code");
			rs.next();
			t1.setText(rs.getString(1));
			t2.setText(rs.getString(2));
		}
		catch(SQLException sqle)
		{
			JOptionPane.showMessageDialog(null,sqle);
		}
		}
	}
	
	private class lastListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
                     {
                     c=0;
                   rs=stat.executeQuery("select * from district_master order by district_code");
                   while(rs.next())
                        c=c+1;

                   rs=stat.executeQuery("select * from district_master order by district_code");
                   while(c!=0)
                               {
                               rs.next();
                               c=c-1;
                               }
                                   t1.setText(rs.getString(1));
                                   t2.setText(rs.getString(2));
                                  
                     }
                  catch(SQLException sqle)
                        {
                        JOptionPane.showMessageDialog(null," Last Record");

                        }
			
		}
	}
	
	private class nextListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
            {
            tcd=t1.getText();
            if(t1.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Click on previous button");
            else
                {
                 rs=stat.executeQuery("select * from district_master order by district_code");
                while(rs.next())
                        {
                        dscd=rs.getString(1);
                        if(dscd.compareTo(tcd)==0)
                        break;
                        }
                        rs.next();
                        t1.setText(rs.getString(1));
                        t2.setText(rs.getString(2));
                }
            }
          catch(SQLException sqle)
                {
                JOptionPane.showMessageDialog(null,"This is last record");
                }
		}
	}
	
	private class previousListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			tcd=t1.getText();
                    try
                        {
                        rs=stat.executeQuery("select * from district_master order by district_code");
                        c=0;
                        while(rs.next())
                                {
                               dscd=rs.getString(1);
                                if(dscd.compareTo(tcd)==0)
                                        break;
                                        c++;
                                }
                        rs=stat.executeQuery("select * from district_master order by district_code");
                        k=0;
                        while(rs.next())
                                {
                                k++;
                                if(k==c)
                                break;
                                }
                           t1.setText(rs.getString(1));
                           t2.setText(rs.getString(2));
                        }
                   catch(SQLException sqle)
                        {
                        JOptionPane.showMessageDialog(null,"This is first Record");
                        }
		
		}
	}
	
	public static void main(String[] args)
	{
		Temp dd=new Temp();
	}
}
		
