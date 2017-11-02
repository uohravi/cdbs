package submodule1;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.sql.*;

public class PanchayatSearch extends JFrame
  {

    private JLabel lblSbcd,lblDcd,lblBcode,lblPcode,lblestd,lblPname,lblsrpncname,lblBottom1,lblBottom2,lblHeader;
    private JTextField txtSbname,txtDname,txtBcode,txtPcode,txtestd,txtsrpncname,txtPname;
    private JPanel pnl;
    private JButton btnClose;
    Dimension screenSize;
    String st1,str1,str2,str3,str4,str5,str6,str7,pc;
    Statement statement;
    Connection connection;
    ResultSet rs;

     public PanchayatSearch(String pcd)
      {
        pc=pcd;
        pnl = new JPanel();
        lblHeader = new JLabel();
        lblSbcd = new JLabel();
        lblDcd = new JLabel();
        lblBcode = new JLabel();
        lblPcode = new JLabel();
        lblPname = new JLabel();
        lblestd = new JLabel();
        lblsrpncname = new JLabel();
        txtSbname = new JTextField();
        txtDname = new JTextField();
        txtBcode = new JTextField();
        txtPcode = new JTextField();
        txtestd = new JTextField();
        txtPname = new JTextField();
        txtsrpncname = new JTextField();
       JLabel lblLine = new JLabel();
        lblBottom1 = new JLabel();
        lblBottom2 = new JLabel();
        btnClose = new JButton();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Search Result of Panchayat Master");
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

        lblDcd.setText("District code");
        getContentPane().add(lblDcd);
        lblDcd.setBounds(60, 90, 180, 20);

        lblSbcd.setText("Subdivision Code");
        getContentPane().add(lblSbcd);
        lblSbcd.setBounds(60, 120, 190, 20);

        lblBcode.setText("Block Code");
        getContentPane().add(lblBcode);
        lblBcode.setBounds(60, 150, 170, 20);
	
        lblPcode.setText("Panchayat Code");
        getContentPane().add(lblPcode);
        lblPcode.setBounds(60, 180, 180, 20);

        lblPname.setText("Panchayat Name");
        getContentPane().add(lblPname);
        lblPname.setBounds(60, 210, 190, 20);
	
        lblestd.setText("ESTD");
        getContentPane().add(lblestd);
        lblestd.setBounds(60, 240, 160, 20);
        
        lblsrpncname.setText("Surpanch Name");
        getContentPane().add(lblsrpncname);
       lblsrpncname.setBounds(60, 270, 160, 20);

        txtDname.setBackground(new Color(255, 255, 255));
        txtDname.setEditable(false);
        getContentPane().add(txtDname);
        txtDname.setBounds(250, 90, 220, 20);

        txtSbname.setBackground(Color.white);
        txtSbname.setEditable(false);
        getContentPane().add(txtSbname);
        txtSbname.setBounds(250, 120, 220, 20);

        txtBcode.setBackground(Color.white);
        txtBcode.setEditable(false);
        getContentPane().add(txtBcode);
        txtBcode.setBounds(250, 150, 220, 20);
	
        txtPcode.setBackground(Color.white);
        txtPcode.setEditable(false);
        getContentPane().add(txtPcode);
        txtPcode.setBounds(250, 180, 220, 20);

        txtPname.setBackground(Color.white);
        txtPname.setEditable(false);
        getContentPane().add(txtPname);
        txtPname.setBounds(250, 210, 220, 20);

        txtestd.setBackground(Color.white);
        txtestd.setEditable(false);
        getContentPane().add(txtestd);
        txtestd.setBounds(250, 240, 220, 20);
        
        txtsrpncname.setBackground(Color.white);
        txtsrpncname.setEditable(false);
        getContentPane().add(txtsrpncname);
        txtsrpncname.setBounds(250, 270, 220, 20);

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
//	show();

	
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


 /* public void show()
       {
       	try
       	{
		pc="p001";
	    rs=statement.executeQuery("select District_code,Subdiv_code,Block_code,Panchayat_code,Panchayat_name,TO_CHAR(ESTD,'DD-MON-YYYY'),SURPANCH_NAME from panchayat_master where panchayat_code='"+pc+"'");
	    rs.next();
	    str1=rs.getString(1);
	    str2=rs.getString(2);
	    str3=rs.getString(3);
	    str4=rs.getString(4);
 	    str6=rs.getString(6);
 	    str7=rs.getString(7);

	    rs.close();
	    
	    
	   	txtSbname.setText(str2); 
        txtDname.setText(str1); 
        txtBcode.setText(str3);
        txtPcode.setText(str4);
        txtestd.setText(str6);
        txtPname.setText(str5); 
        txtsrpncname.setText(str7); 
	    

	  }
	 catch(SQLException e)
          {
            	JOptionPane.showMessageDialog(null,"EXCEPTION"+e);
    	  }
	 /*   try
	     {
                rs=statement.executeQuery("select TO_CHAR(estd,'DD-MON-YYYY') from block_master where block_code='"+str3+"'");
	   	rs.next();
	   	str5=rs.getString(1);
		rs.close();
	     }
	    catch(SQLException e1)
             {
            	JOptionPane.showMessageDialog(null,"EXCEPTION"+e1);
    	     }
	    try
	     {
		rs=statement.executeQuery("select state_name from state_master where state_code='"+String.valueOf(str1).trim()+"'");
	   	rs.next();
	   	str1=rs.getString(1).toUpperCase();
		txtSname.setText(str1);
		rs.close();
	     }
	    catch(SQLException e1)
             {
            	JOptionPane.showMessageDialog(null,"EXCEPTION"+e1);
    	     }

	    try
	     {
		rs=statement.executeQuery("select district_name from district_master where district_code='"+String.valueOf(str2).trim()+"'");
	   	rs.next();
		str2=rs.getString(1).toUpperCase();
	   	txtDname.setText(str2);
		rs.close();
	     }
	    catch(SQLException e2)
             {
            	JOptionPane.showMessageDialog(null,"EXCEPTION"+e2);
    	     }

  }*/
  
  	private void search()
	{
			//String s1;	
			try
			{
				    
					rs=statement.executeQuery("select District_code,Subdiv_code,Block_code,Panchayat_code,Panchayat_name,TO_CHAR(ESTD,'DD-MON-YYYY'),SURPANCH_NAME from panchayat_master where panchayat_CODE='"+pc+"'");
					rs.next();
					str1=rs.getString(1);
					    str2=rs.getString(2);
					    str3=rs.getString(3);
					    str4=rs.getString(4);
					    str5=rs.getString(5);
				 	    str6=rs.getString(6);
				 	    str7=rs.getString(7);
				/*	t4.setText(rs.getString(4));
					t5.setText(rs.getString(5));
					t6.setText(rs.getString(6));
					t7.setText(rs.getString(7));*/
					txtSbname.setText(str2); 
			        txtDname.setText(str1); 
			        txtBcode.setText(str3);
			        txtPcode.setText(str4);
			        txtestd.setText(str6);
			        txtPname.setText(str5); 
			        txtsrpncname.setText(str7); 
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
        PanchayatSearch bs = new PanchayatSearch("p001");
    }*/
    
}
