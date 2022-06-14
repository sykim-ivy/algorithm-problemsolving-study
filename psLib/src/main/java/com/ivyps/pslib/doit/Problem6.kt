package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-14
 * @문제출처 : 백준 온라인 저지 2018 번
 */
class Problem6: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem6")
        val sc = Scanner(System.`in`)
        val N = sc.nextInt()

        var result = 1
        var sum = 1
        var startP = 1
        var endP = 1
        while(endP != N) {
            println("CASE ($startP, $endP)")
            if(sum < N) {
                endP++
                sum += endP
            } else if(sum > N) {
                sum -= startP
                startP++
            } else {
//                println("result CASE ($startP, $endP)")
                result++
                endP++
                sum += endP
            }
        }

        println("result = $result")
        sc.close()

    }
}