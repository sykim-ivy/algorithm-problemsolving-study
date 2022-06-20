package com.ivyps.pslib.doit

import java.util.*
import kotlin.collections.ArrayList

/**
 * @author sykim-ivy
 * @since 2022-06-18
 * @문제출처 : 백준 온라인 저지 11399 번
 *
 * -입력
5
3 1 4 3 2
 * -출력
 32
 */
class Problem18: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem18")
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val p = ArrayList<Int>()
        for(i in 0 until n) {
            p.add(sc.nextInt())
        }

        // #1) 삽입 정렬 : O(n*n)
        val ip = p.clone() as ArrayList<Int>
        for(i in 0 until n) {
            var insertIdx = i
            for(j in 0 until i) {
                // 삽입 정렬의 삽입 위치 탐색 알고리즘
                if(ip[j] > ip[i]) {
                    insertIdx = j
                    break
                }
            }
            // insert
            if(insertIdx != i) {
                ip.add(insertIdx, ip[i])
                ip.removeAt(i+1)
            }
        }
        println("Insertion Sort")
        printArrSum(ip)

        // #2) 버블 정렬 : O(n*n)
        val bp = p.clone() as ArrayList<Int>
        for(i in 0 until n) {
            for(j in 0 until n-i-1) {
                // swap
                if(bp[j] > bp[j+1]) {
                    val tmp = bp[j]
                    bp[j] = bp[j+1]
                    bp[j+1] = tmp
                }
            }
        }
        println("Bubble Sort")
        printArrSum(bp)

        // #3) 선택 정렬 : O(n*n)
        val sp = p.clone() as ArrayList<Int>
        for(i in 0 until n) {
            var maxIdx = 0
            for(j in 0 until n-i) {
                if(sp[maxIdx] < sp[j]) {
                    maxIdx = j
                }
            }
            // change
            if(maxIdx < (n-i)) {
                sp.add(n-i, sp[maxIdx])
                // ※ 특정 인덱스에 add하면 그 인덱스에 있던 값은 앞으로 감!!
                sp.removeAt(maxIdx)
            }
        }
        println("Selection Sort")
        printArrSum(sp)

        sc.close()
    }

    private fun printArrSum(p: ArrayList<Int>) {
        var sum = 0
        var beforeSum = 0
        for(i in p.indices) {
            beforeSum += p[i]
            sum += beforeSum
        }
        println("result : $sum")
    }
}