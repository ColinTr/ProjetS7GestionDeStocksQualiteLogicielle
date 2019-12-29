package controleur;

import modele.Rayon;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RayonsTable extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private static final int COLUMN_NOM = 0;
    private static final int COLUMN_NOM_CHEF_RAYON = 1;
    private static final int COLUMN_NB_ARTICLES = 2;

    private String[] columnNames = { "Nom rayon", "Chef de rayon", "Nombre d'articles" };
    private List<Rayon> rayonsList;

    public void setFilesList(List<Rayon> fList) {
        rayonsList = fList;
    }

    public RayonsTable(List<Rayon> fList) {
        rayonsList = fList;
    }

    @Override
    public int getRowCount() {
        if(rayonsList == null){
            return 0;
        }
        return rayonsList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rayonsList==null || rayonsList.size()==0){
            return null;
        }

        Rayon rayon = rayonsList.get(rowIndex);

        Object returnValue = null;

        switch (columnIndex) {

            case COLUMN_NOM :
                returnValue = rayon.getNomRayon();
                break;

            case COLUMN_NOM_CHEF_RAYON :
                returnValue = rayon.getChefDeRayon();
                break;

            case COLUMN_NB_ARTICLES :
                returnValue = rayon.getNbProduits();
                break;

            default:
                throw new IllegalArgumentException("Invalid column index");

        }
        return returnValue;
    }

}