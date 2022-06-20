package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-20
 * @문제출처 : 백준 온라인 저지 11004 번 (p.121)
 *
 * - 입력
5 2
4 1 2 3 5
 * - 출력
 2
 */
class Problem19_AllQuickSort: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem19")

        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val k = sc.nextInt()
        val a = IntArray(n)
        for(i in 0 until n) {
            a[i] = sc.nextInt()
        }

        quickSort(a, 0, n-1)

//        println()
//        print("END: ")
//        printArr(a)
        println("result a[${k-1}] = ${a[k-1]}")
        sc.close()
    }

    private fun quickSort(a: IntArray, initStartIdx: Int, initEndIdx: Int) {
        val n = (initEndIdx+1) - initStartIdx
        var pi: Int = n/2 + initStartIdx
//        println("START: ($initStartIdx ~ $initEndIdx) n=$n, pi=$pi")

        // Qsort 예외처리
        if(n < 2) return
        else if(n==2) {
            if(a[initStartIdx] > a[initEndIdx]){
                swapArr(a, a[initStartIdx], a[initEndIdx])
            }
            return
        }

        var startIdx = initStartIdx
        var endIdx = initEndIdx
        // swap >>  pivot, first
        swapArr(a, startIdx, pi)
        pi = startIdx
        startIdx++

        // move >> startIdx, endIdx
        while(a[startIdx] < a[pi]) {
            startIdx++
        }
        while(a[endIdx] > a[pi] && endIdx!=startIdx) {
            endIdx--
        }
//        println("> Moved : (pi: $pi, startIdx: $startIdx, endIdx=$endIdx)")

        // swap >> startIdx, endIdx
        if(startIdx != endIdx) {
            swapArr(a, startIdx, endIdx)
            startIdx++
            endIdx--
        }
        // recurse qSort()
        if(startIdx == endIdx) {
            val completedIdx = if(a[startIdx] > a[pi]) {
                startIdx-1
            }
            else {
                startIdx+1
            }
            if(completedIdx != pi) insertExArr(a, completedIdx, pi)
            quickSort(a, initStartIdx, completedIdx-1)
            quickSort(a, completedIdx+1, initEndIdx)
        }
    }

    // ※ 기존 다른위치값을 배열에 삽입하는 함수
    private fun insertExArr(a: IntArray, nIdx: Int, bIdx: Int) {
//        println("> Insert Pivot : a[$bIdx]=${a[bIdx]} at a[$nIdx]")
//        print(">> Insert Before : ")
//        printArr(a, min(bIdx, nIdx), max(bIdx+1, nIdx+1))
        val data = a[bIdx]
        for (i in bIdx until nIdx) {
            a[i] = if(bIdx < nIdx) a[i+1] else a[i-1]
        }
        a[nIdx] = data
//        print(">> Insert After : ")
//        printArr(a, min(bIdx, nIdx), max(bIdx+1, nIdx+1))
    }

    private fun printArr(a: IntArray, bIdx: Int=0, nIdx: Int=a.size-1) {
        for (i in bIdx until nIdx) print("a[$i]=${a[i]} ")
        println()
    }

    private fun swapArr(a: IntArray, idx1: Int, idx2: Int) {
        val tmp = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = tmp
    }

}