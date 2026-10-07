import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;
import myDesign.*;

class frmAllocation extends JFrame implements ActionListener
{
	JPanel pnlUI;
	JPanel pnlUIReport;
	JPanel pnlAllocationReport;

	JPanel pnlBottom;
	JLabel lblMovingBusDeveloperList;

	JPanel pnlAllocationUpdate;
	JComboBox cmbAllocationUpdate;
	JLabel lblAllocationUpdate;

	JPanel pnlAllocationDisplay;
	JPanel pnlRootSelection;
	JComboBox cmbRoot;

	JPanel pnlVehicleSelection;
	JComboBox cmbVehicle;

	JPanel pnlDriverSelection;
	JComboBox cmbDriver;

	JPanel pnlConductorSelection;
	JComboBox cmbConductor;
	//JLabel lblRootSelection;

	JPanel pnlRoot;
	JPanel pnlVehicle;
	JPanel pnlDriver;
	JPanel pnlConductor;

	JPanel pnlSave;
	JButton btnSave;

	JPanel pnlReport;
	JButton btnReport;

	JPanel pnlClose;
	JButton btnClose;


	AllocationDesign myUI;

	JPanel pnlCenterTop;

	JLabel lblProgramHeading;
	JLabel lblNotice;

	JLabel lblAllocationID ;
	JLabel lblRoot;
	JLabel lblDriver;
	JLabel lblConductor;
	JLabel lblAllocationDate;
	JLabel lblVehicle;
	JLabel lblSlash1;
	JLabel lblSlash2;

	JLabel lblRootStop;
	JLabel lblTime;

//    JLabel lblVehicleID ;
    JLabel lblVehicleName;
//	JLabel lblVehicleTypeID;
	JLabel lblChessisNo;
	JLabel lblInwardYear;
	JLabel lblVehicleTypeName;


	JLabel lblDriverContactNo;
	JLabel lblDriverAddress;
	JLabel lblConductorContactNo;
	JLabel lblConductorAddress;
	JLabel lblStartFrom;
	JLabel lblLastStop;
	JLabel lblDriverName;
//	JLabel lblDriverPinCode;
	JLabel lblDriverAge;
	JLabel lblDriverGender;
//	JLabel lblDriverAreaName;
	JLabel lblDriverEmailID;
	JLabel lblDriverDesignationName;
	JLabel lblDriverBillaNo;
	JLabel lblDriverLicenseNo;
	JLabel lblConductorName;
//	JLabel lblConductorPinCode;
	JLabel lblConductorAge;
	JLabel lblConductorGender;
//	JLabel lblConductorAreaName;
	JLabel lblConductorEmailID;
	JLabel lblConductorDesignationName;
	JLabel lblConductorBillaNo;
	JLabel lblConductorLicenseNo;

	JTextField txtAllocationID;
	JTextField txtAllocationDay;
	JTextField txtAllocationMonth;
	JTextField txtAllocationYear;

	DateManager TodayDate;

	int vAllocationID=0;
	int vRootID=0;
	int vVehicleID=0;
	int vConductorID=0;
	int vDriverID=0;
	int vEmployeeID=0;


	JLabel lblRootSelection;
	JLabel lblVehicleSelection;
	JLabel lblDriverSelection;
	JLabel lblConductorSelection;

	int Rcols;
	ReportTool tool;
	int Rcols2;
	ReportTool tool2;

	frmAllocation()
	{
		setSize(1950,1200);
		setLocation(1,1);
		setLayout(null);
		setBackground(ColorSetting.getBackColorFrame());
		setTitle("ServiceNexus");
		setIconImage(new ImageIcon("imagesrc\\img-ServiceNexus-Logo.png").getImage());
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );


		myUI = new AllocationDesign();
		add(myUI);

