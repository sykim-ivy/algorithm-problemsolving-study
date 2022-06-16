package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-16
 * @문제출처 : 백준 온라인 저지 1253 번
 */
class Problem8: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem8")
        val sc = Scanner(System.`in`)
        val N = sc.nextInt()

        val arr = LongArray(N+1)
        for(i in 1..N){
            arr[i] = sc.nextLong()
            // ※ 입력값이 1,000,000,000까지 가능하므로 Long타입이어야 한다.
        }

        arr.sort() // 코틀린or자바 정렬함수 사용시 O(nlogn)들어감

        var result = 0
        /**
         * ※ 정수범위(음수포함)하여 모두 가능하므로
         *      k는 1부터 N까지(k포함범위)를 모두 체크해야 한다.
         *       ex) -1(=i), -2, .. 9(=k), 10(=j)
         *      반복문 내부에서 i==k, j==k일 때를 제외해주고 돌아야함
         */
        for (k in 1..N) {
            println("k=$k")
            var find = arr[k]
            var i = 1
            var j = N

            while (i < j) {
                val item = arr[i] + arr[j]
                if(find > item) {
                    i++
                }
                else if(find < item) {
                    j--
                }
                else {
                    if(i!=k && j!=k) {
                        print("\ti=$i + j=$j")
                        result++
                        break
                    }
                    else if(i==k) i++
                    else if(j==k) j--
                }

                // 여기서 체크해도 무관
//                if(i==k) i++
//                if(j==k) j--
            }
            println()
        }
        println("result = $result")
        sc.close()
    }
}