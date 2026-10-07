package screensetting;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import appsetting.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import myUtility.*;

public class ScreenDesign6 extends JPanel
{
	JPanel pnlAll, pnlTop, pnlLeft, pnlRight, pnlCenter, pnlBottom, pnlProgramHead, pnlProgramBody, pnlUI,pnlUIReport;
	JPanel pnlNew,pnlSave,pnlView,pnlEdit,pnlUpdate,pnlDelete,pnlCancle,pnlReport,pnlClose;
	JButton btnNew,btnSave,btnView,btnEdit,btnUpdate,btnDelete,btnCancle,btnReport, btnApply,btnClose;
	JPanel pnlCenterBottom, pnlCenterTop;
	JPanel pnlCombo1, pnlCombo2, pnlCombo3, pnlCombo4, pnlCombo5, pnlCombo6, pnlApply, pnlRightTop, pnlRightMiddel;
	JComboBox cmbCombo1,cmbCombo2, cmbCombo3, cmbCombo4, cmbCombo5, cmbCombo6;
	Vector vtrBranch;
	ImageIcon imgRightTop, imgRightMiddel;
	JLabel lblRightTop, lblRightMiddel, lblProgramHeading, lblMainLogo,lblDeveloper,
    lblDeveloperList,lblCombo1,lblCombo2, lblCombo3, lblCombo4, lblCombo5, lblCombo6;

	public ScreenDesign6()
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

		ImageIcon imageIcon = new ImageIcon("D:\\MSRTC_Serviece_Allocation\\imagesrc\\mainLogoBgRemoved.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(160,140,java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg);  // transform it back
		lblMainLogo = new JLabel(imageIcon);
		lblMainLogo.setBounds(0,0,160,140);
		pnlTop.add(lblMainLogo);

		lblProgramHeading = new JLabel("MSRTC Service Allocation System");
		lblProgramHeading.setBounds(170,30,1500,80);
		lblProgramHeading.setFont(new Font("Forte",Font.BOLD, 80));
		lblProgramHeading.setForeground(Color.WHITE);
		pnlTop.add(lblProgramHeading);

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
		pnlCenterTop.setBounds(390,160,1140,80);
		pnlCenterTop.setBackground(ColorSetting.getBackColorCenterTopPanel());
		add(pnlCenterTop);

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

		lblCombo4 = new JLabel("Your Text Here!!!",SwingConstants.CENTER);
		lblCombo4.setFont(new Font("Arial",Font.BOLD, 16));
		lblCombo4.setBounds(3,3,352,25);
		pnlCombo4.add(lblCombo4);

		cmbCombo4 = new JComboBox();
		cmbCombo4.setBounds(3,27,352,35);
		pnlCombo4.add(cmbCombo4);

        pnlCombo5 = new JPanel();
		pnlCombo5.setBounds(6,289,358,65);
		pnlCombo5.setLayout(null);
		pnlLeft.add(pnlCombo5);

		lblCombo5 = new JLabel("Your Text Here!!!",SwingConstants.CENTER);
		lblCombo5.setFont(new Font("Arial",Font.BOLD, 16));
		lblCombo5.setBounds(3,3,352,25);
		pnlCombo5.add(lblCombo5);

		cmbCombo5 = new JComboBox();
		cmbCombo5.setBounds(3,27,352,35);
		pnlCombo5.add(cmbCombo5);

        pnlCombo6 = new JPanel();
		pnlCombo6.setBounds(6,360,358,65);
		pnlCombo6.setLayout(null);
		pnlLeft.add(pnlCombo6);

		lblCombo6 = new JLabel("Your Text Here!!!",SwingConstants.CENTER);
		lblCombo6.setFont(new Font("Arial",Font.BOLD, 16));
		lblCombo6.setBounds(3,3,352,25);
		pnlCombo6.add(lblCombo6);

		cmbCombo6 = new JComboBox();
		cmbCombo6.setBounds(3,27,352,35);
		pnlCombo6.add(cmbCombo6);

		pnlApply = new JPanel();
		pnlApply.setBounds(6,431,358,55);
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

		imageIcon = new ImageIcon("D:\\MSRTC_Serviece_Allocation\\imagesrc\\images.jpeg"); // load the image to a imageIcon
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

		imageIcon = new ImageIcon("D:\\MSRTC_Serviece_Allocation\\imagesrc\\busAndLogo.jpeg"); // load the image to a imageIcon
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
		PanelState.disabledComponents(pnlCombo3);
		PanelState.disabledComponents(pnlCombo4);
		PanelState.disabledComponents(pnlCombo5);
		PanelState.disabledComponents(pnlCombo6);
		PanelState.disabledComponents(pnlApply);
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

		public JPanel getClosePanel()
				{
				    return(pnlClose);
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
		public JButton getCloseButton()
				{
					return(btnClose);
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


		public JLabel getCombo5Label()
		{
			return(lblCombo5);
		}

		public JPanel getCombo5Panel()
		{
			return(pnlCombo5);
		}

		public JComboBox getCombo5ComboBox()
		{
			return(cmbCombo5);
		}


		public JLabel getCombo6Label()
		{
			return(lblCombo6);
		}

		public JPanel getCombo6Panel()
		{
			return(pnlCombo6);
		}

		public JComboBox getCombo6ComboBox()
		{
			return(cmbCombo6);
		}

}
