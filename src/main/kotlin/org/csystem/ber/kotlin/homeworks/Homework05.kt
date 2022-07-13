package org.csystem.ber.kotlin.homeworks

import kotlin.math.sqrt as sqrt

fun main() {
    while (true) {
        print("Select Solution Number of 5 (0 for exit):")
        val n = readLine()!!.toInt()
        when (n) {
            0 -> break
            1 -> HW05_1_run()
            2 -> HW05_2_run()
            3 -> HW05_3_run()
            4 -> HW05_4_run()
            else -> break

        }
    }
}

fun HW05_1_run()
{
    println("--Euler Series Calculator App--")
    println("e: ${eCalculator()}")
}

fun eCalculator(): Double
{
    var result = 0.0

    for(i in 0 until 20)
        result += 1.0/ factorial(i)

    return result

}

fun HW05_2_run()
{
    println("--sumFactors App--")
    print("Enter a nubmer:")
    val n = readLine()!!.toInt()
    println("sumFactors is: ${sumFactors(n)}")
}

fun sumFactors(value: Int): Int
{
    var result = 1

    for(i in 2..value / 2)
        if(value % i == 0)
            result += i

    return result
}
fun sumFactorsFaster(value: Int): Int
{
    if (value == 1)
        return 1

    var result = 0
    var sqrtValue = sqrt(value.toDouble()).toInt()
    for(i in 2..sqrtValue)
        if(value % i == 0)
            result += if(i == value / i) i else (i + value / i)

    return result + 1

}

fun HW05_3_run()
{
    println("--areFriends App--")
    print("Enter first number:")
    val n1 = readLine()!!.toInt()
    print("Enter second number:")
    val n2 = readLine()!!.toInt()
    println(if(areFriends(n1, n2)) "The numbers are Friends" else "The numbers are NOT Friends")
    print("Would you like to start 4 Digit Test(1 for Yes, 0 for No):")
    val t = readLine()!!.toInt()
    if (t == 1) {
        println("--4 digit numbers test is started...--")
        areFriends4DigitTest()
    }

}
fun areFriends (n1: Int, n2: Int): Boolean
{
    return sumFactorsFaster(n1) == n2 && sumFactorsFaster(n2) == n1
}
fun areFriends4DigitTest(){
    for(i in 1000..9999)
        for(k in 1000..9999)
            if(areFriends(i, k))
                println("The numbers ${i} and ${k} are Friends")
}

fun HW05_4_run()
{
    println("--Perfect Number App--")
    print("Enter the number to test:")
    val n = readLine()!!.toInt()
    println (if (isPerfect(n)) "The number is perfect number" else " The number is NOT perfect number")

    print("Would you like to start 4 Digit Test(1 for Yes, 0 for No):")
    val t = readLine()!!.toInt()
    if (t == 1) {
        println("--4 digit numbers test is started...--")
        isPerfect4DigitTest()
    }

}
fun isPerfect(value: Int): Boolean
{
    return value == sumFactorsFaster(value)
}
fun isPerfect4DigitTest()
{
    for(i in 1000..9999)
        if(isPerfect(i))
            println("The number ${i} is a 4 Digit Perfect Number")
}