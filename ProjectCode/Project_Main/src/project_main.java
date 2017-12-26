

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.util.Random;
import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author topu42
 */
    public class project_main {
    private static BufferedReader br;

 
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

        
         Connection conn=null;
         conn=ConnectDB.ConnecrDb();

         if(conn!=null)
         {
            System.out.println("Connected succesfully!!!!!!!!!!");
         }
        
         PreparedStatement pst=null;
         //int length=0;

        String Number_LIST = "23456789";
        String Char_LIST="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Rating_LIST="1234.";
        String [] Publication={"2014","2013","2012","2011","2010" };


        int Age_LENGTH = 2;
        int Autor_LENGTH=10;
        int Book_Title_LENGTH=12;
        int randomInt = 0;
 

     String sql="insert into customer(`User Id`,`Age`,`Book Title`,`Author`,`Year of Publication`,`Avg Rating`)"
               + " values(?,?,?,?,?,?)";

   Kmeans ob1 = new Kmeans();
   Max_Distance ob2 = new Max_Distance();
   K_Medoid ob3 = new K_Medoid();

          for(int RandomNumber=0; RandomNumber<5; RandomNumber++)
       {
                        String Customer_Age="",Autor="",Book_Title="",Publication_year="",Average_Rating="";
                        int Age=0;
                        double Rating = 0.0;
                        int year=0;
 
                 for(int i=0; i<Age_LENGTH; i++)
               {
                        randomInt = (int) (Math.random() * Number_LIST.length());
                        char ch = Number_LIST.charAt(randomInt);
                        Customer_Age+=ch;
               }
                        Age=Integer.parseInt(Customer_Age);


                    for(int i=0; i<Book_Title_LENGTH; i++)
                 {
                        randomInt = (int) (Math.random() * Char_LIST.length());
                        char ch = Char_LIST.charAt(randomInt);
                        Book_Title+=ch;

                 }

                    for(int i=0; i<Autor_LENGTH; i++)
                 {
                            randomInt = (int) (Math.random() * Char_LIST.length());
                            char ch = Char_LIST.charAt(randomInt);
                            Autor+=ch;

                 }
                             randomInt = (int) (Math.random() *  Publication.length);
                             Publication_year = Publication[randomInt];
                             year=Integer.parseInt(Publication_year);

  
                 class BooksRating
                 {
                           double scaled;
                           Random random = new Random();
                        double show()
                     {
                          double rand = random.nextDouble();
                          scaled = rand * 5;
                          if(scaled<2)
                          show();
                         return scaled;
                     }
                 }

        BooksRating ob=new BooksRating();
        ob.show();
        Rating=ob.scaled;
        Rating = Math.round(Rating * 100);
        Rating= (Rating / 100);

        Average_Rating=String.valueOf(Rating);
  
         int j=0;
         try
             {
                 pst=conn.prepareStatement(sql);
                 pst.setString(1,j+"");
                 pst.setString(2,Customer_Age);
                 pst.setString(3,Book_Title);
                 pst.setString(4,Autor);
                 pst.setString(5,Publication_year);
                 pst.setString(6,Average_Rating);

                 System.out.println(Age);
                 System.out.println(Book_Title);
                 System.out.println(Autor);
                 System.out.println(year);
                 System.out.println(Rating);
                 pst.execute();
           }
      catch(Exception e){

          }
    ob1.pass(Rating);
    ob2.pass(Rating);
    ob3.pass(Rating);
     }
ob1.show();
ob2.show();
ob3.show();
    }
}
