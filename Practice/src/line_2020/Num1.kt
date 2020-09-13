package line_2020

class Num1 {
    fun solution(boxes: Array<IntArray>): Int {

        var products = intArrayOf()
        var num = boxes.size

        boxes.forEach {
            products+=it
        }
        products.sort()

        var prev = -1
        var count = 0
        for(product in products){
            if(product==prev){
                count++
            }else{
                num-=count/2
                prev = product
                count=1
            }
        }
        num-=count/2
        return num
    }
}