package com.ivyps.pslib.doit

import java.util.*

/**
 * @author sykim-ivy
 * @since 2022-06-20
 * @문제출처 : 백준 온라인 저지 11004 번 (p.121)
 *
 * - 입력
8 4
42 32 24 60 15 5 90 45
 * - 출력
32
 */
class Problem19: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem19")

        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val k = sc.nextInt()
        val a = IntArray(n)
        for(i in 0 until n) {
            a[i] = sc.nextInt()
        }

        quickSort(a, 0, n-1, k-1)

        printArr(a)
        println("result a[${k-1}] = ${a[k-1]}")
        sc.close()
    }

    private fun quickSort(a: IntArray, startIdx: Int, endIdx: Int, k: Int) {
        if(startIdx < endIdx) {
            val pivot = partition(a, startIdx, endIdx)
            if(pivot==k) {
                return
            }
            else if(pivot > k) {
                quickSort(a, startIdx, pivot-1, k)
            }
            else if(pivot < k) {
                quickSort(a, pivot+1, endIdx, k)
            }
        }
    }

    private fun partition(a: IntArray, startIdx: Int, endIdx: Int): Int {
        var pivot = (endIdx+startIdx)/2 // ※ 중앙값 구하는 식
            // (endIdx-startIdx)/2 + startIdx
        println("s=$startIdx, e=$endIdx, pivot=$pivot")
        swapArr(a, startIdx, pivot)
        pivot = startIdx

        var i = startIdx+1
        var j = endIdx
        while(i < j) { // ※
            while (a[j] > a[pivot]) {
                j--
            }
            while (i < j && a[i] < a[pivot]) {
                i++
            }
            if (i != j) {
                swapArr(a, i, j)
            }
        }

        // ※ pivot 들어갈 값과 pivot이 위치한 startIdx를 swap한다!!
        val tmp = a[startIdx] // == a[pivot]
        a[startIdx] = a[i]
        a[i] = tmp
        // ↑ 이러면 QuickSort 배열 삽입에 의해 값들을 밀 필요없음
//        val pIdx = if(a[i] > a[pivot]) i-1 else i+1
//        insertExArr(a, pivot, pIdx)

        return i
    }

    private fun insertExArr(a: IntArray, bIdx: Int, nIdx: Int) {
        val tmp = a[bIdx]
        for(i in bIdx until nIdx) {
            if(bIdx > nIdx) a[i] = a[i-1]
            else  a[i] = a[i+1]
        }
        a[nIdx] = tmp
    }

    private fun swapArr(a: IntArray, bIdx: Int, nIdx: Int) {
        val tmp = a[bIdx]
        a[bIdx] = a[nIdx]
        a[nIdx] = tmp
    }

    private fun printArr(a: IntArray, bIdx: Int=0, nIdx: Int=a.size) {
        for (i in bIdx until nIdx) print("a[$i]=${a[i]} ")
        println()
    }
}