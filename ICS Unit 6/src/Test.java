
public class Test {
	static class Cars {
		private static int count;
		public Cars() {
			count += 1;
		}
	}
	public static void main(String[] args) {
		Cars car1 = new Cars();
		Cars car2 = new Cars();
	}

}
