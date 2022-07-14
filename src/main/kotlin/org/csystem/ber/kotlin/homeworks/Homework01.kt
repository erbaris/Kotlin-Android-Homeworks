package org.csystem.ber.kotlin.homeworks

import kotlin.math.max
import kotlin.math.min


fun main()
{

    while (true) {
        print("Select Solution Number of 3 (0 for exit):")
        val n = readLine()!!.toInt()
        when (n) {
            0 -> break
            1 -> HW01_1_2_run()
            2 -> HW01_1_2_run()
            3 -> HW01_3_run()
            else -> break

        }
    }

}

fun HW01_1_2_run()
{
    println("--min, mid, max--")
    print("Enter first number:")
    val n1 = readLine()!!.toInt()

    print("Enter second number:")
    val n2 = readLine()!!.toInt()

    print("Enter third number:")
    val n3 = readLine()!!.toInt()

    printRelationsApp(n1, n2, n3)
    println()
    println("Mid is ${findMid(n1, n2, n3)}")

}
fun HW01_3_run()
{
    while(true)
    {
        println("--signum function--")
        print("Enter a number(999 for exit):")
        var value = readLine()!!.toInt()

        if(value == 999)
            break

        val sing = signum(value)

        println(when {  sing == 1 -> "The number is positive"
            sing == 0-> "The number is zero"
            else -> "The number is negative"})


    }

}

fun printRelationsApp(n1: Int, n2: Int, n3: Int)
{
    val min = min(min(n1,n2), n3)
    val max = max(max(n1, n2), n3)
    val mid = n1 + n2 + n3 - max - min

    print(if(min == mid) "${min} = ${mid} " else "${min} < ${mid} ")
    print(if(mid == max) "= ${max}" else "< ${max}")

}

fun findMid(n1: Int, n2: Int, n3: Int): Int
{
    if(n1 in n2..n3 || n1 in n3..n2)
        return n1

    if(n2 in n1..n3 || n2 in n3..n1)
        return n2

    return n3
}

fun signum(value: Int): Int
{
    return when {
        value > 0 -> 1
        value == 0 -> 0
        else -> -1
    }
}