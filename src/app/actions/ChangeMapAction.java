package app.actions;

import app.Container;
import app.entities.OptionsEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeMapAction implements ActionListener {

    public ChangeMapAction(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String toMap = (String)cb.getSelectedItem();
        Container.getInstance().provideOptions().mapName = toMap;
    }
}
