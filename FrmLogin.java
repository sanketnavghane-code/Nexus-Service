import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;
import myDesign.*;

class FrmLogin extends JFrame implements ActionListener
{
	LoginDesign myUI;

	JPanel pnlLogin;
	JPanel pnlRight;


	JPanel pnlLoginButton;
	JButton btnLoginButton;
	JPanel pnlLoginUsername;
	JTextField txtLoginUsername;
	JPanel pnlLoginPassword;
	JPasswordField txtLoginPassword;
	JButton btnShowOrHidePassword;
	final char defaultPasswordChar;
	ImageIcon imgShowPassword = new ImageIcon(new ImageIcon("imagesrc\\imgShowPassword.png").getImage().getScaledInstance(38,38,java.awt.Image.SCALE_SMOOTH));
	ImageIcon imgHidePassword = new ImageIcon(new ImageIcon("imagesrc\\imgHidePassword.png").getImage().getScaledInstance(38,38,java.awt.Image.SCALE_SMOOTH));

	String[] slideShowImages = {"imagesrc\\busAndLogo.jpeg","imagesrc\\MSRTC-Satara-Bharti-2024-3.jpg.webp",
								"imagesrc\\imgChopdaBusStand.jpg","imagesrc\\imgRightTopPanel.jpeg",
								"imagesrc\\imgWomanDriver.jpeg","imagesrc\\imgBusCrowd.jpeg"};

	JPanel pnlMovingBusDeveloperList;
	JLabel lblMovingBusDeveloperList;

	FrmLogin()
	{

		setLocation(0,0);
		setLayout(null);
		setBackground(ColorSetting.getBackColorFrame());
		setTitle("ServiceNexus");
		setIconImage(new ImageIcon("imagesrc\\img-ServiceNexus-Logo.png").getImage());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)(screenSize.width),(int)(screenSize.height));
		setLocationRelativeTo(null);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );

		myUI = new LoginDesign();
		add(myUI);

		pnlMovingBusDeveloperList = myUI.getMovingBusDeveloperListPanel();
		lblMovingBusDeveloperList = myUI.getMovingBusDeveloperListLabel();
		new ScrollLabel(lblMovingBusDeveloperList ,9,pnlMovingBusDeveloperList);

		txtLoginUsername = myUI.getLoginUsernameTextField();
		txtLoginPassword = myUI.getLoginPasswordField();
		defaultPasswordChar =  txtLoginPassword.getEchoChar();
		btnShowOrHidePassword = myUI.getShowOrHidePasswordButton();

		btnShowOrHidePassword.addActionListener(e ->{
				if(txtLoginPassword.getEchoChar() == defaultPasswordChar)
				{
					txtLoginPassword.setEchoChar((char)0);
					btnShowOrHidePassword.setIcon(imgHidePassword);
				}
				else
				{
					txtLoginPassword.setEchoChar(defaultPasswordChar);
					btnShowOrHidePassword.setIcon(imgShowPassword);
				}
		});

		pnlRight = myUI.getRightPanel();
		//new ImageSlideShow(slideShowImages,pnlRight);

		pnlLogin = myUI.getLoginPanel();

		pnlLoginButton = myUI.getLoginButtonPanel();
		btnLoginButton = myUI.getLoginButton();
		btnLoginButton.addActionListener(this);

		//pack();
		setVisible(true);
		show();
		txtLoginUsername.requestFocus();
	}


	public void actionPerformed(ActionEvent ae)
	{

	if(ae.getSource() == btnLoginButton)
		{
			String Username = txtLoginUsername.getText();
			String Password = txtLoginPassword.getText();
			//if(txtLoginUsername.getText().equals("Admin") && txtLoginPassword.getText().equals("12345"))

			if(dlsLogin.isValidUser(Username,Password))
			{
				PanelState.disabledComponents(pnlLogin);
				txtLoginPassword.setEchoChar(defaultPasswordChar);
				btnShowOrHidePassword.setIcon(imgShowPassword);

				//new BlinkLabel(lblLoginMessage,1);

				frmDashboard M = new frmDashboard();
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"User Not Found.....!");
				txtLoginUsername.setText("");
				txtLoginPassword.setText("");
			}
		}
	}

	public static void main(String args[])
	{
		new FrmLogin();
	}
}