fun main() {
    greetSeaCreatures()
    println(findPearl(6))
    println(divideTreasure(1000.0,5.0))
    println(calculateDepth(1500, 800, depthDifference))
    println(diveMessage("deep sea"))
    exploreWaters {
        println("Exploring the unknown depths...")
    }
}

// Part 1 with 2 solutions one is commented out. Used Unit because this lambda function has no parameters and it returns nothing.
val greetSeaCreatures: () -> Unit = { println("Hello, Deep Sea Adventurer!") }
//val greetSeaCreatures = { println("Hello, Deep Sea Adventurer!") }

// Part 2 with 2 solutions one is commented out
val findPearl: (Int) -> Int = { numOfPearls -> numOfPearls * numOfPearls }
//val findPearl = { numOfPearls: Int -> numOfPearls * numOfPearls }

// Part 3 with 2 solutions one is commented out
val divideTreasure = { treasure: Double, explorers: Double -> treasure / explorers}
//val divideTreasure: (Double, Double) -> Double = {treasure, explorers -> treasure/explorers }

// Part 4 Higher Order Functions
fun calculateDepth(x: Int, y: Int, differenceFunction: (Int, Int) -> Int): Int {
    return differenceFunction(x, y)
}

val depthDifference: (Int, Int) -> Int = { x, y -> x-y }

// Part 5 Extension Functions
fun String.loud(): String {
    return this.uppercase() + "!"
}

val diveMessage: (String) -> String = {message -> message.loud()}

/*
Bonus Challenge: Lambda as an Inline Function – Exploring Uncharted Waters
Step 1: Define an inline function named exploreWaters that takes a lambda function as a parameter.
Step 2: Inside exploreWaters, record the start and end time of exploring uncharted waters, execute the lambda function, and print the time taken.
Step 3: Call exploreWaters with a lambda that prints "Exploring the unknown depths...".
Expected Output:
Exploring the unknown depths...
Time taken: X milliseconds
*/

// I'm not entirely sure of my solution since inline has many syntaxes I just chose the simplest looking one
// The wording of Step 2 implies performing the calculation then executing the lambda function which is why I opted using a Unit lambda function since it's not needed for the calculation
inline fun exploreWaters(explore: () -> Unit) {
    // Hardcoded the 50000 to simulate exploring the waters for 50 seconds
    val startTime = System.currentTimeMillis()
    val endTime = System.currentTimeMillis() + 50000
    val duration = (endTime - startTime)
    explore()
    println("Time taken: $duration milliseconds")
}