import java.io.*;
import java.util.*;

public class LexicalAnalyzer {
	static Set<String> reservedWord = new HashSet<String>();
	static Set<String> alphabet = new HashSet<String>();
	static Set<String> comparativeSignal = new HashSet<String>();
	static Set<String> arithmeticSignal = new HashSet<String>();
	
	private static void initiateHash(){
		reservedHash();
		alphabetHash();
		comparativeHash();
		arithmeticHash();
	}
	
	private static void reservedHash(){
		reservedWord.add("BEGIN");
		reservedWord.add("END");
		reservedWord.add("IF");
		reservedWord.add("DO");
		reservedWord.add("ELSE");
		reservedWord.add("ENDIF");
		reservedWord.add("FOR");
		reservedWord.add("DO");
		reservedWord.add("ENDFOR");
		reservedWord.add("WHILE");
		reservedWord.add("DO");
		reservedWord.add("ENDWHILE");
		reservedWord.add("READ");
		reservedWord.add("PRINT");
		reservedWord.add("VAR");
		reservedWord.add("FALSE");
		reservedWord.add("TRUE");
	}
	
	private static void alphabetHash(){
		alphabet.add("A");alphabet.add("B");alphabet.add("C");alphabet.add("D");
		alphabet.add("E");alphabet.add("F");alphabet.add("G");alphabet.add("H");
		alphabet.add("I");alphabet.add("J");alphabet.add("K");alphabet.add("L");
		alphabet.add("M");alphabet.add("N");alphabet.add("O");alphabet.add("P");
		alphabet.add("Q");alphabet.add("R");alphabet.add("S");alphabet.add("T");
		alphabet.add("U");alphabet.add("V");alphabet.add("W");alphabet.add("Y");
		alphabet.add("X");alphabet.add("Z");alphabet.add("1");alphabet.add("2");
		alphabet.add("3");alphabet.add("4");alphabet.add("5");alphabet.add("6");
		alphabet.add("7");alphabet.add("8");alphabet.add("9");alphabet.add("0");
		alphabet.add("!");alphabet.add(".");alphabet.add("_");alphabet.add("=");
	}
	
	private static void comparativeHash(){
		comparativeSignal.add("==");comparativeSignal.add(">");comparativeSignal.add("<");
		comparativeSignal.add(">=");comparativeSignal.add("<=");comparativeSignal.add("!=");
	}
	
	private static void arithmeticHash(){
		arithmeticSignal.add("+");arithmeticSignal.add("-");
		arithmeticSignal.add("*");arithmeticSignal.add("/");
	}
	
	private static boolean isReservedWord(String word){
		if(reservedWord.contains(word)){
			return true;
		}else{return false;}
	}
	
	private static boolean isPartOfTheAlphabet(char charactere){
		String c = ""+charactere;
		if(alphabet.contains(c)){
			return true;
		}else{return false;}
	}
	
	private static boolean isComparativeSignal(String word){
		if(comparativeSignal.contains(word)){
			return true;
		}else{return false;}
	}
	
	private static boolean isArithmeticSignal(String word){
		if(arithmeticSignal.contains(word)){
			return true;
		}else{return false;}
	}
	
	public static void main(String[] args) throws IOException{
		 initiateHash();
		 BufferedReader br = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("commandLine.txt")));
         String line;
         String[] partionedString;
         char[] characteredString;
         int numeroLinha = 1;
         
         outterloop:
         while((line = br.readLine()) != null){
        	 partionedString = line.split("\\s+");
        	  
        	 for(int k = 0; k < partionedString.length;k++){
        		 if(isReservedWord(partionedString[k])){
        			 System.out.println("Palavra: " + partionedString[k]+ " | linha: " + numeroLinha + " | " + "É uma palavra reservada.");
        		 }else{
        			 if(isComparativeSignal(partionedString[k])){
        				 System.out.println("Palavra: " + partionedString[k]+ " | linha: " + numeroLinha + " | " + "É um sinal comparativo.");
        			 }else{
        				 if(isArithmeticSignal(partionedString[k])){
        					 System.out.println("Palavra: " + partionedString[k]+ " | linha: " + numeroLinha + " | " + "É um sinal aritmetico.");
        				 }else{
        					 characteredString = partionedString[k].toCharArray();
                			 for(int h = 0; h < characteredString.length;h++){
                				 if(!isPartOfTheAlphabet(characteredString[h])){
                					 System.err.println("Palavra: " + partionedString[k]+ " | linha: " + numeroLinha + " | " + "Não é uma palavra válida."
                					 		+ " Contem caracteres fora do alfabeto. -> " + characteredString[h] + " <-");
                					 break outterloop;
                				 }
                			 }
                			 System.out.println("Palavra: " + partionedString[k]+ " | linha: " + numeroLinha + " | " + "É uma string válida.");
        				 }
        			 }
        		 }
        	 }
        	 numeroLinha++;
         }
	}
}
