//package subPkg;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SchoolUpdate extends JFrame
   {
    private JButton btnCancel,btnUpdate,btnChange;
    private JComboBox cbblock,cbvcode,cbstype;
    private JLabel lblbcode,lblvcode,lblsno,lblsnm,lblstype,lblnos,lblhod,lblHeader,lblLine,lblnot,lblNew,lblOld,lblNote;
    private JPanel pnl;
    private JTextArea tArea;
    private JTextField txtbcode,txtvcode,txtsno1,txtsno2,txtsnm1,txtsnm2,txtstype1,txtstype2,txthod1,txthod2,txtnos1,txtnos2,txtnot1,txtnot2;
    int flag;
    String cd,nm,code,scode,dcode,st1,str,str1,str2,str3,str4,str5,str6,str7,str8,pc;
    char ch;
    Statement statement;
    Connection connection;
    ResultSet rs; 
 
     public SchoolUpdate(String pcd)
      {
      	pc=pcd;
        pnl = new JPanel();
        lblHeader = new JLabel();
        lblbcode = new JLabel();
        lblvcode = new JLabel();
        lblsno=new JLabel();
        lblsnm = new JLabel();
        lblstype = new JLabel();
		lblnos= new JLabel();
        lblnot = new JLabel();
        lblhod = new JLabel();
        
        txtbcode = new JTextField();
		txtvcode = new JTextField();
		txtsno1=new JTextField();
        txtsnm1 = new JTextField();
        txtstype1 = new JTextField();
        txtnos1 = new JTextField();
		txtnot1= new JTextField();
     	txthod1= new JTextField();
        
        txtsno2 = new JTextField();
        txtsnm2 = new JTextField();
        txtstype2 = new JTextField();
		txtnos2= new JTextField();
		txtnot2= new JTextField();
        txthod2= new JTextField();
        
        btnUpdate = new JButton();
        btnCancel = new JButton();
        lblOld = new JLabel();
        lblNew = new JLabel();
        lblLine = new JLabel();
        lblNote = new JLabel();
        tArea = new JTextArea();
        btnChange = new JButton();
        cbblock = new JComboBox();
		cbvcode = new JComboBox();
		cbstype = new JComboBox();

        getContentPane().setLayout(null);
	getContentPane().setBackground(new Color(222,254,231));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Updation of School Information");
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

        lblbcode.setText("Block Code");
        getContentPane().add(lblbcode);
        lblbcode.setBounds(40, 130, 120, 20);

		lblvcode.setText("Village Code");
        getContentPane().add(lblvcode);
        lblvcode.setBounds(40, 160, 120, 20);

        lblsno.setText("School Number");
        getContentPane().add(lblsno);
        lblsno.setBounds(40, 190, 120, 20);

        lblsnm.setText("School Name");
        getContentPane().add(lblsnm);
        lblsnm.setBounds(40, 220, 120, 20);

        lblstype.setText("School Type");
        getContentPane().add(lblstype);
        lblstype.setBounds(40, 250, 130, 20);

		lblnos.setText("Number of Student");
        getContentPane().add(lblnos);
        lblnos.setBounds(40, 280, 130, 20);
        
        lblnot.setText("Number of Teacher");
        getContentPane().add(lblnot);
        lblnot.setBounds(40, 310, 130, 20);
        
        lblhod.setText("HOD Name");
        getContentPane().add(lblhod);
        lblhod.setBounds(40, 340, 130, 20);

        txtbcode.setEditable(false);
        txtbcode.setFocusable(false);
        getContentPane().add(txtbcode);
        txtbcode.setBounds(190, 130, 160, 20);

		txtvcode.setEditable(false);
        txtvcode.setFocusable(false);
        getContentPane().add(txtvcode);
        txtvcode.setBounds(190, 160, 160, 20);

        txtsno1.setEditable(false);
        txtsno1.setFocusable(false);
        getContentPane().add(txtsno1);
        txtsno1.setBounds(190, 190, 160, 20);
        
        txtsnm1.setEditable(false);
        txtsnm1.setFocusable(false);
        getContentPane().add(txtsnm1);
        txtsnm1.setBounds(190, 220, 160, 20);


        txtstype1.setEditable(false);
        txtstype1.setFocusable(false);
        getContentPane().add(txtstype1);
        txtstype1.setBounds(190, 250, 160, 20);

        txtnos1.setEditable(false);
        txtnos1.setFocusable(false);
        getContentPane().add(txtnos1);
        txtnos1.setBounds(190, 280, 160, 20);

		txtnot1.setEditable(false);
        txtnot1.setFocusable(false);
        getContentPane().add(txtnot1);
        txtnot1.setBounds(190, 310, 160, 20);
        
        txthod1.setEditable(false);
        txthod1.setFocusable(false);
        getContentPane().add(txthod1);
        txthod1.setBounds(190, 340, 160, 20);


        txtsno2.setEditable(false);
		txtsno2.setFocusable(false);
        getContentPane().add(txtsno2);
        txtsno2.setBounds(370, 190, 160, 20);

        getContentPane().add(txtsnm2);
        txtsnm2.setBounds(370, 220, 160, 20);

       // getContentPane().add(txtstype2);
        //txtstype2.setBounds(370, 250, 160, 20);
        
        getContentPane().add(txtnot2);
        txtnot2.setBounds(370, 310, 160, 20);

		getContentPane().add(txtnos2);
        txtnos2.setBounds(370, 280, 160, 20);
        
        getContentPane().add(txthod2);
        txthod2.setBounds(370, 340, 160, 20);

   
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
        btnChange.setToolTipText("Click to Change Block");
        getContentPane().add(btnChange);
        btnChange.setBounds(600, 160, 90, 23);

        cbblock.setEnabled(false);
		cbblock.setFocusable(false);
        getContentPane().add(cbblock);
        cbblock.setBounds(370, 130, 220, 22);

		cbvcode.setEnabled(false);
		cbvcode.setFocusable(false);
        getContentPane().add(cbvcode);
        cbvcode.setBounds(370, 160, 220, 22);
        
        cbstype.setEnabled(true);
        getContentPane().add(cbstype);
        cbstype.setBounds(370, 250, 160, 20);
        
        cbstype.addItem("PRIVATE");
        cbstype.addItem("GOVERMENT");
        
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

	    rs=statement.executeQuery("select * from school_info where School_no='"+pc+"'");
	    rs.next();
	    str1=rs.getString(1);
	    str2=rs.getString(2);
	    str3=rs.getString(3);
	    str4=rs.getString(4);
	     str5=rs.getString(5);
 	    str6=rs.getString(6);
 	    str7=rs.getString(7);
 	    str8=rs.getString(8);
	    rs.close();
	    
	    txtbcode.setText(str1);
	    txtvcode.setText(str2);
	    txtsno1.setText(str3);
	    txtsno2.setText(str3);
	    txtsnm1.setText(str4);
	    txtstype1.setText(str5);
	    txtnos1.setText(str6);
	    txtnot1.setText(str7);
	    txthod1.setText(str8);

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
 	
	 rs=statement.executeQuery("select block_code,block_name from block_master");
	 
	 cbblock.addItem("---Code---   |   ---Name---");
	 while(rs.next())
	   {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbblock.addItem(cd+"           |    "+nm);

           }	 
	rs.close();
	
	cbblock.setEnabled(true);
	cbvcode.setEnabled(false);
	
	cbblock.addActionListener(new cbListener());
      

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
	cbvcode.removeActionListener(this);
	

	cbvcode.setEnabled(true);

	cbvcode.removeAllItems();

	
	try
	 {
            rs=statement.executeQuery("select village_code,village_name from village_master where block_code='"+code+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbvcode.addItem(cd+"           |    "+nm);

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
         	
	   str4=txtsnm2.getText();
	   str5=String.valueOf(cbstype.getSelectedItem()).trim();
	   str6=txtnos2.getText();
	   str7=txtnot2.getText();
	   str8=txthod2.getText();
	  
		  if(str4.compareTo(blank)==0)
  	      str4=txtsnm1.getText();	
	   if(str6.compareTo(blank)==0)
	      str6=txtnos1.getText();
	   if(str7.compareTo(blank)==0)
	      str7=txtnot1.getText();
	      if(str8.compareTo(blank)==0)
	      str8=txthod1.getText();

	   if(f>=2)
	    {
		 str=String.valueOf(cbblock.getSelectedItem());
		 code="";
		 for(int i=0;i<str.length();i++)
		  {
	  	    ch=str.charAt(i);
	  	    if(String.valueOf(ch).equals(" "))
		      break;
		    code=code+ch;
	 	  }
		 str1=code;
	  	
		 str=String.valueOf(cbvcode.getSelectedItem());
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
		statement.executeUpdate("update school_info set block_code='"+str1+"',village_code='"+str2+"',SCHOOL_NAME='"+str4+"',SCHOOL_TYPE='"+str5+"',NO_OF_STUDENT='"+str6+"',NO_OF_TEACHER='"+str7+"',HOD_NAME='"+str8+"' where school_no='"+str3+"'");		
		statement.executeUpdate("commit");
		JOptionPane.showMessageDialog(null,"record updated successfully","Information",JOptionPane.INFORMATION_MESSAGE);

		}
		else
		{
	//	JOptionPane.showMessageDialog(null,"updating data flag="+f+str1+"   "+str2+"  "+str3+"  "+pc+"   "+str5+"  "+str6+"   "+str7);
		statement.executeUpdate("update school_info set SCHOOL_NAME='"+str4+"',SCHOOL_TYPE='"+str5+"',NO_OF_STUDENT='"+str6+"',NO_OF_TEACHER='"+str7+"',HOD_NAME='"+str8+"' where school_no='"+str3+"'");		
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

/*
    public static void main(String args[])
     {
        SchoolUpdate bu=new SchoolUpdate("sc01");
    }
   */ 
   
}
