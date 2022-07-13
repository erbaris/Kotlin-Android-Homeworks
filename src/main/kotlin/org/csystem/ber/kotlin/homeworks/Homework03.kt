package org.csystem.ber.kotlin.homeworks

import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.pow

fun main() {
    while (true) {
        print("Select Solution Number of 5 (0 for exit):")
        val n = readLine()!!.toInt()
        when (n) {
            0 -> break
            1 -> HW03_1_run()
            2 -> HW03_2_run()
            3 -> HW03_3_run()
            4 -> HW03_4_run()
            5 -> HW03_5_run()
            6 -> HW03_6_run()
            7 -> HW03_7_run()
            8 -> HW03_8_run()
            else -> break

        }
    }
}

fun HW03_1_run()
{
    println("--The passed numbers for defined conditions--")
    for(i in 100..1000)
        if(conditions(i))
            println("Passed: ${i}")
}
fun conditions(value: Int): Boolean
{
    val reversedVal = reversed(value)
    val ab = value / 10
    val ba = reversed(ab)
    val cb = reversedVal / 10
    val bc = reversed(cb)

    return reversedVal > value && isPrime(value.toLong()) && isPrime(reversedVal.toLong())
            && isPrime(ab.toLong()) && isPrime(bc.toLong())
            && isPrime(cb.toLong()) && isPrime(ba.toLong())
}
fun reversed(value: Int): Int
{
    var result = 0
    var tmp = value

    while (tmp != 0) {
        result = result * 10 + tmp % 10
        tmp /= 10
}

    return result
}
fun HW03_2_run()
{
    println("--PrimeX Numbers Tests--")
    print("Enter max number to test:")
    val max = readLine()!!.toInt()
    for(i in 1..max)
        if(isPrimeX(i))
            println("PrimeX number is : ${i}")
}

fun isPrimeX(value: Int): Boolean
{
    if(isPrime(value.toLong())) {
        var sumdigits = sumDigits(value)

        while(true) {
            if (!isPrime(sumdigits.toLong()))
                return false

            if (countDigits(sumdigits) == 1)
                break

            sumdigits = sumDigits(sumdigits)
        }

        return true
    }
    return false
}

fun sumDigits(value: Int): Int
{
    var sum = 0
    var tmp = value

    while (tmp != 0) {
        sum += tmp % 10
        tmp /= 10
    }

    return abs(sum)
}

fun countDigits(value: Int): Int
{
    if (value == 0)
        return 1

    var count = 0
    var tmp = value

    while (tmp != 0) {
            ++count
            tmp /= 10
    }

    return count
}


fun HW03_3_run()
{
    println("--Digital Root--")
    while (true) {
        print("Enter a number to calculate Digital Root(0 for Exit):")
        var n = readLine()!!.toInt()
        if(n == 0)
            break
        println("Digital root is: ${calculateDigitalRoot(n)}")
    }

}

fun calculateDigitalRoot(value: Int): Int
{
    var tmp = value
    var countDigit = countDigits(tmp)
    while (countDigit != 1) {
        tmp = sumDigits(tmp)
        countDigit = countDigits(tmp)
    }
    return tmp

}

fun HW03_4_run()
{
    println("--Factorian Numbers Tests--")
    for(i in 1..100_000)
        if(isFactorian(i.toLong()))
            println("Factorian number is: ${i}")
}

fun isFactorian(value: Long): Boolean
{
    if (value <= 0)
        return false

    var tmp = value
    var sum = 0L
    while(tmp != 0L) {
        sum += factorial((tmp % 10).toInt())
        tmp /= 10
    }
    return sum == value

}
fun factorial(n: Int): Long
{
    var result = 1L

    for (i in 2..n)
        result *= i

    return result
}

fun HW03_5_run()
{
    println("--Super Prime Tests--")
    print("Enter max number to test:")
    val max = readLine()!!.toInt()
    for(i in 1..max)
        if(isSuperPrime(i))
            println("${i} is Super Prime")
}
fun isSuperPrime(value: Int) : Boolean
{
    return isPrime(value.toLong()) && isPrime(indexOfPrime(value).toLong())
}
fun indexOfPrime(n: Int) : Int
{
    var count = 1

    for(i in 2..n) {
        if(i == n)
            return count
        if(isPrime(i.toLong()))
            count++
    }
    return count
}

fun HW03_6_run()
{
    println("--Hardy-Ramanujan Numbers Test--")
    for(i in 1..100_000)
        if(isHardyRamanujan(i))
            println("${i} is a Hardy-Ramanujan Number")
}
fun isHardyRamanujan(value: Int) : Boolean
{
    var count = 0
    var a = 1
    while (a * a * a < value) {
        var b = a + 1
        var tmp = a * a * a + b * b * b
        while(tmp <= value ) {
            if(tmp == value){
                count++
                if(count == 2)
                    return true
            }
            b++
            tmp = a * a * a + b * b * b
        }
        a++
    }
    return false


}
fun HW03_7_run()
{
    println("--Decimal Harshad Numbers Test--")
    print("Enter max number to test:")
    val max = readLine()!!.toInt()
    for(i in 1..max)
        if(isDecimalHarshad(i))
            println("${i} is a Decimal Harshad Number")
}
fun  isDecimalHarshad(value: Int): Boolean
{
    if (value <= 0)
        return false;

    if(value % sumDigits(value) == 0)
        return true;

    return false;
}
fun HW03_8_run()
{
    println("--Collatz Series Application--")
    print("Enter the number to test:")
    val n = readLine()!!.toInt()
    printCollatz(n)
}
fun printCollatz(value: Int)
{
    var tmp = value
    while (tmp != 1) {
        println(tmp)
        if (tmp % 2 == 0) {
            tmp = tmp / 2
        }
        else {
            tmp = 3 * tmp + 1;
        }
    }
    println(tmp)
    println("----------------------")
}