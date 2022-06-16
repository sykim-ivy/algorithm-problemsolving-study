package com.ivyps.pslib.doit

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-12
 * @문제출처 : 백준 온라인 저지 12891 번
 *
 * 입력값
4 2
GATA
1 0 0 1
 */
class Problem9: Problem() {

    var checkSecret = 0
    lateinit var checkArr: IntArray

    override fun problemSolving() {
        println("Hello PS / Problem9")

        val checkCharLen = 4

        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())
        val S = st.nextToken().toInt()
        val P = st.nextToken().toInt()

        st = StringTokenizer(br.readLine())
        val A = st.nextToken()

        st = StringTokenizer(br.readLine())
        checkSecret = 0
        checkArr = IntArray(checkCharLen)
        for(i in 0 until checkCharLen) {
            checkArr[i] = st.nextToken().toInt()
            if(checkArr[i] == 0) checkSecret++
        }

        println("c1['A'=${checkArr[0]}, 'C'=${checkArr[1]}, 'G'=${checkArr[2]}, 'T'=${checkArr[3]}]")

        var result = 0
        var s = 0
        var e = s + P
        val myArr = IntArray(checkCharLen)
        makeCArray(A.substring(s, e), myArr)

        if(checkSecret == checkCharLen) {
//        if(compareCArray(checkArr,myArr)) {
            println("pw($s, ${e-1}) = ${A.substring(s, e)}")
            result++
        }

        while(e < S) {
            removeChar(A[s], myArr)
            s++
            e = s + P
            addChar(A[e-1], myArr)

            if(checkSecret == checkCharLen) {
//            if(compareCArray(checkArr,myArr)) {
                println("pw($s, ${e-1}) = ${A.substring(s, e)}")
                result++
            }
        }
        println("result = $result")
        br.close()
    }

    private fun addChar(c: Char, c2: IntArray) {
        when (c) {
            'A' -> {
                c2[0]++
                if(checkArr[0] == c2[0]) checkSecret++
            }
            'C' -> {
                c2[1]++
                if(checkArr[1] == c2[1]) checkSecret++
            }
            'G' -> {
                c2[2]++
                if(checkArr[2] == c2[2]) checkSecret++
            }
            'T' -> {
                c2[3]++
                if(checkArr[3] == c2[3]) checkSecret++
            }
        }
    }

    private fun removeChar(c: Char, c2: IntArray) {
        when (c) {
            'A' -> {
                if(checkArr[0] == c2[0]) checkSecret--
                c2[0]--
            }
            'C' -> {
                if(checkArr[1] == c2[1]) checkSecret--
                c2[1]--
            }
            'G' -> {
                if(checkArr[2] == c2[2]) checkSecret--
                c2[2]--
            }
            'T' -> {
                if(checkArr[3] == c2[3]) checkSecret--
                c2[3]--
            }
        }
    }

//    private fun compareCArray(c1: IntArray, c2: IntArray): Boolean {
//        for(i in c1.indices) {
//            if(c1[i] != c2[i]) return false
//        }
//        return true
//    }

    private fun makeCArray(sStr: String, c2: IntArray) {
        for(item in sStr) {
            addChar(item, c2)
        }
    }
}