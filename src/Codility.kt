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

fun main(args: Array<String>){
//    for (i in listOf(1, 2, 100, 2048, 1041)){
//        println("solution(${i}) = ${BinaryGap.solution(i)}")
//    }
//    for ((a,k) in listOf(listOf(listOf(1,2),1), listOf(listOf(5,4,7),2))){
//        println("solution($a,$k) = ${ArrayRotation.solution(a,k)}")
//    }

    println("Done!")
}
