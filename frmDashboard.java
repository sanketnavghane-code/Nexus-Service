import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;
import goonline.*;
import myDesign.*;

class frmDashboard extends JFrame implements ActionListener, FocusListener
{
	JPanel pnlUI;
	JPanel pnlUIReport;

	JPanel pnlUserImage;

	JPanel pnlEmployeeDisplay;
	JPanel pnlBusesDisplay;
	JPanel pnlRootDisplay;
	JPanel pnlAllocationDisplay;

	JPanel pnlRootStopDisplay;
	JButton btnRootStopDisplay;

	JPanel pnlSelectedButtonHighlight;

	JPanel pnlEmployee;
	JButton btnEmployee;

	JPanel pnlBuses;
	JButton btnBuses;

	JPanel pnlAllocation;
	JButton btnAllocation;

    JPanel pnlRoot;
	JButton btnRoot;

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

	JPanel pnlRootGoogleMapDisplay;
	JButton btnRootGoogleMapDisplay;

	JPanel pnlSearchStation;
	JButton btnSearchStation;
	JLabel lblSearchStation;
	JTextField txtSearchStation;

	DashboardDesign myUI;

	JPanel pnlCenterTop;
	JPanel pnlCenterBottom;
	JPanel pnlBottomRight;
	JPanel pnlBottomLeft;

	JPanel pnlLeft;

	JButton btnShowButton;

	JLabel lblMovingBusDeveloperList;

	JPanel pnlRightMiddel;
	String[] slideShowImages = {"imagesrc\\busAndLogo.jpeg","imagesrc\\MSRTC-Satara-Bharti-2024-3.jpg.webp",
								"imagesrc\\imgChopdaBusStand.jpg","imagesrc\\imgRightTopPanel.jpeg",
								"imagesrc\\imgWomanDriver.jpeg","imagesrc\\imgBusCrowd.jpeg"};

	JLabel lblTotalEmployee;
	JLabel lblTotalBuses;
	JLabel lblTotalRoot;
	JLabel lblTotalAllocation;

	JLabel lblProgramHeading;
	JLabel lblNotice;

	JButton btnLogout;

	JLabel lblMSRTCWeb;
	JButton btnMSRTCWeb;

	DateManager TodayDate;
	JTable MyTable ;

	private static javax.swing.Timer timerButtons;
	java.util.Timer timerStarter;


	int Rcols =0;
	ReportTool tool;

	int Rcols2 =0;
	ReportTool tool2;

	int Rcols3 =0;
	ReportTool tool3;

	int Rcols4 =0;
	ReportTool tool4;

	String vDestinationSearch = null;

	frmDashboard()
	{
		setSize(1950,1200);
		setLocation(1,1);
		setLayout(null);
		setBackground(ColorSetting.getBackColorFrame());
		setTitle("ServiceNexus");
		setIconImage(new ImageIcon("imagesrc\\img-ServiceNexus-Logo.png").getImage());
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );


		myUI = new DashboardDesign();
		add(myUI);

		pnlCenterTop = myUI.getCenterTopPanel();
		pnlLeft = myUI.getLeftPanel();

		pnlAboutUs = myUI.getAboutUsPanel();
		btnAboutUs = myUI.getAboutUsButton();
		pnlAboutUsDescription = myUI.getAboutUsDescriptionPanel();
		pnlAboutUsInfo = myUI.getAboutUsInfoPanel();
		btnCloseAboutUsDescription = myUI.getCloseAboutUsDescriptionButton();

		btnAboutUs.addActionListener(e -> {
			PanelState.hideComponents(pnlGalleryDescription);
			PanelState.hideComponents(pnlServicesDescription);
			PanelState.visibleComponents(pnlAboutUsDescription);
		});

		btnCloseAboutUsDescription.addActionListener(e -> {
			PanelState.hideComponents(pnlAboutUsDescription);
		});

		pnlServices = myUI.getServicePanel();
		btnServices = myUI.getServiceButton();
		pnlServicesDescription = myUI.getServiceDescriptionPanel();
		pnlServicesInfo = myUI.getServiceInfoPanel();
		btnCloseServicesDescription = myUI.getCloseServiceDescriptionButton();

