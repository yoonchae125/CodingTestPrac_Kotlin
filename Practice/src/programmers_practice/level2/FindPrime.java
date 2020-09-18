package programmers_practice.level2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class FindPrime {
    public int solution(String numbers) {
        System.out.println(isPrime(2));
        int answer = 0;
        int nums[] = new int[numbers.length()];
        for(int i=0;i<numbers.length();i++){
            nums[i] = numbers.charAt(i)-'0';
        }

        search(nums,0,new ArrayList<>());
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);

        }
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            if(isPrime(it.next())){
                answer++;
            }
        }
        for(int idx=0;idx<lists.size();idx++){
            int nums2[] = new int[lists.get(idx).size()];
            for(int i=0;i<nums2.length;i++){
                nums2[i] = lists.get(idx).get(i);
            }
            String s = "";
            for(int i=0;i<nums2.length;i++){
                s+=nums2[i]+"";
            }
            if(isPrime(Integer.parseInt(s))) {
                if(nums2[0]!=0) {
                    System.out.println(s);
                    answer++;
                }
            }
            while(next_permutation(nums2)){
                if(nums2[0]==0) continue;
                s = "";
                for(int i=0;i<nums2.length;i++){
                    s+=nums2[i]+"";
                }
                if(isPrime(Integer.parseInt(s))) {
                    System.out.println(s);
                    answer++;
                }
            }
        }

        return answer;
    }
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    void search(int[] nums, int idx, ArrayList<Integer> list){
        if(idx == nums.length){
            if(list.size()>1){
                lists.add(list);
            }
            return;
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            list1.add(list.get(i));
            list2.add(list.get(i));
        }
        list1.add(nums[idx]);
        search(nums,idx+1,list1);
        search(nums,idx+1,list2);
    }
    public static boolean next_permutation(int[] a) { // 순열
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[j] <a[i - 1]) {
            j -= 1;
        }

        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
    boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i=2; i*i<=n; i++) {
            if (n % i == 0) { return false;
            } }
        return true;
    }
}
