package com.View.basic_infoManage.Charge_Standard_Management;


import com.View.MainView.MainView;
import com.View.basic_infoManage.HouseMagage.HouseManageCellRender;
import com.utils.con_mysql.con_mysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

class Charge_Standard_ManagementModel extends DefaultTableModel {

    static Vector<String> columns = new Vector<>();
    static {
        columns.addElement("收费项目");
        columns.addElement("价格");
    }
    private Charge_Standard_ManagementModel() {
        super(null, columns);
    }

    private static Charge_Standard_ManagementModel houseManageModel = new Charge_Standard_ManagementModel();
    public static Charge_Standard_ManagementModel updateModel(Vector<Vector<Object>> data) {
        houseManageModel.setDataVector(data,columns);
        return houseManageModel;
    }

    public static Vector<String> getColumns() {
        return columns;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}



public class Charge_Standard_Management extends JFrame {

    private Vector<Vector<Object>> data;

    public JTable getUsertable_copy() {
        return Usertable_copy;
    }

    private JTable Usertable_copy;
    public void setData(Vector<Vector<Object>> data) {
        this.data = data;
    }

    public JScrollPane userPanel;
    public Charge_Standard_Management(int auto_width, int auto_height,int menuheight) {
        super("收费信息管理");

        String sql = "select Charge, price from Charge_Standard_Management";
        String str[] = {"Charge", "price"};
        Vector<Vector<Object>> data = new con_mysql().getresult(sql, str);

        //jtable和table关联
        Charge_Standard_ManagementModel charge_standard_managementModel = Charge_Standard_ManagementModel.updateModel(data);
        JTable Usertable = new JTable(charge_standard_managementModel);
        Usertable_copy = Usertable;
        //设置表头
        JTableHeader tableHeader = Usertable.getTableHeader();
        tableHeader.setFont(new Font(null,Font.BOLD, MainView.auto_width / 50));
        tableHeader.setForeground(Color.red);
        //设置表格体
        Usertable.setFont(new Font(null,Font.PLAIN, MainView.auto_width / 50));
        Usertable.setForeground(Color.black);
        Usertable.setGridColor(Color.BLACK);
        Usertable.setRowHeight(30);

        //设置表格列的渲染方式
        HouseManageCellRender houseManageCellRender = new HouseManageCellRender();
        Vector<String> columns = Charge_Standard_ManagementModel.getColumns();
        for (int i = 0; i < columns.size(); i ++ ) {
            TableColumn column = Usertable.getColumn(columns.get(i));
            column.setCellRenderer(houseManageCellRender);
        }

        //表格建好后要加入到内容面板里,且Jtable要放在滚动面板上:  Container <- JScrollPane <- jtable

        JScrollPane jScrollPane = new JScrollPane(Usertable);
        jScrollPane.setVisible(true);
        jScrollPane.setSize(200,100);
        jScrollPane.setBounds(0, menuheight, auto_width, auto_height - menuheight);
        userPanel = jScrollPane;
    }

    public static void main(String[] args) {
    }
}