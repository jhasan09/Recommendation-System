
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author topu42
 */
public class Cluster_seeking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Double data1[]=new Double[2000000];
    Double z[]=new Double[1000000];
    Double minimum[]=new Double[1000000];

     double val;
     Scanner c;
     int i,p,j,l,m=0,count = 0,length;
     c = new Scanner(System.in);
     for(i=1;i<=8;i++)
    {
       val=c.nextDouble();
       data1[i]=val;
    } 
  
   
   int Z[][]=new int[20000][20000];
   int visit[]=new int[1000000];

      double Target_Value=c.nextDouble();
      int  n=c.nextInt();

      for(i=0;i<10000000;i++)
      {
          visit[i]=0;
          minimum[i]=0.0;
       }
           j=1;
           z[j]=data1[n];
           Z[1][1]=n;
           Z[1][0]=1;
           visit[n]=1;
           length=1;

        double Max,k;
       Double dist[][]=new Double[10000][10000];
       boolean flag;

      for(i=1;i<=8;i++)
       {
           count=0;
          if(visit[i]==0)
           {
                        for(p=1;p<=length;p++)
                       {
                             k=z[p]-data1[i];
                             if(k<0)
                             k=-k;
                             System.out.println(" k= "+k);
                             dist[p][i]=k;
                             if(k>Target_Value)
                             count++;
                             else
                             {
                                Z[p][Z[p][0]+1]=i;
                                Z[p][0]++;
                             }
                          }
                      if(count==length)
                       {
                         j++;
                         length++;
                         Z[j][Z[j][0]+1]=i;
                         Z[j][0]++;
                         visit[i]=1;
                         z[j]=data1[i];
                      }
              }
    } 
   
}
