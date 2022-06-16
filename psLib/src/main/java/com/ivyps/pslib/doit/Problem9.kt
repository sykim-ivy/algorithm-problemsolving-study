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
        val checkArr = IntArray(checkCharLen)
        for(i in 0 until checkCharLen) {
            checkArr[i] = st.nextToken().toInt()
        }

        println("c1['A'=${checkArr[0]}, 'C'=${checkArr[1]}, 'G'=${checkArr[2]}, 'T'=${checkArr[3]}]")

        var result = 0
        var s = 0
        var e = s + P
        val myArr = IntArray(checkCharLen)
        makeCArray(A.substring(s, e), myArr)

        if(compareCArray(checkArr,myArr)) {
            println("pw($s, ${e-1}) = ${A.substring(s, e)}")
            result++
        }

        while(e < S) {
            removeChar(A[s], myArr)
            s++
            e = s + P
            addChar(A[e-1], myArr)

            if(compareCArray(checkArr,myArr)) {
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
            }
            'C' -> {
                c2[1]++
            }
            'G' -> {
                c2[2]++
            }
            'T' -> {
                c2[3]++
            }
        }
    }

    private fun removeChar(c: Char, c2: IntArray) {
        when (c) {
            'A' -> {
                c2[0]--
            }
            'C' -> {
                c2[1]--
            }
            'G' -> {
                c2[2]--
            }
            'T' -> {
                c2[3]--
            }
        }
    }

    private fun compareCArray(c1: IntArray, c2: IntArray): Boolean {
        for(i in c1.indices) {
            if(c1[i] != c2[i]) return false
        }
        return true
    }

    private fun makeCArray(sStr: String, c2: IntArray) {
        for(item in sStr) {
            addChar(item, c2)
        }
    }
}