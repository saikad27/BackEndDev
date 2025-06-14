import java.io.*;
class Demo {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a number : ");
		int x = Integer.parseInt(br.readLine());
		System.out.println(x);
	}

}
