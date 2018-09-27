/*京东2019校招第二题
有n个产品,三条属性a,b,c,只要存在一个产品a,b,c都大于其a,b,c就说明是次品
思路是对a,b,c三个属性分别排序,只要有一个属性最大就不是次品,使用一个set记录这些编号,最后非次品数量就是n-set.size()
时间复杂度O(nlogn)
*/
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
public class JD2019_2{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
           int n=in.nextInt();
           int[][] a=new int[n][2];
           int[][] b=new int[n][2];
           int[][] c=new int[n][2];
           for(int i=0;i<n;i++) {
        	   a[i][0]=i;
        	   a[i][1]=in.nextInt();
        	   b[i][0]=i;
        	   b[i][1]=in.nextInt();
        	   c[i][0]=i;
        	   c[i][1]=in.nextInt();
           }
           Comparator<int[]> cmp=new Comparator<int[]>() {
        	   public int compare(int[] a1,int[] a2) {
        		   return a1[1]-a2[1];
        	   }
           };
           Arrays.sort(a,cmp);
           Arrays.sort(b,cmp);
           Arrays.sort(c,cmp);
           HashSet<Integer> set=new HashSet<>();
           for(int i=n-1;i>=0;i--) if(a[i][1]==a[n-1][1]) set.add(a[i][0]);
           for(int i=n-1;i>=0;i--) if(b[i][1]==b[n-1][1]) set.add(b[i][0]);
           for(int i=n-1;i>=0;i--) if(c[i][1]==c[n-1][1]) set.add(c[i][0]);
           System.out.println(n-set.size());
        }
        in.close();
    }
}
