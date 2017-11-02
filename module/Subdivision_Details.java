import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;

public class Subdivision_Details extends JFrame 
{
	private JLabel title,l,l1,l2,l3,l4,l5;
	private JTextField t1,t2,t3,t4,t5;
	private JButton sav,del,upd,neew,ser,ext,first,last,prev,nex,rec;
	private Icon i;
	private Container cn;
	Connection conn;
	Statement stat;
	ResultSet rs;
	String tscd,tsnm,tdcd,tdt,tsdnm,dcd,scd,snm,dt,sdnm,cstr;
	int f,c,k,rst;
	private JComboBox jcmb;
	
	public Subdivision_Details()
	{
		JFrame aw=new JFrame("Computerized Databank System of Bihar");
		Toolkit thekit=aw.getToolkit();
		Dimension dm=thekit.getScreenSize();
		Container cn;
		
		aw.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cn=aw.getContentPane();
		cn.setLayout(null);
		i=new ImageIcon("27996130.jpg");
		l=new JLabel(i);
		l.setBounds(0,0,900,630);
		l.setBackground(Color.RED);
	
		jcmb=new JComboBox();
		jcmb.setBounds(450,250,200,30);
		
		title=new JLabel("Welcom in Subdivision Entry Form");
		title.setFont(new Font("arial",Font.BOLD+Font.ITALIC,40));
		title.setBounds(150,20,700,50);
		title.setForeground(Color.CYAN);
		title.setBackground(Color.RED);
		
		l1=new JLabel("Subdivision_Code");
		//l1.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
		l1.setBounds(200,150,180,30);
		l1.setForeground(Color.WHITE);
		
		l2=new JLabel("Subdivision_Name");
	//	l2.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
		l2.setBounds(200,200,180,30);
		l2.setForeground(Color.WHITE);
		
		l3=new JLabel("District_Code");
		//l3.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
		l3.setBounds(200,250,180,30);
		l3.setForeground(Color.WHITE);
		
		l4=new JLabel("ESTD");
		//l4.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
		l4.setBounds(200,300,180,30);
		l4.setForeground(Color.WHITE);
		
		l5=new JLabel("sdo_name");
	//	l5.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
		l5.setBounds(200,350,180,30);
		l5.setForeground(Color.WHITE);
		
		t1=new JTextField(20);
		t1.setBounds(450,150,200,30);
		t1.setEditable(false);
		
		t2=new JTextField(20);
		t2.setBounds(450,200,200,30);
		
	//	t3=new JTextField(20);
	//	t3.setBounds(450,250,200,30);
	
	       
		t4=new JTextField(20);
		t4.setBounds(450,300,200,30);
		
		t5=new JTextField(20);
		t5.setBounds(450,350,200,30);
		
		neew=new JButton("New");
		neew.addActionListener(new neewListener());
		neew.setMnemonic('N');
		neew.setToolTipText("press to enter new record");
		neew.setBackground(new Color(125,250,100));
		neew.setFont(new Font("Serif",Font.BOLD,20));
		neew.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        neew.setBounds(150,400,100,30);
		
		sav=new JButton("Save");
		sav.addActionListener(new saveListener());
		sav.setMnemonic('S');
		sav.setToolTipText("press  to save record");
		sav.setBackground(new Color(125,250,100));
		sav.setFont(new Font("Serif",Font.BOLD,20));
		sav.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        sav.setBounds(260,400,100,30);
		
		del=new JButton("Delete");
		del.addActionListener(new deletListener());
		del.setMnemonic('D');
		del.setToolTipText("press to Delete record");
		del.setBackground(new Color(125,250,100));
		del.setFont(new Font("Serif",Font.BOLD,20));
		del.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        del.setBounds(370,400,100,30);
		
		ext=new JButton("eXit");
		ext.addActionListener(new exitListener(aw));
		ext.setMnemonic('X');
		ext.setToolTipText("press to exit");
		ext.setBackground(new Color(125,250,100));
		ext.setFont(new Font("Serif",Font.BOLD,20));
		ext.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        ext.setBounds(710,400,100,30);
        
		
		upd=new JButton("Update");
		upd.addActionListener(new updateListener());
		upd.setMnemonic('U');
		upd.setToolTipText("press to update the exitisting record");
		upd.setBackground(new Color(125,250,100));
		upd.setFont(new Font("Serif",Font.BOLD,20));
		upd.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        upd.setBounds(600,400,100,30);
		
		ser=new JButton("sEarch");
		ser.addActionListener(new searchListener());
		ser.setMnemonic('E');
		ser.setToolTipText("press to search a record");
		ser.setBackground(new Color(125,250,100));
		ser.setFont(new Font("Serif",Font.BOLD,20));
		ser.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        ser.setBounds(480,400,100,30);
		
		first=new JButton("First");
		first.addActionListener(new firstListener());
		first.setMnemonic('F');
		first.setToolTipText("press to the first record");
		first.setBackground(new Color(125,250,100));
		first.setFont(new Font("Serif",Font.BOLD,20));
		first.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        first.setBounds(260,450,100,30);

		nex=new JButton("nexT");
		nex.addActionListener(new nextListener());
		nex.setMnemonic('T');
		nex.setToolTipText("press to see the next record");
		nex.setBackground(new Color(125,250,100));
		nex.setFont(new Font("Serif",Font.BOLD,20));
		nex.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        nex.setBounds(370,450,100,30);
        
		prev=new JButton("Previous");
		prev.addActionListener(new previousListener());
		prev.setMnemonic('P');
		prev.setToolTipText("press to see previous record");
		prev.setBackground(new Color(125,250,100));
		prev.setFont(new Font("Serif",Font.BOLD,20));
		prev.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        prev.setBounds(480,450,100,30);
        
        last=new JButton("Last");
		last.addActionListener(new lastListener());
		last.setMnemonic('L');
		last.setToolTipText("press to show the last record");
		last.setBackground(new Color(125,250,100));
		last.setFont(new Font("Serif",Font.BOLD,20));
		last.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        last.setBounds(600,450,100,30);
        
        rec=new JButton("Recover");
		rec.addActionListener(new recoverListener());
		rec.setMnemonic('R');
		rec.setToolTipText("Recover Modified Record");
		rec.setBackground(new Color(125,250,100));
		rec.setFont(new Font("Serif",Font.BOLD,20));
		rec.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        rec.setBounds(385,500,100,30);
        
        	JLabel	foot=new JLabel("Devloped By:-        Ravi Kumar");
    	JLabel ln=new JLabel("============================================================================================================================================================");
    	ln.setBounds(0,560,900,20);
    	ln.setForeground(Color.red);
    	foot.setBounds(400,580,250,20);
    	foot.setForeground(Color.magenta);
		foot.setFont(new Font("legand",Font.BOLD,15));
        
        cn.add(title);
        cn.add(l1);
         cn.add(l2);
          cn.add(l3);
           cn.add(l4);
            cn.add(l5);
             cn.add(t1);
              cn.add(t2);
               //cn.add(t3);
                cn.add(t4);
                 cn.add(t5);
                  cn.add(neew);
                   cn.add(del);
                    cn.add(ser);
                     cn.add(sav);
                      cn.add(ext);
                       cn.add(first);
                        cn.add(last);
                         cn.add(prev);
                          cn.add(nex);
                           cn.add(upd);
                           cn.add(rec);
                           cn.add(ln);
                           cn.add(foot);
                           cn.add(jcmb);
                           cn.add(l);
                           
                           cn.setBackground(Color.PINK); 
                           aw.pack();
                           aw.setSize(910,650);
                            aw.setVisible(true);
                            connect();
                            load();		
		
    }
    
   
    public void load()
    {
    	try
	       {
	       	
			//jcmb.addItem("DISTRICT_CODE");
	    	rs=stat.executeQuery("select district_code from district_Master order by district_code");
			while(rs.next())
			{
			
				jcmb.addItem(rs.getString(1));
				
			}
			rs.close();
		}
		catch(SQLException sqle)
		{
			JOptionPane.showMessageDialog(null,"error in fetching"+sqle,"Database Error",JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null,"Not connected to Database","Database Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
		private class neewListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				rs=stat.executeQuery("select * from tmpsbcode");
				rs.next();
				tscd=rs.getString(1);
				t1.setEditable(false);
				t1.setText(tscd);
				t2.setText("");
				jcmb.setSelectedIndex(0);
				t4.setText("");
				t5.setText("");
				t2.requestFocus();
			}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"error in sequence"+sqle,"Could no Fetch",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
		private class recoverListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new recover_subdivision();
		}
	}
	
