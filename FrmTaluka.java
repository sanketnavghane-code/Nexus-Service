import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;

class FrmTaluka extends JFrame implements ActionListener
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

	JLabel lblProgramHeading;

	JLabel lblTalukaID;
	JTextField txtTalukaID;

	JLabel lblTalukaName;
	JTextField txtTalukaName;

	JComboBox cmbCountry;
	JLabel lblCountryName;

	JComboBox cmbState;
	JLabel lblStateName;

	JComboBox cmbDistrict;
	JLabel lblDistrictName;

	JButton btnNewDoc;
	JButton btnRefreshDoc;

	int vCountryID;
	int vStateID;
	int vDistrictID;

	ScreenDesign4 myUI;

	ButtonState bst;
	clsButtonManagement4 cbm;

	FrmTaluka()
	{
		setSize(1950,1200);
		setLocation(1,1);
		setLayout(null);
		setBackground(ColorSetting.getBackColorFrame());
		setTitle("Form Designing");
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );
		myUI = new ScreenDesign4();
		add(myUI);

		pnlUI = myUI.getUIPanel();
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,500,410);

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

		pnlView = myUI.getViewPanel();
		btnView = myUI.getViewButton();
		btnView.addActionListener(this);

		pnlReport = myUI.getReportPanel();
		btnReport = myUI.getReportButton();
		btnReport.addActionListener(this);

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
		new BlinkLabel(lblProgramHeading,800).start();

		lblTalukaID = new JLabel("Taluka ID : ");
		lblTalukaID.setBounds(70,40,200,50);
		lblTalukaID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblTalukaID);

		txtTalukaID = new JTextField();
		txtTalukaID.setBounds(230,40,200,50);
		txtTalukaID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtTalukaID);

		lblTalukaName = new JLabel("Taluka Name : ");
		lblTalukaName.setBounds(70,110,200,50);
		lblTalukaName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblTalukaName);

		txtTalukaName = new JTextField();
		txtTalukaName.setBounds(230,110,200,50);
		txtTalukaName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtTalukaName);

		lblCountryName = new JLabel("Country : ");
		lblCountryName.setBounds(70,180,200,50);
		lblCountryName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblCountryName);

		cmbCountry = new JComboBox();
		cmbCountry.setBounds(230,180,200,50);
		cmbCountry.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbCountry);

		lblStateName = new JLabel("State : ");
		lblStateName.setLayout(null);
		lblStateName.setBounds(70,250,200,50);
		lblStateName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblStateName);

		cmbState = new JComboBox();
		cmbState.setBounds(230,250,200,50);
		cmbState.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbState);

		lblDistrictName = new JLabel("District : ");
		lblDistrictName.setLayout(null);
		lblDistrictName.setBounds(70,320,200,50);
		lblDistrictName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblDistrictName);

		cmbDistrict = new JComboBox();
		cmbDistrict.setBounds(230,320,200,50);
		cmbDistrict.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbDistrict);

		ImageIcon imgIcon = new ImageIcon("imagesrc\\imgNewDoc.png");
		Image image = imgIcon.getImage();
		Image newimage = image.getScaledInstance(48,45,java.awt.Image.SCALE_SMOOTH);
		Icon imgNewDoc = new ImageIcon(newimage);
		btnNewDoc = new JButton(imgNewDoc);
		btnNewDoc.setBounds(436,320,43,50);
		btnNewDoc.addActionListener(this);
		btnNewDoc.setBackground(Color.WHITE);
		pnlUI.add(btnNewDoc);

		ImageIcon imgIcon2 = new ImageIcon("imagesrc\\imgRefreshDoc.png");
		Image image2 = imgIcon2.getImage();
		Image refreshimage2 = image2.getScaledInstance(48,45,java.awt.Image.SCALE_SMOOTH);
		Icon imgRefreshDoc = new ImageIcon(refreshimage2);
		btnRefreshDoc = new JButton(imgRefreshDoc);
		btnRefreshDoc.setBounds(436,320,43,50);
		btnRefreshDoc.setBackground(Color.WHITE);
		btnRefreshDoc.addActionListener(this);
		pnlUI.add(btnRefreshDoc);


		//setDefaultOperation();

		bst = new ButtonState();
		cbm = new clsButtonManagement4();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);
		addCountryRecords(cmbCountry);
		show();

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
		txtTalukaID.setText("0");

		txtTalukaName.setText("");
		txtTalukaName.requestFocus();
		cmbCountry.setSelectedIndex(0);
		cmbState.removeAllItems();
		cmbDistrict.removeAllItems();

	}

	clsTaluka readUI()
	{
		clsTaluka temp = new clsTaluka();
		temp.setTalukaID(Integer.parseInt(txtTalukaID.getText()));
		temp.setTalukaName(txtTalukaName.getText());
		temp.setCountryID(vCountryID);
		temp.setStateID(vStateID);
		temp.setDistrictID(vDistrictID);
		return(temp);
	}

	void writeUI(clsTaluka temp)
	{
		txtTalukaID.setText(String.valueOf(temp.getTalukaID()));
		txtTalukaName.setText(temp.getTalukaName());

		clsLocationManagement4 temp1 = clsLocationManagement4.getLocationInfo(temp.getTalukaID());
		int mCountryID=temp1.getCountryID();
		int mStateID=temp1.getStateID();
		int mDistrictID=temp1.getDistrictID();
		cmbCountry.setSelectedItem(temp1.getCountryName());
		addStateRecords(cmbState,mCountryID);
		cmbState.setSelectedItem(temp1.getStateName());
		addDistrictRecords(cmbDistrict,mStateID);
		cmbDistrict.setSelectedItem(temp1.getDistrictName());
	}

	void addCountryRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsCountry.addCountryRecords(temp);
		temp.addActionListener(this);
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
			bst.setButtonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
		}
		else if(ae.getSource() == btnSave)
		{
			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);

			clsTaluka temp = readUI();
			clsTaluka.addNewTaluka(temp);
		}
		else if(ae.getSource() == btnApply)
		{
			if(cmbCountryUpdate.getSelectedIndex() == 0 || cmbStateUpdate.getSelectedIndex() == 0 || cmbDistrictUpdate.getSelectedIndex() == 0 || cmbTalukaUpdate.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Country or State or or District or Taluka Property....!");
			}
			else
			{
				String mTalukaName = (String)cmbTalukaUpdate.getSelectedItem();
				int mTalukaID = clsTaluka.getIDFromName(mTalukaName);
				clsTaluka temp = clsTaluka.getTalukaInformation(mTalukaID);
				clsTaluka.showTaluka(temp);
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
			clsTaluka temp = readUI();
			clsTaluka.updateTaluka(temp);
			PanelState.disabledComponents(pnlUI);
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsTaluka temp = readUI();
			clsTaluka.deleteTaluka(temp);
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
		else if(ae.getSource()==btnNewDoc)
		{
			btnNewDoc.setVisible(false);
			btnRefreshDoc.setVisible(true);

			FrmDistrict A =	new FrmDistrict();


		}
		else if(ae.getSource()==btnRefreshDoc)
		{
			btnNewDoc.setVisible(true);
			btnRefreshDoc.setVisible(false);

			addDistrictRecords(cmbDistrict);
		}

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

	public static void main(String args[])
	{
		new FrmTaluka();
	}
}