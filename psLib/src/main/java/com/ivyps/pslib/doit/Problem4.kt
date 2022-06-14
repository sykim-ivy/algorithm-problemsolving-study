package com.ivyps.pslib.doit

import java.io.*
import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-13
 * @문제출처 : 백준 온라인 저지 11660 번
 * ※ '합배열' 구하는 공식 vs '구간합' 구하는 공식 다르므로 주의!!
     * 1. 합배열
     * S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + A[i][j]
     * 2. 구간합
     * 구간(i1,j1) ~ (i2,j2)의 합
     *      = S[i2][j2] - S[i1-1][j2] - S[i2][j1-1] + S[i1-1][j1-1]
 *
 */
class Problem4: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem4")
        val br = BufferedReader(InputStreamReader(System.`in`))

        // 초기 입력받기
        var st = StringTokenizer(br.readLine())
        val N = st.nextToken().toInt()
        val qCnt = st.nextToken().toInt()

        // 배열 입력받기
        val A = Array(N+1) { IntArray(N+1) { 0 } }
        for(i in 1..N) {
            st = StringTokenizer(br.readLine())
            for(j in 1..N) {
                A[i][j] = st.nextToken().toInt()
            }
        }
        println("배열 입력 완료")

        // 합배열 생성
        val S = Array(N+1) { IntArray(N+1) { 0 } }
        for(i in 1..N) {
            for(j in 1..N) {
                S[i][j] = S[i-1][j] +  S[i][j-1] -  S[i-1][j-1] + A[i][j]
//                print("S[$i][$j] = ${S[i][j]}, ")
            }
//            println()
        }

        // 질의 구간 입력받기
//        val bo = BufferedOutputStream(OutputStreamWriter(System.out))
        val result = StringBuffer()
        for(i in 1..qCnt) {
            st = StringTokenizer(br.readLine())
            var x1 = st.nextToken().toInt()
            var y1 = st.nextToken().toInt()
            var x2 = st.nextToken().toInt()
            var y2 = st.nextToken().toInt()

            val sum = S[x2][y2] - S[x1-1][y2]  - S[x2][y1-1] + S[x1-1][y1-1]
            result.append("result$i = $sum\n")
        }

        println("$result")


    }
}