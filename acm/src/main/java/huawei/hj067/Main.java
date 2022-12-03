package huawei.hj067;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            String[] strs = s.split(" ");
            int[] numbers = new int[4];
            for(int i=0; i<4; ++i){
                numbers[i] = Integer.parseInt(strs[i]);
            }
            System.out.println(dfs(0, 0, numbers, new boolean[4]));
        }
    }

    public static boolean dfs(int count, int sum, int[] numbers, boolean[] visit){
        if(count > 3){
            return sum == 24;
        }
        for(int i = 0; i < 4; ++i){
            if(visit[i]) {
                continue;
            }
            int num = numbers[i];
            visit[i] = true;
            if(dfs(count + 1, sum + num, numbers, visit)){
                return true;
            }
            if(dfs(count + 1, sum - num, numbers, visit)){
                return true;
            }
            if(dfs(count + 1, sum * num, numbers, visit)){
                return true;
            }
            if(sum % num==0 && dfs(count + 1, sum / num, numbers, visit)){
                return true;
            }
            visit[i] = false;
        }
        return false;
    }
}