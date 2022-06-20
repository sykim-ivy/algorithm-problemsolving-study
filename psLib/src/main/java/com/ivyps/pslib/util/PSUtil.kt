package com.ivyps.pslib.util

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.lang.Integer.min
import java.util.*
import kotlin.math.pow

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
         * !!주의 : (parsing하지말고) -'0' 해주는 것이 간편함
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

    /*******************************************************
     * 코틀린 math 관련 함수들
     *******************************************************/
    fun mathInKotlin() {
        // 최대 최솟값!!
        max(1,3)
        min(1,-3)

        // ※ 코틀린 제곱함수 : (Doblue형 숫자).pow(Doblue형 제곱숫자)
        val cnt = 3
        var jarisu: Int = 10.0.pow(cnt.toDouble()).toInt() // 1000


        // ※ n번째 자릿수 숫자 구하는 공식 = "검색할숫자/(10의 n-1제곱)%10" !!!
        var num = 5613
        var n = 3
        var tenN = 10.0.pow(n-1)
        var digitAt3 = num/tenN%10

    }

    /*******************************************************
     * 코틀린 배열 생성 관련
     *******************************************************/
    fun createArray() {
        // 코틀린 배열 선언으로 생성자를 통해 디폴트값으로 채우기 가능
        Array<Int>(3) { i -> i+1 } // [1,2,3] 배열 객체 생성
        IntArray(3, {0}) // [0, 0, 0] 배열 객체 생성

        // cf) 코틀린 배열생성 메소드는 문제풀이용 X (처음부터 값을 넣어줘야하거나 null체크가 항상 필요해짐)
//        arrayOf(1,2,3) // [1,2,3] 배열 객체 생성
//        emptyArray<Int>() // 빈 배열 객체 생성
//        arrayOfNulls<Int>(3) // [null, null, null] 배열 객체 생성

        //  !! 코틀린 2차원 배열 선언법
        Array(3/*행의 크기*/) {
            IntArray(4/*열의 크기*/) { -1/*초기화 값*/ }
        }

        // !! 자바 정수형 배열은 초기값 0으로 채워져있음
    }

    /*******************************************************
     * 순열/조합 공식 !!
     * 1. 조합(중복X,나열X)
        nCr = n!/r!(n-r)!
     * 2. 순열(중복X, 나열O)
        nPr = n!/(n-r)!
     *******************************************************/

    /*******************************************************
     * 투포인트(Two point) 관련
     * - startIdx와 endIdx 같은 값으로 함이 포함되는지 제외되는지 주의!!
     *******************************************************/

    /*******************************************************
     * 정렬 관련
     *******************************************************/
    fun Sort() {
        val A = intArrayOf(1,4,7,9,8,3)
        A.sort() // 코틀린or자바 정렬함수 사용시 O(nlogn)들어감
    }


    /*******************************************************
    [Deque(LinkedList)를 통한 범위 내 정렬 (슬라이딩 윈도우 시)]!!
     * - 값을 입력받는 즉시 Deque 연산 가능
     * 1. 추가값 기준으로 Deque 정렬 (마지막값부터 비정렬대상 다 제거)
        ㄴ> 리스트꼴의 경우 마지막 제거 시 while문으로 간편하게 가능
     * 2. 마지막에 추가값 추가
     * 3. 범위 초과 check (초과 시 첫번째값 제거)
     * 4. 최소값 출력
     *******************************************************/
}