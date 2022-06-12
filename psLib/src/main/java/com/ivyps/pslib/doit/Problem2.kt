package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-12
 * @문제출처 : 백준 온라인 저지 1546 번
 */
class Problem2: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem2")

        val sc = Scanner(System.`in`)
        val N = sc.nextInt()
        val scores = DoubleArray(N)
        var M = 0.0
        var sum = 0.0

        for(i in 0 until N) {
            scores[i] = sc.next().toDouble()
            sum += scores[i]
            M = if(scores[i] > M) scores[i] else M
        }

        // ※ 주의 : 식 항상 합쳐보기!! >> (i1/M*100) + (i2/M*100) = (i1+i2)*100/M
        println("[Problem2] result = ${(sum*100/M)/N.toDouble()}")

        // 식 합치면 아래 for문 돌 필요가 없음
//        for(i in scores) {
//            sum += (i/M*100)
//        }
//        println("[Problem2] result = ${(sum/N.toDouble())}")

    }
}