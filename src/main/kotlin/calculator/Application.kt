package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    val input = getInput()
    printResult(input)
}

private fun getInput(): String {
    println("덧셈할 문자열을 입력해주세요.")
    val input = Console.readLine()
    return input
}

private fun printResult(result: String) {
    println(result)
}