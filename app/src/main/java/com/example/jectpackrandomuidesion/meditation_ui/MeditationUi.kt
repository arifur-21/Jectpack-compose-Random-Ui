package com.example.jectpackrandomuidesion.meditation_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jectpackrandomuidesion.R

@Composable
fun MeditationUi(){
    GeetingSection()
}
@Composable
@Preview
fun MeditPre(){
    Column {
        GeetingSection()
        Spacer(modifier = Modifier.height(10.dp))
        ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depressic", "Meditation"))
        CurrentMeditation()
    }
}

@Composable
fun GeetingSection(
    name: String = "Android"
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column {
            Text(text = "Good Morning, $name",
            style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold))
            Text(text = "Android jectpack compose", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        Icon(painter = painterResource(id = R.drawable.eye),
            contentDescription = "icon",
        modifier = Modifier.size(24.dp))
    }

}

@Composable
fun ChipSection(
    chips: List<String>
){

    var selectedChipIndex by remember{ mutableStateOf(0)}

    LazyRow{
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        if (selectedChipIndex == it) Color.Blue
                        else Color.Gray
                    )
                    .padding(8.dp)
            ){
                Text(text = chips[it], color = Color.White)
            }
        }
    }

}

@Composable
fun CurrentMeditation(color: Color = Color.LightGray){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            ){

        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Text(text = "Daily Thought", style = MaterialTheme.typography.h4)
            Text(text = "Meditation 3-10 min",
            style = MaterialTheme.typography.body1, fontSize = 20.sp,
            color = Color.White)
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.DarkGray)
                .padding(10.dp)
        ){
           Icon(painter = painterResource(id = R.drawable.ic_baseline_play_circle_outline_24),
               contentDescription = "Play", tint = Color.White,
           modifier = Modifier.size(30.dp))
        }

    }

}