import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class frmRoot extends JFrame implements ActionListener
{
	JPanel pnlUI;
	JPanel pnlUIReport;
	JPanel pnlRootUpdate;

	JPanel pnlLeft;
	JPanel pnlLeftBottom;

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

	JPanel pnlBottom;
	JLabel lblMovingBusDeveloperList;

	ScreenDesign myUI;

	JLabel lblProgramHeading;

	JLabel lblRootID ;
	JLabel lblRootName;
	JLabel lblSourceStation;
	JLabel lblVillagian;
	JLabel lblStartTime;
	JLabel lblDestinationStation;


	JLabel lblRootUpdate;
	JComboBox cmbRootUpdate;
	JComboBox cmbCombo1;
	JCheckBox chbVillagian;

	JTextField txtRootID;
	JTextField txtRootName;
	JTextField txtSourceStation;
	JTextField txtVillagian;
	JTextField txtDestinationStation;
	JTextField txtStartTime;

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

	JLabel lblSourceStationStatus_Correct;
	JLabel lblSourceStationStatus_Incorrect;
	JLabel lblDestinationStationStatus_Correct;
	JLabel lblDestinationStationStatus_Incorrect;

	String IncorrectStationImage = "imagesrc\\Incorrect.png";
	String CorrectStationImage = "imagesrc\\Correct.png";

	int vSourceID = 0;
	int vDestinationID = 0;

	String vFromPlaceFind = "From";
	String vToPlaceFind = "To";

	int Rcols;
	ReportTool tool;

	ButtonState bst;
	clsButtonManagement cbm;

	frmRoot()
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
		UISetting.setArea(pnlUI,575,450);

		pnlUIReport = myUI.getUIReportPanel();
		tool = new ReportTool(500,500);
		tool.setBounds(10,10,500,300);
		pnlUIReport.add(tool);
		UISetting.setArea(pnlUIReport,520,320);

		pnlLeft = myUI.getLeftPanel();

		pnlLeftBottom = ImagePanel.getPanel("imagesrc\\img-FrmRootManual.png");
		pnlLeftBottom.setLayout(null);
		pnlLeftBottom.setBackground(ColorSetting.getBackColorBottomPanel());
		pnlLeftBottom.setBounds(6,150,358,574);//6,5,358,70
		pnlLeft.add(pnlLeftBottom);

		pnlBottom = myUI.getBottomPanel();
		lblMovingBusDeveloperList = myUI.getMovingBusDeveloperListLabel();
		new ScrollLabel(lblMovingBusDeveloperList ,6,pnlBottom);

		pnlNew = myUI.getNewPanel();
		btnNew = myUI.getNewButton();
		btnNew.addActionListener(this);

		pnlSave = myUI.getSavePanel();
		btnSave = myUI.getSaveButton();
		btnSave.addActionListener(this);

		pnlCancel = myUI.getCancelPanel();
		btnCancel = myUI.getCancelButton();
		btnCancel.addActionListener(this);

		lblRootUpdate = myUI.getCombo1Label();
		lblRootUpdate.setText("***Route List***");

		pnlRootUpdate = myUI.getCombo1Panel();
		cmbRootUpdate = myUI.getCombo1();
		cmbRootUpdate.addActionListener(this);

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

		//pnlUIReport = myUI.getUIReportPanel();

		lblProgramHeading = myUI.getProgramHeadingLabel();
		lblProgramHeading.setText("Route Information");
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


		int y=100;
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

		lblRootID = new JLabel("Root ID : ");
		lblRootID.setLayout(null);
		lblRootID.setBounds(75,y,130,h);
		lblRootID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblRootID);

		txtRootID = new JTextField();
		txtRootID.setLayout(null);
		txtRootID.setBounds(275,y,100,h);
		txtRootID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtRootID);

		y=y+h+gap;

		lblRootName = new JLabel("Root Name : ");
		lblRootName.setLayout(null);
		lblRootName.setBounds(75,y,200,h);
		lblRootName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblRootName);

		txtRootName = new JTextField();
		txtRootName.setLayout(null);
		txtRootName.setBounds(275,y,255,h);
		txtRootName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtRootName);

		y=y+h+gap;

		lblSourceStation = new JLabel("Source Station :");
		lblSourceStation.setLayout(null);
		lblSourceStation.setBounds(75,y,300,h);
		lblSourceStation.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblSourceStation);

		txtSourceStation = new JTextField();
		txtSourceStation.setLayout(null);
		txtSourceStation.setBounds(275,y,200,h);
		txtSourceStation.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtSourceStation);

		//Search Button
		ImageIcon imgIconStatus_Incorrect = new ImageIcon("imagesrc\\Incorrect.png");
		Image imgStatus_Incorrect = imgIconStatus_Incorrect.getImage().getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH);
		Icon iconStatus_Incorrect = new ImageIcon(imgStatus_Incorrect);

		lblSourceStationStatus_Incorrect = new JLabel(iconStatus_Incorrect);
		lblSourceStationStatus_Incorrect.setBounds(480,y,30,30);
		lblSourceStationStatus_Incorrect.setVisible(false);
		pnlUI.add(lblSourceStationStatus_Incorrect);

		ImageIcon imgIconStatus_Correct = new ImageIcon("imagesrc\\Correct.png");
		Image imgStatus_Correct = imgIconStatus_Correct.getImage().getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH);
		Icon iconStatus_Correct = new ImageIcon(imgStatus_Correct);

		lblSourceStationStatus_Correct = new JLabel(iconStatus_Correct);
		lblSourceStationStatus_Correct.setBounds(480,y,30,30);
		lblSourceStationStatus_Correct.setVisible(false);
		pnlUI.add(lblSourceStationStatus_Correct);


		ImageIcon imgIconSearch = new ImageIcon("imagesrc\\imgSearch.png");
		Image imageSearch = imgIconSearch.getImage();
		Image newimgIconSearch = imageSearch.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH);
		Icon imgSearch = new ImageIcon(newimgIconSearch);
		btnSearchSourceStation = new JButton(imgSearch);
		btnSearchSourceStation.setBounds(515,y,30,h);
		btnSearchSourceStation.addActionListener(this);
		pnlUI.add(btnSearchSourceStation);

		y=y+h+gap;

		lblDestinationStation = new JLabel("Destination Station :");
		lblDestinationStation.setLayout(null);
		lblDestinationStation.setBounds(75,y,300,h);
		lblDestinationStation.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblDestinationStation);

		txtDestinationStation = new JTextField();
		txtDestinationStation.setLayout(null);
		txtDestinationStation.setBounds(275,y,200,h);
		txtDestinationStation.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtDestinationStation);

		//Source Station Status

		lblDestinationStationStatus_Incorrect = new JLabel(iconStatus_Incorrect);
		lblDestinationStationStatus_Incorrect.setBounds(480,y,30,30);
		lblDestinationStationStatus_Incorrect.setVisible(false);
		pnlUI.add(lblDestinationStationStatus_Incorrect);

		lblDestinationStationStatus_Correct = new JLabel(iconStatus_Correct);
		lblDestinationStationStatus_Correct.setBounds(480,y,30,30);
		lblDestinationStationStatus_Correct.setVisible(false);
		pnlUI.add(lblDestinationStationStatus_Correct);

		btnSearchDestinationStation = new JButton(imgSearch);
		btnSearchDestinationStation.setBounds(515,y,30,h);
		btnSearchDestinationStation.addActionListener(this);
		pnlUI.add(btnSearchDestinationStation);

		y=y+h+gap;

		chbVillagian=new JCheckBox(" Is Destination Village ?");
		chbVillagian.setBounds(75,y,230,h);
		chbVillagian.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(chbVillagian);

		y=y+h+gap;

		lblStartTime = new JLabel("Start Time :");
		lblStartTime.setLayout(null);
		lblStartTime.setBounds(75,y,200,h);
		lblStartTime.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblStartTime);

		txtStartTime = new JTextField();
		txtStartTime.setLayout(null);
		txtStartTime.setBounds(275,y,100,h);
		txtStartTime.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtStartTime);

		g1=new ButtonGroup();

		rbAM=new JRadioButton("AM");
		rbAM.setBounds(390,y,60,h);
		rbAM.setFont(new Font("Basic", Font.BOLD, 18));
		g1.add(rbAM);
		pnlUI.add(rbAM);

		rbPM=new JRadioButton("PM");
		rbPM.setBounds(470,y,60,h);
		rbPM.setFont(new Font("Basic", Font.BOLD, 18));
		g1.add(rbPM);
		pnlUI.add(rbPM);

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
		//cbm.manageCombo1Label(lblRootUpdate);
		cbm.managelblCombo1Panel(lblRootUpdate);
		cbm.manageCombo1Panel(pnlRootUpdate);
		cbm.manageCombo1(cmbRootUpdate);
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
		txtRootID.setText("0");
		txtRootName.setText("");
		txtRootName.requestFocus();
		txtSourceStation.setText("");
		chbVillagian.setSelected(false);
		txtDestinationStation.setText("");
		txtStartTime.setText("");
		g1.clearSelection();
	}

	clsRoot readUI()
	{
		clsRoot temp = new clsRoot();
		temp.setRootID(Integer.parseInt(txtRootID.getText()));
		temp.setRootName(txtRootName.getText());
		temp.setSourceStationID(vSourceID);

		if(chbVillagian.isSelected())
			temp.setVillagian(1);
		else
			temp.setVillagian(0);

		temp.setDestinationStationID(vDestinationID);
		temp.setStartTime(txtStartTime.getText());

		if(rbAM.isSelected())
			temp.setTimeShift(0);
		else
			temp.setTimeShift(1);

		return(temp);
	}

	void writeUI(clsRoot temp)
	{
		txtRootID.setText(String.valueOf(temp.getRootID()));
		txtRootName.setText(temp.getRootName());
		clsTaluka tempTaluka1 = clsTaluka.getTalukaInformation(temp.getSourceStationID());
		txtSourceStation.setText(tempTaluka1.getTalukaName());

		if(temp.getVillagian() == 0)
			chbVillagian.setSelected(false);
		else
			chbVillagian.setSelected(true);

		clsTaluka tempTaluka2 = clsTaluka.getTalukaInformation(temp.getDestinationStationID());
		txtDestinationStation.setText(tempTaluka2.getTalukaName());
		txtStartTime.setText(temp.getStartTime());

		if(temp.getTimeShift() == 0)
		{
			rbAM.setSelected(true);
			rbPM.setSelected(false);
		}
		else
		{
			rbAM.setSelected(false);
			rbPM.setSelected(true);
		}
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
		Rcols+=tool.addNewColumn("RootID");
		Rcols+=tool.addNewColumn("RootName");
	}

	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth()
	{
		tool.setColumnWidth("RootID",80);
		tool.setColumnWidth("RootName",200);
	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsRoot Data[]=clsRoot.getAllRootInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getRootName();

			tool.addNewRow(Objectdata);
		}
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNew)
		{
			initUI();
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);
			PanelState.disabledComponents(pnlPlaceFinder);
		}
		else if(ae.getSource() == btnView)
		{
			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
			addRootRecords(cmbRootUpdate);
		}
		else if(ae.getSource() == btnSave)
		{
			clsRoot temp = readUI();
			clsRoot.showRoot(temp);


				bst.setButtonState(ButtonState.SaveState);
				cbm.showButtonsOnUI(bst);
				if(clsRoot.addNewRoot(temp) == 0)
				{
					JOptionPane.showMessageDialog(null,"Entered Root Already Exist......! ");
				}
				else
				{
					bst.setButtonState(ButtonState.SaveState);
					cbm.showButtonsOnUI(bst);
					JOptionPane.showMessageDialog(null,"Root Added Successfully....!");
				}
		}
		else if(ae.getSource() == btnApply)
		{
			if(cmbRootUpdate.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Root Property....!");
			}
			else
			{
				String mRootName = (String)cmbRootUpdate.getSelectedItem();
				int mRootID = clsRoot.getIDFromName(mRootName);
				clsRoot temp=clsRoot.getRootInformation(mRootID);
				clsRoot.showRoot(temp);
				writeUI(temp);

				bst.setButtonState(ButtonState.ApplyState);
				cbm.showButtonsOnUI(bst);
			}


		}
		else if(ae.getSource() == btnEdit)
		{
			bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);
		}
		else if(ae.getSource() == btnUpdate)
		{
			bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);

			clsRoot temp = readUI();
			clsRoot.updateRoot(temp);
			PanelState.disabledComponents(pnlUI);
			JOptionPane.showMessageDialog(null,"Root Updated Successfully....!");
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsRoot temp = readUI();
			clsRoot.deleteRoot(temp);
			JOptionPane.showMessageDialog(null,"Root Deleted Successfully....!");
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
			setColumnsData();
		}
		else if(ae.getSource()==btnClose)
		{
			bst.setButtonCommonState(ButtonState.CloseReportState);
			cbm.showButtonsOnUI(bst);
		}
		else if(ae.getSource() == btnToPlaceFinder)
		{
			//frmPlaceFinder finder = new frmPlaceFinder();
			UISetting.setArea(pnlUI,1000,450);
			PanelState.enabledComponents(pnlPlaceFinder);
			addCountryRecords(cmbCountry);
		}
		else if(ae.getSource() == btnSearchSourceStation)
		{
			  String SourceStationName=txtSourceStation.getText();
			  int mTalukaID=clsTaluka.getIDFromName(SourceStationName);
			  if(mTalukaID==0)
			  {
					lblSourceStationStatus_Correct.setVisible(false);
					lblSourceStationStatus_Incorrect.setVisible(true);
					txtSourceStation.setForeground(Color.red);
					txtSourceStation.setText(SourceStationName);
					//txtSourceStationID.selectAll();
					txtSourceStation.requestFocus();

			   }
			   else
			   {
				   lblSourceStationStatus_Incorrect.setVisible(false);
				   lblSourceStationStatus_Correct.setVisible(true);
				   txtSourceStation.setForeground(Color.black);
				   txtDestinationStation.requestFocus();
				   vSourceID = mTalukaID;
			   }
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
				if(txtSourceStation.getText() == null && txtDestinationStation.getText() == null)
				{
					vFromPlaceFind = lblPlaceSelection.getText();
					txtSourceStation.setText(vFromPlaceFind);
				}
				else if(txtSourceStation.getText() != null && txtDestinationStation.getText() == null)
				{
					if(txtSourceStation.getText() == vFromPlaceFind)
					{

					}
				}
				else if(txtSourceStation.getText() != null && txtDestinationStation.getText() == null)
				{

				}
				else
				{

				}
			}
		}
		else if(ae.getSource() == cmbCountry)
		{
			String mCountry = (String)cmbCountry.getSelectedItem();
			int vCountryID = clsCountry.getIDFromName(mCountry);
			addStateRecords(cmbState,vCountryID);
		}
		else if(ae.getSource() == cmbState)
		{
			String mState = (String)cmbState.getSelectedItem();
			int vStateID = clsState.getIDFromName(mState);
			addDistrictRecords(cmbDistrict,vStateID);
		}
		else if(ae.getSource() == cmbDistrict)
		{
			String mDistrict = (String) cmbDistrict.getSelectedItem();
			int vDistrictID = clsDistrict.getIDFromName(mDistrict);
			addTalukaRecords(cmbTaluka,vDistrictID);
		}
		else if(ae.getSource() == cmbTaluka)
		{
			String mTaluka = (String) cmbTaluka.getSelectedItem();
			int vTalukaID = clsTaluka.getIDFromName(mTaluka);
			lblPlaceSelection.setText(mTaluka);
			addVillageRecords(cmbVillage,vTalukaID);
		}
		else if(ae.getSource() == cmbVillage)
		{
			String mVillage = (String) cmbVillage.getSelectedItem();
			int vVillageID = clsVillage.getIDFromName(mVillage);
			lblPlaceSelection.setText(mVillage);
		}

	}

	void addRootRecords(JComboBox temp)
	{
		clsRoot.addRootRecords(temp);
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
		frmRoot F = new frmRoot();
	}
}