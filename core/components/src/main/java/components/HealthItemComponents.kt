package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.fitness.framework.extensions.Dark
import com.fitness.framework.extensions.Light
import com.fitness.shapify.theme.PrimaryBlue
import com.fitness.shapify.theme.ShapifyTheme
import com.fitness.theme.R

@Light
@Dark
@Composable
fun DailyHealthItemComponent(modifier: Modifier = Modifier, mealItem: List<Any> = listOf()) {
    ShapifyTheme {
        Card(
            elevation = CardDefaults.cardElevation(3.dp),
            colors = CardDefaults.cardColors(),
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            ConstraintLayout(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(10.dp)
            ) {
                val (ingredient1Ref, ingredient2Ref, ingredient3Ref, ingredient4Ref, metricsRef, timeRef) = createRefs()

                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .padding(10.dp)
                    .wrapContentSize()
                    .constrainAs(metricsRef) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(timeRef.top)
                        start.linkTo(ingredient1Ref.end)
                    }
                ) {
                    MetricItemComponent(
                        metric = "C",
                        "60g",
                        color = PrimaryBlue,
                        25,
                        Modifier.padding(5.dp)
                    )
                    MetricItemComponent(
                        metric = "c",
                        "60g",
                        color = PrimaryBlue,
                        25,
                        Modifier.padding(5.dp)
                    )

                    MetricItemComponent(
                        metric = "f",
                        "60g",
                        color = PrimaryBlue,
                        25,
                        Modifier.padding(5.dp)
                    )
                    MetricItemComponent(
                        metric = "p",
                        "60g",
                        color = PrimaryBlue,
                        25,
                        Modifier.padding(5.dp)
                    )
                }

                Text(
                    text = "temporary",
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .constrainAs(ingredient1Ref) {
                            top.linkTo(parent.top, 5.dp)
                            start.linkTo(parent.start)
                        })

                Text(
                    text = "temporary",
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .constrainAs(ingredient2Ref) {
                            top.linkTo(ingredient1Ref.bottom, 5.dp)
                            start.linkTo(parent.start)
                        })

                Text(
                    text = "temporary",
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .constrainAs(ingredient3Ref) {
                            top.linkTo(ingredient2Ref.bottom, 5.dp)
                            start.linkTo(parent.start)
                        })

                Text(
                    text = "...",
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .constrainAs(ingredient4Ref) {
                            top.linkTo(ingredient3Ref.bottom, 5.dp)
                            start.linkTo(parent.start)
                        })

                Text(
                    text = "Scheduled for 8 AM",
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .constrainAs(timeRef) {
                            bottom.linkTo(parent.bottom)
                            end.linkTo(parent.end)
                        })
            }
        }
    }
}

@Light
@Dark
@Composable
fun WeeklyHealthItemComponent(modifier: Modifier = Modifier, mealItem: List<Any> = listOf()) {
    ShapifyTheme {
        Card(
            elevation = CardDefaults.cardElevation(3.dp),
            colors = CardDefaults.cardColors(),
            modifier = modifier.wrapContentSize()
        ) {
            ConstraintLayout(
                Modifier
                    .wrapContentSize()
                    .padding(10.dp)
            ) {

                val (dayOfWeekRef, metricsRef) = createRefs()

                Column(modifier = Modifier
                    .wrapContentSize()
                    .constrainAs(metricsRef) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        start.linkTo(dayOfWeekRef.end)
                    }
                ) {
                    Row(Modifier.padding(5.dp)) {
                        MetricItemComponent(
                            metric = "C",
                            "60g",
                            color = PrimaryBlue,
                            25,
                            Modifier.padding(5.dp)
                        )
                        MetricItemComponent(
                            metric = "c",
                            "60g",
                            color = PrimaryBlue,
                            25,
                            Modifier.padding(5.dp)
                        )
                    }

                    Row(Modifier.padding(5.dp)) {
                        MetricItemComponent(
                            metric = "f",
                            "60g",
                            color = PrimaryBlue,
                            25,
                            Modifier.padding(5.dp)
                        )
                        MetricItemComponent(
                            metric = "p",
                            "60g",
                            color = PrimaryBlue,
                            25,
                            Modifier.padding(5.dp)
                        )
                    }
                }

//            MetricItemComponent(
//                metric = DateTimeUtil.getDayOfWeek(date).substring(0,2),
//                quantity = "",
//                color = NeonBlue035EE8,
//                canvasSize = 25,
//                modifier = Modifier
//                    .padding(10.dp)
//                    .constrainAs(dayOfWeekRef) {
//
//                    }
//            )
            }
        }
    }
}

