package org.csystem.ber.kotlin.homeworks

import kotlin.random.Random

//Homewrok 06 Solution - Baris ER

fun main() {
    println("--Craps Game App--")
    println("--Simulation is played for 100.000--")
    crapsSimulationApp()
}

fun crapsSimulationApp()
{
    val cp = CrapsGame()
    var winCounter = 0
    for(i in 1..100_000)
        if(cp.play())
            winCounter++
    println("The win probability is ${winCounter.toDouble() / 100_000}")
}

class CrapsGame()
{
    fun play(): Boolean
    {
        val r = Random
        val total = roll(r)
        when {
            total == 7 || total == 11 -> return true
            total == 2 || total == 3 || total == 12 -> return false
            else -> return otherRolls(r, total)
        }
    }
    fun roll(r: Random): Int
    {
        return r.nextInt(1, 7) + r.nextInt(1,7)
    }
    fun otherRolls(r: Random, total: Int): Boolean
    {
        while(true)
        {
            val otherRolls = roll(r)
            if(otherRolls == total)
                return true
            if(otherRolls == 7)
                return false
        }
    }

}