package com.View.PropertyfesManage;

import com.Dao.UserDao;
import com.Handler.Property.Update_PropertyHandler;

import javax.swing.*;
import java.awt.*;

public class updatePropertyView extends JDialog {
    JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,20));
    JLabel idLabel = new JLabel("楼号:",JLabel.RIGHT);
    JTextField idLabel_Txt = new JTextField();
    JLabel namelabel = new JLabel("姓名:",JLabel.RIGHT);
    JTextField name_Txt = new JTextField();
    JLabel house_id = new JLabel("楼号:",JLabel.RIGHT);
    JTextField house_id_Txt = new JTextField();
    JLabel money = new JLabel("需缴:",JLabel.RIGHT);
    JTextField money_txt = new JTextField();
    JLabel commnuity_id = new JLabel("小区号:",JLabel.RIGHT);
    JTextField commnuity_id_Txt = new JTextField();

    JButton UpdateButton = new JButton("保存");
    Update_PropertyHandler update_propertyHandler;
    public updatePropertyView(Propertyfees py) {
        super(py,"修改用户信息",true);

        update_propertyHandler = new Update_PropertyHandler(this, py);
        Container contentPane = getContentPane();
        //设置大小、样式
        setSize();
        contentPane.add(jPanel);

        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }

    private void setSize() {

        namelabel.setPreferredSize(new Dimension(80,30));
        namelabel.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(namelabel);
        name_Txt.setPreferredSize(new Dimension(200,30));
        name_Txt.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(name_Txt);

        house_id.setPreferredSize(new Dimension(80,30));
        house_id.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(house_id);
        house_id_Txt.setPreferredSize(new Dimension(200,30));
        house_id_Txt.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(house_id_Txt);

        money.setPreferredSize(new Dimension(80,30));
        money.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(money);
        money_txt.setPreferredSize(new Dimension(200,30));
        money_txt.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(money_txt);

        commnuity_id.setPreferredSize(new Dimension(80,30));
        commnuity_id.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(commnuity_id);
        commnuity_id_Txt.setPreferredSize(new Dimension(200,30));
        commnuity_id_Txt.setFont(new Font("宋体", Font.BOLD, 18));
        jPanel.add(commnuity_id_Txt);
        UpdateButton.addActionListener(update_propertyHandler);
        UpdateButton.setPreferredSize(new Dimension(200,30));

        jPanel.add(UpdateButton);
    }

    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setUsername(name_Txt.getText());
        userDao.setCommnuity_id(commnuity_id_Txt.getText());
        userDao.setHouse_id(house_id_Txt.getText());
        userDao.setMoney(money_txt.getText());
        return userDao;
    }

    public static void main(String[] args) {
    }
}
