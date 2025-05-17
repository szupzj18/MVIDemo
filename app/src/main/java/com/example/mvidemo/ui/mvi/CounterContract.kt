package com.example.mvidemo.ui.mvi

data class CounterState(val value: Int = 0)

sealed interface CounterIntent {
    object Increment : CounterIntent
    object Decrement : CounterIntent
}

fun reduce(state: CounterState, intent: CounterIntent): CounterState =
    when (intent) {
        CounterIntent.Increment -> state.copy(value = state.value + 1)
        CounterIntent.Decrement -> state.copy(value = state.value - 1)
    }