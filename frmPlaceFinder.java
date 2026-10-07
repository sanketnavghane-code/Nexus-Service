import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class frmPlaceFinder extends JFrame implements ActionListener
{
		JPanel pnlPlaceFinder;
		JLabel lblPlaceFinder;
		JComboBox cmbCountry;
		JComboBox cmbState;
		JComboBox cmbDistrict;
		JComboBox cmbTaluka;
		JComboBox cmbVillage;
		JButton btnNewTalukaDoc;
		JButton btnRefreshTalukaDoc;
		JButton btnNewVillageDoc;
		JButton btnRefreshVillageDoc;
		JLabel lblPlaceSelection;
		JButton btnSelectAndClose;

		JCheckBox chbVillagian;

		frmPlaceFinder()
		{

			setSize(420,500);
			setLocation(1050,300);
			setLayout(new BorderLayout());
			setBackground(ColorSetting.getBackColorFrame());
			setTitle("Form Designing");

			int y=50;
			int h=30;
			int gap=15;
			int y1=10;
			int gap1=20;

			pnlPlaceFinder = new JPanel();
			pnlPlaceFinder.setBounds(575,25,400,400);
			pnlPlaceFinder.setLayout(null);
			pnlPlaceFinder.setBackground(Color.WHITE);
			add(pnlPlaceFinder,BorderLayout.CENTER);

			lblPlaceFinder = new JLabel("Place Finder");
			lblPlaceFinder.setFont(new Font("Basic", Font.BOLD, 28));
			lblPlaceFinder.setBounds(115,y1,170,h);
			pnlPlaceFinder.add(lblPlaceFinder);

			y1=y1+gap1+h;

			cmbCountry = new JComboBox();
			cmbCountry.setBounds(50,y1,250,h);
			cmbCountry.setFont(new Font("Basic", Font.BOLD, 18));
			pnlPlaceFinder.add(cmbCountry);
			cmbCountry.addActionListener(this);

			y1=y1+gap1+h;

			cmbState = new JComboBox();
			cmbState.setBounds(50,y1,250,h);
			cmbState.setFont(new Font("Basic", Font.BOLD, 18));
			pnlPlaceFinder.add(cmbState);
			cmbState.addActionListener(this);

			y1=y1+gap1+h;

			cmbDistrict= new JComboBox();
			cmbDistrict.setBounds(50,y1,250,h);
			cmbDistrict.setFont(new Font("Basic", Font.BOLD, 18));
			pnlPlaceFinder.add(cmbDistrict);
			cmbDistrict.addActionListener(this);

			y1=y1+gap1+h;

			cmbTaluka= new JComboBox();
			cmbTaluka.setBounds(50,y1,250,h);
			cmbTaluka.setFont(new Font("Basic", Font.BOLD, 18));
			pnlPlaceFinder.add(cmbTaluka);
			cmbTaluka.addActionListener(this);

			ImageIcon imgIcon1 = new ImageIcon("imagesrc\\imgNewDoc.png");
			Image image1 = imgIcon1.getImage();
			Image newimage1 = image1.getScaledInstance(48,45,java.awt.Image.SCALE_SMOOTH);
			Icon imgNewDoc = new ImageIcon(newimage1);
			btnNewTalukaDoc = new JButton(imgNewDoc);
			btnNewTalukaDoc.setBounds(310,y1-7,48,45);
			btnNewTalukaDoc.addActionListener(this);
			btnNewTalukaDoc.setBackground(Color.WHITE);
			btnNewTalukaDoc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			pnlPlaceFinder.add(btnNewTalukaDoc);

			ImageIcon imgIcon2 = new ImageIcon("imagesrc\\imgRefreshDoc.png");
			Image image2 = imgIcon2.getImage();
			Image refreshimage2 = image2.getScaledInstance(48,45,java.awt.Image.SCALE_SMOOTH);
			Icon imgRefreshDoc = new ImageIcon(refreshimage2);
			btnRefreshTalukaDoc = new JButton(imgRefreshDoc);
			btnRefreshTalukaDoc.setBounds(310,y1-7,48,45);
			btnRefreshTalukaDoc.setBackground(Color.WHITE);
			btnRefreshTalukaDoc.addActionListener(this);
			btnRefreshTalukaDoc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			pnlPlaceFinder.add(btnRefreshTalukaDoc);

			y1=y1+gap1+h;

			chbVillagian=new JCheckBox("Are you Villagian ?");
			chbVillagian.setBounds(50,y1,250,h);
			chbVillagian.setFont(new Font("Basic", Font.BOLD, 18));
			pnlPlaceFinder.add(chbVillagian);
			chbVillagian.addActionListener(this);

			y1=y1+gap1+h;

			cmbVillage= new JComboBox();
			cmbVillage.setBounds(50,y1,250,h);
			cmbVillage.setFont(new Font("Basic", Font.BOLD, 18));
			pnlPlaceFinder.add(cmbVillage);
			cmbVillage.setEnabled(false);

			btnNewVillageDoc = new JButton(imgNewDoc);
			btnNewVillageDoc.setBounds(310,y1-7,48,45);
			btnNewVillageDoc.addActionListener(this);
			btnNewVillageDoc.setBackground(Color.WHITE);
			btnNewVillageDoc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			pnlPlaceFinder.add(btnNewVillageDoc);
			btnNewVillageDoc.setEnabled(false);


			btnRefreshVillageDoc = new JButton(imgRefreshDoc);
			btnRefreshVillageDoc.setBounds(310,y1-7,48,45);
			btnRefreshVillageDoc.setBackground(Color.WHITE);
			btnRefreshVillageDoc.addActionListener(this);
			btnRefreshVillageDoc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			pnlPlaceFinder.add(btnRefreshVillageDoc);
			btnRefreshVillageDoc.setEnabled(false);


			y1=y1+gap1+h;

			lblPlaceSelection = new JLabel("No Place Selected");
			lblPlaceSelection.setBounds(50,y1,250,h);
			lblPlaceSelection.setFont(new Font("Basic", Font.BOLD, 18));
			pnlPlaceFinder.add(lblPlaceSelection);

			y1=y1+gap1+h;

			btnSelectAndClose = new JButton("Select & Close");
			btnSelectAndClose.setBounds(110,y1,180,h);
			btnSelectAndClose.setFont(new Font("Basic", Font.BOLD, 18));
			pnlPlaceFinder.add(btnSelectAndClose);
			btnSelectAndClose.addActionListener(this);

			addCountryRecords(cmbCountry);
			show();

		}
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource() == btnSelectAndClose)
			{
				if(cmbCountry.getSelectedIndex() == 0 || cmbState.getSelectedIndex() == 0 || cmbDistrict.getSelectedIndex() == 0 || cmbTaluka.getSelectedIndex() == 0)
				{
						JOptionPane.showMessageDialog(null,"Select Valid Country or State or District or Taluka....!");
				}
				else
				{

				}
			}
			else if(ae.getSource() == cmbCountry)
			{
				String mCountry = (String)cmbCountry.getSelectedItem();
				int mCountryID = clsCountry.getIDFromName(mCountry);
				addStateRecords(cmbState,mCountryID);
			}
			else if(ae.getSource() == cmbState)
			{
				String mState = (String)cmbState.getSelectedItem();
				int mStateID = clsState.getIDFromName(mState);
				addDistrictRecords(cmbDistrict,mStateID);
			}
			else if(ae.getSource() == cmbDistrict)
			{
				String mDistrict = (String) cmbDistrict.getSelectedItem();
				int mDistrictID = clsDistrict.getIDFromName(mDistrict);
				addTalukaRecords(cmbTaluka,mDistrictID);
			}
			else if(ae.getSource() == cmbTaluka)
			{
				String mTaluka = (String) cmbTaluka.getSelectedItem();
				int mTalukaID = clsTaluka.getIDFromName(mTaluka);
				addVillageRecords(cmbVillage,mTalukaID);
			}

			else if(ae.getSource() == btnSelectAndClose)
			{
			}
			else if(ae.getSource() == chbVillagian)
			{
				cmbVillage.setEnabled(true);
				btnRefreshVillageDoc.setEnabled(true);
				btnNewVillageDoc.setEnabled(true);
			}

		}

		void addRootStopRecords(JComboBox temp)
		{
			//clsRootStop.addRootStopRecords(temp);
		}
		void addCountryRecords(JComboBox temp)
		{
			clsCountry.addCountryRecords(temp);
		}

		void addStateRecords(JComboBox temp,int mCountryID)
		{
			clsState.addStateRecords(temp,mCountryID);
		}

		void addDistrictRecords(JComboBox temp,int mStateID)
		{
			clsDistrict.addDistrictRecords(temp,mStateID);
		}

		void addTalukaRecords(JComboBox temp,int mDistrictID)
		{
			clsTaluka.addTalukaRecords(temp,mDistrictID);
		}

		void addVillageRecords(JComboBox temp,int mTalukaID)
		{
			clsVillage.addVillageRecords(temp,mTalukaID);
		}


		public static void main(String args[])
		{
			frmPlaceFinder F = new frmPlaceFinder();
		}
}