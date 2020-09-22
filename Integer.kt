import java.util.HashMap
fun isPalindrome(x: Int): Boolean {
        var y = x
        var isNegative = false
        if(x < 0) {
            isNegative = true
            y *= -1
        }
        var pop = 0
        var rev = 0
            while(y != 0){
                pop = y % 10
                y /= 10
                if(y > Int.MAX_VALUE/10 || (y == Int.MAX_VALUE/10 && pop > 7)) {return false}
                if(y < Int.MIN_VALUE/10 || (y == Int.MIN_VALUE/10 && pop < -8)) {return false}
                rev = rev * 10 + pop
            
        }
        if(isNegative) {
            return false
        }
        if (rev == x) {
            println("True")
            return true
        } else {
            println("False")
            return false
        }
    }

    fun romanToInt(s : String) : Int {
         var map = hashMapOf<Char,Int>()
         var num = 0
         map.put('I',1)
         map.put('V',5)
         map.put('X',10)
         map.put('L',50)
         map.put('C',100)
         map.put('D',500)
         map.put('M',1000)
         var i = 0
         for(i in 0..(s.length - 1)) {
             if ((i+1) < s.length - 1) {
                 if(s.get(i) >= s.get(i+1)) {
                    num += map.getValue(s.get(i))
                 } 
                 else {
                     num += map.getValue(s.get(i + 1)) - map.getValue(s.get(i))
                     i++
                 }
            }
            else {
                num += map.getValue(s.get(i)) 
            }
    } 
    return num
}

fun main() {
    isPalindrome(121)
    println("Roman numbers : " + romanToInt("MCMXCIV"))
}
