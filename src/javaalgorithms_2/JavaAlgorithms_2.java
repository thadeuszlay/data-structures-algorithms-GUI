/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaalgorithms_2;

/**
 *
 * @author pad
 */
public class JavaAlgorithms_2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        view theView=new view();
        model theModel=new model();
        
        controller theController=new controller(theModel, theView);
        theView.updateTable(theModel.getMyModel(), theModel.getColumnNames());
        theView.setVisible(true);
        theView.setSize(540,650);
    }
}
