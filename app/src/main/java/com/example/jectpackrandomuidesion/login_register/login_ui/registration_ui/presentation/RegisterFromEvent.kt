package com.example.jectpackrandomuidesion.login_register.login_ui.registration_ui.presentation

sealed class RegisterFromEvent{
    data class EmailChange(val email: String): RegisterFromEvent()
    data class PasswordChange(val password: String): RegisterFromEvent()
    data class RepeatedPasswordChange(val repeatedPassword: String): RegisterFromEvent()
    data class AcceptTerms(val isAccepted: Boolean): RegisterFromEvent()
    object submit: RegisterFromEvent()
}
