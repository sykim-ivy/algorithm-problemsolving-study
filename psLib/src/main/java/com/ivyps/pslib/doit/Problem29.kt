package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-23
 * @문제출처 : 백준 온라인 저지 1920 번 (p.182)
 * - 입력
5
4 1 5 2 3
5
1 3 7 9 5
 * - 출력
 1
 1
 0
 0
 1
 */
class Problem29: Problem() {
    lateinit var a: IntArray
    lateinit var s: IntArray

    override fun problemSolving() {
        println("Hello PS / Problem29")

        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        a = IntArray(n)
        for(i in 0 until n) {
            a[i] = sc.nextInt()
        }

        val m = sc.nextInt()
        s = IntArray(m)
        for(i in 0 until m) {
            s[i] = sc.nextInt()
        }

        a.sort()
        for(i in 0 until m) {
            binarySearch(a, s[i])
        }

    }

    private fun binarySearch(a: IntArray, s: Int) {
        var sIdx = 0
        var mIdx = 0
        var eIdx = a.size-1
        var isSearch = false

        while(eIdx >= sIdx) {// ※※ e>=s일때까지 돌아야 함 주의!!
            mIdx = sIdx + (eIdx-sIdx)/2 // s~e 사이의 중간값 = (s+e)/2 써도 동일함!!
            println("s=$s from a[$sIdx]=${a[sIdx]}, mid a[$mIdx]=${a[mIdx]}, end a[$eIdx]=${a[eIdx]}")
            if(a[mIdx] == s) {
                isSearch = true
                break
            }
            else if(a[mIdx] > s) {
                eIdx = mIdx - 1
            }
            else if(a[mIdx] < s) {
                sIdx = mIdx + 1
            }
        }

        if(isSearch) println("1 (sorted a[$mIdx] = $s)")
        else println("0")
    }
}