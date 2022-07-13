package org.csystem.ber.kotlin.homeworks

//Homewrok04 Solution - Baris ER

fun main() {
    println("--Number Calculator App--")
    calculationApp()
}

fun calculationApp()
{
    var sum = 0
    var min = 101
    var max = 0
    var counter = 0
    var status = 1
    var number = -1
    while(status == 1) {
        print("Would you like to enter number (1 for Yes, 0 for No):")
        val status = readLine()!!.toInt()
        if(status == 1) {
            print("Please enter a number between [0 - 100]:")
            while (true) {
                number = readLine()!!.toInt()
                if (0 <= number && number <= 100)
                    break
                println("You entered invalid value!...")
                print("Please enter a new value:")
            }
            min = if(number < min) number else min
            max = if(number > max) number else max
            sum += number
            counter++
        }
        else
            break

    }
    if (counter != 0) {
        println("Total ${counter} numbers are entered.")
        println("Max: ${max}")
        println("Min: ${min}")
        println("Average: ${sum.toDouble() / counter}")
    }
    else
        println("Total ${counter} numbers are entered.")

}
