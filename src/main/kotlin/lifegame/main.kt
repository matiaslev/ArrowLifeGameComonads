package lifegame

fun main() {
    var notStarted = true
    var state: List<List<Cell>> = listOf(emptyList())
    while (true) {
        state = step(state, if (notStarted) ConwayAction.select else ConwayAction.stepSimulation)
        showGame(state)
        notStarted = false
        Thread.sleep(1000)
    }
}

fun step(state: List<List<Cell>>, action: ConwayAction): List<List<Cell>> = when(action) {
        is ConwayAction.stepSimulation -> gameOfLife(state)
        is ConwayAction.select -> Pattern.beacon.grid()
    }

fun showGame(state: List<List<Cell>>) {
    state.forEachIndexed { index1, list ->
        println()
        list.forEachIndexed { index2, cell ->
           print(state[index2][index1].description())
        }
    }
    println("\n\n\n")
}
