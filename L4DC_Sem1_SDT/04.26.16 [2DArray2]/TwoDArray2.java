public class TwoDArray2{
  public static void main(String[]args){
  
 
    int sum = 0;
    int count = 0;
    int[][]grid = {
      {1, 0, 6},
      {2, 9, 0},
      {0, 5, 2}    
    };
  
    for (int rowindex = 0; rowindex<grid.length; rowindex++){
     
      for (int columnindex = 0; columnindex<grid[1].length; columnindex++)
        if (grid [rowindex][columnindex] == 0){
      count = count+1;     
    }
   
    }
     System.out.println("There are "+count+ " 0s");    
  }
}

//sum
//