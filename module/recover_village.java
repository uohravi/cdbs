import java.lang.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.JTable.*;

public class recover_village extends JFrame
{
	private JLabel title,l1,footer;
	private JTextField t1;
	private JButton ok,cancel;
	private JPanel ptit,pcom;
	Connection conn;
	Statement stat;
	ResultSet rs;
	private String str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,tmp;
	String colhead[]={"District_code","Subdivision_code","Block_code","Panchayat_code","village_code","Panchayat_name","estd","Surpanch_name","User_Name","Status","Date Of Modification"};
	Object data[][]=new Object[30][11];
	JTable table=new JTable(data,colhead);
	Cursor cr;
	
	public recover_village()
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
		pcom=new JPanel();
		
		title=new JLabel("Recover Village Information");
		title.setFont(new Font("Courier",Font.BOLD+Font.ITALIC,35));
		title.setForeground(Color.WHITE);
		ptit.add(title);
		ptit.setBounds(0,0,850,50);
		ptit.setBackground(Color.BLUE);
		
		
		pcom.setLayout(null);
    	pcom.setBackground(new Color(224,232,255));
    	pcom.setBounds(0,50,850,650);
    	
    	l1=new JLabel("Enter Village_Code");
		l1.setBounds(30,30,180,30);
		l1.setForeground(Color.blue);
		l1.setBorder(bvl);

		t1=new JTextField(20);
		t1.setBounds(250,30,200,30);
		t1.setBorder(bvl);
		 
		ok=new JButton("Recover");
		ok.addActionListener(new okListener());
		ok.setMnemonic('R');
		ok.setToolTipText("press recover the record");
        ok.setBounds(480,30,100,25);
        ok.setCursor(cr);
		
		cancel=new JButton("  Cancel  ");
		cancel.addActionListener(new cancelListener());
		cancel.setMnemonic('C');
		cancel.setToolTipText("exit from the form");	
        cancel.setBounds(480,70,100,25);
		cancel.setCursor(cr);
		
		footer=new JLabel("        !!!!  INFORMATION: == \n    Deleted record can not be Recover  \n   It is Only for View Purpose    ");
		footer.setForeground(Color.red);
		footer.setBounds(0,400,850,100);
		
		
    	table.setForeground(Color.blue);
    	table.setEnabled(false);

    	JScrollPane jsp=new JScrollPane(table);
    	jsp.setBounds(0,150,850,200);
		table.setEnabled(false);
		
			JLabel	foot=new JLabel("Devloped By:-        Ravi Kumar");
    	JLabel ln=new JLabel("============================================================================================================================================================");
    	ln.setBounds(0,470,900,20);
    	ln.setForeground(Color.red);
    	foot.setBounds(450,530,250,20);
    	foot.setForeground(Color.magenta);
		foot.setFont(new Font("legand",Font.BOLD,15));
		
		pcom.add(l1);
		pcom.add(t1);
		pcom.add(ok);
		pcom.add(cancel);
		pcom.add(footer);
		pcom.add(ln);
		pcom.add(foot);
		pcom.add(jsp);
		pcom.setBorder(BorderFactory.createTitledBorder("Recovering Data"));
		
		cn.add(ptit);
		cn.add(pcom);
		
		wind=Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setBounds((wind.width-900)/4,(wind.height-650)/4,900,650);
		setResizable(false);
		setVisible(true);
		connect();
		load();
		
	}
	
         public void load()
         {
             int k=0;
             
            try
            {
              stat.executeUpdate("commit");
              rs=stat.executeQuery("select District_code,subdiv_code,block_code,panchayat_code,village_code,village_name,TO_CHAR(estd,'DD-MON-YYYY'),mukhia_name,user_name,status,TO_CHAR(dt,'DD-MON-YYYY') from bkp_village order by district_code");
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
                data[k][8]=" ";
                data[k][9]=" ";
                data[k][10]=" ";

                JTable table=new JTable(data,colhead);
                table.setForeground(Color.blue);
                JScrollPane jsp=new JScrollPane(table);
                jsp.setBounds(0,150,850,200);
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
   
   	private class okListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				  str1=t1.getText();
				  tmp="update";
				  rs=stat.executeQuery("select district_code,subdiv_code,block_code,panchayat_code,village_name,TO_CHAR(estd,'DD-MON-YYYY'),mukhia_name,status from bkp_village where village_code='"+str1.trim()+"'");
                 rs.next();
                str2=rs.getString(1);
                str3=rs.getString(2);
                str4=rs.getString(3);
                str5=rs.getString(4);
                str6=rs.getString(5);
                str7=rs.getString(6);
                str8=rs.getString(7);
                str9=rs.getString(8);
                if(tmp.equals(str9.trim()))
                {
                	if(str7==null)
                	str7="";
                	JOptionPane.showMessageDialog(null,"values "+str2+"  "+str1+"  "+str3+"  "+str4+"  "+str5+"  "+str6);
				stat.executeUpdate("update village_master set district_code='"+str2+"',subdiv_CODE='"+str3+"',block_code='"+str4.trim()+"',panchayat_code='"+str5.trim()+"',village_name='"+str6.trim()+"',estd='"+str7+"',mukhia_name='"+str8.trim()+"' where village_code='"+str1.trim()+"'");
				stat.executeUpdate("delete from bkp_village where village_code='"+str1.trim()+"'");
				stat.executeUpdate("commit");
				JOptionPane.showMessageDialog(null,"Record Updated Succesfully");
				load();
				}
			}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"could not fetched"+sqle,"Database Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private class cancelListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				dispose();
				conn.close();
		
			}
		   
		   catch(SQLException sqle)
		   {
		   	  JOptionPane.showMessageDialog(null,"Error to EXit "+sqle,"Database Error",JOptionPane.ERROR_MESSAGE);
		  }
		
		}
	}
	
	public static void main(String[] args)
	{
		new recover_village();
	}
}
		
		
		
	