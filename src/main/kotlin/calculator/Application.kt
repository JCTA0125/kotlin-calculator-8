package calculator

import camp.nextstep.edu.missionutils.Console
import kotlin.collections.mapNotNull
import kotlin.text.toIntOrNull

fun main() {
    val input = getInput()
    checkCustom(input)
}

private fun getInput(): String {
    println("덧셈할 문자열을 입력해주세요.")
    val input = Console.readLine()
    return input
}

private fun checkCustom(input: String) {
    val customStart = input.indexOf("//")
    val customEnd = input.indexOf("\\n")
    if (customStart == 0 && customEnd == 3){
        // Custom Calculator
        customSeparator(input)
    } else if (customStart != 0 && customEnd == 3) {
        // Custom Separator //(X), \n(O)
        throw IllegalArgumentException("customStart: $customStart")
    } else if (customStart == 0 && customEnd != 3){
        // Custom Separator //(O), \n(X)
        throw IllegalArgumentException("customEnd: $customEnd")
    } else {
        // Basic Calculator
        basicSeparator(input)
    }
}

private fun customSeparator(input: String) {
    val sep = input.substring(2 until 3)
    val inputProcessed = input.substring(5 until input.length)
    checkStrException(inputProcessed, sep)
    val split = inputProcessed.split(sep)
    val numArr = split.mapNotNull { it.toIntOrNull() }
    sumNum(numArr)
}

private fun basicSeparator(input: String) {
    checkStrException(input, ",:")
    val split1 = input.split(":")
    val split2 = split1.joinToString().replace(" ", "").split(',')
    val numArr = split2.mapNotNull { it.toIntOrNull() }
    sumNum(numArr)
}

private fun checkStrException(testStr: String, allowedChars: String) {
    val regex = Regex("^[0-9${Regex.escape(allowedChars)}]*$")
    if (regex.matches(testStr)) return
    else throw IllegalArgumentException("Characters not allowed")
}

private fun sumNum(numArr: List<Int>) {
    val sum = numArr.sum()
    printResult(sum)
}

private fun printResult(result: Int) {
    println("결과 : $result")
}