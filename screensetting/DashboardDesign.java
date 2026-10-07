package screensetting;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import appsetting.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import myUtility.*;
import myDesign.*;

public class DashboardDesign extends JPanel
{
	JPanel pnlAll;

	JPanel pnlLeft;
	JPanel pnlLeftForward;

	JPanel pnlLogo;

	JButton btnLogout;

	JLabel lblAboutDashboard;

	JPanel pnlRight;

	JPanel pnlRightTop;
	JLabel lblRightTop;

	JPanel pnlRightMiddel;
	JLabel lblRightMiddel;

	JPanel pnlCenter;
	JPanel pnlCenterTop;
	JPanel pnlCenterBottom;

	JPanel pnlBottomRight;
	JPanel pnlBottomLeft;


	JLabel lblLeftBottom;
	JPanel pnlProgramHead;
	JLabel lblNotice;
	JPanel pnlProgramBody;
	JPanel pnlUIReport;

	JPanel pnlRootStopDisplay;
	JButton btnRootStopDisplay;

	JPanel pnlRootGoogleMapDisplay;
	JButton btnRootGoogleMapDisplay;


	JPanel pnlManageEmployee;
	JButton btnManageEmployee;

	JPanel pnlManageBus;
	JButton btnManageBus;

	JPanel pnlManageRoot;
	JButton btnManageRoot;

	JPanel pnlManageAllocation;
	JButton btnManageAllocation;

	JPanel pnlAboutUs;
	JButton btnAboutUs;
	JPanel pnlAboutUsDescription;
	JPanel pnlAboutUsInfo;
	JButton btnCloseAboutUsDescription;

	JButton btnServices;
	JPanel  pnlServices;
	JPanel pnlServicesDescription;
	JButton btnCloseServicesDescription;
	JPanel pnlServicesInfo;

	JButton btnGallery;
	JPanel  pnlGallery;
	JPanel pnlGalleryDescription;
	JButton btnCloseGalleryDescription;
	JPanel pnlGalleryInfo;

	JPanel pnlEmployee;
	JButton btnEmployee;

	JPanel pnlBuses;
	JButton btnBuses;

	JPanel pnlAllocation;
	JButton btnAllocation;

    JPanel pnlRoot;
	JButton btnRoot;

	JPanel pnlMSRTCWeb;
	JLabel lblMSRTCWeb;
	JButton btnMSRTCWeb;

	JButton btnSearchStation;
	JPanel pnlSearchStation;
	JLabel lblSearchStation;
	JTextField txtSearchStation;

	JPanel pnlUserProfile;
	JPanel pnlUserImage;
	JLabel lblUserName;

	JPanel pnlTotalEmployee;
	JPanel pnlTotalBuses;
	JPanel pnlTotalRoot;
	JPanel pnlTotalAllocation;

	JLabel lblTotalEmployee;
	JLabel lblTotalBuses;
	JLabel lblTotalRoot;
	JLabel lblTotalAllocation;

	ImageIcon imgLeftMiddel;
	ImageIcon imgLeftBottom;

	JLabel lblDevelopers;

	JPanel pnlUI;

	int x = 5;
	int y = 430;
	int w = 200;
	int h = 45;

