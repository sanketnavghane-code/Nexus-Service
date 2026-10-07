package screensetting;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import appsetting.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import myUtility.*;
import myDesign.*;

public class MainDesign extends JPanel
{
	JPanel pnlAll;

	JPanel pnlTop;

	JLabel lblMainLogo;
	JLabel lblMainHeading;
	JLabel lblProgramHeading;

	//JPanel pnlLeft;
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

	JPanel pnlEmployee;
	JButton btnEmployee;

	JPanel pnlBuses;
	JButton btnBuses;

	JPanel pnlAllocation;
	JButton btnAllocation;

    JPanel pnlRoot;
	JButton btnRoot;

	JLabel lblMSRTCWeb;
	JButton btnMSRTCWeb;

	JButton btnSearchStation;
	JPanel pnlSearchStation;
	JLabel lblSearchStation;
	JTextField txtSearchStation;

	ImageIcon imgLeftMiddel;


	ImageIcon imgLeftBottom;


	JLabel lblMovingBusDeveloperList;

	JPanel pnlUI;

	public MainDesign()
	{
		setSize(1950,1200);
		setLocation(1,1);
		setLayout(null);
		setVisible(true);
		setBackground(Color.WHITE);

		pnlTop = new JPanel();
		pnlTop.setLayout(null);
		pnlTop.setBackground(ColorSetting.getBackColorTopPanel());
		pnlTop.setBounds(10,10,1900,140);
		add(pnlTop);



		 RoundedPanel.createRoundedPanel(pnlTop,25);


		//Main Logo and Main Heading

		lblMainLogo = new JLabel(new ImageIcon(new ImageIcon("imagesrc\\mainLogoBgRemoved.png").getImage().getScaledInstance(160,140,java.awt.Image.SCALE_SMOOTH)));
		lblMainLogo.setBounds(0,0,160,140);
		pnlTop.add(lblMainLogo);

		lblMainHeading = new JLabel("MSRTC Service Allocation System");
		lblMainHeading.setBounds(170,30,1500,80);
		lblMainHeading.setFont(new Font("Forte",Font.BOLD, 80));
		lblMainHeading.setForeground(Color.WHITE);
		pnlTop.add(lblMainHeading);

		pnlCenter = new JPanel();
		pnlCenter.setBackground(ColorSetting.getBackColorCenterPanel());
		pnlCenter.setLayout(null);
		pnlCenter.setBounds(10,260,1520,547);
		add(pnlCenter);

		RoundedPanel.createRoundedPanel(pnlCenter,25);

		pnlUI = new JPanel();
		pnlUI.setBounds(6,6,1128,535);
		pnlUI.setLayout(null);
		pnlUI.setBackground(ColorSetting.getBackColorUIPanel());//255,255,143
		pnlCenter.add(pnlUI);

	    RoundedPanel.createRoundedPanel(pnlUI,25);

		pnlUIReport = new JPanel();
		pnlUIReport.setBounds(6,6,1128,535);
		pnlUIReport.setBackground(new Color(244,187,68)); //44,187,68
		pnlCenter.add(pnlUIReport);

		/*pnlLeft = new JPanel();
		pnlLeft.setLayout(null);
		pnlLeft.setBackground(ColorSetting.getBackColorLeftPanel());
		pnlLeft.setBounds(10,160,130,730);
		add(pnlLeft);

	    RoundedPanel.createRoundedPanel(pnlLeft,25);*/

		pnlRight = new JPanel();
		pnlRight.setLayout(null);
		pnlRight.setBackground(ColorSetting.getBackColorRightPanel());
		pnlRight.setBounds(1540,160,370,730);
		add(pnlRight);

	    RoundedPanel.createRoundedPanel(pnlRight,25);


		pnlBottomRight = new JPanel();
		pnlBottomRight.setLayout(null);
		pnlBottomRight.setBackground(ColorSetting.getBackColorBottomPanel());
		pnlBottomRight.setBounds(500,900,1400,140);
		add(pnlBottomRight);

		RoundedPanel.createRoundedPanel(pnlBottomRight,25);

		pnlBottomLeft = new JPanel();
		pnlBottomLeft.setLayout(null);
		pnlBottomLeft.setBackground(ColorSetting.getBackColorBottomPanel());
		pnlBottomLeft.setBounds(10,900,480,140);
		add(pnlBottomLeft);


		lblLeftBottom = new JLabel("<html><center> Our Talent <br> Spins The World... </center></html>",JLabel.CENTER);
		//lblLeftBottom.setBackground(new Color(242,178,140));
		lblLeftBottom.setForeground(Color.WHITE);
		lblLeftBottom.setFont(new Font("Serif", Font.BOLD, 30));
		lblLeftBottom.setBounds(10,10,460,120);
		pnlBottomLeft.add(lblLeftBottom);

	    RoundedPanel.createRoundedPanel(pnlBottomLeft,25);

		lblMovingBusDeveloperList = new JLabel(new ImageIcon(new ImageIcon("imagesrc\\imgBus3_And_DeveloperList.png").getImage().getScaledInstance(1700,110,java.awt.Image.SCALE_SMOOTH)));
		lblMovingBusDeveloperList.setBounds(0,30,1700,110);
		lblMovingBusDeveloperList.setFont(new Font("Serif", Font.BOLD, 30));
		lblMovingBusDeveloperList.setForeground(Color.WHITE);
		pnlBottomRight.add(lblMovingBusDeveloperList);

		//Center Top Panel

		pnlCenterTop = new JPanel();
		pnlCenterTop.setLayout(null);
		pnlCenterTop.setBounds(10,160,1520,90);
		pnlCenterTop.setBackground(ColorSetting.getBackColorCenterTopPanel());
		add(pnlCenterTop);

		 RoundedPanel.createRoundedPanel(pnlCenterTop,25);

		pnlEmployee = new JPanel();
		pnlEmployee.setBounds(-76,18,76,70);
		pnlEmployee.setLayout(null);
		//pnlEmployee.setBackground(ColorSetting.getBackColorCenterTopPanel());
		pnlEmployee.setBackground(Color.WHITE);
		pnlCenterTop.add(pnlEmployee);

		RoundedPanel.createRoundedPanel(pnlEmployee,100);

		btnEmployee = new JButton(new ImageIcon(new ImageIcon("imagesrc\\imgEmployeeIcon.png").getImage().getScaledInstance(60,60,java.awt.Image.SCALE_SMOOTH)));
		btnEmployee.setBounds(3,0,70,70);
		//btnEmployee.setText("MSRTC Empolyees");
		//btnEmployee.setFont(new Font("Basic", Font.BOLD, 18));
		//btnEmployee.setBackground(ColorSetting.getBackColorCenterTopPanel());
		btnEmployee.setBackground(Color.WHITE);
		//btnEmployee.setForeground(ColorSetting.getForeColorCenterBottomButton());
		btnEmployee.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlEmployee.add(btnEmployee);

		RoundedPanel.createRoundedButton(btnEmployee,100);

		pnlBuses = new JPanel();
		pnlBuses.setBounds(-76,18,76,70);//226
		pnlBuses.setLayout(null);
		//pnlBuses.setBackground(ColorSetting.getBackColorCenterTopPanel());
		pnlBuses.setBackground(Color.WHITE);
		pnlCenterTop.add(pnlBuses);

		RoundedPanel.createRoundedPanel(pnlBuses,100);

		btnBuses = new JButton(new ImageIcon(new ImageIcon("imagesrc\\imgBusIcon.png").getImage().getScaledInstance(55,55,java.awt.Image.SCALE_SMOOTH)));
		btnBuses.setBounds(3,0,70,70);
		//btnBuses.setText("Our Buses");
		//btnBuses.setFont(new Font("Basic", Font.BOLD, 18));
		//btnBuses.setBackground(ColorSetting.getBackColorCenterTopPanel());
		btnBuses.setBackground(Color.WHITE);
		//btnBuses.setForeground(ColorSetting.getForeColorCenterBottomButton());
		btnBuses.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlBuses.add(btnBuses);

		RoundedPanel.createRoundedButton(btnBuses,100);

		pnlRoot = new JPanel();
		pnlRoot.setBounds(-76,18,76,70);//377
		pnlRoot.setLayout(null);
		//pnlRoot.setBackground(ColorSetting.getBackColorCenterTopPanel());
		pnlRoot.setBackground(Color.WHITE);
		pnlCenterTop.add(pnlRoot);

		RoundedPanel.createRoundedPanel(pnlRoot,100);

		btnRoot = new JButton(new ImageIcon(new ImageIcon("imagesrc\\imgRootIcon.png").getImage().getScaledInstance(60,60,java.awt.Image.SCALE_SMOOTH)));
		btnRoot.setBounds(3,0,70,70);
		//btnRoot.setText("Daily Route ");
		//btnRoot.setFont(new Font("Basic", Font.BOLD, 18));
		//btnRoot.setBackground(ColorSetting.getBackColorCenterTopPanel());
		btnRoot.setBackground(Color.WHITE);
		//btnRoot.setForeground(ColorSetting.getForeColorCenterBottomButton());
		btnRoot.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlRoot.add(btnRoot);

		RoundedPanel.createRoundedButton(btnRoot,100);

		pnlAllocation = new JPanel();
		pnlAllocation.setBounds(-76,18,76,70);//528
		pnlAllocation.setLayout(null);
		//pnlAllocation.setBackground(ColorSetting.getBackColorCenterTopPanel());
		pnlAllocation.setBackground(Color.WHITE);
		pnlCenterTop.add(pnlAllocation);

		RoundedPanel.createRoundedPanel(pnlAllocation,100);

		btnAllocation = new JButton(new ImageIcon(new ImageIcon("imagesrc\\imgAllocationIcon.png").getImage().getScaledInstance(60,60,java.awt.Image.SCALE_SMOOTH)));
		btnAllocation.setBounds(3,0,70,70);
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

		pnlSearchStation = new JPanel();
		pnlSearchStation.setBounds(900,40,570,50);
		pnlSearchStation.setLayout(null);
		pnlSearchStation.setBackground(ColorSetting.getBackColorCenterTopPanel());
		pnlCenterTop.add(pnlSearchStation);

		RoundedPanel.createRoundedPanel(pnlSearchStation,25);

		lblSearchStation = new JLabel("Search Station Here >>>");
		lblSearchStation.setBounds(5,10,220,30);
		lblSearchStation.setFont(new Font("Basic",Font.BOLD, 18));
		lblSearchStation.setForeground(Color.WHITE);
		lblSearchStation.setBackground(ColorSetting.getBackColorCenterTopPanel());
		pnlSearchStation.add(lblSearchStation);

		txtSearchStation = new JTextField();
		txtSearchStation.setBounds(225,10,260,30);
		txtSearchStation.setFont(new Font("Basic",Font.BOLD, 18));
		txtSearchStation.setForeground(Color.BLACK);
		txtSearchStation.setBackground(Color.WHITE);
		pnlSearchStation.add(txtSearchStation);

		btnSearchStation = new JButton(new ImageIcon(new ImageIcon("imagesrc\\imgSearch.png").getImage().getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH)));
		btnSearchStation.setBounds(495,10,30,30);
		pnlSearchStation.add(btnSearchStation);

