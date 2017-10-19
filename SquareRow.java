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
public class SquareRow {
	
	/** initialising the values that the row can contain */
	
	public SquareRow(){
		Utility.populateAll(allowedValues);				
	}	
	
	private String name = null;	
	boolean isFull = false;
	
	/** the possible values from 0..8 */
	private Set allowedValues = new HashSet();
	
	/** the values that this row cannot contain  */
	private Set notAllowedValues = new HashSet();
	
	private Set containsValues = new HashSet();
	
	private Set mustContainValues = new HashSet();
	
	/** contains the three cells */
	private Set cells = new HashSet();
	
	/** initial capacity of square row is 3 */
	private int initSqrRowCapacity = 3;
	
	
	public Set getAllowedValues() {
		return allowedValues;
	}
	public void setAllowedValues(Set possibleValues) {
		this.allowedValues = possibleValues;
	}
	/**
	 * @return Returns the cells.
	 */
	public Set getCells() {
		return cells;
	}
	/**
	 * @param cells The cells to Set.
	 */
	public void setCells(Set cells) {
		this.cells = cells;
	}
	
	
	/**
	 * @return Returns the cannotContainValues.
	 */
	public Set getnotAllowedValues() {
		return notAllowedValues;
	}
	/**
	 * @param cannotContainValues The cannotContainValues to Set.
	 */
	public void setnotAllowedValues(Set cannotContainValues) {
		this.notAllowedValues = cannotContainValues;
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
	public Set getMustContainValues() { 
		return mustContainValues;
	}
	public void setMustContainValues(Set mustContainValues) {
		this.mustContainValues = mustContainValues;
	}
	public int getInitSqrRowCapacity() {
		return initSqrRowCapacity;
	}
	public void decreaseInitSqrRowCapacity() {
		this.initSqrRowCapacity = this.initSqrRowCapacity -1 ;
	}
}
