public class CodePoint{

   public static void main(String[] args){
      
      /*
      //Example 1
      char ch = 'A';
      int intValue = ch;
      //System.out.println(intValue);
      
      intValue += 13;
      ch = (char)intValue;
      System.out.println(ch);
      */
      
      
      //Example 2
      String str = "6JH";
      int codePoint = str.codePointAt(0);
      codePoint += 13;
      char ch = (char)codePoint;
      System.out.print(ch);
      
      codePoint = str.codePointAt(1);
      ch = (char)(codePoint + 13);
      System.out.print(ch);
      
      codePoint = str.codePointAt(2);
      ch = (char)(codePoint + 13);
      System.out.print(ch);
            
   }

}