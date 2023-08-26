import java.util.*;

public class Factoring {
	
	public static void main(String[] args) {
		//test 7: 10 -22 4
		int change1 = 1, change2=1;
		boolean changed0 = false, changed1 = false;
		//System.out.println(gcd(-3, 6));
        Scanner console = new Scanner(System.in);
        String numbers = console.nextLine();
        String[] numbersArr = numbers.split(" ");
        int a = Integer.parseInt(numbersArr[0]);
		int b = Integer.parseInt(numbersArr[1]);
		int c = Integer.parseInt(numbersArr[2]);
        if (a != 0 && c != 0 && a % 1 == 0 && b % 1 == 0 && c % 1 == 0) {
        	int abcgcd = Math.abs(gcd(gcd(a, b),c));
        	a = a /abcgcd;
        	b = b /abcgcd;
        	c = c /abcgcd;
        	int factor1 = findFactors((int)a,(int)b,(int)c)[0];
        	int factor2 = findFactors((int)a,(int)b,(int)c)[1];
        	int coeff1 = gcd((int)a, (int)factor1);
        	int result1 = gcd((int)factor2, (int)c);
        	int coeff2 = a/coeff1;
        	int result2 = factor1/coeff1;
            int[] ans = {-1*result1, -1*result2};
            //int[] pair1 = {coeff1, result1};
            //int[] pair2 = {coeff2, result2};
            insertionSort(ans);
            int[] coeff = {coeff1, coeff2};
            if (ans[0] == -1*result1) {
            	coeff[0] = coeff1;
            	coeff[1] = coeff2;
            }else {
            	coeff[0] = coeff2;
            	coeff[1] = coeff1;
            }
            /*
            //System.out.println(a);
            System.out.println(factor1);
            System.out.println(factor2);
            System.out.println(coeff1);
            System.out.println(result1);
            System.out.println(coeff2);
            System.out.println(result2);

            System.out.println(ans[0]*-1);
            System.out.println(coeff[0]);
            System.out.println(ans[1]*-1);
            System.out.println(coeff[1]);
           */
            if (abcgcd == 1 && coeff[0] == 1 && coeff[1] == 1 && abcgcd == 1) {
            	System.out.println(String.format("(x%+d)(x%+d)",(ans[0]*-1), (ans[1]*-1)));
            }else if (abcgcd == 1 && coeff[0] == 1 && coeff[1] != 1) {
            	System.out.println(String.format("(x%+d)(%dx%+d)",(ans[0]*-1), coeff[1], (ans[1]*-1)));
            }else if (abcgcd == 1 && coeff[0] != 1 && coeff[1] == 1) {
            	System.out.println(String.format("(%dx%+d)(x%+d)",coeff[0], (ans[0]*-1), (ans[1]*-1)));
            }else if (abcgcd == 1 && coeff[0] != 1 && coeff[1] != 1) {
            	System.out.println(String.format("(%dx%+d)(%dx%+d)",coeff[0], (ans[0]*-1), coeff[1],(ans[1]*-1)));
            }else if (abcgcd != 1 && coeff[0] == 1 && coeff[1] == 1) {
            	System.out.println(String.format("%d(x%+d)(x%+d)", abcgcd, (ans[0]*-1),(ans[1]*-1)));
            }else if (abcgcd != 1 && coeff[0] != 1 && coeff[1] == 1) {
            	System.out.println(String.format("%d(%dx%+d)(x%+d)", abcgcd, coeff[0], (ans[0]*-1),(ans[1]*-1)));
            }else if (abcgcd != 1 && coeff[0] == 1 && coeff[1] != 1) {
            	System.out.println(String.format("%d(x%+d)(%dx%+d)", abcgcd, (ans[0]*-1), coeff[1],(ans[1]*-1)));
            }else {
            	System.out.println(String.format("%d(%dx%+d)(%dx%+d)", abcgcd,  coeff[0],(ans[0]*-1), coeff[1],(ans[1]*-1)));
            }
            
            /*
            if (changed0 == true && changed1 == true) {
            	if (coeff[0] == 1 && coeff[1] == 1) {
                	System.out.println(String.format("-(x%+d)-(x%+d)", (int)(ans[0]*-1), (int)(ans[1]*-1)));
                }else if (coeff[1] == 1) {
                	System.out.println(String.format("-(%dx%+d)-(x%+d)", (int)(coeff[0]), (int)(ans[0]*-1), (int)(ans[1]*-1)));
                }else if (coeff[0] == 1) {
                	System.out.println(String.format("-(x%+d)-(%dx%+d)", (int)(ans[0]*-1), (int)(coeff[1]), (int)(ans[1]*-1)));
                }else {
                	System.out.println(String.format("-(%dx%+d)-(%dx%+d)", (int)(coeff[0]), (int)(ans[0]*-1), (int)(coeff[1]), (int)(ans[1]*-1)));
                }
            }else if (changed0 == true) {
            	if (coeff[0] == 1 && coeff[1] == 1) {
                	System.out.println(String.format("(x%+d)-(x%+d)", (int)(ans[0]*-1), (int)(ans[1]*-1)));
                }else if (coeff[1] == 1) {
                	System.out.println(String.format("(%dx%+d)-(x%+d)", (int)(coeff[0]), (int)(ans[0]*-1), (int)(ans[1]*-1)));
                }else if (coeff[0] == 1) {
                	System.out.println(String.format("(x%+d)-(%dx%+d)", (int)(ans[0]*-1), (int)(coeff[1]), (int)(ans[1]*-1)));
                }else {
                	System.out.println(String.format("(%dx%+d)-(%dx%+d)", (int)(coeff[0]), (int)(ans[0]*-1), (int)(coeff[1]), (int)(ans[1]*-1)));
                }
            }else if (changed1 == true) {
            	if (coeff[0] == 1 && coeff[1] == 1) {
                	System.out.println(String.format("-(x%+d)(x%+d)", (int)(ans[0]*-1), (int)(ans[1]*-1)));
                }else if (coeff[1] == 1) {
                	System.out.println(String.format("-(%dx%+d)(x%+d)", (int)(coeff[0]), (int)(ans[0]*-1), (int)(ans[1]*-1)));
                }else if (coeff[0] == 1) {
                	System.out.println(String.format("-(x%+d)(%dx%+d)", (int)(ans[0]*-1), (int)(coeff[1]), (int)(ans[1]*-1)));
                }else {
                	System.out.println(String.format("-(%dx%+d)(%dx%+d)", (int)(coeff[0]), (int)(ans[0]*-1), (int)(coeff[1]), (int)(ans[1]*-1)));
                }
            }else {
            	if (coeff[0] == 1 && coeff[1] == 1) {
                	System.out.println(String.format("(x%+d)(x%+d)", (int)(ans[0]*-1), (int)(ans[1]*-1)));
                }else if (coeff[1] == 1) {
                	System.out.println(String.format("(%dx%+d)(x%+d)", (int)(coeff[0]), (int)(ans[0]*-1), (int)(ans[1]*-1)));
                }else if (coeff[0] == 1) {
                	System.out.println(String.format("(x%+d)(%dx%+d)", (int)(ans[0]*-1), (int)(coeff[1]), (int)(ans[1]*-1)));
                }else {
                	System.out.println(String.format("(%dx%+d)(%dx%+d)", (int)(coeff[0]), (int)(ans[0]*-1), (int)(coeff[1]), (int)(ans[1]*-1)));
                }
                
            }
   */
           
 
        }else if(a == 0 || c == 0 && (a % 1 == 0 && b % 1 == 0 && c % 1 == 0)) {
        	if (a == 0 && (b % c == 0 || c % b == 0)) {
        		int[] arr = {b, c};
                insertionSort(arr);
        		int result1 = arr[1] / (arr[1] / arr[0]);
        		int result2 = b / result1;
        		int result3 = c / result1;
        		if (result2 == 1) {
        			System.out.println(String.format("%d(x%+d)", (int)(result1), (int)(result3)));
        		}else {
        			System.out.println(String.format("%d(%dx%+d)", (int)(result1), (int)(result2), (int)(result3)));
        		}
        	}
        	if(c == 0 && (a % b == 0 || b % a == 0)) {
        		int[] arr = {a, b};
                insertionSort(arr);
        		int result1 = arr[1] / (arr[1] / arr[0]);
        		int result2 = a / result1;
        		int result3 = b / result1;
        		/*
        		System.out.println(result1);
        		System.out.println(result2);
        		System.out.println(result3);
        		*/
        		if (result2 == 1) { 
        			System.out.println(String.format("%dx(x%+d)", (int)(result1), (int)(result3)));
        		}else {
        			System.out.println(String.format("%dx(%dx%+d)", (int)(result1), (int)(result2), (int)(result3)));
        		}
        	}else {
        		System.out.println(String.format("x(%dx%+d)", (int)(a), (int)(b)));
        	}
        }
        /*
        int[] ans = {result1, result2};
        insertionSort(ans);
        System.out.println(String.format("(x%+d)(x%+d)", (int)(-1*ans[0])/10, (int)(-1*ans[1])/ 10));
        */
        
    }
	public static int[] findFactors(int a, int b, int c) {
		for (int i = -1 * Math.abs(b);; i++) {
			int diff = b - i;
			if (i + diff == b && i * diff == a * c) {
				int[] factors = {i, diff};
				return factors;

			}
		}
	}
	public static int gcd(int a, int b) {
		int initialA = a;
		//int initialB = b;
		a = Math.abs(a);
		b = Math.abs(b);
	    if (a == 0)
	        return b;

	    while (b != 0) {
	        if (a > b)
	            a = a - b;
	        else
	            b = b - a;
	    }
	    
	    if (initialA < 0) {
	    	return a*-1;
	    }
	    return a;
	}
    public static void insertionSort(int[] x) {
		for (int i = 1; i < x.length; i++) {
			int key = (int)x[i];
			int j = i - 1;
			while (j >= 0 && key < x[j]) {
				int temp = (int)x[j];
				x[j] = x[j + 1];
				x[j + 1] = temp;
				j--;
			}
		}
	}
    public static String toFraction(int x) {
    	int numDigits = countDigits(String.valueOf(x));
    	int num = (int) (x * Math.pow(10,numDigits));
    	int denom = (int) Math.pow(10,numDigits);
    	int gcd = gcd(num, denom);
    	if (num < 0 || denom < 0) {
    		return "-" + Math.abs(num/gcd) + "/" + Math.abs(denom/gcd);
    	}
		return num/gcd + "/" + denom/gcd;
    	
    }
    public static int countDigits(String x) {
		int count = 0;
		for (int i = 0; i<x.length();i++) {
			if (Character.isDigit(x.charAt(i))) {
				count++;
			}
		}
		return count;
	}

}
