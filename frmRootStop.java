import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class frmRootStop extends JFrame implements ActionListener
{
	JPanel pnlUI;
	JPanel pnlUIReport;
	JPanel pnlRootStopUpdate;

	JPanel pnlApply;
	JButton btnApply;

	JPanel pnlNew;
	JButton btnNew;

	JPanel pnlSave;
	JButton btnSave;

	JPanel pnlView;
	JButton btnView;

	JPanel pnlEdit;
	JButton btnEdit;

	JPanel pnlUpdate;
	JButton btnUpdate;

	JPanel pnlDelete;
	JButton btnDelete;

	JPanel pnlCancel;
	JButton btnCancel;

	JPanel pnlReport;
	JButton btnReport;

	JPanel pnlClose;
	JButton btnClose;


	ScreenDesign myUI;

	JLabel lblProgramHeading;

	JLabel lblRootStopID ;
	JLabel lblRootID;
	JLabel lblStopTime;
	JLabel lblMinute;
	JLabel lblDestinationStation;
	JLabel lblStartTime;

	JLabel lblRootStopUpdate;
	JComboBox cmbRootStopUpdate;
	JComboBox cmbCombo1;
	JCheckBox chbVillagian;
	JComboBox cmbRoot;

	JTextField txtRootStopID;
	JTextField txtDestinationStation;
	JTextField txtStopTime;
	JLabel lblStartTiming;

	JPanel pnlRootDisplay;

	JButton btnSearchSourceStation;
	JButton btnSearchDestinationStation;

	ButtonGroup g1;
	JRadioButton rbAM;
	JRadioButton rbPM;

	JButton btnToPlaceFinder;

	JPanel pnlPlaceFinder;
	JLabel lblPlaceFinder;
	JComboBox cmbCountry;
	JComboBox cmbState;
	JComboBox cmbDistrict;
	JComboBox cmbTaluka;
	JComboBox cmbVillage;
	JButton btnNewTalukaDoc;
	JButton btnRefreshTalukaDoc;
	JButton btnNewVillageDoc;
	JButton btnRefreshVillageDoc;
	JLabel lblPlaceSelection;
	JButton btnSelectAndClose;

	JLabel lblDestinationStationStatus_Correct;
	JLabel lblDestinationStationStatus_Incorrect;

	String IncorrectStationImage = "imagesrc\\Incorrect.png";
	String CorrectStationImage = "imagesrc\\Correct.png";

	int vDestinationID = 0;
	int vStartTiming = 0;
	int vRootID=0;

	int Rcols;
	ReportTool tool;

	ButtonState bst;
	clsButtonManagement cbm;

	frmRootStop()
	{
		setSize(1950,1200);
		setLocation(1,1);
		setLayout(null);
		setBackground(ColorSetting.getBackColorFrame());
		setTitle("Form Designing");
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );


		myUI = new ScreenDesign();
		add(myUI);

		pnlUI = myUI.getUIPanel();
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,575,500);//800,350

		//pnlUIReport = myUI.getUIReportPanel();
		//UISetting.setArea(pnlUIReport,520,320);

		pnlNew = myUI.getNewPanel();
		btnNew = myUI.getNewButton();
		btnNew.addActionListener(this);

		pnlSave = myUI.getSavePanel();
		btnSave = myUI.getSaveButton();
		btnSave.addActionListener(this);

		pnlCancel = myUI.getCancelPanel();
		btnCancel = myUI.getCancelButton();
		btnCancel.addActionListener(this);

		lblRootStopUpdate = myUI.getCombo1Label();
		lblRootStopUpdate.setText("***RootStop List***");

		pnlRootStopUpdate = myUI.getCombo1Panel();
		cmbRootStopUpdate = myUI.getCombo1();
		cmbRootStopUpdate.addActionListener(this);

		pnlView = myUI.getViewPanel();
		btnView = myUI.getViewButton();
		btnView.addActionListener(this);

		pnlReport = myUI.getReportPanel();
		btnReport = myUI.getReportButton();
		btnReport.addActionListener(this);

		pnlClose = myUI.getClosePanel();
		btnClose = myUI.getCloseButton();
		btnClose.addActionListener(this);

		pnlApply = myUI.getApplyPanel();
		btnApply = myUI.getApplyButton();
		btnApply.addActionListener(this);

		pnlEdit = myUI.getEditPanel();
		btnEdit = myUI.getEditButton();
		btnEdit.addActionListener(this);

		pnlDelete = myUI.getDeletePanel();
		btnDelete = myUI.getDeleteButton();
		btnDelete.addActionListener(this);

		pnlUpdate = myUI.getUpdatePanel();
		btnUpdate = myUI.getUpdateButton();
		btnUpdate.addActionListener(this);

		pnlUIReport = myUI.getUIReportPanel();

		lblProgramHeading = myUI.getProgramHeadingLabel();
		lblProgramHeading.setText("RootStop Information");
		new BlinkLabel(lblProgramHeading,800).start();

		ImageIcon imgIcon = new ImageIcon("imagesrc\\fast-forward.png");
		Image image = imgIcon.getImage();
		Image newimage = image.getScaledInstance(45,48,java.awt.Image.SCALE_SMOOTH);
		Icon img = new ImageIcon(newimage);
		btnToPlaceFinder = new JButton(img);
		btnToPlaceFinder.setBounds(520,25,50,48);
		btnToPlaceFinder.addActionListener(this);
		btnToPlaceFinder.setBackground(ColorSetting.getBackColorUIPanel());
		btnToPlaceFinder.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlUI.add(btnToPlaceFinder);

		int y=50;
		int h=30;
		int gap=15;
		int y1=10;
		int gap1=20;

		pnlPlaceFinder = new JPanel();
		pnlPlaceFinder.setBounds(575,25,400,400);
		pnlPlaceFinder.setLayout(null);
		pnlPlaceFinder.setBackground(Color.WHITE);
		pnlUI.add(pnlPlaceFinder);

		lblPlaceFinder = new JLabel("Place Finder");
		lblPlaceFinder.setFont(new Font("Basic", Font.BOLD, 28));
		lblPlaceFinder.setBounds(115,y1,170,h);
		pnlPlaceFinder.add(lblPlaceFinder);

		y1=y1+gap1+h;

		cmbCountry = new JComboBox();
		cmbCountry.setBounds(50,y1,250,h);
		cmbCountry.setFont(new Font("Basic", Font.BOLD, 18));
		pnlPlaceFinder.add(cmbCountry);
		cmbCountry.addActionListener(this);

		y1=y1+gap1+h;

		cmbState = new JComboBox();
		cmbState.setBounds(50,y1,250,h);
		cmbState.setFont(new Font("Basic", Font.BOLD, 18));
		pnlPlaceFinder.add(cmbState);
		cmbState.addActionListener(this);

		y1=y1+gap1+h;

		cmbDistrict= new JComboBox();
		cmbDistrict.setBounds(50,y1,250,h);
		cmbDistrict.setFont(new Font("Basic", Font.BOLD, 18));
		pnlPlaceFinder.add(cmbDistrict);
		cmbDistrict.addActionListener(this);

		y1=y1+gap1+h;

		cmbTaluka= new JComboBox();
		cmbTaluka.setBounds(50,y1,250,h);
		cmbTaluka.setFont(new Font("Basic", Font.BOLD, 18));
		pnlPlaceFinder.add(cmbTaluka);
		cmbTaluka.addActionListener(this);

		ImageIcon imgIcon1 = new ImageIcon("imagesrc\\imgNewDoc.png");
		Image image1 = imgIcon1.getImage();
		Image newimage1 = image1.getScaledInstance(48,45,java.awt.Image.SCALE_SMOOTH);
		Icon imgNewDoc = new ImageIcon(newimage1);
		btnNewTalukaDoc = new JButton(imgNewDoc);
		btnNewTalukaDoc.setBounds(310,y1-7,48,45);
		btnNewTalukaDoc.addActionListener(this);
		btnNewTalukaDoc.setBackground(Color.WHITE);
		btnNewTalukaDoc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlPlaceFinder.add(btnNewTalukaDoc);

		ImageIcon imgIcon2 = new ImageIcon("imagesrc\\imgRefreshDoc.png");
		Image image2 = imgIcon2.getImage();
		Image refreshimage2 = image2.getScaledInstance(48,45,java.awt.Image.SCALE_SMOOTH);
		Icon imgRefreshDoc = new ImageIcon(refreshimage2);
		btnRefreshTalukaDoc = new JButton(imgRefreshDoc);
		btnRefreshTalukaDoc.setBounds(310,y1-7,48,45);
		btnRefreshTalukaDoc.setBackground(Color.WHITE);
		btnRefreshTalukaDoc.addActionListener(this);
		btnRefreshTalukaDoc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlPlaceFinder.add(btnRefreshTalukaDoc);

		y1=y1+gap1+h;

		cmbVillage= new JComboBox();
		cmbVillage.setBounds(50,y1,250,h);
		cmbVillage.setFont(new Font("Basic", Font.BOLD, 18));
		pnlPlaceFinder.add(cmbVillage);

		btnNewVillageDoc = new JButton(imgNewDoc);
		btnNewVillageDoc.setBounds(310,y1-7,48,45);
		btnNewVillageDoc.addActionListener(this);
		btnNewVillageDoc.setBackground(Color.WHITE);
		btnNewVillageDoc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlPlaceFinder.add(btnNewVillageDoc);


		btnRefreshVillageDoc = new JButton(imgRefreshDoc);
		btnRefreshVillageDoc.setBounds(310,y1-7,48,45);
		btnRefreshVillageDoc.setBackground(Color.WHITE);
		btnRefreshVillageDoc.addActionListener(this);
		btnRefreshVillageDoc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlPlaceFinder.add(btnRefreshVillageDoc);

		y1=y1+gap1+h;

		lblPlaceSelection = new JLabel("No Place Selected");
		lblPlaceSelection.setBounds(50,y1,250,h);
		lblPlaceSelection.setFont(new Font("Basic", Font.BOLD, 18));
		pnlPlaceFinder.add(lblPlaceSelection);

		y1=y1+gap1+h;

		btnSelectAndClose = new JButton("Select & Close");
		btnSelectAndClose.setBounds(110,y1,180,h);
		btnSelectAndClose.setFont(new Font("Basic", Font.BOLD, 18));
		pnlPlaceFinder.add(btnSelectAndClose);
		btnSelectAndClose.addActionListener(this);


		lblRootStopID = new JLabel("Root Stop ID : ");
		lblRootStopID.setLayout(null);
		lblRootStopID.setBounds(75,y,130,h);
		lblRootStopID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblRootStopID);

		txtRootStopID = new JTextField();
		txtRootStopID.setLayout(null);
		txtRootStopID.setBounds(275,y,100,h);
		txtRootStopID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtRootStopID);

		y=y+h+gap;

		lblRootID = new JLabel("Select Root : ");
		lblRootID.setLayout(null);
		lblRootID.setBounds(75,y,200,h);
		lblRootID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblRootID);

		cmbRoot = new JComboBox();
		cmbRoot.setBounds(275,y,275,h);
		cmbRoot.setFont(new Font("Basic", Font.BOLD, 18));
		cmbRoot.addActionListener(this);
		pnlUI.add(cmbRoot);


		y=y+h+gap;

		lblStartTime = new JLabel("Start Time :");
		lblStartTime.setBounds(275,y,110,h);
		lblStartTime.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblStartTime);

		lblStartTiming = new JLabel("---------");
		lblStartTiming.setBounds(380,y,100,h);
		lblStartTiming.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblStartTiming);

		y=y+h+gap;

		lblDestinationStation = new JLabel("Station Stop : ");
		lblDestinationStation.setLayout(null);
		lblDestinationStation.setBounds(75,y,300,h);
		lblDestinationStation.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblDestinationStation);

		txtDestinationStation = new JTextField();
		txtDestinationStation.setLayout(null);
		txtDestinationStation.setBounds(275,y,200,h);
		txtDestinationStation.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtDestinationStation);

		ImageIcon imgIconStatus_Incorrect = new ImageIcon("imagesrc\\Incorrect.png");
		Image imgStatus_Incorrect = imgIconStatus_Incorrect.getImage().getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH);
		Icon iconStatus_Incorrect = new ImageIcon(imgStatus_Incorrect);

		lblDestinationStationStatus_Incorrect = new JLabel(iconStatus_Incorrect);
		lblDestinationStationStatus_Incorrect.setBounds(480,y,30,30);
		lblDestinationStationStatus_Incorrect.setVisible(false);
		pnlUI.add(lblDestinationStationStatus_Incorrect);

		ImageIcon imgIconStatus_Correct = new ImageIcon("imagesrc\\Correct.png");
		Image imgStatus_Correct = imgIconStatus_Correct.getImage().getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH);
		Icon iconStatus_Correct = new ImageIcon(imgStatus_Correct);

		lblDestinationStationStatus_Correct = new JLabel(iconStatus_Correct);
		lblDestinationStationStatus_Correct.setBounds(480,y,30,30);
		lblDestinationStationStatus_Correct.setVisible(false);
		pnlUI.add(lblDestinationStationStatus_Correct);

		ImageIcon imgIconSearch = new ImageIcon("imagesrc\\imgSearch.png");
		Image imageSearch = imgIconSearch.getImage();
		Image newimgIconSearch = imageSearch.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH);
		Icon imgSearch = new ImageIcon(newimgIconSearch);
		btnSearchDestinationStation = new JButton(imgSearch);
		btnSearchDestinationStation.setBounds(520,y,30,h);
		btnSearchDestinationStation.addActionListener(this);
		pnlUI.add(btnSearchDestinationStation);

		/*chbVillagian=new JCheckBox(" Is Destination Village ?");
		chbVillagian.setBounds(550,y,230,h);
		chbVillagian.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(chbVillagian);*/

		y=y+h+gap;

		lblStopTime = new JLabel("Stop Time :");
		lblStopTime.setLayout(null);
		lblStopTime.setBounds(75,y,200,h);
		lblStopTime.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblStopTime);

		txtStopTime = new JTextField();
		txtStopTime.setLayout(null);
		txtStopTime.setBounds(275,y,100,h);
		txtStopTime.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtStopTime);

		lblMinute = new JLabel("Minutes");
		lblMinute.setBounds(380,y,200,h);
		lblMinute.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblMinute);

		y=y+h+gap;

		pnlRootDisplay = new JPanel();
		pnlRootDisplay.setLayout(null);
		pnlRootDisplay.setBounds(20,y,530,200);
		pnlRootDisplay.setBackground(Color.WHITE);
		pnlUI.add(pnlRootDisplay);

		tool = new ReportTool(500,500);
		tool.setBounds(10,10,500,300);
		pnlRootDisplay.add(tool);


		//setDefaultOperation();

		bst = new ButtonState();
		cbm = new clsButtonManagement();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);

		createReport();

		show();

	}

	void automateButtons()
	{
		cbm.manageNewPanel(pnlNew);
		cbm.manageViewPanel(pnlView);
		cbm.manageUIPanel(pnlUI);
		cbm.manageUIReportPanel(pnlUIReport);
		//cbm.manageEntryPanel(pnlEntry);
		//cbm.manageDataReportPanel(pnlDataReport);
		cbm.manageSavePanel(pnlSave);
		cbm.manageViewPanel(pnlView);
		cbm.manageEditPanel(pnlEdit);
		cbm.manageUpdatePanel(pnlUpdate);
		cbm.manageDeletePanel(pnlDelete);
		cbm.manageCancelPanel(pnlCancel);
		cbm.manageReportPanel(pnlReport);
		cbm.manageApplyPanel(pnlApply);
		//cbm.manageCombo1Label(lblRootStopUpdate);
		cbm.managelblCombo1Panel(lblRootStopUpdate);
		cbm.manageCombo1Panel(pnlRootStopUpdate);
		cbm.manageCombo1(cmbRootStopUpdate);
		cbm.manageClosePanel(pnlClose);

	}

	void setDefaultOperation()
	{
		PanelState.enabledComponents(pnlNew);
		PanelState.enabledComponents(pnlView);
		PanelState.enabledComponents(pnlReport);
		PanelState.disabledComponents(pnlUI);
	}

	void initUI()
	{
		txtRootStopID.setText("0");
		cmbRoot.setSelectedItem(0);
		txtDestinationStation.setText("");
		txtStopTime.setText("");
		//g1.clearSelection();
	}

	clsRootStop readUI()
	{
		clsRootStop temp = new clsRootStop();
		temp.setRootStopID(Integer.parseInt(txtRootStopID.getText()));
		temp.setRootID(clsRoot.getIDFromName((String)cmbRoot.getSelectedItem()));

		temp.setStationID(clsTaluka.getIDFromName(txtDestinationStation.getText()));
		temp.setStopTime(txtStopTime.getText());

		return(temp);
	}

	void writeUI(clsRootStop temp)
	{
		txtRootStopID.setText(String.valueOf(temp.getRootStopID()));
		//cmbRoot.setSelectedItem(clsRoot.getRootInformation(temp.getRootID()).get);

		/*if(temp.getVillagian() == 0)
			chbVillagian.setSelected(false);
		else
			chbVillagian.setSelected(true);*/

		txtDestinationStation.setText(String.valueOf(temp.getStationID()));
		txtStopTime.setText(temp.getStopTime());

		/*if(temp.getTimeShift() == 0)
		{
			rbAM.setSelected(true);
			rbPM.setSelected(false);
		}
		else
		{
			rbAM.setSelected(false);
			rbPM.setSelected(true);
		}*/
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
		Rcols+=tool.addNewColumn("Sr. No.");
		Rcols+=tool.addNewColumn("Station Name");
		Rcols+=tool.addNewColumn("Stop Time");
	}

	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth()
	{
		tool.setColumnWidth("Sr. No.",80);
		tool.setColumnWidth("Station Name",200);
		tool.setColumnWidth("Stop Time",100);
	}

	void setColumnsData()
	{

		tool.removeAllRows();
		clsRootStopReport Data[];

		if(vRootID != 0)
			Data=clsRootStopReport.getAllRootStopReportInformation(vRootID);
		else
			Data=clsRootStopReport.getAllRootStopReportInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getTalukaName();
			Objectdata[2]=Data[i].getStopTime()+" Minutes";

			tool.addNewRow(Objectdata);
		}
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNew)
		{
			initUI();
			clsRoot.addRootRecords(cmbRoot);
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);
		}
		else if(ae.getSource() == btnView)
		{
			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
			addRootStopRecords(cmbRootStopUpdate);
		}
		else if(ae.getSource() == btnSave)
		{
			clsRootStop temp = readUI();
			clsRootStop.showRootStop(temp);
			clsRootStop.addNewRootStop(temp);
			JOptionPane.showMessageDialog(null,"RootStop Added Successfully....!");

			/*if(clsRootStop.isRootStopDulplicate(temp.getRootStopName()))
			{
				JOptionPane.showMessageDialog(null,"Entered RootStop Already Exist......! ");
			}
			else
			{*/
			vRootID = temp.getRootID();
			setColumnsData();
			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
		}
		/*else if(ae.getSource() == btnApply)
		{
			if(cmbRootStopUpdate.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select RootStop Property....!");
			}
			else
			{
				String mRootStopName = (String)cmbRootStopUpdate.getSelectedItem();
				int mRootStopID = clsRootStop.getIDFromName(mRootStopName);
				clsRootStop temp=clsRootStop.getRootStopInformation(mRootStopID);
				clsRootStop.showRootStop(temp);
				writeUI(temp);

				bst.setButtonState(ButtonState.ApplyState);
				cbm.showButtonsOnUI(bst);
			}


		}*/
		else if(ae.getSource() == btnEdit)
		{
			bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);
		}
		else if(ae.getSource() == btnUpdate)
		{
			bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);

			clsRootStop temp = readUI();
			clsRootStop.updateRootStop(temp);
			PanelState.disabledComponents(pnlUI);
			JOptionPane.showMessageDialog(null,"RootStop Updated Successfully....!");
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsRootStop temp = readUI();
			clsRootStop.deleteRootStop(temp);
			JOptionPane.showMessageDialog(null,"RootStop Deleted Successfully....!");
		}
		else if(ae.getSource() == btnCancel)
		{
			bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);
		}
		else if(ae.getSource()==btnReport)
		{
			bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
			vRootID = 0;
			setColumnsData();
		}
		else if(ae.getSource()==btnClose)
		{
			bst.setButtonCommonState(ButtonState.CloseReportState);
			cbm.showButtonsOnUI(bst);
		}
		else if(ae.getSource() == btnToPlaceFinder)
		{
			UISetting.setArea(pnlUI,1000,500);
			PanelState.enabledComponents(pnlPlaceFinder);
			addCountryRecords(cmbCountry);
		}

		else if(ae.getSource() == btnSearchDestinationStation)
		{
			  String DestinationStationName = txtDestinationStation.getText();
			  int mTalukaID=clsTaluka.getIDFromName(DestinationStationName);
			  if(mTalukaID==0)
			  {
					lblDestinationStationStatus_Correct.setVisible(false);
					lblDestinationStationStatus_Incorrect.setVisible(true);
					txtDestinationStation.setForeground(Color.red);
					txtDestinationStation.setText(DestinationStationName);
					//txtSourceStationID.selectAll();
					txtDestinationStation.requestFocus();

			   }
			   else
			   {
				   lblDestinationStationStatus_Incorrect.setVisible(false);
				   lblDestinationStationStatus_Correct.setVisible(true);
				   txtDestinationStation.setForeground(Color.black);
				   txtDestinationStation.requestFocus();
				   vDestinationID = mTalukaID;
			   }

		}
		else if(ae.getSource() == btnSelectAndClose)
		{
			UISetting.setArea(pnlUI,575,450);
			if(cmbCountry.getSelectedIndex() == 0 || cmbState.getSelectedIndex() == 0 || cmbDistrict.getSelectedIndex() == 0 || cmbTaluka.getSelectedIndex() == 0)
			{
					JOptionPane.showMessageDialog(null,"Select Valid Country or State or District or Taluka....!");
			}
			else
			{

			}
		}
		else if(ae.getSource() == cmbCountry)
		{
			String mCountry = (String)cmbCountry.getSelectedItem();
			int mCountryID = clsCountry.getIDFromName(mCountry);
			addStateRecords(cmbState,mCountryID);
		}
		else if(ae.getSource() == cmbState)
		{
			String mState = (String)cmbState.getSelectedItem();
			int mStateID = clsState.getIDFromName(mState);
			addDistrictRecords(cmbDistrict,mStateID);
		}
		else if(ae.getSource() == cmbDistrict)
		{
			String mDistrict = (String) cmbDistrict.getSelectedItem();
			int mDistrictID = clsDistrict.getIDFromName(mDistrict);
			addTalukaRecords(cmbTaluka,mDistrictID);
		}
		else if(ae.getSource() == cmbTaluka)
		{
			String mTaluka = (String) cmbTaluka.getSelectedItem();
			int mTalukaID = clsTaluka.getIDFromName(mTaluka);
			addVillageRecords(cmbVillage,mTalukaID);
		}

		else if(ae.getSource() == btnSelectAndClose)
		{
			UISetting.setArea(pnlUI,575,500);
		}
		else if(ae.getSource() == cmbRoot)
		{
			String RootName = (String)cmbRoot.getSelectedItem();

			if(cmbRoot.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Root....!");
				 vRootID = 0;
				 setColumnsData();
			}
			else
			{
				 clsRoot temp = clsRoot.getRootInformation(clsRoot.getIDFromName(RootName));
				 vRootID = temp.getRootID();
				 setColumnsData();
				 String mStartTiming = temp.getStartTime();

				 if(temp.getTimeShift()==0)
				 	lblStartTiming.setText(mStartTiming+ " AM");
				 else
				 	lblStartTiming.setText(mStartTiming+ " 1PM");

			}
		}

	}

	void addRootStopRecords(JComboBox temp)
	{
		//clsRootStop.addRootStopRecords(temp);
	}
	void addCountryRecords(JComboBox temp)
	{
		clsCountry.addCountryRecords(temp);
	}

	void addStateRecords(JComboBox temp,int mCountryID)
	{
		clsState.addStateRecords(temp,mCountryID);
	}

	void addDistrictRecords(JComboBox temp,int mStateID)
	{
		clsDistrict.addDistrictRecords(temp,mStateID);
	}

	void addTalukaRecords(JComboBox temp,int mDistrictID)
	{
		clsTaluka.addTalukaRecords(temp,mDistrictID);
	}

	void addVillageRecords(JComboBox temp,int mTalukaID)
	{
		clsVillage.addVillageRecords(temp,mTalukaID);
	}


	public static void main(String args[])
	{
		frmRootStop F = new frmRootStop();
	}
}