	public DashboardDesign()
	{
		setSize(1950,1200);
		setLocation(1,1);
		setLayout(null);
		setVisible(true);
		setBackground(new Color(236,237,255));

		pnlLeft = new JPanel();
		pnlLeft.setLayout(null);
		pnlLeft.setBackground(new Color(81,85,195));//Blue - 0,117,255
		pnlLeft.setBounds(-1,0,100,1080);
		add(pnlLeft);

		pnlLogo = ImagePanel.getPanel("imagesrc\\img-ServiceNexus-Logo.png");
		pnlLogo.setBounds(5,5,90,90);
		pnlLogo.setBackground(new Color(255,255,255,0));
		RoundedPanel.createRoundedPanel(pnlLogo,100);
		pnlLeft.add(pnlLogo);

		btnLogout = new JButton(new ImageIcon(new ImageIcon("imagesrc\\img-logout2.png").getImage().getScaledInstance(60,60,java.awt.Image.SCALE_SMOOTH)));
		btnLogout.setBounds(12,900,75,75);
		btnLogout.setBackground(new Color(255,255,255,0));
		btnLogout.setOpaque(false);
		btnLogout.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlLeft.add(btnLogout);

		pnlLeftForward = new JPanel();
		pnlLeftForward.setLayout(null);
		pnlLeftForward.setBackground(Color.WHITE);
		pnlLeftForward.setBounds(100,0,210,1080);
		add(pnlLeftForward);

		lblAboutDashboard = new JLabel("<html><p><center>Welcome<br>to<br>Service-Nexus<br>Dashboard</center></p></html>");
		lblAboutDashboard.setForeground(new Color(81,85,195));
		lblAboutDashboard.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblAboutDashboard.setBounds(3,-5,210,200);
		pnlLeftForward.add(lblAboutDashboard);

//Manage Buttons
		pnlManageEmployee = new JPanel();
		pnlManageEmployee.setBounds(x,y,w,h);
		pnlManageEmployee.setLayout(null);
		pnlManageEmployee.setBackground(new Color(81,85,195));//Light Purpule - 81,85,195
		pnlLeftForward.add(pnlManageEmployee);

		RoundedPanel.createRoundedPanel(pnlManageEmployee,50);

		btnManageEmployee = new JButton();
		btnManageEmployee.setBounds(0,0,200,45);
		btnManageEmployee.setText("Manage Employee");
		btnManageEmployee.setFont(new Font("Basic", Font.BOLD, 18));
		btnManageEmployee.setBackground(new Color(81,85,195));
		btnManageEmployee.setForeground(Color.WHITE);
		pnlManageEmployee.add(btnManageEmployee);

		RoundedPanel.createRoundedButton(btnManageEmployee,50);

		pnlManageBus = new JPanel();
		pnlManageBus.setBounds(x,y,w,h);
		pnlManageBus.setLayout(null);
		pnlManageBus.setBackground(new Color(81,85,195));
		pnlLeftForward.add(pnlManageBus);

		RoundedPanel.createRoundedPanel(pnlManageBus,50);

		btnManageBus = new JButton();
		btnManageBus.setBounds(0,0,200,45);
		btnManageBus.setText("Manage Bus");
		btnManageBus.setFont(new Font("Basic", Font.BOLD, 18));
		btnManageBus.setBackground(new Color(81,85,195));
		btnManageBus.setForeground(Color.WHITE);
		pnlManageBus.add(btnManageBus);

		RoundedPanel.createRoundedButton(btnManageBus,50);

		pnlManageRoot = new JPanel();
		pnlManageRoot.setBounds(x,y,w,h);
		pnlManageRoot.setLayout(null);
		pnlManageRoot.setBackground(new Color(81,85,195));
		pnlLeftForward.add(pnlManageRoot);

		RoundedPanel.createRoundedPanel(pnlManageRoot,50);

		btnManageRoot = new JButton();
		btnManageRoot.setBounds(0,0,200,45);
		btnManageRoot.setText("Manage Root");
		btnManageRoot.setFont(new Font("Basic", Font.BOLD, 18));
		btnManageRoot.setBackground(new Color(81,85,195));
		btnManageRoot.setForeground(Color.WHITE);
		pnlManageRoot.add(btnManageRoot);

		RoundedPanel.createRoundedButton(btnManageRoot,50);

		pnlManageAllocation = new JPanel();
		pnlManageAllocation.setBounds(x,y,w,h);
		pnlManageAllocation.setLayout(null);
		pnlManageAllocation.setBackground(new Color(81,85,195));
		pnlLeftForward.add(pnlManageAllocation);

		RoundedPanel.createRoundedPanel(pnlManageAllocation,50);

		btnManageAllocation = new JButton();
		btnManageAllocation.setBounds(0,0,200,45);
		btnManageAllocation.setText("Manage Allocation");
		btnManageAllocation.setFont(new Font("Basic", Font.BOLD, 18));
		btnManageAllocation.setBackground(new Color(81,85,195));
		btnManageAllocation.setForeground(Color.WHITE);
		pnlManageAllocation.add(btnManageAllocation);

		RoundedPanel.createRoundedButton(btnManageAllocation,50);

		y += 58;

		pnlAboutUs=new JPanel();
		pnlAboutUs.setLayout(null);
		pnlAboutUs.setBounds(x,y,w,h);
		pnlAboutUs.setBackground(new Color(81,85,195));
		pnlLeftForward.add(pnlAboutUs);

		RoundedPanel.createRoundedPanel(pnlAboutUs,50);

		btnAboutUs=new JButton("About Us");
		btnAboutUs.setBounds(0,0,200,45);
		btnAboutUs.setFont(new Font("Arial Bold", Font.BOLD,18));
		btnAboutUs.setForeground(Color.WHITE);
		btnAboutUs.setBackground(new Color(81,85,195));
		//btnAboutUs.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlAboutUs.add(btnAboutUs);

		RoundedPanel.createRoundedButton(btnAboutUs,50);

		pnlAboutUsDescription=new JPanel();
		pnlAboutUsDescription.setLayout(null);
		pnlAboutUsDescription.setBounds(320,10,840,1025);
		pnlAboutUsDescription.setBackground(new Color(255,255,255));
		add(pnlAboutUsDescription);
		PanelState.hideComponents(pnlAboutUsDescription);

		pnlAboutUsInfo = ImagePanel.getPanel("imagesrc\\img-MSRTC-About-Us-1.jpg");
		pnlAboutUsInfo.setLayout(null);
		pnlAboutUsInfo.setBounds(10,10,820,970);
		pnlAboutUsDescription.add(pnlAboutUsInfo);

		btnCloseAboutUsDescription = new JButton("Close");
		btnCloseAboutUsDescription.setBounds(380,980,100,30);
		btnCloseAboutUsDescription.setBackground(Color.RED);
		btnCloseAboutUsDescription.setForeground(Color.WHITE);
		pnlAboutUsDescription.add(btnCloseAboutUsDescription);

//Services
		y += 58;

		pnlServices=new JPanel();
		pnlServices.setLayout(null);
		pnlServices.setBounds(x,y,w,h);
		pnlServices.setBackground(new Color(81,85,195));
        pnlLeftForward.add(pnlServices);

        RoundedPanel.createRoundedPanel(pnlServices,50);

        btnServices=new JButton("Services");
		btnServices.setBounds(0,0,200,45);
		btnServices.setFont(new Font("Arial Bold", Font.BOLD,20));
		btnServices.setForeground(Color.WHITE);
		btnServices.setBackground(new Color(81,85,195));
		//btnServices.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlServices.add(btnServices);

		RoundedPanel.createRoundedButton(btnServices,50);

		pnlServicesDescription=new JPanel();
		pnlServicesDescription.setLayout(null);
		pnlServicesDescription.setBounds(320,10,840,1025);
		pnlServicesDescription.setBackground(new Color(255,255,255));
        add(pnlServicesDescription);
        PanelState.hideComponents(pnlServicesDescription);

		pnlServicesInfo = ImagePanel.getPanel("imagesrc\\img-MSRTC-Services.jpg");
		pnlServicesInfo.setLayout(null);
		pnlServicesInfo.setBounds(10,10,820,970);
		pnlServicesDescription.add(pnlServicesInfo);

		btnCloseServicesDescription = new JButton("Close");
		btnCloseServicesDescription.setBounds(380,980,100,30);
		btnCloseServicesDescription.setBackground(Color.RED);
		btnCloseServicesDescription.setForeground(Color.WHITE);
		pnlServicesDescription.add(btnCloseServicesDescription);

//Gallery
		y += 58;

		pnlGallery=new JPanel();
		pnlGallery.setLayout(null);
		pnlGallery.setBounds(x,y,w,h);
		pnlGallery.setBackground(new Color(81,85,195));
        pnlLeftForward.add(pnlGallery);

        RoundedPanel.createRoundedPanel(pnlGallery,50);

        btnGallery=new JButton("Gallery");
		btnGallery.setBounds(0,0,200,45);
		btnGallery.setFont(new Font("Arial Bold", Font.BOLD,20));
		btnGallery.setForeground(Color.WHITE);
		btnGallery.setBackground(new Color(81,85,195));
		//btnGallery.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlGallery.add(btnGallery);

		RoundedPanel.createRoundedButton(btnGallery,50);

		pnlGalleryDescription=new JPanel();
		pnlGalleryDescription.setLayout(null);
		pnlGalleryDescription.setBounds(320,10,840,1025);
		pnlGalleryDescription.setBackground(new Color(255,255,255));
        add(pnlGalleryDescription);
        PanelState.hideComponents(pnlGalleryDescription);

		pnlGalleryInfo = ImagePanel.getPanel("imagesrc\\img-MSRTC-Gallery.png");
		pnlGalleryInfo.setLayout(null);
		pnlGalleryInfo.setBounds(0,10,820,970);
		pnlGalleryDescription.add(pnlGalleryInfo);

		btnCloseGalleryDescription = new JButton("Close");
		btnCloseGalleryDescription.setBounds(380,980,100,30);
		btnCloseGalleryDescription.setBackground(Color.RED);
		btnCloseGalleryDescription.setForeground(Color.WHITE);
		pnlGalleryDescription.add(btnCloseGalleryDescription);


		pnlCenterBottom = new JPanel();
		pnlCenterBottom.setLayout(null);
		pnlCenterBottom.setBounds(1475,795,436,245);//320,1590,90
		pnlCenterBottom.setBackground(ColorSetting.getBackColorCenterBottomPanel());
		VideoPanel.getVideoPanel(pnlCenterBottom,"videosrc\\vdoEmployee-Privileges.mp4");
		add(pnlCenterBottom);

		pnlBottomRight = ImagePanel.getPanel("imagesrc\\imgBusCrowd.jpeg");
		pnlBottomRight.setBounds(320,795,436,245);
		add(pnlBottomRight);

		pnlBottomLeft = new JPanel(); //ImagePanel.getPanel("imagesrc\\imgBusCrowd.jpeg");
		pnlBottomLeft.setBounds(766,795,699,245);
		pnlBottomLeft.setLayout(null);
		pnlBottomLeft.setBackground(Color.WHITE);
		add(pnlBottomLeft);

		lblDevelopers = new JLabel("<html><body><center>*Developed By*<br><br><p>Ms. Srushti A. Pardeshi&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mr. Mayank B. Bhat</p></center></body></html>");
		lblDevelopers.setBounds(100,0,699,245);
		lblDevelopers.setFont(new Font("Basic", Font.BOLD, 20));
		pnlBottomLeft.add(lblDevelopers);

		pnlCenter = new JPanel();
		pnlCenter.setBackground(new Color(81,85,195));
		pnlCenter.setLayout(null);
		pnlCenter.setBounds(320,260,1590,525);
		add(pnlCenter);

		RoundedPanel.createRoundedPanel(pnlCenter,25);

		pnlUI = new JPanel();
		pnlUI.setBounds(0,0,2000,535);
		pnlUI.setLayout(null);
		//pnlUI.setBackground(Color.WHITE);//255,255,143
		pnlCenter.add(pnlUI);

	    RoundedPanel.createRoundedPanel(pnlUI,25);

		pnlUIReport = new JPanel();
		pnlUIReport.setBounds(6,6,1128,535);
		pnlUIReport.setBackground(new Color(244,187,68)); //44,187,68
		pnlCenter.add(pnlUIReport);

		//Center Top Panel

		pnlCenterTop = new JPanel();
		pnlCenterTop.setLayout(null);
		pnlCenterTop.setBounds(320,10,1590,90);
		pnlCenterTop.setBackground(new Color(81,85,195));
		add(pnlCenterTop);

		 RoundedPanel.createRoundedPanel(pnlCenterTop,25);

		pnlEmployee = new JPanel();
		pnlEmployee.setBounds(-80,372,75,75);
		pnlEmployee.setLayout(null);
		//pnlEmployee.setBackground(new Color(0,112,245,0));
		pnlEmployee.setBackground(Color.WHITE);
		pnlLeft.add(pnlEmployee);

		RoundedPanel.createRoundedPanel(pnlEmployee,25);

		btnEmployee = new JButton(new ImageIcon(new ImageIcon("imagesrc\\imgEmployeeIcon.png").getImage().getScaledInstance(60,60,java.awt.Image.SCALE_SMOOTH)));
		btnEmployee.setBounds(3,3,70,70);
		//btnEmployee.setText("MSRTC Empolyees");
		//btnEmployee.setFont(new Font("Basic", Font.BOLD, 18));
		//btnEmployee.setBackground(new Color(0,112,245));
		btnEmployee.setBackground(Color.WHITE);
		//btnEmployee.setForeground(ColorSetting.getForeColorCenterBottomButton());
		btnEmployee.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlEmployee.add(btnEmployee);

		RoundedPanel.createRoundedButton(btnEmployee,100);

		pnlBuses = new JPanel();
		pnlBuses.setBounds(-80,459,75,75);//226
		pnlBuses.setLayout(null);
		//pnlBuses.setBackground(ColorSetting.getBackColorCenterTopPanel());
		pnlBuses.setBackground(Color.WHITE);
		pnlLeft.add(pnlBuses);

		RoundedPanel.createRoundedPanel(pnlBuses,25);

		btnBuses = new JButton(new ImageIcon(new ImageIcon("imagesrc\\imgBusIcon.png").getImage().getScaledInstance(55,55,java.awt.Image.SCALE_SMOOTH)));
		btnBuses.setBounds(3,3,70,70);
		//btnBuses.setText("Our Buses");
		//btnBuses.setFont(new Font("Basic", Font.BOLD, 18));
		//btnBuses.setBackground(ColorSetting.getBackColorCenterTopPanel());
		btnBuses.setBackground(Color.WHITE);
		//btnBuses.setForeground(ColorSetting.getForeColorCenterBottomButton());
		btnBuses.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlBuses.add(btnBuses);

		RoundedPanel.createRoundedButton(btnBuses,100);

		pnlRoot = new JPanel();
		pnlRoot.setBounds(-80,546,75,75);//377
		pnlRoot.setLayout(null);
		//pnlRoot.setBackground(ColorSetting.getBackColorCenterTopPanel());
		pnlRoot.setBackground(Color.WHITE);
		pnlLeft.add(pnlRoot);

		RoundedPanel.createRoundedPanel(pnlRoot,25);

		btnRoot = new JButton(new ImageIcon(new ImageIcon("imagesrc\\imgRootIcon.png").getImage().getScaledInstance(60,60,java.awt.Image.SCALE_SMOOTH)));
		btnRoot.setBounds(3,3,70,70);
		//btnRoot.setText("Daily Route ");
		//btnRoot.setFont(new Font("Basic", Font.BOLD, 18));
		//btnRoot.setBackground(ColorSetting.getBackColorCenterTopPanel());
		btnRoot.setBackground(Color.WHITE);
		//btnRoot.setForeground(ColorSetting.getForeColorCenterBottomButton());
		btnRoot.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlRoot.add(btnRoot);

		RoundedPanel.createRoundedButton(btnRoot,100);

		pnlAllocation = new JPanel();
		pnlAllocation.setBounds(-80,633,75,75);//528
		pnlAllocation.setLayout(null);
		//pnlAllocation.setBackground(ColorSetting.getBackColorCenterTopPanel());
		pnlAllocation.setBackground(Color.WHITE);
		pnlLeft.add(pnlAllocation);

		RoundedPanel.createRoundedPanel(pnlAllocation,25);

		btnAllocation = new JButton(new ImageIcon(new ImageIcon("imagesrc\\imgAllocationIcon.png").getImage().getScaledInstance(60,60,java.awt.Image.SCALE_SMOOTH)));
		btnAllocation.setBounds(3,3,70,70);
		//btnAllocation.setText("Allocate Service");
		//btnAllocation.setFont(new Font("Basic", Font.BOLD, 18));
		//btnAllocation.setBackground(ColorSetting.getBackColorCenterTopPanel());
		btnAllocation.setBackground(Color.WHITE);
		//btnAllocation.setForeground(ColorSetting.getForeColorCenterBottomButton());
		btnAllocation.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlAllocation.add(btnAllocation);

		RoundedPanel.createRoundedButton(btnAllocation,100);

		//Allocation
		lblNotice = new JLabel("*Note : Your entered data should not be dublicate.........!");
		lblNotice.setFont(new Font("Arial", Font.BOLD, 18));
		lblNotice.setForeground(Color.WHITE);
		lblNotice.setBounds(0,0,500,20);
		pnlCenterTop.add(lblNotice);

		pnlUserProfile = new JPanel();
		pnlUserProfile.setLayout(null);
		pnlUserProfile.setBounds(1310,20,275,65);
		pnlUserProfile.setBackground(Color.WHITE);
		pnlCenterTop.add(pnlUserProfile);
		RoundedPanel.createRoundedPanel(pnlUserProfile,25);

		pnlUserImage = ImagePanel.getPanel("imagesrc\\imgUserProfile.png");
		pnlUserImage.setLayout(null);
		pnlUserImage.setBounds(5,5,55,55);
		pnlUserImage.setBackground(Color.WHITE);
		pnlUserProfile.add(pnlUserImage);
		RoundedPanel.createRoundedPanel(pnlUserImage,10);

		lblUserName = new JLabel("Admin");
		lblUserName.setLayout(null);
		lblUserName.setBounds(75,23,200,18);
		lblUserName.setFont(new Font("Basic",Font.BOLD, 18));
		pnlUserProfile.add(lblUserName);

/*		lblSearchStation = new JLabel("Search Station Here >>>");
		lblSearchStation.setBounds(5,10,220,30);
		lblSearchStation.setFont(new Font("Basic",Font.BOLD, 18));
		lblSearchStation.setForeground(Color.WHITE);
		lblSearchStation.setBackground(ColorSetting.getBackColorCenterTopPanel());
		pnlSearchStation.add(lblSearchStation);
*/

		pnlSearchStation = new JPanel();
		pnlSearchStation.setBounds(950,47,300,39);
		pnlSearchStation.setLayout(null);
		pnlSearchStation.setBackground(new Color(255,255,255));
		pnlCenterTop.add(pnlSearchStation);

		RoundedPanel.createRoundedPanel(pnlSearchStation,39);

		txtSearchStation = new JTextField();
		txtSearchStation.setBounds(10,4,250,30);
		txtSearchStation.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		txtSearchStation.setFont(new Font("Basic",Font.BOLD, 18));
		txtSearchStation.setForeground(Color.BLACK);
		txtSearchStation.setBackground(Color.WHITE);
		pnlSearchStation.add(txtSearchStation);

		btnSearchStation = new JButton(new ImageIcon(new ImageIcon("imagesrc\\imgSearch.png").getImage().getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH)));
		btnSearchStation.setBounds(261,0,40,40);
		btnSearchStation.setBackground(new Color(153,217,234));
		pnlSearchStation.add(btnSearchStation);

