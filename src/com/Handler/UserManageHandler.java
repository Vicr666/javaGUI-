package com.Handler;


import com.View.MainView.MainView;
import com.View.basic_infoManage.Charge_Standard_Management.Charge_Standard_Management;
import com.View.basic_infoManage.HouseMagage.HouseManage;
import com.View.basic_infoManage.UserManage.UserManage;
import com.service.impl.Property_add_ServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserManageHandler implements ActionListener {

    private MainView mv;

    public UserManageHandler(MainView mv) {
        this.mv = mv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JScrollPane jsp = null;
        JMenuItem JMenuItem = (JMenuItem)e.getSource();
        if("用户管理".equals(JMenuItem.getText())) {
            if(mv.housemanage){
                mv.housemanage = false;
                mv.root.remove(mv.jp2);
            }
            if(mv.Charge_Standard_Management) {
                mv.Charge_Standard_Management = false;
                mv.root.remove(mv.jp2);
            }
            if(mv.usermanage) {
                mv.usermanage = false;
                mv.root.remove(mv.jp2);
            }
            UserManage um = new UserManage(mv.auto_width,mv.auto_height,(int)(mv.auto_height * 0.05));
            jsp = um.userPanel;
            mv.usermanage = true;
            System.out.println("用户管理");
        } else if ("房产管理".equals(JMenuItem.getText())) {
            if(mv.usermanage) {
                mv.usermanage = false;
                mv.root.remove(mv.jp2);
            }
            if(mv.Charge_Standard_Management) {
                mv.Charge_Standard_Management = false;
                mv.root.remove(mv.jp2);
            }
            if(mv.housemanage){
                mv.housemanage = false;
                mv.root.remove(mv.jp2);
            }
            mv.housemanage = true;
            System.out.println("房产管理");
            HouseManage hm = new HouseManage(mv.auto_width,mv.auto_height,(int)(mv.auto_height * 0.05));
            jsp = hm.userPanel;

        } else if("收费标准管理".equals(JMenuItem.getText())) {
            if(mv.usermanage) {
                mv.usermanage = false;
                mv.root.remove(mv.jp2);
            }
            if(mv.housemanage){
                mv.housemanage = false;
                mv.root.remove(mv.jp2);
            }
            if(mv.Charge_Standard_Management) {
                mv.Charge_Standard_Management = false;
                mv.root.remove(mv.jp2);
            }
            mv.Charge_Standard_Management = true;
            System.out.println("收费信息管理");
            Charge_Standard_Management csm = new Charge_Standard_Management(mv.auto_width,mv.auto_height,(int)(mv.auto_height * 0.05));
            jsp = csm.userPanel;
        }

        mv.root.add(jsp);
        mv.jp2 = jsp;


    }

}
