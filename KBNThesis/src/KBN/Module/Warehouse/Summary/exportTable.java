package KBN.Module.Warehouse.Summary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class exportTable {
	
	   public void toExcel(JTable modelTale, File file){
			try{
				TableModel model = modelTale.getModel();
				FileWriter excel = new FileWriter(file);

				for(int i = 0; i < model.getColumnCount(); i++){
					excel.write(model.getColumnName(i) + "\t");
				}
				excel.write("\n");

				for(int i=0; i< model.getRowCount(); i++) {
					for(int j=0; j < model.getColumnCount(); j++) {
						excel.write(model.getValueAt(i,j).toString()+"\t");
					}
					excel.write("\n");
				}

				excel.close();
			}catch(IOException e){ System.out.println(e); }
		}
}
