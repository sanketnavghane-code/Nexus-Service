package screensetting;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import appsetting.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import myUtility.*;
import javax.swing.JButton;

public class ScreenDesign2 extends JPanel
{
	JPanel pnlAll;

	JPanel pnlTop;

	JLabel lblMainLogo;
	JLabel lblMainHeading;
	JLabel lblProgramHeading;

	JPanel pnlLeft;

	JPanel pnlRight;

	JPanel pnlRightTop;
	JLabel lblRightTop;

	JPanel pnlRightMiddel;
	JLabel lblRightMiddel;


	JPanel pnlCenter;
	JPanel pnlCenterTop;
	JPanel pnlCenterBottom;

	JPanel pnlBottom;
	JPanel pnlProgramHead;
	JPanel pnlProgramBody;

	JPanel pnlUIReport;

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

	JPanel pnlCancle;
	JButton btnCancle;

	JPanel pnlReport;
	JButton btnReport;

	JPanel pnlClose;
	JButton btnClose;



	JPanel pnlApply;
	JButton btnApply;

	JPanel pnlCombo1;
	JComboBox cmbCombo1;
	JLabel lblCombo1;

	JPanel pnlCombo2;
	JLabel lblCombo2;
	JComboBox cmbCombo2;

	Vector vtrBranch;

	ImageIcon imgLeftMiddel;

	JLabel lblLeftBottom;
	ImageIcon imgLeftBottom;


	JLabel lblDeveloper;
	JLabel lblDeveloperList;

	JPanel pnlUI;

