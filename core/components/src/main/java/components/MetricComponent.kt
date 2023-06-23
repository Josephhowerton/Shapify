package components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.fitness.framework.extensions.Dark
import com.fitness.framework.extensions.Light
import com.fitness.shapify.theme.PrimaryBlue
import com.fitness.shapify.theme.ShapifyTheme
import com.fitness.shapify.util.DateTimeUtil
import java.util.Calendar

@Light
@Dark
@Composable
fun MetricItemComponent(
    modifier: Modifier = Modifier,
    metric:String = "C",
    quantity: String = "60g",
    color: Color = PrimaryBlue,
    canvasSize: Int = 15
) {
    ShapifyTheme {
        Surface {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier
                .wrapContentSize()
                .padding(1.dp)) {

                Card(
                    elevation = CardDefaults.cardElevation(3.dp),
                    colors = CardDefaults.cardColors(containerColor = color),
                    modifier = Modifier.size(canvasSize.dp))
                {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = metric,
                            textAlign = TextAlign.Center,
                            fontSize = (canvasSize/2).sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.wrapContentSize()
                        )
                    }
                }

                Spacer(modifier = Modifier.size(2.dp))

                Text(text = quantity,
                    fontSize = (canvasSize/2).sp,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}

@Light
@Dark
@Composable
fun LongMetricItemComponent(
    modifier: Modifier = Modifier,
    metric:String = "C",
    quantity: String = "60g",
    color: Color = PrimaryBlue,
    textSize: Int = 8
) {
    ShapifyTheme {
        Surface {
            Card(
                elevation = CardDefaults.cardElevation(3.dp),
                colors = CardDefaults.cardColors(containerColor = color),
                modifier = modifier
                    .wrapContentSize()
                    .padding(1.dp))
            {
                Box(contentAlignment = Alignment.Center, modifier = Modifier
                    .wrapContentSize()
                    .padding(3.dp)){
                    Text(
                        text = "$metric: $quantity",
                        textAlign = TextAlign.Center,
                        fontSize = textSize.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.wrapContentSize()
                    )
                }
            }
        }
    }
}