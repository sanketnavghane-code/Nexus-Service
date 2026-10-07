package screensetting;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import appsetting.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import myUtility.*;
import myDesign.*;

public class AllocationDesign extends JPanel
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
	JLabel lblNotice;
	JPanel pnlProgramBody;
	JPanel pnlUIReport;

	JPanel pnlSave;
	JButton btnSave;

	JPanel pnlReport;
	JButton btnReport;

	JPanel pnlClose;
	JButton btnClose;


	JPanel pnlCombo1;
	JComboBox cmbCombo1;
	JLabel lblCombo1;

	JPanel pnlCombo2;
	JLabel lblCombo2;
	JComboBox cmbCombo2;

	JPanel pnlCombo3;
	JLabel lblCombo3;
	JComboBox cmbCombo3;

    JPanel pnlCombo4;
	JLabel lblCombo4;
	JComboBox cmbCombo4;

	Vector vtrBranch;

	ImageIcon imgLeftMiddel;

	JLabel lblLeftBottom;
	ImageIcon imgLeftBottom;


	JLabel lblMovingBusDeveloperList;

	JPanel pnlUI;

	public AllocationDesign()
	{
		setSize(1950,1200);
		setLocation(1,1);
		setLayout(null);
		setVisible(true);
		setBackground(Color.WHITE);

		pnlTop = new JPanel();
		pnlTop.setLayout(null);
		pnlTop.setBackground(new Color(81,85,195));
		pnlTop.setBounds(10,10,1900,140);
		add(pnlTop);

		RoundedPanel.createRoundedPanel(pnlTop,25);


		//Main Logo and Main Heading

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

		pnlUIReport = new JPanel();
		pnlUIReport.setBounds(6,6,1128,535);
		pnlUIReport.setBackground(new Color(244,187,68)); //44,187,68
		pnlCenter.add(pnlUIReport);

		RoundedPanel.createRoundedPanel(pnlUIReport,25);

		pnlLeft = new JPanel();
		pnlLeft.setLayout(null);
		pnlLeft.setBackground(new Color(64,155,227));
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
		pnlBottom.setBackground(new Color(81,85,195));
		pnlBottom.setBounds(10,900,1900,140);
		add(pnlBottom);

		RoundedPanel.createRoundedPanel(pnlBottom,25);

		lblMovingBusDeveloperList = new JLabel(new ImageIcon(new ImageIcon("imagesrc\\imgBus3_And_DeveloperList.png").getImage().getScaledInstance(1075,110,java.awt.Image.SCALE_SMOOTH)));
		lblMovingBusDeveloperList.setBounds(0,30,1075,110);
		pnlBottom.add(lblMovingBusDeveloperList);

		//Center Top Panel

		pnlCenterTop = new JPanel();
		pnlCenterTop.setLayout(null);
		pnlCenterTop.setBounds(390,160,1140,80);
		pnlCenterTop.setBackground(new Color(158,225,242,0));
		add(pnlCenterTop);

		RoundedPanel.createRoundedPanel(pnlCenterTop,25);

		//Allocation
		lblNotice = new JLabel("Note : Your entered data should not be dublicate.........!");
		lblNotice.setFont(new Font("Arial", Font.BOLD, 18));
		lblNotice.setForeground(new Color(81,85,195));
		lblNotice.setBounds(0,40,1000,50);
		pnlCenterTop.add(lblNotice);

		lblProgramHeading = new JLabel("Allocation Information",JLabel.CENTER);
		lblProgramHeading.setFont(new Font("Arial", Font.BOLD, 30));
		lblProgramHeading.setForeground(new Color(81,85,195));
		lblProgramHeading.setBounds(320,0,500,30);
		pnlCenterTop.add(lblProgramHeading);

		//Center Bottom panel and buttons

		pnlCenterBottom = new JPanel();
		pnlCenterBottom.setLayout(null);
		pnlCenterBottom.setBounds(390,808,1140,80);
		pnlCenterBottom.setBackground(new Color(158,225,242,0));
		add(pnlCenterBottom);

		RoundedPanel.createRoundedPanel(pnlCenterBottom,25);

		pnlSave = new JPanel();
		pnlSave.setBounds(25,15,125,50);
		pnlSave.setLayout(null);
		pnlSave.setBackground(new Color(81,85,195));
		pnlCenterBottom.add(pnlSave);
	    RoundedPanel.createRoundedPanel(pnlSave,25);

		btnSave = new JButton();
		btnSave.setBounds(0,0,125,50);
		btnSave.setText("SAVE");
		btnSave.setFont(new Font("Basic", Font.BOLD, 18));
		btnSave.setBackground(new Color(81,85,195));
		btnSave.setForeground(Color.WHITE);
		pnlSave.add(btnSave);
	    RoundedPanel.createRoundedButton(btnSave,25);

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
		btnReport.setForeground(Color.WHITE);
	    RoundedPanel.createRoundedButton(btnReport,25);
		pnlReport.add(btnReport);


		pnlClose = new JPanel();
		pnlClose.setBounds(1005,15,125,50);
		pnlClose.setLayout(null);
		pnlClose.setBackground(ColorSetting.getBackColorCenterBottomButtonPanel());
		pnlCenterBottom.add(pnlClose);

		PanelState.hideComponents(pnlClose);

		RoundedPanel.createRoundedPanel(pnlClose,25);


		btnClose = new JButton();
		btnClose.setBounds(7,5,110,40);
		btnClose.setText("Close");
		btnClose.setFont(new Font("Basic", Font.BOLD, 18));
		btnClose.setBackground(ColorSetting.getBackColorCenterBottomButton());
		btnClose.setForeground(ColorSetting.getForeColorCenterBottomButton());
		pnlClose.add(btnClose);

		RoundedPanel.createRoundedButton(btnClose,25);


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

        pnlCombo3 = new JPanel();
		pnlCombo3.setBounds(6,147,358,65);
		pnlCombo3.setLayout(null);
		pnlLeft.add(pnlCombo3);

		lblCombo3 = new JLabel("Your Text Here!!!",SwingConstants.CENTER);
		lblCombo3.setFont(new Font("Arial",Font.BOLD, 16));
		lblCombo3.setBounds(3,3,352,25);
		pnlCombo3.add(lblCombo3);

		cmbCombo3 = new JComboBox();
		cmbCombo3.setBounds(3,27,352,35);
		pnlCombo3.add(cmbCombo3);

	    pnlCombo4 = new JPanel();
	    pnlCombo4.setBounds(6,218,358,65);
	    pnlCombo4.setLayout(null);
	    pnlLeft.add(pnlCombo4);

	    lblCombo4 = new JLabel("Taluka List!!!",SwingConstants.CENTER);
	    lblCombo4.setFont(new Font("Arial",Font.BOLD, 16));
	    lblCombo4.setBounds(3,3,352,25);
	    pnlCombo4.add(lblCombo4);

	    cmbCombo4 = new JComboBox();
	    cmbCombo4.setBounds(3,27,352,35);
		pnlCombo4.add(cmbCombo4);


		//Images in Left Middel Panels

		pnlRightTop = new JPanel();
		pnlRightTop.setBounds(6,6,358,292);
		pnlRightTop.setLayout(null);
		pnlRight.add(pnlRightTop);

		RoundedPanel.createRoundedPanel(pnlRightTop,25);


		ImageIcon imageIcon = new ImageIcon("imagesrc\\images.jpeg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(358,297,java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg);  // transform it back
		lblRightTop = new JLabel(imageIcon);
		lblRightTop.setBounds(0,0,358,297);
		pnlRightTop.add(lblRightTop);

		//Images in Left Bottom Panels

		pnlRightMiddel = new JPanel();
		pnlRightMiddel.setBounds(6,432,358,292);
		pnlRightMiddel.setLayout(null);
		pnlRight.add(pnlRightMiddel);

		RoundedPanel.createRoundedPanel(pnlRightMiddel,25);

		imageIcon = new ImageIcon("imagesrc\\busAndLogo.jpeg"); // load the image to a imageIcon
		image = imageIcon.getImage(); // transform it
		newimg = image.getScaledInstance(358,297,java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg);  // transform it back
		lblRightMiddel = new JLabel(imageIcon);
		lblRightMiddel.setBounds(0,0,358,297);
		pnlRightMiddel.add(lblRightMiddel);

		//setDefaultSettings();
	}

/*	void setDefaultSettings()
	{

		PanelState.disabledComponents(pnlNew);
		PanelState.disabledComponents(pnlSave);
		PanelState.disabledComponents(pnlView);
		PanelState.disabledComponents(pnlEdit);
		PanelState.disabledComponents(pnlUpdate);
		PanelState.disabledComponents(pnlDelete);
		PanelState.disabledComponents(pnlCancle);
		PanelState.disabledComponents(pnlReport);
		PanelState.disabledComponents(pnlClose);
		PanelState.disabledComponents(pnlCombo1);
		PanelState.disabledComponents(pnlCombo2);
	    PanelState.disabledComponents(pnlCombo3);
	    PanelState.disabledComponents(pnlCombo4);
		PanelState.disabledComponents(pnlApply);
		PanelState.hideComponents(pnlUIReport);
	}
*/
	public JLabel getProgramHeadingLabel()
	{
		return(lblProgramHeading);
	}

	public JLabel getNoticeLabel()
	{
		return(lblNotice);
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

	public JPanel getCenterTopPanel()
	{
	    return(pnlCenterTop);
	}

	public JPanel getCombo1Panel()
	{
		return(pnlCombo1);
	}

	public JComboBox getCombo1ComboBox()
	{
		return(cmbCombo1);
	}

	public JLabel getCombo1Label()
	{
		return(lblCombo1);
	}

	public JPanel getUIReportPanel()
	{
		return(pnlUIReport);
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

	public JLabel getCombo3Label()
	{
		return(lblCombo3);
	}

	public JPanel getCombo3Panel()
	{
		return(pnlCombo3);
	}

	public JComboBox getCombo3ComboBox()
	{
		return(cmbCombo3);
	}
	public JLabel getCombo4Label()
	{
		return(lblCombo4);
	}

	public JPanel getCombo4Panel()
	{
		return(pnlCombo4);
	}

	public JComboBox getCombo4ComboBox()
	{
		return(cmbCombo4);
	}

	public JPanel getSavePanel()
	{
		return(pnlSave);
	}

	public JButton getSaveButton()
	{
		return(btnSave);
	}

	public JPanel getBottomPanel()
	{
		return(pnlBottom);
	}

	public JLabel getMovingBusDeveloperListLabel()
	{
		return(lblMovingBusDeveloperList);
	}

	public static void main(String args[])
	{
		new AllocationDesign();
	}
}
