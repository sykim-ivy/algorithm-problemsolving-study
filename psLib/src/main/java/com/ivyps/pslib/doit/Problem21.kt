package com.ivyps.pslib.doit

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

/**
 * @author sykim-ivy
 * @since 2022-06-20
 * @문제출처 : 백준 온라인 저지 1517 번 (p.133)
 * - 입력
8
3
2
8
1
7
4
5
6

 * - 출력
11
 */
class Problem21: Problem() {
    lateinit var a: IntArray
    override fun problemSolving() {
        println("Hello PS / Problem21")

        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        a = IntArray(n)
        for(i in 0 until n) {
            a[i] = br.readLine().toInt()
        }

        mergeSort(0, n-1)
        println("")
        println("result : ${swapCnt}")
        br.close()
    }

    var swapCnt = 0
    private fun mergeSort(s: Int, e: Int) {
        if(e <= s) return

        val m = (s+e)/2
        mergeSort(s, m)
        mergeSort(m+1, e)

        var i1 = s
        var i2 = m+1
        var ti = 0
        val tmp = IntArray(e-s+1)
        while(i1 <=m && i2 <=e) {
            if(a[i1] < a[i2]) {
                tmp[ti] = a[i1]
                i1++
            }
            else {
                tmp[ti] = a[i2]
//                println("s=$s, i1=$i1")
                swapCnt += m-i1+1 //== i2-(ti+s) ※ 현재 남아있는 i1 데이터 갯수만큼 저장(=i2-(ti+s)) : 왼쪽으로 이동
                i2++
            }
            ti++
        }

        while(i1 <=m) {
            tmp[ti] = a[i1]
            i1++
            ti++
        }
        while(i2 <=e) {
            tmp[ti] = a[i2]
            i2++
        }

        for((tn, i) in (s..e).withIndex()) {
//            println("a[$i] = tmp[$tn]")
            a[i] = tmp[tn]
        }
    }
}