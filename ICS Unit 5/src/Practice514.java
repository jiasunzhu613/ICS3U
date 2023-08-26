import java.util.*;
public class Practice514 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int s = console.nextInt();
		console.nextLine();
		int cnt = 0;
		for (int i = 0; i < s; i++) {
			int ind = 0;
			String[] split = console.nextLine().split(" ");
			while (Integer.parseInt(split[ind]) != -1 && ind < split.length - 1) {
				cnt += Integer.parseInt(split[ind]);
				ind += Integer.parseInt(split[ind]) + 1;
			}
		}
		System.out.println(cnt);

	}

}
