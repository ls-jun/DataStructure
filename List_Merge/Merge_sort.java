// Lab 010	: Natural Merge
// Name :
// Student ID :

import java.util.*;


class NaturalMerge {
	int noe;  // the number of elements
	private int[] inputArray; // input array 
	int[] outputArray; // output array 
	int R;

	NaturalMerge() { 
		// Graph constructor. 
		noe = 0;
	}

	public String toString() {
		String str = new String();
		str = "Input : ";
		for(int i = 0; i < noe; i++) {
			str += inputArray[i] + " ";
		}
		str += "\nOutput : ";
		for(int i = 0; i < noe; i++) {
			str += outputArray[i] + " ";
		}
		return str;
	}

	void Init(int [] arr, int n) { 
		noe = n;
		inputArray = new int[noe];
		System.arraycopy(arr, 0, inputArray, 0, n);

		outputArray = new int[noe];
	}

	void Merge() { 
		int n = noe;
		for(int i = 0; i < n; i++) {
			if(inputArray[i] > inputArray[i+1]) {
				R = i+1;
				break;
			}
		}
		int Li = 0;
		int Ri = R;
		System.out.println("noe = "+ n+", R = " + R);
		
		for(int i = 0; i < noe; i++) {
			if(Li == R) {
				while(Ri < noe) {
					outputArray[i] = inputArray[Ri];
					Ri++;
					i++;
				}
				break;
			}
			else if(Ri == noe) {
				while(Li < R) {
					outputArray[i] = inputArray[Li];
					Li++;
					i++;
				}
				break;
			}
			if(inputArray[Li] <= inputArray[Ri]) {
				outputArray[i] = inputArray[Li];
				Li++;
				System.out.print("L ");
			}
			else if(inputArray[Li] > inputArray[Ri]) {
				outputArray[i] = inputArray[Ri];
				Ri++;
				System.out.print("R ");
			}
			
			
		}
		System.out.println();

	// NEED TO IMPLEMENT


	}
}