	public ScreenDesign2()
	{
		setSize(1950,1200);
		setLocation(1,1);
		setLayout(null);
		setVisible(true);
		setBackground(Color.WHITE);

		pnlTop = new JPanel();
		pnlTop.setLayout(null);
		pnlTop.setBackground(ColorSetting.getBackColorTopPanel());
		pnlTop.setBounds(10,10,1900,140);
		add(pnlTop);

		//Main Logo and Main Heading

		ImageIcon imageIcon = new ImageIcon("imagesrc\\mainLogoBgRemoved.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(160,140,java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg);  // transform it back
		lblMainLogo = new JLabel(imageIcon);
		lblMainLogo.setBounds(0,0,160,140);
		pnlTop.add(lblMainLogo);

		lblMainHeading = new JLabel("MSRTC Service Allocation System");
		lblMainHeading.setBounds(170,30,1500,80);
		lblMainHeading.setFont(new Font("Forte",Font.BOLD, 80));
		lblMainHeading.setForeground(Color.WHITE);
		pnlTop.add(lblMainHeading);

		pnlCenter = new JPanel();
		pnlCenter.setBackground(ColorSetting.getBackColorCenterPanel());
		pnlCenter.setLayout(null);
		pnlCenter.setBounds(390,250,1140,547);
		add(pnlCenter);

		pnlUI = new JPanel();
		pnlUI.setBounds(6,6,1128,535);
		pnlUI.setLayout(null);
		pnlUI.setBackground(ColorSetting.getBackColorUIPanel());//255,255,143
		pnlCenter.add(pnlUI);

		pnlUIReport = new JPanel();
		pnlUIReport.setBounds(6,6,1128,535);
		pnlUIReport.setBackground(new Color(244,187,68)); //44,187,68
		pnlCenter.add(pnlUIReport);

		pnlLeft = new JPanel();
		pnlLeft.setLayout(null);
		pnlLeft.setBackground(ColorSetting.getBackColorLeftPanel());
		pnlLeft.setBounds(10,160,370,730);
		add(pnlLeft);

		pnlRight = new JPanel();
		pnlRight.setLayout(null);
		pnlRight.setBackground(ColorSetting.getBackColorRightPanel());
		pnlRight.setBounds(1540,160,370,730);
		add(pnlRight);

		pnlBottom = new JPanel();
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(ColorSetting.getBackColorBottomPanel());
		pnlBottom.setBounds(10,900,1900,140);
		add(pnlBottom);

		lblDeveloper = new JLabel("* Developed By *");
		lblDeveloper.setBounds(850,10,500,40);
		lblDeveloper.setFont(new Font("Serif", Font.BOLD, 30));
		lblDeveloper.setForeground(Color.WHITE);
		pnlBottom.add(lblDeveloper);

		lblDeveloperList = new JLabel("Ms. Srushti Pardeshi                    Mr. Mayank Bhat                    Ms. Khushi Bhat                     Ms. Mansi Bhat");
		lblDeveloperList.setBounds(380,80,1900,30);
		lblDeveloperList.setFont(new Font("Serif", Font.ITALIC, 25));
		lblDeveloperList.setForeground(Color.WHITE);
		pnlBottom.add(lblDeveloperList);

		//Center Top Panel

		pnlCenterTop = new JPanel();
		//pnlCenterTop.setLayout(null);
		pnlCenterTop.setBounds(390,160,1140,80);
		pnlCenterTop.setBackground(ColorSetting.getBackColorCenterTopPanel());
		add(pnlCenterTop);

		lblProgramHeading = new JLabel("State Information",JLabel.CENTER);
		lblProgramHeading.setFont(new Font("Arial", Font.BOLD, 30));
		lblProgramHeading.setForeground(Color.WHITE);
		lblProgramHeading.setBounds(20,10,40,250);
		pnlCenterTop.add(lblProgramHeading);

		//Center Bottom panel and buttons

		pnlCenterBottom = new JPanel();
		pnlCenterBottom.setLayout(null);
		pnlCenterBottom.setBounds(390,808,1140,80);
		pnlCenterBottom.setBackground(ColorSetting.getBackColorCenterBottomPanel());
		add(pnlCenterBottom);

		pnlNew = new JPanel();
		pnlNew.setBounds(10,15,125,50);
		pnlNew.setLayout(null);
		pnlNew.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlNew);

		btnNew = new JButton();
		btnNew.setBounds(7,5,110,40);
		btnNew.setText("NEW");
		btnNew.setFont(new Font("Basic", Font.BOLD, 18));
		btnNew.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnNew.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlNew.add(btnNew);

		pnlSave = new JPanel();
		pnlSave.setBounds(150,15,125,50);
		pnlSave.setLayout(null);
		pnlSave.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlSave);

		btnSave = new JButton();
		btnSave.setBounds(7,5,110,40);
		btnSave.setText("SAVE");
		btnSave.setFont(new Font("Basic", Font.BOLD, 18));
		btnSave.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnSave.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlSave.add(btnSave);

