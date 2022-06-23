package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-23
 * @문제출처 : 백준 온라인 저지 2343 번 (p.186)
 * ※ 문제 이해 못함;;
 * - 입력
9 3
1 2 3 4 5 6 7 8 9
 * - 출력
17
 */
class Problem30: Problem() {
    lateinit var a: IntArray

    override fun problemSolving() {
        println("Hello PS / Problem30")
        val sc = Scanner(System.`in`)
        val n = sc.nextInt() // 레슨 수
        val m = sc.nextInt() // 블루레이 개수
        // 레슨 시간
        a = IntArray(n)
        var s = 0 // 배열의 최대값 = 가장 많은 개수(=N개)의 그룹으로 만들 때 사이즈
        var e = 0 // 배열의 총합 => 가장 작은 개수(=1개)의 그룹으로 만들 때 사이즈
        for(i in 0 until n) {
            a[i] = sc.nextInt()
            if(s < a[i]) s = a[i]
            e += a[i]
        }

        /*******************************************************
         * ※ 이진탐색 핵심 :
         *  배열의 요소들을 '사이즈가 같은 공간' M개에 순서대로 나눠 넣을 때
             -  "검색 start 인덱스 = 배열의 최대값 " => 가장 많은 개수(=N개)의 그룹으로 만들 때 사이즈
             -  "검색 end 인덱스 = 배열의 총합"    => 가장 작은 개수(=1개)의 그룹으로 만들 때 사이즈
             -  "검색값 = (start+end)/2"로 계속 중간값 가지고 순회
         *  => 탐색 종료 후의 "검색 start 인덱스"값이 M개씩 넣을 때의 '공간 사이즈'의 최소값
         *******************************************************/
        while(e >= s) {
            val mid = (s+e)/2
            // mid 사이즈로 블루레이 생성 시 몇 개 생성되는지 판단
            var bCnt = 0 // 블루레이 개수
            var pSum = 0
            for(i in 0 until n) {
                if(pSum + a[i] > mid) {
                    bCnt++
                    pSum = 0
                }
                pSum += a[i]
            }
            println("(s=$s ~ e=$e) : mid=$mid 로 bCnt=$bCnt 개 블루레이 생성 가능!")

            //※ 탐색 후 sum이 0이 아니면 1개 더 필요함 (∵ bCnt가 0부터 시작)
            if(pSum != 0) bCnt++

            if(bCnt > m) {
                s = mid + 1
            }
            else {
                e = mid-1
            }
        }

        //※ 나눌 수 있는 최소값은 
        println("result : $s")
        sc.close()
    }
}