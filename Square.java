package com;



import java.util.HashSet;
import java.util.Set;

/**
 * This class contains two important attributes : possibleValues & cannotContainValues
 * At the start when object is created - possibleValues - will contain values from 0..8
 * cannotContainValues will contain nothing 
 * Once a cell is populated with a value - that value will be removed from possibleValues
 * That value will be added to cannotContainValues
 * 
 */
public class Square {
	
	/** initialising the values that the row can contain */
	
	public Square(){
		Utility.populateAll(allowedValues);				
	}	
	
	private String name = null;	
	boolean isFull = false;
	
	/** the possible values from 0..8 */
	private Set allowedValues = new HashSet();
	
	/** the values that this row cannot contain  */
	private Set notAllowedValues = new HashSet();
	
	
	
	private Set rows = new HashSet();
	private Set columns = new HashSet();
	private Set cells = new HashSet();
	
	private Set squareRows = new HashSet();
	private Set squareColumns = new HashSet();
	
	
	public Set getAllowedValues() {
		return allowedValues;
	}
	public void setAllowedValues(Set possibleValues) {
		this.allowedValues = possibleValues;
	}
	
	
	
	/**
	 * @return Returns the cannotContainValues.
	 */
	public Set getnotAllowedValues() {
		return notAllowedValues;
	}
	
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to Set.
	 */
	public void setName(String name) {
		this.name = name;
	}		
	
	public Set getCells() {
		return cells;
	}
	public void setCells(Set cells) {
		this.cells = cells;
	}
	public Set getColumns() {
		return columns;
	}
	public void setColumns(Set columns) {
		this.columns = columns;
	}
	public Set getRows() {
		return rows;
	}
	public void setRows(Set rows) {
		this.rows = rows;
	}
	public Set getSquareColumns() {
		return squareColumns;
	}
	public void setSquareColumns(Set squareColumns) {
		this.squareColumns = squareColumns;
	}
	public Set getSquareRows() {
		return squareRows;
	}
	public void setSquareRows(Set squareRows) {
		this.squareRows = squareRows;
	}
	
	public void populateSquare(int value,Cell cell){
		getAllowedValues().remove(String.valueOf(value));
		getnotAllowedValues().add(String.valueOf(value));
		
		if(getAllowedValues().size() <=0 && getnotAllowedValues().size() == 9 ){
			isFull = true;
		}
	}
}
