package com.View.basic_infoManage.HouseMagage;


import com.View.basic_infoManage.UserManage.UserManageCellRender;
import com.utils.con_mysql.con_mysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

class HouseManageModel extends DefaultTableModel {

    static Vector<String> columns = new Vector<>();
    static {
        columns.addElement("房号");
        columns.addElement("房主");
        columns.addElement("面积");
        columns.addElement("状态");
    }
    private HouseManageModel() {
        super(null, columns);
    }

    private static HouseManageModel houseManageModel = new HouseManageModel();
    public static HouseManageModel updateModel(Vector<Vector<Object>> data) {
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


public class HouseManage extends JFrame {

    private Vector<Vector<Object>> data;

    public void setData(Vector<Vector<Object>> data) {
        this.data = data;
    }

    public JScrollPane userPanel;
    public HouseManage(int auto_width, int auto_height,int menuheight) {
        super("房产管理");

        String sql = "select house_id,userName, area,status from house_manage";
        String str[] = {"house_id", "userName","area", "status"};
        Vector<Vector<Object>> data = new con_mysql().getresult(sql, str);

        //jtable和table关联
        HouseManageModel houseManageModel = HouseManageModel.updateModel(data);
        JTable Usertable = new JTable(houseManageModel);
        //设置表头
        JTableHeader tableHeader = Usertable.getTableHeader();
        tableHeader.setFont(new Font(null,Font.BOLD, 20));
        tableHeader.setForeground(Color.red);
        //设置表格体
        Usertable.setFont(new Font(null,Font.PLAIN, 20));
        Usertable.setForeground(Color.black);
        Usertable.setGridColor(Color.BLACK);
        Usertable.setRowHeight(30);

        //设置表格列的渲染方式
        HouseManageCellRender houseManageCellRender = new HouseManageCellRender();
        Vector<String> columns = HouseManageModel.getColumns();
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
