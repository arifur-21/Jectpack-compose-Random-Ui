package com.example.jectpackrandomuidesion.login_register.login_ui.login_use_case

import android.util.Patterns

class LoginValidation {
    fun executeEmail(email: String): ValidationResult{
        if (email.isBlank()){
            return ValidationResult(
                successfull = false,
                errorMessage = "the email can't be blank"
            )
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return ValidationResult(
                successfull = false,
                errorMessage = "that's not a valid email"
            )
        }
        return ValidationResult(successfull = true)
    }

    fun executePassword(password: String): ValidationResult{
        if (password.isBlank()){
            return ValidationResult(
                successfull = false,
                errorMessage = "the password can't be blank"
            )
        }
        if (password.length<=8){
            return ValidationResult(
                successfull = false,
                errorMessage = "The password needs to consist of at least 8 characters"
            )
        }
        val containsLetterAndDigits = password.any {it.isDigit() } && password.any { it.isLetter() }

        if (containsLetterAndDigits){
            return ValidationResult(
                successfull = false,
                errorMessage = "The password needs to contain at least one letter and digit"
            )
        }
        return ValidationResult(successfull = true)
    }
}