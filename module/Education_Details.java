import java.lang.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.JTable.*;

public class Education_Details extends JFrame
{
	private JLabel bck,title,pic,l1,l2,l3,l4,l5,l6,l7,l8;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	private JButton sav,del,upd,neew,ser,ext,lod,rec;
	private JPanel ptit,ppic,pcom;
	Connection conn;
	Statement stat;
	ResultSet rs;
	private String tsn,sn,str1,str2,str3,str4,str5,str6,str7,str8;
	String colhead[]={"BLOCK_CODE","VILLAGE_CODE","PANCHAYAT_CODE","EDUCATION_CODE","NO_OF_MALE_LITERATE","NO_OF_MALE_ILITERATE","NO_OF_FEMALE_LITERATE","NO_OF_FEMALE_ILITERATE"}; 
	Object data[][]=new Object[30][8];
	JTable table=new JTable(data,colhead);
	Cursor cr;
	JComboBox cbblock,cbvill,cbpan;
	
	public Education_Details()
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
		
		title=new JLabel("Entry Form of Education Information");
		title.setFont(new Font("Times of new Roman",Font.BOLD+Font.ITALIC,35));
		title.setForeground(Color.CYAN);
		ptit.add(title);
		ptit.setBounds(0,0,850,40);
		ptit.setBackground(Color.BLUE);
		
		Icon icn=new ImageIcon("ravjpg.jpg");
		pic=new JLabel(icn);
		pic.setBounds(0,40,230,300);
		JLabel pn=new JLabel(new ImageIcon("1890076777.jpg"));
		pn.setBounds(0,0,230,630);
		ppic.setLayout(null);
		ppic.add(pic);
		ppic.add(pn);
		ppic.setBounds(0,40,230,630);
		
		pcom.setLayout(null);
    	pcom.setBackground(new Color(224,232,255));
    	pcom.setBounds(230,40,850,650);
    	
    	bck=new JLabel();
    	bck.setIcon(new ImageIcon("1890076777.jpg"));
    	bck.setBounds(0,0,850,650);
    	
    	l1=new JLabel("Block_Code");
		l1.setBounds(30,30,150,30);
		l1.setForeground(Color.blue);
		l1.setBorder(bvl);
		
		l2=new JLabel("Panchayat Code");
		l2.setBounds(30,70,150,30);
		l2.setForeground(Color.blue);
		l2.setBorder(bvl);
		
		l3=new JLabel("Village Code");
		l3.setBounds(30,110,150,30);
		l3.setForeground(Color.blue);
		l3.setBorder(bvl);
		
		l4=new JLabel("Enter Education_code");
		l4.setBounds(30,150,150,30);
		l4.setForeground(Color.blue);
		l4.setBorder(bvl);
		
		l5=new JLabel("NO of Male Literate");
		l5.setBounds(30,190,150,30);
		l5.setForeground(Color.blue);
		l5.setBorder(bvl);
		
		l6=new JLabel("NO of Male ILiterate");
		l6.setBounds(30,230,150,30);
		l6.setForeground(Color.blue);
		l6.setBorder(bvl);
		
		l7=new JLabel("NO of Female Literate");
		l7.setBounds(30,270,150,30);
		l7.setForeground(Color.blue);
		l7.setBorder(bvl);
		
		l8=new JLabel("NO of Female ILiterate");
		l8.setBounds(30,310,150,30);
		l8.setForeground(Color.blue);
		l8.setBorder(bvl);
		
		cbblock=new JComboBox();
		cbvill=new JComboBox();
		cbpan=new JComboBox();
		cbblock.setBounds(250,30,200,30);
		cbvill.setBounds(250,110,200,30);
		cbpan.setBounds(250,70,200,30);
	/*	t1=new JTextField(20);
		t1.setBounds(250,30,200,30);
		t1.setBorder(bvl);
		t1.addActionListener(new enterListener());
		
		t2=new JTextField(20);
		t2.setBounds(250,70,200,30);
		t2.setBorder(bvl);
		t2.addActionListener(new enterListener());
		 
		t3=new JTextField(20);
		t3.setBounds(250,110,200,30);
		t3.setBorder(bvl);
	    t3.addActionListener(new enterListener());*/
	        
