package screensetting;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import appsetting.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import myUtility.*;
import javax.swing.JButton;
import myDesign.*;

public class ScreenDesign extends JPanel
{
	JPanel pnlAll;

	JPanel pnlTop;

	JLabel lblMainLogo;
	JLabel lblMainHeading;
	JLabel lblProgramHeading;


	JPanel pnlLeft;
	JPanel pnlLeftBottom;
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
	JPanel pnlUI;

	JPanel pnlUIReport;

	JPanel pnlNew;
	JButton btnNew;

	JPanel pnlSave;
	JButton btnSave;

	JPanel pnlView;
	JButton btnView;

	JPanel pnlEdit;
	JButton btnEdit;

	JPanel pnlTopRight;
	JPanel pnlTopLeft;

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

	Vector vtrBranch;

	ImageIcon imgLeftMiddel;

	ImageIcon imgLeftBottom;

	JLabel lblLeftBottom;

	JLabel lblMovingBusDeveloperList;

	public ScreenDesign()
	{
		setSize(1950,1200);
		setLocation(1,1);
		setLayout(null);
		setVisible(true);
		setBackground(new Color(236,237,255));

		pnlTop = new JPanel();
		pnlTop.setLayout(null);
		pnlTop.setBackground(new Color(81,85,195));
		pnlTop.setBounds(10,10,1900,140);
		add(pnlTop);

		RoundedPanel.createRoundedPanel(pnlTop,25);

		lblMainLogo = new JLabel(new ImageIcon(new ImageIcon("imagesrc\\img-ServiceNexus-Logo.png").getImage().getScaledInstance(140,140,java.awt.Image.SCALE_SMOOTH)));
		lblMainLogo.setBounds(0,0,140,140);
		pnlTop.add(lblMainLogo);

		lblMainHeading = new JLabel("Service-Nexus");
		lblMainHeading.setBounds(170,30,1500,80);
		lblMainHeading.setFont(new Font("Forte",Font.BOLD, 80));
		lblMainHeading.setForeground(Color.WHITE);
		pnlTop.add(lblMainHeading);

		pnlCenter = new JPanel();
		pnlCenter.setBackground(ColorSetting.getBackColorCenterPanel());
		pnlCenter.setLayout(null);
		pnlCenter.setBounds(390,250,1140,547);
		add(pnlCenter);

		RoundedPanel.createRoundedPanel(pnlCenter,25);

		pnlUI = new JPanel();
		pnlUI.setBounds(6,6,1128,535);
		pnlUI.setLayout(null);
		pnlUI.setBackground(ColorSetting.getBackColorUIPanel());//255,255,143
		pnlCenter.add(pnlUI);

		RoundedPanel.createRoundedPanel(pnlUI,25);

		pnlUIReport = new JPanel();
		pnlUIReport.setLayout(null);
		pnlUIReport.setBounds(6,6,1128,535);
		pnlUIReport.setBackground(new Color(255,255,255)); //44,187,68
		pnlCenter.add(pnlUIReport);

		RoundedPanel.createRoundedPanel(pnlUIReport,25);

		pnlLeft = new JPanel();
		pnlLeft.setLayout(null);
		pnlLeft.setBackground(new Color(64,155,227));//new Color(158,225,242));
		pnlLeft.setBounds(10,160,370,730);
		add(pnlLeft);

		RoundedPanel.createRoundedPanel(pnlLeft,25);


		pnlRight = new JPanel();
		pnlRight.setLayout(null);
		pnlRight.setBackground(new Color(64,155,227));
		pnlRight.setBounds(1540,160,370,730);
		add(pnlRight);

		RoundedPanel.createRoundedPanel(pnlRight,25);

		pnlBottom = new JPanel();
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(new Color(255,255,255,0));
		pnlBottom.setBounds(10,910,1900,140);
		pnlBottom.setOpaque(false);
		add(pnlBottom);

		RoundedPanel.createRoundedPanel(pnlBottom,25);

		lblMovingBusDeveloperList = new JLabel(new ImageIcon(new ImageIcon("imagesrc\\imgBus3_And_DeveloperList.png").getImage().getScaledInstance(1075,110,java.awt.Image.SCALE_SMOOTH)));
		lblMovingBusDeveloperList.setBounds(0,30,1075,110);
		pnlBottom.add(lblMovingBusDeveloperList);

/*		lblLeftBottom = new JLabel("<html><center> Our Talent <br> Spins The World... </center></html>",JLabel.CENTER);
*		//lblLeftBottom.setBackground(new Color(242,178,140));
*		lblLeftBottom.setForeground(Color.WHITE);
*		lblLeftBottom.setFont(new Font("Serif", Font.BOLD, 30));
*		lblLeftBottom.setBounds(10,10,460,120);
*		pnlLeftBottom.add(lblLeftBottom);
*/
		//Center Top Panel

		pnlCenterTop = new JPanel();
		pnlCenterTop.setLayout(null);
		pnlCenterTop.setBounds(390,160,1140,80);
		pnlCenterTop.setBackground(new Color(158,225,242,0));
		add(pnlCenterTop);

		RoundedPanel.createRoundedPanel(pnlCenterTop,25);

		lblProgramHeading = new JLabel("Program Heading.........",JLabel.CENTER);
		lblProgramHeading.setFont(new Font("Arial", Font.BOLD, 28));
		lblProgramHeading.setForeground(new Color(81,85,195));
		lblProgramHeading.setBounds(420,1,350,32);
		pnlCenterTop.add(lblProgramHeading);

		//Center Bottom panel and buttons

		pnlCenterBottom = new JPanel();
		pnlCenterBottom.setLayout(null);
		pnlCenterBottom.setBounds(390,808,1140,80);
		pnlCenterBottom.setBackground(new Color(158,225,242,0));
		add(pnlCenterBottom);

		RoundedPanel.createRoundedPanel(pnlCenterBottom,25);

		pnlNew = new JPanel();
		pnlNew.setBounds(10,15,125,50);
		pnlNew.setLayout(null);
		pnlNew.setBackground(new Color(81,85,195));
		pnlCenterBottom.add(pnlNew);

		RoundedPanel.createRoundedPanel(pnlNew,25);


		btnNew = new JButton();
		btnNew.setBounds(0,0,125,50);
		btnNew.setText("NEW");
		btnNew.setFont(new Font("Basic", Font.BOLD, 18));
		btnNew.setBackground(new Color(81,85,195));
		btnNew.setForeground(new Color(255,255,255));
		pnlNew.add(btnNew);

		RoundedPanel.createRoundedButton(btnNew,25);


		pnlSave = new JPanel();
		pnlSave.setBounds(150,15,125,50);
		pnlSave.setLayout(null);
		pnlSave.setBackground(new Color(81,85,195));
		pnlCenterBottom.add(pnlSave);

		RoundedPanel.createRoundedPanel(pnlSave,25);


		btnSave = new JButton();
		btnSave.setBounds(0,0,125,50);
		btnSave.setText("SAVE");
		btnSave.setFont(new Font("Basic", Font.BOLD, 18));
		btnSave.setBackground(new Color(81,85,195));
		btnSave.setForeground(new Color(255,255,255));
		pnlSave.add(btnSave);

		RoundedPanel.createRoundedButton(btnSave,25);


		pnlView = new JPanel();
		pnlView.setBounds(290,15,125,50);
		pnlView.setLayout(null);
		pnlView.setBackground(new Color(81,85,195));
		pnlCenterBottom.add(pnlView);

		RoundedPanel.createRoundedPanel(pnlView,25);

		btnView = new JButton();
		btnView.setBounds(0,0,125,50);
		btnView.setText("VIEW");
		btnView.setFont(new Font("Basic", Font.BOLD, 18));
		btnView.setBackground(new Color(81,85,195));
		btnView.setForeground(new Color(255,255,255));
		pnlView.add(btnView);

		RoundedPanel.createRoundedButton(btnView,25);


		pnlEdit = new JPanel();
		pnlEdit.setBounds(434,15,125,50);
		pnlEdit.setLayout(null);
		pnlEdit.setBackground(new Color(81,85,195));
		pnlCenterBottom.add(pnlEdit);

		RoundedPanel.createRoundedPanel(pnlEdit,25);

		btnEdit = new JButton();
		btnEdit.setBounds(0,0,125,50);
		btnEdit.setText("EDIT");
		btnEdit.setFont(new Font("Basic", Font.BOLD, 18));
		btnEdit.setBackground(new Color(81,85,195));
		btnEdit.setForeground(new Color(255,255,255));
		pnlEdit.add(btnEdit);

		RoundedPanel.createRoundedButton(btnEdit,25);


		pnlUpdate = new JPanel();
		pnlUpdate.setBounds(578,15,125,50);
		pnlUpdate.setLayout(null);
		pnlUpdate.setBackground(new Color(81,85,195));
		pnlCenterBottom.add(pnlUpdate);

		RoundedPanel.createRoundedPanel(pnlUpdate,25);

		btnUpdate = new JButton();
		btnUpdate.setBounds(0,0,125,50);
		btnUpdate.setText("UPDATE");
		btnUpdate.setFont(new Font("Basic", Font.BOLD, 18));
		btnUpdate.setBackground(new Color(81,85,195));
		btnUpdate.setForeground(new Color(255,255,255));
		pnlUpdate.add(btnUpdate);

		RoundedPanel.createRoundedButton(btnUpdate,25);

		pnlDelete = new JPanel();
		pnlDelete.setBounds(721,15,125,50);
		pnlDelete.setLayout(null);
		pnlDelete.setBackground(new Color(81,85,195));
		pnlCenterBottom.add(pnlDelete);

		RoundedPanel.createRoundedPanel(pnlDelete,25);

		btnDelete = new JButton();
		btnDelete.setBounds(0,0,125,50);
		btnDelete.setText("DELETE");
		btnDelete.setFont(new Font("Basic", Font.BOLD, 18));
		btnDelete.setBackground(new Color(81,85,195));
		btnDelete.setForeground(new Color(255,255,255));
		pnlDelete.add(btnDelete);

		RoundedPanel.createRoundedButton(btnDelete,25);

		pnlCancle = new JPanel();
		pnlCancle.setBounds(864,15,125,50);
		pnlCancle.setLayout(null);
		pnlCancle.setBackground(new Color(81,85,195));
		pnlCenterBottom.add(pnlCancle);

		RoundedPanel.createRoundedPanel(pnlCancle,25);

		btnCancle = new JButton();
		btnCancle.setBounds(0,0,125,50);
		btnCancle.setText("CANCLE");
		btnCancle.setFont(new Font("Basic", Font.BOLD, 18));
		btnCancle.setBackground(new Color(81,85,195));
		btnCancle.setForeground(new Color(255,255,255));
		pnlCancle.add(btnCancle);

		RoundedPanel.createRoundedButton(btnCancle,25);

		pnlReport = new JPanel();
		pnlReport.setBounds(1005,15,125,50);
		pnlReport.setLayout(null);
		pnlReport.setBackground(new Color(81,85,195));
		pnlCenterBottom.add(pnlReport);

		RoundedPanel.createRoundedPanel(pnlReport,25);


		btnReport = new JButton();
		btnReport.setBounds(0,0,125,50);
		btnReport.setText("REPORT");
		btnReport.setFont(new Font("Basic", Font.BOLD, 18));
		btnReport.setBackground(new Color(81,85,195));
		btnReport.setForeground(new Color(255,255,255));
		pnlReport.add(btnReport);

		RoundedPanel.createRoundedButton(btnReport,25);


		pnlClose = new JPanel();
		pnlClose.setBounds(1005,15,125,50);
		pnlClose.setLayout(null);
		pnlClose.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlClose);

