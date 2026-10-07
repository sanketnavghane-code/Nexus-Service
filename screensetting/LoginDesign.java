package screensetting;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import myUtility.*;
import javax.swing.JButton;
import myDesign.*;


public class LoginDesign extends JPanel
{
	JPanel pnlLeft;
	JPanel pnlLeftTop;
	JLabel lblLeftTop;
	JPanel pnlLeftBottom;
//	JPanel pnlRightBottom;
	JLabel lblLeftBottom;

	JSeparator SeparatorLeftTop;

	JPanel pnlRight;
	JLabel lblRightPanelImage;
//	JLabel lblMovingBus;

	JPanel pnlServiceNexusLogopit;

	JPanel pnlLogin;
	JPanel pnlLoginTop;
	JLabel lblLoginMSRTC;
	JLabel lblLoginPage;
	JPanel pnlLoginCenter;
	JLabel lblLoginUsername;
	JTextField txtLoginUsername;
	JLabel lblLoginPassword;
	JPasswordField txtLoginPassword;
	JButton btnShowOrHidePassword;
	JPanel pnlLoginButton;
	JButton btnLoginButton;

	JLabel lblDeveloper;
	JLabel lblDeveloperList;

	JPanel pnlUI;

	JPanel pnlMovingBusDeveloperList;
	JLabel lblMovingBusDeveloperList;

	public LoginDesign()
	{
		setSize(1920,1080);
		setLocation(0,0);
		setLayout(null);
		setVisible(true);;
		setBackground(Color.WHITE);

		pnlMovingBusDeveloperList = new JPanel();
		pnlMovingBusDeveloperList.setLayout(null);
		pnlMovingBusDeveloperList.setBackground(new Color(255,255,255,0));
		pnlMovingBusDeveloperList.setBounds(0,915,1920,140);
		pnlMovingBusDeveloperList.setOpaque(false);

		lblMovingBusDeveloperList = new JLabel(new ImageIcon(new ImageIcon("imagesrc\\imgBus3_And_DeveloperList.png").getImage().getScaledInstance(1075,120,java.awt.Image.SCALE_SMOOTH)));
		lblMovingBusDeveloperList.setBounds(0,20,1075,120);

		pnlLogin = new JPanel();
		pnlLogin.setLayout(null);
		pnlLogin.setBounds(1290,0,625,1050);
		pnlLogin.setBackground(new Color(255,255,255));

		RoundedPanel.createRoundedPanel(pnlLogin,75);

		pnlRight = ImagePanel.getPanel("imagesrc\\imgMapAndBus.png");
		pnlRight.setLayout(null);
		pnlRight.setBounds(0,0,1320,1080);

// Service Nexus Logopit

		pnlServiceNexusLogopit = ImagePanel.getPanel("imagesrc\\img-ServiceNexus-Logo.png");
		pnlServiceNexusLogopit.setLayout(null);
		pnlServiceNexusLogopit.setBackground(Color.WHITE);
		pnlServiceNexusLogopit.setBounds(238,15,150,150);


		pnlLoginTop = new JPanel();
		pnlLoginTop.setLayout(null);
		pnlLoginTop.setBackground(new Color(255,255,255));
		pnlLoginTop.setBounds(63,175,500,240);

		lblLoginMSRTC = new JLabel("<html><center>Welcome<br>To<br>ServiceNexus</center></html>",JLabel.CENTER);
		lblLoginMSRTC.setFont(new Font("Forte", Font.BOLD, 48));
		lblLoginMSRTC.setForeground(new Color(81,85,195));//new Color(49, 146, 224));
		lblLoginMSRTC.setBounds(0,-15,500,200);


		lblLoginPage = new JLabel("Login in to your account to Continue",JLabel.CENTER);
		lblLoginPage.setFont(new Font("Copper Black", Font.BOLD, 24));
		lblLoginPage.setBounds(0,205,500,29);

		pnlLoginCenter = new JPanel();
		pnlLoginCenter.setBounds(98,465,430,250);
		pnlLoginCenter.setLayout(null);
		pnlLoginCenter.setBackground(new Color(255,255,255));

		lblLoginUsername = new JLabel("Username",JLabel.CENTER);
		lblLoginUsername.setFont(new Font("Serif Bold", Font.BOLD, 24));
		lblLoginUsername.setBounds(15,15,115,26);

		txtLoginUsername = new JTextField();
		txtLoginUsername.setFont(new Font("Arial Bold", Font.BOLD, 25));
		txtLoginUsername.setBounds(15,55,400,40);

		lblLoginPassword = new JLabel("Password",JLabel.CENTER);
		lblLoginPassword.setFont(new Font("Serif Bold", Font.BOLD, 24));
		lblLoginPassword.setBounds(15,140,115,26);

		txtLoginPassword = new JPasswordField();
		txtLoginPassword.setFont(new Font("Arial Bold", Font.BOLD, 25));
		txtLoginPassword.setBounds(15,181,350,40);
		//setEchoChar((char) 0)

		btnShowOrHidePassword = new JButton(new ImageIcon(new ImageIcon("imagesrc\\imgShowPassword.png").getImage().getScaledInstance(38,38,java.awt.Image.SCALE_SMOOTH)));
		btnShowOrHidePassword.setBounds(370,181,40,40);
		btnShowOrHidePassword.setBackground(new Color(255,255,255));
		btnShowOrHidePassword.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		pnlLoginButton = new JPanel();
		pnlLoginButton.setBounds(213,800,200,60);
		pnlLoginButton.setLayout(null);
		pnlLoginButton.setBackground(new Color(49, 146, 224));

		RoundedPanel.createRoundedPanel(pnlLoginButton,25);

		btnLoginButton = new JButton("LOG IN");
		btnLoginButton.setBounds(0,0,200,60);
		btnLoginButton.setFont(new Font("Arial Bold", Font.BOLD,28));
		btnLoginButton.setLayout(null);
		btnLoginButton.setForeground(new Color(255,255,255));
		btnLoginButton.setBackground(new Color(81,85,195));//new Color(49, 146, 224));

		RoundedPanel.createRoundedButton(btnLoginButton,25);

		add(pnlMovingBusDeveloperList);
		pnlMovingBusDeveloperList.add(lblMovingBusDeveloperList);
		add(pnlRight);
		add(pnlLogin);
		pnlLogin.add(pnlServiceNexusLogopit);
		pnlLogin.add(pnlLoginTop);
		pnlLoginTop.add(lblLoginMSRTC);
		pnlLoginTop.add(lblLoginPage);
		pnlLogin.add(pnlLoginCenter);
		pnlLoginCenter.add(lblLoginUsername);
		pnlLoginCenter.add(txtLoginUsername);
		pnlLoginCenter.add(lblLoginPassword);
		pnlLoginCenter.add(txtLoginPassword);
		pnlLoginCenter.add(btnShowOrHidePassword);
		pnlLogin.add(pnlLoginButton);
		pnlLoginButton.add(btnLoginButton);


//		setDefaultSettings();

	}


