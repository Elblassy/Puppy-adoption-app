package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.models.PuppyModel
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                val puppy = PuppyModel(
                    intent.getStringExtra("name") ?: "",
                    intent.getStringExtra("des") ?: "",
                    intent.getIntExtra("image", 0)
                )
                DetailsPuppy(puppy)
            }
        }
    }
}

@Composable
fun DetailsPuppy(puppy: PuppyModel) {
    Scaffold() {
        Column {
            Image(
                painter = painterResource(id = puppy.image),
                contentDescription = null,
                modifier = Modifier
                    .padding(12.dp)
                    .height(280.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(modifier = Modifier.padding(12.dp), text = puppy.name)
            Text(modifier = Modifier.padding(12.dp), text = puppy.des)
        }
    }
}
