package com.Handler.Property;

import com.View.PropertyfesManage.Propertyfees;
import com.View.PropertyfesManage.addPropertyView;
import com.View.PropertyfesManage.delPropertyView;
import com.View.PropertyfesManage.updatePropertyView;
import com.service.impl.Property_retrieve_ServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class check_PropertyHandler implements ActionListener {
    private Propertyfees py;
    public check_PropertyHandler(Propertyfees py) {
        this.py = py;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jbutton = (JButton)e.getSource();
        String text = jbutton.getText();
        if ("增加".equals(text)) {
            new addPropertyView(py);
            System.out.println("增加");

        }else if("修改".equals(text)) {
            System.out.println("修改");
            new updatePropertyView(py);

        }else if("删除".equals(text)) {
            System.out.println("删除");
            new delPropertyView(py);

        }else if("查询".equals(text)) {
            String key = py.getSearchTxt().getText();
            py.setData(new Property_retrieve_ServiceImpl(key).getData());
            py.updateModel();

        }else if("上一页".equals(text)) {

        }else if("下一页".equals(text)) {

        }

    }
}
