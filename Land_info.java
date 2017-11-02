import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;

public class Land_info
{
	private JLabel pic,title,l1,l2,l3,l4,l5,l6,l7;
	private JTextField t1,t2,t3,t4,t5,t6,t7;
	private JButton sav,del,upd,neew,ser,ext,first,last,prev,nex,rec;
	private Icon i;
	private Container cn;
	Connection conn;
	Statement stat;
	ResultSet rs;
	String tlinf,linf,str1,str2,str3,str4,str5,str6,str7;
	String colhead[]={"Village_code","Individual_info_no","LAND_INFO_NO","LAND_IN_ACRE","IRRIGATED_LAND","NON_IRRIGATED_LAND","HOUSE_AREA"};                         
	Object data[][]=new Object[30][7];
	JTable table=new JTable(data,colhead);
	int f,c,k;
	private JComboBox cbvill,cbinv;
	JFrame aw=new JFrame("Computerized Databank System of Bihar");
	
	public Land_info()
	{
		
		
		aw.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cn=aw.getContentPane();
		cn.setLayout(null);

		BevelBorder bl=new BevelBorder(BevelBorder.RAISED);
	
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBounds(200,3,550,40);
		title=new JLabel("Welcom in Land Information Entry Form");
		title.setFont(new Font("Georgia",Font.BOLD,25));
		title.setBounds(0,0,550,40);
		title.setForeground(Color.red);
		title.setBorder(bl);
		pn.setBackground(Color.green);
		cn.add(pn);
		
		ImageIcon icn=new ImageIcon("ravjpg.jpg");
		pic=new JLabel(icn);
		pic.setBounds(0,0,300,350);
		
		ImageIcon icn1=new ImageIcon("1658221146.jpg");
		JLabel pic1=new JLabel(icn1);
		pic1.setBounds(0,0,910,650);
		
		l1=new JLabel("Village_Code");
		l1.setBounds(320,60,180,30);
	    l1.setBorder(bl);
	    l1.setForeground(Color.red);
		
		l2=new JLabel("Individual_Info_No");
		l2.setBounds(320,100,180,30);
		l2.setForeground(Color.red);
	 	l2.setBorder(bl);
		
		l3=new JLabel("Land Info Number");
		l3.setBounds(320,140,180,30);
		l3.setForeground(Color.red);
		l3.setBorder(bl);
		
		l4=new JLabel("Land In Acre");
		l4.setBounds(320,180,180,30);
		l4.setForeground(Color.red);
		l4.setBorder(bl);
		
		l5=new JLabel("Irrigated Land");
		l5.setBounds(320,220,180,30);
		l5.setForeground(Color.red);
		l5.setBorder(bl);
		
		l6=new JLabel("Non_Irrigated_Land");
		l6.setBounds(320,260,180,30);
		l6.setForeground(Color.red);
		l6.setBorder(bl);
		
		l7=new JLabel("House_Area");
		l7.setBounds(320,300,180,30);
		l7.setForeground(Color.red);
		l7.setBorder(bl);
		
		cbvill=new JComboBox();
		cbvill.setBounds(520,60,200,30);
		cbinv=new JComboBox();
		cbinv.setBounds(520,100,200,30);	
	/*	t1=new JTextField(20);
		t1.setBounds(520,60,200,30);
		t1.addActionListener(new enterListener());
		
		t2=new JTextField(20);
		t2.setBounds(520,100,200,30);
		t2.addActionListener(new enterListener());*/
		
		t3=new JTextField(20);
		t3.setBounds(520,140,200,30);
		t3.setEditable(false);
	       
		t4=new JTextField(20);
		t4.setBounds(520,180,200,30);
		t4.addActionListener(new enterListener());
		
		t5=new JTextField(20);
		t5.setBounds(520,220,200,30);
		t5.addActionListener(new enterListener());
		
		t6=new JTextField(20);
		t6.setBounds(520,260,200,30);
		t6.addActionListener(new enterListener());
		
		t7=new JTextField(20);
		t7.setBounds(520,300,200,30);
		t7.addActionListener(new enterListener());
		
		neew=new JButton("New");
		neew.addActionListener(new neewListener());
		neew.setMnemonic('N');
		neew.setToolTipText("To enter new record");
        neew.setBounds(750,60,100,30);
		
		sav=new JButton("Save");
		sav.addActionListener(new saveListener());
		sav.setMnemonic('S');
		sav.setToolTipText("To save record");
		sav.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        sav.setBounds(750,100,100,30);
		
		del=new JButton("Delete");
		del.addActionListener(new deletListener());
		del.setMnemonic('D');
		del.setToolTipText("To Delete record");
        del.setBounds(750,140,100,30);
		
		ext=new JButton("eXit");
		ext.addActionListener(new exitListener());
		ext.setMnemonic('X');
		ext.setToolTipText("To exit");
        ext.setBounds(750,180,100,30);
        
		
		upd=new JButton("Update");
		upd.addActionListener(new updateListener());
		upd.setMnemonic('U');
		upd.setToolTipText("To update the exitisting record");
        upd.setBounds(750,220,100,30);
		
		ser=new JButton("sEarch");
		ser.addActionListener(new searchListener());
		ser.setMnemonic('E');
		ser.setToolTipText("To search a record");
        ser.setBounds(750,260,100,30);
        
        rec=new JButton("Recover");
		rec.addActionListener(new recoverListener());
		rec.setMnemonic('R');
		rec.setToolTipText("Restore Modified record");
        rec.setBounds(50,310,100,30);
        
        JButton	ld=new JButton("Load");
		ld.addActionListener(new loadListener());
		ld.setMnemonic('L');
		ld.setToolTipText("To Load record");
        ld.setBounds(750,300,100,30);
		
	/*	first=new JButton(">|");
		first.addActionListener(new firstListener());
		first.setMnemonic('F');
		first.setToolTipText("View First record");
        first.setBounds(10,310,50,30);
        
		last=new JButton("|<");
		last.addActionListener(new lastListener());
		last.setMnemonic('A');
		last.setToolTipText("view last record");
        last.setBounds(160,310,50,30);
        
		nex=new JButton(">");
		nex.addActionListener(new nextListener());
		nex.setMnemonic('T');
		nex.setToolTipText("view next record");
        nex.setBounds(60,310,50,30);
        
		prev=new JButton("<");
		prev.addActionListener(new previousListener());
		prev.setMnemonic('P');
		prev.setToolTipText("view previous record");
        prev.setBounds(110,310,50,30);*/
        
        	JScrollPane jsp=new JScrollPane(table);
        	jsp.setBounds(5,350,890,200);
        	table.setEnabled(false);
        	
        JLabel	foot=new JLabel("Devloped By:-        Ravi Kumar");
    	JLabel ln=new JLabel("============================================================================================================================================================");
    	ln.setBounds(0,550,900,20);
    	ln.setForeground(Color.red);
    	foot.setBounds(400,570,250,20);
    	foot.setForeground(Color.magenta);
		foot.setFont(new Font("legand",Font.BOLD,15));
		
        pn.add(title);
        cn.add(l1);
         cn.add(l2);
          cn.add(l3);
           cn.add(l4);
            cn.add(l5);
            cn.add(l6);
            cn.add(l7);
             cn.add(cbvill);
              cn.add(cbinv);
               cn.add(t3);
                cn.add(t4);
                 cn.add(t5);
                 cn.add(t6);
                 cn.add(t7);
                  cn.add(neew);
                   cn.add(del);
                    cn.add(ser);
                     cn.add(sav);
                      cn.add(ext);
                      cn.add(rec);
                     /*  cn.add(first);
                        cn.add(last);
                         cn.add(prev);
                          cn.add(nex);*/
                           cn.add(upd);
                           cn.add(jsp);
                           cn.add(ld);
                           cn.add(foot);
                           cn.add(ln);
                           cn.add(pic);
                           cn.add(pic1);
                          
                           cn.setBackground(Color.PINK); 
                           aw.pack();
                           aw.setBounds(110,30,910,650);
                           aw.setResizable(false);
                            aw.setVisible(true);
                            connect();
                          // loadtbl();
                            addvillage();
                            
                            
			
		
    }
    
