package submodule;
import submodule1.*;
import java.lang.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class Sub_school extends JFrame
 {
     private JComboBox cbblock,cbvill,cbscno;
     private JLabel lblblock,lblvill,lblscno,lblHeader;
     private JButton btnCancel,btnSubmit;
     Dimension screenSize;
     Statement statement;
     Connection connection;
     ResultSet rs;
     String cd,nm,code,sno,sf;
     int fl;
     char x,ch;	

     
    public Sub_school(int flg)
      {
      	fl=flg;
        cbblock = new JComboBox();
        cbvill = new JComboBox();
   		cbscno= new JComboBox();
   		
        lblblock = new JLabel();
        lblvill = new JLabel();
        lblscno = new JLabel();
        
        lblHeader = new JLabel();
        btnSubmit = new JButton();
        btnCancel = new JButton();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Submit Entry Of School");
        //setAlwaysOnTop(true);
        setResizable(false);
        
        getContentPane().add(cbblock);
	cbblock.setMaximumRowCount(5);
        cbblock.setBounds(180, 80, 220, 22);

        getContentPane().add(cbvill);
	cbvill.setMaximumRowCount(5);
        cbvill.setBounds(180, 110, 220, 22);
        
        getContentPane().add(cbscno);
	cbscno.setMaximumRowCount(5);
        cbscno.setBounds(180, 140, 220, 22);

        lblblock.setText("Block Name");
        getContentPane().add(lblblock);
        lblblock.setBounds(40, 80, 90, 20);

        lblvill.setText("Village Name");
        getContentPane().add(lblvill);
        lblvill.setBounds(40, 110, 120, 20);
        
        lblscno.setText("School Number");
        getContentPane().add(lblscno);
        lblscno.setBounds(40, 140, 120, 20);
  
        lblHeader.setFont(new Font("Forte", 0, 36));
        lblHeader.setForeground(new Color(190, 90, 54));
        lblHeader.setText("Select  School Number");
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
	addBlock();
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


  public void addBlock()
   {
	
	try
	{
 	
	 rs=statement.executeQuery("select block_code,block_name from block_master order by block_code");
	 
	 cbblock.addItem("---Code---   |   ---Name---");
	 while(rs.next())
	   {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbblock.addItem(cd+"           |    "+nm);

           }	 
	rs.close();

	cbvill.setEnabled(false);
	cbscno.setEnabled(false);
		
	cbblock.addActionListener(new cbListener());
      

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
     if(ae.getSource()==cbblock)
      {
	String str=String.valueOf(cbblock.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cbvill.removeActionListener(this);
	cbscno.removeActionListener(this);
	
	cbvill.setEnabled(true);
	cbscno.setEnabled(false);
	
	cbvill.removeAllItems();
	cbscno.removeAllItems();
	
	try
	 {
            rs=statement.executeQuery("select village_code,village_name from village_master where block_code='"+code+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbvill.addItem(cd+"           |    "+nm);

               }
	    rs.close();
	    cbvill.addActionListener(this);
	  }
	catch(Exception e){}
       }
 

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
	cbscno.removeActionListener(this);
	

	cbscno.setEnabled(true);	

	
	cbscno.removeAllItems();
	
	
	try
	 {
            rs=statement.executeQuery("select school_no,school_name from school_info where village_code='"+String.valueOf(code).trim()+"'");
	    while(rs.next())
	       {
			cd=rs.getString(1);
				nm=rs.getString(2);
        	cbscno.addItem(cd+"           |    "+nm);

               }
	    rs.close();
	    
	   btnSubmit.setEnabled(true);
	  }
	catch(Exception e){}
       }
       
   
    } 
  }  


 public void getSchoolCode()
  {
     String str=String.valueOf(cbscno.getSelectedItem());
	sno="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		sno=sno+ch;
	 }

  }
    
  private class btnSubmitListener implements ActionListener
     {
        public void actionPerformed(ActionEvent e)
  	 {
	    getSchoolCode(); 
	    if(fl==1)
	       {
                SchoolSearch pbs = new SchoolSearch(sno);     
	       }
	     if(fl==2)
	       {
                SchoolUpdate pbu = new SchoolUpdate(sno);     
	        
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


 /*   public static void main(String args[])
    {
       Sub_school sbf=new Sub_school(1);
    } 
  
    */
}
