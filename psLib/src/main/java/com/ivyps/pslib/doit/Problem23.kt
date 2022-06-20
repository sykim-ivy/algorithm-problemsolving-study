package com.ivyps.pslib.doit

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author sykim-ivy
 * @since 2022-06-20
 * @문제출처 : 백준 온라인 저지 11724 번 (p.148)
 * - 입력1
6 5
1 2
2 5
5 1
3 4
4 6
 * - 출력1
 2
 * * - 입력2
6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3
 * - 출력2
1
 */
class Problem23: Problem() {
    lateinit var l: Array<ArrayList<Int>>
    lateinit var vArr: BooleanArray
    var result = 0

    override fun problemSolving() {
        println("Hello PS / Problem23")

        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()

        l = Array(n+1) { ArrayList() } // u가 1부터의 범위를 가지므로
        for(i in 1..m) {
            st = StringTokenizer(br.readLine())
            val u = st.nextToken().toInt()
            val v = st.nextToken().toInt()

            // ※ 방향이 없으므로 양쪽으로 연결되야 한다!!
            l[u].add(v)
            l[v].add(u)
        }

        // 방문배열
        vArr = BooleanArray(n+1)
        vArr[0] = true

        // 탐색
        result = 0
        for(i in 1 until n) {
            if(!vArr[i]){
                println("DFS($i)")
                DFS(i)
                result++
            }
        }

        println("result : $result")
    }

    private fun DFS(v: Int) {
        vArr[v] = true // ※ (vArr[v]==false)인 v만 요청하므로 여기서 true가능!!
        for(j in l[v]) {
            if(!vArr[j]) {
//                println(">> vArr[$j] = true")
                DFS(j)
//                println(">> DFS($j)")
            }
        }
    }
}