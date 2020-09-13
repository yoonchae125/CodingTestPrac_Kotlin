package programmers_challenge

class Num2 {
    fun solution(n: Int): IntArray {
        var answer = ArrayList<Int>()
        var array = arrayOf<IntArray>()

        for(i in 1..n){
            array = array.plus(IntArray(i))
        }
        val size = n*(n+1)/2
        fill(size, array, 1, 0,0,Dir.Down)

        for(i in array.indices){
            for(j in array[i].indices){
                answer.add(array[i][j])
            }
        }

        return answer.toIntArray()
    }
    fun fill(size:Int, array: Array<IntArray>,num:Int, x:Int, y:Int, dir:Dir){
        array[x][y]=num
        if(num == size)
            return

        val nx = x+dir.x
        val ny = y+dir.y
        if(nx<0 || nx>= array.size || ny<0 || ny>=array[nx].size){
            if(dir==Dir.Down){
                return fill(size, array, num, x, y, Dir.Right)
            }else if(dir==Dir.Right){
                return fill(size, array, num, x, y, Dir.Up)
            }else{
                return fill(size, array, num, x, y, Dir.Down)
            }
        }
        else if(array[nx][ny]!=0){
            if(dir==Dir.Down){
                return fill(size, array, num, x, y, Dir.Right)
            }else if(dir==Dir.Right){
                return fill(size, array, num, x, y, Dir.Up)
            }else{
                return fill(size, array, num, x, y, Dir.Down)
            }
        }
        return fill(size, array, num+1, nx, ny, dir)
    }
    enum class Dir(val x:Int, val y:Int){
        Down(1, 0),
        Right(0, 1),
        Up(-1,-1)
    }
}