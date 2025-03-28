import java.util.*;
import java.lang.*;

public class JavaDay1
{
    public static void main(String args[])
    {
        int temp = (int)(Math.random() * 1000);
       for(int i=0;i<4;i++)
       {
            for(int p=0;p<i+1;p++)
            {
                System.out.print(temp  +  " ");
                temp++;
            }
        System.out.println(" ");
       }
        
    }
}
/*
A
B B
C C C
D D D D
*/
