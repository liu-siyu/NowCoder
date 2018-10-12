public class PrintSnakeMatrix{
/*打印给定维度的矩阵
如 4
1	2	9	10	
4	3	8	11	
5	6	7	12	
16	15	14	13
*/
  public static void print(int n) {
		int[][] a=new int[n][n];
		int count=1;
		int i=0;
		int j=0;
		a[i][j]=count;
		j++;
		count++;
		for(int k=1;k<n;) {
			for(;i<=k;i++) {
				a[i][j]=count;
				count++;
			}
			i--;
			j--;
			for(;j>=0;j--) {
				a[i][j]=count;
				count++;
			}
			j++;
			i++;
			k++;
			if(k>=n) break;
			for(;j<=k;j++) {
				a[i][j]=count;
				count++;
			}
			j--;
			i--;
			for(;i>=0;i--) {
				a[i][j]=count;
				count++;
			}
			i++;
			j++;
			k++;
		}
		for(int c=0;c<n;c++) {
			for(int b=0;b<n;b++) {
				System.out.print(a[c][b]+"\t");
			}
			System.out.println();
		}
	}
}
