package com.Handler.RepairManage;

import com.View.RepairManage.RepairManage;
import com.View.RepairManage.addRepairView;
import com.View.RepairManage.delRepairView;
import com.View.RepairManage.updateRepairView;
import com.service.impl.Repair_retrieve_ServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class check_RepairManageHandler implements ActionListener {
    private RepairManage rm;
    public check_RepairManageHandler(RepairManage rm) {
        this.rm = rm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jbutton = (JButton)e.getSource();
        String text = jbutton.getText();
        if ("增加".equals(text)) {
            new addRepairView(rm);
            System.out.println("增加");

        }
        else if("修改".equals(text)) {
            System.out.println("修改");
            new updateRepairView(rm);

        }else if("删除".equals(text)) {
            System.out.println("删除");
            new delRepairView(rm);

        }else if("查询".equals(text)) {
            String key = rm.getSearchTxt().getText();
            rm.setData(new Repair_retrieve_ServiceImpl(key).getData());
            rm.updateModel();

        }else if("上一页".equals(text)) {

        }else if("下一页".equals(text)) {

        }

    }
}