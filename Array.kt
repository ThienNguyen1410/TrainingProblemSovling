import java.util.Arrays
import java.util.Scanner

fun main() {
    var arr = arrayOf<Int>(1,2,2,3,4,1,54,6,7,8,9,9,13,10,2,3,5)
    var twoSumArr = intArrayOf(2,7,11,15)
    var reversInt = -123
    println("Origin Array " + Arrays.toString(arr) )
    println("Revert array : " + Arrays.toString(reverse(arr)))
    println("Sum Array : " + sumArray(arr))
    println("Check Duplicate     : " + findDuplicate(arr))
    // println("Remove Duplicate : " + removeDuplicateSortedList(quickSort(arr.toList()).toTypedArray()))
    println("Remove Dupicates Using Set : " + removeDuplicateUseSet(arr).toList())
    // println("Dupicate using copy array : " + findDuplicateUseCopyArray(arr))
    println("Divide arrays to evens and odd subarray : " + divideArray(arr))
    println("Quick Sort : " + quickSort(arr.toMutableList()))
    println("Input to an Array : " + inputIntToSortedArray(removeDuplicateUseSet(quickSort(arr.toList()).toTypedArray()).toTypedArray()))
    println("Two sum Int Array : " + twoSum(twoSumArr, 9).toList())
    println("Reverse Int $reversInt to Int : " + reverse(reversInt))
}

fun reverse(arr : Array<Int>) : Array<Int> {
    var reverseArray = arrayOf<Int>()
    val converter : MutableList<Int> = reverseArray.toMutableList()
    for(x in (arr.size - 1) downTo 0)
    {
        converter.add(arr[x])
    }
    return converter.toTypedArray()
}
fun quickSort(list : List<Int>) : List<Int> {
    if(list.count() < 2) {
        return list
    }
    var pivot = list[list.count()/2]
    var equal = list.filter { it == pivot}
    var less  = list.filter {it < pivot}
    val greater = list.filter { it > pivot}
    
    return quickSort(less) + equal + quickSort(greater)
}
 
fun sumArray(arr : Array<Int>) : Int {
    var n = 0
    for (i in 0..(arr.size - 1 )){
        n = n + arr[i]
    }
    return n
}

fun findDuplicate(arr : Array<Int>) : MutableList<Int> {
    val start = System.nanoTime()
    var checker = 0
    var duplicates = mutableListOf<Int>()
    for (i in 0..(arr.size - 1 )) {
        for (j in (i + 1)..(arr.size - 1)) {
            if (arr[i] == arr[j]) {
                checker++
                duplicates.add(arr[j])
                println("Duplicate at index $i and index $j")
                println("Dupicates value is " + arr[i] )
            }
        }
    }
    println("Repeat $checker time ")
    val end = System.nanoTime()
    var count = end - start
    println("Running time using O(nxn) : $count" )
    return duplicates
}


fun emoveDuplicateSortedList(arr : Array<Int>) : MutableList<Int> {
    val start = System.nanoTime()
    var duplicates = mutableListOf<Int>()
    for (i in 0..(arr.size - 2 )) {
            if (arr[i] != arr[i+1]) {
                duplicates.add(arr[i])
        }
    }
    val end = System.nanoTime()
    var count = end - start
    println("Running time removeDuplicateSortedList  : $count" )
    return duplicates
}

fun removeDuplicateUseSet(arr : Array<Int>) : Set<Int>{
    var distinct = arr.toSet()
    return distinct
}

fun findUnique(arr : Array<Int>) : MutableList<Int> {
    var checker = 0
    var unique = mutableListOf<Int>()
    for (i in 0..(arr.size - 1 )) {
        for (j in (i + 1)..(arr.size - 1)) {
            if (arr[i] != arr[j]) {
                checker++
                unique.add(arr[i])
            }
        }
    }
    return unique
}

fun divideArray(arr : Array<Int>) {

    var evens = mutableListOf<Int>()
    var odds = mutableListOf<Int>()
    for(i in 0..(arr.size - 1)) {
        if( (arr[i] % 2) == 0) {
            evens.add(arr[i])
        } else {
            odds.add(arr[i])
        }
    }
    println("List of evens elements : " + evens)
    println("List of odd elements : " + odds)
}

fun inputIntToSortedArray(arr: Array<Int>) : MutableList<Int> {
    val reader = Scanner(System.`in`)
    val list : MutableList<Int> = arr.toMutableList()
    println("Input a number : " )
    var x = reader.nextInt()
    for(i in 0..(arr.size - 1)){
        if(arr[i] > x) {
            list.add(i-1,x)
            break
        }
    }
    return list 
}

fun twoSum(nums: IntArray, target: Int): IntArray {
        var map = hashMapOf<Int,Int>()
        var indexs = mutableListOf<Int>()
        for(i in 0..(nums.size - 1)) {
            var leftNum = target - nums[i]
            if (map.containsKey(leftNum)) {
                indexs.add(map.getValue(leftNum))
                println("Value of hash map : " + map.getValue(leftNum))
            }
            map.put(nums[i],i)
        }
        return indexs.toIntArray()
    }
fun reverse(x: Int): Int {
        var rev = 0
        var y = x
        while(y != 0) {
            var pop = y % 10
            y /= 10
            rev = rev*10 + pop
        }
    return rev
    }


