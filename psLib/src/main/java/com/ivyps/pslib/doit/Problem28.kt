package com.ivyps.pslib.doit

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author sykim-ivy
 * @since 2022-06-22
 * @문제출처 : 백준 온라인 저지 1167 번 (p.174)
 * - 입력
5
1 3 2 -1
2 4 4 -1
3 1 2 4 3 -1
4 2 4 3 3 5 6 -1
5 4 6 -1
 * - 출력
BFS(2)
weightArr1[1] = 9
weightArr1[2] = 0
weightArr1[3] = 7
weightArr1[4] = 4
weightArr1[5] = 10
BFS(5)
weightArr1[1] = 11
weightArr1[2] = 10
weightArr1[3] = 9
weightArr1[4] = 6
weightArr1[5] = 0
result : 11

 */
class Problem28: Problem() {
    lateinit var a: Array<ArrayList<TreeNode>>
    lateinit var visited: BooleanArray
    lateinit var weightArr: IntArray // N번 노드까지의 경로값

    override fun problemSolving() {
        println("Hello PS / Problem28")
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())
        val V = st.nextToken().toInt() // 노드수

        a = Array(V+1) { ArrayList() }
        for(i in 1..V) {
            st = StringTokenizer(br.readLine())
            val n = st.nextToken().toInt()

            var next = st.nextToken().toInt()
            while (next != -1) {
                val dNode = next
                val weight = st.nextToken().toInt()
                a[n].add(TreeNode(dNode, weight))
                next = st.nextToken().toInt()
            }
        }

        /**
         * ※ 핵심 : 임의의 노드 n의 거리배열 중 최대값을 가진 노드 k는 트리의 지름 노드 둘 중 하나이다!!
         *  ->  ⓐ 그러므로 임의의 노드에서 거리배열 구하고,
         *      ⓑ 그 중 최대경로값을 가진 노드 k로 다시 거리배열을 구하면,
         *      ⓒ 그 중 최대경로값이 '트리의 지름'값이 된다.
         */
        weightArr = IntArray(V+1)
        visited = BooleanArray(V+1)
        BFS(2) // ⓐ 임의로 1번으로 시작


        // ⓑ 그 중 최대경로값을 가진 노드 k로 다시 거리배열을 구하면,
        val maxIdx = getIndexMaxWeight()
        weightArr = IntArray(V+1)
        visited = BooleanArray(V+1)
        BFS(maxIdx)

        // ⓒ 그 중 최대경로값이 '트리의 지름'값이 된다.
        println("result : ${weightArr[getIndexMaxWeight()]}")

        br.close()
    }

    private fun getIndexMaxWeight(): Int {
        var maxIdx = 0
        var maxDistance = 0
        for(i in 1 until weightArr.size) {
            println("weightArr1[$i] = ${weightArr[i]}")
            if(maxDistance < weightArr[i]) {
                maxDistance = weightArr[i]
                maxIdx = i
            }
        }
        return maxIdx
    }


    private fun BFS(nodeNo: Int) {
        println("BFS($nodeNo)")
        val q: Queue<Int> = LinkedList()//<< [Mistake] ※ 큐에는 항상 노드번호를 넣는다!!
        val firstItem = nodeNo
//        weightArr[firstItem.v] =  firstItem.w //<< [Mistake] ※ 이걸 여기서 할 필요가 없음
        q.add(firstItem)
        // ※ BFS 방문은 항상 queue에 add후 처리!!
        visited[nodeNo] = true

        while(!q.isEmpty()) {
            val itemNo = q.poll()
            for(subItem in a[itemNo]) {
                if(!visited[subItem.v]) {
                    weightArr[subItem.v] =  weightArr[itemNo] + subItem.w
                    q.add(subItem.v)
                    visited[itemNo] = true
                }
            }
        }
    }


    data class TreeNode(val v: Int, val w: Int) // 연결노드번호 v, 엣지가중치 w
}