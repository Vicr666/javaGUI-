package com.Handler.totalHandler;

import com.View.MainView.MainView;
import com.View.RepairManage.RepairManage;
import com.View.basic_infoManage.Charge_Standard_Management.Charge_Standard_Management;
import com.View.basic_infoManage.HouseMagage.HouseManage;
import com.View.basic_infoManage.UserManage.UserManage;
import com.View.total.Charge_totalView;
import com.View.total.Repair_totalView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class total_Handler implements ActionListener {

    private MainView mv;

    public total_Handler(MainView mv) {
        this.mv = mv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JScrollPane jsp = null;
        JMenuItem JMenuItem = (JMenuItem)e.getSource();
        if("收费统计".equals(JMenuItem.getText())) {
            if(mv.repair_total){
                mv.repair_total = false;
                mv.root.remove(mv.jp2);
            }
            if(mv.charge_total) {
                mv.charge_total = false;
                mv.root.remove(mv.jp2);
            }
            Charge_totalView ct = new Charge_totalView(mv.auto_width, mv.auto_height, (int) (mv.auto_height * 0.05));
            jsp = ct.userPanel;
            mv.charge_total = true;
            System.out.println("收费统计");
        }
        else if ("报修统计".equals(JMenuItem.getText())) {
            if(mv.charge_total) {
                mv.charge_total = false;
                mv.root.remove(mv.jp2);
            }
            if(mv.repair_total) {
                mv.repair_total = false;
                mv.root.remove(mv.jp2);
            }

            Repair_totalView rt = new Repair_totalView(mv.auto_width,mv.auto_height,(int)(mv.auto_height * 0.05));
            jsp = rt.userPanel;
            mv.repair_total = true;
            System.out.println("报修统计");
        }

        mv.root.add(jsp);
        mv.jp2 = jsp;


    }

}