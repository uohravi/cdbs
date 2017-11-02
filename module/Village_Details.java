import java.lang.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.JTable.*;

public class Village_Details extends JFrame
{
	private JLabel title,pic,foot,l1,l2,l3,l4,l5,l6,l7,l8;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	private JButton sav,del,upd,neew,ser,ext,lod,rec;
	private JPanel ptit,ppic,pcom;
	Connection conn;
	Statement stat;
	ResultSet rs;
	private String tdcd,tscd,tbcd,tpcd,tvcd,tvnm,tdt,tmknm,dcd,scd,bcd,pcd,vcd,vnm,dt,mknm;
	String colhead[]={"District_code","Subdivision_code","Block_code","Panchayat_code","Village_code","Village_name","ESTD","Mukhia_name"};
	Object data[][]=new Object[30][8];
	JTable table=new JTable(data,colhead);
	Cursor cr;
	String code,cd,nm;
	char ch;
	private JComboBox cbdis,cbsub,cbblock,cbpanchayat;
	
	public Village_Details()
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
		
		title=new JLabel("Entry Form of village Master");
		title.setFont(new Font("Courier",Font.BOLD+Font.ITALIC,35));
		title.setForeground(Color.WHITE);
		ptit.add(title);
		ptit.setBounds(0,0,900,50);
		ptit.setBackground(Color.red);
		
		Icon icn=new ImageIcon("village23.jpg");
		pic=new JLabel(icn);
		ppic.add(pic);
		ppic.setBounds(0,40,230,630);
		ppic.setBackground(new Color(221,183,136));
		
		pcom.setLayout(null);
    	pcom.setBackground(new Color(224,232,255));
    	pcom.setBounds(230,50,850,650);
    	
    	l1=new JLabel("Enter District_Code");
		l1.setBounds(30,30,180,30);
		l1.setForeground(Color.blue);
		l1.setBorder(bvl);
		
		l2=new JLabel("Enter Subdivision_code");
		l2.setBounds(30,70,180,30);
		l2.setForeground(Color.blue);
		l2.setBorder(bvl);
		
		l3=new JLabel("Enter Block_Code");
		l3.setBounds(30,110,180,30);
		l3.setForeground(Color.blue);
		l3.setBorder(bvl);
		
		l4=new JLabel("Enter Panchayat_code");
		l4.setBounds(30,150,180,30);
		l4.setForeground(Color.blue);
		l4.setBorder(bvl);
		
		l5=new JLabel("Enter Village_code");
		l5.setBounds(30,190,180,30);
		l5.setForeground(Color.blue);
		l5.setBorder(bvl);
		
		l6=new JLabel("Village_name");
		l6.setBounds(30,230,180,30);
		l6.setForeground(Color.blue);
		l6.setBorder(bvl);
		
		l7=new JLabel("ESTD");
		l7.setBounds(30,270,180,30);
		l7.setForeground(Color.blue);
		l7.setBorder(bvl);
		
		l8=new JLabel("Enter Mukhia_name");
		l8.setBounds(30,310,180,30);
		l8.setForeground(Color.blue);
		l8.setBorder(bvl);
		
		
		cbdis=new JComboBox();
		cbsub=new JComboBox();
		cbblock=new JComboBox();
		cbpanchayat=new JComboBox();
		cbdis.setBounds(250,30,200,30);
		cbsub.setBounds(250,70,200,30);
		cbblock.setBounds(250,110,200,30);
		cbpanchayat.setBounds(250,150,200,30);	
	/*	t1=new JTextField(20);
		t1.setBounds(250,30,200,30);
		t1.setBorder(etch);
		t1.addActionListener(new enterListener());
		
		t2=new JTextField(20);
		t2.setBounds(250,70,200,30);
		t2.setBorder(etch);
		t2.addActionListener(new enterListener());
		 
		t3=new JTextField(20);
		t3.setBounds(250,110,200,30);
		t3.setBorder(etch);
	    t3.addActionListener(new enterListener());
	        
		t4=new JTextField(20);
		t4.setBounds(250,150,200,30);
		t4.setBorder(etch);
		t4.addActionListener(new enterListener());*/
		 
		t5=new JTextField(20);
		t5.setBounds(250,190,200,30);
		t5.setBorder(etch);
		t5.addActionListener(new enterListener());
		 
		t6=new JTextField(20);
		t6.setBounds(250,230,200,30);
		t6.setBorder(etch);
		t6.addActionListener(new enterListener());
		
