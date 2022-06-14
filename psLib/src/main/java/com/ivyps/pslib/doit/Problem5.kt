package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-14
 * @문제출처 : 백준 온라인 저지 10986 번
 */
class Problem5: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem5")
        val sc = Scanner(System.`in`)
        val N = sc.nextInt()
        val M = sc.nextInt()

        val modArr = IntArray(M)
        var bSum = 0
        var result = 0
        for(i in 1..N) {
            bSum += sc.nextInt()
            if(bSum%M == 0) result++
            modArr[bSum%M]++
            println("MA[${bSum%M}]=${modArr[bSum%M]}")
        }

        for(i in modArr) {
            if(i==0) break;
            result += (i-1)*i/2
            println("i=$i, result += ${(i-1)*i/2}")
        }

        println("result = $result")
    }
}