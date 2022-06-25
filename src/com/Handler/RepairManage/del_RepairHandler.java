package com.Handler.RepairManage;

import com.View.PropertyfesManage.Propertyfees;
import com.View.PropertyfesManage.delPropertyView;
import com.View.RepairManage.RepairManage;
import com.View.RepairManage.delRepairView;
import com.service.impl.Property_del_ServiceImpl;
import com.service.impl.Repair_del_ServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class del_RepairHandler implements ActionListener {
    private delRepairView drv;
    private RepairManage rm;

    public del_RepairHandler(delRepairView drv, RepairManage rm) {
        this.drv = drv;
        this.rm = rm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        if ("确定".equals(jButton.getText())) {
            System.out.println("确定点击事件被触发");
            rm.setData(new Repair_del_ServiceImpl(drv.userDao()).getData());
            rm.updateModel();
        }

    }
}