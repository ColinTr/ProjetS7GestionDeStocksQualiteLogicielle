package controleur;

import modele.Produit;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProduitsTable extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private static final int COLUMN_NOM = 0;
    private static final int COLUMN_PRIX = 1;
    private static final int COLUMN_STOCK = 2;
    private static final int COLUMN_QTE_RESERVEE = 3;

    private String[] columnNames = { "Nom produit", "Prix", "Stock", "Quantité réservée" };
    private List<Produit> produitsList;

    public void setFilesList(List<Produit> fList) {
        produitsList = fList;
    }

    public ProduitsTable(List<Produit> fList) {
        produitsList = fList;
    }

    @Override
    public int getRowCount() {
        if(produitsList == null){
            return 0;
        }
        return produitsList.size();
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
        if(produitsList==null || produitsList.size()==0){
            return null;
        }

        Produit produit = produitsList.get(rowIndex);

        Object returnValue = null;

        switch (columnIndex) {

            case COLUMN_NOM :
                returnValue = produit.getNomProduit();
                break;

            case COLUMN_PRIX :
                returnValue = produit.getPrix();
                break;

            case COLUMN_STOCK :
                returnValue = produit.getStock();
                break;

            case COLUMN_QTE_RESERVEE :
                returnValue = produit.getReservations();
                break;

            default:
                throw new IllegalArgumentException("Invalid column index");

        }
        return returnValue;
    }

}