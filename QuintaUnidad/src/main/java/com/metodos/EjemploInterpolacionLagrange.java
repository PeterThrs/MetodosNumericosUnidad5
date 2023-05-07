/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodos;

public class EjemploInterpolacionLagrange {
    public static void main(String[] args) {
        // Valores conocidos
        double[] x = {8, 12}; // Valores conocidos de x
        double[] y = {0.9030900, 1.0791812}; // Valores conocidos de y
        double xValor = 10; // Valor para el cual queremos estimar y

        // Estimación y cálculo del error relativo porcentual
        double yValor = interpolacionLagrange(x, y, xValor);
        double valorReal = Math.log(xValor);
        double errorRelativo = calcularErrorRelativo(yValor, valorReal);

        System.out.println("Estimación para x = " + xValor + ": " + yValor);
        System.out.println("Error relativo porcentual: " + errorRelativo + "%");
    }

    // Función para calcular la interpolación de Lagrange
    public static double interpolacionLagrange(double[] x, double[] y, double xValor) {
        int n = x.length;
        double resultado = 0;

        for (int i = 0; i < n; i++) {
            double termino = y[i];

            for (int j = 0; j < n; j++) {
                if (j != i) {
                    termino *= (xValor - x[j]) / (x[i] - x[j]);
                }
            }

            resultado += termino;
        }

        return resultado;
    }

    // Función para calcular el error relativo porcentual
    public static double calcularErrorRelativo(double valorEstimado, double valorReal) {
        return Math.abs((valorEstimado - valorReal) / valorReal) * 100;
    }
}