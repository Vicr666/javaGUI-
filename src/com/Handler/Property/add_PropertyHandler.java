package com.Handler.Property;

import com.Dao.UserDao;
import com.View.MainView.MainView;
import com.View.PropertyfesManage.Propertyfees;
import com.View.PropertyfesManage.addPropertyView;
import com.service.impl.Property_add_ServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_PropertyHandler implements ActionListener {
    private addPropertyView apv;
    private Propertyfees py;
    public add_PropertyHandler(addPropertyView apv, Propertyfees py) {
        this.apv = apv;
        this.py = py;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton)e.getSource();
        if ("添加".equals(jButton.getText())) {
            py.setData(new Property_add_ServiceImpl(apv.userDao()).getData());
            py.updateModel();
        }

    }
}
