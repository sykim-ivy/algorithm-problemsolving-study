package com.ivyps.pslib.doit

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author sykim-ivy
 * @since 2022-06-21
 * @문제출처 : 백준 온라인 저지 1206 번 (p.164)
 * - 입력1
4 5 1
1 2
1 3
1 4
2 4
3 4
 * - 출력1
DFS : 1 2 4 3
BFS : 1 2 3 4
 ********************************
 * - 입력2
5 5 3
5 4
5 2
1 2
3 4
3 1

 * - 출력3
DFS : 3 1 2 5 4
BFS : 3 1 4 2 5

 */
class Problem26: Problem() {
    lateinit var a: Array<ArrayList<Int>>
    lateinit var dVisited: BooleanArray
//    val q: Queue<Int> = LinkedList()
    lateinit var bVisited: BooleanArray

    override fun problemSolving() {
        println("Hello PS / Problem26")
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt() // 노드
        val m = st.nextToken().toInt() // 에지
        val startNode = st.nextToken().toInt() // 시작점

        // 인접리스트
        a = Array(n+1) { ArrayList() }
        for(i in 1..m) {
            st = StringTokenizer(br.readLine())
            val sNode = st.nextToken().toInt()
            val eNode = st.nextToken().toInt()
            // 방향이 없는 그래프 (=양방향 그래프)
            a[sNode].add(eNode)
            a[eNode].add(sNode)
        }

        // 적은 수부터 방문하기 위해 정렬시킴
        for(aList in a) {
            aList.sort()
        }

        // 탐색 시작
        dVisited = BooleanArray(n+1)

//        q.clear() // ※ Queue는 메소드변수여도 됨!! (전역변수일 필요없다.)
        bVisited = BooleanArray(n+1)
        // ※ DFS, BFS 모두 완전 탐색 기법이므로 for문 필요 없음!!
//        for(i in 1..n) {
//            if(!dVisited[i]) {
                print("DFS : ")
                DFS(startNode)
                println("")
//            }

//            if(!bVisited[i]) {
                print("BFS : ")
                BFS(startNode)
                println("")
//            }
//        }

        br.close()
    }

    /**
     * BFS 너비우선탐색
     */
    private fun BFS(v: Int) {
        // ※ Queue는 메소드변수여도 됨!! (전역변수일 필요없다.)
        val q: Queue<Int> = LinkedList()

        print("$v ")
        bVisited[v] = true
        for(j in a[v]) {
            if(!bVisited[j]) {
                q.add(j)
                bVisited[j] = true
            }
        }
        if(q.isNotEmpty()) BFS(q.poll())
    }

    /**
     * DFS 깊이우선탐색
     */
    private fun DFS(v: Int) {
        print("$v ")
        dVisited[v] = true // ※주의: DFS 여기서 방문배열 true하는 거 계속 까먹는다 ㅜㅜ
        for(i in a[v]) {
            if(!dVisited[i]) {
                DFS(i)
            }
        }
    }
}