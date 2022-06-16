package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-12
 * @문제출처 : 백준 온라인 저지 1874 번
 */
class Problem11: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem11")
        var isFail = false
        var result = StringBuffer()
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val s = Stack<Int>()
        var lastNo = 0
        for(i in 1..n) {
            val inputN = sc.nextInt()
            /**
             * 좋은 풀이법
             */
            if(inputN >= lastNo) {
                while(inputN >= lastNo) {
                    s.push(++lastNo)
                    result.append("+ ($lastNo)\n")
                }

                result.append("- (${s.pop()})\n")
            }
            else {
                val lastV = s.pop()
                if(lastV < inputN) { // 책오류로 보임
                    isFail = true
                    break
                }
                else result.append("- ($lastV)\n")
            }


            /**
             * 좋진 않은 내가 한 방법
             */
//            if(s.isEmpty() || inputN > s.peek()) {
//                // NO 케이스
//                if(lastNo >= inputN) {
//                    isFail = true
//                    break
//                }
//                // push() 케이스
//                while(lastNo < inputN) {
//                    s.push(++lastNo)
//                    result.append("+ ($lastNo)\n")
//                }
//            }
//
//            // pop() 케이스
//            while(s.isNotEmpty() && s.peek() >= inputN) {
//                result.append("- (${s.pop()})\n")
//            }
//            // (pop() 이후) NO 케이스
//            if(i != n && s.isEmpty()) {
//                isFail = true
//                break
//            }
        }
        println(if(isFail) "NO" else result)
        sc.close()
    }
}