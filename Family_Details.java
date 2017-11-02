
import java.lang.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.JTable.*;

public class Family_Details extends JFrame
{
	private JLabel title,pic,foot,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	private JButton sav,del,upd,neew,ser,ext,lod,rec;
	private JPanel ptit,ppic,pcom;
	Connection conn;
	Statement stat;
	ResultSet rs;
	private JComboBox jcmb,cbmrd;
	private String fnm,tfnm,str1,str2,str3,str4,str5,str6,str7,str8,str9,str10;
	String colhead[]={"INDIVIDUAL_INFO_NO","FAMILY_NUMBER","NAME","SEX","DOB","AGE","OCCUPATION","ANNUAL_INCOME","MARITAL_STATUS","REMARKS"};
	Object data[][]=new Object[30][10];
	JTable table=new JTable(data,colhead);
	Cursor cr;
	JRadioButton ml,fm;
	ButtonGroup gp;
	String bl;
	
	public Family_Details()
	{
		super("Computerized Databank System of Bihar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		Container cn=getContentPane();
		cn.setBackground(Color.BLUE);
		Dimension wind;
		
		BevelBorder bvl=new BevelBorder(BevelBorder.RAISED);
		EtchedBorder etch=new EtchedBorder(EtchedBorder.RAISED);
		cr=new Cursor(Cursor.HAND_CURSOR);
		ptit=new JPanel();
		ppic=new JPanel();
		pcom=new JPanel();

		title=new JLabel("Entry Form of Family_Information");
		title.setFont(new Font("Courier",Font.BOLD+Font.ITALIC,30));
		title.setForeground(Color.WHITE);
		title.setBorder(bvl);
		ptit.add(title);
		ptit.setBounds(0,0,850,40);
		ptit.setBackground(Color.red);
		
		Icon icn=new ImageIcon("540274851.jpg");
		pic=new JLabel(icn);
		pic.setBounds(0,0,850,580);
	
		pcom.setLayout(null);
    	pcom.setBackground(new Color(224,232,255));
    	pcom.setBounds(0,40,850,580);
    	
    	
    	l1=new JLabel("Enter Individual_Info_No");
		l1.setBounds(10,30,150,30);
		l1.setForeground(Color.blue);
		l1.setBorder(bvl);
		
		l2=new JLabel("Enter Family_Number");
		l2.setBounds(10,70,150,30);
		l2.setForeground(Color.blue);
		l2.setBorder(bvl);
		
		l3=new JLabel("Enter HOF Name");
		l3.setBounds(10,110,150,30);
		l3.setForeground(Color.blue);
		l3.setBorder(bvl);
		
		l4=new JLabel("Select Sex");
		l4.setBounds(10,150,150,30);
		l4.setForeground(Color.blue);
		l4.setBorder(bvl);
		
		l5=new JLabel("Enter Date_of_Birth");
		l5.setBounds(10,190,150,30);
		l5.setForeground(Color.blue);
		l5.setBorder(bvl);
		
		l6=new JLabel("AGE");
		l6.setBounds(360,30,150,30);
		l6.setForeground(Color.blue);
		l6.setBorder(bvl);
		
		l7=new JLabel("Occupation");
		l7.setBounds(360,70,150,30);
		l7.setForeground(Color.blue);
		l7.setBorder(bvl);
		
		l8=new JLabel("Annual_Income");
		l8.setBounds(360,110,150,30);
		l8.setForeground(Color.blue);
		l8.setBorder(bvl);
		
		l9=new JLabel("Marital_Status");
		l9.setBounds(360,150,150,30);
		l9.setForeground(Color.blue);
		l9.setBorder(bvl);
		
		l10=new JLabel("Remarks");
		l10.setBounds(360,190,150,30);
		l10.setForeground(Color.blue);
		l10.setBorder(bvl);
		
		jcmb=new JComboBox();
		jcmb.setBounds(190,30,150,30);
	//	t1=new JTextField(20);
	//	t1.setBounds(190,30,150,30);
	//	t1.addActionListener(new enterListener());
		
		t2=new JTextField(20);
		t2.setBounds(190,70,150,30);
		t2.setEditable(false);
		//t2.addActionListener(new enterListener());
		 
		t3=new JTextField(20);
		t3.setBounds(190,110,150,30);
	    t3.addActionListener(new enterListener());
	        
	/*	t4=new JTextField(20);
		t4.setBounds(190,150,150,30);
		t4.addActionListener(new enterListener());*/
		ml=new JRadioButton("MALE");
		fm=new JRadioButton("FEMALE");
		
		gp=new ButtonGroup();
		ml.setBounds(190,150,150,15);
		ml.addActionListener(new buttonListener());
		fm.setBounds(190,170,150,15);
		fm.addActionListener(new buttonListener());
		 
		t5=new JTextField(20);
		t5.setBounds(190,190,150,30);
		t5.addActionListener(new enterListener());
		 
		t6=new JTextField(20);
		t6.setBounds(530,30,150,30);
		t6.addActionListener(new enterListener());
		
		t7=new JTextField(20);
		t7.setBounds(530,70,150,30);
		t7.addActionListener(new enterListener());
		
		t8=new JTextField(20);
		t8.setBounds(530,110,150,30);
		t8.addActionListener(new enterListener());
		
		/*t9=new JTextField(20);
		t9.setBounds(530,150,150,30);
		t9.addActionListener(new enterListener());*/
		cbmrd=new JComboBox();
		cbmrd.setBounds(530,150,150,30);
		
		t10=new JTextField(50);
		t10.setBounds(530,190,150,30);
		t10.addActionListener(new enterListener());
		 
		neew=new JButton("New");
		neew.addActionListener(new neewListener());
		neew.setMnemonic('N');
		neew.setToolTipText("press to enter new record");
        neew.setBounds(700,30,80,25);
        neew.setCursor(cr);
		
		sav=new JButton("Save");
		sav.addActionListener(new saveListener());
		sav.setMnemonic('S');
		sav.setToolTipText("press  to save record");	
        sav.setBounds(700,65,80,25);
		sav.setCursor(cr);
		
		del=new JButton("Delete");
		del.addActionListener(new deletListener());
		del.setMnemonic('D');
		del.setToolTipText("press to Delete record");
        del.setBounds(700,100,80,25);
		del.setCursor(cr);
		
		ext=new JButton("eXit");
		ext.addActionListener(new exitListener());
		ext.setMnemonic('X');
		ext.setToolTipText("press to exit");
        ext.setBounds(700,135,80,25);
        ext.setCursor(cr);
        
		
		upd=new JButton("Update");
		upd.addActionListener(new updateListener());
		upd.setMnemonic('U');
		upd.setToolTipText("press to update the exitisting record");
        upd.setBounds(700,170,80,25);
		upd.setCursor(cr);
		
		ser=new JButton("sEarch");
		ser.addActionListener(new searchListener());
		ser.setMnemonic('E');
		ser.setToolTipText("press to search a record");
        ser.setBounds(700,200,80,25);
		ser.setCursor(cr);
		
		rec=new JButton("Recover");
		rec.addActionListener(new recoverListener());
		rec.setMnemonic('R');
		rec.setToolTipText("Restore Modified record");
        rec.setBounds(700,230,100,25);
		rec.setCursor(cr);
		
		lod=new JButton("Load");
		lod.addActionListener(new LoadListener());
		lod.setMnemonic('L');
		lod.setToolTipText("load data from database");
		lod.setBounds(20,230,80,30);
		lod.setCursor(cr);
		lod.setForeground(Color.blue);
		
    	table.setForeground(Color.blue);
    	table.setEnabled(false);

    	JScrollPane jsp=new JScrollPane(table);
   	//	jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  	//jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    	jsp.setBounds(0,270,830,200);
    	
    	foot=new JLabel("Devloped By:-        Ravi Kumar");
    	JLabel ln=new JLabel("=================================================================================================================================================");
    	ln.setBounds(0,470,850,20);
    	ln.setForeground(Color.GRAY);
    	foot.setBounds(400,480,250,20);
    	foot.setForeground(Color.CYAN);
		foot.setFont(new Font("legand",Font.BOLD,15));
		pcom.add(l1);
		pcom.add(l2);
		pcom.add(l3);
		pcom.add(l4);
		pcom.add(l5);
		pcom.add(l6);
		pcom.add(l7);
		pcom.add(l8);
		pcom.add(l9);
		pcom.add(l10);
	//	pcom.add(t1);
		pcom.add(jcmb);
		pcom.add(t2);
		pcom.add(t3);
		//pcom.add(t4);
		pcom.add(ml);
		pcom.add(fm);
		pcom.add(t5);
		pcom.add(t6);
		pcom.add(t7);
		pcom.add(t8);
		pcom.add(cbmrd);
		pcom.add(t10);
		pcom.add(neew);
		pcom.add(sav);
		pcom.add(del);
		pcom.add(upd);
		pcom.add(ser);
		pcom.add(ext);
		pcom.add(rec);
		pcom.add(jsp);
		pcom.add(lod);
		pcom.add(ln);
		pcom.add(foot);
		pcom.add(pic);
		gp.add(ml);
		gp.add(fm);
		pcom.setBorder(BorderFactory.createTitledBorder("Enter the Family Information"));
		
		cn.add(ptit);
		cn.add(ppic);
		cn.add(pcom);
		
		wind=Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setBounds((wind.width-850)/4,(wind.height-580)/4,850,580);
		setResizable(false);
		setVisible(true);
		connect();
		//load();
		loadcmb();
		cbmrd.addItem("MARRIED");
		cbmrd.addItem("SINGLE");
		cbmrd.addItem("WIDOW");
	}
	
	private class enterListener implements ActionListener
        {
                public void actionPerformed(ActionEvent e)
                {
                  if(e.getSource()==t3)
                    t5.requestFocus();
                  if(e.getSource()==t5)
                    t6.requestFocus();
                  if(e.getSource()==t6)
                  	t7.requestFocus();
                  if(e.getSource()==t7)
                  t8.requestFocus();
                  if(e.getSource()==t8)
                  t10.requestFocus();
                  if(e.getSource()==t10)
                    sav.requestFocus();
                }
         }
         
         	private class recoverListener implements ActionListener
        {
                public void actionPerformed(ActionEvent e)
                {
                	new recover_family();
                }
         }
         
         private class buttonListener implements ActionListener
         {
         	public void actionPerformed(ActionEvent ae)
         	{
         		bl=ae.getActionCommand();
         	}
         }
         
        public void load()
         {
             int k=0;
             
            try
            {
              stat.executeUpdate("commit");
              rs=stat.executeQuery("select * from Family_info order by family_number");
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
                k++;
              }
                data[k][0]=" ";
                data[k][1]=" ";
                data[k][2]=" ";
                data[k][3]=" ";
                data[k][4]=" ";
                data[k][5]=" ";
                data[k][6]="";
                data[k][7]="";
                data[k][8]="";
                data[k][9]="";
                
                JTable table=new JTable(data,colhead);
                table.setForeground(Color.blue);
                JScrollPane jsp=new JScrollPane(table);
            //    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//                jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
               	jsp.setBounds(0,270,830,200);
               pcom.add(jsp);
                table.setEnabled(false);
                 
           }
             catch(SQLException sqle)
             {
                  JOptionPane.showMessageDialog(null,"Record not transfer","Database Error",JOptionPane.ERROR_MESSAGE);                      
             }
            
         }
         