		pnlUI = myUI.getUIPanel();
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,1115,525);//1115,525

		pnlBottom = myUI.getBottomPanel();
		lblMovingBusDeveloperList = myUI.getMovingBusDeveloperListLabel();
		new ScrollLabel(lblMovingBusDeveloperList ,6,pnlBottom);

		pnlRootSelection=myUI.getCombo1Panel();
		lblRootSelection=myUI.getCombo1Label();
		lblRootSelection.setText("Select Root Information !!!");
		cmbRoot= myUI.getCombo1ComboBox();
		cmbRoot.addActionListener(this);


		pnlVehicleSelection=myUI.getCombo2Panel();
		lblVehicleSelection=myUI.getCombo2Label();
		lblVehicleSelection.setText("Select Vehicle Information !!!");
		cmbVehicle= myUI.getCombo2ComboBox();
		cmbVehicle.addActionListener(this);

		pnlDriverSelection=myUI.getCombo3Panel();
		lblDriverSelection=myUI.getCombo3Label();
		lblDriverSelection.setText("Select Driver Information !!!");
		cmbDriver= myUI.getCombo3ComboBox();
		cmbDriver.addActionListener(this);


		pnlConductorSelection=myUI.getCombo4Panel();
		lblConductorSelection=myUI.getCombo4Label();
		lblConductorSelection.setText("Select Conductor Information !!!");
		cmbConductor= myUI.getCombo4ComboBox();
		cmbConductor.addActionListener(this);

		pnlUIReport = myUI.getUIReportPanel();
		tool = new ReportTool(1105,515);
		tool.setBounds(0,100,1115,525);
		pnlUIReport.add(tool);
		UISetting.setArea(pnlUIReport,1115,525);

		pnlSave = myUI.getSavePanel();
		btnSave = myUI.getSaveButton();
		PanelState.disabledComponents(pnlSave);
		btnSave.addActionListener(this);

		pnlReport = myUI.getReportPanel();
		btnReport = myUI.getReportButton();
		btnReport.addActionListener(this);

		pnlClose = myUI.getClosePanel();
		btnClose = myUI.getCloseButton();
		btnClose.addActionListener(this);

		pnlAllocationUpdate = myUI.getCombo1Panel();
		lblAllocationUpdate = myUI.getCombo1Label();
		cmbAllocationUpdate = myUI.getCombo1ComboBox();
		//pnlUIReport = myUI.getUIReportPanel();

		lblProgramHeading = myUI.getProgramHeadingLabel();
		new BlinkLabel(lblProgramHeading,800).start();

		pnlCenterTop = myUI.getCenterTopPanel();
		lblNotice = myUI.getNoticeLabel();
		new ScrollLabel(lblNotice ,10,pnlCenterTop);


		int y=10;
		int h=30;
		int gap=15;

		lblAllocationID = new JLabel("Allocation ID : ");
		lblAllocationID.setBounds(25,y,150,h);
		lblAllocationID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblAllocationID);

		txtAllocationID = new JTextField();
		txtAllocationID.setBounds(175,y,200,h);
		txtAllocationID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtAllocationID);

		lblAllocationDate = new JLabel("Allocation Date : ");
		lblAllocationDate.setBounds(625,y,230,h);
		lblAllocationDate.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblAllocationDate);

		TodayDate = DateManager.convertToDate(DateUtil.getTodayDate());

		txtAllocationDay = new JTextField();
		txtAllocationDay.setBounds(800,y,50,h);
		txtAllocationDay.setText(String.valueOf(TodayDate.getDay()));
		txtAllocationDay.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtAllocationDay);

		lblSlash1 = new JLabel("/");
		lblSlash1.setBounds(860,y,150,h);
		lblSlash1.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblSlash1);

		txtAllocationMonth = new JTextField();
		txtAllocationMonth.setBounds(875,y,50,h);
		txtAllocationMonth.setText(String.valueOf(TodayDate.getMonth()));
		txtAllocationMonth.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtAllocationMonth);

		lblSlash2 = new JLabel("/");
		lblSlash2.setBounds(935,y,150,h);
		lblSlash2.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblSlash2);

		txtAllocationYear = new JTextField();
		txtAllocationYear.setBounds(950,y,100,h);
		txtAllocationYear.setText(String.valueOf(TodayDate.getYear()));
		txtAllocationYear.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtAllocationYear);

		y=y+h+gap-10;
