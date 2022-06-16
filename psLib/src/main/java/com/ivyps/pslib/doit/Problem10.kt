package com.ivyps.pslib.doit

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author sykim-ivy
 * @since 2022-06-16
 * @문제출처 : 백준 온라인 저지 11003 번
 *
 * - 입력값
12 3
1 5 2 3 6 2 3 7 3 5 2 6
 * - 출력값
1 1 1 2 2 2 2 2 3 3 2 2
 */
class Problem10: Problem() {
    /**
     * ※※ [Deque(LinkedList)를 통한 범위 내 정렬 (슬라이딩 윈도우 시)]
     * 1. 추가값 기준으로 Deque정렬 (비정렬대상 다 제거)
     * 2. 마지막에 추가값 추가
     * 3. 범위 초과 check (초과 시 첫번째값 제거)
     * 4. 최소값 출력
     */
    override fun problemSolving() {
        println("Hello PS / Problem10")

        val bw = BufferedWriter(OutputStreamWriter(System.`out`))

        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())

        val N = st.nextToken().toInt()
        val L = st.nextToken().toInt()

        // ※ 값을 입력받는 즉시 Deque 연산 가능
        st = StringTokenizer(br.readLine())
        val deque = LinkedList<Node>()
        for(idx in 1..N) {
            val newNode = Node(idx, st.nextToken().toInt())

            // 1. 추가값 기준으로 정렬 (비정렬대상 다 제거)
            // ※ 리스트꼴의 경우 마지막 제거 시 while문으로 간편하게 가능
            while(deque.isNotEmpty() && deque.last.v > newNode.v) {
                deque.removeLast()
            }

            // 2. 마지막 위치에 값 추가
            deque.addLast(newNode)

            // 3. 범위 초과 check (초과 시 첫번째값 제거)
            if((newNode.i - deque.first.i) > L-1) {
                deque.removeFirst()
            }

            // 4. 최소값 출력
            bw.write("${deque.first.v} ")
        }

        bw.flush()
        bw.close()
        br.close()
    }

    data class Node(val i: Int, var v: Int)
}