            public void loadcmb()
    {
    	try
	       {
	       	
			//jcmb.addItem("DISTRICT_CODE");
	    	rs=stat.executeQuery("select individual_info_no from individual_information_master order by individual_info_no");
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
	
	protected void processWindowEvent(WindowEvent we)
   {  int r;
     if(we.getID() == we.WINDOW_CLOSING)
     {
       r=JOptionPane.showConfirmDialog(null,"Are You Sure To Exit From The Window","Window Closing",JOptionPane.WARNING_MESSAGE);
       if(r==JOptionPane.YES_OPTION)
         dispose();
      }
   }
   
   	private class neewListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				rs=stat.executeQuery("select * from lookupFamily");
				rs.next();
				tfnm=rs.getString(1);
				jcmb.setSelectedIndex(0);
				t2.setText(tfnm);
				t2.setEditable(false);
				t3.setText("");
			//	t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				cbmrd.setSelectedIndex(0);
				t10.setText("");
				t3.requestFocus();
			}
			catch(SQLException sqle)
			{
				 JOptionPane.showMessageDialog(null,"could not Fetched"+sqle,"Database Error",JOptionPane.ERROR_MESSAGE);
			}
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
					if(bl==null||bl.equals(""))
					bl="Male";
					str4=bl;
					str5=t5.getText();
					str6=t6.getText();
					str7=t7.getText();
					str8=t8.getText();
					str9=cbmrd.getSelectedItem().toString();
					str10=t10.getText();
					if(str3.compareTo("")==0||str4.compareTo("")==0||str5.compareTo("")==0||str6.compareTo("")==0||str7.compareTo("")==0||str8.compareTo("")==0||str10.compareTo("")==0)
					JOptionPane.showMessageDialog(null,"Please Fill The Blank Field","ALERT MESSAGE",JOptionPane.WARNING_MESSAGE);
					else
					{
		stat.executeUpdate("insert into family_info(INDIVIDUAL_INFO_NO,NAME,SEX,DOB,AGE,OCCUPATION,ANNUAL_INCOME,MARITAL_STATUS,REMARKS) values('"+str1+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"','"+str7+"','"+str8+"','"+str9+"','"+str10+"')");
					stat.executeUpdate("commit");
					JOptionPane.showMessageDialog(null,"Record has been successfully inserted","Information",JOptionPane.INFORMATION_MESSAGE);
					jcmb.setSelectedIndex(0);
					t2.setText("");
					t3.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
					t8.setText(" ");
					cbmrd.setSelectedIndex(0);
					t10.setText(" ");
					t3.requestFocus();
					load();
				}
				
			}
		   
