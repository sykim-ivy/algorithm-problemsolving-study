package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-20
 * @문제출처 : 백준 온라인 저지 2023 번 (p.153)
 *
 * ※※※※※※ 문제 손도 못댐 ㅠㅠ >> 근데 풀이글만 보고 풀었음!! 첨이다 ㅠㅠ♥
 * - 입력
4
 * - 출력
2333
2339
2393
2399
2939
3119
3137
3733
3739
3793
3797
5939
7193
7331
7333
7393
 */
class Problem24: Problem() {
    var n: Int = 0

    override fun problemSolving() {
        println("Hello PS / Problem24")
        val sc = Scanner(System.`in`)
        n = sc.nextInt()

        // 내가 한 방식
        // 1의 자리에서 가능한 소수가 4개 : 2,3,5,7
        val a: IntArray = intArrayOf(2, 3, 5, 7)
        // 2의 자리부터 ~ N자리까지 자릿수별 숫자를 DFS 순회하면서 소수인 수 추가
        for (firstNum in a) {
            DFS(firstNum, 1)
        }

//        // cf) 책은 바로 아래처럼 다 호출해버림 (더 나음)
//        DFS(2, 1)
//        DFS(3, 1)
//        DFS(5, 1)
//        DFS(7, 1)

    }

    private fun DFS(beforeNum: Int, jarisu: Int) {
        if(jarisu == n) {
            /**
             * 책에선 여기서 if(isPrime(num)) 체크 후 println하는데 왜지??
             *  소수체크 후 이 함수 호출하는데 왜지 ?? (출력은 동일함)
             */
            println("$beforeNum")
            return
        }

        // 다음 자리수 소수 탐색
        for(d in 1..9 step 2) {
            val checkNum = (beforeNum*10) + d
            if(isPrime(checkNum)) {
                DFS(checkNum, jarisu+1)
            }
        }
    }

    /**
     * 소수 검색
     */
    private fun isPrime(num: Int): Boolean {
        if(num < 3 || num%2==0) return false

        var isPrime = true
        for(i in 3 until num) {
            if(num%i == 0) {
                isPrime = false
                break
            }
        }
        return isPrime
    }
}