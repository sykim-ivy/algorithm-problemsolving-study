package com.ivyps.pslib.util

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.lang.Integer.min
import java.util.*
import kotlin.Comparator
import kotlin.math.abs
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

    /*******************************************************
    [Queue(LinkedList)
     - 추가 함수 (enqueue)
        offer() : 추가성공여부 리턴
        add() : 예외발생
     - 제거 함수 (dequeue)
        poll() : 제거값 리턴
        remove() : 예외발생
     - 검사(peek)
        peek() : 최상단 front값 리턴
        element() : 예외발생
     *******************************************************/
    fun queueTask() {
        val q: Queue<Int> = LinkedList()
        q.offer(3) // ※ offer()는 추가성공여부 리턴 cf) add()는 예외발생
    }

    /*******************************************************
     * 자바,코틀린 제공 정렬 함수
     *******************************************************/
    fun javaSort() {
        val arr = arrayOf(1, 29, 3, 4, 402)
        /**
         * 1. 오름차순 정렬
         */
        arr.sort() // 원본 정렬
        // 원본 유지
        arr.sortedArray() // 정렬 후 새 배열반환
        arr.sorted() // 정렬 후 리스트 반환
        // 클래스 정렬
        arr.sortBy { it }

        for(i in arr) println("오름차순 arr = $i")
        println()

        /**
         * 2. 내림차순 정렬
         */
        arr.sortedDescending() // 원본 정렬
        // 원본 유지
        arr.sortedArrayDescending() // 정렬 후 새 배열반환
        arr.sortDescending() // 정렬 후 리스트 반환
        // 클래스 정렬
        arr.sortByDescending { it }

        for(i in arr) println("내림차순 arr = $i")
        println()

        /**
         * 3. Comparator 정렬
         * - Comparator.compared(p1, p2) : Int
         *      ㄴ> 첫번째 파라미터인 'p1'가 더 크면 양수 리턴 (같으면 0)
         */
        arr.sortWith(Comparator { o1, o2 ->
//            o1 - o2 //  오름차순
//            o2 - o1 //  내림차순
            // 절대값으로 오름차순 (같으면 원본값 비교)
            val o1ABS = abs(o1)
            val o2ABS = abs(o2)
            if(o1ABS == o2ABS) if(o1 > o2) 1 else -1 // 같으면 원본값 비교
            else o1ABS - o2ABS
        })

        /**
         * 여러 기준으로 정렬
         * - sortWith()에 comparator 대신 "compareBy(), compareByDescending()" 넣어 정렬
         * - 정렬 기준이 되는 속성들의 순서를 지정 가능
         */
        var pArr = arrayOf(Pair("Park", 10), Pair("Kim", 12), Pair("Kim", 5), Pair("Lee", 19))

        // Pair 데이터 중 string 우선 정렬 후 -> int값 정렬
        pArr.sortWith(compareBy({it.first}, {it.second}))

        pArr.sortWith(compareByDescending { it.first })

    }

    // [s~e 사이의 중간값] = (s+e)/2 써도 동일함!!
    // 이진탐색은 e>=s일때까지 돌아야함 주의!!
}