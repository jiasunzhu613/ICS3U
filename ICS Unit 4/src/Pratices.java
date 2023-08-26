import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Pratices {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReaderTemplate console = new BufferedReaderTemplate();
		int num = console.readInt();
		String[] input = console.readLine().split(" ");
		long[] input1 = new long[input.length];
		for (int i = 0; i<input.length;i++) {
			input1[i]= Integer.parseInt(input[i]);
		}
		long count = 0;
		for (int i = 0;i<input1.length;i++) {
			count += input1[i]*2*num;
			
		}
		System.out.println(count);
		

	}
	
	

}

