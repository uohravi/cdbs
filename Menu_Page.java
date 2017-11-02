import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
//import Report.*;


  public class Menu_Page extends JFrame //implements Runnable
    {
	private JMenuBar mBar;
	private JMenu mMaster,mSurvey,mReport,mHelp,mExit,mAbout,mTools;
	private JMenuItem miDistrict,miSubdivision,miBlock,miPanchayat,miVillage;
	private JMenuItem miPopulation,miLand,miIndividual,miSchool,miEducation,miFamily;
	private JMenuItem miDeveloper,miSoftware,miYes,miNo,miDocu,mibakup,mirestore,michngpasswd,micreateusr;
	private JMenuItem rSubdivision,rBlock,rPanchayat,rVillage;
	private JMenuItem rPopulation,rLand,rIndividual,rSchool,rEducation,rFamily;
	private ImageIcon image;
	private JLabel lblImage,rn;
	private JPanel pnl,mvpnl;
	private Container mycontainer; 
	private String str1,usrtype;
	int r;

  public Menu_Page(String ss)
    {
	setTitle("COMPUTERIZED DATABANK SYSTEM OF BIHAR (C.D.S.B.)");
	getContentPane().setLayout(null);
	getContentPane().setBackground(new Color(252,226,250));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	usrtype=ss.trim();

	pnl = new JPanel();
	image=new ImageIcon("MAINpAGE1.jpg");
	pnl.setLayout(null);
	mvpnl=new JPanel();
   	r=0;
	
	 rn=new JLabel("WELCOME TO COMPUTERIZED DATABANK SYSTEM OF BIHAR (C.D.S.B.) ");
	 rn.setForeground(Color.blue);
	 rn.setFont(new Font("monotype cursiva",Font.BOLD,20));
	 
	 rn.setBounds(0,400,750,30);
	 //mvpnl.add(rn);
	
	Timer tm=new Timer(500,new timerListener());
	tm.start();
		
	lblImage=new JLabel(image);
	lblImage.setBounds(0,0,800,600);

	mycontainer=getContentPane();
        mycontainer.setLayout(new GridLayout(1,1));
        pnl.add(rn);
        pnl.add(lblImage);
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

	mBar.setBackground(new Color(140,251,250));
	
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
	
	if(usrtype.equalsIgnoreCase("Ravi"))
	mMaster.setEnabled(false);
	else if(usrtype.equalsIgnoreCase("Guest"))
	{
		mMaster.setEnabled(false);
		mSurvey.setEnabled(false);
	}
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
         int n = JOptionPane.showConfirmDialog(null, "Would you really want to EXIT","Confirmation",
		                                              JOptionPane.YES_NO_OPTION);
         if (n == JOptionPane.YES_OPTION) 
	    System.exit(0);			 
       }
       if(e.getSource()==mibakup)
       {
       }
       if(e.getSource()==mirestore)
       {
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
   		
   		rn.setLocation(r,400);
   			r=r+20;
   			if(r>=750)
   			r=0;

   	}
   
   	
   }
  // void play(String url,String nm)
   //{
   //}


 /* public static void main(String arg[])
    {
//	Thread firstThread=new Thread(new Menu_Page());
	//firstThread.setDeamon(true);
	new Menu_Page("Ravi kumar");
    }*/
  }
