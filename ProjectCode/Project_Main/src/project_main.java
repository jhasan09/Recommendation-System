
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author topu42
 */
public class project_main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

        Connection conn = ConnectDB.ConnecrDb();
        PreparedStatement pst = null;
        String Number_LIST = "23456789";
        String Char_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Rating_LIST = "1234.";
        String[] Publication = {"2014", "2013", "2012", "2011", "2010"};
        int Age_LENGTH = 2;
        int Autor_LENGTH = 10;
        int Book_Title_LENGTH = 12;
        int randomInt = 0;

        String sql = "insert into customer(`User Id`,`Age`,`Book Title`,`Author`,`Year of Publication`,`Avg Rating`)"
                + " values(?,?,?,?,?,?)";

        Kmeans kMeans = new Kmeans();

        for (int randomNumber = 0; randomNumber < 5; randomNumber++) {
            String customerAge = "", Autor = "", bookTitle = "", publicationYear = "", averageRating = "";
            double Rating = 0.0;

            for (int i = 0; i < Age_LENGTH; i++) {
                randomInt = (int) (Math.random() * Number_LIST.length());
                char ch = Number_LIST.charAt(randomInt);
                customerAge += ch;
            }

            for (int i = 0; i < Book_Title_LENGTH; i++) {
                randomInt = (int) (Math.random() * Char_LIST.length());
                char ch = Char_LIST.charAt(randomInt);
                bookTitle += ch;
            }

            for (int i = 0; i < Autor_LENGTH; i++) {
                randomInt = (int) (Math.random() * Char_LIST.length());
                char ch = Char_LIST.charAt(randomInt);
                Autor += ch;
            }

            class BooksRating {

                double scaled;
                Random random = new Random();
                double show() {
                    double rand = random.nextDouble();
                    scaled = rand * 5;
                    if (scaled < 2) {
                        show();
                    }
                    return scaled;
                }
            }

            BooksRating ob = new BooksRating();
            ob.show();
            Rating = ob.scaled;
            Rating = Math.round(Rating * 100);
            Rating = (Rating / 100);
            averageRating = String.valueOf(Rating);

            int j = 0;
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, j + "");
                pst.setString(2, customerAge);
                pst.setString(3, bookTitle);
                pst.setString(4, Autor);
                pst.setString(5, publicationYear);
                pst.setString(6, averageRating);
                pst.execute();
            } catch (Exception ex) {
            }            
            kMeans.pass(Rating);
        }
        kMeans.show();
    }
}