		RoundedPanel.createRoundedButton(btnSearchStation,100);

		pnlTotalEmployee = new JPanel();//GradientPanel(Color.BLUE,Color.RED);
		pnlTotalEmployee.setLayout(null);
		pnlTotalEmployee.setBackground(new Color(153,9,240));
		pnlTotalEmployee.setBounds(320,110,390,140);//320,10,1590,90
		add(pnlTotalEmployee);

		RoundedPanel.createRoundedPanel(pnlTotalEmployee,25);

		lblTotalEmployee = new JLabel("<html><center> Total Employees Working<br> ..... </center></html>",JLabel.CENTER);
		//lblLeftBottom.setBackground(new Color(242,178,140));
		lblTotalEmployee.setForeground(Color.WHITE);
		lblTotalEmployee.setFont(new Font("Serif", Font.BOLD, 30));
		lblTotalEmployee.setBounds(70,10,250,110);
		pnlTotalEmployee.add(lblTotalEmployee);

		pnlTotalBuses = new JPanel();
		pnlTotalBuses.setLayout(null);
		pnlTotalBuses.setBackground(new Color(240,134,80));
		pnlTotalBuses.setBounds(720,110,390,140);//320,10,1590,90
		add(pnlTotalBuses);

		RoundedPanel.createRoundedPanel(pnlTotalBuses,25);

