package com.example.pizza.ui.screens.custom_pizza.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizza.R


@Composable
fun Header(
    headerTitle: String,
    modifier: Modifier = Modifier,
    rightIcon: Int? = null,
) {
    Row (
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.arrow_left),
            contentDescription = null ,
            tint = Color.Black,
            modifier = Modifier.size(32.dp)
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = headerTitle,
            color = Color.Black,
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.weight(1f))
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.heart),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun HeaderPreview(
){
    Header(
        headerTitle = "Header",
        rightIcon = R.drawable.heart,
        modifier = Modifier.padding(vertical = 46.dp)
    )
}