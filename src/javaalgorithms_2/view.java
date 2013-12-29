/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaalgorithms_2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
    
/**
 *
 * @author pad
 */
public class view extends JFrame {

    String[] dataStructureTypes={"", "Array","Stack","Queue"};
    String[] sorting={"", "Bubble Sort","Insertion Sort","Selection Sort","Bucket Sort","Radix Sort","Quick Sort","Merge Sort","Heap Sort"};
    
    private String[] columnNames= {"",""};
    
    protected interactiveTableModel myModel=new interactiveTableModel(columnNames);
    
    private JComboBox dataStructureList=new JComboBox(dataStructureTypes); 
    private JLabel lSize=new JLabel("Size");
    private JTextField tArraySize=new JTextField(10);
    private JButton bCreateArray=new JButton("Create Array");
    private JScrollPane jscrollPane=new JScrollPane();
    private JTable table=new JTable();
    private JButton bFill=new JButton("Fill randomly");
    private JButton bEmpty=new JButton("Empty Table");
    private JTextField tValue=new JTextField(6);
    private JLabel lValue=new JLabel("Value");
    private JTextField tIndex=new JTextField(3);
    private JLabel lIndex=new JLabel("Index");
    private JButton bFind=new JButton("Find");
    private JButton bDelete=new JButton("Delete");
    private JLabel lInput=new JLabel("Input");
    private JRadioButton rInputMany=new JRadioButton("Input Many");
    private JRadioButton rInputOne=new JRadioButton("Input One");
    
    private JButton bInput=new JButton("Insert");
    private JComboBox cSorting=new JComboBox(sorting); 
    private JRadioButton rAscending=new JRadioButton("Ascending");
    private JRadioButton rDescending=new JRadioButton("Descending");
    
    private JButton bSort=new JButton("Sort");
    private JRadioButton rLinear=new JRadioButton("Linear");
    private JRadioButton rBinary=new JRadioButton("Binary");
    private JScrollPane jOutput=new JScrollPane();
    private JTextArea aOutput=new JTextArea();
    
    view(){
        JPanel panel=new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        table.setModel(myModel);
        
        panel.add(dataStructureList);
        panel.add(lSize);
        panel.add(tArraySize);
        panel.add(bCreateArray);

        jscrollPane=new JScrollPane();
        jscrollPane.getViewport().add(table, null);
        Dimension d=table.getPreferredSize();
        jscrollPane.setPreferredSize(new Dimension(d.width, 200));
        panel.add(jscrollPane);
        panel.add(bFill);
        panel.add(bEmpty);
        panel.add(tValue);
        panel.add(lValue);
        panel.add(tIndex);
        panel.add(lIndex);
        panel.add(bFind);
        panel.add(bDelete);
        panel.add(lInput);
        panel.add(rInputOne);
        rInputOne.setSelected(true);
        panel.add(rInputMany);
        
        ButtonGroup groupInput=new ButtonGroup();
        groupInput.add(rInputOne);
        groupInput.add(rInputMany);
        
        panel.add(bInput);
        panel.add(cSorting);
        
        panel.add(rAscending);
        rAscending.setSelected(true);
        panel.add(rDescending);
        
        ButtonGroup groupSort_direction=new ButtonGroup();
        groupSort_direction.add(rAscending);
        groupSort_direction.add(rDescending);
        
        panel.add(bSort);
        panel.add(rLinear);
        rLinear.setSelected(true);
        panel.add(rBinary);
        ButtonGroup groupSort_way=new ButtonGroup();
        groupSort_way.add(rLinear);
        groupSort_way.add(rBinary);
        
        jOutput=new JScrollPane();
        jOutput.getViewport().add(aOutput, null);
        jOutput.setPreferredSize(new Dimension(500, 300));
        panel.add(jOutput);
        
        add(panel);
    }
    
    //getter
    public int getSizeArray(){
        try{
            return Integer.parseInt(tArraySize.getText());}
        catch(Exception ex){
            return 0;    
        }
    }
    
    public int getValue(){
        try{
        return Integer.parseInt(tValue.getText());
        }catch(Exception ex){
            return -1234567890;
        }
    }
    
    public int getIndex(){
        try{
            return Integer.parseInt(tIndex.getText());
        }catch (Exception ex){
            return -1234567890;
        }
    }
    
    void addComboBoxSelectListener(ActionListener ListenForComboSelect){
        dataStructureList.addActionListener(ListenForComboSelect);
    }
    
    void addSetArrayListener(ActionListener ListenForButton){        
        bCreateArray.addActionListener(ListenForButton);
    }
    
    void addFillRandomlyListener(ActionListener ListenForButton){
        bFill.addActionListener(ListenForButton);
    }
    
    void addEmptyTableListener(ActionListener ListenForButton){
        bEmpty.addActionListener(ListenForButton);
    }
    
    void addFindListener(ActionListener ListenForButton){
        bFind.addActionListener(ListenForButton);
    }
    
    void addDeleteListener(ActionListener ListenForButton){
        bDelete.addActionListener(ListenForButton);
    }
    
    void addInputListener(ActionListener ListenForButton){
        bInput.addActionListener(ListenForButton);
    }
    
    void addSortComboBoxListener(ActionListener ListenForComboSelect){
        cSorting.addActionListener(ListenForComboSelect);
    }
    
    void addSortListener(ActionListener ListenForButton){
        bSort.addActionListener(ListenForButton);
    }
    
    public void printOutTextArea(String text){
        aOutput.append(text);
    }
    
    public void popUpMessage(String text){
        JOptionPane.showMessageDialog(this, text);                
    }
  
    public void updateTable(interactiveTableModel model, String[] columnNames){
        table.setModel(model);
        model=new interactiveTableModel(columnNames);
    }

    

    /**
     * @return the columnNames
     */
    public String[] getColumnNames() {
        return columnNames;
    }

    /**
     * @param columnNames the columnNames to set
     */
    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }
}