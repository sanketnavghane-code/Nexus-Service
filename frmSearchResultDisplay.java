import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class frmSearchResultDisplay extends JFrame
{
	JPanel pnlUI;
	int Rcols;
	ReportTool tool;
	JButton btnClose;
	JButton btnShowDetails;
	JPanel pnlBottom;
	int vSearchStationID=0;
	JTable MyTable;

	frmSearchResultDisplay(String currentStation)
	{
		setSize(800,600);
		setLocation(700,300);
		setLayout(new BorderLayout());
		setBackground(ColorSetting.getBackColorFrame());
		setTitle("Bus Station : "+currentStation);

		vSearchStationID=clsTaluka.getIDFromName(currentStation);

		if(vSearchStationID <= 0)
		{
			JOptionPane.showMessageDialog(null,"Station Not Found....!");
			dispose();
		}

		pnlUI = new JPanel();
		pnlUI.setLayout(new BorderLayout());
		pnlUI.setBackground(Color.WHITE);
		add(pnlUI,BorderLayout.CENTER);

		dispose();

		tool = new ReportTool(100,100);
		pnlUI.add(tool,BorderLayout.CENTER);
		MyTable = tool.getTable();

		pnlBottom = new JPanel();
		pnlBottom.setLayout(new GridLayout(1,2,5,5));
		pnlBottom.setBackground(Color.WHITE);
		add(pnlBottom,BorderLayout.SOUTH);

		btnShowDetails=new JButton("Show Details");
		btnShowDetails.setBackground(Color.WHITE);
		btnShowDetails.setBounds(50,10,100,50);
		btnShowDetails.setFont(new Font("Arial",Font.BOLD, 16));
		pnlBottom.add(btnShowDetails);
		btnShowDetails.addActionListener(e -> {
			int selectedRow = MyTable.getSelectedRow();
			int selectedColumn = MyTable.getSelectedColumn();

			if (selectedRow != -1 && selectedColumn != -1)
			{
				Object selectedValue = MyTable.getValueAt(selectedRow, 0);
				int mRootID=(int)selectedValue;
				clsRoot temp =clsRoot.getRootInformation(mRootID);
				frmRootStopDetail A = new frmRootStopDetail(temp);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No cell selected.");
			}
		});

		btnClose=new JButton("CLOSE");
		btnClose.setBackground(Color.RED);
		btnClose.setBounds(200,10,100,50);
		pnlBottom.add(btnClose);
		btnClose.setFont(new Font("Arial",Font.BOLD, 16));
		btnClose.addActionListener(e -> {
			dispose();
			});

		createReport();
		setColumnsData();

		show();

	}


//Report for root

	void createReport()
	{
		setColumnsHeading();
		setColumnsAlignment();
		setColumnsWidth();
		setColumnsData();
	}

	void setColumnsHeading()
	{
		Rcols=0;
		Rcols+=tool.addNewColumn("RootID");
		Rcols+=tool.addNewColumn("Root_Name");
		Rcols+=tool.addNewColumn("Start_Time");
		Rcols+=tool.addNewColumn("Source_Station_Name");
		Rcols+=tool.addNewColumn("Destination_Station_Name");
		Rcols+=tool.addNewColumn("Villagian");
	}

	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_LEFT);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(4,ReportTool.ALIGN_LEFT);
		tool.setColumnAlignment(5,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth()
	{
		tool.setColumnWidth("RootID",100);
		tool.setColumnWidth("Root_Name",550);
		tool.setColumnWidth("Start_Time",120);
		tool.setColumnWidth("Source_Station_Name",300);
		tool.setColumnWidth("Destination_Station_Name",300);
		tool.setColumnWidth("Villagian",150);
	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsRootReport Data [] = clsRootReport.getAllRootReportInformation(vSearchStationID);

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getRootName();
			Objectdata[2]=Data[i].getStartTime()+" "+Data[i].getTimeShiftText();
			Objectdata[3]=Data[i].getSourceStationName();
			Objectdata[4]=Data[i].getDestinationStationName();
			Objectdata[5]=Data[i].getVillagianText();

			tool.addNewRow(Objectdata);
		}
	}


	public static void main(String args[])
	{
		frmSearchResultDisplay F = new frmSearchResultDisplay("12345");
	}
}