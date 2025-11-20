import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        // map을 2개 선언해서, point가 한 칸 움직일 때마다, 각각 더하고 빼고
        Map<Integer, Integer> leftMap = new HashMap();
        Map<Integer, Integer> rightMap = new HashMap();

        for(int i = 0 ; i < topping.length ; i++) {
            rightMap.put(topping[i], rightMap.getOrDefault(topping[i], 0)+1);
        }

        // point를 하나 정해서 n만큼 이동
        for(int point = 0 ; point < topping.length ; point++) {
            // 2개의 map 개수 비교
            if(leftMap.size() == rightMap.size()) answer++;

            rightMap.put(topping[point], rightMap.get(topping[point])-1);
            if(rightMap.get(topping[point]) == 0) rightMap.remove(topping[point]);

            leftMap.put(topping[point], leftMap.getOrDefault(topping[point], 0)+1);
        }
        return answer;
    }
}