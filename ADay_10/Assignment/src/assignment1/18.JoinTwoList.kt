package assignment1

fun main(){
    var list1:List<Int> = listOf(2,3,4,5)
    var list2:List<Int> = listOf(6,7,8,9)
    var joined:ArrayList<Int> = arrayListOf()
    joined.addAll(list1)
    joined.addAll(list2)
    print(joined)
}