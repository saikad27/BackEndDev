import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class Demo{
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a character : ");
		char ch = 'a';
		try{
			ch = (char)br.read();
			br.skip(1);
		}catch(IOException e){
			e.printStackTrace();	
		}
		System.out.println(ch);
		
	}
}
