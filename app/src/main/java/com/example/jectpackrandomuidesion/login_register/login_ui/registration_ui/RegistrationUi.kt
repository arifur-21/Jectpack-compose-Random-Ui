package com.example.jectpackrandomuidesion.login_register.login_ui.registration_ui


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jectpackrandomuidesion.R
import com.example.jectpackrandomuidesion.login_register.login_ui.registration_ui.presentation.RegisterFromEvent
import com.example.jectpackrandomuidesion.login_register.login_ui.registration_ui.presentation.RegisterViewModel

@Composable
fun RegistrationUi(){

        val viewModel = viewModel<RegisterViewModel>()
        val state = viewModel.state
        val context = LocalContext.current



    Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(value = state.email , onValueChange ={
                viewModel.onEvent(RegisterFromEvent.EmailChange(it)) },
                isError = state.emailErrror != null,
                placeholder = { Text(text = "Enter your Email")},
                label = { Text(text = "Email")},
                trailingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_email),
                        contentDescription = "Email" )},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                modifier = Modifier.fillMaxWidth())
            if (state.emailErrror != null){
                Text(text = state.emailErrror,
                    color = MaterialTheme.colors.error,
                    modifier = Modifier.align(Alignment.End))
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(value = state.password , onValueChange ={
                viewModel.onEvent(RegisterFromEvent.PasswordChange(it)) },
                isError = state.passwordError != null,
                placeholder = { Text(text = "Enter your Password")},
                label = { Text(text = "Password")},
                trailingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                        contentDescription = "Password" )},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation())
            if (state.passwordError != null){
                Text(text = state.passwordError,
                    color = MaterialTheme.colors.error,
                    modifier = Modifier.align(Alignment.End))
            }

            Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = state.password, onValueChange ={
            viewModel.onEvent(RegisterFromEvent.RepeatedPasswordChange(it))},
            isError = state.repeatedPasswordError != null,
            placeholder = { Text(text = "Enter your repeated password")},
            label = { Text(text = "Confrom Password")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation())

            if (state.repeatedPasswordError != null){
                Text(text = state.repeatedPasswordError,
                    color = MaterialTheme.colors.error,
                    modifier = Modifier.align(Alignment.End))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = state.acceptedTerms, onCheckedChange = {
                    viewModel.onEvent(RegisterFromEvent.AcceptTerms(it))
                })
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Accept terms")
            }

            if (state.termsError != null){
                Text(text = state.termsError, color = MaterialTheme.colors.error)
            }
            Button(onClick = {
                viewModel.onEvent(RegisterFromEvent.submit) },
                modifier = Modifier.align(Alignment.End)
            ) {

                Text(text = "Submit")
            }

        }

    }

