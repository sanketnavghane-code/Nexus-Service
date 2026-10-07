import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class FrmState extends JFrame implements ActionListener
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

	JComboBox cmbCountry;
	JComboBox lblCountry;

	JLabel lblProgramHeading;
	JLabel lblStateID ;
	JLabel lblStateName;
	JTextField txtStateID;
	JTextField txtStateName;

	JButton btnNewDoc;
	JButton btnRefreshDoc;

	int Rcols;
	ReportTool tool;

	int vCountryID=0;

	ScreenDesign2 myUI;

	ButtonState bst;
	clsButtonManagement2 cbm;


	FrmState()
	{

		setSize(1950,1200);
		setLocation(1,1);
		setLayout(null);
		setBackground(ColorSetting.getBackColorFrame());
		setTitle("Form Designing");
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );
		myUI = new ScreenDesign2();
		add(myUI);

		pnlUIReport = myUI.getUIReportPanel();
		tool = new ReportTool(500,500);
		tool.setBounds(10,10,500,300);
		pnlUIReport.add(tool);
		UISetting.setArea(pnlUIReport,520,460);

		pnlUI = myUI.getUIPanel();
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,500,270);

		pnlNew = myUI.getNewPanel();
		btnNew = myUI.getNewButton();
		btnNew.addActionListener(this);

		pnlSave = myUI.getSavePanel();
		btnSave = myUI.getSaveButton();
		btnSave.addActionListener(this);

		pnlCancel = myUI.getCancelPanel();
		btnCancel = myUI.getCancelButton();
		btnCancel.addActionListener(this);

		pnlReport = myUI.getReportPanel();
		btnReport = myUI.getReportButton();
		btnReport.addActionListener(this);

		pnlClose = myUI.getClosePanel();
		btnClose = myUI.getCloseButton();
		btnClose.addActionListener(this);

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
		btnDelete.addActionListener(this);

		pnlUpdate = myUI.getUpdatePanel();
		btnUpdate = myUI.getUpdateButton();
		btnUpdate.addActionListener(this);

		pnlUIReport = myUI.getUIReportPanel();

		lblProgramHeading = myUI.getProgramHeadingLabel();
		new BlinkLabel(lblProgramHeading,800).start();

		lblStateID = new JLabel("State ID : ");
		lblStateID.setLayout(null);
		lblStateID.setBounds(70,40,200,50);
		lblStateID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblStateID);

		txtStateID = new JTextField();
		txtStateID.setLayout(null);
		txtStateID.setBounds(230,40,200,50);
		txtStateID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtStateID);

		lblStateName = new JLabel("State Name : ");
		lblStateName.setLayout(null);
		lblStateName.setBounds(70,110,200,50);
		lblStateName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblStateName);

		txtStateName = new JTextField();
		txtStateName.setLayout(null);
		txtStateName.setBounds(230,110,200,50);
		txtStateName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtStateName);

		lblStateName = new JLabel("Country : ");
		lblStateName.setLayout(null);
		lblStateName.setBounds(70,180,200,50);
		lblStateName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblStateName);

		cmbCountry = new JComboBox();
		cmbCountry.setBounds(230,180,200,50);
		cmbCountry.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbCountry);

		ImageIcon imgIcon = new ImageIcon("imagesrc\\imgNewDoc.png");
		Image image = imgIcon.getImage();
		Image newimage = image.getScaledInstance(48,45,java.awt.Image.SCALE_SMOOTH);
		Icon imgNewDoc = new ImageIcon(newimage);
		btnNewDoc = new JButton(imgNewDoc);
		btnNewDoc.setBounds(436,180,43,50);
		btnNewDoc.addActionListener(this);
		btnNewDoc.setBackground(Color.WHITE);
		pnlUI.add(btnNewDoc);

		ImageIcon imgIcon2 = new ImageIcon("imagesrc\\imgRefreshDoc.png");
		Image image2 = imgIcon2.getImage();
		Image refreshimage2 = image2.getScaledInstance(48,45,java.awt.Image.SCALE_SMOOTH);
		Icon imgRefreshDoc = new ImageIcon(refreshimage2);
		btnRefreshDoc = new JButton(imgRefreshDoc);
		btnRefreshDoc.setBounds(436,180,43,50);
		btnRefreshDoc.setBackground(Color.WHITE);
		btnRefreshDoc.addActionListener(this);
		pnlUI.add(btnRefreshDoc);


		//setDefaultOperation();

		bst = new ButtonState();
		cbm = new clsButtonManagement2();
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
		cbm.manageClosePanel(pnlClose);
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
		cbm.manageCombo1Panel(pnlCountryUpdate);
		cbm.manageCombo1Label(lblCountryUpdate);
		cbm.manageCombo1(cmbCountryUpdate);
		cbm.manageCombo2Panel(pnlStateUpdate);
		cbm.manageCombo2Label(lblStateUpdate);
		cbm.manageCombo2(cmbStateUpdate);

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
		txtStateID.setText("0");
		txtStateName.setText("");
		txtStateName.requestFocus();
		cmbCountry.setSelectedIndex(0);
	}

	clsState readUI()
	{
		clsState temp = new clsState();
		temp.setStateID(Integer.parseInt(txtStateID.getText()));
		temp.setStateName(txtStateName.getText());
		temp.setCountryID(vCountryID);
		return(temp);
	}

	void writeUI(clsState temp)
	{
		txtStateID.setText(String.valueOf(temp.getStateID()));
		txtStateName.setText(temp.getStateName());

		clsLocationManagement2 temp1 = clsLocationManagement2.getLocationInfo(temp.getStateID());
		vCountryID=temp1.getCountryID();
		cmbCountry.setSelectedItem(temp1.getCountryName());
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
		Rcols+=tool.addNewColumn("StateID");
		Rcols+=tool.addNewColumn("StateName");
		Rcols+=tool.addNewColumn("CountryName");
	}

	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth()
	{
		tool.setColumnWidth("StateID",80);
		tool.setColumnWidth("StateName",200);
		tool.setColumnWidth("CountryName",200);
	}

	void setColumnsData()
	{
		tool.removeAllRows();

		clsStateReport1 Data[]=clsStateReport1.getStateReport1Info();

		for(int i=0;i<Data.length;i++)
		{
				Object Objectdata[]=new Object[Rcols];

				Objectdata[0]=i+1;
				Objectdata[1]=Data[i].getStateName();
				Objectdata[2]=Data[i].getCountryName();


			    tool.addNewRow(Objectdata);
		}
	}


	void addCountryRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsCountry.addCountryRecords(temp);
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
			//addStateRecords(cmbStateUpdate);
		}
		else if(ae.getSource() == btnSave)
		{
			clsState temp = readUI();
			clsState.showState(temp);

			if(clsState.isStateDulplicate(temp.getStateName()))
			{
				JOptionPane.showMessageDialog(null,"Entered State Already Exist......! ");
			}
			else
			{
				bst.setButtonState(ButtonState.SaveState);
				cbm.showButtonsOnUI(bst);
				clsState.addNewState(temp);
				JOptionPane.showMessageDialog(null,"State Added Successfully....!");
			}

		}
		else if(ae.getSource() == btnApply)
		{
			if(cmbCountryUpdate.getSelectedIndex() == 0 || cmbStateUpdate.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Country or State Property....!");
			}
			else
			{
				String mStateName = (String)cmbStateUpdate.getSelectedItem();
				int mStateID = clsState.getIDFromName(mStateName);
				clsState temp=clsState.getStateInformation(mStateID);
				clsState.showState(temp);
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
			clsState temp = readUI();
			clsState.updateState(temp);
			PanelState.disabledComponents(pnlUI);
			JOptionPane.showMessageDialog(null,"State Updated Successfully....!");
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsState temp = readUI();
			clsState.deleteState(temp);
			JOptionPane.showMessageDialog(null,"State Deleted Successfully....!");

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
		else if(ae.getSource()==btnNewDoc)
		{
			btnNewDoc.setVisible(false);
			btnRefreshDoc.setVisible(true);

			FrmCountry A=	new FrmCountry();


		}
		else if(ae.getSource()==btnRefreshDoc)
		{
			btnNewDoc.setVisible(true);
			btnRefreshDoc.setVisible(false);

			addCountryRecords(cmbCountry);

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

	void addStateRecords(JComboBox temp, int mCountryID)
	{
		clsState.addStateRecords(temp,mCountryID);
	}

	public static void main(String args[])
	{
		FrmState F=new FrmState();
	}
}