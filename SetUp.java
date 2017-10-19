package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class SetUp {
	
	/** when puzzle done - should contain 81 values */
	public List totalPopulatedCount = new ArrayList();
	
	public List totalRows = new ArrayList();
	public List totalColumns = new ArrayList();	
	public List totalSquares = new ArrayList();	
	
	public List totalSqrRows = new ArrayList();
	public List totalSqrCols = new ArrayList();
	public static Map totalCells = new HashMap(); 
	
	/** squares */
	Square s11_44 = new Square();
	Square s14_47 = new Square();
	Square s17_410 = new Square();
	Square s41_74 = new Square();
	Square s44_77 = new Square();
	Square s47_710 = new Square();
	Square s71_104 = new Square();
	Square s74_107 = new Square();
	Square s77_1010 = new Square();
	
	/** rows and columns */
	Row r1 = new Row();Row r2 = new Row();	Row r3 = new Row();	
	Row r4 = new Row();	Row r5 = new Row();	Row r6 = new Row();	
	Row r7 = new Row();	Row r8 = new Row();	Row r9 = new Row();
	
	Column c1 = new Column();	Column c2 = new Column();	Column c3 = new Column();	
	Column c4 = new Column();	Column c5 = new Column();	Column c6 = new Column();	
	Column c7 = new Column();	Column c8 = new Column();	Column c9 = new Column();

	//sqr rows and columns 
	SquareRow sqr1Row1 = new SquareRow();SquareRow sqr1Row2 = new SquareRow();SquareRow sqr1Row3 = new SquareRow();
	SquareRow sqr2Row1 = new SquareRow();SquareRow sqr2Row2 = new SquareRow();SquareRow sqr2Row3 = new SquareRow();
	SquareRow sqr3Row1 = new SquareRow();SquareRow sqr3Row2 = new SquareRow();SquareRow sqr3Row3 = new SquareRow();
	
	SquareColumn sqr1Col1 = new SquareColumn();SquareColumn sqr1Col2 = new SquareColumn();SquareColumn sqr1Col3 = new SquareColumn();
	SquareColumn sqr2Col1 = new SquareColumn();SquareColumn sqr2Col2 = new SquareColumn();SquareColumn sqr2Col3 = new SquareColumn();
	SquareColumn sqr3Col1 = new SquareColumn();SquareColumn sqr3Col2 = new SquareColumn();SquareColumn sqr3Col3 = new SquareColumn();
	
	SquareRow sqr4Row1 = new SquareRow();SquareRow sqr4Row2 = new SquareRow();SquareRow sqr4Row3 = new SquareRow();
	SquareRow sqr5Row1 = new SquareRow();SquareRow sqr5Row2 = new SquareRow();SquareRow sqr5Row3 = new SquareRow();
	SquareRow sqr6Row1 = new SquareRow();SquareRow sqr6Row2 = new SquareRow();SquareRow sqr6Row3 = new SquareRow();
	
	SquareColumn sqr4Col1 = new SquareColumn();SquareColumn sqr4Col2 = new SquareColumn();SquareColumn sqr4Col3 = new SquareColumn();
	SquareColumn sqr5Col1 = new SquareColumn();SquareColumn sqr5Col2 = new SquareColumn();SquareColumn sqr5Col3 = new SquareColumn();
	SquareColumn sqr6Col1 = new SquareColumn();SquareColumn sqr6Col2 = new SquareColumn();SquareColumn sqr6Col3 = new SquareColumn();
	
	SquareRow sqr7Row1 = new SquareRow();SquareRow sqr7Row2 = new SquareRow();SquareRow sqr7Row3 = new SquareRow();
	SquareRow sqr8Row1 = new SquareRow();SquareRow sqr8Row2 = new SquareRow();SquareRow sqr8Row3 = new SquareRow();
	SquareRow sqr9Row1 = new SquareRow();SquareRow sqr9Row2 = new SquareRow();SquareRow sqr9Row3 = new SquareRow();	
	
	SquareColumn sqr7Col1 = new SquareColumn();SquareColumn sqr7Col2 = new SquareColumn();SquareColumn sqr7Col3 = new SquareColumn();
	SquareColumn sqr8Col1 = new SquareColumn();SquareColumn sqr8Col2 = new SquareColumn();SquareColumn sqr8Col3 = new SquareColumn();
	SquareColumn sqr9Col1 = new SquareColumn();SquareColumn sqr9Col2 = new SquareColumn();SquareColumn sqr9Col3 = new SquareColumn();
	
	//row 1 
	Cell c11 = new Cell();	Cell c21 = new Cell();	Cell c31 = new Cell();	
	Cell c41 = new Cell();	Cell c51 = new Cell();	Cell c61 = new Cell();	
	Cell c71 = new Cell();	Cell c81 = new Cell();	Cell c91 = new Cell();
	
	//row 2
	Cell c12 = new Cell();	Cell c22 = new Cell();	Cell c32 = new Cell();	
	Cell c42 = new Cell();	Cell c52 = new Cell();	Cell c62 = new Cell();	
	Cell c72 = new Cell();	Cell c82 = new Cell();	Cell c92 = new Cell();
	
	//row 3
	Cell c13 = new Cell();	Cell c23 = new Cell();	Cell c33 = new Cell();	
	Cell c43 = new Cell();	Cell c53 = new Cell();	Cell c63 = new Cell();	
	Cell c73 = new Cell();	Cell c83 = new Cell();	Cell c93 = new Cell();	
	
	//row 4
	Cell c14 = new Cell();	Cell c24 = new Cell();	Cell c34 = new Cell();	
	Cell c44 = new Cell();	Cell c54 = new Cell();	Cell c64 = new Cell();	
	Cell c74 = new Cell();	Cell c84 = new Cell();	Cell c94 = new Cell();
	
	//row 5
	Cell c15 = new Cell();	Cell c25 = new Cell();	Cell c35 = new Cell();	
	Cell c45 = new Cell();	Cell c55 = new Cell();	Cell c65 = new Cell();	
	Cell c75 = new Cell();	Cell c85 = new Cell();	Cell c95 = new Cell();
	
	//row 6
	Cell c16 = new Cell();	Cell c26 = new Cell();	Cell c36 = new Cell();	
	Cell c46 = new Cell();	Cell c56 = new Cell();	Cell c66 = new Cell();	
	Cell c76 = new Cell();	Cell c86 = new Cell();	Cell c96 = new Cell();
	
	//row 7
	Cell c17 = new Cell();	Cell c27 = new Cell();	Cell c37 = new Cell();	
	Cell c47 = new Cell();	Cell c57 = new Cell();	Cell c67 = new Cell();	
	Cell c77 = new Cell();	Cell c87 = new Cell();	Cell c97 = new Cell();
	
	//row 8
	Cell c18 = new Cell();	Cell c28 = new Cell();	Cell c38 = new Cell();	
	Cell c48 = new Cell();	Cell c58 = new Cell();	Cell c68 = new Cell();	
	Cell c78 = new Cell();	Cell c88 = new Cell();	Cell c98 = new Cell();
	
	//row 9
	Cell c19 = new Cell();	Cell c29 = new Cell();	Cell c39 = new Cell();	
	Cell c49 = new Cell();	Cell c59 = new Cell();	Cell c69 = new Cell();	
	Cell c79 = new Cell();	Cell c89 = new Cell();	Cell c99 = new Cell();	
	
	
	
	
	public void printBasicSetUp(){
		for(int i=8;i>-1;i--){
			//for(int i=0;i<9;i++){
			Row prRow = (Row)totalRows.get(i);
			//System.out.println(" name of row " + prRow.getName());
			Set prCellArr = prRow.getCells();
			Set treeSet = new TreeSet();
			treeSet.addAll(prCellArr);
			Iterator iter = treeSet.iterator();
			while(iter.hasNext()){
				Cell prCell = (Cell)iter.next();
				//System.out.println(" cell =  >>>> " + prCell.getName());
				if(prCell.getValue() > -1){					
					if(!prCell.isCalculatedValue()){
						System.out.print("  " + prCell.getValue()  + " ");
					}else{
						System.out.print("  " + prCell.getValue()  + " ");
					}					
				}else{
					System.out.print(" " + " *"  + " ");
				}				
			}			
			System.out.println();
			if(i>0 && i%3==0){
				System.out.println(" ");
			}
		}//for
		System.out.println();
	}
	
	
	
	public  void arrangeGrid(){
		
		/** add the cells to a list */
		populateCellsList();
		/** add the squares to a list */
		populateSquaresList();
		
		/** add the rows to a list */
		populateRowsList();	
		
		/** add the columns to a list */
		populateColumnsList();
		
		/** add the square rows to a list */
		populateSqrRowsList();
		
		/** add the square columns to a list */
		populateSqrColsList();
		
		/** populate cols and rows with cells as a Set */
		populateRowsWithCells();
		populateColumnsWithCells();	
		
		/** populates the square rows and columns with cells */
		populateSqrRowsAndColumnsWithCells();
		
		/**populates the square with cells as a Set */
		populateSquareWithCells();
		
		/** populates the square with rows and columns as a Set */
		populateSquareWithRowsAndColumns();
		
		/** populates the square with sqyare rows and columns */
		populateSquareWithSqrRowsAndSqrColumns();
		
		/** populate the rows with square rows */
		populateRowWithSquareRows();
		
		/** populate the columns with square columns */
		populateColumnWithSquareColumns();
		
		/** set names of cells , rows , squares and columns */
		setUpNames();		
		
		/** this method is used to populate each cell with its own row , column and square */ 
		populateCellWithRowAndColumnAndSquare();	
	}
	
	public static void populateCell(String cellName , int value,boolean isCalculated){
		Cell cell = (Cell)totalCells.get(cellName);
		/** first do cell activity */
		cell.setValue(value);
		cell.setHasValue(true);
		
		cell.getAllowedValues().clear();
		Utility.populateAll(cell.getNotAllowedValues());
		cell.setCalculatedValue(isCalculated);
		
		cell.getRow().getAllowedValues().remove(String.valueOf(value));
		cell.getRow().getnotAllowedValues().add(String.valueOf(value));
		
		cell.getColumn().getAllowedValues().remove(String.valueOf(value));
		cell.getColumn().getnotAllowedValues().add(String.valueOf(value));
		
		cell.getSquare().getAllowedValues().remove(String.valueOf(value));
		cell.getSquare().getnotAllowedValues().add(String.valueOf(value));
		
		/**for the square column and row check if they are full */
		if(cell.getRow().getAllowedValues().size() <= 0 && cell.getRow().getnotAllowedValues().size() == 9){
			cell.getRow().isFull = true;
		}
		if(cell.getColumn().getAllowedValues().size() <= 0 && cell.getColumn().getnotAllowedValues().size() == 9){
			cell.getColumn().isFull = true;
		}
		if(cell.getSquare().getAllowedValues().size() <= 0 && cell.getSquare().getnotAllowedValues().size() == 9){
			cell.getSquare().isFull = true; 
		} 
		
		/** before running the possibilities whenever we populate cleanup after ourselves */
		cell.getSquareColumn().getAllowedValues().remove(String.valueOf(cell.getValue()));
		cell.getSquareRow().getAllowedValues().remove(String.valueOf(cell.getValue()));	
		cell.getSquareColumn().getMustContainValues().remove(String.valueOf(cell.getValue()));
		cell.getSquareRow().getMustContainValues().remove(String.valueOf(cell.getValue()));
		
		/** every cell that we populate decrement the capacity of the square row and square column */
		cell.getSquareRow().decreaseInitSqrRowCapacity();
		cell.getSquareColumn().decreaseInitSqrColCapacity();
		
		/** set the indicator of sqr row aand col to is full conditionally */
		if(cell.getSquareRow().getInitSqrRowCapacity() == 0){
			cell.getSquareRow().isFull = true;
		}
		
		if(cell.getSquareColumn().getInitSqrColCapacity() == 0){
			cell.getSquareColumn().isFull = true;
		}
	}
	
	private void setUpNames(){
		setUpCellNames();
		setUpRowNames();
		setUpColumnNames();
		setUpSquareNames();
		setUpSqrRowNames();
		setUpSqrColNames();
	}
	
	private void populateCellsList() {
		
		
		//	#sqr 1
		totalCells.put("c11",c11);totalCells.put("c21",c21);totalCells.put("c31",c31);
		totalCells.put("c12",c12);totalCells.put("c22",c22);totalCells.put("c32",c32);
		totalCells.put("c13",c13);totalCells.put("c23",c23);totalCells.put("c33",c33);
		
		// #sqr 4
		totalCells.put("c14",c14);totalCells.put("c24",c24);totalCells.put("c34",c34);
		totalCells.put("c15",c15);totalCells.put("c25",c25);totalCells.put("c35",c35);
		totalCells.put("c16",c16);totalCells.put("c26",c26);totalCells.put("c36",c36);
		
		// #sqr 7
		totalCells.put("c17",c17);totalCells.put("c27",c27);totalCells.put("c37",c37);
		totalCells.put("c18",c18);totalCells.put("c28",c28);totalCells.put("c38",c38);
		totalCells.put("c19",c19);totalCells.put("c29",c29);totalCells.put("c39",c39);
		
		//####################################################################
		
		// #sqr 2
		totalCells.put("c41",c41);totalCells.put("c51",c51);totalCells.put("c61",c61);
		totalCells.put("c42",c42);totalCells.put("c52",c52);totalCells.put("c62",c62);
		totalCells.put("c43",c43);totalCells.put("c53",c53);totalCells.put("c63",c63);
		
		// #sqr 5
		totalCells.put("c44",c44);totalCells.put("c54",c54);totalCells.put("c64",c64);
		totalCells.put("c45",c45);totalCells.put("c55",c55);totalCells.put("c65",c65);
		totalCells.put("c46",c46);totalCells.put("c56",c56);totalCells.put("c66",c66);
		
		// #sqr 8
		totalCells.put("c47",c47);totalCells.put("c57",c57);totalCells.put("c67",c67);
		totalCells.put("c48",c48);totalCells.put("c58",c58);totalCells.put("c68",c68);
		totalCells.put("c49",c49);totalCells.put("c59",c59);totalCells.put("c69",c69);	
		
		//####################################################################
		
		 // #sqr 3
		totalCells.put("c71",c71);totalCells.put("c81",c81);totalCells.put("c91",c91);
		totalCells.put("c72",c72);totalCells.put("c82",c82);totalCells.put("c92",c92);
		totalCells.put("c73",c73);totalCells.put("c83",c83);totalCells.put("c93",c93);	
		
		// #sqr 6
		totalCells.put("c74",c74);totalCells.put("c84",c84);totalCells.put("c94",c94);
		totalCells.put("c75",c75);totalCells.put("c85",c85);totalCells.put("c95",c95);
		totalCells.put("c76",c76);totalCells.put("c86",c86);totalCells.put("c96",c96);	
	
		// #sqr 9
		totalCells.put("c77",c77);totalCells.put("c87",c87);totalCells.put("c97",c97);
		totalCells.put("c78",c78);totalCells.put("c88",c88);totalCells.put("c98",c98);
		totalCells.put("c79",c79);totalCells.put("c89",c89);totalCells.put("c99",c99);		
	}
	private void populateColumnsList() {
		/** set up all columns in a list */
		totalColumns.add(this.c1);totalColumns.add(this.c2);totalColumns.add(this.c3);
		totalColumns.add(this.c4);totalColumns.add(this.c5);totalColumns.add(this.c6);
		totalColumns.add(this.c7);totalColumns.add(this.c8);totalColumns.add(this.c9);
	}

	private void populateRowsList() {
		/** set up all rows in  a List */
		totalRows.add(this.r1);totalRows.add(this.r2);totalRows.add(this.r3);
		totalRows.add(this.r4);	totalRows.add(this.r5);totalRows.add(this.r6);
		totalRows.add(this.r7);	totalRows.add(this.r8);	totalRows.add(this.r9);
	}
	
	private void populateSqrRowsList() {
		/** set up all rows in  a List */
		totalSqrRows.add(sqr1Row1);totalSqrRows.add(sqr1Row2);totalSqrRows.add(sqr1Row3);
		totalSqrRows.add(sqr2Row1);totalSqrRows.add(sqr2Row2);totalSqrRows.add(sqr2Row3);
		totalSqrRows.add(sqr3Row1);totalSqrRows.add(sqr3Row2);totalSqrRows.add(sqr3Row3);
		
		totalSqrRows.add(sqr4Row1);totalSqrRows.add(sqr4Row2);totalSqrRows.add(sqr4Row3);
		totalSqrRows.add(sqr5Row1);totalSqrRows.add(sqr5Row2);totalSqrRows.add(sqr5Row3);
		totalSqrRows.add(sqr6Row1);totalSqrRows.add(sqr6Row2);totalSqrRows.add(sqr6Row3);
		
		totalSqrRows.add(sqr7Row1);totalSqrRows.add(sqr7Row2);totalSqrRows.add(sqr7Row3);
		totalSqrRows.add(sqr8Row1);totalSqrRows.add(sqr8Row2);totalSqrRows.add(sqr8Row3);
		totalSqrRows.add(sqr9Row1);totalSqrRows.add(sqr9Row2);totalSqrRows.add(sqr9Row3);
	}
	
	private void populateSqrColsList() {
		/** set up all cols in  a List */
		totalSqrCols.add(sqr1Col1);totalSqrCols.add(sqr1Col2);totalSqrCols.add(sqr1Col3);
		totalSqrCols.add(sqr2Col1);totalSqrCols.add(sqr2Col2);totalSqrCols.add(sqr2Col3);
		totalSqrCols.add(sqr3Col1);totalSqrCols.add(sqr3Col2);totalSqrCols.add(sqr3Col3);
		
		totalSqrCols.add(sqr4Col1);totalSqrCols.add(sqr4Col2);totalSqrCols.add(sqr4Col3);
		totalSqrCols.add(sqr5Col1);totalSqrCols.add(sqr5Col2);totalSqrCols.add(sqr5Col3);
		totalSqrCols.add(sqr6Col1);totalSqrCols.add(sqr6Col2);totalSqrCols.add(sqr6Col3);
		
		totalSqrCols.add(sqr7Col1);totalSqrCols.add(sqr7Col2);totalSqrCols.add(sqr7Col3);
		totalSqrCols.add(sqr8Col1);totalSqrCols.add(sqr8Col2);totalSqrCols.add(sqr8Col3);
		totalSqrCols.add(sqr9Col1);totalSqrCols.add(sqr9Col2);totalSqrCols.add(sqr9Col3);
	}	

	private void populateSquareWithRowsAndColumns() {
		/** set the third square */
		s71_104.getColumns().add(c7);s71_104.getColumns().add(c8);s71_104.getColumns().add(c9);		
		
		s71_104.getRows().add(r1);s71_104.getRows().add(r2);s71_104.getRows().add(r3);
		
		/** set the sixth square */
		s74_107.getColumns().add(c7);s74_107.getColumns().add(c8);s74_107.getColumns().add(c9);
		
		s74_107.getRows().add(r4);s74_107.getRows().add(r5);s74_107.getRows().add(r6);
		
		/** set the ninth square */
		s77_1010.getColumns().add(c7);s77_1010.getColumns().add(c8);s77_1010.getColumns().add(c9);
		
		s77_1010.getRows().add(r7);s77_1010.getRows().add(r8);s77_1010.getRows().add(r9);
		
		/** set the second square */
		s41_74.getColumns().add(c4);s41_74.getColumns().add(c5);s41_74.getColumns().add(c6);
		
		s41_74.getRows().add(r1);s41_74.getRows().add(r2);s41_74.getRows().add(r3);
		
		/** set the fifth square */
		s44_77.getColumns().add(c4);s44_77.getColumns().add(c5);s44_77.getColumns().add(c6);
		
		s44_77.getRows().add(r4);s44_77.getRows().add(r5);s44_77.getRows().add(r6);
		
		/** set the eighth square */
		s47_710.getColumns().add(c4);s47_710.getColumns().add(c5);s47_710.getColumns().add(c6);
		
		s47_710.getRows().add(r7);s47_710.getRows().add(r8);s47_710.getRows().add(r9);
		
		/** set the first square */
		s11_44.getColumns().add(c1);s11_44.getColumns().add(c2);s11_44.getColumns().add(c3);
		
		s11_44.getRows().add(r1);s11_44.getRows().add(r2);s11_44.getRows().add(r3);
		
		/** set the fourth square */
		s14_47.getColumns().add(c1);s14_47.getColumns().add(c2);s14_47.getColumns().add(c3);
		
		s14_47.getRows().add(r4);s14_47.getRows().add(r5);s14_47.getRows().add(r6);
		
		/** set the seventh square */
		s17_410.getColumns().add(c1);s17_410.getColumns().add(c2);s17_410.getColumns().add(c3);
		
		s17_410.getRows().add(r7);s17_410.getRows().add(r8);s17_410.getRows().add(r9);
	}
	
	private void populateSquareWithSqrRowsAndSqrColumns(){
		 
		/** set the third square */
		s71_104.getSquareColumns().add(sqr3Col1);s71_104.getSquareColumns().add(sqr3Col2);s71_104.getSquareColumns().add(sqr3Col3);		
		
		s71_104.getSquareRows().add(sqr3Row1);s71_104.getSquareRows().add(sqr3Row2);s71_104.getSquareRows().add(sqr3Row3);
		
		/** set the sixth square */
		s74_107.getSquareColumns().add(sqr6Col1);s74_107.getSquareColumns().add(sqr6Col2);s74_107.getSquareColumns().add(sqr6Col3);
		
		s74_107.getSquareRows().add(sqr6Row1);s74_107.getSquareRows().add(sqr6Row2);s74_107.getSquareRows().add(sqr6Row3);
		
		/** set the ninth square */
		s77_1010.getSquareColumns().add(sqr9Col1);s77_1010.getSquareColumns().add(sqr9Col2);s77_1010.getSquareColumns().add(sqr9Col3);
		
		s77_1010.getSquareRows().add(sqr9Row1);s77_1010.getSquareRows().add(sqr9Row2);s77_1010.getSquareRows().add(sqr9Row3);
		
		/** set the second square */
		s41_74.getSquareColumns().add(sqr2Col1);s41_74.getSquareColumns().add(sqr2Col2);s41_74.getSquareColumns().add(sqr2Col3);
		
		s41_74.getSquareRows().add(sqr2Row1);s41_74.getSquareRows().add(sqr2Row2);s41_74.getSquareRows().add(sqr2Row3);
		
		/** set the fifth square */
		s44_77.getSquareColumns().add(sqr5Col1);s44_77.getSquareColumns().add(sqr5Col2);s44_77.getSquareColumns().add(sqr5Col3);
		
		s44_77.getSquareRows().add(sqr5Row1);s44_77.getSquareRows().add(sqr5Row2);s44_77.getSquareRows().add(sqr5Row3);
		
		/** set the eighth square */
		s47_710.getSquareColumns().add(sqr8Col1);s47_710.getSquareColumns().add(sqr8Col2);s47_710.getSquareColumns().add(sqr8Col3);
		
		s47_710.getSquareRows().add(sqr8Row1);s47_710.getSquareRows().add(sqr8Row2);s47_710.getSquareRows().add(sqr8Row3);
		
		/** set the first square */
		s11_44.getSquareColumns().add(sqr1Col1);s11_44.getSquareColumns().add(sqr1Col2);s11_44.getSquareColumns().add(sqr1Col3);
		
		s11_44.getSquareRows().add(sqr1Row1);s11_44.getSquareRows().add(sqr1Row2);s11_44.getSquareRows().add(sqr1Row3);
		
		/** set the fourth square */
		s14_47.getSquareColumns().add(sqr4Col1);s14_47.getSquareColumns().add(sqr4Col2);s14_47.getSquareColumns().add(sqr4Col3);
		
		s14_47.getSquareRows().add(sqr4Row1);s14_47.getSquareRows().add(sqr4Row2);s14_47.getSquareRows().add(sqr4Row3);
		
		/** set the seventh square */
		s17_410.getSquareColumns().add(sqr7Col1);s17_410.getSquareColumns().add(sqr7Col2);s17_410.getSquareColumns().add(sqr7Col3);
		
		s17_410.getSquareRows().add(sqr7Row1);s17_410.getSquareRows().add(sqr7Row2);s17_410.getSquareRows().add(sqr7Row3);
		
	}
	
	private void setUpCellWithRowAndColumnAndSquare(Cell cell,Row row , Column col, Square square,SquareRow squareRow,SquareColumn squareCol){
		cell.setRow(row);
		cell.setColumn(col);
		cell.setSquare(square);
		cell.setSquareColumn(squareCol);
		cell.setSquareRow(squareRow);
	}

	private void populateSquareWithCells() {
		
		/** setting up each square  with cells */
		Set sqrCells1 = new HashSet(); Set sqrCells2 = new HashSet(); Set sqrCells3 = new HashSet();
		Set sqrCells4 = new HashSet(); Set sqrCells5 = new HashSet(); Set sqrCells6 = new HashSet();
		Set sqrCells7 = new HashSet(); Set sqrCells8 = new HashSet(); Set sqrCells9 = new HashSet();
		
		
		// #sqr 1
		sqrCells1.add(c11);sqrCells1.add(c21);sqrCells1.add(c31);
		sqrCells1.add(c12);sqrCells1.add(c22);sqrCells1.add(c32);
		sqrCells1.add(c13);sqrCells1.add(c23);sqrCells1.add(c33);
		
		// #sqr 4
		sqrCells4.add(c14);sqrCells4.add(c24);sqrCells4.add(c34);
		sqrCells4.add(c15);sqrCells4.add(c25);sqrCells4.add(c35);
		sqrCells4.add(c16);sqrCells4.add(c26);sqrCells4.add(c36);
		
		// #sqr 7
		sqrCells7.add(c17);sqrCells7.add(c27);sqrCells7.add(c37);
		sqrCells7.add(c18);sqrCells7.add(c28);sqrCells7.add(c38);
		sqrCells7.add(c19);sqrCells7.add(c29);sqrCells7.add(c39);
		
		//####################################################################
		
		// #sqr 2
		sqrCells2.add(c41);sqrCells2.add(c51);sqrCells2.add(c61);
		sqrCells2.add(c42);sqrCells2.add(c52);sqrCells2.add(c62);
		sqrCells2.add(c43);sqrCells2.add(c53);sqrCells2.add(c63);
		
		// #sqr 5
		sqrCells5.add(c44);sqrCells5.add(c54);sqrCells5.add(c64);
		sqrCells5.add(c45);sqrCells5.add(c55);sqrCells5.add(c65);
		sqrCells5.add(c46);sqrCells5.add(c56);sqrCells5.add(c66);
		
		// #sqr 8
		sqrCells8.add(c47);sqrCells8.add(c57);sqrCells8.add(c67);
		sqrCells8.add(c48);sqrCells8.add(c58);sqrCells8.add(c68);
		sqrCells8.add(c49);sqrCells8.add(c59);sqrCells8.add(c69);	
		
		//####################################################################
		
		 // #sqr 3
		sqrCells3.add(c71);sqrCells3.add(c81);sqrCells3.add(c91);
		sqrCells3.add(c72);sqrCells3.add(c82);sqrCells3.add(c92);
		sqrCells3.add(c73);sqrCells3.add(c83);sqrCells3.add(c93);	
		
		// #sqr 6
		sqrCells6.add(c74);sqrCells6.add(c84);sqrCells6.add(c94);
		sqrCells6.add(c75);sqrCells6.add(c85);sqrCells6.add(c95);
		sqrCells6.add(c76);sqrCells6.add(c86);sqrCells6.add(c96);	
	
		// #sqr 9
		sqrCells9.add(c77);sqrCells9.add(c87);sqrCells9.add(c97);
		sqrCells9.add(c78);sqrCells9.add(c88);sqrCells9.add(c98);
		sqrCells9.add(c79);sqrCells9.add(c89);sqrCells9.add(c99);
		
		s11_44.setCells(sqrCells1);s14_47.setCells(sqrCells4);s17_410.setCells(sqrCells7);
		
		s41_74.setCells(sqrCells2);s44_77.setCells(sqrCells5);s47_710.setCells(sqrCells8);
		
		s71_104.setCells(sqrCells3);s74_107.setCells(sqrCells6);s77_1010.setCells(sqrCells9);	
	}
	
	private void populateSquaresList(){
		totalSquares.add(s11_44);
		totalSquares.add(s14_47);
		totalSquares.add(s17_410);
		
		totalSquares.add(s41_74);
		totalSquares.add(s44_77);
		totalSquares.add(s47_710);
		
		totalSquares.add(s71_104);
		totalSquares.add(s74_107);
		totalSquares.add(s77_1010);
	}
	
	private void setUpSquareNames() {
		/** set names to squares */
		s11_44.setName("s11_44");
		s14_47.setName("s14_47");
		s17_410.setName("s17_410");
		s41_74.setName("s41_74");
		s44_77.setName("s44_77");
		s47_710.setName("s47_710");
		s71_104.setName("s71_104");
		s74_107.setName("s74_107");
		s77_1010.setName("s77_1010");	
	}

	private void setUpColumnNames() {
		/** set the names of each column */
		c1.setName("c1");c2.setName("c2");c3.setName("c3");c4.setName("c4");c5.setName("c5");
		c6.setName("c6");c7.setName("c7");c8.setName("c8");c9.setName("c9");
	}

	private void setUpRowNames() {
		/** set the names of each row */
		r1.setName("r1");r2.setName("r2");r3.setName("r3");r4.setName("r4");r5.setName("r5");
		r6.setName("r6");r7.setName("r7");r8.setName("r8");r9.setName("r9");
	}
	
	private void setUpSqrRowNames() {
		
		sqr1Row1.setName("sqr1Row1");sqr1Row2.setName("sqr1Row2");sqr1Row3.setName("sqr1Row3");
		sqr2Row1.setName("sqr2Row1");sqr2Row2.setName("sqr2Row2");sqr2Row3.setName("sqr2Row3");
		sqr3Row1.setName("sqr3Row1");sqr3Row2.setName("sqr3Row2");sqr3Row3.setName("sqr3Row3");
		
		sqr4Row1.setName("sqr4Row1");sqr4Row2.setName("sqr4Row2");sqr4Row3.setName("sqr4Row3");
		sqr5Row1.setName("sqr5Row1");sqr5Row2.setName("sqr5Row2");sqr5Row3.setName("sqr5Row3");
		sqr6Row1.setName("sqr6Row1");sqr6Row2.setName("sqr6Row2");sqr6Row3.setName("sqr6Row3");
		
		sqr7Row1.setName("sqr7Row1");sqr7Row2.setName("sqr7Row2");sqr7Row3.setName("sqr7Row3");
		sqr8Row1.setName("sqr8Row1");sqr8Row2.setName("sqr8Row2");sqr8Row3.setName("sqr8Row3");
		sqr9Row1.setName("sqr9Row1");sqr9Row2.setName("sqr9Row2");sqr9Row3.setName("sqr9Row3");
	}
	
	private void setUpSqrColNames() {
		
		sqr1Col1.setName("sqr1Col1");sqr1Col2.setName("sqr1Col2");sqr1Col3.setName("sqr1Col3");
		sqr2Col1.setName("sqr2Col1");sqr2Col2.setName("sqr2Col2");sqr2Col3.setName("sqr2Col3");
		sqr3Col1.setName("sqr3Col1");sqr3Col2.setName("sqr3Col2");sqr3Col3.setName("sqr3Col3");
		
		sqr4Col1.setName("sqr4Col1");sqr4Col2.setName("sqr4Col2");sqr4Col3.setName("sqr4Col3");
		sqr5Col1.setName("sqr5Col1");sqr5Col2.setName("sqr5Col2");sqr5Col3.setName("sqr5Col3");
		sqr6Col1.setName("sqr6Col1");sqr6Col2.setName("sqr6Col2");sqr6Col3.setName("sqr6Col3");
		
		sqr7Col1.setName("sqr7Col1");sqr7Col2.setName("sqr7Col2");sqr7Col3.setName("sqr7Col3");
		sqr8Col1.setName("sqr8Col1");sqr8Col2.setName("sqr8Col2");sqr8Col3.setName("sqr8Col3");
		sqr9Col1.setName("sqr9Col1");sqr9Col2.setName("sqr9Col2");sqr9Col3.setName("sqr9Col3");
	}
	

	private void setUpCellNames() {
		/** set the names of each cell */
		c11.setName("c11");c21.setName("c21");c31.setName("c31");
		c41.setName("c41");c51.setName("c51");c61.setName("c61");
		c71.setName("c71");c81.setName("c81");c91.setName("c91");
		
		c12.setName("c12");c22.setName("c22");c32.setName("c32");
		c42.setName("c42");c52.setName("c52");c62.setName("c62");
		c72.setName("c72");c82.setName("c82");c92.setName("c92");
		
		c13.setName("c13");c23.setName("c23");c33.setName("c33");
		c43.setName("c43");c53.setName("c53");c63.setName("c63");
		c73.setName("c73");c83.setName("c83");c93.setName("c93");
		
		c14.setName("c14");c24.setName("c24");c34.setName("c34");
		c44.setName("c44");c54.setName("c54");c64.setName("c64");
		c74.setName("c74");c84.setName("c84");c94.setName("c94");
		
		c15.setName("c15");c25.setName("c25");c35.setName("c35");
		c45.setName("c45");c55.setName("c55");c65.setName("c65");
		c75.setName("c75");c85.setName("c85");c95.setName("c95");
		
		c16.setName("c16");c26.setName("c26");c36.setName("c36");
		c46.setName("c46");c56.setName("c56");c66.setName("c66");
		c76.setName("c76");c86.setName("c86");c96.setName("c96");
		
		c17.setName("c17");c27.setName("c27");c37.setName("c37");
		c47.setName("c47");c57.setName("c57");c67.setName("c67");
		c77.setName("c77");c87.setName("c87");c97.setName("c97");
		
		c18.setName("c18");c28.setName("c28");c38.setName("c38");
		c48.setName("c48");c58.setName("c58");c68.setName("c68");
		c78.setName("c78");c88.setName("c88");c98.setName("c98");
		
		c19.setName("c19");c29.setName("c29");c39.setName("c39");
		c49.setName("c49");c59.setName("c59");c69.setName("c69");
		c79.setName("c79");c89.setName("c89");c99.setName("c99");
	}

	private void populateRowsWithCells() {
		/** setting up each row with cells */
		Set rowCells1 = new HashSet(); Set  rowCells2 = new HashSet(); Set  rowCells3 = new HashSet();
		Set rowCells4 = new HashSet(); Set  rowCells5 = new HashSet(); Set  rowCells6 = new HashSet();
		Set rowCells7 = new HashSet(); Set  rowCells8 = new HashSet(); Set  rowCells9 = new HashSet();
		
		rowCells1.add(c11);rowCells1.add(c21);rowCells1.add(c31);
		rowCells1.add(c41);rowCells1.add(c51);rowCells1.add(c61);
		rowCells1.add(c71);rowCells1.add(c81);rowCells1.add(c91);
		
		rowCells2.add(c12);rowCells2.add(c22);rowCells2.add(c32);
		rowCells2.add(c42);rowCells2.add(c52);rowCells2.add(c62);
		rowCells2.add(c72);rowCells2.add(c82);rowCells2.add(c92);
		
		rowCells3.add(c13);rowCells3.add(c23);rowCells3.add(c33);
		rowCells3.add(c43);rowCells3.add(c53);rowCells3.add(c63);
		rowCells3.add(c73);rowCells3.add(c83);rowCells3.add(c93);
		
		rowCells4.add(c14);rowCells4.add(c24);rowCells4.add(c34);
		rowCells4.add(c44);rowCells4.add(c54);rowCells4.add(c64);
		rowCells4.add(c74);rowCells4.add(c84);rowCells4.add(c94);
		
		rowCells5.add(c15);rowCells5.add(c25);rowCells5.add(c35);
		rowCells5.add(c45);rowCells5.add(c55);rowCells5.add(c65);
		rowCells5.add(c75);rowCells5.add(c85);rowCells5.add(c95);
		
		rowCells6.add(c16);rowCells6.add(c26);rowCells6.add(c36);
		rowCells6.add(c46);rowCells6.add(c56);rowCells6.add(c66);
		rowCells6.add(c76);rowCells6.add(c86);rowCells6.add(c96);
		
		rowCells7.add(c17);rowCells7.add(c27);rowCells7.add(c37);
		rowCells7.add(c47);rowCells7.add(c57);rowCells7.add(c67);
		rowCells7.add(c77);rowCells7.add(c87);rowCells7.add(c97);
		
		rowCells8.add(c18);rowCells8.add(c28);rowCells8.add(c38);
		rowCells8.add(c48);rowCells8.add(c58);rowCells8.add(c68);
		rowCells8.add(c78);rowCells8.add(c88);rowCells8.add(c98);
		
		rowCells9.add(c19);rowCells9.add(c29);rowCells9.add(c39);
		rowCells9.add(c49);rowCells9.add(c59);rowCells9.add(c69);
		rowCells9.add(c79);rowCells9.add(c89);rowCells9.add(c99);
			
		this.r1.setCells(rowCells1);this.r2.setCells(rowCells2);this.r3.setCells(rowCells3);
		this.r4.setCells(rowCells4);this.r5.setCells(rowCells5);this.r6.setCells(rowCells6);
		this.r7.setCells(rowCells7);this.r8.setCells(rowCells8);this.r9.setCells(rowCells9);
	}
	
	
	private void populateSqrRowsAndColumnsWithCells() {
		
		// # first square		
		sqr1Row1.getCells().add(c11);sqr1Row1.getCells().add(c21);sqr1Row1.getCells().add(c31);
		sqr1Row2.getCells().add(c12);sqr1Row2.getCells().add(c22);sqr1Row2.getCells().add(c32);
		sqr1Row3.getCells().add(c13);sqr1Row3.getCells().add(c23);sqr1Row3.getCells().add(c33);
		
		sqr1Col1.getCells().add(c11);sqr1Col1.getCells().add(c12);sqr1Col1.getCells().add(c13);
		sqr1Col2.getCells().add(c21);sqr1Col2.getCells().add(c22);sqr1Col2.getCells().add(c23);
		sqr1Col3.getCells().add(c31);sqr1Col3.getCells().add(c32);sqr1Col3.getCells().add(c33);
		
		//	# fourth square		
		sqr4Row1.getCells().add(c14);sqr4Row1.getCells().add(c24);sqr4Row1.getCells().add(c34);
		sqr4Row2.getCells().add(c15);sqr4Row2.getCells().add(c25);sqr4Row2.getCells().add(c35);
		sqr4Row3.getCells().add(c16);sqr4Row3.getCells().add(c26);sqr4Row3.getCells().add(c36);
		
		sqr4Col1.getCells().add(c14);sqr4Col1.getCells().add(c15);sqr4Col1.getCells().add(c16);
		sqr4Col2.getCells().add(c24);sqr4Col2.getCells().add(c25);sqr4Col2.getCells().add(c26);
		sqr4Col3.getCells().add(c34);sqr4Col3.getCells().add(c35);sqr4Col3.getCells().add(c36);
		
		//	# seventh square		
		sqr7Row1.getCells().add(c17);sqr7Row1.getCells().add(c27);sqr7Row1.getCells().add(c37);
		sqr7Row2.getCells().add(c18);sqr7Row2.getCells().add(c28);sqr7Row2.getCells().add(c38);
		sqr7Row3.getCells().add(c19);sqr7Row3.getCells().add(c29);sqr7Row3.getCells().add(c39);
		
		sqr7Col1.getCells().add(c17);sqr7Col1.getCells().add(c18);sqr7Col1.getCells().add(c19);
		sqr7Col2.getCells().add(c27);sqr7Col2.getCells().add(c28);sqr7Col2.getCells().add(c29);
		sqr7Col3.getCells().add(c37);sqr7Col3.getCells().add(c38);sqr7Col3.getCells().add(c39);
				
		//	# second square				
		sqr2Row1.getCells().add(c41);sqr2Row1.getCells().add(c51);sqr2Row1.getCells().add(c61);
		sqr2Row2.getCells().add(c42);sqr2Row2.getCells().add(c52);sqr2Row2.getCells().add(c62);
		sqr2Row3.getCells().add(c43);sqr2Row3.getCells().add(c53);sqr2Row3.getCells().add(c63);
		
		sqr2Col1.getCells().add(c41);sqr2Col1.getCells().add(c42);sqr2Col1.getCells().add(c43);
		sqr2Col2.getCells().add(c51);sqr2Col2.getCells().add(c52);sqr2Col2.getCells().add(c53);
		sqr2Col3.getCells().add(c61);sqr2Col3.getCells().add(c62);sqr2Col3.getCells().add(c63);
		
		//	# fifth square				
		sqr5Row1.getCells().add(c44);sqr5Row1.getCells().add(c54);sqr5Row1.getCells().add(c64);
		sqr5Row2.getCells().add(c45);sqr5Row2.getCells().add(c55);sqr5Row2.getCells().add(c65);
		sqr5Row3.getCells().add(c46);sqr5Row3.getCells().add(c56);sqr5Row3.getCells().add(c66);
		
		sqr5Col1.getCells().add(c44);sqr5Col1.getCells().add(c45);sqr5Col1.getCells().add(c46);
		sqr5Col2.getCells().add(c54);sqr5Col2.getCells().add(c55);sqr5Col2.getCells().add(c56);
		sqr5Col3.getCells().add(c64);sqr5Col3.getCells().add(c65);sqr5Col3.getCells().add(c66);
		
		//	# eigth square				
		sqr8Row1.getCells().add(c47);sqr8Row1.getCells().add(c57);sqr8Row1.getCells().add(c67);
		sqr8Row2.getCells().add(c48);sqr8Row2.getCells().add(c58);sqr8Row2.getCells().add(c68);
		sqr8Row3.getCells().add(c49);sqr8Row3.getCells().add(c59);sqr8Row3.getCells().add(c69);
		
		sqr8Col1.getCells().add(c47);sqr8Col1.getCells().add(c48);sqr8Col1.getCells().add(c49);
		sqr8Col2.getCells().add(c57);sqr8Col2.getCells().add(c58);sqr8Col2.getCells().add(c59);
		sqr8Col3.getCells().add(c67);sqr8Col3.getCells().add(c68);sqr8Col3.getCells().add(c69);
		
		//	# third square				
		sqr3Row1.getCells().add(c71);sqr3Row1.getCells().add(c81);sqr3Row1.getCells().add(c91);
		sqr3Row2.getCells().add(c72);sqr3Row2.getCells().add(c82);sqr3Row2.getCells().add(c92);
		sqr3Row3.getCells().add(c73);sqr3Row3.getCells().add(c83);sqr3Row3.getCells().add(c93);
		
		sqr3Col1.getCells().add(c71);sqr3Col1.getCells().add(c72);sqr3Col1.getCells().add(c73);
		sqr3Col2.getCells().add(c81);sqr3Col2.getCells().add(c82);sqr3Col2.getCells().add(c83);
		sqr3Col3.getCells().add(c91);sqr3Col3.getCells().add(c92);sqr3Col3.getCells().add(c93);
		
		//	# sixth square				
		sqr6Row1.getCells().add(c74);sqr6Row1.getCells().add(c84);sqr6Row1.getCells().add(c94);
		sqr6Row2.getCells().add(c75);sqr6Row2.getCells().add(c85);sqr6Row2.getCells().add(c95);
		sqr6Row3.getCells().add(c76);sqr6Row3.getCells().add(c86);sqr6Row3.getCells().add(c96);
		
		sqr6Col1.getCells().add(c74);sqr6Col1.getCells().add(c75);sqr6Col1.getCells().add(c76);
		sqr6Col2.getCells().add(c84);sqr6Col2.getCells().add(c85);sqr6Col2.getCells().add(c86);
		sqr6Col3.getCells().add(c94);sqr6Col3.getCells().add(c95);sqr6Col3.getCells().add(c96);
		
		//	# ninth square				
		sqr9Row1.getCells().add(c77);sqr9Row1.getCells().add(c87);sqr9Row1.getCells().add(c97);
		sqr9Row2.getCells().add(c78);sqr9Row2.getCells().add(c88);sqr9Row2.getCells().add(c98);
		sqr9Row3.getCells().add(c79);sqr9Row3.getCells().add(c89);sqr9Row3.getCells().add(c99);
		
		sqr9Col1.getCells().add(c77);sqr9Col1.getCells().add(c78);sqr9Col1.getCells().add(c79);
		sqr9Col2.getCells().add(c87);sqr9Col2.getCells().add(c88);sqr9Col2.getCells().add(c89);
		sqr9Col3.getCells().add(c97);sqr9Col3.getCells().add(c98);sqr9Col3.getCells().add(c99);
	
	}
	

	private void populateColumnsWithCells() {
		/** setting up each row with cells */
		Set colCells1 = new HashSet(); Set  colCells2 = new HashSet(); Set  colCells3 = new HashSet();
		Set colCells4 = new HashSet(); Set  colCells5 = new HashSet(); Set  colCells6 = new HashSet();
		Set colCells7 = new HashSet(); Set  colCells8 = new HashSet(); Set  colCells9 = new HashSet();
		
		colCells1.add(c11);colCells1.add(c12);colCells1.add(c13);
		colCells1.add(c14);colCells1.add(c15);colCells1.add(c16);
		colCells1.add(c17);colCells1.add(c18);colCells1.add(c19);
		
		colCells2.add(c21);colCells2.add(c22);colCells2.add(c23);
		colCells2.add(c24);colCells2.add(c25);colCells2.add(c26);
		colCells2.add(c27);colCells2.add(c28);colCells2.add(c29);
		
		colCells3.add(c31);colCells3.add(c32);colCells3.add(c33);
		colCells3.add(c34);colCells3.add(c35);colCells3.add(c36);
		colCells3.add(c37);colCells3.add(c38);colCells3.add(c39);
		
		colCells4.add(c41);colCells4.add(c42);colCells4.add(c43);
		colCells4.add(c44);colCells4.add(c45);colCells4.add(c46);
		colCells4.add(c47);colCells4.add(c48);colCells4.add(c49);
		
		colCells5.add(c51);colCells5.add(c52);colCells5.add(c53);
		colCells5.add(c54);colCells5.add(c55);colCells5.add(c56);
		colCells5.add(c57);colCells5.add(c58);colCells5.add(c59);
		
		colCells6.add(c61);colCells6.add(c62);colCells6.add(c63);
		colCells6.add(c64);colCells6.add(c65);colCells6.add(c66);
		colCells6.add(c67);colCells6.add(c68);colCells6.add(c69);
		
		colCells7.add(c71);colCells7.add(c72);colCells7.add(c73);
		colCells7.add(c74);colCells7.add(c75);colCells7.add(c76);
		colCells7.add(c77);colCells7.add(c78);colCells7.add(c79);
		
		colCells8.add(c81);colCells8.add(c82);colCells8.add(c83);
		colCells8.add(c84);colCells8.add(c85);colCells8.add(c86);
		colCells8.add(c87);colCells8.add(c88);colCells8.add(c89);
		
		colCells9.add(c91);colCells9.add(c92);colCells9.add(c93);
		colCells9.add(c94);colCells9.add(c95);colCells9.add(c96);
		colCells9.add(c97);colCells9.add(c98);colCells9.add(c99);
			
		
		this.c1.setCells(colCells1);this.c2.setCells(colCells2);this.c3.setCells(colCells3);
		this.c4.setCells(colCells4);this.c5.setCells(colCells5);this.c6.setCells(colCells6);
		this.c7.setCells(colCells7);this.c8.setCells(colCells8);this.c9.setCells(colCells9);
	}

	public List getTotalSquares() {
		return totalSquares;
	}

	public void setTotalSquares(List totalSquares) {
		this.totalSquares = totalSquares;
	}
	
	private void populateRowWithSquareRows(){
		r1.getSquareRows().add(sqr1Row1);r1.getSquareRows().add(sqr2Row1);r1.getSquareRows().add(sqr3Row1);
		r2.getSquareRows().add(sqr1Row2);r2.getSquareRows().add(sqr2Row2);r2.getSquareRows().add(sqr3Row2);
		r3.getSquareRows().add(sqr1Row3);r3.getSquareRows().add(sqr2Row3);r3.getSquareRows().add(sqr3Row3);
		
		r4.getSquareRows().add(sqr4Row1);r4.getSquareRows().add(sqr5Row1);r4.getSquareRows().add(sqr6Row1);
		r5.getSquareRows().add(sqr4Row2);r5.getSquareRows().add(sqr5Row2);r5.getSquareRows().add(sqr6Row2);
		r6.getSquareRows().add(sqr4Row3);r6.getSquareRows().add(sqr5Row3);r6.getSquareRows().add(sqr6Row3);
		
		r7.getSquareRows().add(sqr7Row1);r7.getSquareRows().add(sqr8Row1);r7.getSquareRows().add(sqr9Row1);
		r8.getSquareRows().add(sqr7Row2);r8.getSquareRows().add(sqr8Row2);r8.getSquareRows().add(sqr9Row2);
		r9.getSquareRows().add(sqr7Row3);r9.getSquareRows().add(sqr8Row3);r9.getSquareRows().add(sqr9Row3);		
	}
	
	private void populateColumnWithSquareColumns(){
		c1.getSquareColumns().add(sqr1Col1);c1.getSquareColumns().add(sqr4Col1);c1.getSquareColumns().add(sqr7Col1);
		c2.getSquareColumns().add(sqr1Col2);c2.getSquareColumns().add(sqr4Col2);c2.getSquareColumns().add(sqr7Col2);
		c3.getSquareColumns().add(sqr1Col3);c3.getSquareColumns().add(sqr4Col3);c3.getSquareColumns().add(sqr7Col3);
		
		c4.getSquareColumns().add(sqr2Col1);c4.getSquareColumns().add(sqr5Col1);c4.getSquareColumns().add(sqr8Col1);
		c5.getSquareColumns().add(sqr2Col2);c5.getSquareColumns().add(sqr5Col2);c5.getSquareColumns().add(sqr8Col2);
		c6.getSquareColumns().add(sqr2Col3);c6.getSquareColumns().add(sqr5Col3);c6.getSquareColumns().add(sqr8Col3);
		
		c7.getSquareColumns().add(sqr3Col1);c7.getSquareColumns().add(sqr6Col1);c7.getSquareColumns().add(sqr9Col1);
		c8.getSquareColumns().add(sqr3Col2);c8.getSquareColumns().add(sqr6Col2);c8.getSquareColumns().add(sqr9Col2);
		c9.getSquareColumns().add(sqr3Col3);c9.getSquareColumns().add(sqr6Col3);c9.getSquareColumns().add(sqr9Col3);		
	}
	
	
	
	private void populateCellWithRowAndColumnAndSquare() {
		// cells of sqr#1
		setUpCellWithRowAndColumnAndSquare(c11,r1,c1,s11_44,sqr1Row1,sqr1Col1);
		setUpCellWithRowAndColumnAndSquare(c21,r1,c2,s11_44,sqr1Row1,sqr1Col2);
		setUpCellWithRowAndColumnAndSquare(c31,r1,c3,s11_44,sqr1Row1,sqr1Col3);
		
		setUpCellWithRowAndColumnAndSquare(c12,r2,c1,s11_44,sqr1Row2,sqr1Col1);
		setUpCellWithRowAndColumnAndSquare(c22,r2,c2,s11_44,sqr1Row2,sqr1Col2);
		setUpCellWithRowAndColumnAndSquare(c32,r2,c3,s11_44,sqr1Row2,sqr1Col3);
		
		setUpCellWithRowAndColumnAndSquare(c13,r3,c1,s11_44,sqr1Row3,sqr1Col1);
		setUpCellWithRowAndColumnAndSquare(c23,r3,c2,s11_44,sqr1Row3,sqr1Col2);
		setUpCellWithRowAndColumnAndSquare(c33,r3,c3,s11_44,sqr1Row3,sqr1Col3);
		
		// cells of sqr#4
		setUpCellWithRowAndColumnAndSquare(c14,r4,c1,s14_47,sqr4Row1,sqr4Col1);
		setUpCellWithRowAndColumnAndSquare(c24,r4,c2,s14_47,sqr4Row1,sqr4Col2);
		setUpCellWithRowAndColumnAndSquare(c34,r4,c3,s14_47,sqr4Row1,sqr4Col3);
		
		setUpCellWithRowAndColumnAndSquare(c15,r5,c1,s14_47,sqr4Row2,sqr4Col1);
		setUpCellWithRowAndColumnAndSquare(c25,r5,c2,s14_47,sqr4Row2,sqr4Col2);
		setUpCellWithRowAndColumnAndSquare(c35,r5,c3,s14_47,sqr4Row2,sqr4Col3);
		
		setUpCellWithRowAndColumnAndSquare(c16,r6,c1,s14_47,sqr4Row3,sqr4Col1);
		setUpCellWithRowAndColumnAndSquare(c26,r6,c2,s14_47,sqr4Row3,sqr4Col2);
		setUpCellWithRowAndColumnAndSquare(c36,r6,c3,s14_47,sqr4Row3,sqr4Col3);
		
		// cells of sqr#7
		setUpCellWithRowAndColumnAndSquare(c17,r7,c1,s17_410,sqr7Row1,sqr7Col1);
		setUpCellWithRowAndColumnAndSquare(c27,r7,c2,s17_410,sqr7Row1,sqr7Col2);
		setUpCellWithRowAndColumnAndSquare(c37,r7,c3,s17_410,sqr7Row1,sqr7Col3);
		
		setUpCellWithRowAndColumnAndSquare(c18,r8,c1,s17_410,sqr7Row2,sqr7Col1);
		setUpCellWithRowAndColumnAndSquare(c28,r8,c2,s17_410,sqr7Row2,sqr7Col2);
		setUpCellWithRowAndColumnAndSquare(c38,r8,c3,s17_410,sqr7Row2,sqr7Col3);
		
		setUpCellWithRowAndColumnAndSquare(c19,r9,c1,s17_410,sqr7Row3,sqr7Col1);
		setUpCellWithRowAndColumnAndSquare(c29,r9,c2,s17_410,sqr7Row3,sqr7Col2);
		setUpCellWithRowAndColumnAndSquare(c39,r9,c3,s17_410,sqr7Row3,sqr7Col3);
		
		// cells of sqr#2
		setUpCellWithRowAndColumnAndSquare(c41,r1,c4,s41_74,sqr2Row1,sqr2Col1);
		setUpCellWithRowAndColumnAndSquare(c51,r1,c5,s41_74,sqr2Row1,sqr2Col2);
		setUpCellWithRowAndColumnAndSquare(c61,r1,c6,s41_74,sqr2Row1,sqr2Col3);
		
		setUpCellWithRowAndColumnAndSquare(c42,r2,c4,s41_74,sqr2Row2,sqr2Col1);
		setUpCellWithRowAndColumnAndSquare(c52,r2,c5,s41_74,sqr2Row2,sqr2Col2);
		setUpCellWithRowAndColumnAndSquare(c62,r2,c6,s41_74,sqr2Row2,sqr2Col3);
		
		setUpCellWithRowAndColumnAndSquare(c43,r3,c4,s41_74,sqr2Row3,sqr2Col1);
		setUpCellWithRowAndColumnAndSquare(c53,r3,c5,s41_74,sqr2Row3,sqr2Col2);
		setUpCellWithRowAndColumnAndSquare(c63,r3,c6,s41_74,sqr2Row3,sqr2Col3);
		
		// cells of sqr#5
		setUpCellWithRowAndColumnAndSquare(c44,r4,c4,s44_77,sqr5Row1,sqr5Col1);
		setUpCellWithRowAndColumnAndSquare(c54,r4,c5,s44_77,sqr5Row1,sqr5Col2);
		setUpCellWithRowAndColumnAndSquare(c64,r4,c6,s44_77,sqr5Row1,sqr5Col3);
		
		setUpCellWithRowAndColumnAndSquare(c45,r5,c4,s44_77,sqr5Row2,sqr5Col1);
		setUpCellWithRowAndColumnAndSquare(c55,r5,c5,s44_77,sqr5Row2,sqr5Col2);
		setUpCellWithRowAndColumnAndSquare(c65,r5,c6,s44_77,sqr5Row2,sqr5Col3);
		
		setUpCellWithRowAndColumnAndSquare(c46,r6,c4,s44_77,sqr5Row3,sqr5Col1);
		setUpCellWithRowAndColumnAndSquare(c56,r6,c5,s44_77,sqr5Row3,sqr5Col2);
		setUpCellWithRowAndColumnAndSquare(c66,r6,c6,s44_77,sqr5Row3,sqr5Col3);
		
		// cells of sqr#8
		setUpCellWithRowAndColumnAndSquare(c47,r7,c4,s47_710,sqr8Row1,sqr8Col1);
		setUpCellWithRowAndColumnAndSquare(c57,r7,c5,s47_710,sqr8Row1,sqr8Col2);
		setUpCellWithRowAndColumnAndSquare(c67,r7,c6,s47_710,sqr8Row1,sqr8Col3);
		
		setUpCellWithRowAndColumnAndSquare(c48,r8,c4,s47_710,sqr8Row2,sqr8Col1);
		setUpCellWithRowAndColumnAndSquare(c58,r8,c5,s47_710,sqr8Row2,sqr8Col2);
		setUpCellWithRowAndColumnAndSquare(c68,r8,c6,s47_710,sqr8Row2,sqr8Col3);
		
		setUpCellWithRowAndColumnAndSquare(c49,r9,c4,s47_710,sqr8Row3,sqr8Col1);
		setUpCellWithRowAndColumnAndSquare(c59,r9,c5,s47_710,sqr8Row3,sqr8Col2);
		setUpCellWithRowAndColumnAndSquare(c69,r9,c6,s47_710,sqr8Row3,sqr8Col3);
		
		// cells of sqr#3
		setUpCellWithRowAndColumnAndSquare(c71,r1,c7,s71_104,sqr3Row1,sqr3Col1);
		setUpCellWithRowAndColumnAndSquare(c81,r1,c8,s71_104,sqr3Row1,sqr3Col2);
		setUpCellWithRowAndColumnAndSquare(c91,r1,c9,s71_104,sqr3Row1,sqr3Col3);
		
		setUpCellWithRowAndColumnAndSquare(c72,r2,c7,s71_104,sqr3Row2,sqr3Col1);
		setUpCellWithRowAndColumnAndSquare(c82,r2,c8,s71_104,sqr3Row2,sqr3Col2);
		setUpCellWithRowAndColumnAndSquare(c92,r2,c9,s71_104,sqr3Row2,sqr3Col3);
		
		setUpCellWithRowAndColumnAndSquare(c73,r3,c7,s71_104,sqr3Row3,sqr3Col1);
		setUpCellWithRowAndColumnAndSquare(c83,r3,c8,s71_104,sqr3Row3,sqr3Col2);
		setUpCellWithRowAndColumnAndSquare(c93,r3,c9,s71_104,sqr3Row3,sqr3Col3);
		
		// cells of sqr#6
		setUpCellWithRowAndColumnAndSquare(c74,r4,c7,s74_107,sqr6Row1,sqr6Col1);
		setUpCellWithRowAndColumnAndSquare(c84,r4,c8,s74_107,sqr6Row1,sqr6Col2);
		setUpCellWithRowAndColumnAndSquare(c94,r4,c9,s74_107,sqr6Row1,sqr6Col3);
		
		setUpCellWithRowAndColumnAndSquare(c75,r5,c7,s74_107,sqr6Row2,sqr6Col1);
		setUpCellWithRowAndColumnAndSquare(c85,r5,c8,s74_107,sqr6Row2,sqr6Col2);
		setUpCellWithRowAndColumnAndSquare(c95,r5,c9,s74_107,sqr6Row2,sqr6Col3);
		
		setUpCellWithRowAndColumnAndSquare(c76,r6,c7,s74_107,sqr6Row3,sqr6Col1);
		setUpCellWithRowAndColumnAndSquare(c86,r6,c8,s74_107,sqr6Row3,sqr6Col2);
		setUpCellWithRowAndColumnAndSquare(c96,r6,c9,s74_107,sqr6Row3,sqr6Col3);
		
		// cells of sqr#9
		setUpCellWithRowAndColumnAndSquare(c77,r7,c7,s77_1010,sqr9Row1,sqr9Col1);
		setUpCellWithRowAndColumnAndSquare(c87,r7,c8,s77_1010,sqr9Row1,sqr9Col2);
		setUpCellWithRowAndColumnAndSquare(c97,r7,c9,s77_1010,sqr9Row1,sqr9Col3);
		
		setUpCellWithRowAndColumnAndSquare(c78,r8,c7,s77_1010,sqr9Row2,sqr9Col1);
		setUpCellWithRowAndColumnAndSquare(c88,r8,c8,s77_1010,sqr9Row2,sqr9Col2);
		setUpCellWithRowAndColumnAndSquare(c98,r8,c9,s77_1010,sqr9Row2,sqr9Col3);
		
		setUpCellWithRowAndColumnAndSquare(c79,r9,c7,s77_1010,sqr9Row3,sqr9Col1);
		setUpCellWithRowAndColumnAndSquare(c89,r9,c8,s77_1010,sqr9Row3,sqr9Col2);
		setUpCellWithRowAndColumnAndSquare(c99,r9,c9,s77_1010,sqr9Row3,sqr9Col3);
	}

	public List getTotalColumns() {
		return totalColumns;
	}

	public void setTotalColumns(List totalColumns) {
		this.totalColumns = totalColumns;
	}

	public List getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(List totalRows) {
		this.totalRows = totalRows;
	}

	public List getTotalSqrCols() {
		return totalSqrCols;
	}

	public void setTotalSqrCols(List totalSqrCols) {
		this.totalSqrCols = totalSqrCols;
	}

	public List getTotalSqrRows() {
		return totalSqrRows;
	}

	public void setTotalSqrRows(List totalSqrRows) {
		this.totalSqrRows = totalSqrRows;
	}

	public Map getTotalCells() {
		return totalCells;
	}
}
