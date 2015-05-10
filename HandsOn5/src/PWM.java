/*Michael Nguyen
 * CS49J
 */

public class PWM {
	public static void main(String args[]){
		String[] sequences = {"AGTGTAAGT","TTCGTAAGT","AGGGTAAGA","CAGGTGGGG","GAGGTGAGT",
				"ACGGTAACT","CTCGTAAGT","TAAGTAAGC","CTGGTGGGT","CAGGTGAGG"};
		
		int aCount = 0, gCount = 0, tCount = 0, cCount = 0;
		int COL = 9, ROW = 10, AMINO = 4;
		
		double[][] matrix = new double[AMINO][COL];
		
		for(int i = 0; i < COL; i++)
		{
			for(int j = 0; j < ROW; j++)
			{
				if(sequences[j].charAt(i) == 'A')
					aCount++;
				else if(sequences[j].charAt(i) == 'G')
					gCount++;
				else if(sequences[j].charAt(i) == 'C')
					cCount++;
				else if(sequences[j].charAt(i) == 'T')
					tCount++;
			}
			
			matrix[0][i] = (aCount + .1) / 10.4;
			matrix[1][i] = (cCount + .1) / 10.4;
			matrix[2][i] = (gCount + .1) / 10.4;
			matrix[3][i] = (tCount + .1) / 10.4;
			//reset the count for next iteration
			aCount = 0;
			gCount = 0;
			cCount = 0;
			tCount = 0;
		}
		
		for(int i = 0; i < AMINO; i++) //A, G, C, T
		{
			for(int j = 0; j < COL; j++)
			{
				//divide by log2 to get log base 2
				matrix[i][j] = (Math.log(matrix[i][j] / .25) / Math.log(2));
				System.out.printf("%.3f ", matrix[i][j]);
			}
			System.out.println("\n");
		}
		String[] inputs = {"CGTGAGGAA", "ACCGTGGAC"};
		double score = 0;
		for(int i = 0; i < 2; i ++) //two scores to compute
		{
			score = 0;
			for(int j = 0; j < COL; j++)
			{
				if(inputs[i].charAt(j) == 'A')
					score += matrix[0][j];
				else if(inputs[i].charAt(j) == 'C')
					score += matrix[1][j];
				else if(inputs[i].charAt(j) == 'G')
					score += matrix[2][j];
				else if(inputs[i].charAt(j) == 'T')
					score += matrix[3][j];
			}
			System.out.printf("%s %.3f\n", inputs[i], score);
		}
	}
}
