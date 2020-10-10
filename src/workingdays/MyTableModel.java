/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package workingdays;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author M.ANJANAN
 */
class MyTableModel extends AbstractTableModel {
    private String[] columnNames = {"",
                                    "Monday",
                                    "Tuesday",
                                    "Wednesday",
                                    "Thursday",
                                    "Friday"};

    String[] temp_delete = new String[10];
    int index_delete = 0;

   private ArrayList<ArrayList<Object>> tableData = new ArrayList<ArrayList<Object>>();


    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return tableData.size();

    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {

        if(tableData.size()> 0){
            return tableData.get(row).get(col);
        }

         return null;
    }

    public void removeAllEntry(){

            tableData.clear();
        //model.fireTableDataChanged();
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    public Class getColumnClass(int c) {
        if(tableData.size()> 0){
            return getValueAt(0, c).getClass();
        }

        return String.class;
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.

        switch (col){
            case 4:
                return true;
            default: return false;
        }
    }


    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {

        if(tableData.size() <= row){

            ArrayList<Object> arrayList = new ArrayList<Object>();

            for(int i = 0; i < columnNames.length;i++){
                arrayList.add("");
            }

            tableData.add(arrayList);
        }

        ArrayList<Object> object = tableData.get(row);

        object.add(col, value);

        tableData.set(row, object);

        fireTableDataChanged();

    }
}