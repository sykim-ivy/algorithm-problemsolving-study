package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-18
 * @문제출처 : 백준 온라인 저지 1427 번
 */
class Problem17: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem17")

        val sc = Scanner(System.`in`)
        val st = sc.nextLine()
        var originArr: IntArray = intArrayOf()
        for(i in st) {
            originArr = originArr.plus((i-'0'))
        }

        // #1) 선택정렬
        val a = originArr.clone()
        val n = a.size
        for(i in 0 until n) { // i는 정렬완료 후 삽입될 인덱스
            var max = i // 최소값들어갈 인덱스
            for(j in i until n) {
                if(a[max] < a[j]) {
                    max = j
                }
            }
            // swap
            if(max != i) {
                val tmp = a[i]
                a[i] = a[max]
                a[max] = tmp
            }
        }
        printArr("Selection Sort", a)

        // #2) 버블 정렬
        val b = originArr.clone()
        for(i in 0 until n) {
            for(j in 1 until n-i) {
                if(b[j] > b[j-1]) {
                    val tmp = b[j]
                    b[j] = b[j-1]
                    b[j-1] = tmp
                }
            }
        }
        printArr("Bubble Sort", b)


        sc.close()
    }

    private fun printArr(title:String, a: IntArray) {
        print("$title : ")
        for(i in a) print("$i")
        println()
    }
}
