package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-18
 * @문제출처 : 백준 온라인 저지 1377 번
 *
 * - 입력
5
10 1 5 2 3
 * - 출력
result = 3
 */
class Problem16: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem16")

        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val a = Array<Item>(n) { Item(0, it) }
        for(i in 0 until n) {
            a[i].data = sc.nextInt()
        }

        // ※ N갯수(50만개)가 너무 많으므로 버블정렬 O(n*n)이 아닌 Array.sort() 로 처리
        a.sort()

        // ※ "버블 정렬에서 swap이 일어나지 않았다" = "정렬 완료된 상태"

        /**
         * ※ 몇 회만에 정렬이 완료되었는지 묻는 문제!!
         * ※ 버블 정렬에서 안쪽 for문이 몇 번 수행됐는지 구하는 다른 아이디어
            -> ※ 버블소트는 왼->오 방향으로 진행되므로
                "왼쪽으로는 회차당 1칸밖에 이동할 수 없다."
                따라서 "정렬 전-후 인덱스를 통해 가장 왼쪽으로 많이 이동한 값"이
                "정렬완료까지 걸린 회차 수" 이다.
         */
        var lMoveMax = 0
        for(i in a.indices) {
            val lMove = a[i].index - i
            if(lMove > lMoveMax) lMoveMax = lMove // 전인덱스 - 후인덱스
        }

        println("result = ${lMoveMax+1}") // 정렬 완료된 회차를 구하므로 +1해야함(∵lMoveMax 다음회차일 때가 정렬완료상태이므로)
        sc.close()
    }

    /**
     * ※  Comparable<클래스명> 과 같이 상속받아 인덱스 전후 비교 가능!!
     */
    class Item(var data: Int, val index: Int): Comparable<Item>{
        override fun compareTo(other: Item): Int {
            return (this.data - other.data)
        }
    }
}