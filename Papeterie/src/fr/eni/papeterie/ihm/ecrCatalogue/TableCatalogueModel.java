package fr.eni.papeterie.ihm.ecrCatalogue;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Stylo;

/**
 * @author sbaudin2021
 *
 */
/**
 * @author sbaudin2021
 *
 */
public class TableCatalogueModel extends AbstractTableModel {

	private List<Article> catalogue;

	private String[] columnNames = { "", "Reference", "Marque", "Designation", "Prix unitaire", "Stock" };

	public TableCatalogueModel(List<Article> catalogue) {
		this.catalogue = catalogue;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public int getRowCount() {
		return catalogue.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object val = null;
		switch (columnIndex) {
		case TableCatalogue.COL_ICON:
			val = catalogue.get(rowIndex) instanceof Stylo ? "S" : "R";
			break;
		case TableCatalogue.COL_REFERENCE:
			val = catalogue.get(rowIndex).getReference();
			break;
		case TableCatalogue.COL_MARQUE:
			val = catalogue.get(rowIndex).getMarque();
			break;
		case TableCatalogue.COL_DESIGNATION:
			val = catalogue.get(rowIndex).getDesignation();
			break;
		case TableCatalogue.COL_PU:
			val = catalogue.get(rowIndex).getPrixUnitaire();
			break;
		case TableCatalogue.COL_STOCK:
			val = catalogue.get(rowIndex).getQteStock();
			break;
		}
		return val;
	}

	public void setValueAt(Object value, int row, int col) {
		switch (col) {
		case TableCatalogue.COL_REFERENCE:
			catalogue.get(row).setReference((String) value);
			break;
		case TableCatalogue.COL_MARQUE:
			catalogue.get(row).setMarque((String) value);
			break;
		case TableCatalogue.COL_DESIGNATION:
			catalogue.get(row).setDesignation((String) value);
			break;
		case TableCatalogue.COL_PU:
			catalogue.get(row).setPrixUnitaire((Float) value);
			break;
		case TableCatalogue.COL_STOCK:
			catalogue.get(row).setQteStock((Integer) value);
			break;
		}
		fireTableCellUpdated(row, col);
		System.out.println("fireTableCellUpdated");
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	public boolean isCellEditable(int row, int col) {
		switch (col) {
		case TableCatalogue.COL_REFERENCE:
		case TableCatalogue.COL_MARQUE:
		case TableCatalogue.COL_DESIGNATION:
		case TableCatalogue.COL_PU:
		case TableCatalogue.COL_STOCK:
			return true;
		}
		return false;
	}
}
