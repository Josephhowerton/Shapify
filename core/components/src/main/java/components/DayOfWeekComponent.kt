package components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    metric:String = DateTimeUtil.getDayOfWeek(Calendar.getInstance().time).substring(0,2),
    color: Color = PrimaryBlue,
    canvasSize: Int = 15
) {
    ShapifyTheme {
        Surface {

            Card(
                elevation = CardDefaults.cardElevation(3.dp),
                colors = CardDefaults.cardColors(containerColor = color),
                modifier = Modifier.size(canvasSize.dp)
            )
            {

                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
                    Text(
                        text = metric,
                        textAlign = TextAlign.Center,
                        fontSize = (canvasSize/2).sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.wrapContentSize()
                    )
                }

            }
        }

    }
}