		   catch(SQLException sqle)
		   {
		   	  JOptionPane.showMessageDialog(null,"could not Inserted "+sqle,"Database Error",JOptionPane.ERROR_MESSAGE);
		  }
		
		}
	}
					
			
		
	private class deletListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
				try
			{
				fnm=JOptionPane.showInputDialog("Enter family number to be deleted");
				if(fnm==null||fnm.compareTo("")==0)
				    {
				    	JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				    }
				else
				{
					int r;
					r=JOptionPane.showConfirmDialog(null,"Are u sure to delete the Record it can't recover later","ALERT ABOUT DELET",JOptionPane.WARNING_MESSAGE);
					if(r==JOptionPane.YES_OPTION)
					{	
				stat.executeUpdate("delete from family_info where family_number='"+fnm+"'");
				stat.executeUpdate("commit");
				load();
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
		{int r;
		    r=JOptionPane.showConfirmDialog(null,"Are You Sure To Exit From The Window","Window Closing",JOptionPane.WARNING_MESSAGE);
       		if(r==JOptionPane.YES_OPTION)
          	dispose();
        }
    	
    }
	
	private class updateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		
			try
			{
			//	search();
				
				tfnm=t2.getText();
				str3=t3.getText();
				str4=bl;
				str5=t5.getText();
				str6=t6.getText();
				str7=t7.getText();
				str8=t8.getText();
				str9=cbmrd.getSelectedItem().toString();
				str10=t10.getText();
				if(tfnm.compareTo("")==0)
				    JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				else
				{   
	stat.executeUpdate("update family_info set INDIVIDUAL_INFO_NO='"+String.valueOf(jcmb.getSelectedItem())+"', NAME='"+str3.trim()+"',SEX='"+str4+"',DOB='"+str5+"',AGE='"+str6+"',OCCUPATION='"+str7+"',ANNUAL_INCOME='"+str8+"',MARITAL_STATUS='"+str9+"',REMARKS='"+str10+"' where family_number='"+tfnm+"'");
				stat.executeUpdate("commit");
				load();
				JOptionPane.showMessageDialog(null,"record updated successfully","Information",JOptionPane.INFORMATION_MESSAGE);
			}
		
		}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"could not update"+sqle);
			}
			
		}
	}
	
	private class searchListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			
				search();
			
			
		
			
		}
	}
	
	private class LoadListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			load();
		}
	}
	
	public void search()
	{
			String s1;	
			try
			{
				    fnm=JOptionPane.showInputDialog("Enter the family number to be search");
				    if(fnm==null||fnm.compareTo("")==0)
				    {
				    	JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				    }
				    else
				    {
					rs=stat.executeQuery("select * from family_info where family_number='"+fnm+"'");
					rs.next();
					jcmb.setSelectedItem(rs.getString(1));
					t2.setText(rs.getString(2));
					t3.setText(rs.getString(3));
					s1=String.valueOf(rs.getString(4)).trim();
					if(s1.equalsIgnoreCase("male"))
						{
							ml.setSelected(true);
					}
						else
						{
							if(s1.equalsIgnoreCase("female"))
							fm.setSelected(true);
						}
						
					t5.setText(rs.getString(5));
					t6.setText(rs.getString(6));
					t7.setText(rs.getString(7));
					t8.setText(rs.getString(8));
					//t9.setText(rs.getString(9));
					s1=rs.getString(9);
					cbmrd.setSelectedItem(String.valueOf(s1).trim());
					t10.setText(rs.getString(10));
						rs=stat.executeQuery("select to_char(dob,'DD-MON-YYYY') from family_info where family_number='"+fnm+"'");
					rs.next();
					t5.setText(rs.getString(1));
					JOptionPane.showMessageDialog(null,"record found","Information",JOptionPane.INFORMATION_MESSAGE);
					
				}
				}
				catch(SQLException sqle)
				{
					JOptionPane.showMessageDialog(null,"Record not found","Record Not Exist",JOptionPane.ERROR_MESSAGE);
				}			
	}
			
	
	public static void main(String[] args)
	{
		Family_Details fd=new Family_Details();
	}
}
		