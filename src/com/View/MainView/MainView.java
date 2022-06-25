package com.View.MainView;


import com.Handler.PropertyfeesHandler;
import com.Handler.UserManageHandler;
import com.Handler.repairManageHandler;
import com.Handler.totalHandler.total_Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class MainView extends JFrame {

    //基本信息管理
    public JScrollPane jp2;
    public static boolean usermanage;
    public static boolean housemanage;
    public static boolean Charge_Standard_Management;

    //统计查询
    public static boolean charge_total;
    public static boolean repair_total;

    //添加菜单栏
    public static int auto_width = 1000;
    public static int auto_height = 30;
    public JPanel root;

    JMenuBar mb = new JMenuBar();
    JMenu menu1 = new JMenu("基本信息管理");
    JMenu menu2 = new JMenu("物业费收缴管理");
    JMenu menu3 = new JMenu("报修信息");
    JMenu menu4 = new JMenu("统计查询");

    JMenuItem menu1_1 = new JMenuItem("用户管理");
    JMenuItem menu1_2 = new JMenuItem("房产管理");
    JMenuItem menu1_3 = new JMenuItem("收费标准管理");
    JMenuItem menu2_1 = new JMenuItem("收缴管理");

    JMenuItem menu3_1 = new JMenuItem("报修管理");

    JMenuItem menu4_1 = new JMenuItem("收费统计");
    JMenuItem menu4_2 = new JMenuItem("报修统计");


    UserManageHandler usermanagehandler;
    PropertyfeesHandler propertyfeesHandler;
    repairManageHandler repairmanagehandler;
    total_Handler total_handler;

    public MainView() {

        super("物业信息管理系统");
        Container contentPane = getContentPane();

        usermanagehandler = new UserManageHandler(this);
        propertyfeesHandler = new PropertyfeesHandler(this);
        repairmanagehandler = new repairManageHandler(this);
        total_handler = new total_Handler(this);
        root = new JPanel();
//        JScrollPane jp2 = new JScrollPane();
        root.setLayout(null);
        this.setContentPane(root);

        //设置字体大小
        setFont();

        //将组件添加至菜单栏
        mb.add(menu1);
        mb.add(menu2);
        mb.add(menu3);
        mb.add(menu4);

        //将菜单栏加入面板
        root.add(mb);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        setVisible(true);
        root.setLayout(null);

    }

    private void setFont() {
        menu1_1.addActionListener(usermanagehandler);
        menu1.add(menu1_1);
        menu1_2.addActionListener(usermanagehandler);
        menu1.add(menu1_2);
        menu1_3.addActionListener(usermanagehandler);
        menu1.add(menu1_3);
        menu1.addSeparator();
        menu2_1.addActionListener(propertyfeesHandler);
        menu2.add(menu2_1);
        menu2.addSeparator();
        menu3_1.addActionListener(repairmanagehandler);
        menu3.add(menu3_1);
        menu3.addSeparator();

        menu4_1.addActionListener(total_handler);
        menu4.add(menu4_1);
        menu4_2.addActionListener(total_handler);
        menu4.add(menu4_2);
        menu4.addSeparator();

    }

    public void update(MainView mainview) {
        mainview.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                mainview.auto_width = mainview.getSize().width;
                mainview.auto_height = mainview.getSize().height;
                mb.setBounds(0,0,auto_width,(int)(auto_height * 0.05));
                menu1.setFont(new Font("宋体", Font.BOLD, (int)(auto_height * 0.08) / 2));
                menu2.setFont(new Font("宋体", Font.BOLD, (int)(auto_height * 0.08) / 2));
                menu3.setFont(new Font("宋体", Font.BOLD, (int)(auto_height * 0.08) / 2));
                menu4.setFont(new Font("宋体", Font.BOLD, (int)(auto_height * 0.08) / 2));
                menu1_1.setFont(new Font("宋体", Font.BOLD, (int)(auto_height * 0.08) / 2));
                menu1_2.setFont(new Font("宋体", Font.BOLD, (int)(auto_height * 0.08) / 2));
                menu1_3.setFont(new Font("宋体", Font.BOLD, (int)(auto_height * 0.08) / 2));
                menu2_1.setFont(new Font("宋体", Font.BOLD, (int)(auto_height * 0.08) / 2));
                menu3_1.setFont(new Font("宋体", Font.BOLD, (int)(auto_height * 0.08) / 2));
                menu4_1.setFont(new Font("宋体", Font.BOLD, (int)(auto_height * 0.08) / 2));
                menu4_2.setFont(new Font("宋体", Font.BOLD, (int)(auto_height * 0.08) / 2));

                if(usermanage) {
                    //如果usermange存在则动态更新
                    root.remove(jp2);//删除panel1中原有的组件
                    jp2.setBounds(0, (int)(auto_height * 0.05), auto_width, auto_height - (int)(auto_height * 0.05));
                    root.add(jp2);//panel1添加新的组件
                } else if(housemanage) {
                    root.remove(jp2);//删除panel1中原有的组件
                    jp2.setBounds(0, (int)(auto_height * 0.05), auto_width, auto_height - (int)(auto_height * 0.05));
                    root.add(jp2);//panel1添加新的组件
                } else if(Charge_Standard_Management) {
                    root.remove(jp2);//删除panel1中原有的组件
                    jp2.setBounds(0, (int)(auto_height * 0.05), auto_width, auto_height - (int)(auto_height * 0.05));
                    root.add(jp2);//panel1添加新的组件
                } else if(charge_total) {
                    root.remove(jp2);//删除panel1中原有的组件
                    jp2.setBounds(0, (int)(auto_height * 0.05), auto_width, auto_height - (int)(auto_height * 0.05));
                    root.add(jp2);//panel1添加新的组件
                } else if (repair_total){
                    root.remove(jp2);//删除panel1中原有的组件
                    jp2.setBounds(0, (int)(auto_height * 0.05), auto_width, auto_height - (int)(auto_height * 0.05));
                    root.add(jp2);//panel1添加新的组件
                }
            }
        });
    }


}