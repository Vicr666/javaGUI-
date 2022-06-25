package com.View.total;

import com.utils.con_mysql.con_mysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

class Repair_totalViewModel extends DefaultTableModel {

    static Vector<String> columns = new Vector<>();
    static {
        columns.addElement("小区号");
        columns.addElement("楼号");
        columns.addElement("用户");
        columns.addElement("报修信息");

    }
    private Repair_totalViewModel() {
        super(null, columns);
    }

    private static Repair_totalViewModel repair_totalViewModel = new Repair_totalViewModel();
    public static Repair_totalViewModel updateModel(Vector<Vector<Object>> data) {
        repair_totalViewModel.setDataVector(data,columns);
        return repair_totalViewModel;
    }

    public static Vector<String> getColumns() {
        return columns;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

public class Repair_totalView extends JFrame {

    public JScrollPane userPanel;
    public Repair_totalView(int auto_width, int auto_height,int menuheight) {
        super("报修统计");
        String sql = "select house_id,commnuity_id ,info, username from Repair_total";
        String str[] = {"house_id", "commnuity_id","info", "username"};
        Vector<Vector<Object>> data = new con_mysql().getresult(sql, str);

        //jtable和table关联
        Repair_totalViewModel repair_totalViewModel = Repair_totalViewModel.updateModel(data);
        JTable Usertable = new JTable(repair_totalViewModel);
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
        Repair_totalViewCellRender repair_totalViewCellRender = new Repair_totalViewCellRender();
        Vector<String> columns = Repair_totalViewModel.getColumns();
        for (int i = 0; i < columns.size(); i ++ ) {
            TableColumn column = Usertable.getColumn(columns.get(i));
            column.setCellRenderer(repair_totalViewCellRender);
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