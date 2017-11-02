package submodule1;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BlockUpdate extends JFrame
   {
    private JButton btnCancel,btnUpdate,btnChange;
    private JComboBox cbdis,cbsub;
    private JLabel lblSbcode,lblBcode,lblestd,lblmkname,lblBname,lblHeader,lblLine,lblDcode,lblNew,lblOld,lblNote;
    private JPanel pnl;
    private JTextArea tArea;
    private JTextField txtSbcode,txtDcode,txtBcode1,txtBcode2,txtBname1,txtBname2,txtmkname1,txtmkname2,txtestd1,txtestd2;
    int flag;
    String cd,nm,code,scode,dcode,st1,str,str1,str2,str3,str4,str5,str6,str7,bc;
    char ch;
    Double Area,BArea,DArea,TBArea;
    Statement statement;
    Connection connection;
    ResultSet rs; 
 
     public BlockUpdate(String bcd)
      {
      	bc=bcd;
        pnl = new JPanel();
        lblHeader = new JLabel();
        lblSbcode = new JLabel();
        lblBcode = new JLabel();
        lblBname = new JLabel();
        lblestd = new JLabel();
		lblmkname= new JLabel();
        lblDcode = new JLabel();
        
        txtSbcode = new JTextField();
		txtDcode = new JTextField();
		txtBcode1=new JTextField();
        txtBname1 = new JTextField();
        txtestd1 = new JTextField();
		txtmkname1= new JTextField();
     
        
        txtBcode2 = new JTextField();
        txtBname2 = new JTextField();
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

        getContentPane().setLayout(null);
	getContentPane().setBackground(new Color(222,254,231));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Updation of Block Master");
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

        lblDcode.setText("District Name");
        getContentPane().add(lblDcode);
        lblDcode.setBounds(40, 130, 120, 20);

		lblSbcode.setText("Subdivision Name");
        getContentPane().add(lblSbcode);
        lblSbcode.setBounds(40, 160, 120, 20);

        lblBcode.setText("Block Code");
        getContentPane().add(lblBcode);
        lblBcode.setBounds(40, 190, 120, 20);

        lblBname.setText("Block Name");
        getContentPane().add(lblBname);
        lblBname.setBounds(40, 220, 130, 20);

		lblestd.setText("ESTD");
        getContentPane().add(lblestd);
        lblestd.setBounds(40, 250, 130, 20);
        
        lblmkname.setText("BDO Name");
        getContentPane().add(lblmkname);
        lblmkname.setBounds(40, 280, 130, 20);

        txtDcode.setEditable(false);
        txtDcode.setFocusable(false);
        getContentPane().add(txtDcode);
        txtDcode.setBounds(190, 130, 160, 20);

		txtSbcode.setEditable(false);
        txtSbcode.setFocusable(false);
        getContentPane().add(txtSbcode);
        txtSbcode.setBounds(190, 160, 160, 20);

        txtBcode1.setEditable(false);
        txtBcode1.setFocusable(false);
        getContentPane().add(txtBcode1);
        txtBcode1.setBounds(190, 190, 160, 20);
        
        txtBname1.setEditable(false);
        txtBname1.setFocusable(false);
        getContentPane().add(txtBname1);
        txtBname1.setBounds(190, 220, 160, 20);

        txtestd1.setEditable(false);
        txtestd1.setFocusable(false);
        getContentPane().add(txtestd1);
        txtestd1.setBounds(190, 250, 160, 20);

		txtmkname1.setEditable(false);
        txtmkname1.setFocusable(false);
        getContentPane().add(txtmkname1);
        txtmkname1.setBounds(190, 280, 160, 20);


        txtBcode2.setEditable(false);
		txtBcode2.setFocusable(false);
        getContentPane().add(txtBcode2);
        txtBcode2.setBounds(370, 190, 160, 20);

        getContentPane().add(txtBname2);
        txtBname2.setBounds(370, 220, 160, 20);

        getContentPane().add(txtestd2);
        txtestd2.setBounds(370, 250, 160, 20);
        
       // getContentPane().add(txtestd22);
      //  txtDecDate2.setBounds(370, 280, 160, 20);

	getContentPane().add(txtmkname2);
        txtmkname2.setBounds(370, 280, 160, 20);
   
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

	    rs=statement.executeQuery("select * from block_master where block_code='"+bc+"'");
	    rs.next();
	    str1=rs.getString(1);
	    str2=rs.getString(2);
	   // dcode=str2;
	    str3=rs.getString(3);
	    str4=rs.getString(4);
	     str5=rs.getString(5);
 	    str6=rs.getString(6);
	   // code=str1;
	    rs.close();
	   /* try
	     {
		rs=statement.executeQuery("select state_name from state_master where state_code='"+String.valueOf(str1).trim()+"'");
	   	rs.next();
	   	str1=rs.getString(1).toUpperCase();
		rs.close();
	     }
	    catch(SQLException e1)
             {
            	JOptionPane.showMessageDialog(null,"EXCEPTION"+e1);
    	     }

	    code=str2;
	   
	    try
	     {
		rs=statement.executeQuery("select district_name from district_master where district_code='"+String.valueOf(str2).trim()+"'");
	   	rs.next();
	   	str2=rs.getString(1).toUpperCase();
		rs.close();
	     }
	    catch(SQLException e2)
             {
            	JOptionPane.showMessageDialog(null,"EXCEPTION"+e2);
    	     }*/

	    try
	     {
              rs=statement.executeQuery("select TO_CHAR(estd,'DD-MON-YYYY') from block_master where block_code='"+bc+"'");
	       rs.next();
	       str5=rs.getString(1);
	       rs.close();
	     }
	    catch(SQLException e2)
             {
               JOptionPane.showMessageDialog(null,"EXCEPTION"+e2);
    	     }
	    txtSbcode.setText(str2);
	    txtDcode.setText(str1);
	    txtBcode1.setText(str3);
	    txtBcode2.setText(str3);
	    txtBname1.setText(str4.toUpperCase());
	    txtestd1.setText(str5);
	    txtmkname1.setText(str6);
	   

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
	
	cbsub.setEnabled(true);

	cbsub.removeAllItems();

	
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
	   
	   str4=txtBname2.getText();
	   str5=txtestd2.getText();
	   str6=txtmkname2.getText();
	  
		
          if(str4.compareTo(blank)==0)
  	      str4=txtBname1.getText();
	   if(str5.compareTo(blank)==0)
	      str5=txtestd1.getText();
	   if(str6.compareTo(blank)==0)
	      str6=txtmkname1.getText();

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
		 
		 
	//	JOptionPane.showMessageDialog(null,"updating data flag="+f+str1+"   "+str2+"  "+str3+"  "+str4+"   "+str5+"  "+str6+"   "+str7);
		statement.executeUpdate("update block_master set district_code='"+str1+"',subdiv_code='"+str2+"',block_name='"+str4+"',estd='"+str5+"',bdo_name='"+str6+"'where block_code='"+str3+"'");		
		statement.executeUpdate("commit");
		JOptionPane.showMessageDialog(null,"record updated successfully","Information",JOptionPane.INFORMATION_MESSAGE);

		}
		else
		{
	//	JOptionPane.showMessageDialog(null,"updating data flag="+f+str1+"   "+str2+"  "+str3+"  "+pc+"   "+str5+"  "+str6+"   "+str7);
	statement.executeUpdate("update block_master set block_name='"+str4+"',estd='"+str5+"',bdo_name='"+str6+"'where block_code='"+str3+"'");		
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


/*    public static void main(String args[])
     {
        BlockUpdate bu=new BlockUpdate("b126");
    }*/
    
   
}
