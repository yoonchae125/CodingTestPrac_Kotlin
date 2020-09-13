package line_2020

class Num4 {
    // 아래 오른 위 왼
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    fun solution(maze: Array<IntArray>): Int {
        var answer: Int = 0
        answer = search(maze,Pair(0,0),0,0)
        return answer
    }
    fun search(maze: Array<IntArray>, now:Pair<Int,Int>, dir:Int, count:Int):Int{
        println("$now, $dir")
        if(now.first == maze.lastIndex && now.second == maze.lastIndex){ // clear!
            return count
        }

        val leftDir = (dir+1)%4
        val left = Pair(now.first+dx[leftDir], now.second+dy[leftDir])
        val next = Pair(now.first+dx[dir], now.second+dy[dir])
        if(left.first<0 || left.first>maze.lastIndex||left.second<0 || left.second>maze.lastIndex) { // edge of maze
            println("벽 ")
            if(next.first<0 || next.first>maze.lastIndex||next.second<0 || next.second>maze.lastIndex){
                return search(maze, now, (dir+3)%4, count)
            }
            if(maze[next.first][next.second] == 1){ // 앞에 벽이
                return search(maze, now, (dir+3)%4, count)
            }
            return search(maze, next, dir, count+1)
        }
        if(maze[left.first][left.second] == 0){ // 왼쪽에 벽이 없으면 왼쪽으로 돌아서
            println("${left.first},${left.second}벽 x")
            if(left.first+dx[(leftDir+1)%4]<0 || left.first+dx[(leftDir+1)%4]>maze.lastIndex
                    ||left.second+dy[(leftDir+1)%4]<0 || left.second+dy[(leftDir+1)%4]>maze.lastIndex){
                return search(maze,now, leftDir,count)

            }
            if(maze[left.first+dx[(leftDir+1)%4]][left.second+dy[(leftDir+1)%4]]==1)
                return search(maze, left, leftDir, count+1)
            return search(maze,now, leftDir,count)
        }

        if(next.first<0 || next.first>maze.lastIndex||next.second<0 || next.second>maze.lastIndex){
            return search(maze, now, (dir+3)%4, count)
        }
        if(maze[next.first][next.second] == 1){ // 앞에 벽이
            return search(maze, now, (dir+3)%4, count)
        }
        println("벽 ")
        return search(maze, next,dir, count+1)
    }
}