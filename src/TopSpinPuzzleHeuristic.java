
public class TopSpinPuzzleHeuristic
{
	public double getHeuristic(TopSpinPuzzleState problemState)
	{
		int[] puzzle = problemState._TopSpinPuzzle;
		int index0=0;
		for (int i = 0; i < puzzle.length; i++) {
			if(puzzle[0]==0) {
				index0 = i;
				break;
			}
		}
		/*
		int sum=0;
		if(puzzle.length%2==0)
			sum=puzzle.length/2;
		else
			sum=-puzzle.length/2;

		for (int i = 0; i < puzzle.length; i++) {
			if(i%2==0)
				sum += puzzle[(i+index0)%puzzle.length];
			else
				sum -= puzzle[(i+index0)%puzzle.length];
		}
		return Math.abs(sum);
		*/
		int sum=0;
		for (int i = 0; i < puzzle.length; i++) {
			sum+=puzzle[(i+index0)%puzzle.length]*i;
		}
		return Math.abs(sum);


	}
}
