package com.Handler.RepairManage;

import com.View.PropertyfesManage.Propertyfees;
import com.View.PropertyfesManage.updatePropertyView;
import com.View.RepairManage.RepairManage;
import com.View.RepairManage.updateRepairView;
import com.service.impl.Property_update_ServiceImpl;
import com.service.impl.Repair_update_ServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Update_RepairHandler implements ActionListener {
    private updateRepairView urv;
    private RepairManage rm;
    public Update_RepairHandler(updateRepairView urv, RepairManage rm) {
        this.urv = urv;
        this.rm = rm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton)e.getSource();
        if ("保存".equals(jButton.getText())) {
            System.out.println("保存点击事件被触发");
            rm.setData(new Repair_update_ServiceImpl(urv.userDao()).getData());
            rm.updateModel();
        }

    }
}