//package anishpackage;

import java.sql.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Village_wise_IndividualInformation_Report extends JFrame implements ActionListener
{

	private Container myContainer;
	Connection myConnection;
	Statement myStatement;
	ResultSet rs;
	int c;
	String []colname={"Village Code","Village Name","Individual_Info_No","Name","NO_OF_FAMILY_MEMBER","NO_OF_MALE","NO_OF_FEMALE","NO_OF_CHILD","OCCUPATION","ORGANISATION_NAME","POST_HELD","ANNUAL_INCOME","POVERTY_STATUS","DOB","REMARKS"};
	
	JPanel jptle,jpr,jpnlbtn;
	JButton jbtn1,jbtn2;
	JLabel lbl;
	JTextArea status;

public Village_wise_IndividualInformation_Report()
{

		super("REPORT");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jbtn1=new JButton("Print");
		jbtn2=new JButton("Close");
		
		
		lbl=new JLabel("Report of Village wise Individual Information                                                 ");
		lbl.setFont(new Font("Monotype Corsiva",Font.BOLD+Font.ITALIC,27));
		lbl.setForeground(Color.blue);
		jbtn1=new JButton("Print");
		
		c=0;
		connect();
		try
		{
		
		rs=myStatement.executeQuery("select * from individual_information_master");
		
		while(rs.next())
		c++;
		}
		catch(Exception e){
		JOptionPane.showMessageDialog(null,"message 1		"+e);
		}
		
		Object data[][]=new Object[c][15];
		
		try
		{
		ResultSet rs1;
		rs1=myStatement.executeQuery("select v.Village_code,v.village_name,ii.Individual_info_no,ii.name,ii.NO_OF_FAMILY_MEMBER,ii.NO_OF_MALE,ii.NO_OF_FEMALE,ii.NO_OF_CHILD,ii.OCCUPATION,ii.ORGANISATION_NAME,ii.POST_HELD,ii.ANNUAL_INCOME,ii.POVERTY_STATUS,ii.DOB,ii.REMARKS from village_master v,Individual_Information_master ii where v.village_code=ii.village_code  order by v.village_code");
		for(int i=0;i<c;i++)
		{
		rs1.next();
		
		data[i][0]=rs1.getString(1);
		data[i][1]=rs1.getString(2);
		data[i][2]=rs1.getString(3);
		data[i][3]=rs1.getString(4);
		data[i][4]=rs1.getString(5);
		data[i][5]=rs1.getString(6);
		data[i][6]=rs1.getString(7);
		data[i][7]=rs1.getString(8);
		data[i][8]=rs1.getString(9);
		data[i][9]=rs1.getString(10);
		data[i][10]=rs1.getString(11);
		data[i][11]=rs1.getString(12);
		data[i][12]=rs1.getString(13);
		data[i][13]=rs1.getString(14);
		data[i][14]=rs1.getString(15);
	
		}
		}
		catch(Exception sqle)
		{
		JOptionPane.showMessageDialog(null,"message 2		"+sqle);
		}
		
		
		Box box =Box.createHorizontalBox();
		
		box.add(lbl);
		box.add(jbtn1);
		add(box,BorderLayout.NORTH);
		
		status=new JTextArea();
		
		status.setLineWrap(true);
		status.setWrapStyleWord(true);
		status.setEditable(false);
		status.setText("There are "+c+" Record Found");
		getContentPane().add(status,BorderLayout.SOUTH);
		
		
		JTable    table = new JTable(data,colname);
		table.setAutoResizeMode(1);
		JScrollPane resultspane = new JScrollPane(table);
		table.setShowGrid(false);
		table.setEnabled(false);
		table.setBackground(new Color(250, 216, 217));
		getContentPane().add(resultspane,BorderLayout.CENTER);
		
		jbtn1.addActionListener(new printButton(table));
		jbtn2.addActionListener(this);
		
		
		pack();
		setSize(1260,680);
		setLocation(0,0);
		setVisible(true);


}


public class printButton implements ActionListener
{
	JTable table1;
	public printButton(JTable table)
	{
	table1=table;
	}
	
	public void actionPerformed(ActionEvent e)
	{
	try
	{
	table1.print();
	}
	catch(Exception ex)
	{
}

}
}

public void actionPerformed(ActionEvent evt)
{
	if(evt.getSource()==jbtn2)
	{
	dispose();
	}
}
	
public void connect()
{
	try
	{
	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	myConnection=DriverManager.getConnection("jdbc:odbc:home","system","manager");
	myStatement=myConnection.createStatement();
	}
	catch(SQLException sqle)
	{
	JOptionPane.showMessageDialog(null,sqle);
	}
	}
	catch(Exception ex)
	{
	JOptionPane.showMessageDialog(null,ex);
	}
}

	public static void main(String a[])
{
	new  Village_wise_IndividualInformation_Report();
}

}
