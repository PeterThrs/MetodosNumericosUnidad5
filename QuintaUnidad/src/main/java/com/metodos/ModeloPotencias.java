/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodos;

/**
 *
 * @author Root
 */
public class ModeloPotencias {

    public static double[] powerModel(double[] x, double[] y, double xToApproximate) {
    double[] result = new double[3];
    int n = x.length;

    // Calcular las sumas necesarias
    double sumX = 0;
    double sumY = 0;
    double sumX2 = 0;
    double sumXY = 0;

    for (int i = 0; i < n; i++) {
        sumX += Math.log(x[i]);
        sumY += Math.log(y[i]);
        sumX2 += Math.pow(Math.log(x[i]), 2);
        sumXY += Math.log(x[i]) * Math.log(y[i]);
    }

    // Calcular los coeficientes de la recta de regresión
    double b = (n * sumXY - sumX * sumY) / (n * sumX2 - Math.pow(sumX, 2));
    double a = Math.exp((sumY - b * sumX) / n);

    // Calcular la aproximación para xToApproximate
    double yApprox = a * Math.pow(xToApproximate, b);

    result[0] = a; // el coeficiente "a" de la ecuación y = a * x^b
    result[1] = b; // el coeficiente "b" de la ecuación y = a * x^b
    result[2] = yApprox; // la aproximación para el valor de xToApproximate

    return result;
}

    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {0.5, 1.7, 3.4, 5.7, 8.4};

        double[] res = powerModel(x, y, x.length);

        System.out.println("res[0] = " + res[0]);
        System.out.println("res[1] = " + res[1]);
        System.out.println("res[2] = " + res[2]);
    }

}
