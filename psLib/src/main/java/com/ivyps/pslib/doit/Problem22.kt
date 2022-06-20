package com.ivyps.pslib.doit

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

/**
 * @author sykim-ivy
 * @since 2022-06-20
 * @문제출처 : 백준 온라인 저지 10989 번 (p.139)
 * ※※※※※※ 문제 손도 못댐 ㅠㅠ ※※※※※
 * - 입력
11
215
15
344
372
294
100
8
145
24
198
831

 * - 출력
8
15
24
100
145
198
215
294
344
372
831
 */
class Problem22: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem22")

        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val a = IntArray(n)
        for(i in 0 until n) {
            a[i] = br.readLine().toInt()
        }

        radixSort(a, 5) // 최대 자릿수 5
        println("\nresult")
        for(i in a) println(i)

        br.close()

    }

    private fun radixSort(a: IntArray, d: Int) {
        val output = IntArray(a.size)
        var cnt: Int = 0
        while(cnt != d) {
            var jarisu: Int = 10.0.pow(cnt.toDouble()).toInt() // ※ 코틀린 제곱함수 : (Doblue형 숫자).pow(Doblue형 제곱숫자)
            val bucket = IntArray(10)
            // 자릿수별 갯수
            for(i in a.indices) {
                val digitAtN = (a[i]/jarisu)%10
                bucket[digitAtN]++
            }
            printArr(bucket, "b")
            // 배열합
            for(i in 1..9) {
                bucket[i] += bucket[i-1]
            }
            printArr(bucket, "s")
            //
            // ※ 선입선출로 인해 배열 끝에서부터 시작!!
            for(i in (a.size-1) downTo 0) {
                val digitAtN = (a[i]/jarisu)%10
                output[ --bucket[digitAtN] ] = a[i]
                println(">> a[$i]=${a[i]}, digitAtN=$digitAtN, " +
                        "output[ ${bucket[digitAtN]}-1 ]")
            }
            printArr(output, "o")
            // i번째 자리값으로 정렬된 데이터 덮어씀
            for(i in a.indices) {
                a[i] = output[i]
            }
            // 반복문 데이터 업데이트
            cnt++
        }
    }

    private fun printArr(bucket: IntArray, name: String) {
        for(i in bucket.indices) {
            print("$name[$i]\t")
        }
        println()
        for(i in bucket.indices) {
            print("${bucket[i]}\t")
        }
        println()
    }
}


