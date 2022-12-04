package com.example.jectpackrandomuidesion.login_register.login_ui.login_use_case

data class LoginFromState (
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null
        )