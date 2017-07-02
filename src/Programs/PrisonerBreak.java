package Programs;

public class PrisonerBreak {

	public void jumpWall(int X, int Y, int arr[]){
		int count =0;
		for (int i = 0; i <arr.length;i++)
		{
			int wallHeight = arr[i];
			if (arr[i] <= X){
				++count;
			}else{
				//while (arr[i] > 0 ){
					//arr[i] = (arr[i] - X)+Y;
				if ((wallHeight%(X-Y)) ==0)
					count+= wallHeight/(X-Y);
				else
					count+= (wallHeight/(X-Y))+1;
				//}
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		PrisonerBreak break1 = new PrisonerBreak();
		int[] mydata = new int[] { 6, 9, 11, 4, 5 };
		break1.jumpWall(4, 1, mydata);

	}

}
