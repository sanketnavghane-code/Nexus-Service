import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class frmDesignation extends JFrame implements ActionListener
{
	JPanel pnlUI;
	JPanel pnlUIReport;
	JPanel pnlDesignationUpdate;

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

	JLabel lblDesignationID ;
	JLabel lblDesignationName;

	JLabel lblDesignationUpdate;
	JComboBox cmbDesignationUpdate;
	JComboBox cmbCombo1;

	JTextField txtDesignationID;
	JTextField txtDesignationName;

	int Rcols;
	ReportTool tool;

	ButtonState bst;
	clsButtonManagement cbm;

	frmDesignation()
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
		UISetting.setArea(pnlUI,600,250);

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

		lblDesignationUpdate = myUI.getCombo1Label();

		pnlDesignationUpdate = myUI.getCombo1Panel();
		cmbDesignationUpdate = myUI.getCombo1();
		cmbDesignationUpdate.addActionListener(this);

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
		lblProgramHeading.setText("Designation Information");
		new BlinkLabel(lblProgramHeading,800).start();

		lblDesignationID = new JLabel("Designation ID : ");
		lblDesignationID.setLayout(null);
		lblDesignationID.setBounds(70,40,150,50);
		lblDesignationID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblDesignationID);

		txtDesignationID = new JTextField();
		txtDesignationID.setLayout(null);
		txtDesignationID.setBounds(310,40,200,50);
		txtDesignationID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtDesignationID);

		lblDesignationName = new JLabel("Designation Name : ");
		lblDesignationName.setLayout(null);
		lblDesignationName.setBounds(70,110,200,50);
		lblDesignationName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblDesignationName);

		txtDesignationName = new JTextField();
		txtDesignationName.setLayout(null);
		txtDesignationName.setBounds(310,110,200,50);
		txtDesignationName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtDesignationName);

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
		//cbm.manageCombo1Label(lblDesignationUpdate);
		cbm.managelblCombo1Panel(lblDesignationUpdate);
		cbm.manageCombo1Panel(pnlDesignationUpdate);
		cbm.manageCombo1(cmbDesignationUpdate);
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
		txtDesignationID.setText("0");
		txtDesignationName.setText("");
		txtDesignationName.requestFocus();
	}

	clsDesignation readUI()
	{
		clsDesignation temp = new clsDesignation();
		temp.setDesignationID(Integer.parseInt(txtDesignationID.getText()));
		temp.setDesignationName(txtDesignationName.getText());
		return(temp);
	}

	void writeUI(clsDesignation temp)
	{
		txtDesignationID.setText(String.valueOf(temp.getDesignationID()));
		txtDesignationName.setText(temp.getDesignationName());
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
		Rcols+=tool.addNewColumn("DesignationID");
		Rcols+=tool.addNewColumn("DesignationName");
	}

	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth()
	{
		tool.setColumnWidth("DesignationID",80);
		tool.setColumnWidth("DesignationName",200);
	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsDesignation Data[]=clsDesignation.getAllDesignationInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getDesignationName();

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
			addDesignationRecords(cmbDesignationUpdate);
		}
		else if(ae.getSource() == btnSave)
		{
			clsDesignation temp = readUI();
			clsDesignation.showDesignation(temp);
			clsDesignation.addNewDesignation(temp);
			JOptionPane.showMessageDialog(null,"Designation Added Successfully....!");

			/*if(clsDesignation.isDesignationDulplicate(temp.getDesignationName()))
			{
				JOptionPane.showMessageDialog(null,"Entered Designation Already Exist......! ");
			}
			else
			{
				bst.setButtonState(ButtonState.SaveState);
				cbm.showButtonsOnUI(bst);

			}*/
		}
		else if(ae.getSource() == btnApply)
		{
			if(cmbDesignationUpdate.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Designation Property....!");
			}
			else
			{
				String mDesignationName = (String)cmbDesignationUpdate.getSelectedItem();
				int mDesignationID = clsDesignation.getIDFromName(mDesignationName);
				clsDesignation temp=clsDesignation.getDesignationInformation(mDesignationID);
				clsDesignation.showDesignation(temp);
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

			clsDesignation temp = readUI();
			clsDesignation.updateDesignation(temp);
			PanelState.disabledComponents(pnlUI);
			JOptionPane.showMessageDialog(null,"Designation Updated Successfully....!");
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsDesignation temp = readUI();
			clsDesignation.deleteDesignation(temp);
			JOptionPane.showMessageDialog(null,"Designation Deleted Successfully....!");
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

	void addDesignationRecords(JComboBox temp)
	{
		clsDesignation.addDesignationRecords(temp);
	}


	public static void main(String args[])
	{
		frmDesignation F = new frmDesignation();
	}
}