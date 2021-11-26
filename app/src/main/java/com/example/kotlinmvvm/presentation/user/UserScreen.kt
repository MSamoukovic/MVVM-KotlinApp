package com.example.kotlinmvvm.presentation.user

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.kotlinmvvm.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview

fun UserScreen(
    viewModel: UserViewModel = hiltViewModel()
) {
    val state = viewModel.state.value


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Image(
            painter = rememberImagePainter(state.user?.avatar),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .border(2.dp, Color.White, CircleShape)
                .clip(CircleShape)
        )

        Text(
            text = state.user?.firstName + " " + state.user?.lastName,
                )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),


            horizontalArrangement = Arrangement.Center

        ) {


            val list = (1..6).map { it.toString() }
         LazyVerticalGrid(cells = GridCells.Fixed(2), modifier = Modifier
             .background(Color.White)
             .fillMaxWidth(),content ={
             items(list.size){
                 index ->
                 Card(
                     backgroundColor = Color.Red,
                     modifier = Modifier
                         .padding(10.dp)
                         .fillMaxWidth()
                 ) {
                     Column(
                         modifier = Modifier
                             .fillMaxWidth()
                             .background(Color.Gray),
                         horizontalAlignment = Alignment.CenterHorizontally
                     ){
                         Image(
                             painter = rememberImagePainter(state.user?.avatar),
                             contentDescription = null,
                             modifier = Modifier
                                 .size(100.dp)
                                 .border(2.dp, Color.Gray)
                         )


                         Text(
                             text = list[index] ,
                             modifier = Modifier
                                 .background(Color.Black)
                                 .padding(5.dp)
                                 .fillMaxWidth(),
                             color = Color.White,
                             textAlign = TextAlign.Center,


                             )
                     }

                 }

             }
         } )



        }
        val list2 = (1..6).map { it.toString() }
        LazyVerticalGrid( cells = GridCells.Fixed(1), content = {
            items(list2.size){
                    index ->
                Card (
                    modifier = Modifier
                        .padding(5.dp)
                        .background(Color.Green)
                        .fillMaxWidth(),
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null)
                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Gray)

                        ) {
                            Text(
                                text = stringResource(id = R.string.call_122),
                                modifier = Modifier.fillMaxWidth(),
                                fontSize = 30.sp
                            )
                            Text(text = stringResource(id = R.string.click_here))
                        }
                    }
                }
            }

        })


    }



}