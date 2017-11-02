import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 public class aboutDeveloper extends JFrame
   {
     private JButton btnClose;
     private JLabel lblHeader;
     private JTextArea txtArea;
     Dimension screenSize;

     public aboutDeveloper()
      {
    	lblHeader = new JLabel();
    	txtArea = new JTextArea();
     	btnClose = new JButton();

        getContentPane().setLayout(null);
	getContentPane().setBackground(new Color(252,226,250));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
		        JLabel	img=new JLabel(new ImageIcon("Copy of 1658221146.jpg"));
			img.setBounds(0,0,500,400);
			
        lblHeader.setFont(new Font("Copperplate Gothic Bold", 1, 36));
        lblHeader.setText("Developer Details");
        getContentPane().add(lblHeader);
        lblHeader.setBounds(10, 10, 510, 40);
        
        JLabel devpic=new JLabel(new ImageIcon("ravjpg.jpg"));
        devpic.setBounds((500-400)/2,45,400,200);
		getContentPane().add(devpic);
		
        txtArea.setBackground(new Color(246, 156, 242));
        txtArea.setText("    Name\t      :\tRAVI KUMAR\n    Mobile No.\t      :\t09199914295\n    Address \t      :\tPatna (Bihar)\n Email :- Ravi.kumar567@yahoo.com ");
        getContentPane().add(txtArea);
        txtArea.setBounds(40, 250, 350, 100);
	txtArea.setEditable(false);

        btnClose.setText("Close");
        getContentPane().add(btnClose);
        btnClose.setBounds(350, 360, 80, 23);
	btnClose.addActionListener(new btnCloseListener());

	setResizable(false);
	setUndecorated(true);
	
	getContentPane().add(img);
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-500)/2, (screenSize.height-400)/3, 500, 400);
	
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
