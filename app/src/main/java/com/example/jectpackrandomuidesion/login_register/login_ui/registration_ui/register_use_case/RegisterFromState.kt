package com.example.jectpackrandomuidesion.login_register.login_ui.registration_ui.register_use_case

data class RegisterFromState(
    val email: String = "",
    val emailErrror: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val repeatedPassword: String = "",
    val repeatedPasswordError: String? = null,
    val acceptedTerms: Boolean = false,
    val termsError: String? = null
)
