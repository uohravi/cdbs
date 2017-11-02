//package subPkg;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class VillageUpdate extends JFrame
   {
    private JButton btnCancel,btnUpdate,btnChange;
    private JComboBox cbdis,cbsub,cbblock,cbpanchayat;
    private JLabel lblSbcode,lblBcode,lblPcode,lblvcode,lblestd,lblmkname,lblvname,lblHeader,lblLine,lblDcode,lblNew,lblOld,lblNote;
    private JPanel pnl;
    private JTextArea tArea;
    private JTextField txtSbcode,txtDcode,txtBcode,txtPcode,txtvcode1,txtvcode2,txtvname1,txtvname2,txtmkname1,txtmkname2,txtestd1,txtestd2;
    int flag;
    String cd,nm,code,scode,dcode,st1,str,str1,str2,str3,str4,str5,str6,str7,str8,vc;
    char ch;
    Statement statement;
    Connection connection;
    ResultSet rs; 
 
     public VillageUpdate(String vcd)
      {
      	vc=vcd;
        pnl = new JPanel();
        lblHeader = new JLabel();
        lblSbcode = new JLabel();
        lblBcode = new JLabel();
        lblPcode=new JLabel();
        lblvcode=new JLabel();
        lblvname = new JLabel();
        lblestd = new JLabel();
		lblmkname= new JLabel();
        lblDcode = new JLabel();
        
        txtSbcode = new JTextField();
		txtDcode = new JTextField();
		txtBcode=new JTextField();
		txtPcode = new JTextField();
        txtvcode1 = new JTextField();
        txtvname1 = new JTextField();
        txtestd1 = new JTextField();
		txtmkname1= new JTextField();
     
        
        txtvcode2 = new JTextField();
        txtvname2 = new JTextField();
        txtestd2 = new JTextField();
		txtmkname2= new JTextField();
       
        btnUpdate = new JButton();
        btnCancel = new JButton();
        lblOld = new JLabel();
        lblNew = new JLabel();
        lblLine = new JLabel();
        lblNote = new JLabel();
        tArea = new JTextArea();
        btnChange = new JButton();
        cbsub = new JComboBox();
		cbdis = new JComboBox();
		cbblock=new JComboBox();
		cbpanchayat=new JComboBox();

        getContentPane().setLayout(null);
	getContentPane().setBackground(new Color(222,254,231));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Updation of Village Master");
        //setAlwaysOnTop(true);
        setBackground(new Color(210, 185, 224));
        setName("District Master");
        setResizable(false);
        
        pnl.setBackground(new Color(3, 116, 0));
        lblHeader.setFont(new Font("Elephant", 1, 48));
        lblHeader.setForeground(new Color(246, 185, 224));
        lblHeader.setText("Updation Form");
        //lblHeader.setHorizontalTextPosition(SwingConstants.LEADING);
        pnl.add(lblHeader);

        getContentPane().add(pnl);
        pnl.setBounds(0, 0, 700, 80);

        lblDcode.setText("District Name");
        getContentPane().add(lblDcode);
        lblDcode.setBounds(40, 130, 120, 20);

		lblSbcode.setText("Subdivision Name");
        getContentPane().add(lblSbcode);
        lblSbcode.setBounds(40, 160, 120, 20);

        lblBcode.setText("Block Code");
        getContentPane().add(lblBcode);
        lblBcode.setBounds(40, 190, 120, 20);

        lblPcode.setText("Panchayat Code");
        getContentPane().add(lblPcode);
        lblPcode.setBounds(40, 220, 120, 20);
        
        lblvcode.setText("Village Code");
        getContentPane().add(lblvcode);
        lblvcode.setBounds(40, 250, 120, 20);

        lblvname.setText("Village Name");
        getContentPane().add(lblvname);
        lblvname.setBounds(40, 280, 130, 20);

		lblestd.setText("ESTD");
        getContentPane().add(lblestd);
        lblestd.setBounds(40, 310, 130, 20);
        
        lblmkname.setText("Mukhia Name");
        getContentPane().add(lblmkname);
        lblmkname.setBounds(40, 340, 130, 20);

        txtDcode.setEditable(false);
        txtDcode.setFocusable(false);
        getContentPane().add(txtDcode);
        txtDcode.setBounds(190, 130, 160, 20);

		txtSbcode.setEditable(false);
        txtSbcode.setFocusable(false);
        getContentPane().add(txtSbcode);
        txtSbcode.setBounds(190, 160, 160, 20);

        txtBcode.setEditable(false);
        txtBcode.setFocusable(false);
        getContentPane().add(txtBcode);
        txtBcode.setBounds(190, 190, 160, 20);
        
        txtPcode.setEditable(false);
        txtPcode.setFocusable(false);
        getContentPane().add(txtPcode);
        txtPcode.setBounds(190, 220, 160, 20);
        
        txtvcode1.setEditable(false);
        txtvcode1.setFocusable(false);
        getContentPane().add(txtvcode1);
        txtvcode1.setBounds(190, 250, 160, 20);


        txtvname1.setEditable(false);
        txtvname1.setFocusable(false);
        getContentPane().add(txtvname1);
        txtvname1.setBounds(190, 280, 160, 20);

        txtestd1.setEditable(false);
        txtestd1.setFocusable(false);
        getContentPane().add(txtestd1);
        txtestd1.setBounds(190, 310, 160, 20);

		txtmkname1.setEditable(false);
        txtmkname1.setFocusable(false);
        getContentPane().add(txtmkname1);
        txtmkname1.setBounds(190, 340, 160, 20);


        txtvcode2.setEditable(false);
		txtvcode2.setFocusable(false);
        getContentPane().add(txtvcode2);
        txtvcode2.setBounds(370, 250, 160, 20);

        getContentPane().add(txtvname2);
        txtvname2.setBounds(370, 280, 160, 20);

        getContentPane().add(txtestd2);
        txtestd2.setBounds(370, 310, 160, 20);

	getContentPane().add(txtmkname2);
        txtmkname2.setBounds(370, 340, 160, 20);
   
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
        btnChange.setToolTipText("Click to Change District");
        getContentPane().add(btnChange);
        btnChange.setBounds(600, 160, 90, 23);

        cbdis.setEnabled(false);
		cbdis.setFocusable(false);
        getContentPane().add(cbdis);
        cbdis.setBounds(370, 130, 220, 22);

		cbsub.setEnabled(false);
		cbsub.setFocusable(false);
        getContentPane().add(cbsub);
        cbsub.setBounds(370, 160, 220, 22);
        
        cbblock.setEnabled(false);
		cbblock.setFocusable(false);
        getContentPane().add(cbblock);
        cbblock.setBounds(370, 190, 220, 22);
        
        cbpanchayat.setEnabled(false);
		cbpanchayat.setFocusable(false);
        getContentPane().add(cbpanchayat);
        cbpanchayat.setBounds(370, 220, 220, 22);

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

	    rs=statement.executeQuery("select * from village_master where village_code='"+vc+"'");
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
	    try
	     {
              rs=statement.executeQuery("select TO_CHAR(estd,'DD-MON-YYYY') from village_master where village_code='"+vc+"'");
	       rs.next();
	       str7=rs.getString(1);
	       rs.close();
	     }
	    catch(SQLException e2)
             {
               JOptionPane.showMessageDialog(null,"EXCEPTION"+e2);
    	     }
	    txtSbcode.setText(str2);
	    txtDcode.setText(str1);
	    txtBcode.setText(str3);
	    txtPcode.setText(str4);
	    txtvcode1.setText(str5);
	    txtvcode2.setText(str5);
	    txtvname1.setText(str6.toUpperCase());
	    txtestd1.setText(str7);
	    txtmkname1.setText(str8);
	   

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
 	
	 rs=statement.executeQuery("select District_code,District_name from District_master");
	 
	 cbdis.addItem("---Code---   |   ---Name---");
	 while(rs.next())
	   {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbdis.addItem(cd+"           |    "+nm);

           }	 
	rs.close();
	
	cbdis.setEnabled(true);
	cbsub.setEnabled(false);
	cbblock.setEnabled(false);
	cbpanchayat.setEnabled(false);
	
	cbdis.addActionListener(new cbListener());
      

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
     if(ae.getSource()==cbdis)
      {
	String str=String.valueOf(cbdis.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cbsub.removeActionListener(this);
	cbblock.removeActionListener(this);
	cbpanchayat.removeActionListener(this);
	
	
	cbsub.setEnabled(true);
	cbblock.setEnabled(false);
	cbpanchayat.setEnabled(false);

	cbsub.removeAllItems();
	cbblock.removeAllItems();
	cbpanchayat.removeAllItems();

	
	try
	 {
            rs=statement.executeQuery("select subdiv_code, subdiv_name from subdivision_master where district_code='"+String.valueOf(code).trim()+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbsub.addItem(cd+"           |    "+nm);

               }
	    rs.close();
	    cbsub.addActionListener(this);
	  }
	catch(Exception e){}
       }
 

      if(ae.getSource()==cbsub)
      {
	String str=String.valueOf(cbsub.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cbblock.removeActionListener(this);
	cbpanchayat.removeActionListener(this);
	

	cbblock.setEnabled(true);
	cbpanchayat.setEnabled(false);

	cbblock.removeAllItems();
	cbpanchayat.removeAllItems();
	
	try
	 {
            rs=statement.executeQuery("select block_code,block_name from block_master where subdiv_code='"+String.valueOf(code).trim()+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbblock.addItem(cd+"           |    "+nm);

               }
	    rs.close();
	    cbblock.addActionListener(this);
	  }
	catch(Exception e){}
      
       }
       
        if(ae.getSource()==cbblock)
      {
      	//JOptionPane.showMessageDialog(null,"in block");
	String str=String.valueOf(cbblock.getSelectedItem());
	code="";
	for(int i=0;i<str.length();i++)
	 {
	   ch=str.charAt(i);
	   if(String.valueOf(ch).equals(" "))
		break;
		code=code+ch;
	 }
	cbpanchayat.removeActionListener(this);
	
	cbpanchayat.setEnabled(true);

	cbpanchayat.removeAllItems();
	
	try
	 {
            rs=statement.executeQuery("select panchayat_code,panchayat_name from panchayat_master where block_code='"+String.valueOf(code).trim()+"'");
	    while(rs.next())
	       {
		cd=rs.getString(1);
		nm=rs.getString(2);
        	cbpanchayat.addItem(cd+"           |    "+nm);

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
	   
	   str6=txtvname2.getText();
	   str7=txtestd2.getText();
	   str8=txtmkname2.getText();
	  
		
          if(str6.compareTo(blank)==0)
  	      str6=txtvname1.getText();
	   if(str7.compareTo(blank)==0)
	      str7=txtestd1.getText();
	   if(str8.compareTo(blank)==0)
	      str8=txtmkname1.getText();

	   if(f>=2)
	    {
		 str=String.valueOf(cbdis.getSelectedItem());
		 code="";
		 for(int i=0;i<str.length();i++)
		  {
	  	    ch=str.charAt(i);
	  	    if(String.valueOf(ch).equals(" "))
		      break;
		    code=code+ch;
	 	  }
		 str1=code;
	  	
		 str=String.valueOf(cbsub.getSelectedItem());
		 code="";
		 for(int i=0;i<str.length();i++)
		  {
	  	    ch=str.charAt(i);
	  	    if(String.valueOf(ch).equals(" "))
		      break;
		    code=code+ch;
	 	  }
		 str2=code;
		 
		 str=String.valueOf(cbblock.getSelectedItem());
		 code="";
		 for(int i=0;i<str.length();i++)
		  {
	  	    ch=str.charAt(i);
	  	    if(String.valueOf(ch).equals(" "))
		      break;
		    code=code+ch;
	 	  }
		 str3=code;
		 str=String.valueOf(cbpanchayat.getSelectedItem());
		 code="";
		 for(int i=0;i<str.length();i++)
		  {
	  	    ch=str.charAt(i);
	  	    if(String.valueOf(ch).equals(" "))
		      break;
		    code=code+ch;
	 	  }
		 str4=code;
	//	JOptionPane.showMessageDialog(null,"updating data flag="+f+str1+"   "+str2+"  "+str3+"  "+str4+"   "+str5+"  "+str6+"   "+str7);
		statement.executeUpdate("update village_master set district_code='"+str1+"',subdiv_code='"+str2+"',block_code='"+str3+"',panchayat_code='"+str4+"',village_name='"+str6+"',estd='"+str7+"',mukhia_name='"+str8+"'where village_code='"+vc+"'");		
		statement.executeUpdate("commit");
		JOptionPane.showMessageDialog(null,"record updated successfully","Information",JOptionPane.INFORMATION_MESSAGE);

		}
		else
		{
	//	JOptionPane.showMessageDialog(null,"updating data flag="+f+str1+"   "+str2+"  "+str3+"  "+pc+"   "+str5+"  "+str6+"   "+str7);
		statement.executeUpdate("update village_master set district_code='"+str1+"',subdiv_code='"+str2+"',block_code='"+str3+"',panchayat_code='"+str4+"',village_name='"+str6+"',estd='"+str7+"',mukhia_name='"+str8+"'where village_code='"+vc+"'");		
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


  /*  public static void main(String args[])
     {
        VillageUpdate bu=new VillageUpdate("v124");
    }
    */
   
}
