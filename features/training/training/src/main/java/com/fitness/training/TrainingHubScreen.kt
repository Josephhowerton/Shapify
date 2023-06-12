package com.fitness.training.training

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fitness.shapify.theme.DarkBlack
import com.fitness.theme.R

@Preview(showBackground = true)
@Composable
private fun TrainingHubScreenPreview(){
    TrainingHubScreen()
}

@Composable
fun TrainingHubScreen() = Column(
    modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(5.dp),
    horizontalAlignment = Alignment.CenterHorizontally
) {

    Card(colors = CardDefaults.cardColors(), modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(bottom = 5.dp)) {

        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(text = "Weight Lifting", fontSize = 24.sp, textAlign = TextAlign.Center, modifier = Modifier.wrapContentSize())
//            Image(painter = painterResource(id = R.drawable.pexels_estudio_polaroid_3112004), contentDescription = "", alpha = .25f, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
        }

    }

    Card(colors = CardDefaults.cardColors(), modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(bottom = 5.dp)) {

        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(text = "Boxing", fontSize = 24.sp, textAlign = TextAlign.Center, modifier = Modifier.wrapContentSize())
//            Image(painter = painterResource(id = R.drawable.pexels_ron_lach_8736743), contentDescription = "", alpha = .25f, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
        }

    }

    Card(colors = CardDefaults.cardColors(), modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(bottom = 5.dp)) {

        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(text = "MMA", fontSize = 24.sp, textAlign = TextAlign.Center, modifier = Modifier.wrapContentSize())
//            Image(painter = painterResource(id = R.drawable.pexels_pavel_danilyuk_6296013), contentDescription = "", alpha = .25f, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
        }
    }

    Card(colors = CardDefaults.cardColors(), modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(bottom = 5.dp)) {

        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(text = "Yoga", fontSize = 24.sp, textAlign = TextAlign.Center, modifier = Modifier.wrapContentSize())
//            Image(painter = painterResource(id = R.drawable.pexels_elina_fairytale_3822906), contentDescription = "", alpha = .25f, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
        }
    }

    Card(colors = CardDefaults.cardColors(), modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(bottom = 5.dp)) {

        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(text = "Cardio", fontSize = 24.sp, textAlign = TextAlign.Center, modifier = Modifier.wrapContentSize())
//            Image(painter = painterResource(id = R.drawable.pexels_andrea_piacquadio_3796802), contentDescription = "", alpha = .25f, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
        }
    }

    Card(colors = CardDefaults.cardColors(), modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(bottom = 5.dp)) {


        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(text = "Interval Training", fontSize = 24.sp, textAlign = TextAlign.Center, modifier = Modifier.wrapContentSize())
//            Image(painter = painterResource(id = R.drawable.pexels_li_sun_2294361), contentDescription = "", alpha = .25f, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
        }
    }
}