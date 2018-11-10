
package myconstructor;

public class addme {
    
    int first;
    int second; 
    public addme(int first,int second)
    {
        this.first = first;
        this.second=second;
    }
    public int add()
    {
        int sum;
        sum = first + second;
        return sum;
    }
}
