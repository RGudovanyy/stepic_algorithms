package stepic.algo.LIS;

public class Main {
    public static int LISBottomUp(int[] A){
        int n = A.length+1;
        int[] D = new int[n]; //заводим массив содержащий длину кратчайшей подпоследовательности,
                                //оканчивающейся в i-м элементе
        for(int i = 1; i < n; i++){
            D[i] = 1; // знаем как минимум одну подпоследовательность, которая оканчивается в i-м элементе
            for(int j = 0; j < i - 1; j++){
                //перебираем всех кадидатов на то, чтобы стать предыдущим элементом в оптимальной последовательности,
                // оканчивающейся в i-м элементе

                if(A[j] < A[i] && D[j] + 1 > D[i])
                    D[i] = D[j] + 1;
            }
            }
        int ans = 0;
        for(int i = 1; i < n; i++)
            ans = Math.max(ans, D[i]);
        return ans;
    }


    public static void main(String[] args) {
        int[] array = new int[]{7,2,1,3,8,4,9,1,2,6,5,9,3,8,1};
        System.out.println(LISBottomUp(array));
    }
}
