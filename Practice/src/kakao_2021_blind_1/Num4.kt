package kakao_2021_blind_1

import java.util.*

class Num4 {
    lateinit var cheapPath:Array<IntArray>
    lateinit var linkedPath:Array<IntArray>
    var num:Int =0
    lateinit var list:IntArray
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer: Int = 0

        cheapPath = Array(n+1){IntArray(n+1){ 100001 } }
        linkedPath = Array(n+1){IntArray(n+1) }
        checked = IntArray(n+1)
        num=n

        fares.forEach { fare->
            cheapPath[fare[0]][fare[1]] = fare[2]
            cheapPath[fare[1]][fare[0]] = fare[2]
            linkedPath[fare[0]][fare[1]] = 1
            linkedPath[fare[1]][fare[0]] = 1
        }
        for(i in 1..n){
            cheapPath[i][i] = 0
        }
        list = linkedPath(s)

        for(i in 1..n){
            if(!list.contains(i)) {
                continue
            }
            for(j in 1..n){
                if(!list.contains(j)) {
                    continue
                }
                search(i,j)
            }
        }
        var min = cheapPath[s][a] + cheapPath[s][b]
        for(i in 1..n){
            if(!list.contains(i)) {
                println(i)
                continue
            }
            if(i==s)
                continue
            min = minOf(min, cheapPath[s][i]+cheapPath[i][a]+cheapPath[i][b])
        }
        return min
    }
    lateinit var checked:IntArray
    fun linkedPath(s:Int):IntArray{
        var links = intArrayOf()

        val q:Queue<Int> = LinkedList<Int>()
        q.add(s)
        checked[s]=1
        while(!q.isEmpty()){
            val n = q.poll()
            links+=n
            for(i in 1..num){
                if(checked[i]==1)
                    continue
                if(linkedPath[n][i]==0)
                    continue
                q.add(i)
                checked[i]=1
            }
        }
        printList(links)
        return links
    }
    fun search( s:Int, a:Int){
        for(i in 1 until cheapPath.size){
            if(!list.contains(i)) {
                continue
            }
            cheapPath[s][a] = minOf(cheapPath[s][a], cheapPath[s][i]+cheapPath[i][a])
        }

        if(cheapPath[s][a]>=10001)
            cheapPath[s][a] = Int.MAX_VALUE
    }
}