		btnServices.addActionListener(e -> {
			PanelState.hideComponents(pnlGalleryDescription);
			PanelState.hideComponents(pnlAboutUsDescription);
			PanelState.visibleComponents(pnlServicesDescription);
		});

		btnCloseServicesDescription.addActionListener(e -> {
			PanelState.hideComponents(pnlServicesDescription);
		});

// For Gallery

		pnlGallery = myUI.getGalleryPanel();
		btnGallery = myUI.getGalleryButton();
		pnlGalleryDescription = myUI.getGalleryDescriptionPanel();
		pnlGalleryInfo = myUI.getGalleryInfoPanel();
		btnCloseGalleryDescription = myUI.getCloseGalleryDescriptionButton();

		btnGallery.addActionListener(e -> {
			PanelState.hideComponents(pnlServicesDescription);
			PanelState.hideComponents(pnlAboutUsDescription);
			PanelState.visibleComponents(pnlGalleryDescription);
		});

		btnCloseGalleryDescription.addActionListener(e -> {
			PanelState.hideComponents(pnlGalleryDescription);
		});

		btnLogout = myUI.getLogoutButton();

		pnlUI = myUI.getUIPanel();
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,1580,515);//1115,525

		pnlUIReport = myUI.getUIReportPanel();
		UISetting.setArea(pnlUIReport,1115,525);
		PanelState.hideComponents(pnlUIReport);

		pnlSelectedButtonHighlight = new JPanel();
		pnlSelectedButtonHighlight.setLayout(null);
		pnlSelectedButtonHighlight.setBounds(5,370,115,79);
		pnlSelectedButtonHighlight.setBackground(Color.WHITE);
		RoundedPanel.createRoundedPanel(pnlSelectedButtonHighlight,50);
		PanelState.hideComponents(pnlSelectedButtonHighlight);
		pnlLeft.add(pnlSelectedButtonHighlight);

		btnShowButton = new JButton(new ImageIcon(new ImageIcon("imagesrc\\fast-forward.png").getImage().getScaledInstance(60,60,java.awt.Image.SCALE_SMOOTH)));
		btnShowButton.setBounds(12,250,75,75);//226
		btnShowButton.setBackground(new Color(255,255,255,0));
		btnShowButton.setOpaque(false);
		btnShowButton.setVisible(false);
		pnlLeft.add(btnShowButton);

		btnShowButton.addActionListener(this);

		pnlAllocation = myUI.getAllocationPanel();
		btnAllocation = myUI.getAllocationButton();
		btnAllocation.addActionListener(this);
		btnAllocation.setToolTipText("Allocate Service...");

		pnlRoot = myUI.getRootPanel();
		btnRoot = myUI.getRootButton();
		btnRoot.addActionListener(this);
		btnRoot.setToolTipText("Daily Routes...");

		pnlBuses = myUI.getBusesPanel();
		btnBuses = myUI.getBusesButton();
		btnBuses.addActionListener(this);
		btnBuses.setToolTipText("Our Buses...");

		pnlEmployee = myUI.getEmployeePanel();
		btnEmployee = myUI.getEmployeeButton();
		btnEmployee.addActionListener(this);
		btnEmployee.setToolTipText("Employee List...");


		lblTotalEmployee = myUI.getTotalEmployeeLable();
		lblTotalBuses = myUI.getTotalBusesLable();
		lblTotalRoot = myUI.getTotalRootLable();
		lblTotalAllocation = myUI.getTotalAllocationLable();

		pnlSearchStation = myUI.getSearchStationPanel();
		btnSearchStation = myUI.getSearchStationButton();
		lblSearchStation = myUI.getSearchStationLabel();
		txtSearchStation = myUI.getSearchStationTextField();
		txtSearchStation.setText("Search Station Here...");
		txtSearchStation.setForeground(new Color(171,171,171));
		txtSearchStation.addFocusListener(this);
		btnSearchStation.addActionListener(this);

