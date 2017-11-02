package submodule1;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.sql.*;

public class LandSearch extends JFrame
  {

    private JLabel lblvcd,lblinv,lbllno,lbllacr,lblir,lblnir,lblha,lblBottom1,lblBottom2,lblHeader;
    private JTextField txtvcd,txtinv,txtlno,txtlacr,txtir,txtnir,txtha;
    private JPanel pnl;
    private JButton btnClose;
    Dimension screenSize;
    String st1,str1,str2,str3,str4,str5,str6,str7,pc;
    Statement statement;
    Connection connection;
    ResultSet rs;

     public LandSearch(String pcd)
      {
        pc=pcd;
        pnl = new JPanel();
        lblHeader = new JLabel();
        lblvcd = new JLabel();
        lblinv = new JLabel();
        lbllno = new JLabel();
        lbllacr = new JLabel();
        lblir = new JLabel();
        lblnir = new JLabel();
        lblha = new JLabel();
        txtvcd = new JTextField();
        txtinv = new JTextField();
        txtlno = new JTextField();
        txtlacr = new JTextField();
        txtir = new JTextField();
        txtnir = new JTextField();
        txtha = new JTextField();
       JLabel lblLine = new JLabel();
        lblBottom1 = new JLabel();
        lblBottom2 = new JLabel();
        btnClose = new JButton();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Search Result of Land Master");
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

        lblvcd.setText("Village code");
        getContentPane().add(lblvcd);
        lblvcd.setBounds(60, 90, 180, 20);

        lblinv.setText("Individual Information Number");
        getContentPane().add(lblinv);
        lblinv.setBounds(60, 120, 190, 20);

        lbllno.setText("Land Info Number");
        getContentPane().add(lbllno);
        lbllno.setBounds(60, 150, 170, 20);
	
        lbllacr.setText("Land in Acre");
        getContentPane().add(lbllacr);
        lbllacr.setBounds(60, 180, 180, 20);

        lblir.setText("Irrigated Land");
        getContentPane().add(lblir);
        lblir.setBounds(60, 210, 190, 20);
	
        lblnir.setText("Non Irrigated Land");
        getContentPane().add(lblnir);
        lblnir.setBounds(60, 240, 160, 20);
        
        lblha.setText("House Area");
        getContentPane().add(lblha);
       lblha.setBounds(60, 270, 160, 20);

        txtvcd.setBackground(new Color(255, 255, 255));
        txtvcd.setEditable(false);
        getContentPane().add(txtvcd);
        txtvcd.setBounds(250, 90, 220, 20);

        txtinv.setBackground(Color.white);
        txtinv.setEditable(false);
        getContentPane().add(txtinv);
        txtinv.setBounds(250, 120, 220, 20);

        txtlno.setBackground(Color.white);
        txtlno.setEditable(false);
        getContentPane().add(txtlno);
        txtlno.setBounds(250, 150, 220, 20);
	
        txtlacr.setBackground(Color.white);
        txtlacr.setEditable(false);
        getContentPane().add(txtlacr);
        txtlacr.setBounds(250, 180, 220, 20);

        txtir.setBackground(Color.white);
        txtir.setEditable(false);
        getContentPane().add(txtir);
        txtir.setBounds(250, 210, 220, 20);

        txtnir.setBackground(Color.white);
        txtnir.setEditable(false);
        getContentPane().add(txtnir);
        txtnir.setBounds(250, 240, 220, 20);
        
        txtha.setBackground(Color.white);
        txtha.setEditable(false);
        getContentPane().add(txtha);
        txtha.setBounds(250, 270, 220, 20);

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
				    
					rs=statement.executeQuery("select * from land_info where land_info_no='"+pc+"'");
					rs.next();
					str1=rs.getString(1);
					    str2=rs.getString(2);
					    str3=rs.getString(3);
					    str4=rs.getString(4);
					    str5=rs.getString(5);
				 	    str6=rs.getString(6);
				 	    str7=rs.getString(7);
					txtinv.setText(str2); 
			        txtvcd.setText(str1); 
			        txtlno.setText(str3);
			        txtlacr.setText(str4);
			        txtir.setText(str6);
			        txtnir.setText(str5); 
			        txtha.setText(str7); 
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
   
   /* public static void main(String args[]) 
    {
        LandSearch bs = new LandSearch("l25");
    }*/
    
}
