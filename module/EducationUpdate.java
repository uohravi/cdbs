//package subPkg;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class EducationUpdate extends JFrame
   {
    private JButton btnCancel,btnUpdate,btnChange;
    private JComboBox cbBlock,cbPanchayat,cbVillage;
    private JLabel lblpcode,lblVcode,lbleducode,lblnml,lblnfml,lblnfmil,lblnmil,lblHeader,lblLine,lblbcode,lblNew,lblOld,lblNote;
    private JPanel pnl;
    private JTextArea tArea;
    private JTextField txtpcode,txtbcode,txtVcode,txtedcode1,txtedcode2,txtnml1,txtnml2,txtnmil1,txtnmil2,txtnfml1,txtnfml2,txtnfmil1,txtnfmil2;
    int flag;
    String cd,nm,code,scode,dcode,st1,str,str1,str2,str3,str4,str5,str6,str7,str8,vc;
    char ch;
    Statement statement;
    Connection connection;
    ResultSet rs; 
 
     public EducationUpdate(String vcd)
      {
      	vc=vcd;
        pnl = new JPanel();
        lblHeader = new JLabel();
        lblpcode = new JLabel();
        lblVcode = new JLabel();
        lbleducode=new JLabel();
        lblnml=new JLabel();
        lblnmil = new JLabel();
        lblnfml = new JLabel();
		lblnfmil= new JLabel();
        lblbcode = new JLabel();
        
        txtpcode = new JTextField();
		txtbcode = new JTextField();
		txtVcode=new JTextField();
		txtedcode1 = new JTextField();
        txtnml1 = new JTextField();
        txtnmil1 = new JTextField();
        txtnfml1 = new JTextField();
		txtnfmil1= new JTextField();
     
        
        txtedcode2 = new JTextField();
        txtnml2 = new JTextField();
        txtnmil2 = new JTextField();
		txtnfml2= new JTextField();
		txtnfmil2= new JTextField();
       
        btnUpdate = new JButton();
        btnCancel = new JButton();
        lblOld = new JLabel();
        lblNew = new JLabel();
        lblLine = new JLabel();
        lblNote = new JLabel();
        tArea = new JTextArea();
        btnChange = new JButton();
        cbPanchayat = new JComboBox();
		cbBlock = new JComboBox();
		cbVillage=new JComboBox();

        getContentPane().setLayout(null);
	getContentPane().setBackground(new Color(222,254,231));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Updation of Education Information");
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

        lblbcode.setText("Block Name");
        getContentPane().add(lblbcode);
        lblbcode.setBounds(40, 130, 120, 20);

		lblpcode.setText("Panchayat Name");
        getContentPane().add(lblpcode);
        lblpcode.setBounds(40, 160, 120, 20);

        lblVcode.setText("Village Code");
        getContentPane().add(lblVcode);
        lblVcode.setBounds(40, 190, 120, 20);

        lbleducode.setText("Education Code");
        getContentPane().add(lbleducode);
        lbleducode.setBounds(40, 220, 120, 20);
        
        lblnml.setText("NO of Male Literate");
        getContentPane().add(lblnml);
        lblnml.setBounds(40, 250, 120, 20);

        lblnmil.setText("NO of Male ILiterate");
        getContentPane().add(lblnmil);
        lblnmil.setBounds(40, 280, 130, 20);

		lblnfml.setText("NO of Female Literate");
        getContentPane().add(lblnfml);
        lblnfml.setBounds(40, 310, 130, 20);
        
        lblnfmil.setText("NO of Female ILiterate");
        getContentPane().add(lblnfmil);
        lblnfmil.setBounds(40, 340, 130, 20);

        txtbcode.setEditable(false);
        txtbcode.setFocusable(false);
        getContentPane().add(txtbcode);
        txtbcode.setBounds(190, 130, 160, 20);

		txtpcode.setEditable(false);
        txtpcode.setFocusable(false);
        getContentPane().add(txtpcode);
        txtpcode.setBounds(190, 160, 160, 20);

        txtVcode.setEditable(false);
        txtVcode.setFocusable(false);
        getContentPane().add(txtVcode);
        txtVcode.setBounds(190, 190, 160, 20);
        
        txtedcode1.setEditable(false);
        txtedcode1.setFocusable(false);
        getContentPane().add(txtedcode1);
        txtedcode1.setBounds(190, 220, 160, 20);
        
        txtnml1.setEditable(false);
        txtnml1.setFocusable(false);
        getContentPane().add(txtnml1);
        txtnml1.setBounds(190, 250, 160, 20);


        txtnmil1.setEditable(false);
        txtnmil1.setFocusable(false);
        getContentPane().add(txtnmil1);
        txtnmil1.setBounds(190, 280, 160, 20);

        txtnfml1.setEditable(false);
        txtnfml1.setFocusable(false);
        getContentPane().add(txtnfml1);
        txtnfml1.setBounds(190, 310, 160, 20);

		txtnfmil1.setEditable(false);
        txtnfmil1.setFocusable(false);
        getContentPane().add(txtnfmil1);
        txtnfmil1.setBounds(190, 340, 160, 20);


        txtedcode2.setEditable(false);
		txtedcode2.setFocusable(false);
        getContentPane().add(txtedcode2);
        txtedcode2.setBounds(370, 220, 160, 20);

        getContentPane().add(txtnml2);
        txtnml2.setBounds(370, 250, 160, 20);

        getContentPane().add(txtnmil2);
        txtnmil2.setBounds(370, 280, 160, 20);

	getContentPane().add(txtnfml2);
        txtnfml2.setBounds(370, 310, 160, 20);
        
        getContentPane().add(txtnfmil2);
        txtnfmil2.setBounds(370, 340, 160, 20);
   
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

        cbBlock.setEnabled(false);
		cbBlock.setFocusable(false);
        getContentPane().add(cbBlock);
        cbBlock.setBounds(370, 130, 220, 22);

		cbPanchayat.setEnabled(false);
		cbPanchayat.setFocusable(false);
        getContentPane().add(cbPanchayat);
        cbPanchayat.setBounds(370, 160, 220, 22);
        
        cbVillage.setEnabled(false);
		cbVillage.setFocusable(false);
        getContentPane().add(cbVillage);
        cbVillage.setBounds(370, 190, 220, 22);
        
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
 
           //st1=str;

	    rs=statement.executeQuery("select * from education_info where education_code='"+vc+"'");
	    rs.next();
	    str1=rs.getString(1);
	    str2=rs.getString(2);
	   // dcode=str2;
	    str3=rs.getString(3);
	    str4=rs.getString(4);
	     str5=rs.getString(5);
 	    str6=rs.getString(6);
 	    str7=rs.getString(7);
 	    str8=rs.getString(8);
	   // code=str1;
	    rs.close();
	   
	    txtpcode.setText(str3);
	    txtbcode.setText(str1);
	    txtVcode.setText(str2);
	    txtedcode1.setText(str4);
	    txtedcode2.setText(str4);
	    txtnml1.setText(str5);
	    txtnmil1.setText(str6);
	    txtnfml1.setText(str7);
	    txtnfmil1.setText(str8);
	   

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
	 
	 cbBlock.addItem("---Code---   |   ---Name---");
	 while(rs.next())
	   {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbBlock.addItem(cd+"           |    "+nm);

           }	 
	rs.close();
	
	cbBlock.setEnabled(true);
	cbPanchayat.setEnabled(false);
	cbVillage.setEnabled(false);
	
	cbBlock.addActionListener(new cbListener());
      

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
	cbPanchayat.removeActionListener(this);
	cbVillage.removeActionListener(this);
	
	
	cbPanchayat.setEnabled(true);
	cbVillage.setEnabled(false);

	cbPanchayat.removeAllItems();
	cbVillage.removeAllItems();

	
	try
	 {
            rs=statement.executeQuery("select panchayat_code, panchayat_name from panchayat_master where block_code='"+String.valueOf(code).trim()+"'");
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
	cbVillage.removeActionListener(this);
	

	cbVillage.setEnabled(true);

	cbVillage.removeAllItems();
	
	try
	 {
            rs=statement.executeQuery("select village_code,village_name from village_master where panchayat_code='"+String.valueOf(code).trim()+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbVillage.addItem(cd+"           |    "+nm);

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
         	
	   str5=txtnml2.getText();
	   str6=txtnmil2.getText();
	   str7=txtnfml2.getText();
	   str8=txtnfmil2.getText();
	  
		  if(str5.compareTo(blank)==0)
  	      str5=txtnml1.getText();
          if(str6.compareTo(blank)==0)
  	      str6=txtnmil1.getText();
	   if(str7.compareTo(blank)==0)
	      str7=txtnfml1.getText();
	   if(str8.compareTo(blank)==0)
	      str8=txtnfmil1.getText();

	   if(f>=2)
	    {
		 str=String.valueOf(cbBlock.getSelectedItem());
		 code="";
		 for(int i=0;i<str.length();i++)
		  {
	  	    ch=str.charAt(i);
	  	    if(String.valueOf(ch).equals(" "))
		      break;
		    code=code+ch;
	 	  }
		 str1=code;
	  	
		 str=String.valueOf(cbPanchayat.getSelectedItem());
		 code="";
		 for(int i=0;i<str.length();i++)
		  {
	  	    ch=str.charAt(i);
	  	    if(String.valueOf(ch).equals(" "))
		      break;
		    code=code+ch;
	 	  }
		 str3=code;
		 
		 str=String.valueOf(cbVillage.getSelectedItem());
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
		statement.executeUpdate("update education_info set block_code='"+str1+"',village_code='"+str2+"',panchayat_code='"+str3+"', NO_OF_MALE_LITERATE='"+str5+"',NO_OF_MALE_ILITERATE='"+str6+"',NO_OF_FEMALE_LITERATE='"+str7+"',NO_OF_FEMALE_ILITERATE='"+str8+"'  where education_code='"+str4+"'");		
		statement.executeUpdate("commit");
		JOptionPane.showMessageDialog(null,"record updated successfully","Information",JOptionPane.INFORMATION_MESSAGE);

		}
		else
		{
	//	JOptionPane.showMessageDialog(null,"updating data flag="+f+str1+"   "+str2+"  "+str3+"  "+pc+"   "+str5+"  "+str6+"   "+str7);
		statement.executeUpdate("update education_info set NO_OF_MALE_LITERATE='"+str5+"',NO_OF_MALE_ILITERATE='"+str6+"',NO_OF_FEMALE_LITERATE='"+str7+"',NO_OF_FEMALE_ILITERATE='"+str8+"'  where education_code='"+str4+"'");		
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


   /* public static void main(String args[])
     {
        EducationUpdate bu=new EducationUpdate("e001");
    }*/
    
   
}
