package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RuleEngine {
	/**
	 * first run the elimination rule 
	 * for each row run elimination
	 * then for each column run elimination 
	 */ 
	
	public static void populateCell(Cell cell , int value,boolean isCalculated){
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
	
	/**
	 * POSSIBILITY #1
	 * Once a cell has a value - we need to indicate to the other square rows / square columns in the other squares 
	 * that they cannot contain the value 
	 * This is what is done by this possibility
	 * 
	 * This possibility is used for each cell that has a value 
	 * Essentially once a cell is populated we want some possibilities to get run 
	 * This is one of them
	 * For the cell that is populated get its row and column and square
	 * Iterate over each cell of row and column
	 * If cell doesnt belong to the square - then check if the square is allowed this value
	 * If allowed then it means that the square does not contain the value 
	 * Get the square row or square column for the row / column and populate the  squareRow / squareColumn 
	 * NOTALLOWEDVALUES
	 * 
	 */
	public static void runNotAllowedPossibilitiesForSquareRowColumn(Cell cell){
		if(cell.isHasValue()){
			Row row = cell.getRow();
			Column col = cell.getColumn();
			Square square = cell.getSquare();
			
			/**
			 * for each row and column
			 * get all the cells 
			 * if these cells dont belong to the square do some more checks 
			 * If the square does not contain the values then for the cell of that row get the sqrRow
			 * Populate the sqrRow that it cannot contain this value  
			 */
			Set rowCells = row.getCells();
			Set colCells = col.getCells();
			
			Iterator iter = rowCells.iterator();
			while(iter.hasNext()){
				Cell rowCell = (Cell)iter.next();
				/** the cell should not be the same and should not belong to the same aquare */
				if(rowCell != cell && rowCell.getSquare() != square){
					/** now check if the square doesnt contain this value and if so then tell the sqr row that  it cannot contain this value */
					if(!rowCell.getSquare().getnotAllowedValues().contains(String.valueOf(cell.getValue()))){
						rowCell.getSquareRow().getnotAllowedValues().add(String.valueOf(cell.getValue()));										  
					}//if  
				}
			}//while iterating over each cell of row
			
			/** do the same for column */
			Iterator colIter = colCells.iterator(); 
			while(colIter.hasNext()){
				Cell colCell = (Cell)colIter.next();
				/** the cell should not be the same and should not belong to the same aquare */
				if(colCell != cell && colCell.getSquare() != square){
					/** now check if the square doesnt contain this value and if so then tell the sqr COL that it cannot contain this value  */
					if(!colCell.getSquare().getnotAllowedValues().contains(String.valueOf(cell.getValue()))){
						colCell.getSquareColumn().getnotAllowedValues().add(String.valueOf(cell.getValue()));						
					}//if 
				}
			}//while
			//System.out.println("$$$$$$ end possibilities $$$$$");
		}		
	}
	
	/**
	 * POSSIBILITY #2
	 * Once a cell has a value - we need to indicate to the other square rows / square columns in the other squares 
	 * that they cannot contain the value 
	 * This is what is done by this possibility
	 */
	public static void runRowColMustContainPossibility(List sqrList){
		/**
		 * get each square - and get the sqr rows and sqr cols
		 * Check two rows / cols and find out if there are any common items that "cannot contain"
		 * populate the other row / col attribute "mustContain" 
		 */
		for(int i=0;i<sqrList.size();i++){
			Square sqr = (Square)sqrList.get(i);
			Set sqrRows = sqr.getSquareRows();
			Set sqrCols = sqr.getSquareColumns();
			
			SquareRow sqrR1 = null;
			SquareRow sqrR2 = null;
			SquareRow sqrR3 = null;
			SquareColumn sqrC1 = null;
			SquareColumn sqrC2 = null;
			SquareColumn sqrC3 = null;
			
			Iterator rowIter = sqrRows.iterator();
			int rowCount = 1;
			while(rowIter.hasNext()){
				if(rowCount ==1){
					sqrR1 = (SquareRow)rowIter.next();
				}else if(rowCount ==2){
					sqrR2 = (SquareRow)rowIter.next();
				}else if(rowCount == 3){
					sqrR3 = (SquareRow)rowIter.next();
				}
				rowCount++;
			}
			Iterator colIter = sqrCols.iterator();
			int colCount = 1;
			while(colIter.hasNext()){
				if(colCount ==1){
					sqrC1 = (SquareColumn)colIter.next();
				}else if(colCount ==2){
					sqrC2 = (SquareColumn)colIter.next();
				}else if(colCount == 3){
					sqrC3 = (SquareColumn)colIter.next();
				}
				colCount++;
			}//while
			
			/** now run the must contain possibility */
			sqrRowMustContainPossibility(sqrR1,sqrR2,sqrR3,sqr);
			sqrColMustContainPossibility(sqrC1,sqrC2,sqrC3,sqr);
			
			/**
			 * Possibility :: One or more cols / rows are full
			 * 
			 * Here rather than writing a huge method we are invoking the same logic thrice 
			 * we change the order of the parameters passed to make this happen 
			 * so the order of elements passed here is important
			 */			
			
			rowMustContainPossibilitySinceOtherRowsAreFull(sqrR1,sqrR2,sqrR3,sqr.getnotAllowedValues());
			rowMustContainPossibilitySinceOtherRowsAreFull(sqrR2,sqrR1,sqrR3,sqr.getnotAllowedValues());
			rowMustContainPossibilitySinceOtherRowsAreFull(sqrR3,sqrR1,sqrR2,sqr.getnotAllowedValues());
			
			columnMustContainPossibilitySinceOtherRowsAreFull(sqrC1,sqrC2,sqrC3,sqr.getnotAllowedValues());
			columnMustContainPossibilitySinceOtherRowsAreFull(sqrC2,sqrC1,sqrC3,sqr.getnotAllowedValues());
			columnMustContainPossibilitySinceOtherRowsAreFull(sqrC3,sqrC1,sqrC2,sqr.getnotAllowedValues());			
			
			/** possibility to populate the sqrRow / sqrCol if tow cells of three are full */
			rowSingleCellAvailableCannotContainPossibilityByColumnIntersect(sqrR1);
			rowSingleCellAvailableCannotContainPossibilityByColumnIntersect(sqrR2);
			rowSingleCellAvailableCannotContainPossibilityByColumnIntersect(sqrR3);
			
			colSingleCellAvailableCannotContainPossibilityByRowIntersect(sqrC1);
			colSingleCellAvailableCannotContainPossibilityByRowIntersect(sqrC2);
			colSingleCellAvailableCannotContainPossibilityByRowIntersect(sqrC3);
			
			rowColMustContainPossibilityByEachCell(sqr);			
		}//for		
	}
	/**
	 * Checks if the square is not full and then get the possible values for the square
	 * for each of the allowed values - check each cell of the square
	 * check if the column and row to which the cell belongs specifies that the value is not allowed
	 * if the value is not found in "notAllowed" for 'row" and "column" 
	 * this means that the cell "can possibly" contain this value
	 * Store such cells in a list
	 * Now store in a map - key = possible value , val = list containing cells that are candidates for value 
	 * 
	 */
	private static void rowColMustContainPossibilityByEachCell(Square sqr){
		if(!sqr.isFull){
			Map map = new HashMap();
			/** for each allowed value of the square */
			Set allowedValues = sqr.getAllowedValues();
			Iterator allowedValIter = allowedValues.iterator();
			while(allowedValIter.hasNext()){
				String val = (String)allowedValIter.next();
				/** for each allowed value get the available cells */
				Set cells = sqr.getCells();
				Iterator cellIter = cells.iterator();
				List list = new ArrayList();
				while(cellIter.hasNext()){
					Cell cell = (Cell)cellIter.next();
					if(!cell.isHasValue()){
						if(!cell.getColumn().getnotAllowedValues().contains(val) && !cell.getRow().getnotAllowedValues().contains(val)){
							/** cell is eligible for this value */
							list.add(cell);
						}//if
					}//cell doesnt have a value
				}//iterating over each cell of square - while loop
				map.put(val,list);
			}//for each allowed val of square
			
			/**
			 * now check the cells that are available for each potential val
			 * if the cells all belong to same row or square then we have a must val for that row or col
			 */
			if(map.size() > 0){
				Set entries = map.entrySet();
				Iterator it = entries.iterator();
				while (it.hasNext()) {
					Map.Entry entry = (Map.Entry) it.next();
					String key = entry.getKey().toString().trim();
					List cellCount = (List)entry.getValue();
					/** if the size of the arrayList is > 3  then dont do anything
					 */
					if(cellCount.size() <= 3){
						int count = 0;
						SquareRow sqrR1 = null;
						SquareColumn sqrC1 = null;
						boolean belongsToSameCol = false;
						boolean belongsToSameRow = false;
						/** used to indcate if it is possible to get the must contain value or not */
						boolean canCalc = true;
						
						for(int j=0;j<cellCount.size();j++){
							Cell cell = (Cell)cellCount.get(j);
							if(count == 0){
								cell = (Cell)cellCount.get(j);
								sqrR1 = cell.getSquareRow();
								sqrC1 = cell.getSquareColumn();
							}else {
								cell = (Cell)cellCount.get(j);
								/**
								 * now we can have one , two , or three cells
								 * only one cell - then go for it
								 */
								if(cellCount.size() == 1){
									/** only one cell go for it */
									sqrC1.getMustContainValues().add(key);
									sqrR1.getMustContainValues().add(key);
								}else {
									/** check if the second or third cell belongs to same row or column */
									if(cell.getSquareColumn() == sqrC1){
										belongsToSameCol = true;
									}
									if(cell.getSquareRow() == sqrR1){
										belongsToSameRow = true;
									}	
									/** now the next cell must either belong to a col or a row and if neither we cannot 
									 * definitely say whether s aspecific col or row must contain this value
									 * in such a case dont check further 
									 */
									if(cell.getSquareRow() != sqrR1 && cell.getSquareColumn() != sqrC1){
										canCalc = false;
										break;
									}
								}//cell size > 1 
							}//not the first cell
							count++;							
						}//for loop
						/** now first check if the cal says if it is even possible to deduce a "must contain " based on the boolean */
						if(canCalc){
							/** this means we may possibly be  able to deduce a "must contain" value*/
							
							/**
							 * now check if both row ind and colInd are saying true and if so then it means we have three cells 
							 * with a coalition of two cells along a row and the other coalition along the column
							 * this makes it impossible for us to calculate the "must contain" value
							 */
							if(belongsToSameCol && belongsToSameRow){
								/** do nothing - we cannot deduct " must contain " */
							}else{
								/** now check if any one is true - then that col or row must contain the value */
								if(belongsToSameCol){
									if(!sqr.getnotAllowedValues().contains(key)){
										sqrC1.getMustContainValues().add(key);
									}									
								}
								if(belongsToSameRow){
									if(!sqr.getnotAllowedValues().contains(key)){
										sqrR1.getMustContainValues().add(key);
									}									
								}
							}//does not belong to both row and column							
						}//value deduction may be possible						
					}//cell count <= 3
				}//while
			}//map size > 0						
		}//sqr not full
	}
	
	
	public static void runCellRule(Square square){
		/** run the rule only if the square is not full */
		if(!square.isFull){
			Map map = new HashMap();
			/** get the allowed values */
			Set sqrAllowedValues = square.getAllowedValues();
			/** get the cells of the square */
			Set cells = square.getCells();
			if(sqrAllowedValues != null && sqrAllowedValues.size() > 0){
				Iterator allowedValIter = sqrAllowedValues.iterator();
				while(allowedValIter.hasNext()){
					/** iterate over each allowed value */
					String val = (String)allowedValIter.next();
					/** now get each cell of the square */
					Iterator cellIter = cells.iterator();
					List allowedCells = new ArrayList();
					while(cellIter.hasNext()){
						Cell cell = (Cell)cellIter.next();
						if(!cell.isHasValue()){
						/** now check if this cell can contain this allowed value 
						 * also check its row and column if it can contain the value 
						 * if it can add the cell to a list and populate the list and allowed val to a map 
						 */
						if(!cell.getRow().getnotAllowedValues().contains(val) && !cell.getColumn().getnotAllowedValues().contains(val)){
							/** neither the row or column are preventing this cell from having this value 
							 *  also check if the sqr cols and rows of the cell 
							 *  if the sqr cells or cols specify this value in their " mustContain " - then this cell
							 *  is not a candidate - otherwise this cell is a candidate for this value
							 */
							
							if(isAllowed(cell,val,true) &&  isAllowed(cell,val,false)){
								System.out.println(" allowing cell " + cell.getName() + " for val = " + val);
								allowedCells.add(cell);
							}
							//System.out.println(" $$$$$$ got something $$$$$$");							
						}//if	
						}
					}//while loop for cell
					/** after iterating over all cells of the square for a specific allowed value 
					 * we have all the potential suitors for the damsel
					 * Store damsel as key and suitors as a collection value in a map
					 */
					map.put(val, allowedCells);
				}//while
				/** we now a map loaded with damsels and suitors ! 
				 *  Lets see if there is any damsel with only one suitor 
				 *  and if so the suitor gets the bride !
				 */
				if(map.size() > 0){
					//System.out.println("$$$$$$ map size $$$$$$$ " + map.size()); 
					Set entries = map.entrySet();
					Iterator it = entries.iterator();
					while (it.hasNext()) {
						Map.Entry entry = (Map.Entry) it.next();
						String key = entry.getKey().toString().trim();
						List cellCount = (List)entry.getValue();
						/** if the size of the arrayList is > 1
						 *  then dont do anything
						 */
						if(cellCount.size() ==1){
							//System.out.println("$$$$$$ matched $$$$$$$$ >>>> ");
							Cell listCell = (Cell)cellCount.get(0);
							/** this is the cell that should be populated if the sqr allows too*/
							if(!square.getnotAllowedValues().contains(key)){
								//System.out.println("$$$$$$ matched and populating  $$$$$$$$ >>>> ");
								populateCell(listCell, Integer.parseInt(key),true);
							}					 
						}else{
							if(square.getName().equalsIgnoreCase("s74_107")){
								//System.out.println(" ");
								//System.out.println(" the key is " + key );
								for(int j=0;j<cellCount.size();j++){
									Cell cell = (Cell)cellCount.get(j);
									//System.out.println(" suitors are : " + cell.getName());
									
								}
							}
							//System.out.println(" <<<<<< no match too many = " + cellCount.size()); 
						}
					}//while
				}//map size > 0				
			}//sqrAllowedValues size > 0
		}		
	}
	
	/**
	 * POSSIBILITY #2.5
	 * This possibility is used to populate "notAllowedValues" of squareRow based on if 
	 * two of three cells are full then 
	 * for the empty cell it gets the not allowed values for the col that intersects with this cell 
	 * These not allowed values of col are also applicable for the square row  
	 *  
	 */
	private static void rowSingleCellAvailableCannotContainPossibilityByColumnIntersect(SquareRow sqrRow){
		/** indicates that the square row is not full but has two cells full and only one cell is available */
		if(!sqrRow.isFull && sqrRow.getInitSqrRowCapacity() == 1 ){
			 /**identify the cell that is not filled */
			Set cells= sqrRow.getCells();
			Iterator iter  = cells.iterator();
			Cell cell = null;
			while(iter.hasNext()){
				/**iterate over each cell to find the empty cell */
				cell =  (Cell)iter.next();
				if(!cell.isHasValue()){
					/** now since in a sqr row this is the only cell available - then 
					 * the col for this cell can be used to determine the other not allowed values 
					 * since only one cell is available - then whatever is not allowed for col
					 * is also applicable for the sqr row
					 */
					Set colNotAllowedVals = cell.getColumn().getnotAllowedValues();
					/** add these not allowed values of col to the not allowed values of square row */
					sqrRow.getnotAllowedValues().addAll(colNotAllowedVals);
				}//cell does not have value				
			}//while
		}
	}

	/**
	 * POSSIBILITY #2.6
	 * This possibility is used to populate "notAllowedValues" of squareCol based on if 
	 * two of three cells are full then 
	 * for the empty cell it gets the not allowed values for the col that intersects with this cell 
	 * These not allowed values of col are also applicable for the square row  
	 *  
	 */
	private static void colSingleCellAvailableCannotContainPossibilityByRowIntersect(SquareColumn sqrCol){
		/** indicates that the square col is not full but has two cells full and only one cell is available */
		if(!sqrCol.isFull && sqrCol.getInitSqrColCapacity() == 1 ){
			 /**identify the cell that is not filled */
			Set cells= sqrCol.getCells();
			Iterator iter  = cells.iterator();
			Cell cell = null;
			while(iter.hasNext()){
				/**iterate over each cell to find the empty cell */
				cell =  (Cell)iter.next();
				if(!cell.isHasValue()){
					/** now since in a sqr col this is the only cell available - then 
					 * the row for this cell can be used to determine the other not allowed values 
					 * since only one cell is available - then whatever is not allowed for row
					 * is also applicable for the sqr col
					 */
					Set rowNotAllowedVals = cell.getRow().getnotAllowedValues();
					/** add these not allowed values of row to the not allowed values of square col */
					sqrCol.getnotAllowedValues().addAll(rowNotAllowedVals);
				}//cell does not have value				
			}//while
		}
	}
	
	/**
	 * POSSIBILITY #2.3
	 * This rule is used to populate "mustContain" of squareRow based on logic that if one row is full then whatever is 
	 * not allowed for the other rows must be present in the remaining row 
	 * 
	 * If any one of the square row is full then gets the not allowed values of the other two rows 
	 * Provided the "notAllowedValues" of the row are not already present in square
	 * Then the last row must contain these values 
	 * 
	 */
	private static void rowMustContainPossibilitySinceOtherRowsAreFull(SquareRow r1,SquareRow r2,SquareRow r3,Set sqrNotAllowed){
		/** if any one of the Square row is full */
		if(r1.isFull || r2.isFull || r3.isFull){
			if(r1.isFull){
				if(!r2.isFull){
					/** get the not allowed values for r2 */
					Set rowNotAllowed = r2.getnotAllowedValues();
					/** now check that the third row is not full */
					if(!r3.isFull){
						/** all the not allowed values of r2 which are not present in square must be present for r3*/						
						/** get only those vals from row not allowed which are not found in square */
						rowNotAllowed.removeAll(sqrNotAllowed);
						if(rowNotAllowed.size() > 0){
							r3.getMustContainValues().addAll(rowNotAllowed);
						}
					}
				}
				/** do the same for other row */
				if(!r3.isFull){
					/** get the not allowed values for r2 */
					Set rowNotAllowed = r3.getnotAllowedValues();
					/** now check that the third row is not full */
					if(!r2.isFull){
						/** all the not allowed values of r2 which are not present in square must be present for r3*/						
						/** get only those vals from row not allowed which are not found in square */
						rowNotAllowed.removeAll(sqrNotAllowed);
						if(rowNotAllowed.size() > 0){
							r2.getMustContainValues().addAll(rowNotAllowed);
						}
					}
				}
			}
		}//one or more  rows is full
	}
	
	/**
	 * POSSIBILITY #2.4
	 * This rule is used to populate "mustContain" of squareColumn based on logic that if one col
	 * is full then whatever is 
	 * not allowed for the other columns must be present in the remaining column 
	 * 
	 * If any one of the square col is full then gets the not allowed values of the other two columns 
	 * Provided the "notAllowedValues" of the cols are not already present in square
	 * Then the last col must contain these values 
	 * 
	 */
	private static void columnMustContainPossibilitySinceOtherRowsAreFull(SquareColumn c1,SquareColumn c2,SquareColumn c3,Set sqrNotAllowed){
		if(c1.isFull || c2.isFull || c3.isFull){
			if(c1.isFull){
				if(!c2.isFull){
					/** get the not allowed values for c2 */
					Set rowNotAllowed = c2.getnotAllowedValues();
					/** now check that the third col is not full */
					if(!c3.isFull){
						/** all the not allowed values of c2 which are not present in square must be present for c3*/						
						/** get only those vals from col not allowed which are not found in square */
						rowNotAllowed.removeAll(sqrNotAllowed);
						if(rowNotAllowed.size() > 0){
							c3.getMustContainValues().addAll(rowNotAllowed);
						}
					}
				}
				/** do the same for other col */
				if(!c3.isFull){
					/** get the not allowed values for c2 */
					Set rowNotAllowed = c3.getnotAllowedValues();
					/** now check that the third col is not full */
					if(!c2.isFull){
						/** all the not allowed values of c2 which are not present in square must be present for c3*/						
						/** get only those vals from col not allowed which are not found in square */
						rowNotAllowed.removeAll(sqrNotAllowed);
						if(rowNotAllowed.size() > 0){
							c2.getMustContainValues().addAll(rowNotAllowed);
						}
					}
				}
			}
		}//one or more  rows is full
	}
	
	/**
	 * POSSIBILITY #2.1 
	 * This is applicable to rows 
	 * Used to populate "mustContain" values of third sqr row / col based on values common to the other
	 * two sqr rows / cols 
	 *  
	 * For the square rows / cols of a square : 
	 * Gets the not allowed values 
	 * If two rows / cols have common " not allowed values " - then these common
	 * " not allowed values " can become "must contain" values for the third row / or column
	 * provided the square doesnt already contain these values  
	 */
	private static void sqrRowMustContainPossibility(SquareRow r1,SquareRow r2,SquareRow r3,Square square){
		
		/**compare the first two rows 
		 * find if the two rows have anything in common which they cannot contain 
		 * if found then these are the values that the third row must contain ! 
		 */
		Set notAll1 = r1.getnotAllowedValues();
		Set notAll2 = r2.getnotAllowedValues();
		Set notAll3 = r3.getnotAllowedValues();
		
		
		
		
		/** now this set contains those elements that are common to r1 & r2 ie that both row1 and row 2
		 * cannot comtain
		 * so these must be contained in row 3 
		 */
		/** r1 & r2 */
		Set r12 = new HashSet();
		r12.addAll(notAll1);
		r12.retainAll(notAll2);
		
		/** if the square already contains the value then this row / column cannot contain it */
		r12.removeAll(square.getnotAllowedValues());
		r3.getMustContainValues().addAll(r12);
				
		/** r2 & r3 */
		Set r23 = new HashSet();
		r23.addAll(notAll2);
		r23.retainAll(notAll3);
		/** if the square already contains the value then this row / column cannot contain it */
		r23.removeAll(square.getnotAllowedValues());
		r1.getMustContainValues().addAll(r23);
		
		/** r1 & r3 - and populate r2 with must contain*/
		Set r13 = new HashSet();
		r13.addAll(notAll3);
		r13.retainAll(notAll1);
		/** if the square already contains the value then this row / column cannot contain it */
		r13.removeAll(square.getnotAllowedValues());
		r2.getMustContainValues().addAll(r13);			
	}
	/**
	 * POSSIBILITY #2.2 
	 * This is applicable to cols 
	 * Used to populate "mustContain" values of third sqr row / col based on values common to the other
	 * two sqr rows / cols 
	 *  
	 * For the square rows / cols of a square : 
	 * Gets the not allowed values 
	 * If two rows / cols have common " not allowed values " - then these common
	 * " not allowed values " can become "must contain" values for the third row / or column
	 * provided the square doesnt already contain these values  
	 */
	private static void sqrColMustContainPossibility(SquareColumn c1,SquareColumn c2,SquareColumn c3,Square square){

		/**compare the first two cols 
		 * find if the two cols have anything in common which they cannot cntain 
		 * if found then these are the values that the third col must contain ! 
		 */
		Set notAll1 = c1.getnotAllowedValues();
		Set notAll2 = c2.getnotAllowedValues();
		Set notAll3 = c3.getnotAllowedValues();

		/** now this set contains those elements that are common to c1 & c2 ie that both col1 and col 2
		 * cannot comtain
		 * so these must be contained in col 3 
		 */
		/** c1 & c2 */
		Set c12 = new HashSet();
		/** add col 1 values to new set */
		c12.addAll(notAll1);
		/** saves the intersection of c1 & c2 */
		c12.retainAll(notAll2);
		/** these need to be added to col 3 */
		/** if the square already contains the value then this row / column cannot contain it */
		c12.removeAll(square.getnotAllowedValues());
		c3.getMustContainValues().addAll(c12);

		/** c2 & c3 */
		Set c23 = new HashSet();
		/** add col 2 values to new set */
		c23.addAll(notAll2);
		/** saves the intersection of c2 & c3 */
		c23.retainAll(notAll3);
		/** these need to be added to col 1 */
		/** if the square already contains the value then this row / column cannot contain it */
		c23.removeAll(square.getnotAllowedValues());
		c1.getMustContainValues().addAll(c23);

		/** c1 & c3 - and populate c2 with must contain*/
		Set c13 = new HashSet();
		/** add col 3 values to new set */
		c13.addAll(notAll3);
		/** saves the intersection of c1 & c3 */
		c13.retainAll(notAll1);
		/** if the square already contains the value then this row / column cannot contain it */
		c13.removeAll(square.getnotAllowedValues());
		c2.getMustContainValues().addAll(c13);

		//System.out.println(" sqrCol1 MUST contain " + c1.getMustContainValues().size());
		//System.out.println(" sqrCol1 MUST contain " + c2.getMustContainValues().size());
		//System.out.println(" sqrCol1 MUST contain " + c3.getMustContainValues().size());
	}
	   
	public static void runRules(List sqrList){
		for(int i=0;i<sqrList.size();i++){
			Square sqr = (Square)sqrList.get(i);
			Set sqrRows = sqr.getSquareRows();
			Set sqrCols = sqr.getSquareColumns();
			
			SquareRow sqrR1 = null;
			SquareRow sqrR2 = null;
			SquareRow sqrR3 = null;
			
			SquareColumn sqrC1 = null;
			SquareColumn sqrC2 = null;
			SquareColumn sqrC3 = null;
			
			Iterator rowIter = sqrRows.iterator();
			int rowCount = 1;
			while(rowIter.hasNext()){
				if(rowCount ==1){
					sqrR1 = (SquareRow)rowIter.next();
				}else if(rowCount ==2){
					sqrR2 = (SquareRow)rowIter.next();
				}else if(rowCount == 3){
					sqrR3 = (SquareRow)rowIter.next();
				}
				rowCount++;
			}
			
			Iterator colIter = sqrCols.iterator();
			int colCount = 1;
			while(colIter.hasNext()){
				if(colCount ==1){
					sqrC1 = (SquareColumn)colIter.next();
				}else if(colCount ==2){
					sqrC2 = (SquareColumn)colIter.next();
				}else if(colCount == 3){
					sqrC3 = (SquareColumn)colIter.next();
				}
				colCount++; 
			}
			/**
			 * run the rule for the three rows
			 */
			
			runColRuleForSingleAllowedAndSingleAvailable(sqrC1,sqr);
			runColRuleForSingleAllowedAndSingleAvailable(sqrC2,sqr);
			runColRuleForSingleAllowedAndSingleAvailable(sqrC3,sqr);
			
			runRowRuleForSingleAllowedAndSingleAvailable(sqrR1,sqr);
			runRowRuleForSingleAllowedAndSingleAvailable(sqrR2,sqr);
			runRowRuleForSingleAllowedAndSingleAvailable(sqrR3,sqr); 
			
			runRowMustContainElimination(sqrR1,sqr);
			runRowMustContainElimination(sqrR2,sqr);
			runRowMustContainElimination(sqrR3,sqr);
			
			runColMustContainElimination(sqrC1,sqr); 
			runColMustContainElimination(sqrC2,sqr);
			runColMustContainElimination(sqrC3,sqr);
			
			/** run rules specific to cells */
			Set sqrCells = sqr.getCells();
			Iterator sqrCellIter = sqrCells.iterator();
			while(sqrCellIter.hasNext()){
				Cell cell = (Cell)sqrCellIter.next();
				runCellMustContainByRowColIntersectElimination(cell);
			}//while
			
			runCellRule(sqr);
			runComplexRule1(sqr);
		}//for		
	}
	
	public static void runComplexRule2(Square sqr){
		Map map = new HashMap();
		Map colMap = new HashMap();

		/** get the square rows of this square */
		Set sqrRows = sqr.getSquareRows();
		/** iterate over each square row */
		Iterator iter = sqrRows.iterator();
		while(iter.hasNext()){
			SquareRow sqrRow = (SquareRow)iter.next();			
			/** if the row is not full */
			if(!sqrRow.isFull){
				/** check if the empty cell size is same as must contain 
				 *  if the mustContain is less than cell size dont do anything
				 *  since we are not in a position to predict the value 
				 */
				//if(sqrRow.getInitSqrRowCapacity() == sqrRow.getMustContainValues().size()){
					/** now iterate over each must contain value */
					Set mustContain = sqrRow.getMustContainValues();
					if(mustContain.size() > 0){
						Iterator setIter = mustContain.iterator();
						while (setIter.hasNext()) {
							List cellList = new ArrayList();
							String  value = (String ) setIter.next();
							Iterator cellIter = sqrRow.getCells().iterator();
							while(cellIter.hasNext()){										
								Cell cell = (Cell)cellIter.next();
								if(isAllowed(cell,value,true)){
									//System.out.println(" $$$$$$ val = $$$$$$$ " + value + " $$$$$$$$ contenders =  " + cell.getName());
									cellList.add(cell);											
								}
							}//while loop for each cell in sqr row
							map.put(value,cellList);
							//System.out.println(" this is the must contain value " + value);
						}//while

						/** now we have a map with keys as vals and Lists containing cells */
						/** simply check if the list size is 1 then the cell can be populated with that value */
						if(map.size() > 0){
							Set entries = map.entrySet();
							Iterator it = entries.iterator();
							while (it.hasNext()) {
								Map.Entry entry = (Map.Entry) it.next();
								String key = entry.getKey().toString().trim();
								List cellCount = (List)entry.getValue();
								//System.out.println(" $$$$$$ val = $$$$$$$ " + key + " $$$$$$$$ contenders =  " + cellCount.size());
								if(cellCount.size() == 1){
									Cell popCell = (Cell)cellCount.get(0);
									System.out.println(" <<<<<< have a cell which will be populated " + popCell.getName());
									System.out.println(" ... and val is " + key);
									populateCell(popCell, Integer.parseInt(key), true);
								}
							}
						}
					}//mustContain has atleast one value
				//}//no of empty cells is same as must contain
			}//row not full
		}//while
		
		/** start */
		Set sqrCols = sqr.getSquareColumns();
		Iterator colIter = sqrCols.iterator();
		while(colIter.hasNext()){
			SquareColumn sqrColumn = (SquareColumn)colIter.next();

			//ystem.out.println(" ");
			//System.out.println("$$$$$$$$$$IN SPECIFIC ROW $$$$$$$$$$$$ ");
			//System.out.println(" ");
			/** if the row is not full */
			if(!sqrColumn.isFull){
				/** check if the empty cell size is same as must contain 
				 *  if the mustContain is less than cell size dont do anything
				 *  since we are not in a position to predict the value 
				 */
				//if(sqrColumn.getInitSqrColCapacity() == sqrColumn.getMustContainValues().size()){
					/** now iterate over each must contain value */
					Set mustContain = sqrColumn.getMustContainValues();
					if(mustContain.size() > 0){
						Iterator setIter = mustContain.iterator();
						while (setIter.hasNext()) {
							List cellList = new ArrayList();
							String  value = (String ) setIter.next();
							Iterator cellIter = sqrColumn.getCells().iterator();
							while(cellIter.hasNext()){										
								Cell cell = (Cell)cellIter.next();
								if(isAllowed(cell,value,false)){
									//System.out.println(" $$$$$$ val = $$$$$$$ " + value + " $$$$$$$$ contenders =  " + cell.getName());
									cellList.add(cell);											
								}
							}//while loop for each cell in sqr row
							colMap.put(value,cellList);
							//System.out.println(" this is the must contain value " + value);
						}//while

						/** now we have a map with keys as vals and Lists containing cells */
						/** simply check if the list size is 1 then the cell can be populated with that value */
						if(colMap.size() > 0){
							Set entries = colMap.entrySet();
							Iterator it = entries.iterator();
							while (it.hasNext()) {
								Map.Entry entry = (Map.Entry) it.next();
								String key = entry.getKey().toString().trim();
								List cellCount = (List)entry.getValue();
								//System.out.println(" $$$$$$ val = $$$$$$$ " + key + " $$$$$$$$ contenders =  " + cellCount.size());
								if(cellCount.size() == 1){
									Cell popCell = (Cell)cellCount.get(0);
									System.out.println(" <<<<<< have a cell which will be populated " + popCell.getName());
									System.out.println(" ... and val is " + key);
									populateCell(popCell, Integer.parseInt(key), true);
								}
							}
						}
					}//mustContain has atleast one value
				//}//no of empty cells is same as must contain
			}//row not full
		}//while
		/** finish */
	}
	
	public static void runComplexRule1(Square sqr){
		Map map = new HashMap();
		Map colMap = new HashMap();

		//System.out.println(" ");
		//System.out.println("$$$$$$$$$$$$$$$$$$$$$$ ");
		//System.out.println(" ");
		Set sqrRows = sqr.getSquareRows();
		Iterator iter = sqrRows.iterator();
		while(iter.hasNext()){
			SquareRow sqrRow = (SquareRow)iter.next();

			//ystem.out.println(" ");
			//System.out.println("$$$$$$$$$$IN SPECIFIC ROW $$$$$$$$$$$$ ");
			//System.out.println(" ");
			/** if the row is not full */
			if(!sqrRow.isFull){
				/** check if the empty cell size is same as must contain 
				 *  if the mustContain is less than cell size dont do anything
				 *  since we are not in a position to predict the value 
				 */
				//if(sqrRow.getInitSqrRowCapacity() == sqrRow.getMustContainValues().size()){
					/** now iterate over each must contain value */
					Set mustContain = sqrRow.getMustContainValues();
					if(mustContain.size() > 0){
						Iterator setIter = mustContain.iterator();
						while (setIter.hasNext()) {
							List cellList = new ArrayList();
							String  value = (String ) setIter.next();
							Iterator cellIter = sqrRow.getCells().iterator();
							while(cellIter.hasNext()){										
								Cell cell = (Cell)cellIter.next();
								if(isAllowed(cell,value,true)){
									//System.out.println(" $$$$$$ val = $$$$$$$ " + value + " $$$$$$$$ contenders =  " + cell.getName());
									cellList.add(cell);											
								}
							}//while loop for each cell in sqr row
							map.put(value,cellList);
							//System.out.println(" this is the must contain value " + value);
						}//while

						/** now we have a map with keys as vals and Lists containing cells */
						/** simply check if the list size is 1 then the cell can be populated with that value */
						if(map.size() > 0){
							Set entries = map.entrySet();
							Iterator it = entries.iterator();
							while (it.hasNext()) {
								Map.Entry entry = (Map.Entry) it.next();
								String key = entry.getKey().toString().trim();
								List cellCount = (List)entry.getValue();
								//System.out.println(" $$$$$$ val = $$$$$$$ " + key + " $$$$$$$$ contenders =  " + cellCount.size());
								if(cellCount.size() == 1){
									Cell popCell = (Cell)cellCount.get(0);
									System.out.println(" <<<<<< have a cell which will be populated " + popCell.getName());
									System.out.println(" ... and val is " + key);
									populateCell(popCell, Integer.parseInt(key), true);
								}
							}
						}
					}//mustContain has atleast one value
				//}//no of empty cells is same as must contain
			}//row not full
		}//while
		
		/** start */
		Set sqrCols = sqr.getSquareColumns();
		Iterator colIter = sqrCols.iterator();
		while(colIter.hasNext()){
			SquareColumn sqrColumn = (SquareColumn)colIter.next();

			//ystem.out.println(" ");
			//System.out.println("$$$$$$$$$$IN SPECIFIC ROW $$$$$$$$$$$$ ");
			//System.out.println(" ");
			/** if the row is not full */
			if(!sqrColumn.isFull){
				/** check if the empty cell size is same as must contain 
				 *  if the mustContain is less than cell size dont do anything
				 *  since we are not in a position to predict the value 
				 */
				//if(sqrColumn.getInitSqrColCapacity() == sqrColumn.getMustContainValues().size()){
					/** now iterate over each must contain value */
					Set mustContain = sqrColumn.getMustContainValues();
					if(mustContain.size() > 0){
						Iterator setIter = mustContain.iterator();
						while (setIter.hasNext()) {
							List cellList = new ArrayList();
							String  value = (String ) setIter.next();
							Iterator cellIter = sqrColumn.getCells().iterator();
							while(cellIter.hasNext()){										
								Cell cell = (Cell)cellIter.next();
								if(isAllowed(cell,value,false)){
									//System.out.println(" $$$$$$ val = $$$$$$$ " + value + " $$$$$$$$ contenders =  " + cell.getName());
									cellList.add(cell);											
								}
							}//while loop for each cell in sqr row
							colMap.put(value,cellList);
							//System.out.println(" this is the must contain value " + value);
						}//while

						/** now we have a map with keys as vals and Lists containing cells */
						/** simply check if the list size is 1 then the cell can be populated with that value */
						if(colMap.size() > 0){
							Set entries = colMap.entrySet();
							Iterator it = entries.iterator();
							while (it.hasNext()) {
								Map.Entry entry = (Map.Entry) it.next();
								String key = entry.getKey().toString().trim();
								List cellCount = (List)entry.getValue();
								//System.out.println(" $$$$$$ val = $$$$$$$ " + key + " $$$$$$$$ contenders =  " + cellCount.size());
								if(cellCount.size() == 1){
									Cell popCell = (Cell)cellCount.get(0);
									System.out.println(" <<<<<< have a cell which will be populated " + popCell.getName());
									System.out.println(" ... and val is " + key);
									populateCell(popCell, Integer.parseInt(key), true);
								}
							}
						}
					}//mustContain has atleast one value
				//}//no of empty cells is same as must contain
			}//row not full
		}//while
		/** finish */
	}
	
	private static boolean isAllowed(Cell cell, String value,boolean isRow){
		boolean isAllowed = true;
		if(isRow){
			/** we are checking for row */ 
			Column column = cell.getColumn();
			Set sqrCols = column.getSquareColumns();
			/** the column "notAllowedValues" should not contain this value - only then proceed  */
			if(!column.getnotAllowedValues().contains(value)){
				/**
				 * now check for the square columns for this column
				 * These square columns which do not belong to the same square as the cell
				 * should not specify that "mustContain" contains this value
				 */
				Iterator iter = sqrCols.iterator();
				while(iter.hasNext()){
					SquareColumn sqrColumn = (SquareColumn)iter.next();
					/** the cell should not belong to the same square column */
					if(cell.getSquareColumn() != sqrColumn){	
						//System.out.println(" sqr col " + sqrColumn.getName() + " must contain = " + sqrColumn.getMustContainValues());
						/** now check that the "mustContain" does NOT contain this value */
						if(sqrColumn.getMustContainValues().contains(value)){
							isAllowed = false;
							break;
						}//if
					}//cell column not same as the column containing square column
				}//while
			}else{
				isAllowed = false;
			}
		}else{
			/** we are checking for a column */
			Row row = cell.getRow();
			Set sqrRows = row.getSquareRows();
			/** the row "notAllowedValues" should not contain this value - only then proceed  */
			if(!row.getnotAllowedValues().contains(value)){
				/**
				 * now check for the square rows for this row
				 * These square rows which do not belong to the same square as the cell
				 * should not specify that "mustContain" contains this value
				 */
				Iterator iter = sqrRows.iterator();
				while(iter.hasNext()){
					SquareRow sqrRow = (SquareRow)iter.next();
					/** the cell should not belong to the same square column */
					if(cell.getSquareRow() != sqrRow){	
						//System.out.println(" sqr row " + sqrRow.getName() + " must contain = " + sqrRow.getMustContainValues());
						/** now check that the "mustContain" does NOT contain this value */
						if(sqrRow.getMustContainValues().contains(value)){
							isAllowed = false;
							break;
						}//if
					}//cell column not same as the column containing square column
				}//while
			}else{
				isAllowed = false;
			}
		}
		return isAllowed;
	}
	
	/**
	 * This method is a rule for a row 
	 * The row "MustContain" has only one value
	 * The row has only once cell that is not populated
	 */
	private static void runRowRuleForSingleAllowedAndSingleAvailable(SquareRow sqrRow,Square sqr) {
		if(sqrRow.getMustContainValues() != null && sqrRow.getMustContainValues().size() > 0){
			/** if mustContain size is 1 and two cells are filled and the square already doesnt contain the value then third must have this value */
			if(sqrRow.getMustContainValues().size() ==1 && sqrRow.getInitSqrRowCapacity() ==1 ){
				Set cells = sqrRow.getCells();
				Iterator cellIterator = cells.iterator();
				while(cellIterator.hasNext()){
					Cell cell = (Cell)cellIterator.next();
					if(!cell.isHasValue()){
						List lst = new ArrayList(sqrRow.getMustContainValues());
						String str = (String)lst.get(0);
						if(!sqr.getnotAllowedValues().contains(str)){
							int xyz = Integer.parseInt(str);
							//System.out.println("<<<<< here cell for row is >>>>> " + cell.getName() + " val " + xyz  ); 
							//System.out.println(" before populating ..... sqrRow is " + sqrRow.getName() + " and the must contain are " + sqrRow.getMustContainValues());
							populateCell(cell,xyz,true);
							//System.out.println(" after populating ..... sqrRow is " + sqrRow.getName() + " and the must contain are " + sqrRow.getMustContainValues());
						}					
					}
				}//while
			}
		}  
	}	 
	
	/**
	 * This method is a rule for a col
	 * The row "MustContain" has only one value
	 * The row has only once cell that is not populated
	 */
	private static void runColRuleForSingleAllowedAndSingleAvailable(SquareColumn sqrCol,Square sqr) {
		if(sqrCol.getMustContainValues() != null && sqrCol.getMustContainValues().size() > 0){
			//System.out.println("in sqr col ");
			/** if mustContain size is 1 and two cells are filled nd the non ether cells of the
			 *  square can contain this value 
			 *  then third must have this value 
			 */
			if(sqrCol.getMustContainValues().size() ==1 && sqrCol.getInitSqrColCapacity() ==1 ){
				//System.out.println(" <<<< in col cell here >>>"); 
				Set cells = sqrCol.getCells();
				Iterator cellIterator = cells.iterator();
				while(cellIterator.hasNext()){
					Cell cell = (Cell)cellIterator.next();
					if(!cell.isHasValue()){
						List lst = new ArrayList(sqrCol.getMustContainValues());
						String str = (String)lst.get(0);
						if(!sqr.getnotAllowedValues().contains(str)){
							int xyz = Integer.parseInt(str);
							//System.out.println("<<<<< here cell for column is >>>>> " + cell.getName() + " val " + xyz  ); 
							populateCell(cell,xyz,true);
						}//sqr is allowing this value						
					}//cell doesnt have the value
				}//while 
			}
		}
	}	
	
	private static void runRowMustContainElimination(SquareRow sqrRow,Square sqr){
		Map map = new HashMap();
		/** get the "mustContain" for this square row */
		Set mustContain = sqrRow.getMustContainValues();
		if(null != mustContain && mustContain.size() > 0){
			/**since we have some values for must contain - only now can we proceed  */
			Iterator iter = mustContain.iterator();
			while(iter.hasNext()){
				/** get each mustContain value */
				String mustContainVal = (String)iter.next();
				/**now check with each cell of the square row */
				Set cells = sqrRow.getCells();
				Iterator cellIter = cells.iterator();
				List cellList = new ArrayList();
				while(cellIter.hasNext()){
					Cell cell = (Cell)cellIter.next();
					/** we would like to check if this cell is eligible for mustContain*/
					if(!cell.isHasValue() && !cell.getColumn().getnotAllowedValues().contains(mustContainVal)){ 
						/** this means this cell is eligible for this value */
						cellList.add(cell);
					}//if
				}//while
				/** now store all the eligible cells in list against this mustcontain value*/
				map.put(mustContainVal,cellList);
			}//while
		}//if
		
		/** we now have a map full of the must contain values as keys and the possible candidates stored
		 * as a list as the values
		 * 
		 * If we have a list containing only one cell then that cell is the right candidate for the value
		 * If we have more than one cells for the value - then we do not know 100% which cell should contain
		 * the value - so do not do anything
		 */
		if(map.size() > 0){
			//System.out.println("<<<<< hello world size of map >>>>> " + map.size()); 
			Set entries = map.entrySet();
			Iterator it = entries.iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				String key = entry.getKey().toString().trim();
				List cellCount = (List)entry.getValue();
				/** if the size of the arrayList is > 1
				 *  then dont do anything
				 */
				if(cellCount.size() ==1){
					//System.out.println("<<<<< we have a match >>>> ");
					Cell listCell = (Cell)cellCount.get(0);
					/** this is the cell that should be populated if the sqr allows too*/
					if(!sqr.getnotAllowedValues().contains(key)){
						populateCell(listCell, Integer.parseInt(key),true);
					}					 
				}else{
					//System.out.println(" <<<<<< no match too many = " + cellCount.size()); 
				}
			}//while
		}//map size > 0
	}
	
	private static void runColMustContainElimination(SquareColumn sqrCol,Square sqr){
		Map map = new HashMap();
		/** get the "mustContain" for this square col */
		Set mustContain = sqrCol.getMustContainValues();
		if(null != mustContain && mustContain.size() > 0){
			/**since we have some values for must contain - only now can we proceed  */
			Iterator iter = mustContain.iterator();
			while(iter.hasNext()){
				/** get each mustContain value */
				String mustContainVal = (String)iter.next();
				/**now check with each cell of the square col */
				Set cells = sqrCol.getCells();
				Iterator cellIter = cells.iterator();
				List cellList = new ArrayList();
				while(cellIter.hasNext()){
					Cell cell = (Cell)cellIter.next();
					/** we would like to check if this cell is eligible for mustContain*/
					if(!cell.isHasValue() && !cell.getRow().getnotAllowedValues().contains(mustContainVal)){ 
						/** this means this cell is eligible for this value */
						cellList.add(cell);
					}//if
				}//while
				/** now store all the eligible cells in list against this mustcontain value*/
				map.put(mustContainVal,cellList);
			}//while
		}//if
		
		/** we now have a map full of the must contain values as keys and the possible candidates stored
		 * as a list as the values
		 * 
		 * If we have a list containing only one cell then that cell is the right candidate for the value
		 * If we have more than one cells for the value - then we do not know 100% which cell should contain
		 * the value - so do not do anything
		 */
		if(map.size() > 0){
			//System.out.println("<<<<< hello world size of map >>>>> " + map.size()); 
			Set entries = map.entrySet();
			Iterator it = entries.iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				String key = entry.getKey().toString().trim();
				List cellCount = (List)entry.getValue();
				/** if the size of the arrayList is > 1
				 *  then dont do anything
				 */
				if(cellCount.size() ==1){
					//System.out.println("<<<<< we have a match >>>> ");
					Cell listCell = (Cell)cellCount.get(0);
					/** this is the cell that should be populated if the sqr allows too*/
					if(!sqr.getnotAllowedValues().contains(key)){
						populateCell(listCell, Integer.parseInt(key),true);
					}					 
				}else{
					//System.out.println(" <<<<<< no match too many = " + cellCount.size()); 
				}
			}//while
		}//map size > 0
	}
	
	/**
	 * 
	 * This method will look at each cell - and get the rows and cols 
	 * If the cell has no value : get the "notallowedValues" for both row and col
	 * If the common values - "intersect" of row and col gives us 8 values 
	 * then the cell must contain the ninth value
	 */
	private static void runCellMustContainByRowColIntersectElimination(Cell cell){
		if(!cell.isHasValue()){
			Set allVals = new HashSet();
			
			allVals.add("0");allVals.add("1");allVals.add("2");
			allVals.add("3");allVals.add("4");allVals.add("5");
			allVals.add("6");allVals.add("7");allVals.add("8");
			
			
			/** get the row , col and square for cell */
			Row row = cell.getRow();
			Column col = cell.getColumn();
			Square sqr = cell.getSquare();
			
			/** now get the not allowed values from the col and row */
			Set rowNotAllowedVals = row.getnotAllowedValues();
			Set colNotAllowedVals = col.getnotAllowedValues();
			
			/** now we need to get only the common unique elements */
			Set union = new HashSet();
			union.addAll(rowNotAllowedVals);
			union.addAll(colNotAllowedVals);
			
			/** check if the size is 8 
			 * also check if the square in which this cell is present does not have the value
			 * if so then there is s ninth element that we can work with 
			 */
			
			if(union.size() == 8){
				/** row and col for this cell contain 8 unique elements 
				 * and this implies they dont have the ninth value 
				 * so now we get the ninth element - which this cell must contain
				 */
				allVals.removeAll(union);
				/** now the only element left in the set is what we need to populate */
				if(allVals.size()==1){
					//System.out.println(" <<<<<<< the set has only one cell that can be populated now >>>>>> ");
					Iterator iter = allVals.iterator();
					while(iter.hasNext()){
						String val = (String)iter.next();
						if(!sqr.getnotAllowedValues().contains(val)){
							/** check that the only allowed value is not already present in some other cell of the square */
							populateCell(cell, Integer.parseInt(val.trim()), true);
						}
						
					}//while
				}
			}
		}//cell does not have a value
	}
}