/*
		pnlAllocationReport=new JPanel();
		pnlAllocationReport.setBounds(1000,200,50,100);//25,100,5,200
		pnlAllocationReport.setLayout(null);
		pnlAllocationReport.setBackground(Color.WHITE);
		pnlUI.add(pnlAllocationReport);
*/
		pnlRoot = new JPanel();
		pnlRoot.setBounds(5,y,560,90);
		pnlRoot.setLayout(null);
		pnlRoot.setBackground(Color.WHITE);
		pnlUI.add(pnlRoot);

		RoundedPanel.createRoundedPanel(pnlRoot,25);

		pnlAllocationDisplay = new JPanel();
		pnlAllocationDisplay.setBounds(570,y,540,470);
		pnlAllocationDisplay.setLayout(new BorderLayout());

		tool2 = new ReportTool(540,470);
		tool2.setBounds(0,0,540,470);
		pnlAllocationDisplay.setBackground(Color.WHITE);
		pnlUI.add(pnlAllocationDisplay);
		pnlAllocationDisplay.add(tool2,BorderLayout.CENTER);

		lblRootStop = new JLabel("Root : ");
		lblRootStop.setFont(new Font("Arial",Font.BOLD, 16));
		lblRootStop.setBounds(3,3,500,25);
		pnlRoot.add(lblRootStop);

		lblTime = new JLabel("Time : ");
		lblTime.setFont(new Font("Arial",Font.BOLD, 16));
		lblTime.setBounds(3,30,200,25);
		pnlRoot.add(lblTime);

		lblStartFrom = new JLabel("Start From : ");
		lblStartFrom.setFont(new Font("Arial",Font.BOLD, 16));
		lblStartFrom.setBounds(3,60,200,25);
		pnlRoot.add(lblStartFrom);

		lblLastStop = new JLabel("Last Stop : ");
		lblLastStop.setFont(new Font("Arial",Font.BOLD, 16));
		lblLastStop.setBounds(280,60,200,25);
		pnlRoot.add(lblLastStop);

		y = y + gap + 85;
		pnlVehicle = new JPanel();
		pnlVehicle.setBounds(5,y,560,60);
		pnlVehicle.setLayout(null);
		pnlVehicle.setBackground(Color.WHITE);
		pnlUI.add(pnlVehicle);

		RoundedPanel.createRoundedPanel(pnlVehicle,25);


/*		lblVehicleID = new JLabel("Vehicle ID : ");
		lblVehicleID.setFont(new Font("Arial",Font.BOLD, 16));
		lblVehicleID.setBounds(3,3,350,25);
		pnlVehicle.add(lblVehicleID);
*/
		lblVehicleName = new JLabel("Vehicle Name : ");
		lblVehicleName.setFont(new Font("Arial",Font.BOLD, 16));
		lblVehicleName.setBounds(3,3,350,25);
		pnlVehicle.add(lblVehicleName);

		lblChessisNo = new JLabel("Chessis No : ");
		lblChessisNo.setFont(new Font("Arial",Font.BOLD, 16));
		lblChessisNo.setBounds(280,3,350,25);
		pnlVehicle.add(lblChessisNo);

