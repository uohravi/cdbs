package submodule1;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LandUpdate extends JFrame
   {
    private JButton btnCancel,btnUpdate,btnChange;
    private JComboBox cbvcd,cbinv;
    private JLabel lblvcd,lblinv,lbllno,lbllacr,lblir,lblnir,lblHeader,lblLine,lblha,lblNew,lblOld,lblNote;
    private JPanel pnl;
    private JTextArea tArea;
    private JTextField txtvcd,txtinv,txtlno1,txtlno2,txtlacr1,txtlacr2,txtir1,txtir2,txtnir1,txtnir2,txtha1,txtha2;
    int flag;
    String cd,nm,code,scode,dcode,st1,str,str1,str2,str3,str4,str5,str6,str7,pc;
    char ch;
    Statement statement;
    Connection connection;
    ResultSet rs; 
 
     public LandUpdate(String pcd)
      {
      	pc=pcd;
        pnl = new JPanel();
        lblHeader = new JLabel();
        lblvcd = new JLabel();
        lblinv = new JLabel();
        lbllno=new JLabel();
        lbllacr = new JLabel();
        lblir = new JLabel();
		lblnir= new JLabel();
        lblha = new JLabel();
        
        txtvcd = new JTextField();
		txtinv = new JTextField();
		txtlno1=new JTextField();
        txtlacr1 = new JTextField();
        txtir1 = new JTextField();
        txtnir1 = new JTextField();
		txtha1= new JTextField();
     
        
        txtlno2 = new JTextField();
        txtlacr2 = new JTextField();
        txtir2 = new JTextField();
		txtnir2= new JTextField();
		txtha2= new JTextField();
       
        btnUpdate = new JButton();
        btnCancel = new JButton();
        lblOld = new JLabel();
        lblNew = new JLabel();
        lblLine = new JLabel();
        lblNote = new JLabel();
        tArea = new JTextArea();
        btnChange = new JButton();
        cbvcd = new JComboBox();
		cbinv = new JComboBox();


        getContentPane().setLayout(null);
	getContentPane().setBackground(new Color(222,254,231));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Updation of Land Master");
        //setAlwaysOnTop(true);
        setBackground(new Color(210, 185, 224));
        setResizable(false);
        
        pnl.setBackground(new Color(3, 116, 0));
        lblHeader.setFont(new Font("Elephant", 1, 48));
        lblHeader.setForeground(new Color(246, 185, 224));
        lblHeader.setText("Updation Form");
        //lblHeader.setHorizontalTextPosition(SwingConstants.LEADING);
        pnl.add(lblHeader);

        getContentPane().add(pnl);
        pnl.setBounds(0, 0, 700, 80);

        lblvcd.setText("Village Code");
        getContentPane().add(lblvcd);
        lblvcd.setBounds(40, 130, 120, 20);

		lblinv.setText("Individual Information Number");
        getContentPane().add(lblinv);
        lblinv.setBounds(40, 160, 120, 20);

        lbllno.setText("Land Number");
        getContentPane().add(lbllno);
        lbllno.setBounds(40, 190, 120, 20);

        lbllacr.setText("Land in Acre");
        getContentPane().add(lbllacr);
        lbllacr.setBounds(40, 220, 120, 20);

        lblir.setText("Irrigated Land");
        getContentPane().add(lblir);
        lblir.setBounds(40, 250, 130, 20);

		lblnir.setText("Non Irrigated Land");
        getContentPane().add(lblnir);
        lblnir.setBounds(40, 280, 130, 20);
        
        lblha.setText("House Area");
        getContentPane().add(lblha);
        lblha.setBounds(40, 310, 130, 20);

        txtvcd.setEditable(false);
        txtvcd.setFocusable(false);
        getContentPane().add(txtvcd);
        txtvcd.setBounds(190, 130, 160, 20);

		txtinv.setEditable(false);
        txtinv.setFocusable(false);
        getContentPane().add(txtinv);
        txtinv.setBounds(190, 160, 160, 20);

        txtlno1.setEditable(false);
        txtlno1.setFocusable(false);
        getContentPane().add(txtlno1);
        txtlno1.setBounds(190, 190, 160, 20);
        
        txtlacr1.setEditable(false);
        txtlacr1.setFocusable(false);
        getContentPane().add(txtlacr1);
        txtlacr1.setBounds(190, 220, 160, 20);


        txtir1.setEditable(false);
        txtir1.setFocusable(false);
        getContentPane().add(txtir1);
        txtir1.setBounds(190, 250, 160, 20);

        txtnir1.setEditable(false);
        txtnir1.setFocusable(false);
        getContentPane().add(txtnir1);
        txtnir1.setBounds(190, 280, 160, 20);

		txtha1.setEditable(false);
        txtha1.setFocusable(false);
        getContentPane().add(txtha1);
        txtha1.setBounds(190, 310, 160, 20);


        txtlno2.setEditable(false);
		txtlno2.setFocusable(false);
        getContentPane().add(txtlno2);
        txtlno2.setBounds(370, 190, 160, 20);

        getContentPane().add(txtlacr2);
        txtlacr2.setBounds(370, 220, 160, 20);

        getContentPane().add(txtir2);
        txtir2.setBounds(370, 250, 160, 20);
        
        getContentPane().add(txtha2);
        txtha2.setBounds(370, 310, 160, 20);

	getContentPane().add(txtnir2);
        txtnir2.setBounds(370, 280, 160, 20);
   
        btnUpdate.setText("Update");
        getContentPane().add(btnUpdate);
        btnUpdate.setBounds(190, 370, 160, 30);

        btnCancel.setText("Cancel");
        getContentPane().add(btnCancel);
        btnCancel.setBounds(370, 370, 160, 30);

        lblOld.setForeground(new Color(115, 115, 252));
        lblOld.setText("Old Data");
        getContentPane().add(lblOld);
        lblOld.setBounds(240, 100, 80, 14);

        lblNew.setForeground(new Color(115, 115, 252));
        lblNew.setText("New Data");
        getContentPane().add(lblNew);
        lblNew.setBounds(420, 100, 80, 14);

        lblLine.setText("====================================================================================================");
        getContentPane().add(lblLine);
        lblLine.setBounds(0, 430, 700, 14);

        lblNote.setForeground(new Color(0, 0, 204));
        lblNote.setText("NOTE :-");
        getContentPane().add(lblNote);
        lblNote.setBounds(0, 440, 60, 20);

        tArea.setBackground(new Color(222, 254, 231));
        tArea.setEditable(false);
        tArea.setForeground(new Color(0, 0, 204));
        tArea.setText("If you leave the \"New Data\" fields blank then it automatically insert old data into the record after click on Update button. \nIf you do not want to insert old data automatically then you must fill with a 'space' or dots(....)");
        tArea.setFocusable(false);
        getContentPane().add(tArea);
        tArea.setBounds(50, 440, 650, 60);

        btnChange.setText("Change");
		btnChange.setFocusable(false);
        btnChange.setToolTipText("Click to Change Village");
        getContentPane().add(btnChange);
        btnChange.setBounds(600, 160, 90, 23);

        cbvcd.setEnabled(false);
		cbvcd.setFocusable(false);
        getContentPane().add(cbvcd);
        cbvcd.setBounds(370, 130, 220, 22);

		cbinv.setEnabled(false);
		cbinv.setFocusable(false);
        getContentPane().add(cbinv);
        cbinv.setBounds(370, 160, 220, 22);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-709)/2, (screenSize.height-505)/2, 709, 505);

	connect();
	btnUpdate.addActionListener(new btnUpdateListener());
	btnCancel.addActionListener(new btnCancelListener());
	btnChange.addActionListener(new btnChangeListener());
		getdata();

	flag=0;
	setVisible(true);
    }

   public void connect()
    {	
     try
      {
       try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          connection = DriverManager.getConnection("jdbc:odbc:home", "system", "manager");
	  statement = connection.createStatement();
	  //JOptionPane.showMessageDialog(null,"connected");
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

    private void getdata()
       {
	try
         {

	    rs=statement.executeQuery("select * from Land_info where Land_info_no='"+pc+"'");
	    rs.next();
	    str1=rs.getString(1);
	    str2=rs.getString(2);
	    str3=rs.getString(3);
	    str4=rs.getString(4);
	     str5=rs.getString(5);
 	    str6=rs.getString(6);
 	    str7=rs.getString(7);
	    rs.close();
	    
	    txtvcd.setText(str1);
	    txtinv.setText(str2);
	    txtlno1.setText(str3);
	    txtlno2.setText(str3);
	    txtlacr1.setText(str4);
	    txtir1.setText(str5);
	    txtnir1.setText(str6);
	    txtha1.setText(str7);
	   

	  }
	 catch(SQLException e)
          {
            	JOptionPane.showMessageDialog(null,"EXCEPTION"+e);
    	  }
        }

   private class btnUpdateListener implements ActionListener
     {
	public void actionPerformed(ActionEvent e)
	   {
	      flag=flag+1;
	     // JOptionPane.showMessageDialog(null,"in update");
	      UpdateData(flag);
	   }
     }

   private class btnChangeListener implements ActionListener
     {
	public void actionPerformed(ActionEvent e)
	   {
	      flag=1;
	      try
	{
 	
	 rs=statement.executeQuery("select village_code,village_name from village_master");
	 
	 cbvcd.addItem("---Code---   |   ---Name---");
	 while(rs.next())
	   {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbvcd.addItem(cd+"           |    "+nm);

           }	 
	rs.close();
	
	cbvcd.setEnabled(true);
	cbinv.setEnabled(false);
	
	cbvcd.addActionListener(new cbListener());
      

        }
	
       catch(SQLException sqle)
	{
		JOptionPane.showMessageDialog(null,"error:-not found"+e);
	}        
   }
  }


private class cbListener implements ActionListener
 {
  public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource()==cbvcd)
      {
	String str=String.valueOf(cbvcd.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cbinv.removeActionListener(this);
	

	cbinv.setEnabled(true);

	cbinv.removeAllItems();

	
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
	  }
	catch(Exception e){}
       }
 

    
    } 
  }  


  
  private void UpdateData(int f)
     {
	String blank;
	blank="";	  
	try
         {
         	getdata();
         	
	   str4=txtlacr2.getText();
	   str5=txtir2.getText();
	   str6=txtnir2.getText();
	   str7=txtha2.getText();
	  
		  if(str4.compareTo(blank)==0)
  	      str4=txtlacr1.getText();	
          if(str5.compareTo(blank)==0)
  	      str5=txtir1.getText();
	   if(str6.compareTo(blank)==0)
	      str6=txtnir1.getText();
	   if(str7.compareTo(blank)==0)
	      str7=txtha1.getText();

	   if(f>=2)
	    {
		 str=String.valueOf(cbvcd.getSelectedItem());
		 code="";
		 for(int i=0;i<str.length();i++)
		  {
	  	    ch=str.charAt(i);
	  	    if(String.valueOf(ch).equals(" "))
		      break;
		    code=code+ch;
	 	  }
		 str1=code;
	  	
		 str=String.valueOf(cbinv.getSelectedItem());
		 code="";
		 for(int i=0;i<str.length();i++)
		  {
	  	    ch=str.charAt(i);
	  	    if(String.valueOf(ch).equals(" "))
		      break;
		    code=code+ch;
	 	  }
		 str2=code;
	//	JOptionPane.showMessageDialog(null,"updating data flag="+f+str1+"   "+str2+"  "+str3+"  "+str4+"   "+str5+"  "+str6+"   "+str7);
		statement.executeUpdate("update land_info set village_code='"+str1+"',individual_info_no='"+str2+"',LAND_IN_ACRE='"+str4+"',IRRIGATED_LAND='"+str5+"',NON_IRRIGATED_LAND='"+str6+"',HOUSE_AREA='"+str7+"' where land_info_no='"+str3+"'");		
		statement.executeUpdate("commit");
		JOptionPane.showMessageDialog(null,"record updated successfully","Information",JOptionPane.INFORMATION_MESSAGE);

		}
		else
		{
	//	JOptionPane.showMessageDialog(null,"updating data flag="+f+str1+"   "+str2+"  "+str3+"  "+pc+"   "+str5+"  "+str6+"   "+str7);
		statement.executeUpdate("update land_info set village_code='"+str1+"',individual_info_no='"+str2+"',LAND_IN_ACRE='"+str4+"',IRRIGATED_LAND='"+str5+"',NON_IRRIGATED_LAND='"+str6+"',HOUSE_AREA='"+str7+"' where land_info_no='"+str3+"'");		
		statement.executeUpdate("commit");
		JOptionPane.showMessageDialog(null,"record updated successfully","Information",JOptionPane.INFORMATION_MESSAGE);
	}
 	  
	  }
	catch(SQLException sqle)
	  {
	    JOptionPane.showMessageDialog(null,"could not Update "+sqle);
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
        LandUpdate bu=new LandUpdate("l25");
    }
    */
   
}