		RoundedPanel.createRoundedPanel(pnlClose,25);


		btnClose = new JButton();
		btnClose.setBounds(7,5,110,40);
		btnClose.setText("CLOSE");
		btnClose.setFont(new Font("Basic", Font.BOLD, 18));
		btnClose.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnClose.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlClose.add(btnClose);
		//Left panel

		RoundedPanel.createRoundedButton(btnClose,25);


		pnlCombo1 = new JPanel();
		pnlCombo1.setBounds(6,5,358,70);
		pnlCombo1.setLayout(null);
		pnlLeft.add(pnlCombo1);

		RoundedPanel.createRoundedPanel(pnlCombo1,50);

		lblCombo1 = new JLabel("Your Text Here!!!",SwingConstants.CENTER);
		lblCombo1.setFont(new Font("Arial",Font.BOLD, 16));
		lblCombo1.setBounds(3,3,352,25);
		pnlCombo1.add(lblCombo1);

		cmbCombo1 = new JComboBox();
		cmbCombo1.setBounds(10,27,338,35);
		pnlCombo1.add(cmbCombo1);

		pnlApply = new JPanel();
		pnlApply.setBounds(6,85,358,55);
		pnlApply.setLayout(null);
		pnlLeft.add(pnlApply);

		RoundedPanel.createRoundedPanel(pnlApply,25);

