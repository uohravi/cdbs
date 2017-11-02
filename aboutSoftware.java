import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

  public class aboutSoftware extends JFrame
   {
	private JButton btnClose;
    	private JLabel lblPlateform;
    	private JLabel lblHeader;
    	private JLabel lblWindows;
    	private JLabel lblPowered;
    	private JLabel lblRavi;
	Dimension screenSize;
   
     public aboutSoftware() 
      {
        btnClose = new JButton();
        lblPlateform = new JLabel();
        lblHeader = new JLabel();
        lblWindows = new JLabel();
        lblPowered = new JLabel();
        lblRavi = new JLabel();

        getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(250, 216, 217));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        
        JLabel	img=new JLabel(new ImageIcon("Copy of 1658221146.jpg"));
			img.setBounds(0,0,600,220);
       
        getAccessibleContext().setAccessibleName("About");
        btnClose.setText("Close");
        getContentPane().add(btnClose);
        btnClose.setBounds(340, 190, 80, 23);
	btnClose.addActionListener(new btnCloseListener());

        lblPlateform.setFont(new Font("Microsoft Sans Serif", 0, 18));
        lblPlateform.setForeground(new java.awt.Color(153, 153, 255));
        lblPlateform.setText("Plateform  : ");
        getContentPane().add(lblPlateform);
        lblPlateform.setBounds(180, 80, 120, 20);

        lblHeader.setFont(new Font("Century Schoolbook", 1, 24));
        lblHeader.setForeground(new java.awt.Color(255, 51, 51));
        lblHeader.setText("COMPUTERIZED DATABANK SYSTEM OF BIHAR");
        getContentPane().add(lblHeader);
        lblHeader.setBounds(0, 10, 590, 30);

        lblWindows.setForeground(new Color(0, 0, 153));
        lblWindows.setText("Windows 98 / 2000 / XP / Vista");
        getContentPane().add(lblWindows);
        lblWindows.setBounds(220, 100, 180, 20);

        lblPowered.setFont(new Font("Microsoft Sans Serif", 0, 18));
        lblPowered.setForeground(new java.awt.Color(153, 153, 255));
        lblPowered.setText("Powered by :");
        getContentPane().add(lblPowered);
        lblPowered.setBounds(180, 134, 130, 20);

        lblRavi.setForeground(new Color(0, 102, 51));
        lblRavi.setText("RAVI KUMAR");
        getContentPane().add(lblRavi);
        lblRavi.setBounds(250, 160, 190, 20);
		
		getContentPane().add(img);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-600)/2, (screenSize.height-220)/2, 600, 220);

	setVisible(true);
    }

   private class btnCloseListener implements ActionListener
     {
	public void actionPerformed(ActionEvent e)
	  {
	    dispose();	 
	  }
     }
    
   
}
