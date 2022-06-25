package com.View.basic_infoManage.UserManage;


import com.utils.con_mysql.con_mysql;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;

import java.util.Vector;

class UserManageModel extends DefaultTableModel {

    static Vector<String> columns = new Vector<>();
    static {
        columns.addElement("用户ID");
        columns.addElement("姓名");
        columns.addElement("性别");
        columns.addElement("楼号");

    }
    private UserManageModel() {
        super(null, columns);
    }

    private static UserManageModel usermanagemodel = new UserManageModel();
    public static UserManageModel updateModel(Vector<Vector<Object>> data) {
        usermanagemodel.setDataVector(data,columns);
        return usermanagemodel;
    }

    public static Vector<String> getColumns() {
        return columns;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

public class UserManage extends JFrame{

    public JScrollPane userPanel;
    public UserManage(int auto_width, int auto_height,int menuheight) {
        super("用户管理");
        String sql = "select id,userName ,sex, house_id from user_manage";
        String str[] = {"id", "userName","sex", "house_id"};
        Vector<Vector<Object>> data = new con_mysql().getresult(sql, str);


        //jtable和table关联
        UserManageModel userManageModel = UserManageModel.updateModel(data);
        JTable Usertable = new JTable(userManageModel);
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
        UserManageCellRender userManageCellRender = new UserManageCellRender();
        Vector<String> columns = UserManageModel.getColumns();
        for (int i = 0; i < columns.size(); i ++ ) {
            TableColumn column = Usertable.getColumn(columns.get(i));
            column.setCellRenderer(userManageCellRender);
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
