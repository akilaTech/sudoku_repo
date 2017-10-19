package com;


import java.util.HashSet;
import java.util.Set;

public class Cell implements Comparable {
	
	public Cell(){
		Utility.populateAll(allowedValues);				
	}
	
	public int compareTo(Object o){
		Cell cell = (Cell)o;
		return name.compareTo(cell.getName());
	}
	private boolean hasValue = false;
	private boolean isCalculatedValue = false;
	private int value = -1;
	private String name = null;
	
	/** the possible values from 0..8 */
	private Set allowedValues = new HashSet();
	private Set notAllowedValues = new HashSet();
	
	private Row row = null;
	private Column column = null;
	private Square square = null;
	
	private SquareRow squareRow = null;
	private SquareColumn squareColumn = null;
	
	public Set getNotAllowedValues() {
		return notAllowedValues;
	}
	
	public boolean isHasValue() {
		return hasValue;
	}
	public void setHasValue(boolean hasValue) {
		this.hasValue = hasValue;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * @return Returns the columns.
	 */
	public Column getColumn() {
		return column;
	}
	/**
	 * @param columns The columns to List.
	 */
	public void setColumn(Column columns) {
		this.column = columns;
	}
	/**
	 * @return Returns the rows.
	 */
	public Row getRow() {
		return row;
	}
	/**
	 * @param rows The rows to List.
	 */
	public void setRow(Row row) {
		this.row = row;
	}
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to List.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the square.
	 */
	public Square getSquare() {
		return square;
	}
	/**
	 * @param square The square to List.
	 */
	public void setSquare(Square square) {
		this.square = square;
	}
	
	/**
	 * @return Returns the possibleValues.
	 */
	public Set getAllowedValues() {
		return allowedValues;
	}
	
	
	

	public SquareColumn getSquareColumn() {
		return squareColumn;
	}

	public void setSquareColumn(SquareColumn squareColumn) {
		this.squareColumn = squareColumn;
	}

	public SquareRow getSquareRow() {
		return squareRow;
	}

	public void setSquareRow(SquareRow squareRow) {
		this.squareRow = squareRow;
	}

	public boolean isCalculatedValue() {
		return isCalculatedValue;
	}

	public void setCalculatedValue(boolean isCalculatedValue) {
		this.isCalculatedValue = isCalculatedValue;
	}

	

	

	
}
