package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-12
 * @문제출처 : 백준 온라인 저지 11720 번
 */
class Problem1: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem1")
        problemSolvingUsingArray()
    }

    /**
     * 배열 사용 문제 풀이 (※:놓친 부분)
     */
    private fun problemSolvingUsingArray() {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()

        val numChArr = sc.next().toCharArray() // ※ 문자열 입력을 바로 Char배열로 바꾸는 게 더 빠름
        var sum = 0
        for(i in 0 until n) {
            sum += numChArr[i].toInt() - 48 // ※ 'Char -> 숫자형'으로 고치면 아스키코드값으로 되므로 주의
        }

        println("[Problem1] result(UsingArray) = $sum")
    }

    /**
     * 배열인데 배열 안 쓰고 내가 푼 방식
     */
    fun mineproblemSolving() {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val numStr = sc.next()
        var sum = 0

        for(i in 0 until n) {
            val no = numStr[i].toInt() - 48
            sum += no
        }

        println("[Problem1] result = $sum")
    }
}