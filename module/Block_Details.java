import java.lang.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.JTable.*;

public class Block_Details extends JFrame
{
	private JLabel title,pic,l1,l2,l3,l4,l5,l6;
	private JTextField t1,t2,t3,t4,t5,t6;
	private JButton sav,del,upd,neew,ser,ext,lod,rec;
	private JPanel ptit,ppic,pcom;
	Connection conn;
	Statement stat;
	ResultSet rs;
	private String tdcd,tscd,tbcd,tbnm,tdt,tbdnm,dcd,scd,bcd,bnm,dt,bdnm;
	String colhead[]={"District_code","Subdivision_code","Block_code","Block_name","ESTD","BDO_name"};
	Object data[][]=new Object[30][6];
	JTable table=new JTable(data,colhead);
	private JComboBox jcmbdistcd,jcmbsbdivcd;
	Cursor cr;
	
	public Block_Details()
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
		
		title=new JLabel("Entry Form of Block Master");
		title.setFont(new Font("Courier",Font.BOLD+Font.ITALIC,35));
		title.setForeground(Color.WHITE);
		ptit.add(title);
		ptit.setBounds(0,0,850,50);
		ptit.setBackground(Color.BLUE);
		
		Icon icn=new ImageIcon("mallibrary1.jpg");
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
		
		l4=new JLabel("Enter Block name");
		l4.setBounds(30,150,180,30);
		l4.setForeground(Color.blue);
		l4.setBorder(bvl);
		
		l5=new JLabel("ESTD");
		l5.setBounds(30,190,180,30);
		l5.setForeground(Color.blue);
		l5.setBorder(bvl);
		
		l6=new JLabel("Enter BDO_name");
		l6.setBounds(30,230,180,30);
		l6.setForeground(Color.blue);
		l6.setBorder(bvl);
		
		jcmbdistcd=new JComboBox();
		jcmbsbdivcd=new JComboBox();
		jcmbdistcd.setBounds(250,30,200,30);
		jcmbsbdivcd.setBounds(250,70,200,30);
	//	jcmbdistcd.addItemListener(new comboListener());
		/*
		t1=new JTextField(20);
		t1.setBounds(250,30,200,30);
		t1.setBorder(bvl);
		t1.addActionListener(new enterListener());
		
		t2=new JTextField(20);
		t2.setBounds(250,70,200,30);
		t2.setBorder(bvl);
		t2.addActionListener(new enterListener());*/
		 
		t3=new JTextField(20);
		t3.setBounds(250,110,200,30);
		t3.setForeground(Color.blue);
		t3.setEditable(false);
		t3.setBorder(bvl);

		t4=new JTextField(20);
		t4.setBounds(250,150,200,30);
		t4.setBorder(bvl);
		t4.addActionListener(new enterListener());
		 
		t5=new JTextField(20);
		t5.setBounds(250,190,200,30);
		t5.setBorder(bvl);
		t5.addActionListener(new enterListener());
		 
		t6=new JTextField(20);
		t6.setBounds(250,230,200,30);
		t6.setBorder(bvl);
		t6.addActionListener(new enterListener());
		 
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
		rec.setToolTipText("Recover the Modified record");
        rec.setBounds(480,270,100,25);
		rec.setCursor(cr);
		
		lod=new JButton("Load");
		lod.addActionListener(new LoadListener());
		lod.setMnemonic('L');
		lod.setToolTipText("load data from database");
		lod.setBounds(20,280,80,25);
		lod.setCursor(cr);
		lod.setForeground(Color.blue);
		
		JLabel	foot=new JLabel("Devloped By:-        Ravi Kumar");
    	JLabel ln=new JLabel("============================================================================================================================================================");
    	ln.setBounds(0,500,900,20);
    	ln.setForeground(Color.red);
    	foot.setBounds(400,520,250,20);
    	foot.setForeground(Color.magenta);
		foot.setFont(new Font("legand",Font.BOLD,15));

    	table.setForeground(Color.blue);
    	table.setEnabled(false);

    	JScrollPane jsp=new JScrollPane(table);
   		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//   	jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    	jsp.setBounds(10,310,650,150);
		table.setEnabled(false);
		
		pcom.add(l1);
		pcom.add(l2);
		pcom.add(l3);
		pcom.add(l4);
		pcom.add(l5);
		pcom.add(l6);
	//	pcom.add(t1);
	//	pcom.add(t2);
		pcom.add(jcmbdistcd);
		pcom.add(jcmbsbdivcd);
		pcom.add(t3);
		pcom.add(t4);
		pcom.add(t5);
		pcom.add(t6);
		pcom.add(neew);
		pcom.add(sav);
		pcom.add(del);
		pcom.add(upd);
		pcom.add(ser);
		pcom.add(ext);
		pcom.add(rec);
		pcom.add(ln);
		pcom.add(foot);
		pcom.add(jsp);
		pcom.add(lod);
		pcom.setBorder(BorderFactory.createTitledBorder("Enter the Block Information"));
		
