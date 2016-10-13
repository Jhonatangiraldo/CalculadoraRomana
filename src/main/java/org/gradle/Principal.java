package org.gradle;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Principal {
	
	public static void main(String[]args){
		Principal principal = new Principal("IV", "X");
		System.out.println(principal.devuelta());
	}
	
	private String numero1;
	private String numero2;
	public Map<String, Integer> vector;
	public Map<Integer, String> vectorDevuelta;
	
	public String getNumero1() {
		return numero1;
	}

	public void setNumero1(String numero1) {
		this.numero1 = numero1;
	}

	public String getNumero2() {
		return numero2;
	}

	public void setNumero2(String numero2) {
		this.numero2 = numero2;
	}
	
	public Principal(String numero1, String numero2){
		this.numero1 = numero1;
		this.numero2 = numero2;
		vector = new HashMap<String, Integer>();
		vector.put("I", 1);
		vector.put("V", 5);
		vector.put("X", 10);
		vector.put("L", 50);
		vector.put("C", 100);
		vector.put("D", 500);
		
		vectorDevuelta = new HashMap<Integer, String>();
		vectorDevuelta.put(1, "I");
		vectorDevuelta.put(5, "V");
		vectorDevuelta.put(10, "X");
		vectorDevuelta.put(50, "L");
		vectorDevuelta.put(100, "C");
		vectorDevuelta.put(500, "D");
	}
	
	public Principal() {
		vector = new HashMap<String, Integer>();
		vector.put("I", 1);
		vector.put("V", 5);
		vector.put("X", 10);
		vector.put("L", 50);
		vector.put("C", 100);
		vector.put("D", 500);
		vectorDevuelta = new HashMap<Integer, String>();
		vectorDevuelta.put(1, "I");
		vectorDevuelta.put(5, "V");
		vectorDevuelta.put(10, "X");
		vectorDevuelta.put(50, "L");
		vectorDevuelta.put(100, "C");
		vectorDevuelta.put(500, "D");
	}

	//Convertir a romanos
	public String devuelta(){
		char[] caracteres1 = this.getNumero1().toCharArray();
		char[] caracteres2 = this.getNumero2().toCharArray();
		if (this.validar(caracteres1, caracteres2)){
			return convertirToRomanos(convertirToNumeros(caracteres1, 0) + convertirToNumeros(caracteres2, 0));
		}else{
			return "Incorrect Numbers, try again with valid numbers";
		}
	}
	
	public String convertirToRomanos(int valor){
		if (valor == 500){
			return vectorDevuelta.get(500);
		}else if (valor < 500 && valor >= 100){
			if (valor >= 400)
				return vectorDevuelta.get(100) + vectorDevuelta.get(500) + convertirToRomanos(valor - 400);
			return vectorDevuelta.get(100) + convertirToRomanos(valor - 100);
		}else if(valor < 100 && valor >= 50){
			if (valor >= 90)
				return vectorDevuelta.get(10) + vectorDevuelta.get(100) + convertirToRomanos(valor - 90);
			return vectorDevuelta.get(50) + convertirToRomanos(valor - 50);
		}else if(valor < 50 && valor >= 10){
			if (valor >= 40)
				return vectorDevuelta.get(10) + vectorDevuelta.get(50) + convertirToRomanos(valor - 40);
			return vectorDevuelta.get(10) + convertirToRomanos(valor - 10);
		}else if (valor < 10 && valor >= 5){
			if (valor >= 9)
				return vectorDevuelta.get(1) + vectorDevuelta.get(10) + convertirToRomanos(valor - 9);
			return vectorDevuelta.get(5) + convertirToRomanos(valor - 5);
		}else if (valor > 1 && valor < 5){
			if (valor >= 4)
				return vectorDevuelta.get(1) + vectorDevuelta.get(5) + convertirToRomanos(valor - 4);
			return vectorDevuelta.get(1) + convertirToRomanos(valor - 1);
		}else if (valor == 1){
			return vectorDevuelta.get(1) ;
		}else{
			return "";
		}
	}

	public int convertirToNumeros(char[] caracteres, int resultado){
		if (caracteres.length > 1){
			if (vector.get(String.valueOf(caracteres[0])) < vector.get(String.valueOf(caracteres[1]))){
				char [] c = Arrays.copyOfRange(caracteres, 1, caracteres.length);
				int retorno = 0;
				if (c.length > 1){
					retorno = convertirToNumeros(Arrays.copyOfRange(c, 1, c.length), resultado) ;
				}else{
					retorno = 0;
				}
				return resultado + 
							(vector.get(String.valueOf(caracteres[1])) - vector.get(String.valueOf(caracteres[0]))) +  
							retorno; 
			}else{
				return resultado + vector.get(String.valueOf(caracteres[0])) +
						convertirToNumeros(Arrays.copyOfRange(caracteres, 1, caracteres.length), resultado);
			}
		}else{
			return vector.get(String.valueOf(caracteres[0]));
		}
	}
	
	//validar
	public boolean validar(char[] caracteres1, char[] caracteres2){
		return isValid(caracteres1) && isValid(caracteres2);
	}
	
	public boolean isValid(char[] caracteres){
		for (int i = 0; i < caracteres.length; i++){
			if (vector.get(String.valueOf(caracteres[i])) == null){
				return false;
			}
		}
			return true;
	}
}
