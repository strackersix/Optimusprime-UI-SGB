package POC;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import _CORE.Parametros;

public class MetodoMain {

	public static void main(String[] args) {

		try {

			FileInputStream arquivo = new FileInputStream("C:\\Automacao\\Parametros\\TestDemandaPonta\\existeBug.txt");
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader lerTxt = new BufferedReader(input);

			String CapturaValorTxt;

			CapturaValorTxt = lerTxt.readLine();
			boolean Bug;

			Bug = Boolean.parseBoolean(CapturaValorTxt);
			Parametros.existeBug = Bug;

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
