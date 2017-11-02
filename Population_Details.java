import java.lang.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.JTable.*;

public class Population_Details extends JFrame
{
	private JLabel title,pic,foot,l1,l2,l3,l4,l5;
	private JTextField t1,t2,t3,t4,t5;
	private JButton sav,del,upd,neew,ser,ext,lod,rec;
	private JPanel ptit,ppic,pcom,ptbl,pbtn;
	Connection conn;
	Statement stat;
	ResultSet rs;
	private JComboBox jcmb;
	private String tvcd,tppcd,tnml,tnfl,tncl,ppcd,vcd,nml,nfl,ncl;
	String colhead[]={"Village_code","Population_code","no_of_male_population","no_of_female_population","no_of_child_population"};
	Object data[][]=new Object[30][5];
	JTable table=new JTable(data,colhead);
	Cursor cr;
	
	public Population_Details()
	{
		super("Computerized Databank System of Bihar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		Container cn=getContentPane();
		cn.setBackground(Color.magenta);
		Dimension wind;
		
		BevelBorder bvl=new BevelBorder(BevelBorder.RAISED);
		EtchedBorder etch=new EtchedBorder(EtchedBorder.RAISED);
		cr=new Cursor(Cursor.HAND_CURSOR);
		ptit=new JPanel();
		ppic=new JPanel();
		pcom=new JPanel();
		ptbl=new JPanel();
		pbtn=new JPanel();
		
		title=new JLabel("Entry Form of Population Master");
		title.setFont(new Font("Courier",Font.BOLD+Font.ITALIC,35));
		title.setForeground(Color.WHITE);
		ptit.add(title);
		ptit.setBounds(0,0,900,50);
		ptit.setBackground(Color.RED);
		
		Icon icn=new ImageIcon("pool.jpg");
		pic=new JLabel(icn);
		ppic.add(pic);
		ppic.setBounds(0,40,230,630);
		
		pcom.setLayout(null);
    	//pcom.setBackground(Color.red);
    	pcom.setBounds(230,50,890,250);
    	
    	ptbl.setLayout(null);
    	ptbl.setBounds(230,340,890,200);
    	
    	pbtn.setBackground(new Color(224,232,255));
    	pbtn.setBounds(230,300,700,40);
    	pbtn.setBackground(new Color(100,20,200));
    	
    	l1=new JLabel("Enter Village_Code");
		l1.setBounds(30,30,180,30);
		l1.setForeground(Color.red);
		l1.setBorder(bvl);
		
		l2=new JLabel("Enter Population_code");
		l2.setBounds(30,70,180,30);
		l2.setForeground(Color.red);
		l2.setBorder(bvl);
		
		l3=new JLabel("Enter No_of_male_population");
		l3.setBounds(30,110,180,30);
		l3.setForeground(Color.red);
		l3.setBorder(bvl);
		
		l4=new JLabel("Enter No_of_female_population");
		l4.setBounds(30,150,180,30);
		l4.setForeground(Color.red);
		l4.setBorder(bvl);
		
		l5=new JLabel("Enter No_of_Child_population");
		l5.setBounds(30,190,180,30);
		l5.setForeground(Color.red);
		l5.setBorder(bvl);
		
		jcmb=new JComboBox();
		jcmb.setBounds(250,30,200,25);	
	//	t1=new JTextField(20);
	//	t1.setBounds(250,30,200,25);
	//	t1.setBorder(etch);
	//	t1.addActionListener(new enterListener());
		
		t2=new JTextField(20);
		t2.setBounds(250,70,200,25);
		t2.setBorder(etch);
		t2.setForeground(Color.blue);
		t2.setEditable(false);
		 
		t3=new JTextField(20);
		t3.setBounds(250,110,200,25);
		t3.setBorder(etch);
	    t3.addActionListener(new enterListener());
	        
		t4=new JTextField(20);
		t4.setBounds(250,150,200,25);
		t4.setBorder(etch);
		t4.addActionListener(new enterListener());
		 
		t5=new JTextField(20);
		t5.setBounds(250,190,200,25);
		t5.setBorder(etch);
		t5.addActionListener(new enterListener());
		 
		neew=new JButton("New");
		neew.addActionListener(new neewListener());
		neew.setMnemonic('N');
		neew.setToolTipText("press to enter new record");
        neew.setCursor(cr);
        neew.setForeground(Color.blue);
		
		sav=new JButton("Save");
		sav.addActionListener(new saveListener());
		sav.setMnemonic('S');
		sav.setToolTipText("press  to save record");	
		sav.setCursor(cr);
		sav.setForeground(Color.blue);
		
		del=new JButton("Delete");
		del.addActionListener(new deletListener());
		del.setMnemonic('D');
		del.setToolTipText("press to Delete record");
		del.setCursor(cr);
		del.setForeground(Color.blue);
		
		ext=new JButton("eXit");
		ext.addActionListener(new exitListener());
		ext.setMnemonic('X');
		ext.setToolTipText("press to exit");
        ext.setCursor(cr);
        ext.setForeground(Color.blue);
		
		upd=new JButton("Update");
		upd.addActionListener(new updateListener());
		upd.setMnemonic('U');
		upd.setToolTipText("press to update the exitisting record");
		upd.setCursor(cr);
		upd.setForeground(Color.blue);
		
		ser=new JButton("sEarch");
		ser.addActionListener(new searchListener());
		ser.setMnemonic('E');
		ser.setToolTipText("press to search a record");
		ser.setCursor(cr);
		ser.setForeground(Color.blue);
		
		rec=new JButton("Recover");
		rec.addActionListener(new recoverListener());
		rec.setMnemonic('R');
		rec.setToolTipText("Restore Modified record");
		rec.setCursor(cr);
		rec.setForeground(Color.blue);
		
		lod=new JButton("Load");
		lod.addActionListener(new LoadListener());
		lod.setMnemonic('L');
		lod.setToolTipText("load data from database");
		lod.setCursor(cr);
		lod.setForeground(Color.blue);
		
	
    	table.setForeground(Color.red);

    	JScrollPane jsp=new JScrollPane(table);
   	//	jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  	//jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    	jsp.setBounds(5,0,655,200);
    	
    	foot=new JLabel("Devloped By:-        Ravi Kumar");
    	JLabel ln=new JLabel("===================================================================================================");
    	ln.setBounds(230,560,900,20);
    	ln.setFont(new Font("arial black",Font.BOLD,20));
    	ln.setForeground(Color.green);
    	foot.setBounds(400,590,250,20);
    	foot.setForeground(Color.green);
		foot.setFont(new Font("algerian",Font.BOLD,15));
		pcom.add(l1);
	//	pcom.add(t1);
		pcom.add(jcmb);
		pcom.add(l2);
		pcom.add(t2);
		pcom.add(l3);
		pcom.add(t3);
		pcom.add(l4);
		pcom.add(t4);
		pcom.add(l5);
		pcom.add(t5);
		ptbl.add(jsp);
		pbtn.add(neew);
		pbtn.add(sav);
		pbtn.add(del);
		pbtn.add(upd);
		pbtn.add(ser);
		pbtn.add(ext);
		pbtn.add(rec);
		pbtn.add(lod);
		pcom.setBorder(BorderFactory.createTitledBorder("Enter the Population Information"));
		
		cn.add(ptit);
		cn.add(ppic);
		cn.add(pcom);
		cn.add(ptbl);
		cn.add(pbtn);
		cn.add(ln);
		cn.add(foot);
		
		wind=Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setBounds((wind.width-900)/4,(wind.height-650)/4,900,650);
		setResizable(false);
		setVisible(true);
		connect();
		load();
		loadcmb();
	}
	
	private class enterListener implements ActionListener
        {
                public void actionPerformed(ActionEvent e)
                {
                  if(e.getSource()==t3)
                    t4.requestFocus();
                  if(e.getSource()==t4)
                    t5.requestFocus();
                  if(e.getSource()==t5)
                    sav.requestFocus();
                }
         }
         
         public void load()
         {
             int k=0;
             
            try
            {
              stat.executeUpdate("commit");
              rs=stat.executeQuery("select * from population_master order by population_code");
              while(rs.next())
              {
                vcd=rs.getString(1);
                ppcd=rs.getString(2);
                nml=rs.getString(3);
                nfl=rs.getString(4);
                ncl=rs.getString(5);
                data[k][0]=vcd;
                data[k][1]=ppcd;
                data[k][2]=nml;
                data[k][3]=nfl;
                data[k][4]=ncl;
                k++;
              }
                data[k][0]=" ";
                data[k][1]=" ";
                data[k][2]=" ";
                data[k][3]=" ";
                data[k][4]=" ";
              
                JTable table=new JTable(data,colhead);
                table.setForeground(Color.red);
           
                JScrollPane jsp=new JScrollPane(table);
            //    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//                jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                jsp.setBounds(5,0,655,200);
               ptbl.add(jsp);
                
                 
           }
             catch(SQLException sqle)
             {
                  JOptionPane.showMessageDialog(null,"Record not transfer","Database Error",JOptionPane.ERROR_MESSAGE);                      
             }
            
         }
         
          private void loadcmb()
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
			reset();
		}
	}
	
		private class recoverListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new recover_population();
		}
	}

	
	private void reset()
	{
		try
		{
			rs=stat.executeQuery("select * from tmpppcode");
			rs.next();
			tppcd=rs.getString(1);
			t2.setText(tppcd);
			t2.setEditable(false);
			jcmb.setSelectedIndex(0);
			t3.setText("");
			t4.setText("");
			t5.setText("");
			jcmb.requestFocus();
		}
		  catch(SQLException sqle)
		   {
		   	  JOptionPane.showMessageDialog(null,"could not Fetched "+sqle,"Database Error",JOptionPane.ERROR_MESSAGE);
		  }
	}
	
	private class saveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			try
			{
					
					tvcd=String.valueOf(jcmb.getSelectedItem());
					tnml=t3.getText();
					tnfl=t4.getText();
					tncl=t5.getText();
		stat.executeUpdate("insert into population_master(village_code,no_of_male_population,no_of_female_population,no_of_child_population) values('"+tvcd+"','"+tnml+"','"+tnfl+"','"+tncl+"')");
					stat.executeUpdate("commit");
					JOptionPane.showMessageDialog(null,"Record has been successfully inserted","Information",JOptionPane.INFORMATION_MESSAGE);
					reset();
					load();
				
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
				ppcd=JOptionPane.showInputDialog("Enter population code to be deleted");
				if(ppcd==null||ppcd.compareTo("")==0)
				    {
				    	JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				    }
				else
				{
					int r;
						rs=stat.executeQuery("select * from population_master where population_CODE='"+ppcd+"'");
					rs.next();
					//t1.setText(rs.getString(1));
					String s1=rs.getString(1);
					t2.setText(rs.getString(2));
					t3.setText(rs.getString(3));
					t4.setText(rs.getString(4));
					t5.setText(rs.getString(5));
					jcmb.setSelectedItem(s1);	
					r=JOptionPane.showConfirmDialog(null,"Are u sure to delete the Record it can't recover later","ALERT ABOUT DELET",JOptionPane.WARNING_MESSAGE);
					if(r==JOptionPane.YES_OPTION)
					{
					
				stat.executeUpdate("delete from population_master where population_code='"+ppcd+"'");
				stat.executeUpdate("commit");
				reset();
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
				
				tvcd=String.valueOf(jcmb.getSelectedItem());
				tppcd=t2.getText();
				tnml=t3.getText();
				tnfl=t4.getText();
				tncl=t5.getText();
				if(tppcd.compareTo("")==0)
				    JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				else
				{   
	stat.executeUpdate("update population_master set village_code='"+tvcd+"', No_of_male_population='"+tnml+"',no_of_female_population='"+tnfl+"',no_of_child_population='"+tncl+"' where population_code='"+tppcd+"'");
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
	
	private void search()
	{
			String s1;	
			try
			{
				    ppcd=JOptionPane.showInputDialog("Enter the population code to be search");
				    if(ppcd==null||ppcd.compareTo("")==0)
				    {
				    	JOptionPane.showMessageDialog(null,"please enter a value","Invalid Entry",JOptionPane.WARNING_MESSAGE);
				    }
				    else
				    {
				    	int i;
					rs=stat.executeQuery("select * from population_master where population_CODE='"+ppcd+"'");
					rs.next();
					//t1.setText(rs.getString(1));
					s1=rs.getString(1);
					t2.setText(rs.getString(2));
					t3.setText(rs.getString(3));
					t4.setText(rs.getString(4));
					t5.setText(rs.getString(5));
					jcmb.setSelectedItem(s1);
					JOptionPane.showMessageDialog(null,"record found","Information",JOptionPane.INFORMATION_MESSAGE);
					
				}
				}
				catch(SQLException sqle)
				{
					JOptionPane.showMessageDialog(null,"not found","Database Error",JOptionPane.ERROR_MESSAGE);
				}			
	}
			
	
	public static void main(String[] args)
	{
		Population_Details bd=new Population_Details();
	}
}
		
		
		
	