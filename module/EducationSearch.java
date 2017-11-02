//package subPkg;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.sql.*;

public class EducationSearch extends JFrame
  {

    private JLabel lblvcd,lbleduc,lblBcode,lblPcode,lblnml,lblnmil,lblnfml,lblnfmil,lblBottom1,lblBottom2,lblHeader;
    private JTextField txtedu,txtnml,txtBcode,txtPcode,txtnmil,txtnfml,txtnfmil,txtVcode;
    private JPanel pnl;
    private JButton btnClose;
    Dimension screenSize;
    String st1,str1,str2,str3,str4,str5,str6,str7,str8,vc;
    Statement statement;
    Connection connection;
    ResultSet rs;

     public EducationSearch(String vcd)
      {
        vc=vcd;
        pnl = new JPanel();
        lblHeader = new JLabel();
        lblvcd = new JLabel();
        lbleduc = new JLabel();
        lblBcode = new JLabel();
        lblPcode = new JLabel();
        lblnml = new JLabel();
        lblnmil = new JLabel();
        lblnfml = new JLabel();
        lblnfmil=new JLabel();
        
        txtedu = new JTextField();
        txtnml = new JTextField();
        txtBcode = new JTextField();
        txtPcode = new JTextField();
        txtnmil = new JTextField();
        txtnfml = new JTextField();
        txtnfmil = new JTextField();
        txtVcode= new JTextField();
        
       JLabel lblLine = new JLabel();
        lblBottom1 = new JLabel();
        lblBottom2 = new JLabel();
        btnClose = new JButton();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Search Result of Education Info");
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

        lblBcode.setText("Block code");
        getContentPane().add(lblBcode);
        lblBcode.setBounds(60, 60, 180, 20);

        lblPcode.setText("Panchayat Code");
        getContentPane().add(lblPcode);
        lblPcode.setBounds(60, 90, 190, 20);

        lblvcd.setText("Village Code");
        getContentPane().add(lblvcd);
        lblvcd.setBounds(60, 120, 170, 20);
	
        lbleduc.setText("Education Code");
        getContentPane().add(lbleduc);
        lbleduc.setBounds(60, 150, 180, 20);

		lblnml.setText("NO_OF_MALE_LITERATE");
        getContentPane().add(lblnml);
        lblnml.setBounds(60,180, 180, 20);

        lblnmil.setText("NO_OF_MALE_ILITERATE");
        getContentPane().add(lblnmil);
        lblnmil.setBounds(60, 210, 190, 20);
	
        lblnfml.setText("NO_OF_FEMALE_LITERATE");
        getContentPane().add(lblnfml);
        lblnfml.setBounds(60, 240, 160, 20);
        
        lblnfmil.setText("NO_OF_FEMALE_ILITERATE");
        getContentPane().add(lblnfmil);
       lblnfmil.setBounds(60, 270, 160, 20);

        txtBcode.setBackground(Color.white);
        txtBcode.setEditable(false);
        getContentPane().add(txtBcode);
        txtBcode.setBounds(250, 60, 220, 20);
	
        txtPcode.setBackground(Color.white);
        txtPcode.setEditable(false);
        getContentPane().add(txtPcode);
        txtPcode.setBounds(250, 90, 220, 20);
        
        txtVcode.setBackground(Color.white);
        txtVcode.setEditable(false);
        getContentPane().add(txtVcode);
        txtVcode.setBounds(250, 120, 220, 20);
        
        txtedu.setBackground(new Color(255, 255, 255));
        txtedu.setEditable(false);
        getContentPane().add(txtedu);
        txtedu.setBounds(250, 150, 220, 20);

        txtnml.setBackground(Color.white);
        txtnml.setEditable(false);
        getContentPane().add(txtnml);
        txtnml.setBounds(250, 180, 220, 20);

        txtnmil.setBackground(Color.white);
        txtnmil.setEditable(false);
        getContentPane().add(txtnmil);
        txtnmil.setBounds(250, 210, 220, 20);

        txtnfml.setBackground(Color.white);
        txtnfml.setEditable(false);
        getContentPane().add(txtnfml);
        txtnfml.setBounds(250, 240, 220, 20);
        
        txtnfmil.setBackground(Color.white);
        txtnfmil.setEditable(false);
        getContentPane().add(txtnfmil);
        txtnfmil.setBounds(250, 270, 220, 20);

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
				    
					rs=statement.executeQuery("select * from education_info where education_CODE='"+vc+"'");
					rs.next();
						str1=rs.getString(1);
					    str2=rs.getString(2);
					    str3=rs.getString(3);
					    str4=rs.getString(4);
					    str5=rs.getString(5);
				 	    str6=rs.getString(6);
				 	    str7=rs.getString(7);
				 	    str8=rs.getString(8);
			        txtBcode.setText(str1);
			        txtPcode.setText(str3);
			        txtVcode.setText(str2);
			        txtedu.setText(str4); 
			        txtnml.setText(str5); 
			        txtnmil.setText(str6);
			        txtnfml.setText(str7); 
			        txtnfmil.setText(str8); 
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
        EducationSearch bs = new EducationSearch("e001");
    }*/
    
}
