/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaalgorithms_2;

import java.awt.event.ActionListener;

/**
 *
 * @author pad
 */
public class model {
    
    private String arrayType="";
    private int arraySize;
    private String sortingAlgorithm="";
    private String output="";
    private String[] columnNames= {"Index","Content"};
    private interactiveTableModel myModel=new interactiveTableModel(getColumnNames());
    
    /**
     * @return the arrayType
     */
    public String getArrayType() {
        return arrayType;
    }

    /**
     * @param arrayType the arrayType to set
     */
    public void setArrayType(String arrayType) {
        this.arrayType = arrayType;
    }
    
    /**
     * @return the arraySize
     */
    public int getArraySize() {
        return arraySize;
    }

    /**
     * @param arraySize the arraySize to set
     */
    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }
    
    
    /**
     * @return the sortingAlgorithm
     */
    public String getSortingAlgorithm() {
        return sortingAlgorithm;
    }

    /**
     * @param sortingAlgorithm the sortingAlgorithm to set
     */
    public void setSortingAlgorithm(String sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }
    
    public void initArray(int sizeArray){
        for (int i=0; i<sizeArray; i++){
            //theView.addRow(String.valueOf(i), value);
            myModel.addDataSet(String.valueOf(i), "");
        }
    }
    
    public void addRow(String index, String value){
        myModel.addDataSet(index, value);
    }
//------------------------------------------------------------------------    
    public void bubbleSort(){
        output="";
        //getVector
        for (int i=arraySize-1; i>=0; i--){
            for (int j=0; j<i; j++){
                
                System.out.println("i("+i+")--> j("+j+"): "+(String) myModel.getValueAt(j, 1)+" -> j+1("+(j+1)+"): "+(String) myModel.getValueAt(j+1, 1));
                output+="\ni("+i+")--> j("+j+"): "+(String) myModel.getValueAt(j, 1)+" -> j+1("+(j+1)+"): "+(String) myModel.getValueAt(j+1, 1);
                if ( Integer.valueOf((String) myModel.getValueAt(j, 1)) > Integer.valueOf((String) myModel.getValueAt(j+1,1))){
                    swap(j,j+1);
                    System.out.println("SWAP! New position: j("+j+"): "+(String) myModel.getValueAt(j, 1)+" -> j+1("+(j+1)+"): "+(String) myModel.getValueAt(j+1, 1));
                    output+= "\nSWAP! New position: j("+j+"): "+(String) myModel.getValueAt(j, 1)+" -> j+1("+(j+1)+"): "+(String) myModel.getValueAt(j+1, 1);
                }
            }
        }
    }
    
    public void selectionSort(){
        for (int i=0; i<arraySize; i++){
            int indexOfMinValue=i;
            for (int j=i; j<arraySize; j++){
                System.out.println("i("+i+")--> j("+j+"): "+(String) myModel.getValueAt(j, 1));
                if (Integer.valueOf((String) myModel.getValueAt(j, 1)) < Integer.valueOf((String) myModel.getValueAt(indexOfMinValue,1))){
                    indexOfMinValue=j;
                }
            }
            if (indexOfMinValue!=i)
                swap(i, indexOfMinValue);
                System.out.println("SWAP! New position: j("+i+"): "+(String) myModel.getValueAt(i, 1)+" -> j+1("+indexOfMinValue+"): "+(String) myModel.getValueAt(indexOfMinValue, 1));
        }
    }
//------------------------------------------------------------------------
    private void swap(int iAscend, int iDescend){
        int interim=Integer.valueOf((String)myModel.getValueAt(iAscend, 1));
        myModel.setValueAt(myModel.getValueAt(iDescend, 1), iAscend, 1);
        myModel.setValueAt(interim, iDescend, 1);
        //setMyModel(myModel);
    }
    
    public void printOutArray(){
        for (int i=0; i<arraySize; i++){
            System.out.println(i+" | "+(String) myModel.getValueAt(i, 1));
        }

    }
    
    public void deleteTable(){
        myModel.deleteAllRow();
    }
    /**
     * @return the myModel
     */
    public interactiveTableModel getMyModel() {
        return myModel;
    }

    /**
     * @param myModel the myModel to set
     */
    public void setMyModel(interactiveTableModel myModel) {
        this.myModel = myModel;
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
    
    void addPrintOutput(ActionListener a){
        
    }

    /**
     * @return the output
     */
    public String getOutput() {
        return output;
    }

    /**
     * @param output the output to set
     */
    public void setOutput(String output) {
        this.output = output;
    }
}
