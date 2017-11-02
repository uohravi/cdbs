//package subPkg;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.sql.*;

public class SchoolSearch extends JFrame
  {

    private JLabel lblvcode,lblbcode,lblSno,lblSname,lblnot,lblStype,lblnos,lblhod,lblBottom1,lblBottom2,lblHeader;
    private JTextField txtVcode,txtBcode,txtsno,txtsname,txtnot,txthod,txtnos,txtstype;
    private JPanel pnl;
    private JButton btnClose;
    Dimension screenSize;
    String st1,str1,str2,str3,str4,str5,str6,str7,str8,sc;
    Statement statement;
    Connection connection;
    ResultSet rs;

     public SchoolSearch(String scd)
      {
        sc=scd;
        pnl = new JPanel();
        lblHeader = new JLabel();
        lblvcode = new JLabel();
        lblbcode = new JLabel();
        lblSno = new JLabel();
        lblSname = new JLabel();
        lblnos = new JLabel();
        lblnot = new JLabel();
        lblhod = new JLabel();
        lblStype=new JLabel();
        txtVcode = new JTextField();
        txtBcode = new JTextField();
        txtsno = new JTextField();
        txtsname = new JTextField();
        txtnot = new JTextField();
        txtnos = new JTextField();
        txthod = new JTextField();
        txtstype= new JTextField();
       JLabel lblLine = new JLabel();
        lblBottom1 = new JLabel();
        lblBottom2 = new JLabel();
        btnClose = new JButton();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Search Result of School Information");
        //setAlwaysOnTop(true);
        getContentPane().setBackground(new Color(250, 216, 217));
        setResizable(false);
        

        pnl.setBackground(new Color(126, 3, 6));
        lblHeader.setFont(new Font("Engravers MT", 1, 36));
        lblHeader.setForeground(new Color(247, 251, 249));
        lblHeader.setText("search result");
        pnl.add(lblHeader);

        getContentPane().add(pnl);
        pnl.setBounds(0, 0, 540, 50);

        lblbcode.setText("Block code");
        getContentPane().add(lblbcode);
        lblbcode.setBounds(60, 60, 180, 20);

        lblvcode.setText("Village Code");
        getContentPane().add(lblvcode);
        lblvcode.setBounds(60, 90, 190, 20);

        lblSno.setText("School Number");
        getContentPane().add(lblSno);
        lblSno.setBounds(60, 120, 170, 20);
	
        lblSname.setText("School Name");
        getContentPane().add(lblSname);
        lblSname.setBounds(60, 150, 180, 20);

		lblStype.setText("Scnool Type");
        getContentPane().add(lblStype);
        lblStype.setBounds(60,180, 180, 20);

        lblnos.setText("Number of Student");
        getContentPane().add(lblnos);
        lblnos.setBounds(60, 210, 190, 20);
	
        lblnot.setText("Number of Teacher");
        getContentPane().add(lblnot);
        lblnot.setBounds(60, 240, 160, 20);
        
        lblhod.setText("Head Of Department Name");
        getContentPane().add(lblhod);
       lblhod.setBounds(60, 270, 160, 20);

        txtBcode.setBackground(new Color(255, 255, 255));
        txtBcode.setEditable(false);
        getContentPane().add(txtBcode);
        txtBcode.setBounds(250, 60, 220, 20);

        txtVcode.setBackground(Color.white);
        txtVcode.setEditable(false);
        getContentPane().add(txtVcode);
        txtVcode.setBounds(250, 90, 220, 20);

        txtsno.setBackground(Color.white);
        txtsno.setEditable(false);
        getContentPane().add(txtsno);
        txtsno.setBounds(250, 120, 220, 20);
	
        txtsname.setBackground(Color.white);
        txtsname.setEditable(false);
        getContentPane().add(txtsname);
        txtsname.setBounds(250, 150, 220, 20);
        
        txtstype.setBackground(Color.white);
        txtstype.setEditable(false);
        getContentPane().add(txtstype);
        txtstype.setBounds(250, 180, 220, 20);

        txtnos.setBackground(Color.white);
        txtnos.setEditable(false);
        getContentPane().add(txtnos);
        txtnos.setBounds(250, 210, 220, 20);

        txtnot.setBackground(Color.white);
        txtnot.setEditable(false);
        getContentPane().add(txtnot);
        txtnot.setBounds(250, 240, 220, 20);
        
        txthod.setBackground(Color.white);
        txthod.setEditable(false);
        getContentPane().add(txthod);
        txthod.setBounds(250, 270, 220, 20);

        lblLine.setForeground(new Color(3, 91, 14));
        lblLine.setText("=============================================================================");
        getContentPane().add(lblLine);
        lblLine.setBounds(0, 360, 540, 14);

        lblBottom1.setForeground(new Color(177, 20, 170));
        lblBottom1.setText("Developed by :-");
        getContentPane().add(lblBottom1);
        lblBottom1.setBounds(340, 370, 100, 20);

        lblBottom2.setForeground(new Color(149, 21, 21));
        lblBottom2.setText(" RAVI KUMAR");
        getContentPane().add(lblBottom2);
        lblBottom2.setBounds(430, 370, 230, 20);

        btnClose.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18));
        btnClose.setForeground(new Color(0, 0, 153));
        btnClose.setText("C L O S E");
        getContentPane().add(btnClose);
        btnClose.setBounds(60, 300, 410, 30);
	btnClose.addActionListener(new btnCloseListener());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-544)/2, (screenSize.height-422)/2, 544, 422);

	connect();

	setVisible(true);
		search();
    }

   public void connect()
	{	try
		{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        connection = DriverManager.getConnection("jdbc:odbc:home", "system", "manager");
		
			statement = connection.createStatement();
		}
		
		catch(SQLException e)
           	 {
            	JOptionPane.showMessageDialog(null,"EXCEPTION"+e);
            	}
               }
          catch(Exception e)
          {
		JOptionPane.showMessageDialog(null,"NOT CONNECTED");
          }
	
	}


 
  
  	private void search()
	{
			//String s1;	
			try
			{
				    
					rs=statement.executeQuery("select * from School_info where school_no='"+sc+"'");
					rs.next();
						str1=rs.getString(1);
					    str2=rs.getString(2);
					    str3=rs.getString(3);
					    str4=rs.getString(4);
					    str5=rs.getString(5);
				 	    str6=rs.getString(6);
				 	    str7=rs.getString(7);
				 	    str8=rs.getString(8);
					txtVcode.setText(str2); 
			        txtBcode.setText(str1); 
			        txtsno.setText(str3);
			        txtsname.setText(str4);
			        txtstype.setText(str5);
			        txtnot.setText(str7);
			        txtnos.setText(str6); 
			        txthod.setText(str8); 
				//	JOptionPane.showMessageDialog(null,"record found","Information",JOptionPane.INFORMATION_MESSAGE);
					
				}
			
				catch(SQLException sqle)
				{
					JOptionPane.showMessageDialog(null,"not found","Database Error",JOptionPane.ERROR_MESSAGE);
				}			
	}

     private class btnCloseListener implements ActionListener
     {
		  public void actionPerformed(ActionEvent e)
		    {
			  
				    dispose();
				 
		    }
	  }
   
  /*  public static void main(String args[]) 
    {
        SchoolSearch bs = new SchoolSearch("sc02");
    }
    */
}
