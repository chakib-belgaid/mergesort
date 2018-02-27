fun mergeSort(list: List<Int>): List<Int> {
    if (list.size <= 1) {
        return list
    }
 
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()
 
    val middle = list.size / 2
    list.forEachIndexed { index, number ->
        if (index < middle) {
            left.add(number)
        } else {
            right.add(number)
        }
    }
 
    fun merge(left: List<Int>, right: List<Int>): List<Int> = mutableListOf<Int>().apply {
        var indexLeft = 0
        var indexRight = 0
 
        while (indexLeft < left.size && indexRight < right.size) {
            if (left[indexLeft] <= right[indexRight]) {
                add(left[indexLeft])
                indexLeft++
            } else {
                add(right[indexRight])
                indexRight++
            }
        }
 
        while (indexLeft < left.size) {
            add(left[indexLeft])
            indexLeft++
        }
 
        while (indexRight < right.size) {
            add(right[indexRight])
            indexRight++
        }
    }
 
    return merge(mergeSort(left), mergeSort(right))
}


fun customRandom(n:Int) : Int {
    val MAXI = 1000000
    val x = n.toDouble() 
    return (x*x*x*Math.cos(x)*Math.cos(x)).toInt() % MAXI
}
 
fun main(args: Array<String>) {
    val n = if(args.size >0) args[0].toInt() else 20 
    val niters = if(args.size >1) args[1].toInt() else 1 
    for (iter:Int in 0..(niters-1)){   
        var arr:MutableList<Int> =  ArrayList()
        for(i: Int in 0..(n-1)){
            arr.add(customRandom(i))
        }
        println("$arr")
        println("${mergeSort(arr)}")

        }

    
}