package com.ivyps.pslib.doit

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-21
 * @문제출처 : 백준 온라인 저지 2178 번 (p.169)
 * ※※※※※※ 헤매고 또 헤매다 문제 못풀고 손만 댐ㅠㅠ ※※※※※
 * - 입력1
4 6
101111
101010
101011
111011
 * - 출력1
15
 **********************************
 *  * - 입력2
4 6
110110
110110
111111
111101
 * - 출력2
9
 **********************************
 *  * - 입력3
2 25
1011101110111011101110111
1110111011101110111011101
 * - 출력3
38
 **********************************
 *  * - 입력4
7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
 * - 출력4
13
 **********************************
 */
class Problem27: Problem() {
    // ※ 상하좌우 모두 이동 가능!!
    // 상우하좌 탐색을 위한 배열 선언
    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(1, 0, -1, 0)

    lateinit var a: Array<IntArray> // 건너뛰기 힘들어서 인접행렬로 풀고자 함
    lateinit var visited: Array<BooleanArray>
    var result = 0
    var n = 0
    var m = 0

    override fun problemSolving() {
        println("Hello PS / Problem27")
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())
        n = st.nextToken().toInt() // 행
        m = st.nextToken().toInt() // 열

        a = Array(n) { IntArray(m) }
        visited = Array(n) { BooleanArray(m) }
        for(i in 0 until n) {
            val str = br.readLine()
            for(j in str.indices) {
                // 단방향 그래프
                if(str[j] == '1') {
                    a[i][j] = 1
                }
            }
        }

        BFS(0, 0)
        println("result : ${a[n-1][m-1]}")
        br.close()
    }


    private fun BFS(r: Int, c: Int) {
        val q: Queue<Array<Int>> = LinkedList() // ※ 큐에 배열 저장!!
        q.offer(arrayOf(r, c)) // ※ offer()는 추가성공여부 리턴 cf) add()는 예외발생
        visited[r][c] = true

        while(!q.isEmpty()) {
            val now = q.poll()
            for(k in 0 until 4) {
                val x = now[0] + dx[k]
                val y = now[1] + dy[k]
                if(x >= 0 && x < n && y>=0  && y < m) {
                    if(a[x][y] == 1 && !visited[x][y]) {
                        visited[x][y] = true
                        a[x][y] = a[now[0]][now[1]] + 1
                        q.add(arrayOf(x, y))
                    }
                }
            }
        }
    }

}