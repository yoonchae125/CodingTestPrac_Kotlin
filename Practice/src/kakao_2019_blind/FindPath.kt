package kakao_2019_blind

class FindPath {
    fun solution(nodeinfos: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()
        var startNodeId: Int = -1
        val mutableNodes = mutableMapOf<Int, Node>()
        for ((idx, nodeInfo) in nodeinfos.withIndex()) {
            mutableNodes[idx + 1] = Node(idx + 1, nodeInfo[0], nodeInfo[1])
        }
        val nodes = mutableNodes.toList().sortedWith(compareByDescending { it.second.y }).toMap()
        for (node in nodes) {
            if (startNodeId == -1) {
                startNodeId = node.value.id
                continue
            } else {
                if (node.value.y > nodes[startNodeId]!!.y) {
                    if (node.value.x < nodes[startNodeId]!!.x) {
                        node.value.right = startNodeId
                    } else {
                        node.value.left = startNodeId
                    }
                    startNodeId = node.value.id
                } else if (node.value.y < nodes[startNodeId]!!.y) {
                    var sid = startNodeId
                    while (true) {
                        val snode = nodes[sid]!!
                        if (node.value.x > snode.x) { // right
                            if (snode.right == -1) { // end
                                snode.right = node.value.id
                                break
                            }
                            val rnode = nodes[snode.right]!!
                            if (node.value.y > rnode.y) {
                                //change
                                snode.right = node.value.id
                                if (node.value.x > rnode.x) {
                                    node.value.left = rnode.id
                                } else {
                                    node.value.right = rnode.id
                                }
                                break
                            } else if (node.value.y == rnode.y) {
                                // put in left of snode
                                snode.left = node.value.id
                                break
                            } else {
                                // search for place
                                sid = rnode.id
                                continue
                            }
                        } else { // left
                            if (snode.left == -1) { // end
                                snode.left = node.value.id
                                break
                            }
                            val lnode = nodes[snode.left]!!
                            if (node.value.y > lnode.y) {
                                //change
                                snode.left = node.value.id
                                if (node.value.x > lnode.x) {
                                    node.value.left = lnode.id
                                } else {
                                    node.value.right = lnode.id
                                }
                                break
                            } else if (node.value.y == lnode.y) {
                                // put in right of snode
                                snode.right = node.value.id
                            } else {
                                // search for place
                                sid = lnode.id
                                continue
                            }
                        }
                    }// end of while
                }
            }
        }
//        val queue: Queue<Int> = LinkedList<Int>()
//        queue.add(startNodeId)
//        val first = IntArray(nodeinfos.size)
//        var idx = 0
//        while (!queue.isEmpty()) {
//            val num = queue.poll()
//            if (num == -1) continue
//
//            first[idx++] = num
//            val node = nodes[num]!!
//            queue.add(node.left)
//            queue.add(node.right)
//        }
//        printList(first)
//        println(startNodeId)
        val pre = IntArray(nodeinfos.size)
        preorder(nodes, pre, startNodeId)
//        printList(pre)
        idx = 0
        val post = IntArray(nodeinfos.size)
        postorder(nodes, post, startNodeId)
//        printList(post)
//        val snode = nodes[5]!!
//        println("${snode.left}, ${snode.right}")
        answer += pre
        answer += post
        return answer
    }

    var idx = 0
    fun preorder(nodes: Map<Int, Node>, pre: IntArray, nodeId: Int) {
        if (nodeId == -1) {
            return
        }
        pre[idx++] = nodeId
        val n = nodes[nodeId]!!
        preorder(nodes, pre, n.left)
        preorder(nodes, pre, n.right)
    }

    fun postorder(nodes: Map<Int, Node>, post: IntArray, nodeId: Int) {
        if (nodeId == -1) {
            return
        }
        val n = nodes[nodeId]!!
        postorder(nodes, post, n.left)
        postorder(nodes, post, n.right)
        post[idx++] = nodeId
    }

    data class Node(val id: Int, val x: Int, val y: Int, var left: Int = -1, var right: Int = -1)
}