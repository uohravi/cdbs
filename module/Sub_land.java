//package subPkg;
import java.lang.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class Sub_land extends JFrame
 {
     private JComboBox cbvill,cbinv,cblnd;
     private JLabel lblvill,lblinv,lblland,lblHeader;
     private JButton btnCancel,btnSubmit;
     Dimension screenSize;
     Statement statement;
     Connection connection;
     ResultSet rs;
     String cd,nm,code,bcode,sf;
     int fl;
     char x,ch;	

     
    public Sub_land(int flg)
      {
      	fl=flg;
        cbvill = new JComboBox();
        cbinv = new JComboBox();
   		cblnd= new JComboBox();
   		
        lblvill = new JLabel();
        lblinv = new JLabel();
        lblland = new JLabel();
        
        lblHeader = new JLabel();
        btnSubmit = new JButton();
        btnCancel = new JButton();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Submit Entry Of Land");
        //setAlwaysOnTop(true);
        setResizable(false);
        
        getContentPane().add(cbvill);
	cbvill.setMaximumRowCount(5);
        cbvill.setBounds(180, 80, 220, 22);

        getContentPane().add(cbinv);
	cbinv.setMaximumRowCount(5);
        cbinv.setBounds(180, 110, 220, 22);
        
        getContentPane().add(cblnd);
	cblnd.setMaximumRowCount(5);
        cblnd.setBounds(180, 140, 220, 22);

        lblvill.setText("Village Name");
        getContentPane().add(lblvill);
        lblvill.setBounds(40, 80, 90, 20);

        lblinv.setText("Individual Informataion Number");
        getContentPane().add(lblinv);
        lblinv.setBounds(40, 110, 120, 20);
        
        lblland.setText("Land Number");
        getContentPane().add(lblland);
        lblland.setBounds(40, 140, 120, 20);
  
        lblHeader.setFont(new Font("Forte", 0, 36));
        lblHeader.setForeground(new Color(190, 90, 54));
        lblHeader.setText("Select  Land Number");
        getContentPane().add(lblHeader);
        lblHeader.setBounds(110, 20, 300, 40);

        btnSubmit.setText("Submit");
        getContentPane().add(btnSubmit);
        btnSubmit.setBounds(80, 260, 120, 30);
	btnSubmit.setEnabled(false);
	

        btnCancel.setText("Cancel");
        getContentPane().add(btnCancel);
        btnCancel.setBounds(250, 260, 120, 30);

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-450)/2, (screenSize.height-350)/2, 450, 350);

	connect();
	addState();
	btnSubmit.addActionListener(new btnSubmitListener());
	btnCancel.addActionListener(new btnCancelListener());

        setVisible(true);
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


  public void addState()
   {
	
	try
	{
 	
	 rs=statement.executeQuery("select village_code,village_name from village_master order by village_code");
	 
	 cbvill.addItem("---Code---   |   ---Name---");
	 while(rs.next())
	   {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbvill.addItem(cd+"           |    "+nm);

           }	 
	rs.close();

	cbinv.setEnabled(false);
	cblnd.setEnabled(false);
		
	cbvill.addActionListener(new cbListener());
      

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
     if(ae.getSource()==cbvill)
      {
	String str=String.valueOf(cbvill.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cbinv.removeActionListener(this);
	cblnd.removeActionListener(this);
	
	cbinv.setEnabled(true);
	cblnd.setEnabled(false);
	
	cbinv.removeAllItems();
	cblnd.removeAllItems();
	
	try
	 {
            rs=statement.executeQuery("select individual_info_no,name from individual_information_master where village_code='"+code+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbinv.addItem(cd+"           |    "+nm);

               }
	    rs.close();
	    cbinv.addActionListener(this);
	  }
	catch(Exception e){}
       }
 

      if(ae.getSource()==cbinv)
      {
	String str=String.valueOf(cbinv.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cblnd.removeActionListener(this);
	

	cblnd.setEnabled(true);	

	
	cblnd.removeAllItems();
	
	
	try
	 {
            rs=statement.executeQuery("select land_info_no from land_info where individual_info_no='"+String.valueOf(code).trim()+"'");
	    while(rs.next())
	       {
			cd=rs.getString(1);
        	cblnd.addItem(cd);

               }
	    rs.close();
	    
	   btnSubmit.setEnabled(true);
	  }
	catch(Exception e){}
       }
       
   
    } 
  }  


 public void getlandCode()
  {
     String str=String.valueOf(cblnd.getSelectedItem());
	bcode="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		bcode=bcode+ch;
	 }

  }
    
  private class btnSubmitListener implements ActionListener
     {
        public void actionPerformed(ActionEvent e)
  	 {
	    getlandCode(); 
	    if(fl==1)
	       {
                LandSearch pbs = new LandSearch(bcode);     
	       }
	     if(fl==2)
	       {
                LandUpdate pbu = new LandUpdate(bcode);     
	        
	       }
         }
      }
    

  private class btnCancelListener implements ActionListener
     {
	public void actionPerformed(ActionEvent e)
	    {
	      dispose();
	    }
     }


  /*  public static void main(String args[])
    {
       Sub_land sbf=new Sub_land(1);
    } */
  
    
}