		lblTotalBuses = new JLabel("<html><center> Total Buses In Deport<br> ..... </center></html>",JLabel.CENTER);
		//lblLeftBottom.setBackground(new Color(242,178,140));
		lblTotalBuses.setForeground(Color.WHITE);
		lblTotalBuses.setFont(new Font("Serif", Font.BOLD, 30));
		lblTotalBuses.setBounds(70,10,250,110);
		pnlTotalBuses.add(lblTotalBuses);

		pnlTotalRoot = new JPanel();
		pnlTotalRoot.setLayout(null);
		pnlTotalRoot.setBackground(new Color(52,135,255));
		pnlTotalRoot.setBounds(1120,110,390,140);//320,10,1590,90
		add(pnlTotalRoot);

		RoundedPanel.createRoundedPanel(pnlTotalRoot,25);

		lblTotalRoot = new JLabel("<html><center> Total Connected Routs<br> ..... </center></html>",JLabel.CENTER);
		//lblLeftBottom.setBackground(new Color(242,178,140));
		lblTotalRoot.setForeground(Color.WHITE);
		lblTotalRoot.setFont(new Font("Serif", Font.BOLD, 30));
		lblTotalRoot.setBounds(70,10,250,110);
		pnlTotalRoot.add(lblTotalRoot);

