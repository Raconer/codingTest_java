package study.dfsBfs;

import org.junit.Test;

/* 
 * 조건
 * 1. maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
 * 1. n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
 * 1. maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
 * 1. 처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
 * 
 */

public class GameMap {
    boolean[][] visited;
    int answer = -1;
    int n = 0, m = 0;

    public void gameMap(int distance, int i, int j, int[][] maps) {

        if (i + 1 == n && j + 1 == m) {
            answer = distance;
        }

        for (int r = 0; r < 4; r++) {
            int x = i, y = j;
            switch (r) {
                case 0:
                    y = j + 1;
                    break;
                case 1:
                    x = i + 1;
                    break;
                case 2:
                    x = i - 1;
                    break;
                case 3:
                    y = j - 1;
                    break;
            }

            if (0 <= x && x < n && 0 <= y && y < m && maps[x][y] == 1 && !visited[x][y]) {
                visited[x][y] = true;
                gameMap(distance + 1, x, y, maps);
            }
        }
    }

    public int solution(int[][] maps) {
        this.n = maps.length;
        this.m = maps[n - 1].length;

        if (n == 1 && m == 1) {
            return -1;
        }
        visited = new boolean[this.n][this.m];
        this.gameMap(1, 0, 0, maps);
        return answer;
    }

    @Test
    public void test1() {
        int[][] maps = {
                { 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 } };
        System.out.println("answer : " + this.solution(maps)); // 11
    }

    @Test
    public void test2() {
        int[][] maps = {
                { 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1 },
                { 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1 } };
        System.out.println("answer : " + this.solution(maps)); // -1
    }

    @Test
    public void test3() {
        int[][] maps = {
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1 } };
        System.out.println("answer : " + this.solution(maps)); // 9
    }

    @Test
    public void test4() {
        int[][] maps = {
                { 1, 0, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 1 } };
        System.out.println("answer : " + this.solution(maps)); // 16
    }

    @Test
    public void test5() {
        int[][] maps = {
                { 1 },
                { 1 },
                { 1 }, };
        int result = 9;
        int answer = this.solution(maps);
        System.out.println(answer);
    }

}