	public JPanel getRightPanel()
	{
		return(pnlRight);
	}

	public JPanel getLoginPanel()
	{
		return(pnlLogin);
	}

	public JPanel getLeftPanel()
	{
		return(pnlLeft);
	}

	public JPanel getLoginButtonPanel()
	{
		return(pnlLoginButton);
	}

	public JButton getLoginButton()
	{
		return(btnLoginButton);
	}

	public JLabel getLeftTopLabel()
	{
		return(lblLeftTop);
	}

	public JPanel getLeftBottomPanel()
	{
		return(pnlLeftBottom);
	}

	public JLabel getLeftBottomLabel()
	{
		return(lblLeftBottom);
	}

	public  JSeparator getLeftTopSeparator()
	{
		return(SeparatorLeftTop);
	}

/*	public JPanel getRightBottomPanel()
	{
		return(pnlRightBottom);
	}

	public JLabel getMovingBusLabel()
	{
		return(lblMovingBus);
	}
*/


	public 	JTextField getLoginUsernameTextField()
	{
		return(txtLoginUsername);
	}

	public JPasswordField getLoginPasswordField()
	{
		return(txtLoginPassword);
	}

	public JButton getShowOrHidePasswordButton()
	{
		return(btnShowOrHidePassword);
	}

	public JPanel getMovingBusDeveloperListPanel()
	{
		return(pnlMovingBusDeveloperList);
	}

	public JLabel getMovingBusDeveloperListLabel()
	{
		return(lblMovingBusDeveloperList);
	}

}
