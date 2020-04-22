import java.util.ArrayList;

/**
 * This class tests your ability to write code that manipulates arrays using
 * loops.
 * 
 * @author YOUR_NAME_HERE. Created Sep 28, 2009
 */
public class ArrayFiller {
	/**
	 * @return an array containing the numbers 1 2 3 4 5 6 7 8 9 10
	 */
	public static int[] fillErUp1() {
		
		int[] output = new int[10];
		for(int i=0;i<output.length;i++){
			output[i]=i+1;
		}
		// TODO, Prob. C1: implement this ArrayFiller method using a SINGLE loop
		return output;
	}

	/**
	 * @return an array containing the numbers 2 4 6 8 10 12 14
	 */
	public static int[] fillErUp2() {
		int[] output = new int[7];
		for(int i=0;i<output.length;i++){
			output[i]=(i+1)*2;
		}
		// TODO, Prob. C1: implement this ArrayFiller method using a SINGLE loop
		return output;
	}

	/**
	 * @return an ArrayList containing the numbers 0 3 6 9 12 15 18 
	 */
	public static ArrayList<Integer> fillErUp3() {
		ArrayList<Integer> output =new ArrayList<>();
		for(int i=0;i<7;i++){
			output.add(i*3);
		}
		// TODO, Prob. C1: implement this ArrayFiller method using a SINGLE loop
		return output;
	}

	/**
	 * @return an ArrayList containing the numbers 1 4 7 10 13 13 10 7 4 1
	 */
	public static ArrayList<Integer> fillErUp4() {
		ArrayList<Integer> output =new ArrayList<>();
		for(int i=0;i<10;i++){
			
			if(i>4){
				output.add(1+(9-i)*3);
			}else{
			output.add(1+i*3);
			}
		}
		// TODO, Prob. C1: implement this ArrayFiller method using a SINGLE loop
		return output;
	}

}
