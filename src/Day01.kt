fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        var digitInt = 0
        var digitString = ""
        var wasFirstDigit = false

        var firstDigit = ' '
        var firstDigitIndex = 0

        var secondDigit = ' '
        var secondDigitIndex = 0

        //Iterate through the Day01.txt
        for (s in input) {

            //Iterate through the String's character
            for ((index, element) in s.withIndex()) {

                //Store the first digit character
                if (element.isDigit() && !wasFirstDigit) {
                    firstDigit = element
                    firstDigitIndex = index
                    wasFirstDigit = true
                }
                //Store the second character
                if (element.isDigit() && wasFirstDigit) {
                    secondDigit = element
                    secondDigitIndex = index

                }
            }
            //Make a two-digit number
            //There are first and second digit too
            if (firstDigit != ' ' && secondDigit != ' ') {
                digitString = "$firstDigit$secondDigit"
            }
            //There is only first digit
            if (firstDigit != ' ' && secondDigit == ' ') {
                digitString = "$firstDigit$firstDigit"
            }

            //Convert String to Int
            digitInt = digitString.toInt()

            //Addition of numbers
            sum += digitInt

            //Reset variable
            wasFirstDigit = false
        }
        return sum
    }
    fun stringIndexesFirst(s: String): MutableList<Pair<Int, String>> {

        val pairs = mutableListOf<Pair<Int, String>>()
        if (s.contains("one")) {

            pairs.add(Pair(s.indexOf("one"), "1"))
        }
        if (s.contains("two")) {

            pairs.add(Pair(s.indexOf("two"), "2"))
        }
        if (s.contains("three")) {

            pairs.add(Pair(s.indexOf("three"), "3"))
        }
        if (s.contains("four")) {

            pairs.add(Pair(s.indexOf("four"), "4"))
        }
        if (s.contains("five")) {

            pairs.add(Pair(s.indexOf("five"), "5"))
        }
        if (s.contains("six")) {

            pairs.add(Pair(s.indexOf("six"), "6"))
        }
        if (s.contains("seven")) {

            pairs.add(Pair(s.indexOf("seven"), "7"))
        }
        if (s.contains("eight")) {

            pairs.add(Pair(s.indexOf("eight"), "8"))
        }
        if (s.contains("nine")) {

            pairs.add(Pair(s.indexOf("nine"), "9"))
        }
        //println(pairs.minBy { it.first }.second)
        return pairs
    }

    fun stringIndexesSecond(s: String): MutableList<Pair<Int, String>> {

        val pairs = mutableListOf<Pair<Int, String>>()
        if (s.contains("one")) {

            pairs.add(Pair(s.lastIndexOf("one"), "1"))
        }
        if (s.contains("two")) {

            pairs.add(Pair(s.lastIndexOf("two"), "2"))
        }
        if (s.contains("three")) {

            pairs.add(Pair(s.lastIndexOf("three"), "3"))
        }
        if (s.contains("four")) {

            pairs.add(Pair(s.lastIndexOf("four"), "4"))
        }
        if (s.contains("five")) {

            pairs.add(Pair(s.lastIndexOf("five"), "5"))
        }
        if (s.contains("six")) {

            pairs.add(Pair(s.lastIndexOf("six"), "6"))
        }
        if (s.contains("seven")) {

            pairs.add(Pair(s.lastIndexOf("seven"), "7"))
        }
        if (s.contains("eight")) {

            pairs.add(Pair(s.lastIndexOf("eight"), "8"))
        }
        if (s.contains("nine")) {

            pairs.add(Pair(s.lastIndexOf("nine"), "9"))
        }
        //println(pairs.minBy { it.first }.second)
        return pairs
    }

    fun part2(input: List<String>): Int {

        var sum = 0
        var digitInt = 0
        var digitString = ""
        var wasFirstDigit = false

        var firstDigit = ' '
        var firstDigitIndex = 0

        var secondDigit = ' '
        var secondDigitIndex = 0

        var firstDigitStringIndex: Int? = 0
        var secondDigitStringIndex: Int? = 0


        //Iterate through the Day01.txt
        for (s in input) {

            //Iterate through the String's character
            for ((index, element) in s.withIndex()) {

                //Store the first digit character
                if (element.isDigit() && !wasFirstDigit) {
                    firstDigit = element
                    firstDigitIndex = index
                    wasFirstDigit = true
                }

                //Store the second digit character
                if (element.isDigit()) {
                    secondDigit = element
                    secondDigitIndex = index

                }
            }

            if (firstDigitIndex == secondDigitIndex && firstDigit != ' ') {
                secondDigit = ' '
            }

            //Store the first string number index
            firstDigitStringIndex =
                if (stringIndexesFirst(s).minByOrNull { it.first }?.first == null) 100 else stringIndexesFirst(s).minByOrNull { it.first }?.first

            //Store the last string number index
            secondDigitStringIndex =
                if (stringIndexesSecond(s).maxByOrNull { it.first }?.first == null) 100 else stringIndexesSecond(s).maxByOrNull { it.first }?.first

            if (firstDigitStringIndex == secondDigitStringIndex) {
                secondDigitStringIndex = 100
            }


            //Make a two-digit number
            //There are first and second digit too
            if (firstDigit != ' ' && secondDigit != ' ' && firstDigitStringIndex == 100 && secondDigitStringIndex == 100 || firstDigitIndex < firstDigitStringIndex!! && secondDigitIndex > secondDigitStringIndex!! && secondDigit != ' ') {
                digitString = "$firstDigit$secondDigit"
            }
            //There is only first digit
            if (firstDigit != ' ' && secondDigit == ' ' && firstDigitStringIndex == 100 && secondDigitStringIndex == 100 || firstDigitIndex < firstDigitStringIndex && secondDigitStringIndex == 100 && secondDigit == ' ' && firstDigitStringIndex == 100) {
                digitString = "$firstDigit$firstDigit"
            }

            //There is only one string number
            if (firstDigit == ' ' && secondDigit == ' ' && firstDigitStringIndex != 100 && secondDigitStringIndex == 100) {
                digitString =
                    "${stringIndexesFirst(s).minBy { it.first }.second}${stringIndexesFirst(s).minBy { it.first }.second}"
            }

            //There is two string number
            if (firstDigit == ' ' && secondDigit == ' ' && firstDigitStringIndex != 100 && secondDigitStringIndex != 100) {
                digitString =
                    "${stringIndexesFirst(s).minBy { it.first }.second}${stringIndexesSecond(s).maxBy { it.first }.second}"
            }

            //First is digit second is string number
            if (firstDigit != ' ' && secondDigit == ' ' && secondDigitStringIndex == 100 && firstDigitStringIndex != 100 && firstDigitIndex < firstDigitStringIndex) {
                digitString = "$firstDigit${stringIndexesFirst(s).minBy { it.first }.second}"
            }

            //First is string number second is digit
            if (firstDigit != ' ' && secondDigit == ' ' && secondDigitStringIndex == 100 && firstDigitStringIndex != 100 && firstDigitIndex > firstDigitStringIndex) {
                digitString = "${stringIndexesFirst(s).minBy { it.first }.second}$firstDigit"
            }

            //There is first, second digit and string numbers too
            if (firstDigit != ' ' && secondDigit != ' ' && secondDigitStringIndex != 100 && firstDigitStringIndex != 100 && firstDigitIndex < firstDigitStringIndex && secondDigitIndex < secondDigitStringIndex!!) {
                digitString = "$firstDigit${stringIndexesSecond(s).maxBy { it.first }.second}"
            }

            if (firstDigit != ' ' && secondDigit == ' ' && secondDigitStringIndex != 100 && firstDigitStringIndex != 100 && firstDigitIndex < firstDigitStringIndex) {
                digitString = "$firstDigit${stringIndexesSecond(s).maxBy { it.first }.second}"
            }

            if (firstDigit != ' ' && secondDigit == ' ' && secondDigitStringIndex != 100 && firstDigitStringIndex != 100 && firstDigitStringIndex < firstDigitIndex && firstDigitIndex > secondDigitStringIndex!!) {
                digitString = "${stringIndexesFirst(s).minBy { it.first }.second}$firstDigit"
            }

            if (firstDigit != ' ' && secondDigit != ' ' && firstDigitStringIndex != 100 && secondDigitStringIndex == 100 && secondDigitIndex > firstDigitStringIndex && firstDigitIndex < firstDigitStringIndex) {
                digitString = "$firstDigit$secondDigit"
            }
            if (firstDigit != ' ' && secondDigit != ' ' && firstDigitStringIndex != 100 && secondDigitStringIndex == 100 && firstDigitStringIndex < firstDigitIndex && firstDigitStringIndex < secondDigitIndex) {
                digitString = "${stringIndexesFirst(s).minBy { it.first }.second}$secondDigit"
            }

            if (firstDigit != ' ' && secondDigit != ' ' && firstDigitStringIndex < firstDigitIndex && secondDigitStringIndex!! > secondDigitIndex && firstDigitStringIndex != 100 && secondDigitStringIndex != 100) {
                digitString = "${stringIndexesFirst(s).minBy { it.first }.second}${stringIndexesSecond(s).maxBy { it.first }.second}"
            }

            if (firstDigit != ' ' && secondDigit != ' ' && firstDigitStringIndex  != 100 && secondDigitStringIndex != 100 && firstDigitStringIndex < firstDigitIndex && secondDigitIndex > secondDigitStringIndex!!) {
                digitString = "${stringIndexesFirst(s).minBy { it.first }.second}$secondDigit"
            }

            if (firstDigit != ' ' && secondDigit == ' ' && firstDigitStringIndex != 100 && secondDigitStringIndex != 100 && firstDigitStringIndex < firstDigitIndex && secondDigitStringIndex!! > firstDigitIndex ) {

                digitString = "${stringIndexesFirst(s).minBy { it.first }.second}${stringIndexesSecond(s).maxBy { it.first }.second}"
            }
            if (firstDigit != ' ' && secondDigit != ' ' && firstDigitStringIndex != 100 && secondDigitStringIndex == 100 && secondDigitIndex < firstDigitStringIndex && firstDigitIndex < firstDigitStringIndex) {
                digitString = "$firstDigit${stringIndexesFirst(s).minBy { it.first }.second}"
            }


            //Convert String to Int
            digitInt = digitString.toInt()

            //Addition of numbers
            sum += digitInt

            //Reset variable
            wasFirstDigit = false
        }

        return sum
    }


    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}


