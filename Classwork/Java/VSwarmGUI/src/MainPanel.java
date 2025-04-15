import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
public class MainPanel extends JPanel{
    private GroupLayout layout;
    private GroupLayout.SequentialGroup horo;
    private GroupLayout.SequentialGroup vert;

    MainPanel(){
        this.setBackground(Color.PINK);
        this.setLayout(layout = new GroupLayout(this));
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        horo = layout.createSequentialGroup();
        vert = layout.createSequentialGroup();
    }
    public void addHoro(JLabel e, JTextField c, JButton b){
        horo.addGroup(layout.createParallelGroup().addComponent(e).addComponent(c).addComponent(b));
    }
    public void addHoro(JLabel e, JTextField c){
        horo.addGroup(layout.createParallelGroup().addComponent(e).addComponent(c));
    }
    public void setHoro(){
        layout.setHorizontalGroup(horo);
    }
    public void addVert(JLabel e, JLabel b){
        vert.addGroup(layout.createParallelGroup().addComponent(e).addComponent(b));
    }
    public void addVert(JTextField e, JTextField b){
        vert.addGroup(layout.createParallelGroup().addComponent(e).addComponent(b));
    }
    public void addVert(JButton e){
        vert.addGroup(layout.createParallelGroup().addComponent(e));
    }
    public void setVert(){
        layout.setVerticalGroup(vert);
    }
    public void setGroups(){
        this.setLayout(layout);
    }
}