		RoundedPanel.createRoundedButton(btnSearchStation,25);



		//Center Bottom panel and buttons

		pnlCenterBottom = new JPanel();
		pnlCenterBottom.setLayout(null);
		pnlCenterBottom.setBounds(10,818,1520,72);
		pnlCenterBottom.setBackground(ColorSetting.getBackColorCenterBottomPanel());
		add(pnlCenterBottom);

		RoundedPanel.createRoundedPanel(pnlCenterBottom,25);


		pnlRootStopDisplay = new JPanel();
		pnlRootStopDisplay.setBounds(260,13,200,50);
		pnlRootStopDisplay.setLayout(null);
		pnlRootStopDisplay.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlRootStopDisplay);

		RoundedPanel.createRoundedPanel(pnlRootStopDisplay,25);

		btnRootStopDisplay = new JButton();
		btnRootStopDisplay.setBounds(7,5,187,40);
		btnRootStopDisplay.setText("Show Root Stops");
		btnRootStopDisplay.setFont(new Font("Basic", Font.BOLD, 18));
		btnRootStopDisplay.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnRootStopDisplay.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlRootStopDisplay.add(btnRootStopDisplay);

		RoundedPanel.createRoundedButton(btnRootStopDisplay,25);

		pnlRootGoogleMapDisplay = new JPanel();
		pnlRootGoogleMapDisplay.setBounds(470,13,283,50);
		pnlRootGoogleMapDisplay.setLayout(null);
		pnlRootGoogleMapDisplay.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlRootGoogleMapDisplay);

		RoundedPanel.createRoundedPanel(pnlRootGoogleMapDisplay,25);

		btnRootGoogleMapDisplay = new JButton();
		btnRootGoogleMapDisplay.setBounds(7,5,270,40);
		btnRootGoogleMapDisplay.setText("Show Root On Google Map");
		btnRootGoogleMapDisplay.setFont(new Font("Basic", Font.BOLD, 18));
		btnRootGoogleMapDisplay.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnRootGoogleMapDisplay.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlRootGoogleMapDisplay.add(btnRootGoogleMapDisplay);

		RoundedPanel.createRoundedButton(btnRootGoogleMapDisplay,25);

		pnlManageEmployee = new JPanel();
		pnlManageEmployee.setBounds(50,12,228,50);
		pnlManageEmployee.setLayout(null);
		pnlManageEmployee.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlManageEmployee);

		RoundedPanel.createRoundedPanel(pnlManageEmployee,25);

		btnManageEmployee = new JButton();
		btnManageEmployee.setBounds(7,5,216,40);
		btnManageEmployee.setText("Manage Employee");
		btnManageEmployee.setFont(new Font("Basic", Font.BOLD, 18));
		btnManageEmployee.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnManageEmployee.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlManageEmployee.add(btnManageEmployee);

		RoundedPanel.createRoundedButton(btnManageEmployee,25);

		pnlManageBus = new JPanel();
		pnlManageBus.setBounds(50,12,200,50);
		pnlManageBus.setLayout(null);
		pnlManageBus.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlManageBus);

		RoundedPanel.createRoundedPanel(pnlManageBus,25);

		btnManageBus = new JButton();
		btnManageBus.setBounds(7,5,187,40);
		btnManageBus.setText("Manage Bus");
		btnManageBus.setFont(new Font("Basic", Font.BOLD, 18));
		btnManageBus.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnManageBus.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlManageBus.add(btnManageBus);

		RoundedPanel.createRoundedButton(btnManageBus,25);

		pnlManageRoot = new JPanel();
		pnlManageRoot.setBounds(50,12,200,50);
		pnlManageRoot.setLayout(null);
		pnlManageRoot.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlManageRoot);

		RoundedPanel.createRoundedPanel(pnlManageRoot,25);

		btnManageRoot = new JButton();
		btnManageRoot.setBounds(7,5,187,40);
		btnManageRoot.setText("Manage Root");
		btnManageRoot.setFont(new Font("Basic", Font.BOLD, 18));
		btnManageRoot.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnManageRoot.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlManageRoot.add(btnManageRoot);

		RoundedPanel.createRoundedButton(btnManageRoot,25);

		pnlManageAllocation = new JPanel();
		pnlManageAllocation.setBounds(50,12,230,50);
		pnlManageAllocation.setLayout(null);
		pnlManageAllocation.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlManageAllocation);

		RoundedPanel.createRoundedPanel(pnlManageAllocation,25);

		btnManageAllocation = new JButton();
		btnManageAllocation.setBounds(7,5,215,40);
		btnManageAllocation.setText("Manage Allocation");
		btnManageAllocation.setFont(new Font("Basic", Font.BOLD, 18));
		btnManageAllocation.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnManageAllocation.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlManageAllocation.add(btnManageAllocation);

		RoundedPanel.createRoundedButton(btnManageAllocation,25);

		lblMSRTCWeb = new JLabel("Click Go button to visit our website 'www.msrtc.gov.in' >>>");
		lblMSRTCWeb.setBounds(840,15,530,40);
		lblMSRTCWeb.setFont(new Font("Basic", Font.BOLD, 18));
		lblMSRTCWeb.setBackground(ColorSetting.getBackColorCenterBottomButton());
		lblMSRTCWeb.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlCenterBottom.add(lblMSRTCWeb);

		btnMSRTCWeb = new JButton();
		btnMSRTCWeb.setBounds(1367,15,60,40);
		btnMSRTCWeb.setText("Go");
		btnMSRTCWeb.setFont(new Font("Basic", Font.BOLD, 18));
		btnMSRTCWeb.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnMSRTCWeb.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlCenterBottom.add(btnMSRTCWeb);

		RoundedPanel.createRoundedButton(btnMSRTCWeb,25);




		//Left panel

		//Images in Left Middel Panels

		pnlRightTop = ImagePanel.getPanel("imagesrc\\imgRightTopPanel-MSRTC-bus-time-table-ST-bus-time-table.jpeg");
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
	public JLabel getProgramHeadingLabel()
	{
		return(lblProgramHeading);
	}

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

	public JPanel getRightMiddelPanel()
	{
		return(pnlRightMiddel);
	}

	public JLabel getDeveloperListLable()
	{
		return(lblMovingBusDeveloperList);
	}

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
	public static void main(String args[])
	{
		new MainDesign();
	}
}
