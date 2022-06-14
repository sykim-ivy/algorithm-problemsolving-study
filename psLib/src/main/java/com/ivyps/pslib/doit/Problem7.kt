package com.ivyps.pslib.doit

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-14
 * @문제출처 : 백준 온라인 저지 1940 번
 */
class Problem7: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem7")
        val br = BufferedReader(InputStreamReader(System.`in`))
        val N = br.readLine().toInt()
        val M = br.readLine().toInt()

        val s = IntArray(N)
        var st = StringTokenizer(br.readLine())
        for(i in 0 until N) {
            s[i] = st.nextToken().toInt()
        }

        s.sort()

        var result = 0
        var startIdx = 0
        var endIdx = N-1
        while(startIdx != endIdx) {
            if(s[startIdx] + s[endIdx] > M) {
                endIdx--
            } else if(s[startIdx] +s[endIdx] < M) {
                startIdx++
            }
            else {
                println("s[$startIdx] = ${s[startIdx]}, s[$endIdx] = ${s[endIdx]}")
                endIdx--
                result++
            }
        }

        println("result = $result")

    }
}