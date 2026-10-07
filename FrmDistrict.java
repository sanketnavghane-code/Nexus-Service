import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class FrmDistrict extends JFrame implements ActionListener
{
	JPanel pnlUI;
	JPanel pnlUIReport;

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

	JPanel pnlCountryUpdate;
	JComboBox cmbCountryUpdate;
	JLabel lblCountryUpdate;

	JPanel pnlStateUpdate;
	JLabel lblStateUpdate;
	JComboBox cmbStateUpdate;

	JPanel pnlDistrictUpdate;
	JLabel lblDistrictUpdate;
	JComboBox cmbDistrictUpdate;

	JLabel lblProgramHeading;

	JLabel lblDistrictID;
	JTextField txtDistrictID;

	JLabel lblDistrictName;
	JTextField txtDistrictName;

	JComboBox cmbCountry;
	JLabel lblCountryName;

	JComboBox cmbState;
	JLabel lblStateName;

	JButton btnNewDoc;
	JButton btnRefreshDoc;

	int Rcols;
	ReportTool tool;

	int vCountryID=0;
	int vStateID;

	ScreenDesign3 myUI;

	ButtonState bst;
	clsButtonManagement3 cbm;

	FrmDistrict()
	{
		setSize(1950,1200);
		setLocation(1,1);
		setLayout(null);
		setBackground(ColorSetting.getBackColorFrame());
		setTitle("Form Designing");
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );
		myUI = new ScreenDesign3();
		add(myUI);

		pnlUIReport = myUI.getUIReportPanel();
		tool = new ReportTool(500,500);
		tool.setBounds(10,10,500,300);
		pnlUIReport.add(tool);
		UISetting.setArea(pnlUIReport,520,460);

		pnlUI = myUI.getUIPanel();
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,500,340);

		pnlNew = myUI.getNewPanel();
		btnNew = myUI.getNewButton();
		btnNew.addActionListener(this);

		pnlSave = myUI.getSavePanel();
		btnSave = myUI.getSaveButton();
		btnSave.addActionListener(this);

		pnlCancel = myUI.getCancelPanel();
		btnCancel = myUI.getCancelButton();
		btnCancel.addActionListener(this);

		pnlCountryUpdate = myUI.getCombo1Panel();
		lblCountryUpdate = myUI.getCombo1Label();
		lblCountryUpdate.setText("Country List!!!");
		cmbCountryUpdate = myUI.getCombo1ComboBox();
		cmbCountryUpdate.addActionListener(this);


		pnlStateUpdate = myUI.getCombo2Panel();
		lblStateUpdate = myUI.getCombo2Label();
		lblStateUpdate.setText("State List!!!");
		cmbStateUpdate = myUI.getCombo2ComboBox();

		cmbStateUpdate.addActionListener(this);

		pnlDistrictUpdate = myUI.getCombo3Panel();
		lblDistrictUpdate = myUI.getCombo3Label();
		lblDistrictUpdate.setText("District List!!!");
		cmbDistrictUpdate = myUI.getCombo3ComboBox();
		cmbDistrictUpdate.addActionListener(this);

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
		new BlinkLabel(lblProgramHeading,800).start();

		lblDistrictID = new JLabel("District ID : ");
		lblDistrictID.setLayout(null);
		lblDistrictID.setBounds(70,40,200,50);
		lblDistrictID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblDistrictID);

		txtDistrictID = new JTextField();
		txtDistrictID.setLayout(null);
		txtDistrictID.setBounds(230,40,200,50);
		txtDistrictID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtDistrictID);

		lblDistrictName = new JLabel("District Name : ");
		lblDistrictName.setLayout(null);
		lblDistrictName.setBounds(70,110,200,50);
		lblDistrictName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblDistrictName);

		txtDistrictName = new JTextField();
		txtDistrictName.setLayout(null);
		txtDistrictName.setBounds(230,110,200,50);
		txtDistrictName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtDistrictName);

		lblCountryName = new JLabel("Country : ");
		lblCountryName.setLayout(null);
		lblCountryName.setBounds(70,180,200,50);
		lblCountryName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblCountryName);

		lblStateName = new JLabel("State : ");
		lblStateName.setLayout(null);
		lblStateName.setBounds(70,250,200,50);
		lblStateName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblStateName);

		cmbCountry = new JComboBox();
		cmbCountry.setBounds(230,180,200,50);
		cmbCountry.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbCountry);

		cmbState = new JComboBox();
		cmbState.setBounds(230,250,200,50);
		cmbState.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbState);

		ImageIcon imgIcon = new ImageIcon("imagesrc\\imgNewDoc.png");
		Image image = imgIcon.getImage();
		Image newimage = image.getScaledInstance(48,45,java.awt.Image.SCALE_SMOOTH);
		Icon imgNewDoc = new ImageIcon(newimage);
		btnNewDoc = new JButton(imgNewDoc);
		btnNewDoc.setBounds(436,250,43,50);
		btnNewDoc.addActionListener(this);
		btnNewDoc.setBackground(Color.WHITE);
		pnlUI.add(btnNewDoc);

		ImageIcon imgIcon2 = new ImageIcon("imagesrc\\imgRefreshDoc.png");
		Image image2 = imgIcon2.getImage();
		Image refreshimage2 = image2.getScaledInstance(48,45,java.awt.Image.SCALE_SMOOTH);
		Icon imgRefreshDoc = new ImageIcon(refreshimage2);
		btnRefreshDoc = new JButton(imgRefreshDoc);
		btnRefreshDoc.setBounds(436,250,43,50);
		btnRefreshDoc.setBackground(Color.WHITE);
		btnRefreshDoc.addActionListener(this);
		pnlUI.add(btnRefreshDoc);

		//setDefaultOperation();

		bst = new ButtonState();
		cbm = new clsButtonManagement3();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);
		addCountryRecords(cmbCountry);
		show();

		createReport();


	}

	void automateButtons()
	{
		cbm.manageNewPanel(pnlNew);
		cbm.manageViewPanel(pnlView);
		cbm.manageUIPanel(pnlUI);
		cbm.manageUIReportPanel(pnlUIReport);
		cbm.manageSavePanel(pnlSave);
		cbm.manageViewPanel(pnlView);
		cbm.manageEditPanel(pnlEdit);
		cbm.manageUpdatePanel(pnlUpdate);
		cbm.manageDeletePanel(pnlDelete);
		cbm.manageCancelPanel(pnlCancel);
		cbm.manageReportPanel(pnlReport);
		cbm.manageClosePanel(pnlClose);
		cbm.manageApplyPanel(pnlApply);
		cbm.manageCombo1Panel(pnlCountryUpdate);
		cbm.manageCombo1Label(lblCountryUpdate);
		cbm.manageCombo1(cmbCountryUpdate);
		cbm.manageCombo2Panel(pnlStateUpdate);
		cbm.manageCombo2Label(lblStateUpdate);
		cbm.manageCombo2(cmbStateUpdate);
		cbm.manageCombo3Panel(pnlDistrictUpdate);
		cbm.manageCombo3Label(lblDistrictUpdate);
		cbm.manageCombo3(cmbDistrictUpdate);

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
		txtDistrictID.setText("0");
		txtDistrictName.setText("");
		txtDistrictName.requestFocus();
		cmbCountry.setSelectedIndex(0);
		cmbState.removeAllItems();
	}

	clsDistrict readUI()
	{
		clsDistrict temp = new clsDistrict();
		temp.setDistrictID(Integer.parseInt(txtDistrictID.getText()));
		temp.setDistrictName(txtDistrictName.getText());
		temp.setStateID(vStateID);
		return(temp);
	}

	void writeUI(clsDistrict temp)
	{
		txtDistrictID.setText(String.valueOf(temp.getDistrictID()));
		txtDistrictName.setText(temp.getDistrictName());

		clsLocationManagement3 temp1 = clsLocationManagement3.getLocationInfo(temp.getDistrictID());
		int mCountryID=temp1.getCountryID();
		int mStateID=temp1.getStateID();
		cmbCountry.setSelectedItem(temp1.getCountryName());
		addStateRecords(cmbState,mCountryID);
		cmbState.setSelectedItem(temp1.getStateName());
	}

	void addCountryRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsCountry.addCountryRecords(temp);
		temp.addActionListener(this);
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
		Rcols+=tool.addNewColumn("DistrictID");
		Rcols+=tool.addNewColumn("DistrictName");
		Rcols+=tool.addNewColumn("StateName");
	}

	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth()
	{
		tool.setColumnWidth("DistrictID",80);
		tool.setColumnWidth("DistrictName",200);
		tool.setColumnWidth("StateName",200);
	}

	void setColumnsData()
	{
		tool.removeAllRows();

		clsDistrictReport1 Data[]=clsDistrictReport1.getDistrictReport1Info();

		for(int i=0;i<Data.length;i++)
		{
				Object Objectdata[]=new Object[Rcols];

				Objectdata[0]=i+1;
				Objectdata[1]=Data[i].getDistrictName();
				Objectdata[2]=Data[i].getStateName();


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
		else if(ae.getSource() == btnSave)
		{
			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);

			clsDistrict temp = readUI();
			clsDistrict.addNewDistrict(temp);
		}
		else if(ae.getSource() == btnApply)
		{
			if(cmbCountryUpdate.getSelectedIndex() == 0 || cmbStateUpdate.getSelectedIndex() == 0 || cmbDistrictUpdate.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Country or State or District Property....!");
			}
			else
			{
				String mDistrictName = (String)cmbDistrictUpdate.getSelectedItem();
				int mDistrictID = clsDistrict.getIDFromName(mDistrictName);
				clsDistrict temp = clsDistrict.getDistrictInformation(mDistrictID);
				clsDistrict.showDistrict(temp);
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
			clsDistrict temp = readUI();
			clsDistrict.updateDistrict(temp);
			PanelState.disabledComponents(pnlUI);
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsDistrict temp = readUI();
			clsDistrict.deleteDistrict(temp);
		}
		else if(ae.getSource() == btnCancel)
		{
			bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);
		}
		else if(ae.getSource() == cmbCountry)
		{
			if(cmbCountry.getSelectedIndex() != 0)
			{
				String mCountryName = (String)cmbCountry.getSelectedItem();
				vCountryID = clsCountry.getIDFromName(mCountryName);
				addStateRecords(cmbState,vCountryID);
			}
		}
		else if(ae.getSource() == cmbState)
		{
			if(cmbState.getSelectedIndex() != 0)
			{
				String mStateName = (String)cmbState.getSelectedItem();
				vStateID = clsState.getIDFromName(mStateName);
			}

		}
		else if(ae.getSource() == cmbCountryUpdate)
		{
			if(cmbCountryUpdate.getSelectedIndex() != 0)
			{
				String mCountryName = (String)cmbCountryUpdate.getSelectedItem();
				int mCountryID = clsCountry.getIDFromName(mCountryName);
				addStateRecords(cmbStateUpdate,mCountryID);
			}

		}
		else if(ae.getSource() == cmbStateUpdate)
		{
			if(cmbStateUpdate.getSelectedIndex() != 0)
			{
				String mStateName = (String)cmbStateUpdate.getSelectedItem();
				int mStateID = clsState.getIDFromName(mStateName);
				addDistrictRecords(cmbDistrictUpdate,mStateID);
			}

		}

		else if(ae.getSource()==btnNewDoc)
		{
			btnNewDoc.setVisible(false);
			btnRefreshDoc.setVisible(true);

			FrmState A =new FrmState();


		}
		else if(ae.getSource()==btnRefreshDoc)
		{
			btnNewDoc.setVisible(true);
			btnRefreshDoc.setVisible(false);

			addStateRecords(cmbState);
		}
	}
	void addStateRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsState.addStateRecords(temp);
		temp.addActionListener(this);
	}
	void addStateRecords(JComboBox temp, int mCountryID)
	{
		temp.removeActionListener(this);
		clsDistrict.addStateRecords(temp,mCountryID);
		temp.addActionListener(this);
	}

	void addDistrictRecords(JComboBox temp, int mStateID)
	{
		clsDistrict.addDistrictRecords(temp,mStateID);
	}

	public static void main(String args[])
	{
		new FrmDistrict();
	}
}