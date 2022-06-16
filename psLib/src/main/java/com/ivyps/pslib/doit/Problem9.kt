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

        val checkChar = 4
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())
        val sLen = st.nextToken().toInt()
        val pLen = st.nextToken().toInt()

        st = StringTokenizer(br.readLine())
        val sStr = st.nextToken()

        st = StringTokenizer(br.readLine())
        val c1 = IntArray(checkChar)
        for(i in 0 until checkChar) {
            c1[i] = st.nextToken().toInt()
        }

        println("c1['A'=${c1[0]}, 'C'=${c1[1]}, 'G'=${c1[2]}, 'T'=${c1[3]}]")

        var result = 0
        var s = 0
        var e = s + pLen
        val c2 = IntArray(checkChar)
        makeCArray(sStr.substring(s, e), c2)

        if(compareCArray(c1,c2)) {
            println("pw($s, ${e-1}) = ${sStr.substring(s, e)}")
            result++
        }

        while(e < sLen) {
            removeChar(sStr[s], c2)
            s++
            e = s + pLen
            addChar(sStr[e-1], c2)

            if(compareCArray(c1,c2)) {
                println("pw($s, ${e-1}) = ${sStr.substring(s, e)}")
                result++
            }
        }
        println("result = $result")
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