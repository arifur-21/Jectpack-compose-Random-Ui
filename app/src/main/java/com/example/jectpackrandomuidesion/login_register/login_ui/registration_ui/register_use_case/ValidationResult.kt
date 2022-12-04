package com.example.jectpackrandomuidesion.login_register.login_ui.registration_ui.register_use_case

data class ValidationResult(
    val successfull: Boolean,
    val errorMessage: String? = null
)