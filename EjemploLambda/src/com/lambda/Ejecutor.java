package com.lambda;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Ejecutor {

	public static void main(String[] args) {

		System.out.println("Matriz 1 : ");

		int matriz[][] = new int[3][3];

		matriz[0][0] = 1;	matriz[0][1] = 2;	matriz[0][2] = 3;

		matriz[1][0] = 4;	matriz[1][1] = 5;	matriz[1][2] = 6;

		matriz[2][0] = 7;	matriz[2][1] = 8;	matriz[2][2] = 9;

		int matriz2[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		for (int x = 0; x < matriz.length; x++) {
			System.out.print("|");
			for (int y = 0; y < matriz[x].length; y++) {
				System.out.print(matriz[x][y]);
				if (y != matriz[x].length - 1)
					System.out.print("|\t|");
			}
			System.out.println("|");
		}

		System.out.println("Matriz 2 : ");

		for (int x = 0; x < matriz2.length; x++) {
			System.out.print("|");
			for (int y = 0; y < matriz2[x].length; y++) {
				System.out.print(matriz2[x][y]);
				if (y != matriz2[x].length - 1)
					System.out.print("|\t|");
			}
			System.out.println("|");
		}
		
//		imprimirMatriz(matriz);
//		crearMatriz1(3, 3);
//		crearMatrizMenorA10(10, 10);
//		crearMatrizBordes0(10,10);
//		crearMatrizBinario(15,13);
//		crearMatrizRandom(8,5);
//		imprimirMatriz(crearMatrizRandom(8,5));
		
//		int matrizLambda[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int matrizBinario[][] = crearMatrizRandom(3,18);
		
//		mostrar todos los valores de la matriz
//		Arrays.stream(matrizBinario).flatMapToInt(x -> Arrays.stream(x)).forEach(y -> System.out.println(y+" ; "));
		
//		suma de valores de cada array
		Arrays.stream(matrizBinario).forEach(x -> System.out.println("Suma por fila : " + Arrays.stream(x).sum()));
		
//		suma de valores de cada array
		int suma = Arrays.stream(matrizBinario).flatMapToInt(x -> Arrays.stream(x))
		  .sum();
		
		System.out.println("Suma de todos los elementos de la matriz : " + suma);
//		Arrays.stream(matrizBinario).forEach(x -> Arrays.stream(x).sum());
	}

	public static void imprimirMatriz(int matriz[][]) {

		System.out.println("Metodo imprimir Matriz");
		System.out.print("\n Filas : " + matriz.length);
		System.out.println("\t Columnas : " + matriz[0].length + "\n");

		for (int i = 0; i < matriz.length; i++) {
			System.out.print("|");
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]);
				if (j != matriz[i].length - 1)
					System.out.print("|\t|");
			}
			System.out.println("|");
		}
	}

	public static int[][] crearMatriz1(int x, int y) {

		System.out.println("Metodo crear Matriz 1 ");
		System.out.print("\n Filas : " + x);
		System.out.println("\t Columnas : " + y + "\n");

		int matriz[][] = new int[x][y];
		
		int contador = 1;

		for (int i = 0; i < matriz.length; i++) {
			System.out.print("|");
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = contador;
				System.out.print(matriz[i][j]);
				if (j != matriz[i].length - 1)
					System.out.print("|\t|");
				contador++;
			}
			System.out.println("|");
		}

		return matriz;
	}

	public static int[][] crearMatrizMenorA10(int x, int y) {

		System.out.println("Metodo crear Matriz numeros menores a 10 ordenados ");
		System.out.print("\n Filas : " + x);
		System.out.println("\t Columnas : " + y + "\n");

		int matriz[][] = new int[x][y];

		int contador = 1;

		for (int i = 0; i < matriz.length; i++) {
			System.out.print("|");
			for (int j = 0; j < matriz[i].length; j++) {
				if (contador > 9) {
					contador = 1;
				}
				matriz[i][j] = contador;
				System.out.print(matriz[i][j]);
				if (j != matriz[i].length - 1)
					System.out.print("|\t|");
				contador++;
			}
			System.out.println("|");
		}

		return matriz;
	}
	
	public static int[][] crearMatrizBordes0(int x, int y) {

		System.out.println("Metodo crear Matriz Bordes 0 ");
		System.out.print("\n Filas : " + x);
		System.out.println("\t Columnas : " + y + "\n");

		int matriz[][] = new int[x][y];

		int contador = 1;

		for (int i = 0; i < matriz.length; i++) {
			System.out.print("|");
			for (int j = 0; j < matriz[i].length; j++) {
				if (contador > 9) {
					contador = 1;
				}
				if(i==0 || i==matriz.length - 1 || j==matriz[i].length - 1 || j ==0 ) {
					matriz[i][j] = 0;
				} else {
				matriz[i][j] = contador;
				}
				System.out.print(matriz[i][j]);
				if (j != matriz[i].length - 1)
					System.out.print("|\t|");
				contador++;
			}
			System.out.println("|");
		}

		return matriz;
	}
	
	public static int[][] crearMatrizBinario(int x, int y) {

		System.out.println("Metodo crear Matriz Binario ");
		System.out.print("\n Filas : " + x);
		System.out.println("\t Columnas : " + y + "\n");

		int matriz[][] = new int[x][y];

		for (int i = 0; i < matriz.length; i++) {
			System.out.print("|");
			for (int j = 0; j < matriz[i].length; j++) {
				if ((i == 0 && j == 0) || j == 0) {
					matriz[i][j] = 0;
				} else {
					if (matriz[i][j - 1] == 0) {
						matriz[i][j] = 1;
					} else {
						matriz[i][j] = 0;
					}
				}

				System.out.print(matriz[i][j]);
				if (j != matriz[i].length - 1)
					System.out.print("|\t|");
			}
			System.out.println("|");
		}

		return matriz;
	}
	
	public static int[][] crearMatrizRandom(int x, int y) {

		System.out.println("Metodo crear Matriz Random");
		System.out.print("\n Filas : " + x);
		System.out.println("\t Columnas : " + y + "\n");

		int matriz[][] = new int[x][y];
		
		Random rand = new Random();

		for (int i = 0; i < matriz.length; i++) {
			System.out.print("|");
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = rand.nextInt((9 - 1) + 1) + 1;
				System.out.print(matriz[i][j]);
				if (j != matriz[i].length - 1)
					System.out.print("|\t|");
			}
			System.out.println("|");
		}

		return matriz;
	}

}
