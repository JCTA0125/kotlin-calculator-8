package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    val input = getInput()
    checkCustom(input)
    printResult(input)
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
        // TODO: Custom Calculator
    } else if (customStart != 0 && customEnd == 3) {
        // Custom Separator \\(X), \n(O)
        throw IllegalArgumentException("customStart: $customStart")
    } else if (customStart == 0 && customEnd != 3){
        // Custom Separator \\(O), \n(X)
        throw IllegalArgumentException("customEnd: $customEnd")
    } else {
        // Basic Calculator
        // TODO: Basic Calculator
    }
}

private fun printResult(result: String) {
    println(result)
}