import java.lang.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.JTable.*;

public class Panchayat_Details extends JFrame
{
	private JLabel title,pic,foot,l1,l2,l3,l4,l5,l6,l7;
	private JTextField t1,t2,t3,t4,t5,t6,t7;
	private JButton sav,del,upd,neew,ser,ext,lod,rec;
	private JPanel ptit,ppic,pcom;
	Connection conn;
	Statement stat;
	ResultSet rs;
	private String tdcd,tscd,tbcd,tpcd,tpnm,tdt,tsrnm,dcd,scd,bcd,pcd,pnm,dt,srnm;
	String colhead[]={"District_code","Subdivision_code","Block_code","Panchayat_code","Panchayat_name","ESTD","Surpanch_name"};
	Object data[][]=new Object[30][7];
	JTable table=new JTable(data,colhead);
	Cursor cr;
	String cd,nm,code,Bcode,sf;
     int fg,f,l;
     char x,ch;	
	private JComboBox cbDistrict,cbSubdiv,cbBlock;
	
	public Panchayat_Details()
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
		
		title=new JLabel("Entry Form of Panchayat Master");
		title.setFont(new Font("Courier",Font.BOLD+Font.ITALIC,35));
		title.setForeground(Color.WHITE);
		ptit.add(title);
		ptit.setBounds(0,0,850,50);
		ptit.setBackground(Color.BLUE);
		
		Icon icn=new ImageIcon("village12.jpg");
		pic=new JLabel(icn);
		ppic.add(pic);
		ppic.setBounds(0,40,230,630);
		
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
		
		l5=new JLabel("Enter Panchayat_name");
		l5.setBounds(30,190,180,30);
		l5.setForeground(Color.blue);
		l5.setBorder(bvl);
		
		l6=new JLabel("ESTD");
		l6.setBounds(30,230,180,30);
		l6.setForeground(Color.blue);
		l6.setBorder(bvl);
		
		l7=new JLabel("Enter Surpanch_name");
		l7.setBounds(30,270,180,30);
		l7.setForeground(Color.blue);
		l7.setBorder(bvl);
		
		cbDistrict = new JComboBox();
        cbBlock = new JComboBox();
        cbSubdiv = new JComboBox();
		
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
	    t3.addActionListener(new enterListener());*/
	    
	    cbDistrict.setMaximumRowCount(5);
        cbDistrict.setBounds(250, 30, 200, 30);
	    cbSubdiv.setMaximumRowCount(5);
	    cbSubdiv.setBounds(250,70,200,30);
	    cbBlock.setMaximumRowCount(5);
        cbBlock.setBounds(250, 110, 200, 30);
            
		t4=new JTextField(20);
		t4.setBounds(250,150,200,30);
		t4.setBorder(etch);
		t4.addActionListener(new enterListener());
		 
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
		rec.setToolTipText("Recover Modified record");
        rec.setBounds(480,270,100,25);
		rec.setCursor(cr);
		
		lod=new JButton("Load");
		lod.addActionListener(new LoadListener());
		lod.setMnemonic('L');
		lod.setToolTipText("load data from database");
		lod.setBounds(20,320,80,25);
		lod.setCursor(cr);
		lod.setForeground(Color.blue);
		
	//	table.setFont(new Font("Times New Roman",Font.BOLD,16));
    	table.setForeground(Color.blue);

    	JScrollPane jsp=new JScrollPane(table);
   	//	jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  	//jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    	jsp.setBounds(10,350,650,150);
    	table.setEnabled(false);
    	
    	foot=new JLabel("Devloped By:-        Ravi Kumar");
    	JLabel ln=new JLabel("===================================================================================================");
    	ln.setBounds(10,510,900,20);
    	ln.setForeground(Color.GRAY);
    	foot.setBounds(400,530,250,20);
    	foot.setForeground(Color.CYAN);
		foot.setFont(new Font("legand",Font.BOLD,15));
		pcom.add(l1);
		pcom.add(l2);
		pcom.add(l3);
		pcom.add(l4);
		pcom.add(l5);
		pcom.add(l6);
		pcom.add(l7);
	//	pcom.add(t1);
	//	pcom.add(t2);
	//	pcom.add(t3);
		pcom.add(cbDistrict);
		pcom.add(cbSubdiv);
		pcom.add(cbBlock);
		pcom.add(t4);
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
		pcom.setBorder(BorderFactory.createTitledBorder("Enter the Panchayat Information"));
		