/*		lblVehicleTypeID = new JLabel("Vehicle Type ID : ");
		lblVehicleTypeID.setFont(new Font("Arial",Font.BOLD, 16));
		lblVehicleTypeID.setBounds(3,30,350,25);
		pnlVehicle.add(lblVehicleTypeID);
*/
		lblVehicleTypeName = new JLabel("Vehicle Type Name : ");
		lblVehicleTypeName.setFont(new Font("Arial",Font.BOLD, 16));
		lblVehicleTypeName.setBounds(3,30,350,25);
		pnlVehicle.add(lblVehicleTypeName);

		lblInwardYear = new JLabel("Inward Year : ");
		lblInwardYear.setFont(new Font("Arial",Font.BOLD, 16));
		lblInwardYear.setBounds(280,30,500,25);
		pnlVehicle.add(lblInwardYear);

		y = y + gap + 55;

		pnlDriver = new JPanel();
		pnlDriver.setBounds(5,y,560,145);
		pnlDriver.setLayout(null);
		pnlDriver.setBackground(Color.WHITE);
		pnlUI.add(pnlDriver);

		RoundedPanel.createRoundedPanel(pnlDriver,25);


		lblDriverName = new JLabel("Driver Name : ");
		lblDriverName.setFont(new Font("Arial",Font.BOLD, 16));
		lblDriverName.setBounds(3,3,500,25);
		pnlDriver.add(lblDriverName);

		lblDriverAge = new JLabel("Age : ");
		lblDriverAge.setFont(new Font("Arial",Font.BOLD, 16));
		lblDriverAge.setBounds(3,50,90,25);
		pnlDriver.add(lblDriverAge);

		lblDriverGender = new JLabel("Gender : ");
		lblDriverGender.setFont(new Font("Arial",Font.BOLD, 16));
		lblDriverGender.setBounds(280,50,150,25);
		pnlDriver.add(lblDriverGender);

		lblDriverContactNo = new JLabel("Contact No : ");
		lblDriverContactNo.setFont(new Font("Arial",Font.BOLD, 16));
		lblDriverContactNo.setBounds(3,25,250,25);
		pnlDriver.add(lblDriverContactNo);

		lblDriverEmailID = new JLabel("Email ID : ");
		lblDriverEmailID.setFont(new Font("Arial",Font.BOLD, 16));
		lblDriverEmailID.setBounds(3,75,250,25);
		pnlDriver.add(lblDriverEmailID);

		lblDriverDesignationName = new JLabel("Designation Name : ");
		lblDriverDesignationName.setFont(new Font("Arial",Font.BOLD, 16));
		lblDriverDesignationName.setBounds(280,75,400,25);
		pnlDriver.add(lblDriverDesignationName);

		lblDriverAddress = new JLabel("Address : ");
		lblDriverAddress.setFont(new Font("Arial",Font.BOLD, 16));
		lblDriverAddress.setBounds(3,100,800,25);
		pnlDriver.add(lblDriverAddress);

/*		lblDriverAreaName = new JLabel("Area : ");
		lblDriverAreaName.setFont(new Font("Arial",Font.BOLD, 16));
		lblDriverAreaName.setBounds(530,60,450,25);
		pnlDriver.add(lblDriverAreaName);
*/
		lblDriverBillaNo = new JLabel("Billa No : ");
		lblDriverBillaNo.setFont(new Font("Arial",Font.BOLD, 16));
		lblDriverBillaNo.setBounds(3,125,180,25);
		pnlDriver.add(lblDriverBillaNo);

		lblDriverLicenseNo = new JLabel("License No : ");
		lblDriverLicenseNo.setFont(new Font("Arial",Font.BOLD, 16));
		lblDriverLicenseNo.setBounds(280,125,220,25);
		pnlDriver.add(lblDriverLicenseNo);


		y = y + gap + 140;

		pnlConductor = new JPanel();
		pnlConductor.setBounds(5,y,560,145);
		pnlConductor.setLayout(null);
		pnlConductor.setBackground(Color.WHITE);
		pnlUI.add(pnlConductor);

		RoundedPanel.createRoundedPanel(pnlConductor,25);

		lblConductorName = new JLabel("Conductor Name : ");
		lblConductorName.setFont(new Font("Arial",Font.BOLD, 16));
		lblConductorName.setBounds(3,3,350,25);
		pnlConductor.add(lblConductorName);

		lblConductorAge = new JLabel("Age : ");
		lblConductorAge.setFont(new Font("Arial",Font.BOLD, 16));
		lblConductorAge.setBounds(3,50,90,25);
		pnlConductor.add(lblConductorAge);

		lblConductorGender = new JLabel("Gender : ");
		lblConductorGender.setFont(new Font("Arial",Font.BOLD, 16));
		lblConductorGender.setBounds(280,50,150,25);
		pnlConductor.add(lblConductorGender);

		lblConductorAddress = new JLabel("Address : ");
		lblConductorAddress.setFont(new Font("Arial",Font.BOLD, 16));
		lblConductorAddress.setBounds(3,100,800,25);
		pnlConductor.add(lblConductorAddress);

