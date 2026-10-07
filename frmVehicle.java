import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class frmVehicle extends JFrame implements ActionListener
{
	JPanel pnlUI;
	JPanel pnlUIReport;
	JPanel pnlVehicleUpdate;

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


	ScreenDesign myUI;

	JLabel lblProgramHeading;

	JLabel lblVehicleID ;
	JLabel lblVehicleName;
	JLabel lblVehicleType;
	JLabel lblChessisNo;
	JLabel lblInwardYear;

	JLabel lblVehicleUpdate;
	JComboBox cmbVehicleUpdate;
	JComboBox cmbCombo1;

	JComboBox cmbVehicleType;

	JTextField txtVehicleID;
	JTextField txtVehicleName;
	JTextField txtChessisNo;
	JTextField txtInwardYear;

	JPanel pnlBottom;
	JLabel lblMovingBusDeveloperList;

	int vVehicleTypeID = 0;

	int Rcols;
	ReportTool tool;

	ButtonState bst;
	clsButtonManagement cbm;

	frmVehicle()
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
		UISetting.setArea(pnlUI,500,400);

		pnlUIReport = myUI.getUIReportPanel();
		tool = new ReportTool(500,500);
		tool.setBounds(10,10,500,300);
		pnlUIReport.add(tool);
		UISetting.setArea(pnlUIReport,520,320);

		pnlLeft = myUI.getLeftPanel();

		pnlLeftBottom = ImagePanel.getPanel("imagesrc\\img-FrmVehicleManual.png");
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

		lblVehicleUpdate = myUI.getCombo1Label();
		lblVehicleUpdate.setText("***Vehicle List***");

		pnlVehicleUpdate = myUI.getCombo1Panel();
		cmbVehicleUpdate = myUI.getCombo1();
		cmbVehicleUpdate.addActionListener(this);

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
		lblProgramHeading.setText("Our Buses Information");
		new BlinkLabel(lblProgramHeading,800).start();

		lblVehicleID = new JLabel("Vehicle ID : ");
		lblVehicleID.setLayout(null);
		lblVehicleID.setBounds(70,40,130,50);
		lblVehicleID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblVehicleID);

		txtVehicleID = new JTextField();
		txtVehicleID.setLayout(null);
		txtVehicleID.setBounds(230,40,200,35);
		txtVehicleID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtVehicleID);

		lblVehicleName = new JLabel("Vehicle Name : ");
		lblVehicleName.setLayout(null);
		lblVehicleName.setBounds(70,110,200,50);
		lblVehicleName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblVehicleName);

		txtVehicleName = new JTextField();
		txtVehicleName.setLayout(null);
		txtVehicleName.setBounds(230,110,200,35);
		txtVehicleName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtVehicleName);

		lblVehicleType = new JLabel("Vehicle Type : ");
		lblVehicleType.setLayout(null);
		lblVehicleType.setBounds(70,180,200,50);
		lblVehicleType.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblVehicleType);

		cmbVehicleType=new JComboBox();
		cmbVehicleType.setBounds(230,180,200,35);
		cmbVehicleType.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbVehicleType);

		lblChessisNo = new JLabel("Cessis No : ");
		lblChessisNo.setLayout(null);
		lblChessisNo.setBounds(70,260,200,50);
		lblChessisNo.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblChessisNo);

		txtChessisNo = new JTextField();
		txtChessisNo.setLayout(null);
		txtChessisNo.setBounds(230,260,200,35);
		txtChessisNo.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtChessisNo);

		lblInwardYear = new JLabel("Inward No : ");
		lblInwardYear.setLayout(null);
		lblInwardYear.setBounds(70,330,200,50);
		lblInwardYear.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblInwardYear);

		txtInwardYear = new JTextField();
		txtInwardYear.setLayout(null);
		txtInwardYear.setBounds(230,330,200,35);
		txtInwardYear.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtInwardYear);

		//setDefaultOperation();

		bst = new ButtonState();
		cbm = new clsButtonManagement();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);

		addVehicleTypeRecords(cmbVehicleType);

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
		//cbm.manageCombo1Label(lblCountryUpdate);
		cbm.managelblCombo1Panel(lblVehicleUpdate);
		cbm.manageCombo1Panel(pnlVehicleUpdate);
		cbm.manageCombo1(cmbVehicleUpdate);
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
		txtVehicleID.setText("0");
		txtVehicleName.setText("");
		txtVehicleName.requestFocus();
	}

	clsVehicle readUI()
	{
		clsVehicle temp = new clsVehicle();
		temp.setVehicleID(Integer.parseInt(txtVehicleID.getText()));
		temp.setVehicleName(txtVehicleName.getText());
		temp.setVehicleTypeID(vVehicleTypeID);
		temp.setChessisNo(txtChessisNo.getText());
		temp.setInwardYear(Integer.parseInt(txtInwardYear.getText()));

		return(temp);
	}

	void writeUI(clsVehicle temp)
	{
		txtVehicleID.setText(String.valueOf(temp.getVehicleID()));
		txtVehicleName.setText(temp.getVehicleName());

		String mVehicleTypeName = clsVehicleType.getVehicleTypeInformation(temp.getVehicleTypeID()).getVehicleTypeName();
		cmbVehicleType.setSelectedItem(mVehicleTypeName);

		txtChessisNo.setText(temp.getChessisNo());
		txtInwardYear.setText(String.valueOf(temp.getInwardYear()));

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
		Rcols+=tool.addNewColumn("CountryID");
		Rcols+=tool.addNewColumn("CountryName");
	}

	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth()
	{
		tool.setColumnWidth("CountryID",80);
		tool.setColumnWidth("CountryName",200);
	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsCountry Data[]=clsCountry.getAllCountryInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getCountryName();

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
		}
		else if(ae.getSource() == btnView)
		{
			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
			addVehicleRecords(cmbVehicleUpdate);
		}
		else if(ae.getSource() == btnSave)
		{
			clsVehicle temp = readUI();
			clsVehicle.showVehicle(temp);


				bst.setButtonState(ButtonState.SaveState);
				cbm.showButtonsOnUI(bst);
				if(clsVehicle.addNewVehicle(temp) == 0)
				{
					JOptionPane.showMessageDialog(null,"Entered Vehicle Already Exist......! ");
				}
				else
				{
					bst.setButtonState(ButtonState.SaveState);
					cbm.showButtonsOnUI(bst);
					JOptionPane.showMessageDialog(null,"Vehicle Added Successfully....!");
				}
		}
		else if(ae.getSource() == btnApply)
		{
			if(cmbVehicleUpdate.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Country Property....!");
			}
			else
			{
				String mVehicleName = (String)cmbVehicleUpdate.getSelectedItem();
				int mVehicleID = clsVehicle.getIDFromName(mVehicleName);
				clsVehicle temp=clsVehicle.getVehicleInformation(mVehicleID);
				clsVehicle.showVehicle(temp);
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

			clsVehicle temp = readUI();
			clsVehicle.updateVehicle(temp);
			PanelState.disabledComponents(pnlUI);
			JOptionPane.showMessageDialog(null,"Vehicle Updated Successfully....!");
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsVehicle temp = readUI();
			clsVehicle.deleteVehicle(temp);
			JOptionPane.showMessageDialog(null,"Vehicle Deleted Successfully....!");
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
		else if(ae.getSource() == cmbVehicleType)
		{
			if(cmbVehicleType.getSelectedIndex() != 0)
			{
				String mVehicleTypeName = (String) cmbVehicleType.getSelectedItem();
				vVehicleTypeID = clsVehicleType.getIDFromName(mVehicleTypeName);
			}

		}


	}

	void addVehicleRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsVehicle.addVehicleRecords(temp);
		temp.addActionListener(this);
	}

	void addVehicleTypeRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsVehicleType.addVehicleTypeRecords(temp);
		temp.addActionListener(this);
	}



	public static void main(String args[])
	{
		frmVehicle F = new frmVehicle();
	}
}