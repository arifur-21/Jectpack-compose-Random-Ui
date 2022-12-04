package com.example.jectpackrandomuidesion.login_register.login_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jectpackrandomuidesion.ui.theme.purplish
import com.example.jectpackrandomuidesion.R

@Composable
fun LoginPage() {
    var email by remember{ mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("")}
    var passwordVisibility by remember{ mutableStateOf(false)}

    val icon = if (passwordVisibility) painterResource(id = R.drawable.eye)
                else painterResource(id = R.drawable.hidden)



        Scaffold(
            backgroundColor = purplish,
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_cleaning),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .weight(1.2f)
                        .size(200.dp)
                )

                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(2f),
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.White)
                    ) {

                       Column(
                           modifier = Modifier
                               .padding(16.dp),
                           horizontalAlignment = Alignment.CenterHorizontally,
                           verticalArrangement = Arrangement.Center
                       ) {
                           Spacer(modifier = Modifier.height(20.dp))
                           Text(text = "Login Page",
                               fontSize = 30.sp,
                               fontWeight = FontWeight.Bold)

                           Spacer(modifier = Modifier.height(30.dp))
                           
                           OutlinedTextField(value = email , onValueChange ={
                            email = it },

                               placeholder = { Text(text = "Enter your Email")},
                               label = { Text(text = "Email")},
                               trailingIcon = {
                                   Icon(painter = painterResource(id = R.drawable.ic_email),
                                       contentDescription = "Email" )},
                               keyboardOptions = KeyboardOptions(
                                   keyboardType = KeyboardType.Email
                               ),
                               modifier = Modifier.fillMaxWidth())

                           Spacer(modifier = Modifier.height(16.dp))


                           OutlinedTextField(value = password , onValueChange ={
                               if (it.length <= 8){
                                   password = it
                               } },
                               placeholder = { Text(text = "Enter your Password")},
                               label = { Text(text = "Password")},
                               trailingIcon = {
                                   IconButton(onClick = {
                                       passwordVisibility = !passwordVisibility
                                   }) {
                                       Icon(painter = icon, contentDescription = "Lock",
                                       modifier = Modifier.size(25.dp))
                                   }
                                 },
                               keyboardOptions = KeyboardOptions(
                                   keyboardType = KeyboardType.Password
                               ),
                               visualTransformation = if (passwordVisibility)
                                   VisualTransformation.None
                                           else PasswordVisualTransformation(),

                               modifier = Modifier.fillMaxWidth())

                           Text(text = "Forgot Password",
                               modifier = Modifier
                                   .padding(8.dp)
                                   .align(Alignment.End)
                                   .clickable {

                                   },
                               fontSize = 16.sp,
                               fontFamily = FontFamily.SansSerif,
                           )
                           Spacer(modifier = Modifier.height(16.dp))

                           Button(onClick = {

                           }, modifier = Modifier
                               .fillMaxWidth()
                               ) {
                               Text(text = "Login",
                                   fontWeight = FontWeight.Bold,
                                   fontSize = 20.sp)
                           }


                       }

                    }


                }

            }

        }

    }




@Preview
@Composable
fun PreviewLogin(){
    LoginPage()
}
