package com.example.jectpackrandomuidesion.login_register.login_ui.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jectpackrandomuidesion.login_register.login_ui.login_use_case.LoginFromState
import com.example.jectpackrandomuidesion.login_register.login_ui.login_use_case.LoginValidation
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginValidation: LoginValidation = LoginValidation()
): ViewModel() {

    var state by mutableStateOf(LoginFromState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: LoginFromEvent){

        when(event){
            is LoginFromEvent.EmailChange->{
                state = state.copy(email = event.email)
            }
            is LoginFromEvent.PasswordChange->{
                state = state.copy(password = event.password)
            }
            is LoginFromEvent.submit ->{
                SubmitData()
            }
        }

    }

    private fun SubmitData(){

        val emailResult = loginValidation.executeEmail(state.email)
        val passwordResult = loginValidation.executePassword(state.password)

        val hashError = listOf(
            emailResult,
            passwordResult
        ).any { it.successfull }

        if (hashError){
            state = state.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage
            )
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }



    sealed class ValidationEvent{
        object Success: ValidationEvent()
    }

}