@Light
@Dark
@Composable
fun MonthlyHealthItemComponent(modifier: Modifier = Modifier, mealItem: List<Any> = listOf()) {
    ShapifyTheme {
        Card(
            elevation = CardDefaults.cardElevation(3.dp),
            colors = CardDefaults.cardColors(),
            modifier = modifier
                .wrapContentSize()
        ) {
            ConstraintLayout(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(10.dp)
            ) {
                val (ingredient1Ref, metricsRef) = createRefs()

                Column(modifier = Modifier
                    .padding(10.dp)
                    .wrapContentSize()
                    .constrainAs(metricsRef) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
                ) {
                    Row(Modifier.padding(5.dp)) {
                        MetricItemComponent(
                            metric = "C",
                            "60g",
                            color = PrimaryBlue,
                            25,
                            Modifier.padding(5.dp)
                        )
                        MetricItemComponent(
                            metric = "c",
                            "60g",
                            color = PrimaryBlue,
                            25,
                            Modifier.padding(5.dp)
                        )
                    }

                    Row(Modifier.padding(5.dp)) {
                        MetricItemComponent(
                            metric = "f",
                            "60g",
                            color = PrimaryBlue,
                            25,
                            Modifier.padding(5.dp)
                        )
                        MetricItemComponent(
                            metric = "p",
                            "60g",
                            color = PrimaryBlue,
                            25,
                            Modifier.padding(5.dp)
                        )
                    }
                }

//            val df = SimpleDateFormat("MMM dd yyyy", Locale.getDefault())
//
//            Text(
//                text = "${df.format(weekTimeline[weekTimeline.lastIndex])} -\n ${df.format(weekTimeline[0])}",
//                fontWeight = FontWeight.Light,
//                modifier = Modifier
//                    .padding(end = 5.dp)
//                    .constrainAs(ingredient1Ref) {
//                        top.linkTo(parent.top, 5.dp)
//                        start.linkTo(parent.start)
//                    })
            }
        }
    }
}

@Light
@Dark
@Composable
fun BlankItemComponent(modifier: Modifier = Modifier) {
   ShapifyTheme {
       Card(
           elevation = CardDefaults.cardElevation(3.dp),
           colors = CardDefaults.cardColors(),
           modifier = modifier
               .fillMaxWidth()
               .wrapContentHeight()
       ) {
           Column(
               verticalArrangement = Center,
               horizontalAlignment = CenterHorizontally,
               modifier = Modifier
                   .fillMaxWidth()
                   .height(125.dp)
                   .padding(10.dp)
           ) {
               Icon(
                   painter = painterResource(id = R.drawable.icon_add_more),
                   contentDescription = ""
               )
           }
       }
   }
}

@Light
@Dark
@Composable
fun NoDataDisplayedItemComponent(modifier: Modifier = Modifier) {
    ShapifyTheme {
        Card(
            elevation = CardDefaults.cardElevation(3.dp),
            colors = CardDefaults.cardColors(),
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(
                verticalArrangement = Center,
                horizontalAlignment = CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(125.dp)
                    .padding(10.dp)
            ) {
                Text(text = "No Data Displayed")
            }
        }
    }

}
