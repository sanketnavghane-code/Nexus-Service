import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class frmRootStopDetail extends JFrame
{
	JPanel pnlUI;
	int Rcols;
	ReportTool tool;
	JButton btnClose;
	JPanel pnlClose;

	clsRoot currentRoot;

	frmRootStopDetail(clsRoot currentRoot)
	{
		this.currentRoot=currentRoot;
		setSize(600,600);
		setLocation(700,300);
		setLayout(new BorderLayout());
		setBackground(ColorSetting.getBackColorFrame());
		setTitle("Bus Root Details : "+currentRoot.getRootName());


		pnlUI = new JPanel();
		pnlUI.setLayout(new BorderLayout());
		pnlUI.setBackground(Color.WHITE);
		add(pnlUI,BorderLayout.CENTER);


		tool = new ReportTool(100,100);
		pnlUI.add(tool,BorderLayout.CENTER);

		pnlClose = new JPanel();
		pnlClose.setBackground(Color.WHITE);
		add(pnlClose,BorderLayout.SOUTH);


		btnClose=new JButton("CLOSE");
		btnClose.setBackground(Color.RED);
		pnlClose.add(btnClose);
		btnClose.setFont(new Font("Arial",Font.BOLD, 16));
		btnClose.addActionListener(e -> {

			dispose();

			});


		//pnlUI.setLayout(null);


		createReport();
		setColumnsData();

		show();

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
		Rcols+=tool.addNewColumn("Sr. No.");
		Rcols+=tool.addNewColumn("Station Name");
		Rcols+=tool.addNewColumn("Stop Time");
	}

	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth()
	{
		tool.setColumnWidth("Sr. No.",80);
		tool.setColumnWidth("Station Name",200);
		tool.setColumnWidth("Stop Time",100);
	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsRootStopReport Data[]=clsRootStopReport.getAllRootStopReportInformation(currentRoot.getRootID());

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getTalukaName();
			Objectdata[2]=Data[i].getStopTime()+" Minutes";

			tool.addNewRow(Objectdata);
		}
	}


	public static void main(String args[])
	{
		clsRoot temp = clsRoot.getRootInformation(4);
		frmRootStopDetail F = new frmRootStopDetail(temp);
	}
}