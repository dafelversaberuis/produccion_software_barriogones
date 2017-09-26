package fundacionFRC.generales;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Prueba {

	/**
	 * Redondea un valor a n decimales
	 * 
	 * @param aValor
	 * @param aNumeroDecimales
	 * @return valor
	 */
	public BigDecimal getValorRedondeado(BigDecimal aValor, Integer aNumeroDecimales) {

		BigDecimal valor = new BigDecimal(0);
		try {

			valor = aValor.setScale(aNumeroDecimales, RoundingMode.HALF_UP);

		} catch (Exception e) {
			valor = new BigDecimal(0);
		}

		return valor;
	}

	public static void main(String[] args) {
		try {
			// int number = 10;
			// int suma = 0;
			// int contador = 1;
			// while(contador*3<number){
			// suma+=contador*3;
			// contador++;
			// }
			// contador = 1;
			// while(contador*5<number){
			// suma+=contador*5;
			// contador++;
			// }
			// System.out.println(suma);

			String strng = "56 65 74 100 99 68 86 180 90";
			String[] valores = strng.split(" ");
			Integer[][] pesos = new Integer[2][valores.length];
			for (int i = 0; i <= valores.length - 1; i++) {
				String[] digito = valores[i].split("");
				int suma = 0;
				for (int j = 0; j <= digito.length - 1; j++) {
					suma += Integer.parseInt(digito[j]);
				}
				pesos[0][i] = Integer.parseInt(valores[i]);
				pesos[1][i] = suma;

			}

			int aux = 0;

			for (int i = 0; i < valores.length - 1; i++) {
				for (int j = 0; j < valores.length - 1; j++) {
					if (pesos[1][j] > pesos[1][j + 1]) {
						aux = pesos[1][j];
						pesos[1][j] = pesos[1][j + 1];
						pesos[1][j + 1] = aux;

						aux = pesos[0][j];
						pesos[0][j] = pesos[0][j + 1];
						pesos[0][j + 1] = aux;

					}
				}
			}
			
			String sarta = "";
			for(int i=0; i<=valores.length-1; i++){
				sarta+=pesos[0][i]+" ";
			}
			System.out.println(sarta);

			// BigDecimal anosTrabajados = new BigDecimal(0);
			// Float DIAS_ANO = new Float(360);
			// long aDiasTrabajados = 96;
			// BigDecimal tempDiasTrabajados = new BigDecimal(aDiasTrabajados);
			//
			// anosTrabajados = tempDiasTrabajados.divide(new BigDecimal(DIAS_ANO),10,
			// RoundingMode.HALF_UP);
			// System.out.println(anosTrabajados);
		} catch (Exception e) {
			System.out.println("**");
		}

	}

}
