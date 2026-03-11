    package com.example.comandespizza

    import androidx.compose.runtime.mutableStateListOf
    import androidx.lifecycle.ViewModel

    class LifecycleViewModel : ViewModel() {

        val events = mutableStateListOf<String>()

        fun addEvent(event: String) {
            events.add(event)
        }

        fun reset() {
            events.clear()
        }


    }