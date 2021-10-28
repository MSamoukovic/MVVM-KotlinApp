package com.example.kotlinmvvm.presentation.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvm.common.Resource
import com.example.kotlinmvvm.domain.use_case.get_users.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import androidx.lifecycle.viewModelScope


@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _state = mutableStateOf(UsersListState())
    val state: State<UsersListState> = _state

    init {
        getUsers()
    }

    private fun getUsers() {
        getUsersUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = UsersListState(users = result.data?.data ?: emptyList(), totalPages = result.data?.totalPages ?: 0)
                }
                is Resource.Error -> {
                    _state.value = UsersListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = UsersListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}