package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-17
 * @문제출처 : 백준 온라인 저지 2750 번
 */
class Problem13: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem13")
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val q: Queue<Int> = LinkedList()
        for(i in 1..n) {
            q.add(i)
        }

        while(q.size != 1) {
            println("remove: ${q.poll()}")
            println("addLast: ${q.add(q.poll())}")
        }

        println("result : ${q.poll()}")
        sc.close()
    }
}