package com;
import com.Handler.LoginHandler;

import javax.swing.*;
import java.awt.*;


public class MainForm extends JFrame{

    JLabel nameLabel = new JLabel("物业管理系统",JLabel.CENTER);

    SpringLayout springLayout = new SpringLayout();
    JPanel centerPanel = new JPanel(springLayout);
    JLabel userNameLabel = new JLabel("用户名:");
    JTextField userTxt = new JTextField();
    JLabel pwdLabel = new JLabel("密码：");
    JPasswordField pwdField = new JPasswordField();
    JButton loginButton = new JButton("登录");
    JButton resetButton = new JButton("重置");

    LoginHandler loginHandler;
    public MainForm() {
        super("物业管理系统");
        loginHandler = new LoginHandler(this);
        Container contentPane = getContentPane();
        //设置组件样式
        nameLabel.setFont(new Font("华文行楷",Font.PLAIN,50));
        nameLabel.setPreferredSize(new Dimension(0,100));
        Font centerFont = new Font("楷体",Font.PLAIN,30);
        userNameLabel.setFont(centerFont);
        userTxt.setPreferredSize(new Dimension(200,30));
        userTxt.setFont(new Font("宋体", Font.BOLD, 18));
        pwdLabel.setFont(centerFont);
        pwdField.setFont(new Font("宋体", Font.BOLD, 18));
        pwdField.setPreferredSize(new Dimension(200,30));
        loginButton.setFont(centerFont);
        resetButton.setFont(centerFont);

        //将组件加入面板
        centerPanel.add(userNameLabel);
        centerPanel.add(userTxt);
        centerPanel.add(pwdLabel);
        centerPanel.add(pwdField);
        centerPanel.add(loginButton);
        //设置监听器
        loginButton.addActionListener(loginHandler);
        centerPanel.add(resetButton);
        resetButton.addActionListener(loginHandler);
        //设置弹式布局
        layoutCenter();

        //将面板加入容器
        contentPane.add(nameLabel,BorderLayout.NORTH);
        contentPane.add(centerPanel,BorderLayout.CENTER);
        setResizable(true);

    }

    private void layoutCenter() {
        //布局userNameLabel
        Spring childWidth = Spring.sum(Spring.sum(Spring.width(userNameLabel),Spring.width(userTxt)), Spring.constant(20));
        int offsetX = childWidth.getValue() / 2;

        springLayout.putConstraint(SpringLayout.WEST,userNameLabel,-offsetX,SpringLayout.HORIZONTAL_CENTER,centerPanel);
        springLayout.putConstraint(SpringLayout.NORTH,userNameLabel,20,SpringLayout.NORTH,centerPanel);
        //布局userTxt
        springLayout.putConstraint(SpringLayout.WEST,userTxt,20,SpringLayout.EAST,userNameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,userTxt,0,SpringLayout.NORTH,userNameLabel);
        //布局pwdLabel
        springLayout.putConstraint(SpringLayout.EAST,pwdLabel,0,SpringLayout.EAST,userNameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,pwdLabel,20,SpringLayout.SOUTH,userNameLabel);
        //布局pwdField
        springLayout.putConstraint(SpringLayout.WEST,pwdField,20,SpringLayout.EAST,pwdLabel);
        springLayout.putConstraint(SpringLayout.NORTH,pwdField,0,SpringLayout.NORTH,pwdLabel);
        //布局loginButton
        springLayout.putConstraint(SpringLayout.WEST,loginButton,50,SpringLayout.WEST,pwdLabel);
        springLayout.putConstraint(SpringLayout.NORTH,loginButton,60,SpringLayout.NORTH,pwdLabel);
        //布局resetButton
        springLayout.putConstraint(SpringLayout.WEST,resetButton,50,SpringLayout.EAST,loginButton);
        springLayout.putConstraint(SpringLayout.NORTH,resetButton,0,SpringLayout.NORTH,loginButton);
    }


    public JTextField getUserTxt() {
        return userTxt;
    }


    public JPasswordField getPwdField() {
        return pwdField;
    }


    public static void main(String[] args) {

        MainForm mainform = new MainForm();
        mainform.setSize(300,200);
        mainform.setLayout(new FlowLayout());
        mainform.add(new JButton("button"));
// 去掉java自带边框
        mainform.setUndecorated(true);
//背景透明
        mainform.setBackground(new Color(0,0,0,0));
//设置窗口居中
        mainform.setLocationRelativeTo(null);
        mainform.setVisible(true);
    }
}
