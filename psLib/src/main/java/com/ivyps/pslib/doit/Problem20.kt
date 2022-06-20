package com.ivyps.pslib.doit

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @author sykim-ivy
 * @since 2022-06-20
 * @문제출처 : 백준 온라인 저지 2751 번 (p.128)
 * - 입력
5
5
4
3
2
1
 * - 출력
result
1
2
3
4
5
 */
class Problem20: Problem() {
    lateinit var a: IntArray

    override fun problemSolving() {
        println("Hello PS / Problem20")
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        a = IntArray(n)
        for(i in 0 until n) {
            a[i] = br.readLine().toInt()
        }

        // 병합정렬
        mergeSort(0, n-1)
        println("result")
        for(i in a) println("$i")

        br.close()

    }

    private fun mergeSort(s: Int, e: Int) {
        if(e-s < 1) return

        // ※ 병합정렬 : 가장 작은 단위부터 시작하기 위해 재귀함수로 (s,m) (m,e)먼저 호출함!!
        val m = (s+e)/2
        mergeSort(s, m)
        mergeSort(m+1, e)

        val tmp = IntArray(e-s+1)
        var k = 0
        var i1 = s
        var i2 = m+1
        while(i1 <= m && i2 <=e) {
            if(a[i1] > a[i2]) {
                tmp[k] = a[i2]
                i2++
            }
            else {
                tmp[k] = a[i1]
                i1++
            }
            k++
        }

        while(i1 <= m) {
            tmp[k] = a[i1]
            i1++
            k++
        }

        while(i2 <=e) {
            tmp[k] = a[i2]
            i2++
            k++
        }

        for((tn, i) in (s..e).withIndex()) {
            a[i] = tmp[tn]
        }
    }
}