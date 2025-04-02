package com.example.recompositiontest.immutableTest

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.collections.immutable.ImmutableList


@Composable
fun ImmutableRecompositionScreen(
    modifier: Modifier = Modifier,
    viewModel: ImmutableRecompositionScreenViewModel = viewModel()
) {
    val uiModel by viewModel.uiModel.collectAsState()

    Column(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = uiModel.checked,
                onCheckedChange = {
                    viewModel.setCheck(it)
                }
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(text = "Check Box")
        }

        TestItems(list = uiModel.items)
    }
}

@Composable
private fun TestItems(
    list: ImmutableList<String>
) {
    Column {
        list.forEach {
            TestItem(content = it)
        }
    }
}


@Composable
private fun TestItem(
    content: String,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = content)
    }
}
