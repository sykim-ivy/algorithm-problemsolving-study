package com.ivyps.pslib.util

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * 문제풀이에 공통적이거나 알아야하는 부분
 * @author sykim-ivy
 * @since 2022-06-12
 */
class PSUtil {

    /*******************************************************
     * 키보드 입력 관련
     * #1 'Scanner'
     * #2 'BufferedReader(InputStreamReader(System.`in`)) '
     *******************************************************/
    fun setIO() {
        // #1 'Scanner'
        val sc = Scanner(System.`in`)
        sc.nextInt()
        sc.hasNext() // 다음 token 존재여부
        sc.next() // token기준으로(없으면 공백기준) 값 입력받음
        sc.nextLine() // 개행문자까지 한 라인을 입력받음. ※ 앞의 개행문자 받을 수 있음 주의
        sc.useDelimiter(",") // 입력 구분자

        sc.close()

        // #2 'BufferedReader(InputStreamReader(System.`in`))'
        val br = BufferedReader(InputStreamReader(System.`in`))
        br.read() // 스트림으로부터 한 문자를 읽어서 int형으로 리턴 ('3' -> (int)'3' -> 51)
        br.readLine()

        br.close()
    }



    /*******************************************************
     * 형변환 관련
     *******************************************************/
    fun parseType() {
        /**
         * String -> char[]
         */
        val chArr = "4321".toCharArray()

        /**
         * Char -> 숫자형
         * - 주의 : (parsing하지말고) -'0' 해주는 것이 간편함!!
         */
        val firstNum = chArr[0] - '0'

        /**
         * String -> 숫자형 (short, int, long, float, double 등)
         */
        "101".toInt() // 코틀린방식
        Integer.parseInt("101") // 자바방식1
        Integer.valueOf("101") // 자바방식2
//        "101".toFloat()
//        java.lang.Float.parseFloat("101")
//        java.lang.Float.valueOf("101")

        /**
         * 숫자형 -> String
         */
        val i = 123.0f
        var str: String = ""+i // 이 방식 쓰자 (자바,코틀린 공통방식)
//        str = i.toString() // - Only 코틀린만 사용 가능
//        java.lang.String.valueOf(i) // 자바방식

    }

}