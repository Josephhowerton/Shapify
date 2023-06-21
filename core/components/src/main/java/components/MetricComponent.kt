package components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.fitness.shapify.theme.PrimaryBlue
import com.fitness.shapify.util.DateTimeUtil
import java.util.Calendar

@Preview
@Composable
private fun MetricItemComponentPreview() {
    MetricItemComponent("C", "60g", PrimaryBlue, 15, Modifier)
}


@Preview
@Composable
private fun LongMetricItemComponentPreview() {
    LongMetricItemComponent(metric = "C", quantity = "60g", color = PrimaryBlue, textSize = 8, modifier = Modifier)
}




@Composable
fun MetricItemComponent(metric:String, quantity: String, color: Color, canvasSize: Int, modifier: Modifier) {
    ConstraintLayout(modifier = modifier) {

        val (cardRef, metricRef, quantityRef) = createRefs()

        Card(elevation = CardDefaults.cardElevation(3.dp), colors = CardDefaults.cardColors(containerColor = color), modifier = Modifier
            .size(canvasSize.dp)
            .constrainAs(cardRef) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            }){}

        Text(text = metric, textAlign = TextAlign.Center, fontSize = (canvasSize/2).sp, fontWeight = FontWeight.Light,
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(metricRef) {
                    top.linkTo(cardRef.top)
                    start.linkTo(cardRef.start)
                    end.linkTo(cardRef.end)
                    bottom.linkTo(cardRef.bottom)
                })

        if(quantity.isNotEmpty()){
            Text(text = quantity, fontSize = (canvasSize/2).sp, fontWeight = FontWeight.Light, modifier = Modifier
                .wrapContentSize()
                .padding(start = 2.dp, end = 5.dp)
                .constrainAs(quantityRef) {
                    top.linkTo(cardRef.top)
                    bottom.linkTo(cardRef.bottom)
                    start.linkTo(cardRef.end)
                }
            )
        }
    }
}

@Composable
fun LongMetricItemComponent(metric: String, quantity: String, color: Color, modifier: Modifier, textSize: Int) {
    Card(elevation = CardDefaults.cardElevation(3.dp), colors = CardDefaults.cardColors(containerColor = color), modifier = Modifier.wrapContentSize()){
        ConstraintLayout(modifier = modifier
            .padding(5.dp)
            .wrapContentSize()) {

            val (metricRef, quantityRef) = createRefs()

            Text(text = "$metric: ", textAlign = TextAlign.Center, fontSize = textSize.sp, fontWeight = FontWeight.Light,
                modifier = Modifier
                    .wrapContentSize()
                    .constrainAs(metricRef) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    })

            Text(text = quantity, fontSize = textSize.sp, fontWeight = FontWeight.Light, modifier = Modifier
                .wrapContentSize()
                .constrainAs(quantityRef) {
                    top.linkTo(metricRef.top)
                    bottom.linkTo(metricRef.bottom)
                    start.linkTo(metricRef.end)
                }
            )
        }
    }
}