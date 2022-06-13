package com.ivyps.pslib.doit

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-12
 * @문제출처 : 백준 온라인 저지 11659 번
 */
class Problem3: Problem() {
    override fun problemSolving() {
        val test = DoubleArray(3)
        for(i in test) {
            println("test $i")
        }
        println("Hello PS / Problem3")
        // 합배열 s[i] = s[i-1] + a[i]
        // 배열 i~j 구간 합 = s[j] - s[i-1]

        val br = BufferedReader(InputStreamReader(System.`in`))

        var st = StringTokenizer(br.readLine()) // ※
        val sizeA = st.nextToken().toInt()
        val qCnt = st.nextToken().toInt()

        st = StringTokenizer(br.readLine()) // ※
//        val A = IntArray(sizeA+1) // ※ 배열 저장할 필요가 없음
        val S = LongArray(sizeA+1) // ※ Int 아닌 Long형이어야함 (10만개씩 10만개합 가능) ※ 0으로 채워져 있음!
       for(i in 1..sizeA) {
           val item = st.nextToken()
            S[i] = S[i-1] + item.toInt()
        }

        for(i in 1..qCnt) {
            st = StringTokenizer(br.readLine())
            val n1 = st.nextToken().toInt()
            val n2 = st.nextToken().toInt()
            println("[Problem3] result$i = ${S[n2]-S[n1-1]}")
        }

    }
}