import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;

public class Individual_Information
{
	private JLabel title,l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
	private JButton sav,del,upd,neew,ser,ext,first,last,prev,nex,rec;
	private Icon i;
	private Container cn;
	Connection conn;
	Statement stat;
	ResultSet rs;
	String tinf,inf,str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14;
	String colhead[]={"Village_code","Individual_info_no","name","NO_OF_FAMILY_MEMBER","NO_OF_MALE","NO_OF_FEMALE","NO_OF_CHILD","OCCUPATION","ORGANISATION_NAME","POST_HELD","ANNUAL_INCOME","POVERTY_STATUS","DOB","REMARKS"};                         
	Object data[][]=new Object[30][14];
	JTable table=new JTable(data,colhead);
	int f,c,k;
	private JComboBox jcmb,cbpov;
	JFrame aw=new JFrame("Computerized Databank System of Bihar");
	
	public Individual_Information()
	{
		
		
		aw.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cn=aw.getContentPane();
		cn.setLayout(null);
		i=new ImageIcon("271559999.jpg");
		l=new JLabel(i);
		l.setBounds(0,0,900,650);
		//l.setBackground(Color.RED);
	
		BevelBorder bl=new BevelBorder(BevelBorder.RAISED);
	
		JPanel pn=new JPanel();
		pn.setBounds(130,5,700,40);
		title=new JLabel("Welcom in Individual Information Entry Form");
		title.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,25));
		title.setBounds(150,3,700,40);
		title.setForeground(Color.red);
		title.setBorder(bl);
		pn.setBackground(Color.blue);
		cn.add(pn);
		
		l1=new JLabel("Village_Code");
		l1.setBounds(25,60,180,30);
	    l1.setBorder(bl);
	    l1.setForeground(Color.red);
		
		l2=new JLabel("Individual_Info_No");
		l2.setBounds(25,100,180,30);
		l2.setForeground(Color.red);
	 	l2.setBorder(bl);
		
		l3=new JLabel("Name");
		l3.setBounds(25,140,180,30);
		l3.setForeground(Color.red);
		l3.setBorder(bl);
		
		l4=new JLabel("No_Of_Family_Member");
		l4.setBounds(25,180,180,30);
		l4.setForeground(Color.red);
		l4.setBorder(bl);
		
		l5=new JLabel("No_Of_Male");
		l5.setBounds(25,220,180,30);
		l5.setForeground(Color.red);
		l5.setBorder(bl);
		
		l6=new JLabel("No_Of_Female");
		l6.setBounds(25,260,180,30);
		l6.setForeground(Color.red);
		l6.setBorder(bl);
		
		l7=new JLabel("No_Of_Child");
		l7.setBounds(25,300,180,30);
		l7.setForeground(Color.red);
		l7.setBorder(bl);
		
		l8=new JLabel("Occupaion");
		l8.setBounds(470,60,180,30);
		l8.setBorder(bl);
		l8.setForeground(Color.red);
		
		l9=new JLabel("Organisation_Name");
		l9.setBounds(470,100,180,30);
		l9.setBorder(bl);
		l9.setForeground(Color.red);
		
		l10=new JLabel("Post_Held");
		l10.setBounds(470,140,180,30);
		l10.setBorder(bl);
		l10.setForeground(Color.red);
		
		l11=new JLabel("Annual_Income");
		l11.setBounds(470,180,180,30);
		l11.setBorder(bl);
		l11.setForeground(Color.red);
			
		l12=new JLabel("Poverty_Status");
		l12.setBounds(470,220,180,30);
		l12.setBorder(bl);
		l12.setForeground(Color.red);
		
		l13=new JLabel("DOB");
		l13.setBounds(470,260,180,30);
		l13.setBorder(bl);
		l13.setForeground(Color.red);
		
		l14=new JLabel("Remarks");
		l14.setBounds(470,300,180,30);
		l14.setBorder(bl);
		l14.setForeground(Color.red);
		
		
		jcmb=new JComboBox();
		jcmb.setBounds(220,60,200,30);	
	//	t1=new JTextField(20);
	//	t1.setBounds(220,60,200,30);
		
		t2=new JTextField(20);
		t2.setBounds(220,100,200,30);
		t2.setEditable(false);
		
		t3=new JTextField(20);
		t3.setBounds(220,140,200,30);
	
	       
		t4=new JTextField(20);
		t4.setBounds(220,180,200,30);
		
		t5=new JTextField(20);
		t5.setBounds(220,220,200,30);
	
		t6=new JTextField(20);
		t6.setBounds(220,260,200,30);
		
		t7=new JTextField(20);
		t7.setBounds(220,300,200,30);
	
		t8=new JTextField(20);
		t8.setBounds(680,60,200,30);
	
		t9=new JTextField(20);
		t9.setBounds(680,100,200,30);
	
		t10=new JTextField(20);
		t10.setBounds(680,140,200,30);
	
		t11=new JTextField(20);
		t11.setBounds(680,180,200,30);
	
	//	t12=new JTextField(20);
	//	t12.setBounds(680,220,200,30);
		cbpov=new JComboBox();
		cbpov.setBounds(680,220,200,30);
		
		t13=new JTextField(20);
		t13.setBounds(680,260,200,30);
	
		t14=new JTextField(20);
		t14.setBounds(680,300,200,30);
		
		neew=new JButton("New");
		neew.addActionListener(new neewListener());
		neew.setMnemonic('N');
		neew.setToolTipText("press to enter new record");
        neew.setBounds(650,350,100,30);
		
		sav=new JButton("Save");
		sav.addActionListener(new saveListener());
		sav.setMnemonic('S');
		sav.setToolTipText("press  to save record");
		sav.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        sav.setBounds(650,390,100,30);
		
		del=new JButton("Delete");
		del.addActionListener(new deletListener());
		del.setMnemonic('D');
		del.setToolTipText("press to Delete record");
        del.setBounds(650,430,100,30);
        
        	ser=new JButton("sEarch");
		ser.addActionListener(new searchListener());
		ser.setMnemonic('E');
		ser.setToolTipText("press to search a record");
        ser.setBounds(650,470,100,30);
		
		ext=new JButton("eXit");
		ext.addActionListener(new exitListener());
		ext.setMnemonic('X');
		ext.setToolTipText("press to exit");
        ext.setBounds(770,350,100,30);
        
		
		upd=new JButton("Update");
		upd.addActionListener(new updateListener());
		upd.setMnemonic('U');
		upd.setToolTipText("press to update the exitisting record");
        upd.setBounds(770,390,100,30);

        JButton	ld=new JButton("Load");
		ld.addActionListener(new loadListener());
		ld.setMnemonic('D');
		ld.setToolTipText("Load record");
        ld.setBounds(770,430,100,30);
        
        
        rec=new JButton("Recover");
		rec.addActionListener(new recoverListener());
		rec.setMnemonic('R');
		rec.setToolTipText("Recover Modified record");
        rec.setBounds(770,470,100,30);
        
        first=new JButton(">|");
		first.addActionListener(new firstListener());
		first.setMnemonic('F');
		first.setToolTipText(" First record");
        first.setBounds(650,520,50,30);
        
		last=new JButton("|<");
		last.addActionListener(new lastListener());
		last.setMnemonic('L');
		last.setToolTipText(" Last record");
        last.setBounds(800,520,50,30);
        
		nex=new JButton(">");
		nex.addActionListener(new nextListener());
		nex.setMnemonic('T');
		nex.setToolTipText(" Next record");
        nex.setBounds(700,520,50,30);
        
		prev=new JButton("<");
		prev.addActionListener(new previousListener());
		prev.setMnemonic('P');
		prev.setToolTipText(" Previous record");
        prev.setBounds(750,520,50,30);
        
        	JScrollPane jsp=new JScrollPane(table);
        	jsp.setBounds(5,350,630,200);
        	table.setEnabled(false);
        JLabel	foot=new JLabel("Devloped By:-        Ravi Kumar");
    	JLabel ln=new JLabel("============================================================================================================================================================");
    	ln.setBounds(0,560,900,20);
    	ln.setForeground(Color.red);
    	foot.setBounds(400,580,250,20);
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
             //cn.add(t1);
              cn.add(jcmb);
              cn.add(t2);
               cn.add(t3);
                cn.add(t4);
                 cn.add(t5);
                 cn.add(t6);
                 cn.add(t7);
                 cn.add(l8);
                 cn.add(l9);
                 cn.add(l10);
                 cn.add(l11);
                 cn.add(l12);
                 cn.add(l13);
                 cn.add(l14);
                 cn.add(t8);
                 cn.add(t9);
                 cn.add(t10);
                 cn.add(t11);
                 cn.add(cbpov);
                 cn.add(t13);
                 cn.add(t14);
                  cn.add(neew);
                   cn.add(del);
                    cn.add(ser);
                     cn.add(sav);
                      cn.add(ext);
                       cn.add(first);
                        cn.add(last);
                         cn.add(prev);
                          cn.add(nex);
                          cn.add(rec);
                           cn.add(upd);
                           cn.add(jsp);
                           cn.add(ln);
                           cn.add(foot);
                           cn.add(ld);
                           cn.add(l);
                           
                           
                           cn.setBackground(Color.PINK); 
                           aw.pack();
                           aw.setBounds(110,30,910,650);
                           aw.setResizable(false);
                            aw.setVisible(true);
                            connect();
                            load();
                           //loadtbl();
                            cbpov.addItem("ABOVE");
                            cbpov.addItem("BELOW");
                            
			
		
    }
    public void load()
    {
    	try
	       {
	       	
			//jcmb.addItem("DISTRICT_CODE");
	    	rs=stat.executeQuery("select village_code from village_Master order by village_code");
			while(rs.next())
			{
			
				jcmb.addItem(rs.getString(1));
				
			}
			rs.close();
		}
		catch(SQLException sqle)
		{
			JOptionPane.showMessageDialog(null,"error in fetching"+sqle);
		}
			
		}
    
    private class loadListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		loadtbl();
    	}
    }
      public void loadtbl()
         {
             int k=0;
             
            try
            {
              stat.executeUpdate("commit");
              rs=stat.executeQuery("select * from Individual_information_master order by Individual_info_no");
              while(rs.next())
              {
                str1=rs.getString(1);
                str2=rs.getString(2);
                str3=rs.getString(3);
                str4=rs.getString(4);
                str5=rs.getString(5);
                str6=rs.getString(6);
                str7=rs.getString(7);
                str8=rs.getString(8);
                str9=rs.getString(9);
                str10=rs.getString(10);
                str11=rs.getString(11);
                str12=rs.getString(12);
                str13=rs.getString(13);
                str14=rs.getString(14);
                data[k][0]=str1;
                data[k][1]=str2;
                data[k][2]=str3;
                data[k][3]=str4;
                data[k][4]=str5;
                data[k][5]=str6;
                data[k][6]=str7;
                data[k][7]=str8;
                data[k][8]=str9;
                data[k][9]=str10;
                data[k][10]=str11;
                data[k][11]=str12;
                data[k][12]=str13;
                data[k][13]=str14;
                k++;
              }
                data[k][0]=" ";
                data[k][1]=" ";
                data[k][2]=" ";
                data[k][3]=" ";
                data[k][4]=" ";
                data[k][5]="";
                data[k][6]="";
                data[k][7]="";
                data[k][8]="";
                data[k][9]="";
                data[k][10]="";
                data[k][11]="";
                data[k][12]="";
                data[k][13]="";
              
                JTable table=new JTable(data,colhead);
               
           
                JScrollPane jsp=new JScrollPane(table);
            //    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//                jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                jsp.setBounds(5,350,630,200);
              cn.add(jsp);
                table.setEnabled(false);
                 
           }
             catch(SQLException sqle)
             {
                  JOptionPane.showMessageDialog(null,"Record not transfer","Database Error",JOptionPane.ERROR_MESSAGE);                      
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
				rs=stat.executeQuery("select * from tmpindividual");
				rs.next();
				tinf=rs.getString(1);
				t2.setText(tinf);
				t2.setEditable(false);
				t3.setText("");
				jcmb.setSelectedIndex(0);
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				t9.setText("");
				t10.setText("");
				t11.setText("");
				//t12.setText("");
				cbpov.setSelectedIndex(0);
				t13.setText("");
				t14.setText("");
				t3.requestFocus();
			}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"could not Fetched"+sqle,"Database Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private class recoverListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new recover_individual();
		}
	}
	
	private class saveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			try
			{
					
					str1=jcmb.getSelectedItem().toString();
					str3=t3.getText();
					str4=t4.getText();
					str5=t5.getText();
					str6=t6.getText();
					str7=t7.getText();
					str8=t8.getText();
					str9=t9.getText();
					str10=t10.getText();
					str11=t11.getText();
					str12=cbpov.getSelectedItem().toString();
					str13=t13.getText();
					str14=t14.getText();
					if(str3.compareTo("")==0||str4.compareTo("")==0||str5.compareTo("")==0||str6.compareTo("")==0||str7.compareTo("")==0||str8.compareTo("")==0||str9.compareTo("")==0||str10.compareTo("")==0||str11.compareTo("")==0||str13.compareTo("")==0||str14.compareTo("")==0)
					JOptionPane.showMessageDialog(null,"Please Fill The Blank Field","ALERT MESSAGE",JOptionPane.WARNING_MESSAGE);
					else
					{
		stat.executeUpdate("insert into individual_information_master(Village_code,name,NO_OF_FAMILY_MEMBER,NO_OF_MALE,NO_OF_FEMALE,NO_OF_CHILD,OCCUPATION,ORGANISATION_NAME,POST_HELD,ANNUAL_INCOME,POVERTY_STATUS,DOB,REMARKS) values('"+str1+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"','"+str7+"','"+str8+"','"+str9+"','"+str10+"','"+str11+"','"+str12+"','"+str13+"','"+str14+"')");
					stat.executeUpdate("commit");
					JOptionPane.showMessageDialog(null,"Record has been successfully inserted","Information",JOptionPane.INFORMATION_MESSAGE);
				//	t1.setText("");
					t2.setText("");
					t3.setText("");
					jcmb.setSelectedIndex(0);
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
					t8.setText("");
					t9.setText("");
					t10.setText("");
					t11.setText("");
				cbpov.setSelectedIndex(0);
					t13.setText("");
					t14.setText("");
					t3.requestFocus();
					loadtbl();
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
				tinf=JOptionPane.showInputDialog("Enter individual info number to be deleted");
				if(tinf==null||tinf.compareTo("")==0)
				    {
				    	JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				    }
				else
				{
					int r;
					r=JOptionPane.showConfirmDialog(null,"Are u sure to delete the Record it can't recover later","ALERT ABOUT DELET",JOptionPane.WARNING_MESSAGE);
					if(r==JOptionPane.YES_OPTION)
					{
				stat.executeUpdate("delete from individual_information_master where individual_info_no='"+tinf+"'");
				stat.executeUpdate("commit");
				loadtbl();
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
		
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				int r;
				r=JOptionPane.showConfirmDialog(null,"Are You Sure To Exit From The Window","Window Closing",JOptionPane.WARNING_MESSAGE);
       			if(r==JOptionPane.YES_OPTION)
          		{aw.dispose();
          		conn.close();
          		}
        }
        catch(SQLException sqle)
        {
        	JOptionPane.showMessageDialog(null,"database error","Database Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    	
    }
	
	private class updateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		
			try
			{
					str1=jcmb.getSelectedItem().toString();		
					str2=t2.getText();
					str3=t3.getText();
					str4=t4.getText();
					str5=t5.getText();
					str6=t6.getText();
					str7=t7.getText();
					str8=t8.getText();
					str9=t9.getText();
					str10=t10.getText();
					str11=t11.getText();
					str12=cbpov.getSelectedItem().toString();
					str13=t13.getText();
					str14=t14.getText();
				
				if(str2.compareTo("")==0)
				    JOptionPane.showMessageDialog(null,"please enter a value");
				else
				{   
				stat.executeUpdate("update individual_information_master set village_code='"+str1+"', name='"+str3+"',NO_OF_FAMILY_MEMBER='"+str4+"',NO_OF_MALE='"+str5+"',NO_OF_FEMALE='"+str6+"',NO_OF_CHILD='"+str7+"',OCCUPATION='"+str8+"',ORGANISATION_NAME='"+str9+"',POST_HELD='"+str10+"',ANNUAL_INCOME='"+str11+"',POVERTY_STATUS='"+str12+"',DOB='"+str13+"',REMARKS='"+str14+"' where individual_info_no='"+str2+"'");
				stat.executeUpdate("commit");
				loadtbl();
				JOptionPane.showMessageDialog(null,"record updated successfully","Information",JOptionPane.INFORMATION_MESSAGE);
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
				    inf=JOptionPane.showInputDialog("Enter the individual info number to be search");
				    if(inf==null||inf.compareTo("")==0)
				    {
				    	JOptionPane.showMessageDialog(null,"please enter a value");
				    }
				    else
				    {
					rs=stat.executeQuery("select * from individual_information_master where individual_info_no='"+inf+"'");
					rs.next();
				//	t1.setText(rs.getString(1));
					t2.setText(rs.getString(2));
					t3.setText(rs.getString(3));
					jcmb.setSelectedItem(rs.getString(1));
					t4.setText(rs.getString(4));
					t5.setText(rs.getString(5));
					t6.setText(rs.getString(6));
					t7.setText(rs.getString(7));
					t8.setText(rs.getString(8));
					t9.setText(rs.getString(9));
					t10.setText(rs.getString(10));
					t11.setText(rs.getString(11));
					s1=String.valueOf(rs.getString(12)).trim();
					cbpov.setSelectedItem(s1);
					t13.setText(rs.getString(13));
					t14.setText(rs.getString(14));
					rs=stat.executeQuery("select to_char(dob,'DD-MON-YYYY') from individual_information_master where individual_info_no='"+inf+"'");
					rs.next();
					t13.setText(rs.getString(1));
					JOptionPane.showMessageDialog(null,"record found","Information",JOptionPane.INFORMATION_MESSAGE);
				}
				}
				catch(SQLException sqle)
				{
					JOptionPane.showMessageDialog(null,"not found","Record not Exist",JOptionPane.ERROR_MESSAGE);
				}			
			
		}
	}
	
	private class firstListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{rs=stat.executeQuery("select * from individual_information_master order by INDIVIDUAL_INFO_NO");
			rs.next();
			//t1.setText(rs.getString(1));
			t2.setText(rs.getString(2));
			t3.setText(rs.getString(3));
			jcmb.setSelectedItem(rs.getString(1));
			t4.setText(rs.getString(4));
			t5.setText(rs.getString(5));
			t6.setText(rs.getString(6));
			t7.setText(rs.getString(7));
			t8.setText(rs.getString(8));
			t9.setText(rs.getString(9));
			t10.setText(rs.getString(10));
			t11.setText(rs.getString(11));
			String s1=String.valueOf(rs.getString(12)).trim();
			cbpov.setSelectedItem(s1);
			t13.setText(rs.getString(13));
			t14.setText(rs.getString(14));
			rs=stat.executeQuery("select to_char(dob,'DD-MON-YYYY') from individual_information_master where individual_info_no='"+t2.getText()+"'");
			rs.next();
			t13.setText(rs.getString(1));
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
                   rs=stat.executeQuery("select * from individual_information_master order by INDIVIDUAL_INFO_NO");
                   while(rs.next())
                        c=c+1;

                   rs=stat.executeQuery("select * from individual_information_master order by INDIVIDUAL_INFO_NO");
                   while(c!=0)
                               {
                               rs.next();
                               c=c-1;
                               }
                                   //t1.setText(rs.getString(1));
                                   t2.setText(rs.getString(2));
                                  t3.setText(rs.getString(3));
                                  	jcmb.setSelectedItem(rs.getString(1));
                                   t4.setText(rs.getString(5));
                                   t5.setText(rs.getString(5));
                                    t6.setText(rs.getString(6));
									t7.setText(rs.getString(7));
									t8.setText(rs.getString(8));
									t9.setText(rs.getString(9));
									t10.setText(rs.getString(10));
									t11.setText(rs.getString(11));
									String s1=String.valueOf(rs.getString(12)).trim();
									cbpov.setSelectedItem(s1);
									t13.setText(rs.getString(13));
									t14.setText(rs.getString(14));
									rs=stat.executeQuery("select to_char(dob,'DD-MON-YYYY') from individual_information_master where individual_info_no='"+t2.getText()+"'");
									rs.next();
									t13.setText(rs.getString(1));
                                  
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
            tinf=t2.getText();
            if(t2.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Click on previous button");
            else
                {
                 rs=stat.executeQuery("select * from individual_information_master order by INDIVIDUAL_INFO_NO");
                while(rs.next())
                        {
                        inf=rs.getString(2);
                        if(tinf.compareTo(inf)==0)
                        break;
                        }
                        rs.next();
                        //t1.setText(rs.getString(1));
                        t2.setText(rs.getString(2));
                        t3.setText(rs.getString(3));
                        jcmb.setSelectedItem(rs.getString(1));
                        t4.setText(rs.getString(4));
                        t5.setText(rs.getString(5));
                        t6.setText(rs.getString(6));
						t7.setText(rs.getString(7));
						t8.setText(rs.getString(8));
						t9.setText(rs.getString(9));
						t10.setText(rs.getString(10));
						t11.setText(rs.getString(11));
						String s1=String.valueOf(rs.getString(12)).trim();
						cbpov.setSelectedItem(s1);
						t13.setText(rs.getString(13));
						t14.setText(rs.getString(14));
						rs=stat.executeQuery("select to_char(dob,'DD-MON-YYYY') from individual_information_master where individual_info_no='"+t2.getText()+"'");
						rs.next();
						t13.setText(rs.getString(1));
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
			tinf=t2.getText();
                    try
                        {
                        rs=stat.executeQuery("select * from individual_information_master order by INDIVIDUAL_INFO_NO");
                        c=0;
                        while(rs.next())
                                {
                               inf=rs.getString(2);
                                if(tinf.compareTo(inf)==0)
                                        break;
                                        c++;
                                }
                        rs=stat.executeQuery("select * from individual_information_master order by INDIVIDUAL_INFO_NO");
                        k=0;
                        while(rs.next())
                                {
                                k++;
                                if(k==c)
                                break;
                                }
                           //t1.setText(rs.getString(1));
                           t2.setText(rs.getString(2));
                           t3.setText(rs.getString(3));
                         	jcmb.setSelectedItem(rs.getString(1));
                           t4.setText(rs.getString(4));
                           t5.setText(rs.getString(5));
                           t6.setText(rs.getString(6));
							t7.setText(rs.getString(7));
							t8.setText(rs.getString(8));
							t9.setText(rs.getString(9));
							t10.setText(rs.getString(10));
							t11.setText(rs.getString(11));
							String s1=String.valueOf(rs.getString(12)).trim();
							cbpov.setSelectedItem(s1);
							t13.setText(rs.getString(13));
							t14.setText(rs.getString(14));
							rs=stat.executeQuery("select to_char(dob,'DD-MON-YYYY') from individual_information_master where individual_info_no='"+t2.getText()+"'");
							rs.next();
							t13.setText(rs.getString(1));
                        }
                   catch(SQLException sqle)
                        {
                        JOptionPane.showMessageDialog(null,"This is first Record","Information",JOptionPane.INFORMATION_MESSAGE);
                        }
		
		}
	}
    
    public static void main(String[] args)
    {
    	Individual_Information ii=new Individual_Information();
    }
}
	
