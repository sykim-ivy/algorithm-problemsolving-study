package com.ivyps.pslib.doit

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author sykim-ivy
 * @since 2022-06-20
 * @문제출처 : 백준 온라인 저지 13023 번 (p.157)
 * - 입력1
8 8
1 7
3 7
4 7
3 4
4 6
3 5
0 4
2 7
 * - 출력1
1
 * - 경로1
>> [i=3][item=5] : nDepth=5
>> [i=7][item=3] : nDepth=5
>> [i=4][item=7] : nDepth=5
>> [i=0][item=4] : nDepth=5

 *************************************
 * - 입력2
5 5
0 1
1 2
2 3
3 0
1 4
 * - 출력2
1
 * - 경로2
>> [i=1][item=4] : nDepth=5
>> [i=2][item=1] : nDepth=5
>> [i=3][item=2] : nDepth=5
>> [i=0][item=3] : nDepth=5

 *************************************
 *  - 입력3
6 5
0 1
0 2
0 3
0 4
0 5
 * - 출력3
0

 *************************************

 * - 입력4
5 4
 0 1
 1 2
 2 3
 3 4

 * - 출력4
1
 * - 경로4
>> [i=3][item=4] : nDepth=5
>> [i=2][item=3] : nDepth=5
>> [i=1][item=2] : nDepth=5
>> [i=0][item=1] : nDepth=5
 */
class Problem25: Problem() {
    lateinit var adjacencyList: Array<ArrayList<Int>>
    lateinit var visited: BooleanArray
    var arrive = false

    override fun problemSolving() {
        println("Hello PS / Problem25")

        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())

        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        adjacencyList = Array(n) { ArrayList() }
        visited = BooleanArray(n)

        for(i in 1..m) {
            st = StringTokenizer(br.readLine())
            val sNode = st.nextToken().toInt()
            val dNode = st.nextToken().toInt()
            // ※ 방향없는 노드!!
            adjacencyList[sNode].add(dNode)
            adjacencyList[dNode].add(sNode)
        }


        for(i in 0 until n) {
            // 책이 푼 방법 호출
            DFS(i, 1)
            // ※ 재귀를 전역변수로 반복마다 체크해서 빠르게 탈출!!
            // ※ 이 방법이 for문에서 return하는 것보다 나음!!
            if(arrive) break

            // 내가 푼 방법 호출
//            val result = mineDFS(i, 1)
//            println("(i=$i, result=$result)")
//            if(result >= 5) {
//                println("mineresult: 1")
//                return
//            }
        }

        if(arrive) println("bookresult: 1") else println("bookresult: 0")

//        println("mineresult: 0")
        br.close()
    }

    /**
     * 책이 푼 방식
     * @return : ※ Depth를 리턴하지 않고 boolean arrive가 true이면 리턴!!
     */
    private fun DFS(i: Int, depth:Int) {
        // ※ 재귀자체를 visited[i]가 true일 때 미호출하면 여기서 호출할 필요 없음
//        if(visited[i]) retur n depth-1
        if(depth>=5 || arrive) {
            arrive = true
            return
        }

//        var nDepth = depth
        visited[i] = true // ※ for문 돌기전에 방문으로 바꿨어야 했다!!
        for(item in adjacencyList[i]) {
            // ※ 재귀자체를 visited[i]가 true일 때 미호출!!
            if(!visited[item]){
                DFS(item, depth+1)
            }
        }
        // ※ depth 5까지 진입하나(더이상 방문안함) 안하나(false로 변경필수) false로 항상 바꿔도 무관!!
        visited[i] = false
    }

    /**
     * 내가 푼 방식
     */
    private fun mineDFS(i: Int, depth:Int): Int {
        println("mineDFS(i=$i, depth=$depth)")
        if(visited[i]) return depth-1
        if(depth>=5) return depth

        var nDepth = depth
        for(item in adjacencyList[i]) {
            visited[i] = true
            nDepth = mineDFS(item, depth+1)
            println(">> [i=$i][item=$item] : nDepth=$nDepth")
            if(nDepth>=5) break
        }
        visited[i] = false
        return nDepth
    }
}