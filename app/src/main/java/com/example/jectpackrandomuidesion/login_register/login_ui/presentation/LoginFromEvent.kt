package com.example.jectpackrandomuidesion.login_register.login_ui.presentation

sealed class LoginFromEvent{
    data class EmailChange(val email: String): LoginFromEvent()
    data class PasswordChange(val password: String): LoginFromEvent()
    object submit: LoginFromEvent()
}