//		lblProgramHeading = myUI.getProgramHeadingLabel();
//		new BlinkLabel(lblProgramHeading,800).start();

		lblNotice = myUI.getNoticeLabel();
		new ScrollLabel(lblNotice ,10,pnlCenterTop);

		pnlCenterBottom = myUI.getCenterBottomPanel();

		pnlBottomLeft = myUI.getBottomLeftPanel();

		pnlManageEmployee=myUI.getManageEmployeePanel();
		btnManageEmployee=myUI.getManageEmployeeButton();
		btnManageEmployee.addActionListener(this);

		pnlManageBus=myUI.getManageBusPanel();
		btnManageBus=myUI.getManageBusButton();
		PanelState.hideComponents(pnlManageBus);
		btnManageBus.addActionListener(this);

		pnlManageRoot=myUI.getManageRootPanel();
		btnManageRoot=myUI.getManageRootButton();
		PanelState.hideComponents(pnlManageRoot);
		btnManageRoot.addActionListener(this);

		pnlManageAllocation=myUI.getManageAllocationPanel();
		btnManageAllocation=myUI.getManageAllocationButton();
		PanelState.hideComponents(pnlManageAllocation);
		btnManageAllocation.addActionListener(this);

		pnlRootGoogleMapDisplay = myUI.getRootGoogleMapDisplayPanel();
		btnRootGoogleMapDisplay = myUI.getRootGoogleMapDisplayButton();
		PanelState.hideComponents(pnlRootGoogleMapDisplay);
		btnRootGoogleMapDisplay.addActionListener(this);

		pnlEmployeeDisplay = new JPanel();
		pnlEmployeeDisplay.setBounds(0,0,1580,520);
		pnlEmployeeDisplay.setLayout(new BorderLayout());
		tool = new ReportTool(535,535);
		tool.setBounds(0,0,535,535);
		pnlEmployeeDisplay.setBackground(Color.WHITE);
		pnlUI.add(pnlEmployeeDisplay);
		pnlEmployeeDisplay.add(tool,BorderLayout.CENTER);
		PanelState.visibleComponents(pnlEmployeeDisplay);

		RoundedPanel.createRoundedPanel(pnlEmployeeDisplay,25);

		pnlBusesDisplay = new JPanel();
		pnlBusesDisplay.setBounds(0,0,1580,520);
		pnlBusesDisplay.setLayout(new BorderLayout());
		tool2 = new ReportTool(550,535);
		tool2.setBounds(0,0,550,535);
		pnlBusesDisplay.setBackground(Color.WHITE);
		pnlUI.add(pnlBusesDisplay);
		pnlBusesDisplay.add(tool2,BorderLayout.CENTER);
		PanelState.hideComponents(pnlBusesDisplay);

		pnlRootDisplay = new JPanel();
		pnlRootDisplay.setBounds(0,0,1580,520);
		pnlRootDisplay.setLayout(new BorderLayout());
		//tool3.setBounds(0,0,535,535);
		pnlRootDisplay.setBackground(Color.WHITE);
		pnlUI.add(pnlRootDisplay);
		PanelState.hideComponents(pnlRootDisplay);
		tool3 = new ReportTool(535,535);
		pnlRootDisplay.add(tool3,BorderLayout.CENTER);

		MyTable = tool3.getTable();

		pnlRootStopDisplay = myUI.getRootStopDisplayPanel();
		btnRootStopDisplay = myUI.getRootStopDisplayButton();
		btnRootStopDisplay.addActionListener(this);
		PanelState.hideComponents(pnlRootStopDisplay);


		pnlAllocationDisplay = new JPanel();
		pnlAllocationDisplay.setBounds(0,0,1580,520);
		pnlAllocationDisplay.setLayout(new BorderLayout());
		tool4 = new ReportTool(535,535);
		tool4.setBounds(0,0,535,535);
		pnlAllocationDisplay.setBackground(Color.WHITE);
		pnlUI.add(pnlAllocationDisplay);
		pnlAllocationDisplay.add(tool4,BorderLayout.CENTER);
		PanelState.hideComponents(pnlAllocationDisplay);

		lblMSRTCWeb = myUI.getMSRTCWebLabel();
		btnMSRTCWeb = myUI.getMSRTCWebButton();
		btnMSRTCWeb.addActionListener(this);

		createReport();
		createReport2();
		createReport3();
		createReport4();
		//txtSearchStation.setFocusable(true);

		timerButtons = new javax.swing.Timer(2000,new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e)
				{
					addRightMovingButtons();
					timerButtons.stop();
				}
			});

		timerStarter = new java.util.Timer(false);
		timerStarter.schedule(new TimerTask(){
				@Override
				public void run()
				{
					timerButtons.start();
				}
			},0);


		btnLogout.addActionListener(e ->{
			dispose();
			new FrmLogin();
		});

		pnlBottomRight = myUI.getBottomRightPanel();
		new ImageSlideShow(slideShowImages,pnlBottomRight);

		show();
	}


	void addRightMovingButtons()
	{
		int right = 0;
		new AnimatePanel(pnlEmployee,5,pnlLeft,-76, 12, right);
		new AnimatePanel(pnlAllocation,5,pnlLeft,-152, 12, right);
		new AnimatePanel(pnlRoot,5,pnlLeft,-228, 12, right);
		new AnimatePanel(pnlBuses,5,pnlLeft,-304, 12, right);
	}

	void addLeftMovingButtons()
	{
		int left = 1;
		new AnimatePanel(pnlEmployee,5,pnlLeft,12, -80,left);
		new AnimatePanel(pnlAllocation,5,pnlLeft,12, -80,left);
		new AnimatePanel(pnlRoot,5,pnlLeft,12, -80,left);
		new AnimatePanel(pnlBuses,5,pnlLeft,12, -80,left);

	}
