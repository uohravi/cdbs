//package anishpackage;

import java.sql.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class District_wise_Block extends JFrame implements ActionListener
{

	private Container myContainer;
	Connection myConnection;
	Statement myStatement;
	ResultSet rs;
	int c;
	String []colname={"District Code","District Name","Subdivision Code","Subdivision Name","Block Code","Block Name","Date Of Establishment","BDO Name"};
	
	JPanel jptle,jpr,jpnlbtn;
	JButton jbtn1,jbtn2;
	JLabel lbl;
	JTextArea status;

public District_wise_Block()
{

		super("REPORT");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jbtn1=new JButton("Print");
		jbtn2=new JButton("Close");
		
		
		lbl=new JLabel("Report of District Wise Block                                                 ");
		lbl.setFont(new Font("Monotype Corsiva",Font.BOLD+Font.ITALIC,27));
		lbl.setForeground(Color.blue);
		jbtn1=new JButton("Print");
		
		c=0;
		connect();
		try
		{
		
		rs=myStatement.executeQuery("select * from block_master");
		
		while(rs.next())
		c++;
		}
		catch(Exception e){
		JOptionPane.showMessageDialog(null,"message 1		"+e);
		}
		
		Object data[][]=new Object[c][8];
		
		try
		{
		ResultSet rs1;
		rs1=myStatement.executeQuery("select d.district_code,d.district_name,s.subdiv_code,s.subdiv_name,b.block_code,b.block_name,to_char(b.estd,'DD-MON-YYYY'),b.bdo_name from district_master d,subdivision_master s,block_master b where s.subdiv_code=b.subdiv_code and d.district_code=s.district_code order by d.district_code");
		
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
		setSize(1020,680);
		setLocation(70,0);
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
	new  District_wise_Block();
}

}