		pnlTotalAllocation = new JPanel();
		pnlTotalAllocation.setLayout(null);
		pnlTotalAllocation.setBackground(new Color(110,235,91));
		pnlTotalAllocation.setBounds(1520,110,390,140);//320,10,1590,90
		add(pnlTotalAllocation);

		RoundedPanel.createRoundedPanel(pnlTotalAllocation,25);

		lblTotalAllocation = new JLabel("<html><center>Today's Total Allocation<br> ..... </center></html>",JLabel.CENTER);
		//lblLeftBottom.setBackground(new Color(242,178,140));
		lblTotalAllocation.setForeground(Color.WHITE);
		lblTotalAllocation.setFont(new Font("Serif", Font.BOLD, 30));
		lblTotalAllocation.setBounds(70,10,250,110);
		pnlTotalAllocation.add(lblTotalAllocation);

		pnlRootStopDisplay = new JPanel();
		pnlRootStopDisplay.setBounds(5,401,200,45);
		pnlRootStopDisplay.setLayout(null);
		pnlRootStopDisplay.setBackground(new Color(81,85,195));
		pnlLeftForward.add(pnlRootStopDisplay);

		RoundedPanel.createRoundedPanel(pnlRootStopDisplay,50);

		btnRootStopDisplay = new JButton();
		btnRootStopDisplay.setBounds(0,0,200,45);
		btnRootStopDisplay.setText("Show Root Stops");
		btnRootStopDisplay.setFont(new Font("Basic", Font.BOLD, 18));
		btnRootStopDisplay.setBackground(new Color(81,85,195));
		btnRootStopDisplay.setForeground(Color.WHITE);
		pnlRootStopDisplay.add(btnRootStopDisplay);

