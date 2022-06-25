package com.Handler.RepairManage;

import com.View.RepairManage.RepairManage;
import com.View.RepairManage.addRepairView;
import com.service.impl.Repair_add_ServiceImpl;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class add_RepairHandler implements ActionListener {
    private addRepairView arv;
    private RepairManage rm;
    public add_RepairHandler(addRepairView arv, RepairManage rm) {
        this.arv = arv;
        this.rm = rm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton)e.getSource();
        if ("添加".equals(jButton.getText())) {
            rm.setData(new Repair_add_ServiceImpl(arv.userDao()).getData());
            rm.updateModel();
        }

    }
}