import myUtility.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import screensetting.*;
import ReportUtility.*;

public class rptEmployee extends JFrame implements ActionListener
{

	JLabel lblProjectName 		;

	JTextField txtCountryID 	;
	JTextField txtCountryName 	;

	JPanel  pnlInfo1 			;
	JLabel  lblInfo1 			;

	JPanel  pnlInfo2 			;
	JLabel lblInfo2 			;

	JPanel pnlInfo3             ;
	JLabel lblInfo3             ;

	JPanel pnlInfo4            ;
	JLabel lblInfo4           ;

	JPanel pnlInfo5            ;
	JLabel lblInfo5           ;

	JPanel pnlInfo6            ;
	JLabel lblInfo6           ;

	JPanel pnlInfo7            ;
	JLabel lblInfo7           ;


	JPanel  pnlSave 			;
	JPanel  pnlEdit 			;
	JPanel  pnlCancel 			;
	JPanel  pnlReport 			;
	JPanel  pnlClose			;
	JPanel  pnlUIReport 		;


	JButton btnSave 			;
	JButton btnEdit 			;
	JButton btnCancel 			;
	JButton btnReport 			;
	JButton btnClose 			;


	ReportDesign myUI			;


	int Rcols = 0 				;

	ReportTool tool				;


    public rptEmployee()
    {
		setTitle("New Project");
		setSize(1920,1080);
		setLayout(null);
		setLocation(0,0);

		myUI = new ReportDesign();
		add(myUI);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);



		pnlUIReport = myUI.getpnlUIReport();
		tool = new ReportTool(100,100);
		tool.setBounds(10,10,500,300);
		pnlUIReport.add(tool);

		UISetting.setArea(pnlUIReport,560,460);


		pnlInfo1 = myUI.getInfo1Panel();
		lblInfo1 = myUI.getInfo1Label();
		lblInfo1.setText("Info1");
		lblInfo1.setForeground(Color.WHITE);
		pnlInfo1.add(lblInfo1);

        pnlInfo2 = myUI.getInfo2Panel();
        lblInfo2= myUI.getInfo2Label();
        lblInfo2.setText("lblInfo2");
		lblInfo2.setForeground(Color.WHITE);

		pnlInfo3 = myUI.getInfo3Panel();
		lblInfo3 = myUI.getInfo3Label();
		lblInfo3.setText("lblInfo3");
		lblInfo3.setForeground(Color.WHITE);

		pnlInfo4 = myUI.getInfo4Panel();
		lblInfo4= myUI.getInfo4Label();
		lblInfo4.setText("lblInfo4");
		lblInfo4.setForeground(Color.WHITE);

		pnlInfo5 = myUI.getInfo5Panel();
    	lblInfo5= myUI.getInfo5Label();
		lblInfo5.setText("lblInfo5");
		lblInfo5.setForeground(Color.WHITE);

    	pnlInfo6 = myUI.getInfo6Panel();
    	lblInfo6= myUI.getInfo6Label();
    	lblInfo6.setText("lblInfo6");
		lblInfo6.setForeground(Color.WHITE);

    	pnlInfo7 = myUI.getInfo7Panel();
    	lblInfo7= myUI.getInfo7Label();
		lblInfo7.setText("lblInfo7");
		lblInfo7.setForeground(Color.WHITE);


		pnlReport = myUI.getReportPanel();
		pnlClose = myUI.getClosePanel();
		pnlUIReport = myUI.getpnlUIReport();

		btnReport = myUI.getReportButton();
		btnReport.addActionListener(this);

		btnClose= myUI.getCloseButton();
		btnClose.addActionListener(this);


		lblProjectName = myUI.getlblProgramHeading();
		new BlinkLabel(lblProjectName,500);


		setDefaultOperation();
		createReport();



		setVisible(true);
	}

	void setDefaultOperation()
	{
		PanelState.enabledComponents(pnlReport);

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
		Rcols+=tool.addNewColumn("EmployeeID");
		Rcols+=tool.addNewColumn("Name");
		Rcols+=tool.addNewColumn("Address");
		Rcols+=tool.addNewColumn("PinCode");
		Rcols+=tool.addNewColumn("AreaID");
		Rcols+=tool.addNewColumn("Age");
		Rcols+=tool.addNewColumn("Gender");
		Rcols+=tool.addNewColumn("ContactNo");
		Rcols+=tool.addNewColumn("EmailID");
		Rcols+=tool.addNewColumn("DesignationID");
		Rcols+=tool.addNewColumn("BillaNo");
		Rcols+=tool.addNewColumn("LicenceNo");
		Rcols+=tool.addNewColumn("Villagian");
	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("EmployeeID",80);
		tool.setColumnWidth("Name",600);
		tool.setColumnWidth("Address",600);
		tool.setColumnWidth("PinCode",200);
		tool.setColumnWidth("AreaID",200);
		tool.setColumnWidth("Age",200);
		tool.setColumnWidth("Gender",200);
		tool.setColumnWidth("ContactNo",800);
		tool.setColumnWidth("EmailID",300);
		tool.setColumnWidth("DesignationID",200);
		tool.setColumnWidth("BillaNo",600);
		tool.setColumnWidth("LicenceNo",650);
		tool.setColumnWidth("Villagian",200);
	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsEmployee Data[]=clsEmployee.getAllEmployeeInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getEmployeeName();
			Objectdata[2]=Data[i].getAddress();
			Objectdata[3]=Data[i].getPinCode();
			Objectdata[4]=Data[i].getAreaID();
			Objectdata[5]=Data[i].getAge();
			Objectdata[6]=Data[i].getGender();
			Objectdata[7]=Data[i].getContactNo();
			Objectdata[8]=Data[i].geteMailID();
			Objectdata[9]=Data[i].getDesignationID();
			Objectdata[10]=Data[i].getBillaNo();
			Objectdata[11]=Data[i].getLicenseNo();
			Objectdata[12]=Data[i].getVillagian();


			tool.addNewRow(Objectdata);
		}
	}


	public void actionPerformed(ActionEvent ae)
	{
		 if(ae.getSource()== btnCancel)
		{

		}
		else if(ae.getSource()==btnReport)
		{
			PanelState.visibleComponents(pnlUIReport);
			PanelState.visibleComponents(pnlClose);
			//PanelState.disabledComponents(pnlEntry);
			//PanelState.hideComponents(pnlUI);
			PanelState.hideComponents(pnlReport);
			setColumnsData();



		}
		else if(ae.getSource()==btnClose)
		{
           // PanelState.visibleComponents(pnlUI);
			PanelState.hideComponents(pnlUIReport);
			PanelState.visibleComponents(pnlReport);
			PanelState.hideComponents(pnlClose);
			//bst.setButtonCommonState(ButtonState.ResetState);

		}
		else if(ae.getSource()==btnSave)
		{

		}

		else if(ae.getSource()==btnEdit)
		{


		}


	}
	public static void main(String args[])
	{
		rptEmployee f = new rptEmployee();
	}
}