/*		lblConductorAreaName = new JLabel("Area : ");
		lblConductorAreaName.setFont(new Font("Arial",Font.BOLD, 16));
		lblConductorAreaName.setBounds(530,56,450,25);
		pnlConductor.add(lblConductorAreaName);
*/
		lblConductorContactNo = new JLabel("Contact No : ");
		lblConductorContactNo.setFont(new Font("Arial",Font.BOLD, 16));
		lblConductorContactNo.setBounds(3,25,250,25);
		pnlConductor.add(lblConductorContactNo);

		lblConductorEmailID = new JLabel("Email ID : ");
		lblConductorEmailID.setFont(new Font("Arial",Font.BOLD, 16));
		lblConductorEmailID.setBounds(3,75,250,25);
		pnlConductor.add(lblConductorEmailID);

		lblConductorDesignationName = new JLabel("Designation Name : ");
		lblConductorDesignationName.setFont(new Font("Arial",Font.BOLD, 16));
		lblConductorDesignationName.setBounds(280,75,400,25);
		pnlConductor.add(lblConductorDesignationName);

		lblConductorBillaNo = new JLabel("Billa No : ");
		lblConductorBillaNo.setFont(new Font("Arial",Font.BOLD, 16));
		lblConductorBillaNo.setBounds(3,125,180,25);
		pnlConductor.add(lblConductorBillaNo);

		lblConductorLicenseNo = new JLabel("License No : ");
		lblConductorLicenseNo.setFont(new Font("Arial",Font.BOLD, 16));
		lblConductorLicenseNo.setBounds(280,125,220,25);
		pnlConductor.add(lblConductorLicenseNo);


		initUI();
		addComboBoxRecords();
		createReport();
		createReport2();

		show();

	}

	void initUI()
	{
		txtAllocationID.setText("0");
		/*txtRootID.setText("");
		txtRootID.requestFocus();
		txtDriverID.setText("");
		txtConductorID.setText("");
		txtAllocationDate.setText("");
		txtVehicleID.setText("");*/
	}

	clsAllocation readUI()
	{
		clsAllocation temp = new clsAllocation();
		temp.setAllocationID(Integer.parseInt(txtAllocationID.getText()));
		temp.setRootID(vRootID);
		temp.setDriverID(vDriverID);
		temp.setConductorID(vConductorID);
		temp.setAllocationDayNo(Integer.parseInt(txtAllocationDay.getText()));
		temp.setAllocationMonthNo(Integer.parseInt(txtAllocationMonth.getText()));
		temp.setAllocationYearNo(Integer.parseInt(txtAllocationYear.getText()));
		temp.setVehicleID(vVehicleID);

		return(temp);
	}

	void writeUI(clsAllocation temp)
	{
		txtAllocationID.setText(String.valueOf(temp.getAllocationID()));
		/*txtRootID.setText(String.valueOf(temp.getRootID()));
		txtDriverID.setText(String.valueOf(temp.getDriverID()));
		txtConductorID.setText(String.valueOf(temp.getConductorID()));
		txtAllocationDate.setText(temp.getAllocationDate());
		txtVehicleID.setText(String.valueOf(temp.getVehicleID()));*/


	}

	void createReport()
	{
		setColumnsHeading();
		setColumnsAlignment();
		setColumnsWidth();
	}

	void setColumnsHeading()
	{
		Rcols=0;
		Rcols+=tool.addNewColumn("Date");
		Rcols+=tool.addNewColumn("Bus_No");
		Rcols+=tool.addNewColumn("Bus_Type");
		Rcols+=tool.addNewColumn("Root");
		Rcols+=tool.addNewColumn("Driver_Name_And_Contact");
		Rcols+=tool.addNewColumn("Driver_Billa");
		Rcols+=tool.addNewColumn("Conductor_Name_And_Contact");
		Rcols+=tool.addNewColumn("Conductor_Billa");
	}

	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(4,ReportTool.ALIGN_LEFT);
		tool.setColumnAlignment(5,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(6,ReportTool.ALIGN_LEFT);
		tool.setColumnAlignment(7,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth()
	{
		tool.setColumnWidth("Date",80);
		tool.setColumnWidth("Bus_No",100);
		tool.setColumnWidth("Bus_Type",80);
		tool.setColumnWidth("Root",200);
		tool.setColumnWidth("Driver_Name_And_Contact",280);
		tool.setColumnWidth("Driver_Billa",100);
		tool.setColumnWidth("Conductor_Name_And_Contact",280);
		tool.setColumnWidth("Conductor_Billa",100);
	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsAllocationReport Data[]=clsAllocationReport.getAllAllocationReportInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=Data[i].getAllocationDate();
			Objectdata[1]=Data[i].getVehicleName();
			Objectdata[2]=Data[i].getVehicleTypeName();
			Objectdata[3]=Data[i].getRootName();
			Objectdata[4]=Data[i].getDriverName()+" - ("+Data[i].getDriverContactNo()+")";
			Objectdata[5]=Data[i].getDriverBillaNo();
			Objectdata[6]=Data[i].getConductorName()+" - ("+Data[i].getConductorContactNo()+")";
			Objectdata[7]=Data[i].getConductorBillaNo();

			tool.addNewRow(Objectdata);
		}
	}


//Report 2


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
		Rcols2+=tool2.addNewColumn("Date");
		Rcols2+=tool2.addNewColumn("Driver_Name");
		Rcols2+=tool2.addNewColumn("Conductor_Name");
		Rcols2+=tool2.addNewColumn("Root");
		Rcols2+=tool2.addNewColumn("Bus_No");
	}

	void setColumnsAlignment2()
	{
		tool2.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool2.setColumnAlignment(1,ReportTool.ALIGN_LEFT);
		tool2.setColumnAlignment(2,ReportTool.ALIGN_LEFT);
		tool2.setColumnAlignment(3,ReportTool.ALIGN_LEFT);
		tool2.setColumnAlignment(4,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth2()
	{
		tool2.setColumnWidth("Date",80);
		tool2.setColumnWidth("Driver_Name",175);
		tool2.setColumnWidth("Conductor_Name",175);
		tool2.setColumnWidth("Root",150);
		tool2.setColumnWidth("Bus_No",80);
	}

	void setColumnsData2()
	{

		tool2.removeAllRows();

		int vDayID = Integer.parseInt(txtAllocationDay.getText());
		int vMonthID = Integer.parseInt(txtAllocationMonth.getText());
		int vYearID = Integer.parseInt(txtAllocationYear.getText());

		clsAllocationReport Data[]=clsAllocationReport.getAllAllocationReportInformation(vDayID,vMonthID,vYearID);

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols2];

			Objectdata[0]=Data[i].getAllocationDate();
			Objectdata[1]=Data[i].getDriverName();
			Objectdata[2]=Data[i].getConductorName();
			Objectdata[3]=Data[i].getRootName();
			Objectdata[4]=Data[i].getVehicleName();

			tool2.addNewRow(Objectdata);
		}
	}

	public void addComboBoxRecords()
	{
		//cmbRoot.removeAllItems();
		addRootRecords(cmbRoot,Integer.parseInt(txtAllocationDay.getText()),Integer.parseInt(txtAllocationMonth.getText()),Integer.parseInt(txtAllocationYear.getText()));
		//cmbVehicle.removeAllItems();
		addVehicleRecords(cmbVehicle,Integer.parseInt(txtAllocationDay.getText()),Integer.parseInt(txtAllocationMonth.getText()),Integer.parseInt(txtAllocationYear.getText()));
		//cmbDriver.removeAllItems();
		addDriverRecords(cmbDriver,Integer.parseInt(txtAllocationDay.getText()),Integer.parseInt(txtAllocationMonth.getText()),Integer.parseInt(txtAllocationYear.getText()));
		//cmbConductor.removeAllItems();
		addConductorRecords(cmbConductor,Integer.parseInt(txtAllocationDay.getText()),Integer.parseInt(txtAllocationMonth.getText()),Integer.parseInt(txtAllocationYear.getText()));

	}


	public void actionPerformed(ActionEvent ae)
	{

		if(ae.getSource() == cmbRoot)
		{
			if(cmbRoot.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Select Root Properly ..... ");
			}
			else
			{
				lblTime.setText(" ");
				lblRootStop.setText(" ");
				String mRootName = (String)cmbRoot.getSelectedItem();
				vRootID = clsRoot.getIDFromName(mRootName);
				clsRootReport temp = clsRootReport.getRootReportInformation(vRootID);


				//clsRoot.showRoot(temp);
				lblTime.setText("Time : "+temp.getStartTime()+" "+temp.getTimeShiftText());
				lblRootStop.setText("Root : " + temp.getRootName() );
				lblStartFrom.setText("Start From : "+ temp.getSourceStationName());
				lblLastStop.setText("Last Stop : " + temp.getDestinationStationName() );


			}

			if(cmbRoot.getSelectedIndex() != 0 && cmbVehicle.getSelectedIndex() != 0 && cmbDriver.getSelectedIndex() != 0 && cmbConductor.getSelectedIndex() != 0)
			{
				PanelState.enabledComponents(pnlSave);
			}
			else
			{
				PanelState.disabledComponents(pnlSave);
			}
		}
		else if(ae.getSource() == cmbVehicle)
		{
			if(cmbVehicle.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Select Vehicle Properly ..... ");
			}
			else
			{
				lblChessisNo.setText(" ");
				lblInwardYear.setText(" ");
//				lblVehicleID.setText(" ");
				lblVehicleName.setText(" ");
//				lblVehicleTypeID.setText(" ");
				lblVehicleTypeName.setText(" ");

				String mVehicleName = (String)cmbVehicle.getSelectedItem();
				vVehicleID = clsVehicle.getIDFromName(mVehicleName);
				clsVehicleReport temp = clsVehicleReport.getVehicleReportInformation(vVehicleID);

//				lblVehicleID.setText("Vehicle ID : "+temp.getVehicleID());
				lblVehicleName.setText("Vehicle Name : "+temp.getVehicleName());
				lblChessisNo.setText("ChessisNo : "+temp.getChessisNo());
//				lblVehicleTypeID.setText("Vehicle Type ID : "+temp.getVehicleTypeID());
				lblVehicleTypeName.setText("Vehicle Type Name : "+temp.getVehicleTypeName());
				lblInwardYear.setText("InwardYear : " +temp.getInwardYear() );

			}

			if(cmbRoot.getSelectedIndex() != 0 && cmbVehicle.getSelectedIndex() != 0 && cmbDriver.getSelectedIndex() != 0 && cmbConductor.getSelectedIndex() != 0)
			{
				PanelState.enabledComponents(pnlSave);
			}
			else
			{
				PanelState.disabledComponents(pnlSave);
			}

		}
		else if(ae.getSource() == cmbDriver)
		{
			if(cmbDriver.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Select Employee Properly ..... ");
			}
			else
			{
				lblDriverName.setText(" ");
				lblDriverAge.setText(" ");
				lblDriverGender.setText(" ");
				lblDriverEmailID.setText(" ");
				lblDriverContactNo.setText(" ");
				lblDriverDesignationName.setText(" ");
				lblDriverBillaNo.setText(" ");
				lblDriverLicenseNo.setText(" ");
				lblDriverAddress.setText(" ");

				String mDriverName = (String)cmbDriver.getSelectedItem();
				vDriverID = clsEmployee.getIDFromName(mDriverName);
				clsEmployeeReport temp = clsEmployeeReport.getEmployeeReportInformation(vDriverID);

				lblDriverName.setText("Driver Name : "+temp.getEmployeeName());
				lblDriverAge.setText("Age : "+temp.getAge());
				lblDriverContactNo.setText("Contact No. : "+temp.getContactNo());
				lblDriverGender.setText("Gender : "+temp.getGenderText());
//				lblDriverAreaName.setText("Area : "+);
				lblDriverEmailID.setText("Email ID : "+temp.getEmailID());
				lblDriverDesignationName.setText("Designation : "+temp.getDesignationName());
				lblDriverBillaNo.setText("Billa No. : "+temp.getBillaNo());
				lblDriverLicenseNo.setText("Licence No. : "+temp.getLicenseNo());
				lblDriverAddress.setText("Address : "+temp.getAddress()+" , "+temp.getAreaName()+", Pin Code : "+temp.getPinCode());
			}

			if(cmbRoot.getSelectedIndex() != 0 && cmbVehicle.getSelectedIndex() != 0 && cmbDriver.getSelectedIndex() != 0 && cmbConductor.getSelectedIndex() != 0)
			{
				PanelState.enabledComponents(pnlSave);
			}
			else
			{
				PanelState.disabledComponents(pnlSave);
			}

		}
		else if(ae.getSource() == cmbConductor)
		{
			if(cmbConductor.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Select Employee Properly ..... ");
			}
			else
			{
				lblConductorName.setText(" ");
				lblConductorAge.setText(" ");
				lblConductorGender.setText(" ");
				lblConductorEmailID.setText(" ");
				lblConductorContactNo.setText(" ");

				lblConductorDesignationName.setText(" ");
				lblConductorBillaNo.setText(" ");
				lblConductorLicenseNo.setText(" ");
				lblConductorAddress.setText(" ");

				String mConductorName = (String)cmbConductor.getSelectedItem();
				vConductorID = clsEmployee.getIDFromName(mConductorName);
				clsEmployeeReport temp = clsEmployeeReport.getEmployeeReportInformation(vConductorID);

				lblConductorName.setText("Conductor Name : "+temp.getEmployeeName());
				lblConductorAge.setText("Age : "+temp.getAge());
				lblConductorGender.setText("Gender : "+temp.getGenderText());
				lblConductorEmailID.setText("Email ID : "+temp.getEmailID());
				lblConductorContactNo.setText("Contact No. : "+temp.getContactNo());
				lblConductorDesignationName.setText("Designation : "+temp.getDesignationName());
				lblConductorBillaNo.setText("Billa No. : "+temp.getBillaNo());
				lblConductorLicenseNo.setText("Licence No. : "+temp.getLicenseNo());
				lblConductorAddress.setText("Address : "+temp.getAddress()+" , "+temp.getAreaName()+", Pin Code : "+temp.getPinCode());
			}

			if(cmbRoot.getSelectedIndex() != 0 && cmbVehicle.getSelectedIndex() != 0 && cmbDriver.getSelectedIndex() != 0 && cmbConductor.getSelectedIndex() != 0)
			{
				PanelState.enabledComponents(pnlSave);
			}
			else
			{
				PanelState.disabledComponents(pnlSave);
			}
		}
		else if(ae.getSource()==btnReport)
		{
			PanelState.hideComponents(pnlUI);
			PanelState.visibleComponents(pnlUIReport);
			setColumnsData();
			PanelState.hideComponents(pnlReport);
			PanelState.visibleComponents(pnlClose);
		}
		else if(ae.getSource()==btnClose)
		{
			PanelState.hideComponents(pnlUIReport);
			PanelState.visibleComponents(pnlUI);
			PanelState.hideComponents(pnlClose);
			PanelState.visibleComponents(pnlReport);
		}
		else if(ae.getSource()==btnSave)
		{

			clsAllocation temp = readUI();

			clsAllocation.addNewAllocation(temp);
			JOptionPane.showMessageDialog(null,"Allocation Added Successfully....!");
			setColumnsData2();
			PanelState.disabledComponents(pnlSave);
			addComboBoxRecords();

		}
	}

	void addRootRecords(JComboBox temp,int TodaysDay,int TodaysMonth,int TodaysYear)
	{
		temp.removeActionListener(this);
		clsRoot.addFreeRootRecords(temp, TodaysDay, TodaysMonth, TodaysYear);
		temp.addActionListener(this);
	}

	void addVehicleRecords(JComboBox temp,int TodaysDay,int TodaysMonth,int TodaysYear)
	{
		temp.removeActionListener(this);
		clsVehicle.addFreeVehicleRecords(temp, TodaysDay, TodaysMonth, TodaysYear);
		temp.addActionListener(this);
	}

	void addDriverRecords(JComboBox temp,int TodaysDay,int TodaysMonth,int TodaysYear)
	{
		temp.removeActionListener(this);
		clsEmployee.addFreeDriverRecords(temp, TodaysDay, TodaysMonth, TodaysYear);
		temp.addActionListener(this);
	}

	void addConductorRecords(JComboBox temp, int TodaysDay,int TodaysMonth,int TodaysYear)
	{
		temp.removeActionListener(this);
		clsEmployee.addFreeConductorRecords(temp,TodaysDay, TodaysMonth, TodaysYear);
		temp.addActionListener(this);
	}
/*	void addAllocationRecords(JComboBox temp)
	{
		clsAllocation.addAllocationRecords(temp);
	}*/


	public static void main(String args[])
	{
		frmAllocation F = new frmAllocation();
	}
}