package study.dfsBfs;

import org.junit.Test;

public class NetWork {

    public void netWork(boolean[] checked, int[][] computers, int i, int len) {
        for (int j = 0; j < len; j++) {
            if (i != j && computers[i][j] == 1 && !checked[j]) {
                checked[j] = true;
                this.netWork(checked, computers, j, len);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        if (n == 1) {
            return 1;
        }

        int answer = 0;
        boolean[] checked = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!checked[i]) {
                this.netWork(checked, computers, i, n);
                answer++;
            }
        }
        return answer;
    }

    @Test
    public void test1() {
        int n = 3;
        int[][] computers = {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        };
        int answer = this.solution(n, computers);
        System.out.println(answer); // 2
    }

    @Test
    public void test2() {
        int n = 3;
        int[][] computers = {
                { 1, 1, 0 },
                { 1, 1, 1 },
                { 0, 1, 1 }
        };
        int answer = this.solution(n, computers);
        System.out.println(answer); // 1
    }

    @Test
    public void test3() {
        int n = 7;
        int[][] computers = {
                { 1, 0, 0, 0, 0, 0, 1 },
                { 0, 1, 1, 0, 1, 0, 0 },
                { 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 1, 1 }
        };

        int answer = this.solution(n, computers);
        System.out.println(answer); // 1
    }

    @Test
    public void test4() {
        int n = 5;
        int[][] computers = {
                { 1, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 0, 0, 1, 0, 1 },
                { 0, 0, 0, 1, 1 },
                { 1, 0, 0, 0, 1 }
        };

        int answer = this.solution(n, computers);
        System.out.println(answer); // 1
    }

    @Test
    public void test5() {
        int n = 2;
        int[][] computers = {
                { 1, 1 },
                { 1, 1 }
        };

        int answer = this.solution(n, computers);
        System.out.println(answer); // 1
    }
}