		t4=new JTextField(20);
		t4.setBounds(250,150,200,30);
		t4.setBorder(bvl);
		t4.setEditable(false);
		 
		t5=new JTextField(20);
		t5.setBounds(250,190,200,30);
		t5.setBorder(bvl);
		t5.addActionListener(new enterListener());
		 
		t6=new JTextField(20);
		t6.setBounds(250,230,200,30);
		t6.setBorder(bvl);
		t6.addActionListener(new enterListener());
		
		t7=new JTextField(20);
		t7.setBounds(250,270,200,30);
		t7.setBorder(bvl);
		t7.addActionListener(new enterListener());
		
		t8=new JTextField(20);
		t8.setBounds(250,310,200,30);
		t8.setBorder(bvl);
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
		rec.setToolTipText("Recover Modified record");
        rec.setBounds(480,265,100,25);
		rec.setCursor(cr);
		
		lod=new JButton("Load");
		lod.addActionListener(new LoadListener());
		lod.setMnemonic('L');
		lod.setToolTipText("load data from database");
		lod.setBounds(20,360,80,25);
		lod.setCursor(cr);
		lod.setForeground(Color.blue);
		
	//	table.setFont(new Font("Times New Roman",Font.BOLD,16));
    	table.setForeground(Color.blue);

    	JScrollPane jsp=new JScrollPane(table);
   		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//   	jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    	jsp.setBounds(10,400,650,150);
    	table.setEnabled(false);
    	
    	JLabel	foot=new JLabel("Devloped By:-        Ravi Kumar");
    	JLabel ln=new JLabel("============================================================================================================================================================");
    	ln.setBounds(0,560,900,20);
    	ln.setForeground(Color.red);
    	foot.setBounds(400,580,250,20);
    	foot.setForeground(Color.magenta);
		foot.setFont(new Font("legand",Font.BOLD,15));
		
		pcom.add(l1);
		pcom.add(l2);
		pcom.add(l3);
		pcom.add(l4);
		pcom.add(l5);
		pcom.add(l6);
		pcom.add(l7);
		pcom.add(l8);
		pcom.add(cbblock);
		pcom.add(cbvill);
		pcom.add(cbpan);
		pcom.add(t4);
		pcom.add(t5);
		pcom.add(t6);
		pcom.add(t7);
		pcom.add(t8);
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
		pcom.add(bck);
		pcom.setBorder(BorderFactory.createTitledBorder("Enter the Education Information"));
		
		
		cn.add(ptit);
		cn.add(ppic);
		cn.add(pcom);
		