		t7=new JTextField(20);
		t7.setBounds(250,270,200,30);
		t7.setBorder(etch);
		t7.addActionListener(new enterListener());
		
		t8=new JTextField(20);
		t8.setBounds(250,310,200,30);
		t8.setBorder(etch);
		t8.addActionListener(new enterListener());
		 
		neew=new JButton("New");
		neew.addActionListener(new neewListener());
		neew.setMnemonic('N');
		neew.setToolTipText("press to enter new record");
        neew.setBounds(480,30,80,25);
        neew.setCursor(cr);
		
		sav=new JButton("Save");
		sav.addActionListener(new saveListener());
		sav.setMnemonic('S');
		sav.setToolTipText("press  to save record");	
        sav.setBounds(480,70,80,25);
		sav.setCursor(cr);
		
		del=new JButton("Delete");
		del.addActionListener(new deletListener());
		del.setMnemonic('D');
		del.setToolTipText("press to Delete record");
        del.setBounds(480,110,80,25);
		del.setCursor(cr);
		
		ext=new JButton("eXit");
		ext.addActionListener(new exitListener());
		ext.setMnemonic('X');
		ext.setToolTipText("press to exit");
        ext.setBounds(480,150,80,25);
        ext.setCursor(cr);
        
		
		upd=new JButton("Update");
		upd.addActionListener(new updateListener());
		upd.setMnemonic('U');
		upd.setToolTipText("press to update the exitisting record");
        upd.setBounds(480,190,80,25);
		upd.setCursor(cr);
		
		ser=new JButton("sEarch");
		ser.addActionListener(new searchListener());
		ser.setMnemonic('E');
		ser.setToolTipText("press to search a record");
        ser.setBounds(480,230,80,25);
		ser.setCursor(cr);
		
		rec=new JButton("Recover");
		rec.addActionListener(new recoverListener());
		rec.setMnemonic('R');
		rec.setToolTipText("Restore the modified record");
        rec.setBounds(480,270,100,25);
		rec.setCursor(cr);
		
		lod=new JButton("Load");
		lod.addActionListener(new LoadListener());
		lod.setMnemonic('L');
		lod.setToolTipText("load data from database");
		lod.setBounds(30,350,80,25);
		lod.setCursor(cr);
		lod.setForeground(Color.blue);
		
	//	table.setFont(new Font("Times New Roman",Font.BOLD,16));
    	table.setForeground(Color.blue);

    	JScrollPane jsp=new JScrollPane(table);
   	//	jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  	//jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    	jsp.setBounds(10,380,650,100);
    	table.setEnabled(false);
    	
    	foot=new JLabel("Devloped By:-        Ravi Kumar");
    	JLabel ln=new JLabel("===================================================================================================");
    	ln.setBounds(10,500,900,20);
    	ln.setForeground(Color.GRAY);
    	foot.setBounds(400,520,250,20);
    	foot.setForeground(Color.CYAN);
		foot.setFont(new Font("legand",Font.BOLD,15));
		pcom.add(l1);
		pcom.add(l2);
		pcom.add(l3);
		pcom.add(l4);
		pcom.add(l5);
		pcom.add(l6);
		pcom.add(l7);
		pcom.add(cbdis);
		pcom.add(cbsub);
		pcom.add(cbblock);
		pcom.add(cbpanchayat);
		/*pcom.add(t1);
		pcom.add(t2);
		pcom.add(t3);
		pcom.add(t4);*/
		pcom.add(t5);
		pcom.add(t6);
		pcom.add(t7);
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
		pcom.add(l8);
		pcom.add(t8);
		pcom.setBorder(BorderFactory.createTitledBorder("Enter the Village Information"));
		
		cn.add(ptit);
		cn.add(ppic);
		cn.add(pcom);
		t5.setEditable(false);
		wind=Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setBounds((wind.width-900)/4,(wind.height-650)/4,900,650);
		setResizable(false);
		setVisible(true);
		connect();
		//load();
		adddistrict();
	}
	
	private class enterListener implements ActionListener
        {
                public void actionPerformed(ActionEvent e)
                {
                  if(e.getSource()==t6)
                  	t7.requestFocus();
                  if(e.getSource()==t7)
                  t8.requestFocus();
                  if(e.getSource()==t8)
                    sav.requestFocus();
                }
         }
         
         public void adddistrict()
         {
         		try
			{
		
 	
	 rs=stat.executeQuery("select District_code,District_name from District_master order by district_code");
	 
	 cbdis.addItem("---Code---   |   ---Name---");
	 while(rs.next())
	   {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbdis.addItem(cd+"           |    "+nm);

           }	 
	rs.close();

	cbsub.setEnabled(false);
	cbblock.setEnabled(false);
	cbpanchayat.setEnabled(false);
	
	cbdis.addActionListener(new cbListener());
      

        }
	
       catch(SQLException e)
	{
		JOptionPane.showMessageDialog(null,"error:-not found"+e);
	}        
   }


