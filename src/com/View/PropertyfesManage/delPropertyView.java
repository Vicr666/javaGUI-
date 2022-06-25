package com.View.PropertyfesManage;

import com.Dao.UserDao;
import com.Handler.Property.del_propertyHandler;
import javax.swing.*;
import java.awt.*;

public class delPropertyView extends JDialog {
    JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
    JLabel house_id = new JLabel("楼号:", JLabel.RIGHT);
    JTextField house_id_Txt = new JTextField();
//    JLabel commnuity_id = new JLabel("小区号:", JLabel.RIGHT);
//    JTextField commnuity_id_Txt = new JTextField();


    public JTextField getHouse_id_Txt() {
        return house_id_Txt;
    }


//    public JTextField getCommnuity_id_Txt() {
//        return commnuity_id_Txt;
//    }
    JButton delButton = new JButton("确定");
    private del_propertyHandler del_propertyHandler;


    public delPropertyView(Propertyfees py) {
        super(py, "删除用户", true);
        Container contentPane = getContentPane();
        //设置大小、样式
        del_propertyHandler = new del_propertyHandler(this, py);
        setSize();
        contentPane.add(jPanel);

        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }

    private void setSize() {

        house_id.setPreferredSize(new Dimension(80, 30));
        house_id.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(house_id);
        house_id_Txt.setPreferredSize(new Dimension(150, 30));
        house_id_Txt.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(house_id_Txt);

        delButton.setPreferredSize(new Dimension(200, 30));
        delButton.addActionListener(del_propertyHandler);
        jPanel.add(delButton);
    }

    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setUsername(null);
        userDao.setCommnuity_id(null);
        userDao.setHouse_id(house_id_Txt.getText());
        userDao.setMoney(null);
        return userDao;
    }

    public static void main(String[] args) {
    }
}