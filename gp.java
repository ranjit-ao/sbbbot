import java.util.*;
import java.lang.*;
import java.math.BigInteger;

public class Main
{
  public static void main(String [] args)
  {
    Scanner inn = new Scanner(System.in);
    String input = null;
    String punctuation = "";
    Character lastChar;
    String hexText = null;
    
    System.out.println("Type 'STOPP' to finish sending lines (case sensitive).");
    System.out.print("Enter your text:   ");
    input = inn.nextLine();

    while (!input.equals("STOPP"))
    {
        
        input = input.toLowerCase();
        lastChar = input.charAt(input.length() - 1);
    
        if (lastChar.equals('?'))
        {
          punctuation = "Q";
          input = (input.substring(0, input.length() - 1));
        }
        else if (lastChar.equals('!'))
        {
          punctuation = "E";
          input = (input.substring(0, input.length() - 1));
        }
        else if (lastChar.equals('.'))
        {
          punctuation = "P";
          input = (input.substring(0, input.length() - 1));
        }
        else
        {
          punctuation = "N";
        }
        
        hexText = toHex(input);
        checkSumMaker(hexText);
        System.out.println("\nModified text:");
        System.out.println("$GP" + punctuation + " " + input + "*" + checkSumMaker(hexText));//edit hexText later
        System.out.print("\nEnter your text:   ");
        input = inn.nextLine();
    }
    //checksum
    

  }

  
  public static String toHex(String arge)
  {
    String b = arge;
    return String.format("%040x", new BigInteger(1, b.getBytes()));
  }
  
  public static String checkSumMaker(String a)
  {
      
      String bin = a;
      char[] cA = bin.toCharArray();
      int ckA = 0, ckB = 0;
      for (int i = 0; i < cA.length; i++)
        {
            ckA = (ckA + Integer.valueOf(cA[i])/49) % 255;
            ckB = (ckB + ckA) % 255;
        }
      return Integer.toString(ckA);
  }
}
