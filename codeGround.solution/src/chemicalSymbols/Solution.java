package chemicalSymbols;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;


public class Solution {
	private static Scanner sc;

	public static void main(String args[]) throws Exception	{
		sc = new Scanner(new FileInputStream("input.txt"));
        
//		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;
		
		ChemicalSymbol cs = new ChemicalSymbol();

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			
			String sentence = sc.next();
			cs.initDp(sentence.length());
			boolean isSentenceWithChemicalSymbols = cs.findSymbol(sentence, 0);
			String result = "NO";
			if(isSentenceWithChemicalSymbols){
				result = "YES";
			}
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(result);
		}
	}
}

class ChemicalSymbol {
	
	String[] symbols = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al",
			   "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe",
			   "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr",
			   "Y","Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb",
			   "Te", "I", "Xe", "Cs", "Ba", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au",
			   "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Rf", "Db", "Sg",
			   "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Fl", "Lv", "La", "Ce", "Pr", "Nd",
			   "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Ac",
			   "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md",
			   "No", "Lr"};
	
	int[] dp;	// 0 not yet, 1 is ok, 2 is no;
	
	public ChemicalSymbol() {
		for(int i=0; i<this.symbols.length; i++){
			this.symbols[i] = this.symbols[i].toLowerCase();
		}
		Arrays.sort(this.symbols);
	}
	
	public void initDp(int strLength){
		this.dp = new int[strLength];
	}
	
	public boolean findSymbol(String str, int here){
		boolean hasSymbol = false;
		if(str.length()<=0) return false;
		if(here>=str.length()) return true;
		if(this.dp[here] == 1) return true;
		else if(this.dp[here] == 2) return false;
		else {	// dp[here] == 0일 경우 
			if(Arrays.binarySearch(this.symbols, str.substring(here, here+1))>=0 && findSymbol(str, here+1)) {
				hasSymbol = true;
				this.dp[here] = 1;
			}
			if(here+1<str.length() && Arrays.binarySearch(this.symbols, str.substring(here, here+2))>=0 && findSymbol(str, here+2)) {
				hasSymbol = true;
				this.dp[here] = 1;
			}
			if(!hasSymbol) this.dp[here] = 2;
			return hasSymbol;
		}
	}
	
	public void printDp(){
		for(int i =0; i<this.dp.length; i++){
			System.out.print(this.dp[i]+ " ");
		}
		System.out.println(" ");
	}
}