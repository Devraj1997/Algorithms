package algorithms.stable.matching;

import java.util.Arrays;

public class StableMatching {

	static int N = 3;

	static boolean wPrefersM1OverM(int prefer[][], int w, int m, int m1) {
		for (int i = 0; i < N; i++) {
			if (prefer[w][i] == m1)
				return true;
			if (prefer[w][i] == m)
				return false;
		}
		return false;
	}

	static void stableMarriage(int prefer[][]) {

		int wPartner[] = new int[N];

		boolean mFree[] = new boolean[N];

		Arrays.fill(wPartner, -1);
		int freeCount = N;

		while (freeCount > 0) {
			int m;
			for (m = 0; m < N; m++)
				if (mFree[m] == false)
					break;

			for (int i = 0; i < N && mFree[m] == false; i++) {
				int w = prefer[m][i];

				if (wPartner[w - N] == -1) {
					wPartner[w - N] = m;
					mFree[m] = true;
					freeCount--;
				}

				else {
					int m1 = wPartner[w - N];

					if (wPrefersM1OverM(prefer, w, m, m1) == false) {
						wPartner[w - N] = m;
						mFree[m] = true;
						mFree[m1] = false;
					}
				} 
			} 
		}
		
		System.out.println("Woman Man");
		for (int i = 0; i < N; i++) {
			System.out.print(" ");
			System.out.println(i + N + "	 " + wPartner[i]);
		}
	}

	public static void main(String[] args) {
//		int prefer[][] = new int[][] { 
//			{ 3, 4, 5 }, 
//			{ 4, 5, 3 }, 
//			{ 3, 4, 5 }, 
//			{ 2, 1, 0 }, 
//			{ 0, 2, 1 },
//			{ 0, 1, 2 } };
		int prefer[][] = new int[][] { 
			{ 3, 4, 5 }, 
			{ 4, 5, 3 }, 
			{ 3, 4, 5 }, 
			{ 2, 1, 0 }, 
			{ 0, 2, 1 },
			{ 0, 1, 2 } };
		stableMarriage(prefer);
	}
}

