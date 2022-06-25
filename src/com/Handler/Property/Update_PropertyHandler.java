package com.Handler.Property;

import com.View.PropertyfesManage.Propertyfees;
import com.View.PropertyfesManage.addPropertyView;
import com.View.PropertyfesManage.updatePropertyView;
import com.service.impl.Property_update_ServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Update_PropertyHandler implements ActionListener {
    private updatePropertyView upv;
    private Propertyfees py;
    public Update_PropertyHandler(updatePropertyView upv, Propertyfees py) {
        this.upv = upv;
        this.py = py;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton)e.getSource();
        if ("保存".equals(jButton.getText())) {
            System.out.println("保存点击事件被触发");
            py.setData(new Property_update_ServiceImpl(upv.userDao()).getData());
            py.updateModel();
        }

    }
}
