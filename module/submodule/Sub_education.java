package submodule;
import submodule1.*;
import java.lang.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class Sub_education extends JFrame
 {
     private JComboBox cbBlock,cbvill,cbPanchayat,cbedu;
     private JLabel lblBlock,lblVill,lblPanchayat,lblHeader,lblEdu;
     private JButton btnCancel,btnSubmit;
     Dimension screenSize;
     Statement statement;
     Connection connection;
     ResultSet rs;
     String cd,nm,code,pcode,sf;
     int fl;
     char x,ch;	

     
    public Sub_education(int flg)
      {
      	fl=flg;
        cbPanchayat = new JComboBox();
        cbvill = new JComboBox();
        cbBlock = new JComboBox();
        cbedu = new JComboBox();
       
        lblPanchayat = new JLabel();
        lblVill = new JLabel();
        lblBlock = new JLabel();
        lblEdu=new JLabel();
        
        lblHeader = new JLabel();
        btnSubmit = new JButton();
        btnCancel = new JButton();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Submit Entry");
        //setAlwaysOnTop(true);
        setResizable(false);

        getContentPane().add(cbBlock);
	cbBlock.setMaximumRowCount(5);
        cbBlock.setBounds(180, 80, 220, 22);
        
        getContentPane().add(cbPanchayat);
	cbPanchayat.setMaximumRowCount(5);
        cbPanchayat.setBounds(180, 110, 220, 22);
        
         getContentPane().add(cbvill);
	cbvill.setMaximumRowCount(5);
        cbvill.setBounds(180, 140, 220, 22);
        
        getContentPane().add(cbedu);
	cbedu.setMaximumRowCount(5);
        cbedu.setBounds(180, 170, 220, 22);


        lblBlock.setText("Block Name");
        getContentPane().add(lblBlock);
        lblBlock.setBounds(40, 80, 110, 20);
        
        lblPanchayat.setText("Panchayat Name");
        getContentPane().add(lblPanchayat);
        lblPanchayat.setBounds(40, 110, 110, 20);
        
        lblVill.setText("Village Name");
        getContentPane().add(lblVill);
        lblVill.setBounds(40, 140, 90, 20);

        lblEdu.setText("Education Name");
        getContentPane().add(lblEdu);
        lblEdu.setBounds(40, 170, 120, 20);

        lblHeader.setFont(new Font("Forte", 0, 36));
        lblHeader.setForeground(new Color(190, 90, 54));
        lblHeader.setText("Select  Education Code");
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
 	
	 rs=statement.executeQuery("select block_code,block_name from block_master order by block_code");
	 
	 cbBlock.addItem("---Code---   |   ---Name---");
	 while(rs.next())
	   {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbBlock.addItem(cd+"           |    "+nm);

           }	 
	rs.close();

	cbvill.setEnabled(false);
	cbedu.setEnabled(false);
	cbPanchayat.setEnabled(false);
	
	
	cbBlock.addActionListener(new cbListener());
      

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
     if(ae.getSource()==cbBlock)
      {
	String str=String.valueOf(cbBlock.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cbvill.removeActionListener(this);
	cbedu.removeActionListener(this);
	cbPanchayat.removeActionListener(this);
	
	
	
	cbvill.setEnabled(false);
	cbedu.setEnabled(false);
	cbPanchayat.setEnabled(true);
	
	cbvill.removeAllItems();
	cbedu.removeAllItems();
	cbPanchayat.removeAllItems();
	
	
	try
	 {
            rs=statement.executeQuery("select Panchayat_code, Panchayat_name from Panchayat_master where Block_code='"+String.valueOf(code).trim()+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbPanchayat.addItem(cd+"           |    "+nm);

               }
	    rs.close();
	    cbPanchayat.addActionListener(this);
	  }
	catch(Exception e){}
       }
 

      if(ae.getSource()==cbPanchayat)
      {
	String str=String.valueOf(cbPanchayat.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cbvill.removeActionListener(this);
	cbedu.removeActionListener(this);
	

	cbvill.setEnabled(true);
	cbedu.setEnabled(false);
	

	
	cbvill.removeAllItems();
	cbedu.removeAllItems();
	
	
	try
	 {
            rs=statement.executeQuery("select village_code,village_name from village_master where Panchayat_code='"+String.valueOf(code).trim()+"'");
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
	cbedu.removeActionListener(this);
	

	cbedu.setEnabled(true);
	

	
	cbedu.removeAllItems();
	
	
	try
	 {
            rs=statement.executeQuery("select education_code from education_info where village_code='"+String.valueOf(code).trim()+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
        	cbedu.addItem(cd);

               }
	    rs.close();
	    btnSubmit.setEnabled(true);
	  }
	catch(Exception e){}
       }
    } 
  }  


 public void getEducationCode()
  {
     
		pcode=String.valueOf(cbedu.getSelectedItem()).trim();
	 }

  
    
  private class btnSubmitListener implements ActionListener
     {
        public void actionPerformed(ActionEvent e)
  	 {
	    getEducationCode(); 
	    if(fl==1)
	       {
                EducationSearch pbs = new EducationSearch(pcode);     
	       }
	     if(fl==2)
	       {
                EducationUpdate pbu = new EducationUpdate(pcode);     
	        
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

	/*	public static void main(String args[])
		{
			Sub_education se=new Sub_education(1);
		}
    */
}