private class cbListener implements ActionListener
 {
  public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource()==cbdis)
      {
	String str=String.valueOf(cbdis.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cbsub.removeActionListener(this);
	cbblock.removeActionListener(this);
	cbpanchayat.removeActionListener(this);
	
	
	
	cbsub.setEnabled(true);
	cbblock.setEnabled(false);
	cbpanchayat.setEnabled(false);
	
	cbsub.removeAllItems();
	cbblock.removeAllItems();
	cbpanchayat.removeAllItems();
	
	try
	 {
            rs=stat.executeQuery("select subdiv_code, subdiv_name from subdivision_master where district_code='"+String.valueOf(code).trim()+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbsub.addItem(cd+"           |    "+nm);

               }
	    rs.close();
	    cbsub.addActionListener(this);
	  }
	catch(Exception e){}
       }
 

      if(ae.getSource()==cbsub)
      {
	String str=String.valueOf(cbsub.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cbblock.removeActionListener(this);
	cbpanchayat.removeActionListener(this);

	cbblock.setEnabled(true);
	cbpanchayat.setEnabled(false);

	
	cbblock.removeAllItems();
	cbpanchayat.removeAllItems();
	
	try
	 {
            rs=stat.executeQuery("select block_code,block_name from block_master where subdiv_code='"+String.valueOf(code).trim()+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbblock.addItem(cd+"           |    "+nm);

               }
	    rs.close();
		cbblock.addActionListener(this);
		
	  }
	catch(Exception e){}
       }
       
       if(ae.getSource()==cbblock)
      {
	String str=String.valueOf(cbblock.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cbpanchayat.removeActionListener(this);

	cbpanchayat.setEnabled(true);

	
	cbpanchayat.removeAllItems();
	
	try
	 {
            rs=stat.executeQuery("select panchayat_code,panchayat_name from panchayat_master where block_code='"+String.valueOf(code).trim()+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbpanchayat.addItem(cd+"           |    "+nm);

               }
	    rs.close();
		t5.requestFocus();
		
	  }
	catch(Exception e){}
       }
    
      	 }
    }
         
         
         public void load()
         {
             int k=0;
             
            try
            {
              stat.executeUpdate("commit");
              rs=stat.executeQuery("select District_code,Subdiv_code,Block_code,Panchayat_code,Village_code,Village_name,TO_CHAR(ESTD,'DD-MON-YYYY'),Mukhia_name from Village_master order by village_code");
              while(rs.next())
              {
                dcd=rs.getString(1);
                scd=rs.getString(2);
                bcd=rs.getString(3);
                pcd=rs.getString(4);
                vcd=rs.getString(5);
                vnm=rs.getString(6);
                dt=rs.getString(7);
                mknm=rs.getString(8);
                data[k][0]=dcd;
                data[k][1]=scd;
                data[k][2]=bcd;
                data[k][3]=pcd;
                data[k][4]=vcd;
                data[k][5]=vnm;
                data[k][6]=dt;
                data[k][7]=mknm;
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

                JTable table=new JTable(data,colhead);
                table.setForeground(Color.blue);
                JScrollPane jsp=new JScrollPane(table);
            //    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//                jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                jsp.setBounds(10,380,650,100);
               pcom.add(jsp);
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
				rs=stat.executeQuery("select * from lookupvill");
				rs.next();
				vcd=rs.getString(1);
				t5.setText(vcd);
				t5.setEditable(false);
				t6.setText("");
				t7.setText("");
				t8.setText("");
				cbsub.setEnabled(false);
				cbblock.setEnabled(false);
				cbpanchayat.setEnabled(false);
				t6.requestFocus();
			}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"could not Fetched "+sqle,"Database Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
		private class recoverListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new recover_village();
		}
	}
	
	private class saveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
				String str;
				try
				{
						 str=String.valueOf(cbdis.getSelectedItem());
						code="";
						for(int i=0;i<str.length();i++)
						 {
						   ch=str.charAt(i);
						   if(String.valueOf(ch).equals(" "))
							break;
							code=code+ch;
						 }
						
						tdcd=code;
						
						 str=String.valueOf(cbsub.getSelectedItem());
						code="";
						for(int i=0;i<str.length();i++)
						 {
						   ch=str.charAt(i);
						   if(String.valueOf(ch).equals(" "))
							break;
							code=code+ch;
						 }
						tscd=code;
						
						str=String.valueOf(cbblock.getSelectedItem());
						code="";
						for(int i=0;i<str.length();i++)
						 {
						   ch=str.charAt(i);
						   if(String.valueOf(ch).equals(" "))
							break;
							code=code+ch;
						 }
						tbcd=code;
						
						str=String.valueOf(cbpanchayat.getSelectedItem());
						code="";
						for(int i=0;i<str.length();i++)
						 {
						   ch=str.charAt(i);
						   if(String.valueOf(ch).equals(" "))
							break;
							code=code+ch;
						 }
						tpcd=code;
						
						tvnm=t6.getText();
						tdt=t7.getText();
						tmknm=t8.getText();
						if(tvnm.compareTo("")==0||tdt.compareTo("")==0||tmknm.compareTo("")==0)
						JOptionPane.showMessageDialog(null,"Please Fill The Blank Field","ALERT MESSAGE",JOptionPane.WARNING_MESSAGE);
					else
					{
			stat.executeUpdate("insert into village_master(district_code,subdiv_code,block_code,panchayat_code,village_name,estd,mukhia_name) values('"+tdcd+"','"+tscd+"','"+tbcd+"','"+tpcd+"','"+tvnm.trim()+"','"+tdt+"','"+tmknm.trim()+"')");
						stat.executeUpdate("commit");
						JOptionPane.showMessageDialog(null,"Record has been successfully inserted","Information",JOptionPane.INFORMATION_MESSAGE);
						t5.setText("");
						t6.setText("");
						t7.setText("");
						t8.setText(" ");
						cbsub.setEnabled(false);
						cbblock.setEnabled(false);
						cbpanchayat.setEnabled(false);
						//adddistrict();
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
				vcd=JOptionPane.showInputDialog("Enter village code to be deleted");
				if(scd==null||scd.compareTo("")==0)
				    {
				    	JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				    }
				else
				{
					int r;
					r=JOptionPane.showConfirmDialog(null,"Are u sure to delete the Record it can't recover later","ALERT ABOUT DELET",JOptionPane.WARNING_MESSAGE);
					if(r==JOptionPane.YES_OPTION)
					{	
				stat.executeUpdate("delete from village_master where village_code='"+vcd+"'");
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
		
			//try
		//	{
				Sub_village sv=new Sub_village(2);
				load();
			//	search();
			/*	
				tvcd=t5.getText();
				tvnm=t6.getText();
				tdt=t7.getText();
				tmknm=t8.getText();
				if(tbcd.compareTo("")==0)
				    JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				else
				{   
	stat.executeUpdate("update village_master set village_name='"+tvnm+"',estd='"+tdt+"',mukhia_name='"+tmknm+"' where village_code='"+tvcd+"'");
				
				stat.executeUpdate("commit");
				load();
				JOptionPane.showMessageDialog(null,"record updated successfully","Information",JOptionPane.INFORMATION_MESSAGE);
			}
		
		}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"could not update"+sqle);
			}
			*/
		}
	}
	
	private class searchListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			Sub_village sv=new Sub_village(1);
			//	search();
			
			
		
			
		}
	}
	
	private class LoadListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			load();
		}
	}
	
/*	public void search()
	{
			String s1;	
			try
			{
				    vcd=JOptionPane.showInputDialog("Enter the village code to be search");
				    if(scd==null||scd.compareTo("")==0)
				    {
				    	JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				    }
				    else
				    {
					rs=stat.executeQuery("select District_code,Subdiv_code,Block_code,Panchayat_code,Village_code,Village_name,TO_CHAR(ESTD,'DD-MON-YYYY'),Mukhia_name from village_master where village_CODE='"+vcd+"'");
					rs.next();
				
					t5.setText(rs.getString(5));
					t6.setText(rs.getString(6));
					t7.setText(rs.getString(7));
					t8.setText(rs.getString(8));
					JOptionPane.showMessageDialog(null,"record found","Information",JOptionPane.INFORMATION_MESSAGE);
					
				}
				}
				catch(SQLException sqle)
				{
					JOptionPane.showMessageDialog(null,"not found","Database Error",JOptionPane.ERROR_MESSAGE);
				}			
	}
	*/		
	
	public static void main(String[] args)
	{
		Village_Details bd=new Village_Details();
	}
}
		
		
		
	