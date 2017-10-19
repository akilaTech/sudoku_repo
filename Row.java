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
public class Row {
	
	/** initialising the values that the row can contain */
	
	public Row(){
		Utility.populateAll(allowedValues);				
	}	
	
	private String name = null;	
	boolean isFull = false;
	
	/** the possible values from 0..8 */
	private Set allowedValues = new HashSet();
	
	/** the values that this row cannot contain  */
	private Set notAllowedValues = new HashSet();
	
	private Set containsValues = new HashSet();
	
	private Set cells = new HashSet();
	
	private Set squareRows = new HashSet();
	
	
	public Set getAllowedValues() {
		return allowedValues;
	}
	
	/**
	 * @return Returns the cells.
	 */
	public Set getCells() {
		return cells;
	}
	
	public void setCells(Set _cells) {
		cells = _cells;
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
	
	/**
	 * @return Returns the containsValues.
	 */
	public Set getContainsValues() {
		return containsValues;
	}
	/**
	 * @param containsValues The containsValues to set.
	 */
	public void setContainsValues(Set containsValues) {
		this.containsValues = containsValues;
	}
	
	public void populateRow(int value){
		getAllowedValues().remove(String.valueOf(value));
		getnotAllowedValues().add(String.valueOf(value));
		
		if(getAllowedValues().size() <=0 && getnotAllowedValues().size() == 9 ){
			isFull = true;
		}
	}

	public Set getSquareRows() {
		return squareRows;
	}

	public void setSquareRows(Set squareRows) {
		this.squareRows = squareRows;
	}
}