		cn.add(ptit);
		cn.add(ppic);
		cn.add(pcom);
		
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
                  if(e.getSource()==t4)
                    t5.requestFocus();
                  if(e.getSource()==t5)
                    t6.requestFocus();
                  if(e.getSource()==t6)
                    sav.requestFocus();
                }
         }
         
         public void load()
         {
             int k=0;
             
            try
            {
              stat.executeUpdate("commit");
              rs=stat.executeQuery("select District_code,Subdiv_code,Block_code,block_name,TO_CHAR(ESTD,'DD-MON-YYYY'),bdo_name from Block_master order by block_code");
              while(rs.next())
              {
                dcd=rs.getString(1);
                scd=rs.getString(2);
                bcd=rs.getString(3);
                bnm=rs.getString(4);
                dt=rs.getString(5);
                bdnm=rs.getString(6);
                data[k][0]=dcd;
                data[k][1]=scd;
                data[k][2]=bcd;
                data[k][3]=bnm;
                data[k][4]=dt;
                data[k][5]=bdnm;
                k++;
              }
                data[k][0]=" ";
                data[k][1]=" ";
                data[k][2]=" ";
                data[k][3]=" ";
                data[k][4]=" ";
                data[k][5]=" ";

                JTable table=new JTable(data,colhead);
                table.setForeground(Color.blue);
                JScrollPane jsp=new JScrollPane(table);
                jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//                jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                jsp.setBounds(10,310,650,150);
               pcom.add(jsp);
                table.setEnabled(false);
                 
           }
             catch(SQLException sqle)
             {
                  JOptionPane.showMessageDialog(null,"Record not transfer","Database Error",JOptionPane.ERROR_MESSAGE);                      
             }
            
         }
         
         public void adddistrict()
         {
         	try
         	{
         		jcmbdistcd.addItem("Code    |   Name  ");
         	rs=stat.executeQuery("select district_code,district_name from district_master order by district_code");
         	while(rs.next())
         	jcmbdistcd.addItem(rs.getString(1)+"    |   "+rs.getString(2));
         	jcmbdistcd.setSelectedIndex(0);
         	jcmbsbdivcd.setEnabled(false);
         	
         	jcmbdistcd.addActionListener(new comboListener());
         	
         }
         catch(SQLException sqle)
             {
                  JOptionPane.showMessageDialog(null,"Record not transfer","Database Error",JOptionPane.ERROR_MESSAGE);                      
             }
         	
         }
         
         private void loadsubcmb(String st)
         {
         	try
         	{
         	rs=stat.executeQuery("select subdiv_code,subdiv_name from subdivision_master where district_code='"+String.valueOf(st).trim()+"'");
         	while(rs.next())
         		jcmbsbdivcd.addItem(rs.getString(1)+"    |    "+rs.getString(2));
         
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
   
   private class comboListener implements ActionListener
   {
   	public void actionPerformed(ActionEvent e)
   	{
   		String tmdcd;
   		String code,str;
   		char ch;
   		str=jcmbdistcd.getSelectedItem().toString();
   		code="";
   		for(int i=0;i<str.length();i++)
   		{
   			ch=str.charAt(i);
   			if(Character.isSpace(ch))
   				break;
   				code=code+ch;
   		}
   		tmdcd=code;
   		jcmbsbdivcd.removeActionListener(this);

	jcmbsbdivcd.setEnabled(true);	
	jcmbsbdivcd.removeAllItems();
   		loadsubcmb(tmdcd);
   	}
   }
   
   	private class neewListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				rs=stat.executeQuery("select * from tmpblock");
				rs.next();
				bcd=rs.getString(1);
				t3.setText(bcd);
				t3.setEditable(false);
				t4.setText("");
				t5.setText("");
				t6.setText("");
				jcmbdistcd.setSelectedIndex(0);
				jcmbsbdivcd.setEnabled(false);
				t4.requestFocus();
			}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"could not fetched"+sqle,"Database Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
		private class recoverListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new recover_block();
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
				   		str=jcmbdistcd.getSelectedItem().toString();
				   		code="";
				   		for(int i=0;i<str.length();i++)
				   		{
				   			ch=str.charAt(i);
				   			if(Character.isSpace(ch))
				   				break;
				   				code=code+ch;
				   		}
									
					tdcd=code;
				
			   		str=jcmbsbdivcd.getSelectedItem().toString();
			   		code="";
			   		for(int i=0;i<str.length();i++)
			   		{
			   			ch=str.charAt(i);
			   			if(Character.isSpace(ch))
			   				break;
			   				code=code+ch;
			   		}
					tscd=code;
				}
				catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null,"Please Select The \n   District_Code AND Subdivision_Code ","ALERT MESSAGE",JOptionPane.WARNING_MESSAGE);
						}
					tbnm=t4.getText();
					tdt=t5.getText();
					tbdnm=t6.getText();
					if(tbnm.compareTo("")==0||tdt.compareTo("")==0||tbdnm.compareTo("")==0)
					JOptionPane.showMessageDialog(null,"Please Fill The Blank Field","ALERT MESSAGE",JOptionPane.WARNING_MESSAGE);
					else
					{
		stat.executeUpdate("insert into block_master(district_code,subdiv_code,block_name,estd,bdo_name) values('"+tdcd+"','"+tscd+"','"+tbnm+"','"+tdt+"','"+tbdnm+"')");
					stat.executeUpdate("commit");
					JOptionPane.showMessageDialog(null,"Record has been successfully inserted","Information",JOptionPane.INFORMATION_MESSAGE);
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					jcmbdistcd.setSelectedIndex(0);
					jcmbsbdivcd.setEnabled(false);
					t4.requestFocus();
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
				bcd=JOptionPane.showInputDialog("Enter block code to be deleted");
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
				stat.executeUpdate("delete from block_master where block_code='"+bcd+"'");
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
			Sub_block bu=new Sub_block(2);
		
		}
	}
	
	private class searchListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Sub_block bs=new Sub_block(1);

			
		}
	}
	
	private class LoadListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			load();
		}
	}

	
	public static void main(String[] args)
	{
		Block_Details bd=new Block_Details();
	}
}
		
		
		
	