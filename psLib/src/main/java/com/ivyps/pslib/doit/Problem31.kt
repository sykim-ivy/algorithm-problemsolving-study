package com.ivyps.pslib.doit

import java.lang.Integer.min
import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-23
 * @문제출처 : 백준 온라인 저지 1300 번 (p.190)
 * ※※※※※※ 문제 손도 못댐 ㅠㅠ ※※※※※
 * - 입력
3
7
 * - 출력
6
 */
class Problem31: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem31")
        val sc = Scanner(System.`in`)
        val n = sc.nextLong().toInt()
        val k = sc.nextLong().toInt()

        // a,b 배열 인덱스가 1부터 (문제에서 제시됨)
        val a: Array<IntArray> = Array(n+1) { IntArray(n+1) { it*it } }

        var s = 1
        var e = k
        var result = 0
        while(e >= s) {
            var m = (s+e)/2
            var cnt = 0

            // 한 행에서 m값 이하 값을 가진 데이터 개수
            for(i in 1..n) {
                cnt += min(m/i, n)
            }

            println("(s=$s ~ e=$e) : mid=$m, cnt=$cnt")

            // m값은 cntOverK번째 큰 값보다 크지 않다.
            if(cnt < k) {
                s = m+1
            }
            else {
                result = m // 현재 단계의 중앙값을 변수에 저장!!
                e = m-1
            }
        }

        println("result = $result")
        sc.close()
    }

}