
import java.lang.Double;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author topu42
 */
public class Kmeans {
    Double data1[] =new Double[1000000];
    int length=0;
    Kmeans(){
  // data1[i]=val;
  //  System.out.println(data1[i]);
  //  i++;
    }
void pass(double val){
    data1[length]=val;
  //  System.out.println(data1[i]);
    length++;
}



          void show()
         {
                        //System.out.println(data1[0]);
                        int Cluster_Size;
                        Scanner c= new Scanner(System.in);
                        Cluster_Size=c.nextInt();
                      // System.out.println(Cluster_Size);
                            Double Cluster[][]=new Double[100][100];
                            Double Distance1[]=new Double[100000];
                            int i,j,k,pos,ind;
                            double distance,minimum=10.0,value=0.0;;
                            double cluster_set[][]=new double[100][100];
                            double tmp = 0;



                            for(i=0;i<Cluster_Size;i++)
                            {
                                Cluster[i][0]=data1[i];
                            }

                            for(k=0;k<Cluster_Size;k++)
                            {

                                   for(i=0;i<length;i++)
                                   {
                                       Cluster[k][i+1]=Math.abs(Cluster[k][0]-data1[i]);
                                   }
                            }
                            for(i=0;i<length;i++)
                            {
                                   
                                   for(k=0;k<Cluster_Size;k++) 
                                   {
                                       if(k==0){
                                           tmp=Cluster[k][i+1];
                                           ind=k;
                                       }
                                       else
                                       {
                                           if(tmp>Cluster[k][i+1])
                                           {
                                              tmp=Cluster[k][i+1];
                                                      ind=k;
                                           }
                                           
                                       }
                                   }
                                       //Cluster[k][i+1];
                                   }     
                            }


 }

