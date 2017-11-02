//package subPkg;
import java.lang.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class Sub_block extends JFrame
 {
     private JComboBox cbBlock,cbDistrict,cbSubdiv;
     private JLabel lblBlock,lblDistrict,lblHeader,lblSubdiv;
     private JButton btnCancel,btnSubmit;
     Dimension screenSize;
     Statement statement;
     Connection connection;
     ResultSet rs;
     String cd,nm,code,bcode,sf;
     int fl;
     char x,ch;	

     
    public Sub_block(int flg)
      {
      	fl=flg;
        cbDistrict = new JComboBox();
        cbBlock = new JComboBox();
        cbSubdiv = new JComboBox();
       
        lblDistrict = new JLabel();
        lblBlock = new JLabel();
        lblSubdiv=new JLabel();
        
        lblHeader = new JLabel();
        btnSubmit = new JButton();
        btnCancel = new JButton();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Submit Entry");
        //setAlwaysOnTop(true);
        setResizable(false);
        
        getContentPane().add(cbDistrict);
	cbDistrict.setMaximumRowCount(5);
        cbDistrict.setBounds(180, 80, 220, 22);

        getContentPane().add(cbSubdiv);
	cbSubdiv.setMaximumRowCount(5);
        cbSubdiv.setBounds(180, 110, 220, 22);

        getContentPane().add(cbBlock);
	cbBlock.setMaximumRowCount(5);
        cbBlock.setBounds(180, 140, 220, 22);


        lblDistrict.setText("District Name");
        getContentPane().add(lblDistrict);
        lblDistrict.setBounds(40, 80, 90, 20);

        lblSubdiv.setText("Subdivision Name");
        getContentPane().add(lblSubdiv);
        lblSubdiv.setBounds(40, 110, 120, 20);

        lblBlock.setText("Block Name");
        getContentPane().add(lblBlock);
        lblBlock.setBounds(40, 140, 110, 20);
        
      
        lblHeader.setFont(new Font("Forte", 0, 36));
        lblHeader.setForeground(new Color(190, 90, 54));
        lblHeader.setText("Select  Block");
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
 	
	 rs=statement.executeQuery("select District_code,District_name from District_master order by district_code");
	 
	 cbDistrict.addItem("---Code---   |   ---Name---");
	 while(rs.next())
	   {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbDistrict.addItem(cd+"           |    "+nm);

           }	 
	rs.close();

	cbSubdiv.setEnabled(false);
	cbBlock.setEnabled(false);
	
	
	cbDistrict.addActionListener(new cbListener());
      

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
     if(ae.getSource()==cbDistrict)
      {
	String str=String.valueOf(cbDistrict.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cbSubdiv.removeActionListener(this);
	cbBlock.removeActionListener(this);
	
	
	
	cbSubdiv.setEnabled(true);
	cbBlock.setEnabled(false);
	
	cbSubdiv.removeAllItems();
	cbBlock.removeAllItems();
	
	
	try
	 {
            rs=statement.executeQuery("select subdiv_code, subdiv_name from subdivision_master where district_code='"+String.valueOf(code).trim()+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbSubdiv.addItem(cd+"           |    "+nm);

               }
	    rs.close();
	    cbSubdiv.addActionListener(this);
	  }
	catch(Exception e){}
       }
 

      if(ae.getSource()==cbSubdiv)
      {
	String str=String.valueOf(cbSubdiv.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cbBlock.removeActionListener(this);
	

	cbBlock.setEnabled(true);	

	
	cbBlock.removeAllItems();
	
	
	try
	 {
            rs=statement.executeQuery("select block_code,block_name from block_master where subdiv_code='"+String.valueOf(code).trim()+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbBlock.addItem(cd+"           |    "+nm);

               }
	    rs.close();
	    
	   btnSubmit.setEnabled(true);
	  }
	catch(Exception e){}
       }
       
   
    } 
  }  


 public void getBlockCode()
  {
     String str=String.valueOf(cbBlock.getSelectedItem());
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
	    getBlockCode(); 
	    if(fl==1)
	       {
                BlockSearch pbs = new BlockSearch(bcode);     
	//	pbs.getdata(Bcode);
	       }
	     if(fl==2)
	       {
                BlockUpdate pbu = new BlockUpdate(bcode);     
	        
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
       Sub_block sbf=new Sub_block(2);
    } 
  */
    
}
