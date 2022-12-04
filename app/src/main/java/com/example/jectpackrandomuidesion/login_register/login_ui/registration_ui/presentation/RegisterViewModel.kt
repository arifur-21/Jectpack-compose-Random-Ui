package com.example.jectpackrandomuidesion.login_register.login_ui.registration_ui.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.jectpackrandomuidesion.login_register.login_ui.registration_ui.RegisterValidation
import com.example.jectpackrandomuidesion.login_register.login_ui.registration_ui.register_use_case.RegisterFromState

class RegisterViewModel(
    val registerValidation: RegisterValidation = RegisterValidation()
): ViewModel() {

    //// obj in model class
    var state by mutableStateOf(RegisterFromState())


    /// model class get data from sealed class
    fun onEvent(event: RegisterFromEvent){
        when(event){
            is RegisterFromEvent.EmailChange->{
                state = state.copy(email = event.email)
            }
            is RegisterFromEvent.PasswordChange->{
                state = state.copy(password = event.password)
            }
            is RegisterFromEvent.RepeatedPasswordChange->{
                state = state.copy(repeatedPassword = event.repeatedPassword)
            }
            is RegisterFromEvent.AcceptTerms->{
                state = state.copy(acceptedTerms = event.isAccepted)
            }
            is RegisterFromEvent.submit->{
                submitData()
            }
        }

    }

    private fun submitData(){
        val emailResult = registerValidation.emailExecute(state.email)
        val passwordResult = registerValidation.passwordExectue(state.password)
        val repeatedpasswordResult = registerValidation.repetedPasswordExecute(state.password, state.repeatedPassword)
        val tremsResutl = registerValidation.executeTerm(state.acceptedTerms)

        ///model class get error from Register validation method
        val hasError = listOf(
            emailResult,
            passwordResult,
            repeatedpasswordResult,
            tremsResutl
        ).any { it.successfull }

        if (hasError){
            state = state.copy(
                emailErrror = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                repeatedPasswordError = repeatedpasswordResult.errorMessage,
                termsError = tremsResutl.errorMessage
            )
            return
        }
    }

}

