
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

    Double data1[] = new Double[1000000];
    int length = 0;

    void pass(double val) {
        data1[length] = val;
        length++;
    }

    void show() {

        Scanner c = new Scanner(System.in);
        int clusterSize = c.nextInt();
        Double cluster[][] = new Double[100][100];
        int i, j, k, pos, ind;
        double distance, minimum = 10.0, value = 0.0;;
        double tmp = 0;

        for (i = 0; i < clusterSize; i++) {
            cluster[i][0] = data1[i];
        }

        for (k = 0; k < clusterSize; k++) {

            for (i = 0; i < length; i++) {
                cluster[k][i + 1] = Math.abs(cluster[k][0] - data1[i]);
            }
        }

        for (i = 0; i < length; i++) {
            for (k = 0; k < clusterSize; k++) {
                if (k == 0) {
                    tmp = cluster[k][i + 1];
                    ind = k;
                } else {
                    if (tmp > cluster[k][i + 1]) {
                        tmp = cluster[k][i + 1];
                        ind = k;
                    }
                }
            }
        }
    }
}