		RoundedPanel.createRoundedButton(btnRootStopDisplay,50);

		pnlRootGoogleMapDisplay = new JPanel();
		pnlRootGoogleMapDisplay.setBounds(5,459,200,45);
		pnlRootGoogleMapDisplay.setLayout(null);
		pnlRootGoogleMapDisplay.setBackground(new Color(81,85,195));
		pnlLeftForward.add(pnlRootGoogleMapDisplay);

		RoundedPanel.createRoundedPanel(pnlRootGoogleMapDisplay,50);

		btnRootGoogleMapDisplay = new JButton();
		btnRootGoogleMapDisplay.setBounds(0,0,200,45);
		btnRootGoogleMapDisplay.setText("Show Google Map");
		btnRootGoogleMapDisplay.setFont(new Font("Basic", Font.BOLD, 18));
		btnRootGoogleMapDisplay.setBackground(new Color(81,85,195));
		btnRootGoogleMapDisplay.setForeground(Color.WHITE);
		pnlRootGoogleMapDisplay.add(btnRootGoogleMapDisplay);

		RoundedPanel.createRoundedButton(btnRootGoogleMapDisplay,50);

		pnlMSRTCWeb = new JPanel();
		pnlMSRTCWeb.setLayout(null);
		pnlMSRTCWeb.setBounds(20,48,590,40);
		pnlMSRTCWeb.setBackground(new Color(255,255,255,0));
		pnlCenterTop.add(pnlMSRTCWeb);

