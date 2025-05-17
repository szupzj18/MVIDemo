package com.example.mvidemo.ui.mvvm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CounterScreen(viewModel: CounterViewModel = viewModel()) {
    val count by viewModel.count.collectAsState()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "MVVM Counter", style = MaterialTheme.typography.titleLarge)
        Text(text = count.toString(), style = MaterialTheme.typography.displayLarge)

        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = viewModel::onDecrement) { Text("−") }
            Spacer(Modifier.width(24.dp))
            Button(onClick = viewModel::onIncrement) { Text("+") }
        }
    }
}