import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class FrmCountry extends JFrame implements ActionListener
{
	JPanel pnlUI;
	JPanel pnlUIReport;
	JPanel pnlCountryUpdate;

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

	JLabel lblCountryID ;
	JLabel lblCountryName;

	JLabel lblCountryUpdate;
	JComboBox cmbCountryUpdate;
	JComboBox cmbCombo1;

	JTextField txtCountryID;
	JTextField txtCountryName;

	int Rcols;
	ReportTool tool;

	ButtonState bst;
	clsButtonManagement cbm;

	FrmCountry()
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
		UISetting.setArea(pnlUI,500,200);

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

		lblCountryUpdate = myUI.getCombo1Label();

		pnlCountryUpdate = myUI.getCombo1Panel();
		cmbCountryUpdate = myUI.getCombo1();
		cmbCountryUpdate.addActionListener(this);

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

		lblCountryID = new JLabel("Country ID : ");
		lblCountryID.setLayout(null);
		lblCountryID.setBounds(70,40,130,50);
		lblCountryID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblCountryID);

		txtCountryID = new JTextField();
		txtCountryID.setLayout(null);
		txtCountryID.setBounds(230,40,200,50);
		txtCountryID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtCountryID);

		lblCountryName = new JLabel("Country Name : ");
		lblCountryName.setLayout(null);
		lblCountryName.setBounds(70,110,200,50);
		lblCountryName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblCountryName);

		txtCountryName = new JTextField();
		txtCountryName.setLayout(null);
		txtCountryName.setBounds(230,110,200,50);
		txtCountryName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtCountryName);

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
		cbm.managelblCombo1Panel(lblCountryUpdate);
		cbm.manageCombo1Panel(pnlCountryUpdate);
		cbm.manageCombo1(cmbCountryUpdate);
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
		txtCountryID.setText("0");
		txtCountryName.setText("");
		txtCountryName.requestFocus();
	}

	clsCountry readUI()
	{
		clsCountry temp = new clsCountry();
		temp.setCountryID(Integer.parseInt(txtCountryID.getText()));
		temp.setCountryName(txtCountryName.getText());
		return(temp);
	}

	void writeUI(clsCountry temp)
	{
		txtCountryID.setText(String.valueOf(temp.getCountryID()));
		txtCountryName.setText(temp.getCountryName());
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
			addCountryRecords(cmbCountryUpdate);
		}
		else if(ae.getSource() == btnSave)
		{
			clsCountry temp = readUI();
			clsCountry.showCountry(temp);

			if(clsCountry.isCountryDulplicate(temp.getCountryName()))
			{
				JOptionPane.showMessageDialog(null,"Entered Country Already Exist......! ");
			}
			else
			{
				bst.setButtonState(ButtonState.SaveState);
				cbm.showButtonsOnUI(bst);
				clsCountry.addNewCountry(temp);
				JOptionPane.showMessageDialog(null,"Country Added Successfully....!");
			}
		}
		else if(ae.getSource() == btnApply)
		{
			if(cmbCountryUpdate.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Country Property....!");
			}
			else
			{
				String mCountryName = (String)cmbCountryUpdate.getSelectedItem();
				int mCountryID = clsCountry.getIDFromName(mCountryName);
				clsCountry temp=clsCountry.getCountryInformation(mCountryID);
				clsCountry.showCountry(temp);
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

			clsCountry temp = readUI();
			clsCountry.updateCountry(temp);
			PanelState.disabledComponents(pnlUI);
			JOptionPane.showMessageDialog(null,"Country Updated Successfully....!");
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsCountry temp = readUI();
			clsCountry.deleteCountry(temp);
			JOptionPane.showMessageDialog(null,"Country Deleted Successfully....!");
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

	void addCountryRecords(JComboBox temp)
	{
		clsCountry.addCountryRecords(temp);
	}


	public static void main(String args[])
	{
		FrmCountry F = new FrmCountry();
	}
}