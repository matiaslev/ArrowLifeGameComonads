package lifegame

sealed class ConwayAction {
    object stepSimulation: ConwayAction()
    object select: ConwayAction()
}