    private void addvillage()
    {
    	try
	       {
	       	
			cbvill.addItem("Code    |   Name");
	    	rs=stat.executeQuery("select village_code,village_name from village_master order by village_code");
			while(rs.next())
			{
			
				cbvill.addItem(rs.getString(1)+"    |   "+rs.getString(2));
				
			}
			rs.close();
			cbinv.setEnabled(false);
			cbvill.setSelectedIndex(0);
			cbvill.addActionListener(new cbListener());
		}
		catch(SQLException sqle)
		{
			JOptionPane.showMessageDialog(null,"error in fetching"+sqle,"Database Error",JOptionPane.ERROR_MESSAGE);
		}
			
		}
		
		private class cbListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String code,str;
				char ch;
				str=cbvill.getSelectedItem().toString();
				code="";
				for(int i=0;i<str.length();i++)
				{
					ch=str.charAt(i);
					if(Character.isSpace(ch))
					break;
					code=code+ch;
				}
				cbinv.setEnabled(true);
				cbinv.removeActionListener(this);
				cbinv.removeAllItems();
				
				try
				{
					rs=stat.executeQuery("select individual_info_no,name from individual_information_master where village_code='"+code+"'");
					while(rs.next())
					{
						cbinv.addItem(rs.getString(1)+"     |   "+rs.getString(2));
					}
				}
				catch(SQLException sqle)
				{
					JOptionPane.showMessageDialog(null,"Record not transfer","Database Error",JOptionPane.ERROR_MESSAGE);		
				}
			}
		}
    
    private class loadListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		loadtbl();
    	}
    }
    
    private class recoverListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		new recover_land();
    	}
    }
    
      public void loadtbl()
         {
             int k=0;
             
            try
            {
              stat.executeUpdate("commit");
              rs=stat.executeQuery("select * from land_info order by land_info_no");
              while(rs.next())
              {
                str1=rs.getString(1);
                str2=rs.getString(2);
                str3=rs.getString(3);
                str4=rs.getString(4);
                str5=rs.getString(5);
                str6=rs.getString(6);
                str7=rs.getString(7);
                data[k][0]=str1;
                data[k][1]=str2;
                data[k][2]=str3;
                data[k][3]=str4;
                data[k][4]=str5;
                data[k][5]=str6;
                data[k][6]=str7;
                k++;
              }
                data[k][0]=" ";
                data[k][1]=" ";
                data[k][2]=" ";
                data[k][3]=" ";
                data[k][4]=" ";
                data[k][5]="";
                data[k][6]="";
              
                JTable table=new JTable(data,colhead);
               
           
                JScrollPane jsp=new JScrollPane(table);
            //    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//                jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                jsp.setBounds(5,350,890,200);
              cn.add(jsp);
               table.setEnabled(false); 
                 
           }
             catch(SQLException sqle)
             {
                  JOptionPane.showMessageDialog(null,"Record not transfer","Database Error",JOptionPane.ERROR_MESSAGE);                      
             }
            
         }
         
      
         private class enterListener implements ActionListener
         {
         	public void actionPerformed(ActionEvent e)
         	{
         		enter(e);
         	}
         }
         
         public void enter(ActionEvent e)
         {
                  if(e.getSource()==t4)
                    t5.requestFocus();
                  if(e.getSource()==t5)
                    t6.requestFocus();
                  if(e.getSource()==t6)
                  	t7.requestFocus();
                  if(e.getSource()==t7)
                    sav.requestFocus();
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
				JOptionPane.showMessageDialog(null,"error in Creating Connection");
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
				rs=stat.executeQuery("select * from tmpland");
				rs.next();
				tlinf=rs.getString(1);
				t3.setText(tlinf);
				t3.setEditable(false);
				cbvill.setSelectedIndex(0);
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				cbinv.setEnabled(false);
				t4.requestFocus();
			}
			catch(SQLException sqle)
			{
				 JOptionPane.showMessageDialog(null,"could not Fetched");
			}
		}
	}
	
	private class saveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
					try{
					String code,str;
					char ch;
					str=cbvill.getSelectedItem().toString();
					code="";
					for(int i=0;i<str.length();i++)
					{
						ch=str.charAt(i);
						if(Character.isSpace(ch))
						break;
						code=code+ch;
					}
					str1=code;
					
					str=cbinv.getSelectedItem().toString();
					code="";
					for(int i=0;i<str.length();i++)
					{
						ch=str.charAt(i);
						if(Character.isSpace(ch))
						break;
						code=code+ch;
					}
					str2=code;
				}
				catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null,"Please Select The \n   Village_Code AND Individual_Info_Number","ALERT MESSAGE",JOptionPane.WARNING_MESSAGE);
						}
					
					str4=t4.getText();
					str5=t5.getText();
					str6=t6.getText();
					str7=t7.getText();
					if(str4.compareTo("")==0||str5.compareTo("")==0||str6.compareTo("")==0||str7.compareTo("")==0)
					JOptionPane.showMessageDialog(null,"Please Fill The Blank Field","ALERT MESSAGE",JOptionPane.WARNING_MESSAGE);
					else
					{
		stat.executeUpdate("insert into land_info(Village_code,Individual_info_no,LAND_IN_ACRE,IRRIGATED_LAND,NON_IRRIGATED_LAND,HOUSE_AREA) values('"+str1+"','"+str2+"','"+str4+"','"+str5+"','"+str6+"','"+str7+"')");
					stat.executeUpdate("commit");
					JOptionPane.showMessageDialog(null,"Record has been successfully inserted","Information",JOptionPane.INFORMATION_MESSAGE);
					t3.setText("");
					cbvill.setSelectedIndex(0);
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
					cbinv.setEnabled(false);
					t4.requestFocus();
				   loadtbl();
				  }
				
			}
		   
		   catch(SQLException sqle)
		   {
		   	  JOptionPane.showMessageDialog(null,"could not Inserted");
		  }
		
		}
	}
					
			
		
	private class deletListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
				try
			{
				tlinf=JOptionPane.showInputDialog("Enter land info number to be deleted");
				if(tlinf==null||tlinf.compareTo("")==0)
				    {
				    	JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				    }
				else
				{
					int r;
					r=JOptionPane.showConfirmDialog(null,"Are u sure to delete the Record it can't recover later","ALERT ABOUT DELET",JOptionPane.WARNING_MESSAGE);
					if(r==JOptionPane.YES_OPTION)
					{	
				stat.executeUpdate("delete from land_info where land_info_no='"+tlinf+"'");
				stat.executeUpdate("commit");
				loadtbl();
				JOptionPane.showMessageDialog(null,"record deleted successfully","Information",JOptionPane.INFORMATION_MESSAGE);
			}
			}
			}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"could not deleted");
			}
		
		
		}
	}
	
	 private class exitListener implements  ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			int r;
		    r=JOptionPane.showConfirmDialog(null,"Are You Sure To Exit From The Window","Window Closing",JOptionPane.WARNING_MESSAGE);
       		if(r==JOptionPane.YES_OPTION)
          		aw.dispose(); 	
        }	
    }
	
	private class updateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			Sub_land sl=new Sub_land(2);
			loadtbl();
	
		}
	}
	
	private class searchListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Sub_land sl=new Sub_land(1);
	
		}
	}
	
