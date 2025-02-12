import kotlin.time.measureTime

fun main() {
    greetSeaCreatures()
    println(findPearl(6))
    println(divideTreasure(1000.0,5.0))
    println(calculateDepth(1500, 800, depthDifference))
    println(diveMessage("deep sea"))
    exploreWaters { println("Exploring the unknown depths...") }
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

// Bonus
// I'm not entirely sure of my solution since inline has many syntaxes I just chose the simplest looking one
// Used Long instead of Int because I got an error using Int since .currentTimeMillis() is a Long data Type

inline fun exploreWaters(explore: () -> Unit) {
    val duration = measureTime {
        Thread.sleep(200)
    }
    explore()
    println("Time taken: $duration milliseconds")
}