	private class saveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{

					tsnm=t2.getText();
					tdcd=String.valueOf(jcmb.getSelectedItem());
					tdt=t4.getText();
					tsdnm=t5.getText();
					if(tsnm.compareTo("")==0||tdt.compareTo("")==0||tsdnm.compareTo("")==0)
						JOptionPane.showMessageDialog(null,"Please Fill The Blank Field","ALERT MESSAGE",JOptionPane.WARNING_MESSAGE);
					else
					{
		stat.executeUpdate("insert into Subdivision_master(subdiv_name,district_code,estd,sdo_name) values('"+tsnm.trim()+"','"+tdcd.trim()+"','"+tdt.trim()+"','"+tsdnm.trim()+"')");
					stat.executeUpdate("commit");
					JOptionPane.showMessageDialog(null,"Record has been successfully inserted","Information",JOptionPane.INFORMATION_MESSAGE);
					t1.setText("");
					t2.setText("");
					jcmb.setSelectedIndex(0);
					t4.setText("");
					t5.setText("");
					t2.requestFocus();
				}
				
			}
		   
		   catch(SQLException sqle)
		   {
		   	  JOptionPane.showMessageDialog(null,"could not Inserted"+sqle,"Database Error",JOptionPane.ERROR_MESSAGE);
		  }
		
		}
	}
					
			
		
	private class deletListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
				try
			{
				int rst;
				scd=JOptionPane.showInputDialog("Enter subdivision code to be deleted");
				if(scd==null||scd.compareTo("")==0)
				    {
				    	JOptionPane.showMessageDialog(null,"please enter a value","ALERT",JOptionPane.INFORMATION_MESSAGE);
				    }
				else
				{
					
					rst=JOptionPane.showConfirmDialog(null,"ARE U SURE TO DELETE THE RECORD"+"  "+scd,"Alert Message",JOptionPane.WARNING_MESSAGE);
					if(rst==JOptionPane.YES_OPTION)
					{
				stat.executeUpdate("delete from subdivision_master where subdiv_code='"+scd+"'");
				stat.executeUpdate("commit");
				JOptionPane.showMessageDialog(null,"record deleted successfully","Information",JOptionPane.INFORMATION_MESSAGE);
			}
			}
			}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"could not deleted"+sqle,"Database Error",JOptionPane.ERROR_MESSAGE);
			}
		
		
		}
	}
	
	 private class exitListener implements  ActionListener
	{
		JFrame a;
		public exitListener(JFrame aw)
		{
		 a=aw;
		 }
		public void actionPerformed(ActionEvent e)
		{
			rst=JOptionPane.showConfirmDialog(null,"ARE U SURE TO CLOSE THE FORM","Alert Message",JOptionPane.WARNING_MESSAGE);
					if(rst==JOptionPane.YES_OPTION)
					{
          a.dispose();
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
				tscd=t1.getText();
				tsnm=t2.getText();
				tdcd=jcmb.getSelectedItem().toString();
				tdt=t4.getText();
				tsdnm=t5.getText();
				if(tscd.compareTo("")==0)
				    JOptionPane.showMessageDialog(null,"please enter a value","Information",JOptionPane.INFORMATION_MESSAGE);
				else
				{
						rst=JOptionPane.showConfirmDialog(null,"ARE U SURE TO UPDATE THE RECORD"+"  "+tscd,"Alert Message",JOptionPane.WARNING_MESSAGE);
					if(rst==JOptionPane.YES_OPTION)
					{   
				stat.executeUpdate("update subdivision_master set subdiv_name='"+tsnm.trim()+"',district_code='"+tdcd.trim()+"',estd='"+tdt.trim()+"',sdo_name='"+tsdnm.trim()+"'where subdiv_code='"+tscd.trim()+"'");
				
				stat.executeUpdate("commit");
				JOptionPane.showMessageDialog(null,"record updated successfully","Information",JOptionPane.INFORMATION_MESSAGE);
			}
			}
		
		}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"could not update"+sqle,"Database Error",JOptionPane.ERROR_MESSAGE);
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
				    scd=JOptionPane.showInputDialog("Enter the subdivision code to be search");
				    if(scd==null||scd.compareTo("")==0)
				    {
				    	JOptionPane.showMessageDialog(null,"please enter a value","Information",JOptionPane.INFORMATION_MESSAGE);
				    }
				    else
				    {
					rs=stat.executeQuery("select subdiv_code,subdiv_name,district_code,TO_CHAR(estd,'DD-MON-YYYY'),sdo_name from subdivision_master where subdiv_CODE='"+scd+"'");
					rs.next();
					t1.setText(rs.getString(1));
					t2.setText(rs.getString(2));
					//t3.setText(rs.getString(3));
					jcmb.setSelectedItem(rs.getString(3));
					t4.setText(rs.getString(4));
					t5.setText(rs.getString(5));
					JOptionPane.showMessageDialog(null,"record found","Information",JOptionPane.INFORMATION_MESSAGE);
				}
				}
				catch(SQLException sqle)
				{
					JOptionPane.showMessageDialog(null,"Record not found","Record not Exist",JOptionPane.ERROR_MESSAGE);
				}			
			
		}
	}
	
	private class firstListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{rs=stat.executeQuery("select subdiv_code,subdiv_name,district_code,TO_CHAR(estd,'DD-MON-YYYY'),sdo_name from subdivision_master order by subdiv_code");
			rs.next();
			t1.setText(rs.getString(1));
			t2.setText(rs.getString(2));
			//t3.setText(rs.getString(3));
			jcmb.setSelectedItem(rs.getString(3));
			t4.setText(rs.getString(4));
			t5.setText(rs.getString(5));
		}
		catch(SQLException sqle)
		{
			JOptionPane.showMessageDialog(null,sqle,"Database Error",JOptionPane.ERROR_MESSAGE);
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
                   rs=stat.executeQuery("select subdiv_code,subdiv_name,district_code,TO_CHAR(estd,'DD-MON-YYYY'),sdo_name from subdivision_master order by subdiv_code");
                   while(rs.next())
                        c=c+1;

                   rs=stat.executeQuery("select subdiv_code,subdiv_name,district_code,TO_CHAR(estd,'DD-MON-YYYY'),sdo_name from subdivision_master order by subdiv_code");
                   while(c!=0)
                               {
                               rs.next();
                               c=c-1;
                               }
                                   t1.setText(rs.getString(1));
                                   t2.setText(rs.getString(2));
                                  // t3.setText(rs.getString(3));
                                  	jcmb.setSelectedItem(rs.getString(3));
                                   t4.setText(rs.getString(4));
                                   t5.setText(rs.getString(5));
                                  
                     }
                  catch(SQLException sqle)
                        {
                        JOptionPane.showMessageDialog(null," Last Record","Information",JOptionPane.INFORMATION_MESSAGE);

                        }
			
		}
	}
	
	private class nextListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
            {
            tscd=t1.getText();
            if(t1.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Click on previous button");
            else
                {
                 rs=stat.executeQuery("select subdiv_code,subdiv_name,district_code,TO_CHAR(estd,'DD-MON-YYYY'),sdo_name from subdivision_master order by subdiv_code");
                while(rs.next())
                        {
                        scd=rs.getString(1);
                        if(scd.compareTo(tscd)==0)
                        break;
                        }
                        rs.next();
                        t1.setText(rs.getString(1));
                        t2.setText(rs.getString(2));
                        //t3.setText(rs.getString(3));
                        jcmb.setSelectedItem(rs.getString(3));
                        t4.setText(rs.getString(4));
                        t5.setText(rs.getString(5));
                }
            }
          catch(SQLException sqle)
                {
                JOptionPane.showMessageDialog(null,"This is last record","Information",JOptionPane.INFORMATION_MESSAGE);
                }
		}
	}
	
	private class previousListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			tscd=t1.getText();
                    try
                        {
                        rs=stat.executeQuery("select subdiv_code,subdiv_name,district_code,TO_CHAR(estd,'DD-MON-YYYY'),sdo_name from subdivision_master order by subdiv_code");
                        c=0;
                        while(rs.next())
                                {
                               scd=rs.getString(1);
                                if(scd.compareTo(tscd)==0)
                                        break;
                                        c++;
                                }
                        rs=stat.executeQuery("select subdiv_code,subdiv_name,district_code,TO_CHAR(estd,'DD-MON-YYYY'),sdo_name from subdivision_master order by subdiv_code");
                        k=0;
                        while(rs.next())
                                {
                                k++;
                                if(k==c)
                                break;
                                }
                           t1.setText(rs.getString(1));
                           t2.setText(rs.getString(2));
                         //  t3.setText(rs.getString(3));
                         	jcmb.setSelectedItem(rs.getString(3));
                           t4.setText(rs.getString(4));
                           t5.setText(rs.getString(5));
                        }
                   catch(SQLException sqle)
                        {
                        JOptionPane.showMessageDialog(null,"This is first Record","Information",JOptionPane.INFORMATION_MESSAGE);
                        }
		
		}
	}
    
    public static void main(String[] args)
    {
    	Subdivision_Details sd=new Subdivision_Details();
    }
}
                        
                            
	