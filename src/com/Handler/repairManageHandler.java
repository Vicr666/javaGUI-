package com.Handler;

import com.View.MainView.MainView;
import com.View.RepairManage.RepairManage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class repairManageHandler implements ActionListener {
    private MainView mv;

    public repairManageHandler(MainView mv) {
        this.mv = mv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem jMenuItem = (JMenuItem) e.getSource();
        if("报修管理".equals(jMenuItem.getText())) {
            new RepairManage();
        }

        }

}