//Marc Machado
//Computer Science 1027

//UniqueDiagonalSudoku inherits sudoku
public class UniqueDiagonalSudoku extends Sudoku{

	public UniqueDiagonalSudoku(int[][] numbers) {
		
		super(numbers);
		
	}
	
	//Overrides the method in Sudoku
	public boolean isValidSolution() { 
		
		
		int size = this.getSize();
		int [][] grid = this.getGrid();
		boolean [] digits = new boolean[size];
		boolean [] digits2 = new boolean[size];
		int value; 
		
		if(super.isValidSolution() == false) {
			
			return false;
			
		}
		
		//loops through the top left to bottom right diagonal 
		for(int i = 0; i < size; i++) { 
			
			value = grid[i][i];
			
			if(value < 1 || value > size) { 
				
				return false; 
			}
			
			//Checks for duplicates on the diagonal
			if(digits[value-1]) {
				
				return false; 
			}
			
			digits[value -1] = true; 
		}
		
		//loops through the top right to bottom left
		
		for(int i = 0; i < size; i++) { 
			
			value = grid[i][(size -1) - i];
			
			if(value < 1 || value > size) { 
				
				return false; 
			}
			
			if(digits2 [value -1]) { 
				
				return false;
			}
			
			digits2[value-1] = true;
			
		}
		
		
		
		
		return true;
		


	}

}