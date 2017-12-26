
import java.util.Scanner;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author topu42
 */
public class kmeans {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Double data1[]=new Double[20];
    Double z[]=new Double[100];
    double val;
    Scanner c;
    int i,j,l,m=0;
     c = new Scanner(System.in);
    for(i=1;i<=8;i++)
    {
      
       val=c.nextDouble();
       data1[i]=val;
    }
    int  n=c.nextInt();
   int Z[][]=new int[20][20];
   // Vector<Vector<Integer>> Z = new Vector<Vector<Integer>>();
    for(i=1;i<=n;i++)
    {
       z[i]=data1[i];
       Z[i][1]=i;
       Z[i][0]=1;
     }
    for(i=n+1;i<=8;i++)
    {
        double Min=10000;
        for(j=1;j<=n;j++)
        {
            double k=data1[j]-data1[i];
            if(k<0)
                k=-k;
            if(k<Min)
            {
                Min=k;
                l=i;
                m=j;
            }
        }
        Z[m][Z[m][0]+1]=i;
        Z[m][0]++;
    }
   for(i=1;i<=n;i++)
   {
       double sum=0;
       for(j=1;j<=Z[i][0];j++)
       {
           sum+=(data1[Z[i][j]]);
       }
       z[i]=sum/Z[i][0];
   }


   while(true)
 {
            int Z1[][]=new int[20][20];
            for(i=0;i<=10;i++)
            {
                Z1[i][0]=0;
             }


          for(i=1;i<=8;i++)
        {
                double Min=10000;
                for(j=1;j<=n;j++)
                {
                    double k=data1[j]-data1[i];
                    if(k<0)
                    k=-k;
                    if(k<Min)
                        {
                            Min=k;
                            l=i;
                            m=j;
                        }
                   }
             Z1[m][Z1[m][0]+1]=i;
             Z1[m][0]++;
         }
                       int flag=0;
                       for(i=1;i<=n;i++)
                         {
                               for(j=1;j<=Z[i][0];j++)
                               if(Z[i][j]!=Z1[i][j])
                                  {
                                           // System.out.println(Z[i][j]+" "+Z1[i][j]);
                                      flag=1;
                                      break;
                                   }
                          }

         if(flag==1)
           {
               for(i=1;i<=n;i++)
                   {
                     Z[i]=Z1[i];
                    }
            }
       else
       break;
    }
        

   for(i=1;i<=n;i++)
        {
          for(j=1;j<=Z[i][0];j++)
          System.out.print(Z[i][j]+" ");
          System.out.println();
        }
  }
}
