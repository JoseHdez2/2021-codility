import java.util.*
import java.util.Calendar

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters.firstInMonth
import java.time.temporal.TemporalAdjusters.lastInMonth


class Codility {}

class Wrong {
    fun solution(A: IntArray): Int {
        val B = A.sorted().filter{ it > 0 };
        for(i in B){
            val j = i + 1
            if (j !in B) return j;
        }
        var max = B.max() ?: 0;
        if(max <= 0){
            max = 1
        }
        return max;
    }
}

class BinaryGap {
    companion object {
        fun solution(N: Int): Int {
            val binary = Integer.toBinaryString(N)
            var gaps: MutableList<String> = binary.split("1+".toRegex()).toMutableList()
            // println("A = $gaps");
            if (gaps.size == 1) return 0;
            if(binary.endsWith("0")){
                gaps.removeAt(gaps.size - 1) // "removeLast" not available in all environments.
            }
            return gaps.map { it.length }.max()!!
        }
    }
}

class ArrayRotation {
    companion object {
        fun solution(A: IntArray, K: Int): IntArray {
            if(A.size < 2) return A
            val modulo = K.rem(A.size)
            val i = A.size - modulo
            return A.sliceArray(i..A.size-1) + A.sliceArray(0..i-1)
        }
    }
}


class PhoneContacts {
    companion object {
        fun solution(A: Array<String>, B: Array<String>, P: String): String {
            val contacts: Map<String, String> = A.zip(B).toMap().toSortedMap()
            val results = contacts.filter{ it.value.contains(P) }.map{ it.key }
            if(results.isEmpty()) return "NO CONTACT"
            return results[0]
        }
    }
}

class PhoneNumberFormat {
    companion object {
        fun solution(S: String): String {
            val ary = S.replace("[\\s-]".toRegex(), "").map { it.toString() }
            val str = ary.reduce {a,b -> if(a.matches(".*\\d{3}".toRegex())) ("$a-$b") else (a + b)}
            val str2 = str.replace(Regex("(.*-)(\\d\\d)(\\d)-(\\d)$"), "$1$2-$3$4")
            return str2
        }
    }
}

class GraphPath {
    companion object {
        fun solution(N: Int, A: IntArray, B: IntArray): Boolean {
            for (i in (1 until N)) {
                var bridge = false
                for (j in (A.indices)){
                    if(bridge){ continue }
                    else if(A[j] == i && B[j] == i+1){ bridge = true }
                    else if(B[j] == i && A[j] == i+1){ bridge = true }
                }
                if(!bridge){
                    return false
                }
            }
            return true
        }
    }
}

class GraphPathEfficient { //wip!
    companion object {
        fun solution(N: Int, A: IntArray, B: IntArray): Boolean {
            val edges: List<Pair<Int, Int>> = A.zip(B).map { (a,b) -> Pair(minOf(a,b), maxOf(a,b)) }
                .distinct()
                .filter { (a,b) -> b == a - 1 }
            for (i in (1 until N)) {
                if(edges.none{ (a,b) -> a == i }) return false
            }
            return true
        }
    }
}


class HawaiiVacation {
    companion object {
        val months = listOf("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December")

        fun solution(Y: Int, A: String, B: String, W: String): Int {
            val dateStart = LocalDate.of(Y, months.indexOf(A), 1)
            val firstMonday = dateStart.with(firstInMonth(DayOfWeek.MONDAY))
            val dateEnd = LocalDate.of(Y, months.indexOf(B), 1)
            val lastSunday = dateEnd.with(lastInMonth(DayOfWeek.SUNDAY))

            return (lastSunday.dayOfYear - firstMonday.dayOfYear) / 7
        }
    }
}

fun main(args: Array<String>){
//    for (i in listOf(1, 2, 100, 2048, 1041)){
//        println("solution(${i}) = ${BinaryGap.solution(i)}")
//    }
//    for ((a,k) in listOf(listOf(listOf(1,2),1), listOf(listOf(5,4,7),2))){
//        println("solution($a,$k) = ${ArrayRotation.solution(a,k)}")
//    }
    // for((a,b,p) in listOf([1,2,3]))
//    for (i in listOf(123, 1231, 12312, 123123, 1231231, 12312312)){
//        println("solution($i) = ${PhoneNumberFormat.solution(i.toString())}")
//    }
    println("777888999".contains("88999"))
    println("Done!")
}
