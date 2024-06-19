package replaceWords

class Solution {
    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val trie = Trie()
        for (word in dictionary) {
            trie.add(word)
        }
        val list = sentence.split(" ").toMutableList()
        for (i in list.indices) {
            list[i] = trie.find(list[i]) ?: list[i]
        }
        return list.joinToString(" ")
    }
}

class Trie {
    private val head: Node = Node()

    fun add(str: String, i: Int = 0, node: Node = head) {
        if (i == str.length) {
            node.isEnd = true
            return
        }
        if (node.isEnd) {
            return
        }
        val code = str[i] - 'a'
        if (node.nodes[code] == null) {
            node.nodes[code] = Node()
        }
        add(str, i + 1, node.nodes[code]!!)
    }

    fun find(str: String, i: Int = 0, node: Node = head): String? {
        if (node.isEnd) {
            return ""
        }
        if (i == str.length) {
            return null
        }
        val code = str[i] - 'a'
        if (node.nodes[code] != null) {
            val result = find(str, i + 1, node.nodes[code]!!)
            return if (result == null) null else str[i] + result
        }
        return null
    }
}

class Node {
    val nodes: Array<Node?> = Array(26) { null }
    var isEnd = false
}