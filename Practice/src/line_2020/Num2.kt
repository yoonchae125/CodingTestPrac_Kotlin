package line_2020

import java.util.*

class Num2 {
    fun solution(ball: IntArray, order: IntArray): IntArray {
        var answer: IntArray = intArrayOf()

        val balls:Deque<Int> = LinkedList()
        val orders:Queue<Int> = LinkedList()
        val priorityOrders:Queue<Int> = LinkedList()

        ball.forEach {
            balls.push(it)
        }
        order.forEach {
            orders.add(it)
        }
        val priorityOrdersTemp:Queue<Int> = LinkedList()
        while (!orders.isEmpty()||!priorityOrders.isEmpty()){
            var size = priorityOrders.size
            while(!priorityOrders.isEmpty()){
                val pOrder = priorityOrders.poll()
//                println(pOrder)
                if(balls.peekFirst() == pOrder){
                    answer+=pOrder
                    balls.pollFirst()
                }else if(balls.peekLast() == pOrder){
                    answer+=pOrder
                    balls.pollLast()
                }else{
                    priorityOrdersTemp.add(pOrder)
                }
                if(priorityOrders.isEmpty()){
                    while(!priorityOrdersTemp.isEmpty()){
                        priorityOrders.add(priorityOrdersTemp.poll())
                    }
                    if(priorityOrders.size == size){
                        break
                    }else{
                        size = priorityOrders.size
                    }
                }
            }


            if(!orders.isEmpty()) {
                val order = orders.poll()
//            println(order)
                if (balls.peekFirst() == order) {
                    answer += order
                    balls.pollFirst()
                } else if (balls.peekLast() == order) {
                    answer += order
                    balls.pollLast()
                } else {
                    priorityOrders.add(order)
                }
            }
        }

        return answer
    }
}