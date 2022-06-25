package com.View.PropertyfesManage;


import com.Handler.Property.*;
import com.utils.con_mysql.con_mysql;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

class PropertyfeesModel extends DefaultTableModel {


    static Vector<String> columns = new Vector<>();
    static {
        columns.addElement("小区号");
        columns.addElement("楼号");
        columns.addElement("业主姓名");
        columns.addElement("应缴总额");
    }
    private PropertyfeesModel() {
        super(null, columns);
    }

    private static PropertyfeesModel propertyfeesmodel = new PropertyfeesModel();
    public static PropertyfeesModel updateModel(Vector<Vector<Object>> data) {
        propertyfeesmodel.setDataVector(data,columns);
        return propertyfeesmodel;
    }

    public static Vector<String> getColumns() {
        return columns;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

class PropertyfeesCellRender extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}

public class Propertyfees extends JFrame{
    JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); //默认流式布局
    JButton addBtn = new JButton("增加");
    JButton updateBtn = new JButton("修改");
    JButton delBtn = new JButton("删除");
    JTextField searchTxt = new JTextField(15);
    JButton searchBtn = new JButton("查询");

    JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton preBtn = new JButton("上一页");
    JButton nextBtn = new JButton("下一页");

    private Vector<Vector<Object>> data;

    public void setData(Vector<Vector<Object>> data) {
        this.data = data;
    }
    private add_PropertyHandler add_propertyHandler;
    private check_PropertyHandler check_propertyHandler;
    Container contentPane;
    public Propertyfees() throws InterruptedException {
        super("物业费管理");
        check_propertyHandler = new check_PropertyHandler(this);
        contentPane = getContentPane();
        //放置北边的布局
        LayoutNorth(contentPane);
        //设置中间的布局
        LayoutCenter(contentPane);
        //放置南边的布局
        LayoutSouth(contentPane);
        String[] str = {"commnuity_id","house_id", "username", "money"};
        data = new con_mysql().getresult("select * from propertyfees", str);

        //jtable和table关联
        setTable(contentPane);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }

    private void setTable(Container contentPane) throws InterruptedException {
        PropertyfeesModel propertyfeesModel = PropertyfeesModel.updateModel(data);
        JTable Usertable = new JTable(propertyfeesModel);
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
        PropertyfeesCellRender propertyfeesCellRender = new PropertyfeesCellRender();
        Vector<String> columns = PropertyfeesModel.getColumns();
        for (int i = 0; i < columns.size(); i ++ ) {
            TableColumn column = Usertable.getColumn(columns.get(i));
            column.setCellRenderer(propertyfeesCellRender);
        }

        //表格建好后要加入到内容面板里,且Jtable要放在滚动面板上:  Container <- JScrollPane <- jtable
        JScrollPane jScrollPane = new JScrollPane(Usertable);
        jScrollPane.setVisible(true);
        jScrollPane.setSize(200,100);
        contentPane.add(jScrollPane);
    }


    public void updateModel() {
        PropertyfeesModel propertyfeesModel = PropertyfeesModel.updateModel(data);
        JTable Usertable = new JTable(propertyfeesModel);
        //设置表头
        JTableHeader tableHeader = Usertable.getTableHeader();
        tableHeader.setFont(new Font(null,Font.BOLD, 16));
        tableHeader.setForeground(Color.red);
        //设置表格体
        Usertable.setFont(new Font(null,Font.PLAIN, 16));
        Usertable.setForeground(Color.black);
        Usertable.setGridColor(Color.BLACK);
        Usertable.setRowHeight(30);

        //设置表格列的渲染方式
        PropertyfeesCellRender propertyfeesCellRender = new PropertyfeesCellRender();
        Vector<String> columns = PropertyfeesModel.getColumns();
        for (int i = 0; i < columns.size(); i ++ ) {
            TableColumn column = Usertable.getColumn(columns.get(i));
            column.setCellRenderer(propertyfeesCellRender);
        }
    }


    public JTextField getSearchTxt() {
        return searchTxt;
    }

    private void LayoutCenter(Container contentPane) {

        JScrollPane jScrollPane = new JScrollPane();
        contentPane.add(jScrollPane,BorderLayout.CENTER);
    }

    private void LayoutSouth(Container contentPane) {
        preBtn.setFont(new Font(null,Font.BOLD, 18));
        southPanel.add(preBtn);
        nextBtn.setFont(new Font(null,Font.BOLD, 18));
        southPanel.add(nextBtn);
        contentPane.add(southPanel,BorderLayout.SOUTH);
    }

    private void LayoutNorth(Container contentPane) {

        addBtn.addActionListener(check_propertyHandler);
        addBtn.setFont(new Font(null,Font.BOLD, 20));
        northPanel.add(addBtn);
        updateBtn.addActionListener(check_propertyHandler);
        updateBtn.setFont(new Font(null,Font.BOLD, 20));
        northPanel.add(updateBtn);
        delBtn.addActionListener(check_propertyHandler);
        delBtn.setFont(new Font(null,Font.BOLD, 20));
        northPanel.add(delBtn);
        searchTxt.setFont(new Font(null,Font.BOLD, 18));
        northPanel.add(searchTxt);
        searchBtn.addActionListener(check_propertyHandler);
        searchBtn.setFont(new Font(null,Font.BOLD, 20));
        northPanel.add(searchBtn);
        contentPane.add(northPanel,BorderLayout.NORTH);
    }


    public static void main(String[] args) throws InterruptedException {
        new Propertyfees();
    }
}