		btnApply = new JButton();
		btnApply.setBounds(0,0,358,55);
		btnApply.setText("Apply");
		btnApply.setBackground(new Color(190,238,242));
		btnApply.setFont(new Font("Arial",Font.BOLD, 22));
		pnlApply.add(btnApply);

		RoundedPanel.createRoundedButton(btnApply,25);


		//Images in Left Middel Panels

		pnlRightTop = ImagePanel.getPanel("imagesrc\\imgBusInNature.jpg");
		pnlRightTop.setBounds(6,6,358,356);
		pnlRightTop.setLayout(null);
		pnlRight.add(pnlRightTop);

		/*lblRightTop = new JLabel(new ImageIcon(new ImageIcon("imagesrc\\images.jpeg").getImage().getScaledInstance(358,297,java.awt.Image.SCALE_SMOOTH)));
		lblRightTop.setBounds(0,0,358,297);
		pnlRightTop.add(lblRightTop);*/

		//Images in Left Bottom Panels

		pnlRightMiddel = ImagePanel.getPanel("imagesrc\\busAndLogo.jpeg");
		pnlRightMiddel.setBounds(6,367,358,357);
		pnlRightMiddel.setLayout(null);
		pnlRight.add(pnlRightMiddel);


		/*lblRightMiddel = new JLabel(new ImageIcon(new ImageIcon("imagesrc\\busAndLogo.jpeg").getImage().getScaledInstance(358,297,java.awt.Image.SCALE_SMOOTH)));
		lblRightMiddel.setBounds(0,0,358,297);
		pnlRightMiddel.add(lblRightMiddel);*/

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
		PanelState.disabledComponents(pnlApply);
		PanelState.hideComponents(pnlUIReport);
		PanelState.hideComponents(pnlClose);

	}

	public  JLabel getProgramHeadingLabel()
	{
		return(lblProgramHeading);
	}

	public String getProgramHeading()
	{
		return(lblMainHeading.getText());
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


	public JPanel getClosePanel()
	{
		return(pnlClose);
	}

	public JButton getCloseButton()
	{
		return(btnClose);
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

	public JComboBox getCombo1()
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

	public JLabel getMovingBusDeveloperListLabel()
	{
		return(lblMovingBusDeveloperList);
	}

	public JPanel getBottomPanel()
	{
		return(pnlBottom);
	}

	public JPanel getLeftPanel()
	{
		return(pnlLeft);
	}

}