		lblMSRTCWeb = new JLabel("Click Go button to visit our website 'www.msrtc.gov.in' >>>");
		lblMSRTCWeb.setBounds(0,0,530,40);
		lblMSRTCWeb.setFont(new Font("Basic", Font.BOLD, 18));
		lblMSRTCWeb.setBackground(ColorSetting.getBackColorCenterBottomButton());
		lblMSRTCWeb.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlMSRTCWeb.add(lblMSRTCWeb);

		btnMSRTCWeb = new JButton();
		btnMSRTCWeb.setBounds(530,0,60,40);
		btnMSRTCWeb.setText("Go");
		btnMSRTCWeb.setFont(new Font("Basic", Font.BOLD, 18));
		btnMSRTCWeb.setBackground(new Color(255,255,255));
		btnMSRTCWeb.setForeground(new Color(0,0,0));
		pnlMSRTCWeb.add(btnMSRTCWeb);

		RoundedPanel.createRoundedButton(btnMSRTCWeb,25);




		//Left panel

		//Images in Left Middel Panels

/*		pnlRightTop = ImagePanel.getPanel("imagesrc\\imgRightTopPanel-MSRTC-bus-time-table-ST-bus-time-table.jpeg");
		pnlRightTop.setBounds(6,6,358,356);
		pnlRightTop.setLayout(null);
		pnlRight.add(pnlRightTop);

		RoundedPanel.createRoundedPanel(pnlRightTop,25);


		//Images in Left Bottom Panels

		pnlRightMiddel = ImagePanel.getPanel("imagesrc\\imgChopdaBusStand.jpg");
		pnlRightMiddel.setBounds(6,367,358,357);
		pnlRightMiddel.setLayout(null);
		pnlRight.add(pnlRightMiddel);
		RoundedPanel.createRoundedPanel(pnlRightMiddel,25);
*/


		//setDefaultSettings();
	}

