package designSql

class SQL(names: List<String>, columns: List<Int>) {
    private val map: MutableMap<String, MutableMap<Int, List<String>>> = HashMap()
    private val idMap: MutableMap<String, Int> = HashMap()

    init {
        for (name in names) {
            map[name] = HashMap()
            idMap[name] = 1
        }
    }

    fun insertRow(name: String, row: List<String>) {
        val id = idMap[name]!!
        idMap[name] = id + 1
        map[name]!![id] = row
    }

    fun deleteRow(name: String, rowId: Int) {
        map[name]!!.remove(rowId)
    }

    fun selectCell(name: String, rowId: Int, columnId: Int): String {
        return map[name]!![rowId]!![columnId - 1]
    }
}

fun main() {
    val sql = SQL(arrayListOf("one", "two", "three"), arrayListOf(2, 3, 1))
    sql.insertRow("two", arrayListOf("first", "second", "third"))
    println(sql.selectCell("two", 1, 3))
    sql.insertRow("two", arrayListOf("fourth", "fifth", "sixth"))
    sql.deleteRow("two", 1)
    println(sql.selectCell("two", 2, 2))
}
