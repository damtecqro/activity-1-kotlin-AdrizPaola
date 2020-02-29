package com.app.ejemplo8

/**
 * Adriana Paola Salinas García
 *       A01703675
 * Problems solved: P08 and P35
 */


/**
 * Algorithm P08
 * n <- string size
 * if n < 2
 *    return string
 * end if
 *
 * j <- 0
 * for i <- 1 to n
 *     if string[j] != string[i]
 *          j <- j + 1
 *          string[j] <- string[i]
 *     end if
 * end for
 *
 * arrayAux <- string array copy from 0 to j + 1
 * return arrayAux
 *
 */

fun removeDuplicates(string:CharArray): CharArray{
    val n = string.size
    if (n < 2)
    {
        return string
    }
    var j = 0
    for (i in 1 until n)
    {
        if (string[j] != string[i])
        {
            j++
            string[j] = string[i]
        }
    }
    val arrayAux = string.copyOfRange(0, j + 1)
   // print(arrayAux)
    return arrayAux
}

var testIndex = 1

fun assertEquals(firstValue: Boolean, secondValue: Boolean)
{
    if(firstValue == secondValue)
        println("Prueba #" + testIndex + " ha pasado")
    else
        println("Prueba #" + testIndex + " no ha pasado")

    testIndex += 1
}

//Github
assertEquals(removeDuplicates("".toCharArray()) contentEquals  "".toCharArray(), true)
assertEquals(removeDuplicates("abc".toCharArray()) contentEquals "abc".toCharArray(), true)
assertEquals(removeDuplicates("aaa".toCharArray()) contentEquals "a".toCharArray(), true)
assertEquals(removeDuplicates("aaaabccaadeeee".toCharArray()) contentEquals "abcade".toCharArray(), true)

//Personales
assertEquals(removeDuplicates("yyyba".toCharArray()) contentEquals "yyyba".toCharArray(), false)
assertEquals(removeDuplicates("a  a".toCharArray()) contentEquals "a a".toCharArray(), true)
assertEquals(removeDuplicates("aa".toCharArray()) contentEquals "a".toCharArray(), true)




/**
 * Algorithm P35
 * n <- numbers
 * factors <- an empty list
 * while i < n / i
 *    while n mod i = 0
 *      add i to the list factors
 *      n <- n / i
 *    end while
 *    i <- i + 1
 * end while
 *
 * if n > 1
 *    add i to the list factors
 * end if
 *
 * return factors
 */


fun primeFactors(numbers:Int):List<Int> {
    var n = numbers
    val factors = ArrayList<Int>()
    var i = 2
    while(i < n/i)
    {
        while (n % i == 0)
        {
            factors.add(i)
            n /= i
        }
        i = i + 1
    }
    if (n > 1)
    {
        factors.add(n)
    }
    return factors
}

//GIT
assertEquals(primeFactors(315).equals(listOf(3, 3, 5, 7)), true)


//Personales
assertEquals(primeFactors(1).equals(emptyList<Int>()), true)
assertEquals(primeFactors(580).equals(listOf(2, 2, 5, 29)), true)
assertEquals(primeFactors(76).equals(listOf(2, 2, 19)), true)
assertEquals(primeFactors(84).equals(listOf(2, 2, 3, 7)), true)