/*	void setDefaultSettings()
	{

		PanelState.disabledComponents(pnlNew);
		PanelState.disabledComponents(pnlSave);
		PanelState.disabledComponents(pnlView);
		PanelState.disabledComponents(pnlEdit);
		PanelState.disabledComponents(pnlUpdate);
		PanelState.disabledComponents(pnlDelete);
		PanelState.disabledComponents(pnlCancle);
		PanelState.disabledComponents(pnlReport);
		PanelState.disabledComponents(pnlClose);
		PanelState.disabledComponents(pnlCombo1);
		PanelState.disabledComponents(pnlCombo2);
	    PanelState.disabledComponents(pnlCombo3);
	    PanelState.disabledComponents(pnlCombo4);
		PanelState.disabledComponents(pnlApply);
		PanelState.hideComponents(pnlUIReport);
	}
*/

	public JLabel getNoticeLabel()
	{
		return(lblNotice);
	}
	public JPanel getUIPanel()
	{
	    return(pnlUI);
	}

	public JPanel getCenterTopPanel()
	{
	    return(pnlCenterTop);
	}

	public JPanel getCenterBottomPanel()
	{
	    return(pnlCenterBottom);
	}

	public JPanel getUIReportPanel()
	{
		return(pnlUIReport);
	}

	public JPanel getRootStopDisplayPanel()
	{
		return(pnlRootStopDisplay);
	}

	public JButton getRootStopDisplayButton()
	{
		return(btnRootStopDisplay);
	}

	public JPanel getManageEmployeePanel()
	{
		return(pnlManageEmployee);
	}

	public JButton getManageEmployeeButton()
	{
		return(btnManageEmployee);
	}

	public JPanel getManageRootPanel()
	{
		return(pnlManageRoot);
	}

	public JButton getManageRootButton()
	{
		return(btnManageRoot);
	}

	public JPanel getManageBusPanel()
	{
		return(pnlManageBus);
	}

	public JButton getManageBusButton()
	{
		return(btnManageBus);
	}

	public JPanel getManageAllocationPanel()
	{
		return(pnlManageAllocation);
	}

	public JButton getManageAllocationButton()
	{
		return(btnManageAllocation);
	}

	public JPanel getEmployeePanel()
	{
		return(pnlEmployee);
	}

	public JButton getEmployeeButton()
	{
		return(btnEmployee);
	}

	public JPanel getBusesPanel()
	{
		return(pnlBuses);
	}

	public JButton getBusesButton()
	{
		return(btnBuses);
	}
	public JPanel getRootPanel()
	{
		return(pnlRoot);
	}

	public JButton getRootButton()
	{
		return(btnRoot);
	}
	public JPanel getAllocationPanel()
	{
		return(pnlAllocation);
	}

	public JButton getAllocationButton()
	{
		return(btnAllocation);
	}
	public JButton getSearchStationButton()
	{
		return(btnSearchStation);
	}
	public JLabel getSearchStationLabel()
	{
		return(lblSearchStation);
	}
	public JPanel getSearchStationPanel()
	{
		return(pnlSearchStation);
	}

	public JLabel getMSRTCWebLabel()
	{
		return(lblMSRTCWeb);
	}

	public JButton getMSRTCWebButton()
	{
		return(btnMSRTCWeb);
	}

	public JTextField getSearchStationTextField()
	{
		return(txtSearchStation);
	}

/*	public JPanel getRightMiddelPanel()
	{
		return(pnlRightMiddel);
	}
*/


	public JPanel getBottomLeftPanel()
	{
		return(pnlBottomLeft);
	}

	public JPanel getBottomRightPanel()
	{
		return(pnlBottomRight);
	}

	public JPanel getRootGoogleMapDisplayPanel()
	{
		return (pnlRootGoogleMapDisplay);
	}
	public JButton getRootGoogleMapDisplayButton()
	{
		return (btnRootGoogleMapDisplay);
	}

	public JLabel getTotalEmployeeLable()
	{
		return(lblTotalEmployee);
	}

	public JLabel getTotalBusesLable()
	{
		return(lblTotalBuses);
	}

	public JLabel getTotalRootLable()
	{
		return(lblTotalRoot);
	}

	public JLabel getTotalAllocationLable()
	{
		return(lblTotalAllocation);
	}

	public JPanel getLeftForwardPanel()
	{
		return(pnlLeftForward);
	}

	public JPanel getLeftPanel()
	{
		return(pnlLeft);
	}

	public JButton getLogoutButton()
	{
		return(btnLogout);
	}

	public JPanel getAboutUsPanel()
	{
		return(pnlAboutUs);
	}

	public JButton getAboutUsButton()
	{
		return(btnAboutUs);
	}

	public JPanel getAboutUsDescriptionPanel()
	{
		return(pnlAboutUsDescription);
	}

	public JPanel getAboutUsInfoPanel()
	{
		return(pnlAboutUsInfo);
	}

	public JButton getCloseAboutUsDescriptionButton()
	{
		return(btnCloseAboutUsDescription);
	}

//Services getter

	public JPanel getServicePanel()
	{
		return(pnlServices);
	}

	public JButton getServiceButton()
	{
		return(btnServices);
	}

	public JPanel getServiceDescriptionPanel()
	{
		return(pnlServicesDescription);
	}

	public JPanel getServiceInfoPanel()
	{
		return(pnlServicesInfo);
	}

	public JButton getCloseServiceDescriptionButton()
	{
		return(btnCloseServicesDescription);
	}

//Gallery getters

	public JPanel getGalleryPanel()
	{
		return(pnlGallery);
	}

	public JButton getGalleryButton()
	{
		return(btnGallery);
	}

	public JPanel getGalleryDescriptionPanel()
	{
		return(pnlGalleryDescription);
	}

	public JPanel getGalleryInfoPanel()
	{
		return(pnlGalleryInfo);
	}

	public JButton getCloseGalleryDescriptionButton()
	{
		return(btnCloseGalleryDescription);
	}

	public static void main(String args[])
	{
		new DashboardDesign();
	}
}