		cn.add(ptit);
		cn.add(ppic);
		cn.add(pcom);
		t4.setEditable(false);
		wind=Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setBounds((wind.width-900)/4,(wind.height-650)/4,900,650);
		setResizable(false);
		setVisible(true);
		connect();
	//	load();
		addDistrict();
	}
	
	private class enterListener implements ActionListener
        {
                public void actionPerformed(ActionEvent e)
                {
                  if(e.getSource()==t5)
                    t6.requestFocus();
                  if(e.getSource()==t6)
                  	t7.requestFocus();
                  if(e.getSource()==t7)
                    sav.requestFocus();
                }
         }
         
         public void load()
         {
             int k=0;
             
            try
            {
              stat.executeUpdate("commit");
              rs=stat.executeQuery("select District_code,Subdiv_code,Block_code,Panchayat_code,Panchayat_name,TO_CHAR(ESTD,'DD-MON-YYYY'),SURPANCH_NAME from panchayat_master order by panchayat_code");
              while(rs.next())
              {
                dcd=rs.getString(1);
                scd=rs.getString(2);
                bcd=rs.getString(3);
                pcd=rs.getString(4);
                pnm=rs.getString(5);
                dt=rs.getString(6);
                srnm=rs.getString(7);
                data[k][0]=dcd;
                data[k][1]=scd;
                data[k][2]=bcd;
                data[k][3]=pcd;
                data[k][4]=pnm;
                data[k][5]=dt;
                data[k][6]=srnm;
                k++;
              }
                data[k][0]=" ";
                data[k][1]=" ";
                data[k][2]=" ";
                data[k][3]=" ";
                data[k][4]=" ";
                data[k][5]=" ";
                data[k][6]="";

                JTable table=new JTable(data,colhead);
                table.setForeground(Color.blue);
                JScrollPane jsp=new JScrollPane(table);
            //    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//                jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                jsp.setBounds(10,350,650,150);
               pcom.add(jsp);
               table.setEnabled(false); 
                 
           }
             catch(SQLException sqle)
             {
                  JOptionPane.showMessageDialog(null,"Record not transfer","Database Error",JOptionPane.ERROR_MESSAGE);                      
             }
            
         }
         
         public void addDistrict()
         {
         	try
			{
					 cbDistrict.addItem("---Code---   |   ---Name---");
			 rs=stat.executeQuery("select District_code,District_name from District_master order by district_code");
			 while(rs.next())
			   {
				cd=rs.getString(1);
				nm=rs.getString(2);
		        	cbDistrict.addItem(cd+"           |    "+nm);
		
		           }	 
			rs.close();
		
			cbSubdiv.setEnabled(false);
			cbBlock.setEnabled(false);
			
			
			cbDistrict.addActionListener(new cbListener());
		      
		
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
     if(ae.getSource()==cbDistrict)
      {
	String str=String.valueOf(cbDistrict.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cbSubdiv.removeActionListener(this);
	cbBlock.removeActionListener(this);
	
	
	
	cbSubdiv.setEnabled(true);
	cbBlock.setEnabled(false);
	
	cbSubdiv.removeAllItems();
	cbBlock.removeAllItems();
	
	
	try
	 {
            rs=stat.executeQuery("select subdiv_code, subdiv_name from subdivision_master where district_code='"+String.valueOf(code).trim()+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbSubdiv.addItem(cd+"           |    "+nm);

               }
	    rs.close();
	    cbSubdiv.addActionListener(this);
	  }
	catch(Exception e){}
       }
 

      if(ae.getSource()==cbSubdiv)
      {
	String str=String.valueOf(cbSubdiv.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cbBlock.removeActionListener(this);
	

	cbBlock.setEnabled(true);


	
	cbBlock.removeAllItems();

	
	try
	 {
            rs=stat.executeQuery("select block_code,block_name from block_master where subdiv_code='"+String.valueOf(code).trim()+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbBlock.addItem(cd+"           |    "+nm);

               }
	    rs.close();
		t4.requestFocus();
		
	  }
	catch(Exception e){}
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
				rs=stat.executeQuery("select * from tmppanchayat");
				rs.next();
				tpcd=rs.getString(1);
				t4.setText(tpcd);
				t4.setEditable(false);
				t5.setText("");
				t6.setText("");
				t7.setText("");
				cbSubdiv.setEnabled(false);
				cbBlock.setEnabled(false);
				t5.requestFocus();
			}
		catch(SQLException sqle)
		{
			JOptionPane.showMessageDialog(null,"could not Fetched "+sqle,"New Value Insert Error",JOptionPane.ERROR_MESSAGE);
		}
		
		}
	}
	
		private class recoverListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new recover_panchayat();
		}
	}
	
	private class saveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
					try
					{
						try{
						tdcd=cbDistrict.getSelectedItem().toString();
						code="";
						for(int i=0;i<tdcd.length();i++)
						 {
						   ch=tdcd.charAt(i);
						   if(String.valueOf(ch).equals(" "))
							break;
							code=code+ch;
						 }
						 tdcd=code;
						 
						tscd=cbSubdiv.getSelectedItem().toString();
							code="";
						for(int i=0;i<tscd.length();i++)
						 {
						   ch=tscd.charAt(i);
						   if(String.valueOf(ch).equals(" "))
							break;
							code=code+ch;
						 }
						 tscd=code;
						 
						tbcd=cbBlock.getSelectedItem().toString();
							code="";
						for(int i=0;i<tbcd.length();i++)
						 {
						   ch=tbcd.charAt(i);
						   if(String.valueOf(ch).equals(" "))
							break;
							code=code+ch;
						 }
						 tbcd=code;
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null,"Please Select The \n   District_Code Subdivision_Code AND Block_Code","ALERT MESSAGE",JOptionPane.WARNING_MESSAGE);
						}
						 
						tpnm=t5.getText();
						tdt=t6.getText();
						tsrnm=t7.getText();
						if(tpnm.compareTo("")==0||tdt.compareTo("")==0||tsrnm.compareTo("")==0)
							JOptionPane.showMessageDialog(null,"Please Fill The Blank Field","ALERT MESSAGE",JOptionPane.WARNING_MESSAGE);
					else
					{
			stat.executeUpdate("insert into panchayat_master(district_code,subdiv_code,block_code,panchayat_name,estd,surpanch_name) values('"+tdcd+"','"+tscd+"','"+tbcd+"','"+tpnm+"','"+tdt+"','"+tsrnm+"')");
						stat.executeUpdate("commit");
						JOptionPane.showMessageDialog(null,"Record has been successfully inserted","Information",JOptionPane.INFORMATION_MESSAGE);
						t4.setText("");
						t5.setText("");
						t6.setText("");
						t7.setText("");
						t5.requestFocus();
						cbSubdiv.setEnabled(false);
						cbBlock.setEnabled(false);
						//addDistrict();
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
				pcd=JOptionPane.showInputDialog("Enter panchayat code to be deleted");
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
				stat.executeUpdate("delete from panchayat_master where panchayat_code='"+pcd+"'");
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
			Sub_Panchayat sd=new Sub_Panchayat(2);
			load();
		
		/*	try
			{
			//	search();
				
				tpcd=t4.getText();
				tpnm=t5.getText();
				tdt=t6.getText();
				tsrnm=t7.getText();
				if(tbcd.compareTo("")==0)
				    JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				else
				{   
	stat.executeUpdate("update panchayat_master set panchayat_name='"+tpnm+"',estd='"+tdt+"',surpanch_name='"+tsrnm+"'where panchayat_code='"+tpcd+"'");
				
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
			Sub_Panchayat sd=new Sub_Panchayat(1);
			
				//search();
			
			
		
			
		}
	}
	
	private class LoadListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			load();
		}
	}
	
/*	private void search()
	{
			String s1;	
			try
			{
				    pcd=JOptionPane.showInputDialog("Enter the panchayat code to be search");
				    if(scd==null||scd.compareTo("")==0)
				    {
				    	JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				    }
				    else
				    {
					rs=stat.executeQuery("select District_code,Subdiv_code,Block_code,Panchayat_code,Panchayat_name,TO_CHAR(ESTD,'DD-MON-YYYY'),SURPANCH_NAME from panchayat_master where panchayat_CODE='"+pcd+"'");
					rs.next();
					t4.setText(rs.getString(4));
					t5.setText(rs.getString(5));
					t6.setText(rs.getString(6));
					t7.setText(rs.getString(7));
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
		Panchayat_Details bd=new Panchayat_Details();
	}
}
		
		
		
	