//Report for Employee
	void createReport()
	{
		setColumnsHeading();
		setColumnsAlignment();
		setColumnsWidth();
		setColumnsData();
	}

	void setColumnsHeading()
	{
		Rcols=0;
		Rcols+=tool.addNewColumn("EmployeeID");
		Rcols+=tool.addNewColumn("Name");
		Rcols+=tool.addNewColumn("Address");
		Rcols+=tool.addNewColumn("PinCode");
		Rcols+=tool.addNewColumn("Area_Name");
		Rcols+=tool.addNewColumn("Age");
		Rcols+=tool.addNewColumn("Gender");
		Rcols+=tool.addNewColumn("ContactNo");
		Rcols+=tool.addNewColumn("EmailID");
		Rcols+=tool.addNewColumn("Designation");
		Rcols+=tool.addNewColumn("BillaNo");
		Rcols+=tool.addNewColumn("LicenceNo");
		Rcols+=tool.addNewColumn("Villagian");

	}

	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_LEFT);
		tool.setColumnAlignment(2,ReportTool.ALIGN_LEFT);
		tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(4,ReportTool.ALIGN_LEFT);
		tool.setColumnAlignment(5,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(6,ReportTool.ALIGN_LEFT);
		tool.setColumnAlignment(7,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(8,ReportTool.ALIGN_LEFT);
		tool.setColumnAlignment(9,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(10,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(11,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(12,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth()
	{
		tool.setColumnWidth("EmployeeID",100);
		tool.setColumnWidth("Name",550);
		tool.setColumnWidth("Address",550);
		tool.setColumnWidth("PinCode",120);
		tool.setColumnWidth("Area_Name",300);
		tool.setColumnWidth("Age",80);
		tool.setColumnWidth("Gender",100);
		tool.setColumnWidth("ContactNo",200);
		tool.setColumnWidth("EmailID",500);
		tool.setColumnWidth("Designation",200);
		tool.setColumnWidth("BillaNo",150);
		tool.setColumnWidth("LicenceNo",150);
		tool.setColumnWidth("Villagian",80);
	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsEmployeeReport Data[]=clsEmployeeReport.getAllEmployeeReportInformation();
		lblTotalEmployee.setText("<html><center> Total Employees Working<br>"+String.valueOf(Data.length)+"</center></html>");

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getEmployeeName();
			Objectdata[2]=Data[i].getAddress();
			Objectdata[3]=Data[i].getPinCode();
			Objectdata[4]=Data[i].getAreaName();
			Objectdata[5]=Data[i].getAge();
			Objectdata[6]=Data[i].getGenderText();
			Objectdata[7]=Data[i].getContactNo();
			Objectdata[8]=Data[i].getEmailID();
			Objectdata[9]=Data[i].getDesignationName();
			Objectdata[10]=Data[i].getBillaNo();
			Objectdata[11]=Data[i].getLicenseNo();
			Objectdata[12]=Data[i].getVillagianText();


			tool.addNewRow(Objectdata);
		}
	}
//Report for Buses
	void createReport2()
	{
		setColumnsHeading2();
		setColumnsAlignment2();
		setColumnsWidth2();
		setColumnsData2();
	}

	void setColumnsHeading2()
	{
		Rcols2=0;
		Rcols2+=tool2.addNewColumn("VehicleID");
		Rcols2+=tool2.addNewColumn("Vehicle_Name");
		Rcols2+=tool2.addNewColumn("Vehicle_Type_Name");
		Rcols2+=tool2.addNewColumn("Chessis_No");
		Rcols2+=tool2.addNewColumn("Inward_Year");
	}

	void setColumnsAlignment2()
	{
		tool2.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool2.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool2.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		tool2.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
		tool2.setColumnAlignment(4,ReportTool.ALIGN_CENTER);

	}

	void setColumnsWidth2()
	{
		tool2.setColumnWidth("VehicleID",100);
		tool2.setColumnWidth("Vehicle_Name",300);
		tool2.setColumnWidth("Vehicle_Type_Name",350);
		tool2.setColumnWidth("Chessis_No",120);
		tool2.setColumnWidth("Inward_Year",300);
	}

	void setColumnsData2()
	{

		tool2.removeAllRows();

		clsVehicleReport Data[]=clsVehicleReport.getAllVehicleReportInformation();
		lblTotalBuses.setText("<html><center> Total Buses In Deport<br>"+String.valueOf(Data.length)+"</center></html>");

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols2];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getVehicleName();
			Objectdata[2]=Data[i].getVehicleTypeName();
			Objectdata[3]=Data[i].getChessisNo();
			Objectdata[4]=Data[i].getInwardYear();


			tool2.addNewRow(Objectdata);
		}
	}

//Report for root

	void createReport3()
	{
		setColumnsHeading3();
		setColumnsAlignment3();
		setColumnsWidth3();
		setColumnsData3();
	}

	void setColumnsHeading3()
	{
		Rcols3=0;
		Rcols3+=tool3.addNewColumn("RootID");
		Rcols3+=tool3.addNewColumn("Root_Name");
		Rcols3+=tool3.addNewColumn("Start_Time");
		Rcols3+=tool3.addNewColumn("Time_Shift");
		Rcols3+=tool3.addNewColumn("Source_Station_Name");
		Rcols3+=tool3.addNewColumn("Destination_Station_Name");
		Rcols3+=tool3.addNewColumn("Villagian");

	}

	void setColumnsAlignment3()
	{
		tool3.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool3.setColumnAlignment(1,ReportTool.ALIGN_LEFT);
		tool3.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		tool3.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
		tool3.setColumnAlignment(4,ReportTool.ALIGN_CENTER);
		tool3.setColumnAlignment(5,ReportTool.ALIGN_LEFT);
		tool3.setColumnAlignment(6,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth3()
	{
		tool3.setColumnWidth("RootID",100);
		tool3.setColumnWidth("Root_Name",550);
		tool3.setColumnWidth("Start_Time",120);
		tool3.setColumnWidth("Time_Shift",100);
		tool3.setColumnWidth("Source_Station_Name",300);
		tool3.setColumnWidth("Destination_Station_Name",300);
		tool3.setColumnWidth("Villagian",150);
	}

	void setColumnsData3()
	{

		tool3.removeAllRows();

		clsRootReport Data[]=clsRootReport.getAllRootReportInformation();
		lblTotalRoot.setText("<html><center> Total Connected Routs<br>"+String.valueOf(Data.length)+"</center></html>");

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols3];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getRootName();
			Objectdata[2]=Data[i].getStartTime();
			Objectdata[3]=Data[i].getTimeShiftText();
			Objectdata[4]=Data[i].getSourceStationName();
			Objectdata[5]=Data[i].getDestinationStationName();
			Objectdata[6]=Data[i].getVillagianText();


			tool3.addNewRow(Objectdata);
		}
	}

//Report for Allocation


	void createReport4()
	{
		setColumnsHeading4();
		setColumnsAlignment4();
		setColumnsWidth4();
		setColumnsData4();
	}

	void setColumnsHeading4()
	{
		Rcols4=0;
		Rcols4+=tool4.addNewColumn("Sr_No");
		Rcols4+=tool4.addNewColumn("Date");
		Rcols4+=tool4.addNewColumn("Bus_No");
		Rcols4+=tool4.addNewColumn("Bus_Type");
		Rcols4+=tool4.addNewColumn("Root");
		Rcols4+=tool4.addNewColumn("Driver_Name_And_Contact");
		Rcols4+=tool4.addNewColumn("Driver_Billa");
		Rcols4+=tool4.addNewColumn("Conductor_Name_And_Contact");
		Rcols4+=tool4.addNewColumn("Conductor_Billa");

	}

	void setColumnsAlignment4()
	{
		tool4.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool4.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool4.setColumnAlignment(2,ReportTool.ALIGN_LEFT);
		tool4.setColumnAlignment(3,ReportTool.ALIGN_LEFT);
		tool4.setColumnAlignment(4,ReportTool.ALIGN_LEFT);
		tool4.setColumnAlignment(5,ReportTool.ALIGN_LEFT);
		tool4.setColumnAlignment(6,ReportTool.ALIGN_CENTER);
		tool4.setColumnAlignment(7,ReportTool.ALIGN_LEFT);
		tool4.setColumnAlignment(8,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth4()
	{
		tool4.setColumnWidth("Sr_No",100);
		tool4.setColumnWidth("Date",100);
		tool4.setColumnWidth("Bus_No",150);
		tool4.setColumnWidth("Bus_Type",250);
		tool4.setColumnWidth("Root",500);
		tool4.setColumnWidth("Driver_Name_And_Contact",600);
		tool4.setColumnWidth("Driver_Billa",150);
		tool4.setColumnWidth("Conductor_Name_And_Contact",600);
		tool4.setColumnWidth("Conductor_Billa",200);
	}

	void setColumnsData4()
	{

		tool4.removeAllRows();

		clsAllocationReport Data[]=clsAllocationReport.getAllAllocationReportInformation();
		TodayDate = DateManager.convertToDate(DateUtil.getTodayDate());
		clsAllocationReport Data2[] = clsAllocationReport.getAllAllocationReportInformation(TodayDate.getDay(),TodayDate.getMonth(),TodayDate.getYear());
		lblTotalAllocation.setText("<html><center>Today's Total Allocation<br>"+String.valueOf(Data2.length)+"</center></html>");

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols4];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getAllocationDate();
			Objectdata[2]=Data[i].getVehicleName();
			Objectdata[3]=Data[i].getVehicleTypeName();
			Objectdata[4]=Data[i].getRootName();
			Objectdata[5]=Data[i].getDriverName()+("-")+Data[i].getDriverContactNo();
			Objectdata[6]=Data[i].getDriverBillaNo();
			Objectdata[7]=Data[i].getConductorName()+("-")+Data[i].getConductorContactNo();
			Objectdata[8]=Data[i].getConductorBillaNo();


			tool4.addNewRow(Objectdata);
		}
	}


	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()== btnEmployee)
		{
			PanelState.hideComponents(pnlSelectedButtonHighlight);
			pnlSelectedButtonHighlight.setBounds(5,370,115,79);
			PanelState.hideComponents(pnlBusesDisplay);
			PanelState.hideComponents(pnlRootDisplay);
			PanelState.hideComponents(pnlAllocationDisplay);
			PanelState.hideComponents(pnlRootStopDisplay);
			PanelState.hideComponents(pnlManageRoot);
			PanelState.hideComponents(pnlManageAllocation);
			PanelState.hideComponents(pnlManageBus);
			PanelState.hideComponents(pnlRootGoogleMapDisplay);
			PanelState.visibleComponents(pnlEmployeeDisplay);
			PanelState.visibleComponents(pnlManageEmployee);
			addLeftMovingButtons();
			btnShowButton.setVisible(true);

			int y = 430,h = 45;
			pnlManageEmployee.setBounds(5, y, 200, h);
			y = y + h + 13;
			pnlAboutUs.setBounds(5, y, 200, h);
			y = y + h + 13;
			pnlServices.setBounds(5, y, 200, h);
			y = y + h + 13;
			pnlGallery.setBounds(5, y, 200, h);

			setColumnsData();

		}
		else if(ae.getSource()== btnBuses)
		{
			PanelState.hideComponents(pnlSelectedButtonHighlight);
			pnlSelectedButtonHighlight.setBounds(5,457,115,79);
			PanelState.hideComponents(pnlAllocationDisplay);
			PanelState.hideComponents(pnlEmployeeDisplay);
			PanelState.hideComponents(pnlRootDisplay);
			PanelState.hideComponents(pnlRootStopDisplay);
			PanelState.hideComponents(pnlManageRoot);
			PanelState.hideComponents(pnlManageAllocation);
			PanelState.hideComponents(pnlManageEmployee);
			PanelState.hideComponents(pnlRootGoogleMapDisplay);
			PanelState.visibleComponents(pnlBusesDisplay);
			PanelState.visibleComponents(pnlManageBus);
			addLeftMovingButtons();
			btnShowButton.setVisible(true);

			int y = 430,h = 45;
			pnlManageBus.setBounds(5, y, 200, h);
			y = y + h + 13;
			pnlAboutUs.setBounds(5, y, 200, h);
			y = y + h + 13;
			pnlServices.setBounds(5, y, 200, h);
			y = y + h + 13;
			pnlGallery.setBounds(5, y, 200, h);

			setColumnsData2();
		}
		else if(ae.getSource()== btnRoot)
		{
			PanelState.hideComponents(pnlSelectedButtonHighlight);
			pnlSelectedButtonHighlight.setBounds(5,544,115,79);
			PanelState.hideComponents(pnlAllocationDisplay);
			PanelState.hideComponents(pnlBusesDisplay);
			PanelState.hideComponents(pnlEmployeeDisplay);
			PanelState.hideComponents(pnlManageAllocation);
			PanelState.hideComponents(pnlManageEmployee);
			PanelState.hideComponents(pnlManageBus);
			PanelState.visibleComponents(pnlRootDisplay);
			PanelState.visibleComponents(pnlRootStopDisplay);
			PanelState.visibleComponents(pnlManageRoot);
			PanelState.visibleComponents(pnlRootGoogleMapDisplay);
			addLeftMovingButtons();
			btnShowButton.setVisible(true);

			int y = 374,h = 45;
			pnlRootStopDisplay.setBounds(5,y,200,h);
			y = y+h+13;
			pnlRootGoogleMapDisplay.setBounds(5,y,200,h);
			y = y + h + 13;
			pnlManageRoot.setBounds(5,y,200,45);
			y = y + h + 13;
			pnlAboutUs.setBounds(5,y,200,45);
			y = y + h + 13;
			pnlServices.setBounds(5,y,200,45);
			y = y + h + 13;
			pnlGallery.setBounds(5,y,200,45);

			setColumnsData3();
		}
		else if(ae.getSource()== btnAllocation)
		{
			PanelState.hideComponents(pnlSelectedButtonHighlight);
			pnlSelectedButtonHighlight.setBounds(5,631,115,79);
			PanelState.hideComponents(pnlRootDisplay);
			PanelState.hideComponents(pnlBusesDisplay);
			PanelState.hideComponents(pnlEmployeeDisplay);
			PanelState.hideComponents(pnlRootStopDisplay);
			PanelState.hideComponents(pnlManageRoot);
			PanelState.hideComponents(pnlManageEmployee);
			PanelState.hideComponents(pnlManageBus);
			PanelState.visibleComponents(pnlAllocationDisplay);
			PanelState.visibleComponents(pnlManageAllocation);
			PanelState.hideComponents(pnlRootGoogleMapDisplay);
			addLeftMovingButtons();
			btnShowButton.setVisible(true);

			int y = 430,h = 45;
			pnlManageAllocation.setBounds(5, y, 200, h);
			y = y + h + 13;
			pnlAboutUs.setBounds(5, y, 200, h);
			y = y + h + 13;
			pnlServices.setBounds(5, y, 200, h);
			y = y + h + 13;
			pnlGallery.setBounds(5, y, 200, h);

			setColumnsData4();
		}
		else if(ae.getSource() == btnShowButton)
		{
			btnShowButton.setVisible(false);
			PanelState.hideComponents(pnlSelectedButtonHighlight);
			addRightMovingButtons();
		}
		else if(ae.getSource()== btnRootStopDisplay)
		{
			int selectedRow = MyTable.getSelectedRow();
			int selectedColumn = MyTable.getSelectedColumn();

			if (selectedRow != -1 && selectedColumn != -1)
			{
				Object selectedValue = MyTable.getValueAt(selectedRow, 0);
				int mRootID=(int)selectedValue;
				clsRoot temp =clsRoot.getRootInformation(mRootID);
				frmRootStopDetail A = new frmRootStopDetail(temp);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No cell selected.");
			}
		}
		else if(ae.getSource() == btnSearchStation)
		{
			frmSearchResultDisplay  S = new frmSearchResultDisplay(vDestinationSearch);
		}
		else if(ae.getSource() == btnManageEmployee)
		{
			frmEmployee E = new frmEmployee();
			setColumnsData();
		}
		else if(ae.getSource() == btnManageBus)
		{
			frmVehicle V = new frmVehicle();
			setColumnsData2();
		}
		else if(ae.getSource() == btnManageRoot)
		{
			frmRoot R = new frmRoot();
			setColumnsData3();
		}
		else if(ae.getSource() == btnManageAllocation)
		{
			frmAllocation A = new frmAllocation();
			setColumnsData4();
		}
		else if(ae.getSource() == btnRootGoogleMapDisplay)
		{
			int selectedRow = MyTable.getSelectedRow();
			int selectedColumn = MyTable.getSelectedColumn();

			if (selectedRow != -1 && selectedColumn != -1)
			{
				Object selectedValue = MyTable.getValueAt(selectedRow, 0);
				int mRootID=(int)selectedValue;
				clsRootReport temp =  clsRootReport.getRootReportInformation(mRootID);
				GoogleMapInFrame.showGoogleMap(temp.getSourceStationName(),temp.getDestinationStationName());
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No cell selected.");
			}
		}
		else if(ae.getSource() == btnMSRTCWeb)
		{
			OpenWebSite.openPage("https://msrtc.maharashtra.gov.in/");
		}
	}

      public void focusGained(FocusEvent e)
      {
			if(e.getSource() == txtSearchStation)
			{
				txtSearchStation.setText("");
				txtSearchStation.setForeground(new Color(0,0,0));
			}
	  }

      public void focusLost(FocusEvent e)
      {
		  if(e.getSource() == txtSearchStation)
		  {
				vDestinationSearch = txtSearchStation.getText();
				txtSearchStation.setForeground(new Color(171,171,171));
				txtSearchStation.setText("Search Station Here...");
		}
	  }

	public static void main(String args[])
	{
		frmDashboard F = new frmDashboard();
	}
}