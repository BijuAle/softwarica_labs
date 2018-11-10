public class TwoDArray{
  public static void main(String[]args){
    String[][] authors = 
    {
      {"Norman L Geisler", "Paul Copan", "Greg Koukl", "John Polkinghorne"},
      {"Frank Turek", "Ravi Zacharias", "Chuck Colson", "Chad Meister"},
      {"CS Lewis", "GK Chesterton", "Justin Breiley", "Robin Collins"}
    };
  
    for (int rowindex=0; rowindex<3; rowindex++){
      
      for (int columnindex =0; columnindex<4; columnindex++){
        System.out.println(authors [rowindex][columnindex]);
      }
    
    }
    
  }
}