/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaalgorithms_2;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pad
 */
class interactiveTableModel extends AbstractTableModel{
        public static final int indexColumn=0;
        public static final int valueColumn=1;
        
        
        String[] columnNames;
    
        Vector data;
        
        public interactiveTableModel(String[] columnNames){
            this.columnNames=columnNames;
            this.data=new Vector();
        }
        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }
        
        @Override
        public String getColumnName(int column){
            return columnNames[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            dataSet myDataSet=(dataSet)data.get(rowIndex);
            switch(columnIndex){
                case indexColumn:
                    return myDataSet.getIndex();
                case valueColumn:
                    return myDataSet.getValue();
                default:
                    System.out.println("Invalid Index!");
                    return new Object();
            }
        }
        
        public void setValueAt(Object value, int rowIndex, int columnIndex){
            dataSet myDataSet=(dataSet)data.get(rowIndex);
            switch(columnIndex){
                case indexColumn:
                    myDataSet.setIndex((String) value);
                    break;
                case valueColumn:
                    myDataSet.setValue(String.valueOf(value));
                    break;
                default:
                    System.out.println("Invalid Index");
                    break;
            }
            fireTableCellUpdated(rowIndex, columnIndex);
        }
        
        public boolean hasEmptyRow(){
            if (data.size()==0){
                return false;
            }else{
                return true;
            }            
        }
        
        public void addDataSet(String index, String value){
            dataSet ds=new dataSet();
            ds.setIndex(index);
            ds.setValue(value);
            data.add(ds);
            
            fireTableRowsInserted(
                    data.size()-1,
                    data.size()-1);
        }
        
        public void deleteAllRow(){
            data.removeAll(data);
        }
        
    }