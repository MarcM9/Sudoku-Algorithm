//Marc Machado
//Computer Science 1027
public class Sudoku {
	
	//Initialize variables 
	private int size; 
	private int[][] grid; 
	
	//Constructor
	public Sudoku (int[][] numbers){ 
		
		this.size = numbers.length; 
		
		//Initialize the grid
		this.grid = new int[this.size][this.size]; 
		
		//Copy the numbers into the grid
		for(int i = 0; i < this.size; i++) { 
			
			for(int j = 0; j < this.size; j++) { 
				
				this.grid[i][j] = numbers[i][j]; 
				
			}
		}
		
	}
	
	//Getter for the size of the grid
	public int getSize() {
		
		return this.size; 
	}
	
	//Getter for the grid
	public int[][] getGrid() { 
		
		return this.grid;
	}
	
	
	//Return the digit stored in the grid at the given row and col
	public int getDigitAt(int row, int col) { 
		
		if (row < 0 || col < 0 || row > size -1 || col > size -1) { 
			
			return -1;
		}else { 
			
			return grid[row][col]; 
		}
	}
	
	//Determine if the row is valid in sudoku
	public boolean isValidRow (int row) { 
		
		//Check if index is out of range
		if(row < 0 || row >= size) { 
			
			return false;
		}
		
		boolean [] digits = new boolean[size];
		int value; 
		
		//loop through the grid at the given row
		for(int i = 0; i < size; i++) {
			
			value = this.grid[row][i];
			
			if(value < 1 || value > size) {
				
				return false; 
			}
			
			//checks for duplicate values
			if(digits[value-1]) { 
				
				return false;
			}
			
			//Stores true if the value has not already been found
			digits[value - 1] = true;
		}
		
		return true;
	}
	
	//Determine if the col is valid 
	public boolean isValidCol (int col) { 
		
		//Checks if index is out range
		if(col < 0 || col >= size) { 
			
			return false;
		}
		
		boolean [] digits = new boolean[size];
		int value; 
		
		//loops through the column
		for(int i = 0; i < size; i++) {
			
			value = this.grid[i][col];
			
			if(value < 1 || value > size) {
				
				return false; 
			}
			
			//Checks if the value already exists in the array 
			if(digits[value-1]) { 
				
				return false;
			}
			
			//Stores true if the value is not in the array
			digits[value - 1] = true;
		}

		return true;
	}
	
	//Checks if the the 3x3 box is valid for a size 9 grid 
	public boolean isValidBox (int row, int col) { 
		
	    //Checks if the index is out of range
	    if (row < 0 || row >= size || col < 0 || col >= size) {
	        return false;
	    }

	   
	    boolean[] digits = new boolean[size];

	    //Loops through the box
	    for (int i = row; i < row + 3; i++) {
	        for (int j = col; j < col + 3; j++) {
	            int value = grid[i][j];

	            
	            if (value < 1 || value > 9) {
	                return false;
	            }

	            //Checks if the digit already exists 
	            if (digits[value - 1]) {
	                return false;
	            }

	           // Stores true if the digit is not already in the array
	            digits[value - 1] = true;
	        }
	    }

	   
	    return true;
	}
	
	//Checks if the sudoku board is a solution
	public boolean isValidSolution() { 
		
		//Invokes isValidRow and isValidCol
		for(int i = 0; i < size; i++ ) { 
			
			if(!isValidRow(i) || !isValidCol(i)) {
				
				return false; 
			}
		}
		
		//If the size is 9 call isValidBox
		if(size == 9) { 
			
			for(int i = 0; i < size; i+=3) { 
				
				for(int j = 0; i < size; j+=3) { 
					
					if(isValidBox(i,j) == false) { 
						
						return false; 
					}
				}
			}

		}
		
		
		
		return true; 
	}
	
	//checks is this sudoku is identical to the other sudoku
	public boolean equals (Sudoku other) { 
		
		if(this.size != other.size) { 
			
			return false; 
		}
		
		for(int i = 0; i < size; i++) { 
			
			for(int j = 0; j < size; j++) { 
				
				if(this.grid[i][j] != other.grid[i][j]) { 
					
					return false;
				}
			}
			
		}
		
		return true; 
		
		
	}
	
	//Constructs a toString containing all the digits of the grid.
	public String toString () { 
		
		String board = ""; 
		
		for(int i = 0; i < size; i++) { 
			
			for(int j = 0; j < size; j++) { 
				
				board += grid[i][j]; 
				board += " ";
			}
			
			board += "\n"; 
		}
		
		
		return board; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