/*	private class firstListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{rs=stat.executeQuery("select * from land_info");
			rs.next();
			//t1.setText(rs.getString(1));
			//t2.setText(rs.getString(2));
			t3.setText(rs.getString(3));
		//	jcmb.setSelectedItem(rs.getString(3));
			t4.setText(rs.getString(4));
			t5.setText(rs.getString(5));
			t6.setText(rs.getString(6));
			t7.setText(rs.getString(7));
	
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
                   rs=stat.executeQuery("select * from land_info");
                   while(rs.next())
                        c=c+1;

                   rs=stat.executeQuery("select * from land_info");
                   while(c!=0)
                               {
                               rs.next();
                               c=c-1;
                               }
                                   //t1.setText(rs.getString(1));
                                  // t2.setText(rs.getString(2));
                                  t3.setText(rs.getString(3));
                                  	//jcmb.setSelectedItem(rs.getString(3));
                                   t4.setText(rs.getString(5));
                                   t5.setText(rs.getString(5));
                                    t6.setText(rs.getString(6));
									t7.setText(rs.getString(7));
                                  
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
            tlinf=t3.getText();
            if(t3.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Click on previous button","Information",JOptionPane.INFORMATION_MESSAGE);
            else
                {
                 rs=stat.executeQuery("select * from land_info");
                while(rs.next())
                        {
                        linf=rs.getString(3);
                        if(tlinf.compareTo(linf)==0)
                        break;
                        }
                        rs.next();
                       // t1.setText(rs.getString(1));
                       // t2.setText(rs.getString(2));
                        t3.setText(rs.getString(3));
                        //jcmb.setSelectedItem(rs.getString(3));
                        t4.setText(rs.getString(4));
                        t5.setText(rs.getString(5));
                        t6.setText(rs.getString(6));
						t7.setText(rs.getString(7));
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
			tlinf=t3.getText();
                    try
                        {
                        rs=stat.executeQuery("select * from land_info");
                        c=0;
                        while(rs.next())
                                {
                               linf=rs.getString(3);
                                if(tlinf.compareTo(linf)==0)
                                        break;
                                        c++;
                                }
                        rs=stat.executeQuery("select * from land_info");
                        k=0;
                        while(rs.next())
                                {
                                k++;
                                if(k==c)
                                break;
                                }
                          // t1.setText(rs.getString(1));
                          // t2.setText(rs.getString(2));
                           t3.setText(rs.getString(3));
                         //	jcmb.setSelectedItem(rs.getString(3));
                           t4.setText(rs.getString(4));
                           t5.setText(rs.getString(5));
                           t6.setText(rs.getString(6));
							t7.setText(rs.getString(7));
							
                        }
                   catch(SQLException sqle)
                        {
                        JOptionPane.showMessageDialog(null,"This is first Record","Information",JOptionPane.INFORMATION_MESSAGE);
                        }
		
		}
	}*/
    
    public static void main(String[] args)
    {
    	Land_info ii=new Land_info();
    }
}
	
