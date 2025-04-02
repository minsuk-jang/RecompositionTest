package com.example.recompositiontest.immutableTest

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class ImmutableRecompositionUiModel(
    val checked: Boolean = false,
    val items: ImmutableList<String> = persistentListOf("1", "2", "3", "4", "5", "6")
)

class ImmutableRecompositionScreenViewModel : ViewModel() {
    private val _uiModel: MutableStateFlow<ImmutableRecompositionUiModel> = MutableStateFlow(
        ImmutableRecompositionUiModel()
    )
    val uiModel: StateFlow<ImmutableRecompositionUiModel> = _uiModel.asStateFlow()

    fun setCheck(check: Boolean) {
        _uiModel.update {
            it.copy(
                checked = check
            )
        }
    }
}