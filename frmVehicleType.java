import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class frmVehicleType extends JFrame implements ActionListener
{
	JPanel pnlUI;
	JPanel pnlUIReport;
	JPanel pnlVehicleTypeUpdate;

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

	JLabel lblVehicleTypeID ;
	JLabel lblVehicleTypeName;


	JLabel lblVehicleTypeUpdate;
	JComboBox cmbVehicleTypeUpdate;
	JComboBox cmbCombo1;


	JTextField txtVehicleTypeID;
	JTextField txtVehicleTypeName;



	int Rcols;
	ReportTool tool;

	ButtonState bst;
	clsButtonManagement cbm;

	frmVehicleType()
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
		UISetting.setArea(pnlUI,550,200);

		pnlUIReport = myUI.getUIReportPanel();
		tool = new ReportTool(500,500);
		tool.setBounds(10,10,500,300);
		pnlUIReport.add(tool);
		UISetting.setArea(pnlUIReport,520,320);

		pnlNew = myUI.getNewPanel();
		btnNew = myUI.getNewButton();
		btnNew.addActionListener(this);

		pnlSave = myUI.getSavePanel();
		btnSave = myUI.getSaveButton();
		btnSave.addActionListener(this);

		pnlCancel = myUI.getCancelPanel();
		btnCancel = myUI.getCancelButton();
		btnCancel.addActionListener(this);

		lblVehicleTypeUpdate = myUI.getCombo1Label();

		pnlVehicleTypeUpdate = myUI.getCombo1Panel();
		cmbVehicleTypeUpdate = myUI.getCombo1();
		cmbVehicleTypeUpdate.addActionListener(this);

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
		lblProgramHeading.setText("Country Information");
		new BlinkLabel(lblProgramHeading,800).start();

		lblVehicleTypeID = new JLabel("Vehicle Type ID : ");
		lblVehicleTypeID.setLayout(null);
		lblVehicleTypeID.setBounds(70,40,160,50);
		lblVehicleTypeID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblVehicleTypeID);

		txtVehicleTypeID = new JTextField();
		txtVehicleTypeID.setLayout(null);
		txtVehicleTypeID.setBounds(260,40,200,50);
		txtVehicleTypeID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtVehicleTypeID);

		lblVehicleTypeName = new JLabel("Vehicle Type Name : ");
		lblVehicleTypeName.setLayout(null);
		lblVehicleTypeName.setBounds(70,110,200,50);
		lblVehicleTypeName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblVehicleTypeName);

		txtVehicleTypeName = new JTextField();
		txtVehicleTypeName.setLayout(null);
		txtVehicleTypeName.setBounds(260,110,200,50);
		txtVehicleTypeName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtVehicleTypeName);

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
		//cbm.manageCombo1Label(lblCountryUpdate);
		cbm.managelblCombo1Panel(lblVehicleTypeUpdate);
		cbm.manageCombo1Panel(pnlVehicleTypeUpdate);
		cbm.manageCombo1(cmbVehicleTypeUpdate);
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
		txtVehicleTypeID.setText("0");
		txtVehicleTypeName.setText("");
		txtVehicleTypeName.requestFocus();
	}

	clsVehicleType readUI()
	{
		clsVehicleType temp = new clsVehicleType();
		temp.setVehicleTypeID(Integer.parseInt(txtVehicleTypeID.getText()));
		temp.setVehicleTypeName(txtVehicleTypeName.getText());
		return(temp);
	}

	void writeUI(clsVehicleType temp)
	{
		txtVehicleTypeID.setText(String.valueOf(temp.getVehicleTypeID()));
		txtVehicleTypeName.setText(temp.getVehicleTypeName());
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
		Rcols+=tool.addNewColumn("VehicleTypeID");
		Rcols+=tool.addNewColumn("VehicleTypeName");
	}

	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth()
	{
		tool.setColumnWidth("VehicleTypeID",80);
		tool.setColumnWidth("VehicleTypeName",200);
	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsVehicleType Data[]=clsVehicleType.getAllVehicleTypeInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getVehicleTypeName();

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
			addVehicleTypeRecords(cmbVehicleTypeUpdate);
		}
		else if(ae.getSource() == btnSave)
		{
			clsVehicleType temp = readUI();
			clsVehicleType.showVehicleType(temp);

			/*if(clsVehicle.isVehicleDulplicate(temp.getVehicleName()))
			{
				JOptionPane.showMessageDialog(null,"Entered Country Already Exist......! ");
			}
			else
			{*/
				bst.setButtonState(ButtonState.SaveState);
				cbm.showButtonsOnUI(bst);
				clsVehicleType.addNewVehicleType(temp);
				JOptionPane.showMessageDialog(null,"Country Added Successfully....!");
			//}
		}
		else if(ae.getSource() == btnApply)
		{
			if(cmbVehicleTypeUpdate.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Vehicle Type Property....!");
			}
			else
			{
				String mVehicleTypeName = (String)cmbVehicleTypeUpdate.getSelectedItem();
				int mVehicleTypeID = clsVehicleType.getIDFromName(mVehicleTypeName);
				clsVehicleType temp=clsVehicleType.getVehicleTypeInformation(mVehicleTypeID);
				clsVehicleType.showVehicleType(temp);
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

			clsVehicleType temp = readUI();
			clsVehicleType.updateVehicleType(temp);
			PanelState.disabledComponents(pnlUI);
			JOptionPane.showMessageDialog(null,"Vehicle Type Updated Successfully....!");
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsVehicleType temp = readUI();
			clsVehicleType.deleteVehicleType(temp);
			JOptionPane.showMessageDialog(null,"Vehicle Type Deleted Successfully....!");
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


	}

	void addVehicleTypeRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsVehicleType.addVehicleTypeRecords(temp);
		temp.addActionListener(this);
	}





	public static void main(String args[])
	{
		frmVehicleType F = new frmVehicleType();
	}
}