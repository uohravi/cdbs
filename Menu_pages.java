import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
//import Report.*;


  public class Menu_pages extends JFrame //implements Runnable
    {
	private JMenuBar mBar;
	private JMenu mMaster,mSurvey,mReport,mHelp,mExit,mAbout,mTools;
	private JMenuItem miDistrict,miSubdivision,miBlock,miPanchayat,miVillage;
	private JMenuItem miPopulation,miLand,miIndividual,miSchool,miEducation,miFamily;
	private JMenuItem miDeveloper,miSoftware,miYes,miNo,miDocu,mibakup,mirestore,michngpasswd,micreateusr;
	private JMenuItem rSubdivision,rBlock,rPanchayat,rVillage;
	private JMenuItem rPopulation,rLand,rIndividual,rSchool,rEducation,rFamily;
	private ImageIcon image;
	private JLabel lblImage,rn,desc,backgr;
	private JPanel pnl,mvpnl;
	private Container mycontainer; 
	private String usrtype;
	int r;

  public Menu_pages(String ss)
    {
	setTitle("COMPUTERIZED DATABANK SYSTEM OF BIHAR (C.D.S.B.)");
	getContentPane().setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	usrtype=ss.trim();

//	mvpnl=new JPanel();
	//mvpnl.setLayout(null);
//	mvpnl.setBounds(0,0,800,40);
//	mvpnl.setBackground(new Color(255,200,255));
   	 r=0;
	 rn=new JLabel("WELCOME TO COMPUTERIZED DATABANK SYSTEM OF BIHAR (C.D.S.B.) ");
	 rn.setForeground(Color.blue);
	 rn.setFont(new Font("monotype cursiva",Font.BOLD,20));
	 rn.setBounds(0,10,750,30);
	// mvpnl.add(rn);
	
	Timer tm=new Timer(500,new timerListener());
	tm.start();
	
	pnl = new JPanel();
	image=new ImageIcon("Bihar_02.jpg");
	pnl.setLayout(null);
	pnl.setBackground(new Color(216,251,255));	
	lblImage=new JLabel(image);
	lblImage.setBounds(0,45,800,500);
	backgr=new JLabel(new ImageIcon("Copy of 1658221146.jpg"));
	backgr.setBounds(0,0,800,600);
	
	desc=new JLabel("    NAME :- RAVI KUMAR                                         ENROLLMENT :-084214760");
	desc.setFont(new Font("Arial",Font.ITALIC,20));
	desc.setForeground(new Color(255,0,255));
	desc.setBounds(0,520,800,100);

	mycontainer=getContentPane();
        mycontainer.setLayout(new GridLayout(1,1));
        pnl.add(rn);
        pnl.add(lblImage);
        pnl.add(desc);
        pnl.add(backgr);
	mycontainer.add(pnl);

	mBar = new JMenuBar();
	mMaster = new JMenu("Master Entry   ");
	mMaster.setMnemonic('M');
	mSurvey = new JMenu("Survey Entry   ");
	mSurvey.setMnemonic('S');
	mReport = new JMenu("Report     ");
	mReport.setMnemonic('R');
	mHelp = new JMenu("Help       ");
	mHelp.setMnemonic('H');
	mExit = new JMenu("Exit       ");
	mExit.setMnemonic('X');
	mAbout = new JMenu("About     ");
	mTools=new JMenu("Tools       ");
	mTools.setMnemonic('O');
	
	miSubdivision = new JMenuItem("Subdivision Master");
	miDistrict = new JMenuItem("District Master");
	miBlock = new JMenuItem("Block Master");
	miPanchayat = new JMenuItem("Panchayat Master");
	miVillage = new JMenuItem("Village Master");
	

	miPopulation = new JMenuItem("Population Master");
	miLand = new JMenuItem("Land Master");
	miIndividual = new JMenuItem("Individual Information Master");
	miFamily = new JMenuItem("Family Master");
	miSchool = new JMenuItem("School Master");
	miEducation = new JMenuItem("Education Master");
	

	miDeveloper = new JMenuItem("Developer");
	miSoftware = new JMenuItem("Software");
	miYes = new JMenuItem("Yes");
	miNo = new JMenuItem("No");
	miDocu = new JMenuItem("Documentation");
	mibakup=new JMenuItem("BackUp");
	mirestore=new JMenuItem("Restore");
	michngpasswd=new JMenuItem("Change Password");
	micreateusr=new JMenuItem("Manage User");

	rSubdivision = new JMenuItem("Subdivision Master Report");
	rBlock = new JMenuItem("Block Master Report");
	rPanchayat = new JMenuItem("Panchayat Master Report");
	rVillage = new JMenuItem("Village Master Report");

	rPopulation = new JMenuItem("Population Master Report");
	rLand = new JMenuItem("Land Master Report");
	rIndividual = new JMenuItem("Individual Information Master Report");
	rFamily = new JMenuItem("Family Information Master Report");
	rSchool = new JMenuItem("School Information Master Report");
	rEducation = new JMenuItem("Education Master Report");

	
	
	mMaster.add(miDistrict);
	mMaster.add(miSubdivision);
	mMaster.add(miBlock);
	mMaster.add(miPanchayat);
	mMaster.add(miVillage);

	mSurvey.add(miPopulation);
	mSurvey.add(miIndividual);
	mSurvey.add(miFamily);
	mSurvey.add(miLand);
	mSurvey.add(miSchool);
	mSurvey.add(miEducation);


	mHelp.add(mAbout);
	mAbout.add(miSoftware);
	mAbout.add(miDeveloper);
	mHelp.add(miDocu);

	mExit.add(miYes);
	//mExit.add(miNo);
	mTools.add(mibakup);
	mTools.add(mirestore);
	mTools.add(micreateusr);
	mTools.add(michngpasswd);
	//micreateusr.addMnemonic(KeyStroke.V_K);

	setJMenuBar(mBar);
	mBar.add(mMaster);
	mBar.add(mSurvey);
	mBar.add(mReport);
	mBar.add(mTools);
	mBar.add(mHelp);
	mBar.add(mExit);
	
	mReport.add(rSubdivision);
	mReport.add(rBlock);
	mReport.add(rPanchayat);
	mReport.add(rVillage);
	mReport.add(rPopulation);
	mReport.add(rIndividual);
	mReport.add(rFamily);
	mReport.add(rLand);
	mReport.add(rSchool);
	mReport.add(rEducation);


	miSubdivision.addActionListener(new menuListener());
	miDistrict.addActionListener(new menuListener());
	miBlock.addActionListener(new menuListener());
	miPanchayat.addActionListener(new menuListener());
	miVillage.addActionListener(new menuListener());
	miPopulation.addActionListener(new menuListener());
	miLand.addActionListener(new menuListener());
	miIndividual.addActionListener(new menuListener());
	miFamily.addActionListener(new menuListener());
	miSchool.addActionListener(new menuListener());
	miEducation.addActionListener(new menuListener());

	miSoftware.addActionListener(new menuListener());
	miDocu.addActionListener(new menuListener());
	miDeveloper.addActionListener(new menuListener());
	miYes.addActionListener(new menuListener());
	mibakup.addActionListener(new menuListener());
	mirestore.addActionListener(new menuListener());
	michngpasswd.addActionListener(new menuListener());
	micreateusr.addActionListener(new menuListener());
//	mExit.addActionListener(new menuListener());

	rSubdivision.addActionListener(new reportListener());
	rBlock.addActionListener(new reportListener());
	rPanchayat.addActionListener(new reportListener());
	rVillage.addActionListener(new reportListener());
	rPopulation.addActionListener(new reportListener());
	rLand.addActionListener(new reportListener());
	rIndividual.addActionListener(new reportListener());
	rFamily.addActionListener(new reportListener());
	rSchool.addActionListener(new reportListener());
	rEducation.addActionListener(new reportListener());
    	try
		{
			try
			{
				String tmp="LOCAL";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn=DriverManager.getConnection("jdbc:odbc:home","system","manager");
				Statement stat=conn.createStatement();
				ResultSet rs=stat.executeQuery(" select type from login where name='"+usrtype.trim()+"'");
				rs.next();
				String str=rs.getString(1);		
				if(tmp.equalsIgnoreCase(str.trim()))
				mMaster.setEnabled(false);
			}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"error in Creating Connection","Database Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Not connected to Database","DataBase Error",JOptionPane.ERROR_MESSAGE);
		}
		
		
		mBar.setBackground(new Color(140,251,248));
		miDistrict.setBackground(new Color(245,222,220));
		miSubdivision.setBackground(new Color(245,222,220));
		miBlock.setBackground(new Color(245,222,220));
		miPanchayat.setBackground(new Color(245,222,220));
		miPopulation.setBackground(new Color(245,222,220));
		miVillage.setBackground(new Color(245,222,220));
		miLand.setBackground(new Color(245,222,220));
		miIndividual.setBackground(new Color(245,222,220));
		miSchool.setBackground(new Color(245,222,220));
		miEducation.setBackground(new Color(245,222,220));
		miFamily.setBackground(new Color(245,222,220));
		rSubdivision.setBackground(new Color(245,222,220));
		rBlock.setBackground(new Color(245,222,220));
		rPanchayat.setBackground(new Color(245,222,220));
		rPopulation.setBackground(new Color(245,222,220));
		rVillage.setBackground(new Color(245,222,220));
		rLand.setBackground(new Color(245,222,220));
		rIndividual.setBackground(new Color(245,222,220));
		rSchool.setBackground(new Color(245,222,220));
		rEducation.setBackground(new Color(245,222,220));
		rFamily.setBackground(new Color(245,222,220));
		miDeveloper.setBackground(new Color(245,222,220));
		miYes.setBackground(new Color(245,222,220));
		mibakup.setBackground(new Color(245,222,220));
		mirestore.setBackground(new Color(245,222,220));
		miDocu.setBackground(new Color(245,222,220));
		miSoftware.setBackground(new Color(245,222,220));
		michngpasswd.setBackground(new Color(245,222,220));
		micreateusr.setBackground(new Color(245,222,220));
		mAbout.setBackground(new Color(245,222,220));
		mHelp.setBackground(new Color(245,222,220));

		setSize(800,650);
	setLocation(100,30);
	setResizable(false);
	setVisible(true);
	}

