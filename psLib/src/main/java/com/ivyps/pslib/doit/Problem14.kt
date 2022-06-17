package com.ivyps.pslib.doit

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

/**
 * @author sykim-ivy
 * @since 2022-06-17
 * @문제출처 : 백준 온라인 저지 11286 번
 *
입력
18
1 -1 0 0 0 1 1 -1 -1 2 -2 0 0 0 0 0 0 0
출력
-1
1
0
-1
-1
1
1
-2
2
0
 */
class Problem14: Problem() {
    override fun problemSolving() {
        println("Hello PS / Problem14")
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val pq = PriorityQueue<Int>(kotlin.Comparator { t1, t2 ->
            val t1ABS = abs(t1)
            val t2ABS = abs(t2)
            if(t1ABS == t2ABS) if(t1 > t2) 1 else -1
            else t1ABS - t2ABS
        })

        var st = StringTokenizer(br.readLine())
        for(i in 0 until n) {
            val request = st.nextToken().toInt()
            if(request == 0) {
                if(pq.isEmpty()) println("0")
                else println(pq.poll())
            }
            else {
                pq.add(request)
            }
        }
        br.close()
    }
}