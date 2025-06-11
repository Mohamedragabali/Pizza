package com.example.pizza.ui.screens.custom_pizza

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizza.R
import com.example.pizza.ui.screens.custom_pizza.FivePizzaHased.FivePizza.listOfFiveTypePizza
import com.example.pizza.ui.screens.custom_pizza.composable.Header
import com.example.pizza.ui.screens.custom_pizza.utils.PizzaSize

@Composable
fun CustomPizzaScreen(
    modifier: Modifier
) {

    val pagerState: PagerState = rememberPagerState(
        pageCount = { 5 }
    )
    val breadList = listOf<Int>(
        R.drawable.bread_1,
        R.drawable.bread_2,
        R.drawable.bread_3,
        R.drawable.bread_4,
        R.drawable.bread_5
    )


    var buttonNumber by remember { mutableIntStateOf(listOfFiveTypePizza[pagerState.currentPage].pizzaSize.ordinal) }


    val onClickButtonOne = {
        listOfFiveTypePizza[pagerState.currentPage] =
            listOfFiveTypePizza[pagerState.currentPage].copy(pizzaSize = PizzaSize.SMALL )

        buttonNumber = PizzaSize.SMALL.ordinal
    }
    val onClickButtonTow = {
        listOfFiveTypePizza[pagerState.currentPage] =
            listOfFiveTypePizza[pagerState.currentPage].copy(pizzaSize = PizzaSize.MEDIUM )

        buttonNumber = PizzaSize.MEDIUM.ordinal
    }
    val onClickButtonThree = {
        listOfFiveTypePizza[pagerState.currentPage] =
            listOfFiveTypePizza[pagerState.currentPage].copy(pizzaSize = PizzaSize.LARGE )

        buttonNumber = PizzaSize.LARGE.ordinal
    }

    val transition = updateTransition(targetState = buttonNumber)

    val cardPaddingStart by transition.animateDp(label = "card padding start") {
        when (it) {
            PizzaSize.SMALL.ordinal -> {
                0.dp
            }

            PizzaSize.MEDIUM.ordinal -> {
                0.dp
            }

            else  -> {
                128.dp
            }
        }
    }

    val cardPaddingEnd by transition.animateDp(label = "card padding end") {
        when (it) {
            PizzaSize.SMALL.ordinal -> {
                128.dp
            }

            PizzaSize.MEDIUM.ordinal -> {
                0.dp
            }

            else -> {
                0.dp
            }
        }
    }
    val breadSize by transition.animateDp(label = "image Size") {
        when (it) {
            PizzaSize.SMALL.ordinal -> {
                200.dp
            }

            PizzaSize.MEDIUM.ordinal -> {
                210.dp
            }

            else -> {
                220.dp
            }

        }
    }

    when(pagerState.currentPage){
        0->{
            buttonNumber = listOfFiveTypePizza[0].pizzaSize.ordinal
        }
        1 ->{
            buttonNumber = listOfFiveTypePizza[1].pizzaSize.ordinal
        }
        2->{
            buttonNumber = listOfFiveTypePizza[2].pizzaSize.ordinal
        }
        3->{
            buttonNumber = listOfFiveTypePizza[3].pizzaSize.ordinal
        }
        4->{
            buttonNumber = listOfFiveTypePizza[4].pizzaSize.ordinal
        }
    }
    CustomPizzaContent(
        pagerState = pagerState,
        breadList = breadList,
        onClickButtonOne = onClickButtonOne,
        onClickButtonTow = onClickButtonTow,
        onClickButtonThree = onClickButtonThree,
        breadSize = breadSize,

        cardPaddingStart = cardPaddingStart,
        cardPaddingEnd = cardPaddingEnd,
        modifier = modifier
    )
}


@Composable
private fun CustomPizzaContent(
    pagerState: PagerState,
    breadList: List<Int>,
    onClickButtonOne: () -> Unit,
    onClickButtonTow: () -> Unit,
    onClickButtonThree: () -> Unit,
    cardPaddingStart : Dp,
    cardPaddingEnd:Dp,
    breadSize: Dp,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
//        Header(
//            headerTitle = "Pizaa",
//            rightIcon = R.drawable.heart,
//            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
//        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.45f)
                .padding(vertical = 32.dp),
        ) {

            Image(
                painter = painterResource(R.drawable.plate),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)

            )


            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) { page ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(breadSize)
                            .animateContentSize(),
                        painter = painterResource(breadList[page]),
                        contentDescription = null
                    )
                }
            }

        }


//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(48.dp),
//            contentAlignment = Alignment.Center
//        ) {
//            Row(
//                modifier = Modifier.padding(start = cardPaddingStart , end =cardPaddingEnd),
//            ) {
//                Card(
//                    shape = CircleShape,
//                    colors = CardDefaults.cardColors(
//                        containerColor =androidx.
//                        compose.ui.graphics.Color(0xDEFFFFFF)
//                        ,
//                    ),
//                    elevation = CardDefaults.cardElevation(
//                        defaultElevation = 18.dp
//                    ),
//                    modifier = Modifier
//                        .size(48.dp)
//                ) {
//                }
//            }
//
//            Text(
//                text = "S",
//                fontSize = 20.sp,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .padding(end = 128.dp)
//                .clickable(onClick = onClickButtonOne)
//            )
//
//
//
//            Text(
//                text = "M",
//                modifier = Modifier
//                    .clickable(onClick = onClickButtonTow),
//                fontSize = 20.sp,
//                textAlign = TextAlign.Center
//            )
//
//
//
//            Text(
//                text = "L",
//                modifier = Modifier
//                    .padding(start = 128.dp)
//                    .clickable(onClick = onClickButtonThree)
//                ,fontSize = 20.sp,
//                textAlign = TextAlign.Center
//            )
//
//
//        }


    }


}

@Preview(showSystemUi = true)
@Composable
fun CustomPizzaContentPreview(

) {
    var buttonNumber by remember { mutableIntStateOf(2) }

    val onClickButtonOne = { buttonNumber = 1 }
    val onClickButtonTow = { buttonNumber = 2 }
    val onClickButtonThree = { buttonNumber = 3 }

    val transition = updateTransition(targetState = buttonNumber)

    val cardPaddingStart by transition.animateDp(label = "card padding start") {
        when (it) {
            1 -> {
                0.dp
            }

            2 -> {
                0.dp
            }

            else -> {
                128.dp
            }
        }
    }
    val cardPaddingEnd by transition.animateDp(label = "card padding end") {
        when (it) {
            1 -> {
                128.dp
            }

            2 -> {
                0.dp
            }

            else -> {
                0.dp
            }
        }
    }

    val breadSize by transition.animateDp(label = "image Size") { it ->
        when (it) {
            1 -> {
                200.dp
            }

            2 -> {
                210.dp
            }

            else -> {
                220.dp
            }
        }
    }

//    CustomPizzaContent(
//        pagerState = rememberPagerState(
//            pageCount = { 5 }
//        ),
//        breadList = listOf(R.drawable.bread_1, R.drawable.bread_2, R.drawable.bread_3),
//        onClickButtonOne = onClickButtonOne,
//        onClickButtonTow = onClickButtonTow,
//        onClickButtonThree = onClickButtonThree,
//
//        cardPaddingStart = cardPaddingStart,
//        cardPaddingEnd = cardPaddingEnd,
//
//        breadSize = breadSize,
//        modifier = Modifier.padding(vertical = 48.dp)
//    )
}