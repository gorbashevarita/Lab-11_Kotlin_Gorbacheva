package gameCharacter

fun main() {
    val hero = GameCharacter("Герой")

    hero.changeState(CharacterState.Running)
    handleState(hero.state)

    hero.changeState(CharacterState.Attack(damage = 25))
    handleState(hero.state)

    hero.changeState(CharacterState.Death(reason = "убит мечом противника"))
    handleState(hero.state)
}

fun handleState(state: CharacterState) {
    when (state) {
        CharacterState.Idle -> println("Персонаж бездействует")
        CharacterState.Running -> println("Персонаж бежит")
        is CharacterState.Attack -> println("Персонаж атакует с уроном ${state.damage}")
        is CharacterState.Death -> println("Персонаж погиб: ${state.reason}")
    }
}
