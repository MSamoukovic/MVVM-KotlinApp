package com.example.kotlinmvvm.presentation.user

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinmvvm.common.Constants
import com.example.kotlinmvvm.common.Resource
import com.example.kotlinmvvm.domain.use_case.get_user.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(UserState())
    val state: State<UserState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_USER_ID)?.let { id ->
            getUser(id.toInt())
        }
    }

    private fun getUser(userID: Int) {
        getUserUseCase(userID).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = UserState(user = result.data)
                }
                is Resource.Error -> {
                    _state.value = UserState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = UserState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}