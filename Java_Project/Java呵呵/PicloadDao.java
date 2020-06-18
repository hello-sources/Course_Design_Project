package com.rookie.dao;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.rookie.view.GamerView;


public class PicloadDao {
    
    public PicloadDao() {
        super();
    }

    public void loadPic(int id,JLabel lable) {
        String imageStr = "/LoadImage"+File.separator+"image_" + id + ".png";
        if(lable != null) {
            try {
                lable.setIcon(new ImageIcon(GamerView.class.getResource(imageStr)));
            }catch(NullPointerException e){
                JOptionPane.showMessageDialog(null, "Õº∆¨º”‘ÿ ß∞‹£°£°£°");
            }
        }
    }
}

