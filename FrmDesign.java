import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;

class frmDesign extends JFrame implements ActionListener
{
	JPanel pnlUI, pnlApply, pnlCombo1, pnlNew, pnlSave, pnlView, pnlEdit, pnlUpdate, pnlDelete, pnlCancel, pnlReport;
	JButton btnNew, btnView, btnReport, btnSave, btnCancel, btnApply, btnEdit, btnDelete, btnUpdate;
	JComboBox cmbCombo1;

	ScreenDesign myUI;

	JLabel lblProgramHeading, lblCountryID , lblCountryName;
	JTextField txtCountryID , txtCountryName;

	frmDesign()
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

		pnlNew = myUI.getNewPanel();
		btnNew = myUI.getNewButton();
		btnNew.addActionListener(this);

		pnlSave = myUI.getSavePanel();
		btnSave = myUI.getSaveButton();
		btnSave.addActionListener(this);

		pnlCancel = myUI.getCancelPanel();
		btnCancel = myUI.getCancelButton();
		btnCancel.addActionListener(this);

		//pnlCombo1 = myUI.getCombo1Panel();
		//btnCombo1 = myUI.getCombo1ComboBox();
		//btnCombo1.addActionListener(this);

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

		lblProgramHeading = myUI.getProgramHeadingLabel();
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


		setVisible(true);
		show();

		setDefaultOperation();
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



	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNew)
		{
			PanelState.disabledComponents(pnlNew);
			PanelState.disabledComponents(pnlView);
			PanelState.disabledComponents(pnlReport);
			PanelState.enabledComponents(pnlSave);
			PanelState.enabledComponents(pnlCancel);
			PanelState.enabledComponents(pnlUI);
			initUI();
		}
		else if(ae.getSource() == btnView)
		{
			PanelState.disabledComponents(pnlNew);
			PanelState.disabledComponents(pnlView);
			PanelState.disabledComponents(pnlReport);
			PanelState.enabledComponents(pnlCancel);
			PanelState.enabledComponents(pnlCombo1);
			PanelState.enabledComponents(pnlApply);

		}
		else if(ae.getSource() == btnReport)
		{

		}
		else if(ae.getSource() == btnSave)
		{
			PanelState.disabledComponents(pnlSave);
			PanelState.disabledComponents(pnlCancel);
			PanelState.disabledComponents(pnlUI);
			PanelState.enabledComponents(pnlNew);
			PanelState.enabledComponents(pnlView);
			PanelState.enabledComponents(pnlReport);

			clsCountry temp = readUI();
			clsCountry.showCountry(temp);

		}
		else if(ae.getSource() == btnApply)
		{
			PanelState.disabledComponents(pnlCancel);
			PanelState.disabledComponents(pnlCombo1);
			PanelState.disabledComponents(pnlApply);
			PanelState.enabledComponents(pnlDelete);
			PanelState.enabledComponents(pnlEdit);
		}
		else if(ae.getSource() == btnEdit)
		{
			PanelState.disabledComponents(pnlDelete);
			PanelState.disabledComponents(pnlEdit);
			PanelState.enabledComponents(pnlUpdate);
		}
		else if(ae.getSource() == btnUpdate)
		{
			PanelState.disabledComponents(pnlUpdate);
			PanelState.enabledComponents(pnlNew);
			PanelState.enabledComponents(pnlView);
			PanelState.enabledComponents(pnlReport);
		}
		else if(ae.getSource() == btnDelete)
		{
			PanelState.disabledComponents(pnlDelete);
			PanelState.disabledComponents(pnlEdit);
			PanelState.enabledComponents(pnlNew);
			PanelState.enabledComponents(pnlView);
			PanelState.enabledComponents(pnlReport);
		}

	}
	public static void main(String args[])
	{
		new frmDesign();
	}
}
