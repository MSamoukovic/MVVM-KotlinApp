package com.example.kotlinmvvm.presentation.users.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.kotlinmvvm.domain.model.UserModel

@Composable
fun UserItem(
    user:UserModel
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(2.dp,Color.DarkGray, RoundedCornerShape(10.dp))
            .background(Color.LightGray)
            .padding(10.dp)

    ) {

        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = rememberImagePainter(user.avatar),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .border(2.dp, Color.White, CircleShape)
                    .clip(CircleShape)
            )
        }

       Column(
           modifier = Modifier
               .fillMaxHeight()
               .padding(start  = 10.dp)
               .background(color = Color.Gray)
               .align(CenterVertically)
               .border(1.dp, Color.DarkGray, RoundedCornerShape(10.dp))
               .clip(RoundedCornerShape(10.dp))
               .padding(10.dp)

       ) {
           Text(
               text = user.firstName + " " + user.lastName,
               modifier = Modifier
                   .fillMaxWidth()
           )
           Text(
               text = user.email,
               modifier = Modifier
                   .fillMaxWidth()
           )
       }
    }
}