private class menuListener implements ActionListener
  {
  public void actionPerformed(ActionEvent e)
    {
      if(e.getSource()==miSubdivision)
       {
         Subdivision_Details sm = new Subdivision_Details();
       }
      if(e.getSource()==miDistrict)
       {
         District_Details dm = new District_Details();
       }
      if(e.getSource()==miBlock)
       {
         Block_Details bm = new Block_Details();
       }
      if(e.getSource()==miPanchayat)
       {
         Panchayat_Details pm = new Panchayat_Details();
       }
      if(e.getSource()==miVillage)
       {
         Village_Details vm = new Village_Details();
       }
      if(e.getSource()==miPopulation)
       {
         Population_Details ppm = new Population_Details();
       }
      if(e.getSource()==miLand)
       {
         Land_info lnm = new Land_info();
       }
      if(e.getSource()==miIndividual)
       {
         Individual_Information hsm = new Individual_Information();
       }
      if(e.getSource()==miFamily)
       {
         Family_Details rdw = new Family_Details();
       }
      if(e.getSource()==miSchool)
       {
         School_Details rlw = new School_Details();
       }
      if(e.getSource()==miEducation)
       {
         Education_Details wtw = new Education_Details();
       }
        if(e.getSource()==miDocu)
       {
       	try
       	{
       		Process p=Runtime.getRuntime().exec("cmd /c notepad cdsb.txt"); 
       		
       	}
       	catch(IOException io)
       	{
       		JOptionPane.showMessageDialog(null,"Sorry we Can't RESTORE"+io,"ERROR",JOptionPane.ERROR_MESSAGE);
       	} 
         
       }
      if(e.getSource()==miSoftware)
      {
         aboutSoftware abs = new aboutSoftware();
       }
      if(e.getSource()==miDeveloper)
       {
         aboutDeveloper abd = new aboutDeveloper();
       }
      if(e.getSource()==miYes)
       {
         int n = JOptionPane.showConfirmDialog(null, "Would you really want to EXIT","Confirmation",JOptionPane.YES_NO_OPTION);
         if (n == JOptionPane.YES_OPTION) 
	    System.exit(0);			 
       }
       if(e.getSource()==mibakup)
       {
       	try
       	{
       		String nm;
       		int n = JOptionPane.showConfirmDialog(null, "ARE U SURE TO TAKE BAKUP OF THE FILE","Confirmation",JOptionPane.YES_NO_OPTION);
         if (n == JOptionPane.YES_OPTION) 
         {
       		nm=JOptionPane.showInputDialog(null,"PLEASE ENTER A BAKUP FILE NAME TO BE CREATE \n OTHERWISE DEFAULT NAME bkp WILL BE USED","bkp");
       		if(nm==null||nm.compareTo("")==0)
       			nm="bkp";
       		Process p=Runtime.getRuntime().exec("cmd /c exp USERID=system/manager BUFFER=2000 FILE=bakup/"+nm+" compress=yes grants=yes"); 
       		JOptionPane.showMessageDialog(null,"TAKING BACKUP OF THE DATABASE ","INFORMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);
       	}
       	}
       	catch(IOException io)
       	{
       		JOptionPane.showMessageDialog(null,"Sorry we Can't take Backup"+io,"ERROR",JOptionPane.ERROR_MESSAGE);
       		
       	} 
       
       		
       }
       if(e.getSource()==mirestore)
       {
       	try
       	{
       			String nm;
       			int n = JOptionPane.showConfirmDialog(null, "ARE U SURE TO RESTORE","Confirmation",JOptionPane.YES_NO_OPTION);
         if (n == JOptionPane.YES_OPTION) 
         {
       		nm=JOptionPane.showInputDialog(null,"please enter the bakup File name to be restored \n OTHERWISE DEFAULT NAME bkp FILE WILL BE USED","bkp");
       		if(nm==null||nm.compareTo("")==0)
       			nm="bkp";
       		Process p=Runtime.getRuntime().exec("cmd /c imp USERID=system/manager BUFFER=2000 FILE=bakup/bkp1 compress=yes grants=yes"); 
       		JOptionPane.showMessageDialog(null,"RESTORING DATABASE FROM BACKUP FILE ","INFORMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);
       	}
       	}
       	catch(IOException io)
       	{
       		JOptionPane.showMessageDialog(null,"Sorry we Can't RESTORE"+io,"ERROR",JOptionPane.ERROR_MESSAGE);
       	} 
       	
       }
       if(e.getSource()==michngpasswd)
       {
       		new ChangePasswd(usrtype);
       }
       if(e.getSource()==micreateusr)
       {
       		new CreateUser(usrtype);
       }
     }
   }

private class reportListener implements ActionListener
  {
  public void actionPerformed(ActionEvent e)
    {
      if(e.getSource()==rSubdivision)
       {
         new  District_wise_Subdivision();
       }
      if(e.getSource()==rBlock)
       {
        new  District_wise_Block();
       }
      if(e.getSource()==rPanchayat)
       {
         new  Block_wise_Panchayat_Report();
       }
      if(e.getSource()==rVillage)
       {
        new  Panchayat_wise_Village_Report();
       }
      if(e.getSource()==rPopulation)
       {
         new  Village_wise_Population_Report();
       }
      if(e.getSource()==rLand)
       {
         new Individual_Land_Information_Report();
       }
      if(e.getSource()==rIndividual)
       {
        new  Village_wise_IndividualInformation_Report();
       }
      if(e.getSource()==rFamily)
       {
         new Village_wise_FamilyInformation_Report();
       }
      if(e.getSource()==rSchool)
       {
         new Village_wise_School_Report();
       }
       if(e.getSource()==rEducation)
       {
         new Village_wise_Education_Report();
       }
      
     }
   }
   
   private class timerListener implements ActionListener
   {
   public void actionPerformed(ActionEvent e)
   {	
   		
   		rn.setLocation(r,10);
   			r=r+20;
   			if(r>=150)
   			r=0;

   	}
   
   	
   }
   
   


  public static void main(String arg[])
    {
//	Thread firstThread=new Thread(new Menu_Page());
	//firstThread.setDeamon(true);
	new Menu_pages("Ravi kumar");
    }
  }
