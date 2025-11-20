import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split("");
        String[] input2 = br.readLine().split("");

        Queue<String> subQ1 = new LinkedList();
        for(String s : input1) {
            subQ1.add(s);
        }

        Queue<String> subQ2 = new LinkedList();
        for(String s : input2) {
            subQ2.add(s);
        }

        // 수업설계를 큐에 넣고, 계속 빼는데
        // 필수과목안에 포함되어있다면, 필수과목의 맨 앞이 자기와 같은지
        boolean answer = true;
        while(!subQ2.isEmpty()) {
            String firstSub = subQ2.peek();
            if(subQ1.contains(firstSub)) {
                String firstNesSub = subQ1.peek();
                if(firstSub.equals(firstNesSub)) {
                    subQ1.poll();
                    subQ2.poll();
                } else {
                    answer = false;
                    break;
                }
            } else {
                subQ2.poll();
            }
        }
        if(!subQ1.isEmpty()) answer = false;
        if(answer) System.out.println("YES");
        else System.out.println("NO");
    }
}