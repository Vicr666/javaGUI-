package com.View.RepairManage;

import com.Dao.UserDao;
import com.Handler.RepairManage.add_RepairHandler;

import javax.swing.*;
import java.awt.*;

public class addRepairView extends JDialog {
    JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,20));
    JLabel namelabel = new JLabel("姓名:",JLabel.RIGHT);
    JTextField name_Txt = new JTextField();
    JLabel house_id = new JLabel("楼号:",JLabel.RIGHT);
    JTextField house_id_Txt = new JTextField();
    JLabel info = new JLabel("报修信息:",JLabel.RIGHT);
    JTextField info_Txt = new JTextField();
    JLabel commnuity_id = new JLabel("小区号:",JLabel.RIGHT);
    JTextField commnuity_id_Txt = new JTextField();

    public JTextField getName_Txt() {
        return name_Txt;
    }

    public JTextField getHouse_id_Txt() {
        return house_id_Txt;
    }

    public JTextField getInfo_Txt() {
        return info_Txt;
    }

    public JTextField getCommnuity_id_Txt() {
        return commnuity_id_Txt;
    }

    JButton addButton = new JButton("添加");

    private add_RepairHandler add_repairHandler;
    public addRepairView(RepairManage rm) {
        super(rm,"添加报修信息",true);
        Container contentPane = getContentPane();
        //设置大小、样式
        add_repairHandler = new add_RepairHandler(this, rm);
        setSize();
        contentPane.add(jPanel);

        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }

    private void setSize() {

        commnuity_id.setPreferredSize(new Dimension(80,30));
        commnuity_id.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(commnuity_id);
        commnuity_id_Txt.setPreferredSize(new Dimension(200,30));
        commnuity_id_Txt.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(commnuity_id_Txt);

        house_id.setPreferredSize(new Dimension(80,30));
        house_id.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(house_id);
        house_id_Txt.setPreferredSize(new Dimension(200,30));
        house_id_Txt.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(house_id_Txt);

        namelabel.setPreferredSize(new Dimension(80,30));
        namelabel.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(namelabel);
        name_Txt.setPreferredSize(new Dimension(200,30));
        name_Txt.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(name_Txt);


        info.setPreferredSize(new Dimension(80,30));
        info.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(info);
        info_Txt.setPreferredSize(new Dimension(200,30));
        info_Txt.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(info_Txt);


        addButton.setPreferredSize(new Dimension(200,30));
        addButton.addActionListener(add_repairHandler);
        jPanel.add(addButton);
    }

    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setUsername(name_Txt.getText());
        userDao.setCommnuity_id(commnuity_id_Txt.getText());
        userDao.setHouse_id(house_id_Txt.getText());
        userDao.setInfo(info_Txt.getText());
        return userDao;
    }

    public static void main(String[] args) {
    }
}