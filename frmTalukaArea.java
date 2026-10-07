import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class frmTalukaArea extends JFrame implements ActionListener
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

	JPanel pnlTalukaUpdate;
	JLabel lblTalukaUpdate;
	JComboBox cmbTalukaUpdate;

	JPanel pnlTalukaAreaUpdate;
	JLabel lblTalukaAreaUpdate;
	JComboBox cmbTalukaAreaUpdate;

	JLabel lblProgramHeading;

	JLabel lblTalukaAreaID;
	JTextField txtTalukaAreaID;

	JLabel lblTalukaAreaName;
	JTextField txtTalukaAreaName;

	JComboBox cmbCountry;
	JLabel lblCountryName;

	JComboBox cmbState;
	JLabel lblStateName;

	JComboBox cmbDistrict;
	JLabel lblDistrictName;

	JComboBox cmbTaluka;
	JLabel lblTalukaName;

	JButton btnNewDoc;
	JButton btnRefreshDoc;

	int Rcols;
	ReportTool tool;


	int vCountryID;
	int vStateID;
	int vDistrictID;
	int vTalukaID;

	ScreenDesign5 myUI;


	ButtonState bst;
	clsButtonManagement5 cbm;

	frmTalukaArea()
	{
		setSize(1950,1200);
		setLocation(1,1);
		setLayout(null);
		setBackground(ColorSetting.getBackColorFrame());
		setTitle("Form Designing");
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );
		myUI = new ScreenDesign5();
		add(myUI);


		pnlUI = myUI.getUIPanel();
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,500,410);

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

		pnlTalukaUpdate = myUI.getCombo4Panel();
		lblTalukaUpdate = myUI.getCombo4Label();
		lblTalukaUpdate.setText("Taluka List!!!");
		cmbTalukaUpdate = myUI.getCombo4ComboBox();
		cmbTalukaUpdate.addActionListener(this);

		pnlTalukaAreaUpdate = myUI.getCombo5Panel();
		lblTalukaAreaUpdate = myUI.getCombo5Label();
		lblTalukaAreaUpdate.setText("Taluka Area List!!!");
		cmbTalukaAreaUpdate = myUI.getCombo5ComboBox();
		cmbTalukaAreaUpdate.addActionListener(this);

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
		btnDelete.addActionListener(this);

		pnlUpdate = myUI.getUpdatePanel();
		btnUpdate = myUI.getUpdateButton();
		btnUpdate.addActionListener(this);

		pnlUIReport = myUI.getUIReportPanel();

		lblProgramHeading = myUI.getProgramHeadingLabel();
		lblProgramHeading.setText("Taluka Area Information");
		new BlinkLabel(lblProgramHeading,800).start();

		int y=40,gap=10,h=30;

		lblTalukaAreaID = new JLabel("Taluka Area ID : ");
		lblTalukaAreaID.setBounds(50,y,200,h);
		lblTalukaAreaID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblTalukaAreaID);

		txtTalukaAreaID = new JTextField();
		txtTalukaAreaID.setBounds(230,y,200,h);
		txtTalukaAreaID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtTalukaAreaID);

		y=y+h+gap;

		lblTalukaAreaName = new JLabel("Taluka Area Name : ");
		lblTalukaAreaName.setBounds(50,y,200,h);
		lblTalukaAreaName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblTalukaAreaName);

		txtTalukaAreaName = new JTextField();
		txtTalukaAreaName.setBounds(230,y,200,h);
		txtTalukaAreaName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtTalukaAreaName);

		y=y+h+gap;

		lblCountryName = new JLabel("Country : ");
		lblCountryName.setBounds(50,y,200,h);
		lblCountryName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblCountryName);

		cmbCountry = new JComboBox();
		cmbCountry.setBounds(230,y,200,h);
		cmbCountry.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbCountry);

		y=y+h+gap;

		lblStateName = new JLabel("State : ");
		lblStateName.setLayout(null);
		lblStateName.setBounds(50,y,200,h);
		lblStateName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblStateName);

		cmbState = new JComboBox();
		cmbState.setBounds(230,y,200,h);
		cmbState.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbState);

		y=y+h+gap;


		lblDistrictName = new JLabel("District : ");
		lblDistrictName.setLayout(null);
		lblDistrictName.setBounds(50,y,200,h);
		lblDistrictName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblDistrictName);

		cmbDistrict = new JComboBox();
		cmbDistrict.setBounds(230,y,200,h);
		cmbDistrict.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbDistrict);

		y=y+h+gap;

		lblTalukaName = new JLabel("Taluka : ");
		lblTalukaName.setLayout(null);
		lblTalukaName.setBounds(50,y,200,h);
		lblTalukaName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblTalukaName);

		cmbTaluka = new JComboBox();
		cmbTaluka.setBounds(230,y,200,h);
		cmbTaluka.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbTaluka);

		ImageIcon imgIcon = new ImageIcon("imagesrc\\imgNewDoc.png");
		Image image = imgIcon.getImage();
		Image newimage = image.getScaledInstance(48,45,java.awt.Image.SCALE_SMOOTH);
		Icon imgNewDoc = new ImageIcon(newimage);
		btnNewDoc = new JButton(imgNewDoc);
		btnNewDoc.setBounds(436,y,43,h);
		btnNewDoc.addActionListener(this);
		btnNewDoc.setBackground(Color.WHITE);
		pnlUI.add(btnNewDoc);

		ImageIcon imgIcon2 = new ImageIcon("imagesrc\\imgRefreshDoc.png");
		Image image2 = imgIcon2.getImage();
		Image refreshimage2 = image2.getScaledInstance(48,45,java.awt.Image.SCALE_SMOOTH);
		Icon imgRefreshDoc = new ImageIcon(refreshimage2);
		btnRefreshDoc = new JButton(imgRefreshDoc);

		btnRefreshDoc.setBounds(436,y,43,h);
		btnRefreshDoc.setBackground(Color.WHITE);
		btnRefreshDoc.addActionListener(this);
		pnlUI.add(btnRefreshDoc);


		//setDefaultOperation();

		bst = new ButtonState();
		cbm = new clsButtonManagement5();
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
		cbm.manageCombo4Panel(pnlTalukaUpdate);
		cbm.manageCombo4Label(lblTalukaUpdate);
		cbm.manageCombo4(cmbTalukaUpdate);
		cbm.manageCombo5Panel(pnlTalukaAreaUpdate);
		cbm.manageCombo5Label(lblTalukaAreaUpdate);
		cbm.manageCombo5(cmbTalukaAreaUpdate);


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
		txtTalukaAreaID.setText("0");

		txtTalukaAreaName.setText("");
		txtTalukaAreaName.requestFocus();
		cmbCountry.setSelectedIndex(0);
		cmbState.removeAllItems();
		cmbDistrict.removeAllItems();
		cmbTaluka.removeAllItems();

	}

	clsTalukaArea readUI()
	{
		clsTalukaArea temp = new clsTalukaArea();
		temp.setTalukaAreaID(Integer.parseInt(txtTalukaAreaID.getText()));
		temp.setTalukaAreaName(txtTalukaAreaName.getText());
		temp.setTalukaID(vTalukaID);
		return(temp);
	}

	void writeUI(clsTalukaArea temp)
	{
		txtTalukaAreaID.setText(String.valueOf(temp.getTalukaAreaID()));
		txtTalukaAreaName.setText(temp.getTalukaAreaName());

		clsLocationManagementTalukaArea temp1 = clsLocationManagementTalukaArea.getLocationInfo(temp.getTalukaAreaID());

		vTalukaID=temp1.getTalukaID();
		cmbCountry.setSelectedItem(temp1.getCountryName());
		cmbState.setSelectedItem(temp1.getStateName());
		cmbDistrict.setSelectedItem(temp1.getDistrictName());
		cmbTaluka.setSelectedItem(temp1.getTalukaName());
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
		Rcols+=tool.addNewColumn("TalukaAreaID");
		Rcols+=tool.addNewColumn("TalukaAreaName");
		Rcols+=tool.addNewColumn("TalukaID");

	}

	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);

	}

	void setColumnsWidth()
	{
		tool.setColumnWidth("TalukaAreaID",80);
		tool.setColumnWidth("TalukaAreaName",200);
		tool.setColumnWidth("TalukaID",200);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsTalukaArea Data[]=clsTalukaArea.getAllTalukaAreaInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getTalukaAreaName();
			Objectdata[2]=Data[i].getTalukaID();


			tool.addNewRow(Objectdata);
		}
	}

	void addStateRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsState.addStateRecords(temp);
		temp.addActionListener(this);
	}

	void addDistrictRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsDistrict.addDistrictRecords(temp);
		temp.addActionListener(this);
	}

	void addTalukaRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsTaluka.addTalukaRecords(temp);
		temp.addActionListener(this);
	}

	void addTalukaAreaRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsTalukaArea.addTalukaAreaRecords(temp);
		temp.addActionListener(this);
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
		else if(ae.getSource() == btnReport)
		{
			bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
			setColumnsData();
		}

		else if(ae.getSource() == btnClose)
		{
			bst.setButtonCommonState(ButtonState.CloseReportState);
			cbm.showButtonsOnUI(bst);
			setColumnsData();
		}
		else if(ae.getSource() == btnSave)
		{
			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);

			clsTalukaArea temp = readUI();
			clsTalukaArea.addNewTalukaArea(temp);
		}
		else if(ae.getSource() == btnApply)
		{
			if(cmbCountryUpdate.getSelectedIndex() == 0 || cmbStateUpdate.getSelectedIndex() == 0 || cmbDistrictUpdate.getSelectedIndex() == 0 ||
			cmbTalukaUpdate.getSelectedIndex() == 0 || cmbTalukaAreaUpdate.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Country or State or or District or Taluka or Taluka Area Property....!");
			}
			else
			{
				String mTalukaAreaName = (String)cmbTalukaAreaUpdate.getSelectedItem();
				int mTalukaAreaID = clsTalukaArea.getIDFromName(mTalukaAreaName);
				clsTalukaArea temp = clsTalukaArea.getTalukaAreaInformation(mTalukaAreaID);
				clsTalukaArea.showTalukaArea(temp);
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
			clsTalukaArea temp = readUI();
			clsTalukaArea.updateTalukaArea(temp);
			PanelState.disabledComponents(pnlUI);
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsTalukaArea temp = readUI();
			clsTalukaArea.deleteTalukaArea(temp);
		}
		else if(ae.getSource() == btnCancel)
		{
			bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);
		}
		else if(ae.getSource() == cmbCountry)
		{
			if(cmbCountry.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Country Properly...");
			}
			else
			{
				String mCountryName = (String)cmbCountry.getSelectedItem();
				vCountryID = clsCountry.getIDFromName(mCountryName);
				addStateRecords(cmbState,vCountryID);
			}
		}
		else if(ae.getSource() == cmbState)
		{
			if(cmbState.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Country Properly...");
			}
			else
			{
				String mStateName = (String)cmbState.getSelectedItem();
				vStateID = clsState.getIDFromName(mStateName);
				addDistrictRecords(cmbDistrict,vStateID);
			}
		}
		else if(ae.getSource() == cmbDistrict)
		{
			if(cmbDistrict.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select District Properly...");
			}
			else
			{
				String mDistrictName = (String)cmbDistrict.getSelectedItem();
				vDistrictID = clsDistrict.getIDFromName(mDistrictName);
				addTalukaRecords(cmbTaluka,vDistrictID);
			}
		}
		else if(ae.getSource() == cmbTaluka)
		{
			if(cmbTaluka.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Taluka Properly...");
			}
			else
			{
				String mTalukaName = (String)cmbTaluka.getSelectedItem();
				vTalukaID = clsTaluka.getIDFromName(mTalukaName);
				//clsTalukaArea.addTalukaAreaRecords(cmbTaluka,vTalukaID);
			}
		}
		else if(ae.getSource() == cmbCountryUpdate)
		{
			if(cmbCountryUpdate.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Country Properly...");
			}
			else
			{
				String mCountryName = (String)cmbCountryUpdate.getSelectedItem();
				int mCountryID = clsCountry.getIDFromName(mCountryName);
				addStateRecords(cmbStateUpdate,mCountryID);
			}
		}
		else if(ae.getSource() == cmbStateUpdate)
		{
			if(cmbStateUpdate.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Country Properly...");
			}
			else
			{
				String mStateName = (String)cmbStateUpdate.getSelectedItem();
				int mStateID = clsState.getIDFromName(mStateName);
				addDistrictRecords(cmbDistrictUpdate,mStateID);
			}
		}
		else if(ae.getSource() == cmbDistrictUpdate)
		{
			if(cmbDistrictUpdate.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select District Properly...");
			}
			else
			{
				String mDistrict = (String)cmbDistrictUpdate.getSelectedItem();
				int mDistrictID = clsDistrict.getIDFromName(mDistrict);
				addTalukaRecords(cmbTalukaUpdate,mDistrictID);
			}
		}

		else if(ae.getSource() == cmbTalukaUpdate)
		{
			if(cmbTalukaUpdate.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select District Properly...");
			}
			else
			{
				String mTaluka = (String)cmbTalukaUpdate.getSelectedItem();
				int mTalukaID = clsTaluka.getIDFromName(mTaluka);
				addTalukaAreaRecords(cmbTalukaAreaUpdate,mTalukaID);
			}
		}
		else if(ae.getSource()==btnNewDoc)
		{
			btnNewDoc.setVisible(false);
			btnRefreshDoc.setVisible(true);
		}
		else if(ae.getSource()==btnRefreshDoc)
		{
			btnNewDoc.setVisible(true);
			btnRefreshDoc.setVisible(false);

			addDistrictRecords(cmbDistrict);
		}

	}

	void addCountryRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsCountry.addCountryRecords(temp);
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
		temp.removeActionListener(this);
		clsDistrict.addDistrictRecords(temp,mStateID);
		temp.addActionListener(this);
	}

	void addTalukaRecords(JComboBox temp, int mDistrictID)
	{
		temp.removeActionListener(this);
		clsTaluka.addTalukaRecords(temp,mDistrictID);
		temp.addActionListener(this);
	}

	void addTalukaAreaRecords(JComboBox temp, int mTalukaID)
	{
		temp.removeActionListener(this);
		clsTalukaArea.addTalukaAreaRecords(temp,mTalukaID);
		temp.addActionListener(this);
	}

	public static void main(String args[])
	{
		new frmTalukaArea();
	}
}