package GeradorGrafico;

import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class geradorGrafico {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		
		FileWriter arq = new FileWriter("Gerador Gráfico.html");
		PrintWriter gravarArq = new PrintWriter(arq);
		
		
		//Quantidade Números
		System.out.print("Informe a quantidade de números da amostra:");
		int qtNumeros = entrada.nextInt();
		
		//Valor Minimo
		System.out.print("Informe o valor minimo da amostra:");
		int valorMinimo = entrada.nextInt();
		
		//Valor Maximo
		System.out.print("Informe o valor máximo da amostra:");
		int valorMaximo = entrada.nextInt();
		
		
		Random gerador = new Random();
        int[] numeros = new int[qtNumeros];
        
        gravarArq.println("<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['Contador', 'Valor'],");
        
        for (int i = 0; i < qtNumeros; i++) {
            numeros[i] = gerador.nextInt(valorMaximo - valorMinimo + 1) + valorMinimo;
            gravarArq.println("[" + (i + 1) + "," + numeros[i] + "],");
        }

        gravarArq.println("]);var options = {title: 'Gerador Gráfico'};var chart = new google.visualization.LineChart(document.getElementById('chart_div'));chart.draw(data, options);}</script></head><body><div id=\"chart_div\" style=\"width: 900px; height: 500px;\"></div></body></html>");

        arq.close();

        System.out.println("Arquivo Criado com sucesso!");

        entrada.close(); 

	}

}
