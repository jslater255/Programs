

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {

	private String[] preFile = new String[500];
	private String fileName;
	private int counter = 0;
	
	public void stringSpliter(String s){ // Weapon -type:String -power:int 0..1-weapon
		boolean priv;
		boolean pub;
		boolean prot;
		String f1 = "public ";
		String f2 = "private ";
		String f3 = "protected "; 
		
		String delims = "[ ]+";
		String delims2 = "[:]+";
		String[] tokens = s.split(delims);
		fileName = tokens[0];
		
		preFile[0]="import java.util.*;";
		counter++;
		counter++;
		preFile[counter]="public class ".concat(tokens[0].concat(" {"));
		counter ++;
		
		for(int i=1;i<tokens.length;i++){
			
			priv=false;
			pub=false;
			prot=false;
			
			if(tokens[i].charAt(0)=='1'){	
				if(tokens[i].charAt(1)=='-')
					priv=true;
				if(tokens[i].charAt(1)=='+')
					pub=true;
				if(tokens[i].charAt(1)=='#')
					prot=true;
				
				String d1 = tokens[i].substring(2);
				String[] d2 = d1.split(delims2);
				
				if(priv==true)
					f1 = "private ";
				if(pub==true)
					f1 = "public ";
				if(prot==true)
					f1 = "protected ";
				
				preFile[i+counter]=f1.concat(d2[0].concat(" ".concat(d2[1].concat(";"))));
				counter ++;
			}
			
			if(tokens[i].charAt(0)=='2'){	
				if(tokens[i].charAt(1)=='-')
					priv=true;
				if(tokens[i].charAt(1)=='+')
					pub=true;
				if(tokens[i].charAt(1)=='#')
					prot=true;
				
				String d1 = tokens[i].substring(2);
				String[] d2 = d1.split(delims2);
				
				if(priv==true)
					f1 = "private ";
				if(pub==true)
					f1 = "public ";
				if(prot==true)
					f1 = "protected ";
				
				preFile[i+counter]=f1.concat(d2[1].concat(" ".concat(d2[0].concat("{}"))));
				counter ++;
			}
			
			if(tokens[i].charAt(0)=='0'){
				if(tokens[i].charAt(3)=='1'){
					String d3 = tokens[i].substring(4);
					if(d3.charAt(0)=='-'){
						priv=true;
						String d1 = d3.substring(1);
						String[] d2 = d1.split(delims2);
						
						if(priv==true){
							f1 = "private ";
						}
						if(pub==true){
							f1 = "public ";
						}
						
						counter ++;
						preFile[i+counter]=f1.concat(d2[1].concat(" ".concat(d2[0].concat(";"))));
						counter ++;
						
						counter++;
						preFile[i+counter]=f2.concat(("void set".concat
								(d2[1].concat("(").concat(d2[1].concat
										(".sV".concat("){}"))))));
						counter++;
						
						counter++;
						preFile[i+counter]=f2.concat(d2[1].concat
								(" ".concat("get".concat(d2[1].concat("(){}")))));
						counter++;
						
						
					}
				}
			}
			//0..1 links as linking variables with add, sets and gets as appropriate
			if(tokens[i].charAt(0)=='0'){
				if(tokens[i].charAt(3)=='*'){
					String d3 = tokens[i].substring(4);
					if(d3.charAt(0)=='-'){
						priv=true;
						String d1 = d3.substring(1);
						String[] d2 = d1.split(delims2);
						
						if(priv==true){
							f1 = "private ";
						}
						if(pub==true){
							f1 = "public ";
						}
						
						counter ++;
						preFile[i+counter]=f1.concat("ArrayList<".concat(d2[1].concat
								("> ".concat(d2[0].concat(";")))));
						counter ++;
						
						counter++;
						preFile[i+counter]=f2.concat(("void add".concat
								(d2[1].concat("(").concat(d2[1].concat
										(".sV".concat("){}"))))));
						counter++;
					}
				}
			}
			
		}
		preFile[tokens.length+counter]="}";
		try {
			writeFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void writeFile() throws IOException{   
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName+".java"));
		
		for(int i=0;i<preFile.length;i++){
			if(preFile[i]!=null)
				bw.write(preFile[i]);
			bw.newLine();
		}
		
		bw.close();
		
	}
	
	public String getFileName(){
		return fileName;
	}
}