		pnlView = new JPanel();
		pnlView.setBounds(290,15,125,50);
		pnlView.setLayout(null);
		pnlView.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlView);

		btnView = new JButton();
		btnView.setBounds(7,5,110,40);
		btnView.setText("VIEW");
		btnView.setFont(new Font("Basic", Font.BOLD, 18));
		btnView.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnView.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlView.add(btnView);

		pnlEdit = new JPanel();
		pnlEdit.setBounds(434,15,125,50);
		pnlEdit.setLayout(null);
		pnlEdit.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlEdit);

		btnEdit = new JButton();
		btnEdit.setBounds(7,5,110,40);
		btnEdit.setText("EDIT");
		btnEdit.setFont(new Font("Basic", Font.BOLD, 18));
		btnEdit.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnEdit.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlEdit.add(btnEdit);

		pnlUpdate = new JPanel();
		pnlUpdate.setBounds(578,15,125,50);
		pnlUpdate.setLayout(null);
		pnlUpdate.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlUpdate);

		btnUpdate = new JButton();
		btnUpdate.setBounds(7,5,110,40);
		btnUpdate.setText("UPDATE");
		btnUpdate.setFont(new Font("Basic", Font.BOLD, 18));
		btnUpdate.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnUpdate.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlUpdate.add(btnUpdate);

		pnlDelete = new JPanel();
		pnlDelete.setBounds(721,15,125,50);
		pnlDelete.setLayout(null);
		pnlDelete.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlDelete);

		btnDelete = new JButton();
		btnDelete.setBounds(7,5,110,40);
		btnDelete.setText("DELETE");
		btnDelete.setFont(new Font("Basic", Font.BOLD, 18));
		btnDelete.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnDelete.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlDelete.add(btnDelete);

		pnlCancle = new JPanel();
		pnlCancle.setBounds(864,15,125,50);
		pnlCancle.setLayout(null);
		pnlCancle.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlCancle);

		btnCancle = new JButton();
		btnCancle.setBounds(7,5,110,40);
		btnCancle.setText("CANCLE");
		btnCancle.setFont(new Font("Basic", Font.BOLD, 18));
		btnCancle.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnCancle.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlCancle.add(btnCancle);

		pnlReport = new JPanel();
		pnlReport.setBounds(1005,15,125,50);
		pnlReport.setLayout(null);
		pnlReport.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlReport);

		btnReport = new JButton();
		btnReport.setBounds(7,5,110,40);
		btnReport.setText("REPORT");
		btnReport.setFont(new Font("Basic", Font.BOLD, 18));
		btnReport.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnReport.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlReport.add(btnReport);

		pnlClose = new JPanel();
		pnlClose.setBounds(1005,15,125,50);
		pnlClose.setLayout(null);
		pnlClose.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlClose);

		btnClose = new JButton();
		btnClose.setBounds(7,5,110,40);
		btnClose.setText("CLOSE");
		btnClose.setFont(new Font("Basic", Font.BOLD, 18));
		btnClose.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnClose.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlClose.add(btnClose);

		//Left panel

		pnlCombo1 = new JPanel();
		pnlCombo1.setBounds(6,5,358,65);
		pnlCombo1.setLayout(null);
		pnlLeft.add(pnlCombo1);

		lblCombo1 = new JLabel("Your Text Here!!!",SwingConstants.CENTER);
		lblCombo1.setFont(new Font("Arial",Font.BOLD, 16));
		lblCombo1.setBounds(3,3,352,25);
		pnlCombo1.add(lblCombo1);

		cmbCombo1 = new JComboBox();
		cmbCombo1.setBounds(3,27,352,35);
		pnlCombo1.add(cmbCombo1);

        pnlCombo2 = new JPanel();
		pnlCombo2.setBounds(6,76,358,65);
		pnlCombo2.setLayout(null);
		pnlLeft.add(pnlCombo2);

		lblCombo2 = new JLabel("Your Text Here!!!",SwingConstants.CENTER);
		lblCombo2.setFont(new Font("Arial",Font.BOLD, 16));
		lblCombo2.setBounds(3,3,352,25);
		pnlCombo2.add(lblCombo2);

		cmbCombo2 = new JComboBox();
		cmbCombo2.setBounds(3,27,352,35);
		pnlCombo2.add(cmbCombo2);

		pnlApply = new JPanel();
		pnlApply.setBounds(6,147,358,55);
		pnlApply.setLayout(null);
		pnlLeft.add(pnlApply);

		btnApply = new JButton();
		btnApply.setBounds(4,3,350,50);
		btnApply.setText("Apply");
		btnApply.setFont(new Font("Arial",Font.BOLD, 18));
		pnlApply.add(btnApply);

		//Images in Left Middel Panels

		pnlRightTop = new JPanel();
		pnlRightTop.setBounds(6,6,358,292);
		pnlRightTop.setLayout(null);
		pnlRight.add(pnlRightTop);

		imageIcon = new ImageIcon("imagesrc\\images.jpeg"); // load the image to a imageIcon
		image = imageIcon.getImage(); // transform it
		newimg = image.getScaledInstance(358,297,java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg);  // transform it back
		lblRightTop = new JLabel(imageIcon);
		lblRightTop.setBounds(0,0,358,297);
		pnlRightTop.add(lblRightTop);

		//Images in Left Bottom Panels

		pnlRightMiddel = new JPanel();
		pnlRightMiddel.setBounds(6,432,358,292);
		pnlRightMiddel.setLayout(null);
		pnlRight.add(pnlRightMiddel);

		imageIcon = new ImageIcon("imagesrc\\busAndLogo.jpeg"); // load the image to a imageIcon
		image = imageIcon.getImage(); // transform it
		newimg = image.getScaledInstance(358,297,java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg);  // transform it back
		lblRightMiddel = new JLabel(imageIcon);
		lblRightMiddel.setBounds(0,0,358,297);
		pnlRightMiddel.add(lblRightMiddel);

		setDefaultSettings();
	}

	void setDefaultSettings()
	{

		PanelState.disabledComponents(pnlNew);
		PanelState.disabledComponents(pnlSave);
		PanelState.disabledComponents(pnlView);
		PanelState.disabledComponents(pnlEdit);
		PanelState.disabledComponents(pnlUpdate);
		PanelState.disabledComponents(pnlDelete);
		PanelState.disabledComponents(pnlCancle);
		PanelState.disabledComponents(pnlReport);
		PanelState.disabledComponents(pnlCombo1);
		PanelState.disabledComponents(pnlCombo2);
		PanelState.disabledComponents(pnlApply);
		PanelState.hideComponents(pnlUIReport);
		PanelState.hideComponents(pnlClose);
	}

	public JLabel getProgramHeadingLabel()
	{
		return(lblProgramHeading);
	}

	public JPanel getNewPanel()
	{
		return(pnlNew);
	}

	public JButton getNewButton()
	{
		return(btnNew);
	}

	public JPanel getViewPanel()
	{
		return(pnlView);
	}

	public JButton getViewButton()
	{
		return(btnView);
	}

	public JPanel getReportPanel()
	{
		return(pnlReport);
	}

	public JButton getReportButton()
	{
		return(btnReport);
	}

	public JPanel getUIPanel()
	{
	    return(pnlUI);
	}

	public JPanel getSavePanel()
	{
		return(pnlSave);
	}

	public JButton getSaveButton()
	{
		return(btnSave);
	}

	public JPanel getCancelPanel()
	{
		return(pnlCancle);
	}

	public JButton getCancelButton()
	{
		return(btnCancle);
	}

	public JPanel getCombo1Panel()
	{
		return(pnlCombo1);
	}

	public JComboBox getCombo1ComboBox()
	{
		return(cmbCombo1);
	}

	public JPanel getApplyPanel()
	{
		return(pnlApply);
	}

	public JButton getApplyButton()
	{
		return(btnApply);
	}

	public JPanel getEditPanel()
	{
		return(pnlEdit);
	}

	public JButton getEditButton()
	{
		return(btnEdit);
	}

	public JPanel getDeletePanel()
	{
		return(pnlDelete);
	}

	public JButton getDeleteButton()
	{
		return(btnDelete);
	}

	public JPanel getUpdatePanel()
	{
		return(pnlUpdate);
	}

	public JButton getUpdateButton()
	{
		return(btnUpdate);
	}

	public JLabel getCombo1Label()
	{
		return(lblCombo1);
	}

	public JPanel getUIReportPanel()
	{
		return(pnlUIReport);
	}

	public JPanel getClosePanel()
	{
		return(pnlClose);
	}

	public JButton getCloseButton()
	{
		return(btnClose);
	}

	public JLabel getCombo2Label()
	{
		return(lblCombo2);
	}

	public JPanel getCombo2Panel()
	{
		return(pnlCombo2);
	}

	public JComboBox getCombo2ComboBox()
	{
		return(cmbCombo2);
	}
}
