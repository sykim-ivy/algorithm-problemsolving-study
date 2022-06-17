package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-17
 * @문제출처 : 백준 온라인 저지 2750 번
 */
class Problem15: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem15")

        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val arr = IntArray(n)
        for(i in 0 until n) {
            arr[i] = sc.nextInt()
        }

        // ※ 버블 정렬이 O(n*n) 시간복잡도인 이유 ▽
        for(i in 0 until n) {
            for(j in 0 until n-i-1) {
                if(arr[j] > arr[j+1]) {
                    // swap
                    val tmp = arr[j]
                    arr[j] = arr[j+1]
                    arr[j+1] = tmp
                }
            }
        }

        println()
        print("result : ")
        for(i in arr) print("$i ")
        sc.close()
    }
}