

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileDecriptor {

	String[] preFile = new String[500];
	String[] stuff = new String[50];
	String className;
	String info;
	int counter;
	

	public void readFile(String fileName)throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(fileName+".java"));
		
		for(int i=0;i<500;i++){
			preFile[i] = br.readLine();
		}
		br.close();
		decriptFile();
	}
	
	public void decriptFile(){
		for(int i=0;i<stuff.length;i++)
			stuff[i]=" ";
		
		String bah = null;
		counter = 0;
		for(int i=0;i<preFile.length;i++){
	
			String delims = "[ ]+";
			String[] words = preFile[i].split(delims);
		
			if(words[0].equals("public") && words[1].equals("class"))
				className=words[2];
			
			if(words[0].equals("public") || words[0].equals("private") || words[0].equals("protected")){
				
				if(words[0].equals("public"))
					bah="+";
				if(words[0].equals("private"))
					bah="-";
				if(words[0].equals("protected"))
					bah="#";
				
				/*
				if(words[1].equals("String") || words[1].equals("int") || 
						words[1].equals("double") || words[1].equals("float") || 
						words[1].equals("boolean") || words[1].equals("int[]") ||
						words[1].equals("int[][]")||words[1].equals("String[]") ||
						words[1].equals("String[][]")||words[1].equals("boolean[]") ||
						words[1].equals("boolean[][]") || words[1].equals("float[]") ||
						words[1].equals("float[][]") || words[1].equals("double[]") ||
						words[1].equals("double[][]")){
				*/
					if(words[2].charAt(words[2].length()-1) ==';'){
						String bah2 = words[2].substring(0,words[2].length()-1);
						stuff[counter]="1".concat(bah).concat(words[1]+":").concat(bah2);
						counter++;
					}
					if(words[2].charAt(words[2].length()-1) =='}'){
						String bah2 = words[2].substring(0,words[2].length()-2);
						stuff[counter]="2".concat(bah).concat(bah2+":").concat(words[1]);
						counter++;
					}			
			}
			
		}
		info=className;
		for(int i=0;i<stuff.length;i++){
			info=info.concat(" "+stuff[i]);
		}
	}
	
	public String getInfo(){
		return info;
	}
	
}