		wind=Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setBounds((wind.width-900)/4,0,900,690);
		setResizable(false);
		setVisible(true);
		connect();
		//load();
		addblock();
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
                    t8.requestFocus();
                    if(e.getSource()==t8)
                    sav.requestFocus();
                }
         }
         
         	private class recoverListener implements ActionListener
        {
                public void actionPerformed(ActionEvent e)
                {
                    new recover_education();
                }
         }
         
         public void load()
         {
             int k=0;
             
            try
            {
              stat.executeUpdate("commit");
              rs=stat.executeQuery("select * from Education_info");
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
                data[k][0]=str1;
                data[k][1]=str2;
                data[k][2]=str3;
                data[k][3]=str4;
                data[k][4]=str5;
                data[k][5]=str6;
                data[k][6]=str7;
                data[k][7]=str8;
                k++;
              }
                data[k][0]=" ";
                data[k][1]=" ";
                data[k][2]=" ";
                data[k][3]=" ";
                data[k][4]=" ";
                data[k][5]=" ";
                data[k][6]=" ";
                data[k][7]=" ";

                JTable table=new JTable(data,colhead);
                table.setForeground(Color.blue);
                JScrollPane jsp=new JScrollPane(table);
                jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//                jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                jsp.setBounds(10,400,650,150);
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
       try
       {
       	
       		conn.close();
         dispose();
      }
      catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"error in Creating Connection","Database Error",JOptionPane.ERROR_MESSAGE);
			}
      }
   }
   
   
   private void addblock()
   {
   		cbblock.addItem("Code    |    Name  ");
   		try{
   		rs=stat.executeQuery("select block_code,block_name from block_master order by block_code");
   		while(rs.next())
   		cbblock.addItem(rs.getString(1)+"    |   "+rs.getString(2));
   		cbblock.setSelectedIndex(0);
   		
   		cbvill.setEnabled(false          );
   		cbpan.setEnabled(false);
   		cbblock.addActionListener(new cbListener());
   	}
   	catch(SQLException e)
   	{
   		JOptionPane.showMessageDialog(null,"could not inserted to combo"+e,"Database Fetching Error",JOptionPane.ERROR_MESSAGE);
   	}
   		
   	
   }
   
   private class cbListener implements ActionListener
   {
   	public void actionPerformed(ActionEvent e)
   	{
   		String code,str;
   		char ch;
   		if(e.getSource()==cbblock)
   		{
   			str=String.valueOf(cbblock.getSelectedItem());
   			code="";
   			for(int i=0;i<str.length();i++)
   			{
   				ch=str.charAt(i);
   				if(Character.isSpace(ch))
   				break;
   				code=code+ch;
   			}
   			cbvill.removeActionListener(this);
   			cbpan.removeActionListener(this);
   			
   			cbvill.setEnabled(false);
   			cbpan.setEnabled(true);
   			
   			cbvill.removeAllItems();
   			cbpan.removeAllItems();
   			
   			try
   			{
   				rs=stat.executeQuery("select panchayat_code,panchayat_name from panchayat_master where block_code='"+String.valueOf(code).trim()+"'");
   					while(rs.next())
   					cbpan.addItem(rs.getString(1)+"     |   "+rs.getString(2));
   				}
   				catch(SQLException sqle)
   				{
   					JOptionPane.showMessageDialog(null,"could add to combo box"+sqle,"Database Error Occured",JOptionPane.ERROR_MESSAGE);
   				}
   				cbpan.addActionListener(this);
   		}
   		
   		if(e.getSource()==cbpan)
   		{
   			str=String.valueOf(cbpan.getSelectedItem());
   			code="";
   			for(int i=0;i<str.length();i++)
   			{
   				ch=str.charAt(i);
   				if(Character.isSpace(ch))
   				break;
   				code=code+ch;
   			}
   			cbvill.removeActionListener(this);

   			cbvill.setEnabled(true);

   			cbvill.removeAllItems();
	
   			try
   			{
   				rs=stat.executeQuery("select village_code,village_name from village_master where panchayat_code='"+String.valueOf(code).trim()+"'");
   					while(rs.next())
   					cbvill.addItem(rs.getString(1)+"     |   "+rs.getString(2));
   				}
   				catch(SQLException sqle)
   				{
   					JOptionPane.showMessageDialog(null,"could add to combo box"+sqle,"Database Error Occured",JOptionPane.ERROR_MESSAGE);
   				}
   		}		
   		
   		
   	}
   }
   
   	private class neewListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				rs=stat.executeQuery("select * from lookupeduc");
				rs.next();
				tsn=rs.getString(1);
				cbblock.setSelectedIndex(0);
				cbvill.setEnabled(false);
				cbpan.setEnabled(false);
				t4.setText(tsn);
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				cbblock.requestFocus();
			}
			catch(SQLException sqle)
			{
			}
		}
	}
	
	private class saveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
					String code,str;
			   		char ch;
			   			str=String.valueOf(cbblock.getSelectedItem());
			   			code="";
			   			for(int i=0;i<str.length();i++)
			   			{
			   				ch=str.charAt(i);
			   				if(Character.isSpace(ch))
			   				break;
			   				code=code+ch;
			   			}
					str1=code;
					
			   			str=String.valueOf(cbvill.getSelectedItem());
			   			code="";
			   			for(int i=0;i<str.length();i++)
			   			{
			   				ch=str.charAt(i);
			   				if(Character.isSpace(ch))
			   				break;
			   				code=code+ch;
			   			}
					str2=code;
					
			   			str=String.valueOf(cbpan.getSelectedItem());
			   			code="";
			   			for(int i=0;i<str.length();i++)
			   			{
			   				ch=str.charAt(i);
			   				if(Character.isSpace(ch))
			   				break;
			   				code=code+ch;
			   			}
					str3=code;
					
					str5=t5.getText();
					str6=t6.getText();
					str7=t7.getText();
					str8=t8.getText();
					if(str5.compareTo("")==0||str6.compareTo("")==0||str7.compareTo("")==0||str8.compareTo("")==0)
					JOptionPane.showMessageDialog(null,"Please Fill The Blank Field","ALERT MESSAGE",JOptionPane.WARNING_MESSAGE);
					else
					{
		stat.executeUpdate("insert into Education_info(BLOCK_CODE,VILLAGE_CODE,PANCHAYAT_CODE,NO_OF_MALE_LITERATE,NO_OF_MALE_ILITERATE,NO_OF_FEMALE_LITERATE,NO_OF_FEMALE_ILITERATE) values('"+str1+"','"+str2+"','"+str3+"','"+str5+"','"+str6+"','"+str7+"','"+str8+"')");
					stat.executeUpdate("commit");
					JOptionPane.showMessageDialog(null,"Record has been successfully inserted","Information",JOptionPane.INFORMATION_MESSAGE);
					cbblock.setSelectedIndex(0);
					cbvill.setEnabled(false);
					cbpan.setEnabled(false);
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
					t8.setText("");
					cbblock.requestFocus();
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
				sn=JOptionPane.showInputDialog("Enter Education code to be deleted");
				if(sn==null||sn.compareTo("")==0)
				    {
				    	JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				    }
				else
				{
					int r;
					r=JOptionPane.showConfirmDialog(null,"Are u sure to delete the Record it can't recover later","ALERT ABOUT DELET",JOptionPane.WARNING_MESSAGE);
					if(r==JOptionPane.YES_OPTION)
					{	
				stat.executeUpdate("delete from Education_info where Education_code='"+sn+"'");
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
			Sub_education se=new Sub_education(2);
		
		/*	try
			{
			//	search();
				
				str4=t4.getText();
				str5=t5.getText();
				str6=t6.getText();
				str7=t7.getText();
				str8=t8.getText();
				if(str3.compareTo("")==0)
				    JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				else
				{   
stat.executeUpdate("update education_info set NO_OF_MALE_LITERATE='"+str5+"',NO_OF_MALE_ILITERATE='"+str6+"',NO_OF_FEMALE_LITERATE='"+str7+"',NO_OF_FEMALE_ILITERATE='"+str8+"'  where education_code='"+str4+"'");
				
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
			Sub_education se=new Sub_education(1);
			
			
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
				    sn=JOptionPane.showInputDialog("Enter the Education code to be search");
				    if(sn==null||sn.compareTo("")==0)
				    {
				    	JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				    }
				    else
				    {
					rs=stat.executeQuery("select * from Education_info where Education_code='"+sn+"'");
					rs.next();
					t1.setText(rs.getString(1));
					t2.setText(rs.getString(2));
					t3.setText(rs.getString(3));
					t4.setText(rs.getString(4));
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
		Education_Details sd=new Education_Details();
	}
}