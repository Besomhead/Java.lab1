import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel
{
    private static final long serialVersionUID = 3883320516766981209L;

    private int columnCount = 2;
    private ArrayList<String []> dataList;

    public TableModel()
    {
        dataList = new ArrayList<String []>();
        for (int i = 0; i < dataList.size(); i++)
        {
            dataList.add(new String[getColumnCount()]);
        }
    }

    public int getColumnCount() {return columnCount;}

    public int getRowCount() {return dataList.size();}

    public String getColumnName(int column)
    {
        switch(column)
        {
            case 0: return "Left";
            case 1: return "Right";
        }

        return "";
    }

    public Object getValueAt(int row, int column)
    {
        String []rows = dataList.get(row);

        return rows[column];
    }

    public void addData(String []row)
    {
        String []rowTable = new String[getColumnCount()];
        rowTable = row;
        dataList.add(rowTable);
    }

    public void toRight(int row)
    {
        String []current = dataList.get(row);
        current[1] = current[0];
        current[0] = "";
    }

    public void toLeft(int row)
    {
        String []current = dataList.get(row);
        current[0] = current[1];
        current[1] = "";
    }
}
