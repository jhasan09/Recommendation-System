/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package topumaximum_distance;

import java.util.Scanner;

/**
 *
 * @author topu42
 */
public class maximum_distance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Double data1[]=new Double[2000000];
    Double z[]=new Double[100000];
    Double minimum[]=new Double[1000000];

    double val,count=0,sum=0;
    Scanner c;
    int i,p,j,l,m=0,flag=0;
     c = new Scanner(System.in);
    for(i=1;i<=8;i++)
    {
       val=c.nextDouble();
       data1[i]=val;
    }

   int  n=c.nextInt();
   double fraction=c.nextDouble();
   int Z[][]=new int[20000][20000];
   int visit[]=new int[1000000];
   int Z1[][]=new int[2000][2000];

   j=1;

      for(i=0;i<10;i++)
      {
          visit[i]=0;
          minimum[i]=0.0;
       }
           z[j]=data1[n];
           Z[1][1]=n;
           Z[1][0]=1;
           visit[n]=1;


       double Max,k;
       Double dist[][]=new Double[10000][10000];

        Max=-1;
        for(i=1;i<=8;i++)
     {

           if(visit[i]==0)
           {
            k=z[j]-data1[i];

            if(k<0)
             k=-k;
           // System.out.printf(" k= "+k);
             dist[j][i]=k;
             minimum[i]=k;
             if(k>Max)
            {
                Max=k;
                m=i;

            }
        }
     }
      
        j=2;
        Z[j][Z[j][0]+1]=m;
        Z[j][0]++;
        z[j]=data1[m];
        visit[m]=1;
        count++;
        sum+=Max;
       // j++;


  

   while(true)
 {
           Max=-1;
          for(i=1;i<=8;i++)
        {
                    
                     if(flag==1)
                     break;

                 if(visit[i]==0)
            {
                    k=z[j]-data1[i];
                    if(k<0)
                    k=-k;
                    dist[j][i]=k;
                    System.out.print(" k= "+k);
                    if(minimum[i]>dist[j][i])
                    {
                          minimum[i]=dist[j][i];
                          System.out.println(" min "+minimum[i]);
                          if(Max<minimum[i])
                          {
                          Max=minimum[i];
                          m=i;
                     }
                    }
                    else
                    {
                        minimum[i]=minimum[i];
                        System.out.println(" min "+minimum[i]);
                        if(Max<minimum[i])
                        {
                        Max=minimum[i];
                        m=i;
                     }

               }
            }
    // System.out.println();
    
          }
           System.out.println(" Max= "+Max);
           System.out.println();
          val=fraction*(sum/count);
          if(Max>val)
         {
                      sum+=Max;
                      j++;
                      Z[j][Z[j][0]+1]=m;
                      Z[j][0]++;
                      z[j]=data1[m];
                      visit[m]=1;
                      count++;


          }
          else
          flag=1;


          if(flag==1)
          break;
    }


   for (i =1;i<=8;i++)

   {
         Max=1000000;
          if(visit[i]==0)
          {
              for(p=1;p<=count;p++)
              if(dist[p][i]<Max)
                      {
                          Max=dist[p][i];
                          m=i;
                          j=p;
                       }


              Z[j][Z[j][0]+1]=m;
              Z[j][0]++;
            }
  }
  
  }
 }
