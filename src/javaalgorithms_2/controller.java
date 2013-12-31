/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaalgorithms_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


/**
 *
 * @author pad
 */
public class controller {
    private view theView;
    private model theModel;
    
    
    public controller(model theModel,view theView){
        this.theModel=theModel;

        this.theView=theView;
        this.theView.addComboBoxSelectListener(new selectOptionInCB());
        this.theView.addSetArrayListener(new setArray());
        this.theView.addFillRandomlyListener(new fillRandomly());
        this.theView.addEmptyTableListener(new emptyTable());
        this.theView.addFindListener(new find());
        this.theView.addDeleteListener(new delete());
        this.theView.addInputListener(new input());
        this.theView.addSortComboBoxListener(new selectedSortType());
        this.theView.addSortListener(new sort());
    }
    
    class selectOptionInCB implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb=(JComboBox)e.getSource();
            theModel.setArrayType((String)cb.getSelectedItem());
            System.out.println("Selected item is "+theModel.getArrayType());
            theView.printOutTextArea("hello world\n");
        }
        
    }
    
    class setArray implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            theModel.setArraySize(theView.getSizeArray());
        
            String index = "";
            String value = "";
            int arraySize;
            switch(theModel.getArrayType()){
                    case "Array":
                        theModel.deleteTable();
                        arraySize=theModel.getArraySize();
                        theModel.initArray(arraySize);
                        theView.updateTable(theModel.getMyModel(), theModel.getColumnNames());
                        break;
                    case "Stacks":
                        break;
                    case "Queue":
                        break;
                    default:
                        System.out.println("error!");
                        break;
            }
        }
        
    }
    class fillRandomly implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            theModel.deleteTable();
            int arraySize=theModel.getArraySize();
            for (int i=0;i<arraySize;i++){
                String randomValue=String.valueOf((int)Math.floor(Math.random()*10)+10);
                theModel.addRow(String.valueOf(i), randomValue);
                theView.updateTable(theModel.getMyModel(), theModel.getColumnNames());
            }
        }
    }    
    
    class emptyTable implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            theModel.deleteTable();
            int arraySize=theModel.getArraySize();
            for (int i=0;i<arraySize;i++){
                theModel.addRow(String.valueOf(i), "");
            }
        }
    }
    
    class find implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(theView.getValue()!=-1234567890 && theView.getIndex()==-1234567890){
                System.out.println("find value");                 
            }else if(theView.getValue()==-1234567890 && theView.getIndex()!=-1234567890){
                System.out.println("find index");
            }else{
                theView.popUpMessage("empty");
                System.out.println("empty");
            }
        }
    }
    
    class delete implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    class input implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    class selectedSortType implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb=(JComboBox)e.getSource();
            theModel.setSortingAlgorithm((String)cb.getSelectedItem());
            System.out.println("Selected Sorting Algorthim is "+theModel.getSortingAlgorithm());
        }
        
    }
    
    class sort implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //check for selected sorting algorithm
            String sortAlgo=theModel.getSortingAlgorithm();
            System.out.println(sortAlgo);
            theModel.printOutArray();
            switch(sortAlgo){
                case "Bubble Sort":
                    theModel.bubbleSort();
                    break;
                case "Insertion Sort":
                    System.out.println("Insertion Sort was selected");
                    break;
                case "Selection Sort":
                    theModel.selectionSort();
                    break;
                case "Bucket Sort":
                    break;
                case "Radix Sort":
                    break;
                case "Quick Sort":
                    break;
                case "Merge Sort":
                    break;
                case "Heap Sort":
                    break;
                default:
                    System.out.println("Please selet a sorting algorithm, in order to sort.");
                    break;
            }
            theModel.printOutArray();
            theView.printOutTextArea(theModel.getOutput());
        }
    }
}
