/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.metodos;

import java.util.Scanner;

/**
 *
 * @author Root
 */
public class MinimosCuadrados {

    public static void main(String[] args) {

        // Datos del libro
       double[] x = {1,2,3,4,5,6,7};
       double[] y = {0.5,2.5,2.0,4.0,3.5,6.0,5.5};
        
        /*Scanner sc = new Scanner(System.in);
        
        double[
        System.out.println("Cuantos datos deseas ingresar: ");
        int total = Integer.parseInt(sc.next());
        
        
        for(int i = 0; i < total; i++){
            System.out.print((i + 1) + ".-Inserte el dato(x): " );
            int x = Integer.parseInt(sc.next());
        }*/

        // Calcular la suma de los valores de x, y, x^2, y^2 y xy
        double sumaX = 0.0;
        double sumaY = 0.0;
        double sumaXCuadrada = 0.0;
        double sumaYCuadrada = 0.0;
        double sumaXY = 0.0;
        for (int i = 0; i < x.length; i++) {
            sumaX += x[i];
            sumaY += y[i];
            sumaXCuadrada += x[i] * x[i];
            sumaYCuadrada += y[i] * y[i];
            sumaXY += x[i] * y[i];
        }

        // Calcular la pendiente y el intercepto de la recta de regresión
        double n = x.length;
        double slope = (n * sumaXY - sumaX * sumaY) / (n * sumaXCuadrada - sumaX * sumaX);
        double intercept = (sumaY - slope * sumaX)/n;
        
        
        // Calcular el error estándar y el coeficiente de correlación
        double sum_of_squared_residuals = 0.0;
        double sum_of_squared_deviation_from_mean = 0.0;
        double y_mean = sumaY / n;
        for (int i = 0; i < x.length; i++) {
            //double y_predicted = slope * x[i] + intercept;
            //double residual = y[i] - y_predicted;
            double residual = y[i] - intercept - (slope * x[i]);
            sum_of_squared_residuals += residual * residual;//Sr
            double deviation_from_mean = y[i] - y_mean;
            sum_of_squared_deviation_from_mean += deviation_from_mean * deviation_from_mean;
        }
        double standard_error = Math.sqrt(sum_of_squared_residuals / (n - 2));
        
        //Correlación (r ) = NΣXY - (ΣX)(ΣY) / Sqrt([NΣX2 - (ΣX)2][NΣY2 - (ΣY)2])
        double correlacion =  ((n * sumaXY) - (sumaX * sumaY)) / Math.sqrt( ((n * sumaXCuadrada)- Math.pow(sumaX, 2)) *  (  (n * sumaYCuadrada) -Math.pow(sumaY,2)) );
        // Imprimir los resultados
        System.out.println("Pendiente (m): " + slope);
        System.out.println("Intercepto (c): " + intercept);
        System.out.println("Error estándar: " + standard_error);
        System.out.println("Coeficiente de correlación: " + correlacion);
        
    }
}
