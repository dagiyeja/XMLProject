package xml.sax;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel{
	Vector<String> columnName=new Vector<String>();
	Vector<Vector> data=new Vector<Vector>();
	
	public MyModel() {
		columnName.addElement("이름");
		columnName.addElement("나이");
		columnName.addElement("성별");
	}

	public int getColumnCount() {
		return columnName.size();
	}

	
	public int getRowCount() {
		return data.size();
	}

	public String getColumnName(int col) {
		return columnName.get(col);
	}
	
	public Object getValueAt(int row, int col) {
		return data.get(row).get(col);
	}
	
}
