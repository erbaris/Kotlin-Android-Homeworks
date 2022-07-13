package org.csystem.ber.kotlin.homeworks

import kotlin.math.abs


fun main()
{
    while (true) {
        print("Select Solution Number of 5 (0 for exit):")
        val n = readLine()!!.toInt()
        when (n) {
            0 -> break
            1 -> HW02_1_run()
            2 -> HW02_2_run()
            3 -> HW02_3_run()
            4 -> HW02_4_run()
            5 -> HW02_5_run()
            else -> break

        }
    }


}
fun HW02_1_run()
{
    println("--Diamond print--")
    print("Enter the size of diamond:")
    val n = readLine()!!.toInt()

    printDiamond(n)
}

fun printDiamond(n: Int)
{
    printDiamondAbove(n)
    printDiamondBelow(n)
}

fun printDiamondAbove(n: Int)
{
    for ( i in 1..n){
        for ( k  in 1 .. n + 1 - i)
            print(' ')

        for (k in 1 .. 2 * i -1)
            print('*')

        println()
    }
}

fun printDiamondBelow(n: Int)
{
    for (i in n - 1 downTo 1) {
        for ( k  in 1 .. n + 1 - i)
            print(' ')

        for (k in 1 .. 2 * i -1)
            print('*')

        println()
    }
}

fun HW02_2_run()
{
    println("--Time calculation--")
    print("Enter the second count:")
    val t = readLine()!!.toLong()
    printDuration(t)
}

fun printDuration(time: Long) {
    val second = time % 60
    val minute = time / 60 % 60
    val hour = time / 60 / 60

    val hourStr = when {
        hour > 1L -> "${hour} hours "
        hour == 1L -> "${hour} hour "
        else -> ""
    }
    val minuteStr = when {
        minute > 1L -> "${minute} minutes "
        minute == 1L -> "${minute} minute "
        else -> ""
    }
    val secondStr = when {
        second > 1L -> "${second} seconds "
        second == 1L -> "${second} second "
        else -> ""
    }
    println(hourStr + minuteStr + secondStr)
}

fun HW02_3_run()
{
    println("--Prime Factors--")
    while (true) {
        print("Enter the number (0 for exit):")
        val n = readLine()!!.toInt()
        if (n == 0)
            break
        printPrimeFactors(n)
    }
}
fun printPrimeFactors(n: Int)
{
    if (n == 0)
        return

    var tmp = abs(n)
    var i = 2

    while ( tmp != 1)
        if( tmp % i == 0) {
            println("Prime Factor: ${i}")
            tmp /= i
        }
        else
            i++

}

fun HW02_4_run()
{
    println("--ball fall drawing--")
    print("Enter height:")
    val height = readLine()!!.toInt()
    print("Enter width:")
    val width = readLine()!!.toInt()
    val b = BallFallGame(width, height)
    b.play()
}
class BallFallGame(width: Int, height: Int) {
    val width = width
    val height = height
    var directionRight = true
    var ballIdx = 0

    fun play() {
        for(i in 1..height)
        {
            print('|')
            printBallLine()
            println('|')
        }
    }

    fun printBallLine()
    {
        fillSpace(0, ballIdx)
        print('*')
        fillSpace(ballIdx + 1, width)
        updateBall()
        checkDirection()
    }

    fun fillSpace(start: Int, stop: Int)
    {
        for(i in start until stop)
            print(' ')
    }

    fun updateBall()
    {
        if(directionRight)
            ballIdx++
        else
            ballIdx--

    }

    fun checkDirection()
    {
        ///println(directionRight)
        if(ballIdx == width -1 )
            directionRight = false
        if(ballIdx == 0)
            directionRight = true
        //println(directionRight)
    }

}


fun HW02_5_run()
{
    println("--Goldbach theorem--")
    print("Enter an Even number greater than 2:")
    val n = readLine()!!.toLong()
    findGoldbach(n)
}
fun findGoldbach(n: Long)
{
    for(i in 2L .. n / 2)
        if(isPrime(i) && isPrime(n - i) )
            println("Goldbach numbers are: ${i} + ${n - i}")
}
fun isPrime(value: Long): Boolean
{
    if(value <= 1)
        return false

    if(value % 2 == 0L)
        return value == 2L

    if(value % 3 == 0L)
        return value == 3L

    if(value % 5 == 0L)
        return value == 5L

    if(value % 7 == 0L)
        return value == 7L

    var i = 11L

    while (i * i <= value) {
        if (value % i == 0L)
            return false
        i += 2
    }

    return true
}