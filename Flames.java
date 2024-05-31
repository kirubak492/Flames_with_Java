
import java.sql.SQLException;
import java.util.*;
class Flames
{
    public static void main(String[]args) throws SQLException
    {

        
        
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your name:");
        StringBuilder a=new StringBuilder(sc.nextLine());
        System.out.println("enter your partner name:");
        StringBuilder b=new StringBuilder(sc.nextLine());
        int count=0;
        int x=a.length();
        int y=b.length();
        FlamesDAO fldao=new FlamesDAO(a,b);
        for( int i=0;i<a.length();i++)
        {
            for( int j=0;j<b.length();j++)
            {
                if(a.charAt(i)==b.charAt(j))
                {
                count++;
                b.deleteCharAt(j);
               
                break;
                }              
               
            }
        }

       
        int remain=x+y-2*count;
        System.out.println("remaining "+ remain);
      
        StringBuilder str=new StringBuilder("Flames");
        
         
         int index=(remain%6);
         
         for(int i=0;i<5;i++)
         {
 
             if(index==0)
             {
                 index = str.length()-1;
             }
             else
             {
                 index = index-1;
             }
             str = str.deleteCharAt(index);
             StringBuilder c=new StringBuilder(str.substring(0,index));
             StringBuilder d=new StringBuilder(str.substring(index));
             str=d.append(c);
              
             index = remain%str.length();
             //System.out.println(str);
             
         }
         
         String str1=new String(str);
         String ans="";
         switch(str1){
            case "f":
                ans ="Friend";
                break;
            case "l":
                ans ="Love";
                break;
            case "a":
                ans ="Affection";
                break;
            case "m":
                ans ="Marriage";
                break;
            case "e":
                ans ="Enemy";
                break;
            case "s":
                ans ="Sister";
                break;
         }
         System.out.println(ans);
         System.out.println("press 1 to add in database \npress 2 to not");
         int flag=sc.nextInt();
         if(flag==1){
            try 
            {
                fldao.add_result(ans);  
                System.out.println("Successfully added");   
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
        
        fldao.display();
         
     }

      
}
