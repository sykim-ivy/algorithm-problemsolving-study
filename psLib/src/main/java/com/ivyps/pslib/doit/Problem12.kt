package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-17
 * @문제출처 : 백준 온라인 저지 17298 번
 *
 * - 입력1
4
9 5 4 8
 * - 출력1
-1 8 8 -1

 * - 입력2
4
3 5 2 7
 * - 출력2
5 7 7 -1
 */
class Problem12: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem12")

        val sc = Scanner(System.`in`)
        val N = sc.nextInt()
        val a = IntArray(N)
        val NGE = IntArray(N)
        val s = Stack<Int>()
        // s.push(0) // Q.책에서는 처음에 스택이 비어있으므로 최초값을 push해 초기화 한다는데 왜 필요한지 모르겠음

        for(i in 0 until N) {
            a[i] = sc.nextInt()
        }

        for(i in a.indices) {
            while(s.isNotEmpty() && a[s.peek()] < a[i]) {
                NGE[s.pop()] = a[i]
            }
            s.push(i)
        }

        while(s.isNotEmpty()) {
            NGE[s.pop()] = -1
        }

        for(i in NGE) print("$i ")
        sc.close()
    }
}