package com.example.jectpackrandomuidesion.login_register.login_ui.registration_ui

import android.util.Patterns
import com.example.jectpackrandomuidesion.login_register.login_ui.registration_ui.register_use_case.ValidationResult

class RegisterValidation {

    fun emailExecute(email: String): ValidationResult{
       if (email.isBlank()){
           return ValidationResult(
               successfull = false,
               errorMessage = "The email can't be blank"
           )
       }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return ValidationResult(
                successfull = false,
                errorMessage = "That's not a valid email"
            )
        }
        return ValidationResult(successfull = true)
    }


    fun passwordExectue(passwore: String): ValidationResult{
        if (passwore.isBlank()){
            return ValidationResult(
                successfull = false,
                errorMessage = "The password can't be blank"
            )
        }
        if (passwore.length <= 8){
            return ValidationResult(
                successfull = false,
                errorMessage = "The password needs to consist of at least 8 character"
            )
        }

        val containsLettersAndDigits = passwore.any { it.isDigit() } && passwore.any { it.isLetter() }

        if (containsLettersAndDigits){
            return ValidationResult(
                successfull = false,
                errorMessage = "The password needs to contain at least on letter and digit"
            )
        }
        return ValidationResult(successfull = true)
    }


    fun repetedPasswordExecute(password: String, repeatedPassword: String): ValidationResult{

        if (password != repeatedPassword){
            return ValidationResult(
                successfull = false,
                errorMessage = "The Password don't Match"
            )
        }
        return ValidationResult(successfull = true)
    }

    fun executeTerm(acceptTerms: Boolean): ValidationResult{
        if (!acceptTerms){
            return ValidationResult(
                successfull = false,
                errorMessage = "Please accept the terms"
            )
        }
        return ValidationResult(successfull = true)
    }
}