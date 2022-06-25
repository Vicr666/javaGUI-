package com.Handler.Property;

import com.View.PropertyfesManage.Propertyfees;
import com.View.PropertyfesManage.delPropertyView;
import com.service.impl.Property_del_ServiceImpl;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class del_propertyHandler implements ActionListener {
    private delPropertyView dpv;
    private Propertyfees py;

    public del_propertyHandler(delPropertyView dpv, Propertyfees py) {
        this.dpv = dpv;
        this.py = py;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        if ("确定".equals(jButton.getText())) {
            System.out.println("确定点击事件被触发");
            py.setData(new Property_del_ServiceImpl(dpv.userDao()).getData());
            py.updateModel();
        }

    }
}