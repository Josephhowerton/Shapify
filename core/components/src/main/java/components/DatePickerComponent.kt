package components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.fitness.framework.enums.TimelineConfiguration
import com.fitness.framework.extensions.Dark
import com.fitness.framework.extensions.Light
import com.fitness.shapify.theme.DarkBlack
import com.fitness.shapify.theme.PrimaryBlue
import com.fitness.shapify.theme.PrimaryWhite
import com.fitness.shapify.theme.ShapifyTheme
import com.fitness.shapify.util.DateTimeUtil
import com.fitness.theme.R
import dialog.dateTimePickerDialog
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Dark
@Light
@Composable
fun DatePickerComponent(
    modifier: Modifier = Modifier,
    configuration: TimelineConfiguration = TimelineConfiguration.DAILY,
    onDateChange: (date: Date) -> Unit = {}
){
    ShapifyTheme {
        Surface {
            ConstraintLayout(modifier = modifier ) {

                val (dateRef, dateNavigateRef, dividerRef) = createRefs()

                var date by remember {
                    mutableStateOf(DateTimeUtil.getCurrentDate())
                }

                val dateDialog = dateTimePickerDialog(date = date){
                    date = it
                }

                val df = SimpleDateFormat("MMM dd yyyy", Locale.getDefault())

                Button(
                    onClick = { dateDialog.show() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier.constrainAs(dateRef) {
                        top.linkTo(parent.top, margin = 15.dp)
                        bottom.linkTo(dividerRef.top)
                        start.linkTo(parent.start)
                    }) {

                    Text(
                        text = df.format(date),
                        fontSize = 18.sp
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.icon_drop_down),
                        contentDescription = "",
                        modifier = Modifier.size(32.dp)
                    )
                }

                Row(modifier = Modifier
                    .wrapContentSize()
                    .constrainAs(dateNavigateRef) {
                        end.linkTo(parent.end, 10.dp)
                        top.linkTo(dateRef.top)
                        bottom.linkTo(dateRef.bottom)
                    }) {
                    IconButton(onClick = { date = DateTimeUtil.getPreviousDate(date) }) {
                        Icon(painter = painterResource(id = R.drawable.icon_previous), contentDescription = "", modifier = Modifier.size(32.dp))
                    }
                    IconButton(onClick = { date = DateTimeUtil.getNextDate(date) }) {
                        Icon(painter = painterResource(id = R.drawable.icon_next), contentDescription = "", modifier = Modifier.size(32.dp))
                    }
                }

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(start = 10.dp, end = 10.dp)
                        .constrainAs(dividerRef) {
                            top.linkTo(dateRef.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
            }
        }
    }
}

@Dark
@Light
@Composable
fun TimelineComponent(
    modifier: Modifier = Modifier.fillMaxWidth(),
    configuration: TimelineConfiguration = TimelineConfiguration.WEEKLY,
    onClickButton: (config: TimelineConfiguration) -> Unit = {}) {
    ShapifyTheme {
        Surface {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = modifier.padding(2.dp)
            ) {
                Button(onClick = { onClickButton(TimelineConfiguration.DAILY) },
                    border = BorderStroke(2.dp, if(configuration == TimelineConfiguration.DAILY) PrimaryBlue else DarkBlack),
                    colors = ButtonDefaults.buttonColors(containerColor = if(configuration == TimelineConfiguration.DAILY) PrimaryBlue else Color.Transparent)
                ) {
                    Text(text = "Daily", fontSize = 18.sp)
                }
                Button(onClick = { onClickButton(TimelineConfiguration.WEEKLY) },
                    border = BorderStroke(2.dp, if(configuration == TimelineConfiguration.WEEKLY) PrimaryBlue else DarkBlack),
                    colors = ButtonDefaults.buttonColors(containerColor = if(configuration == TimelineConfiguration.WEEKLY) PrimaryBlue else Color.Transparent)) {
                    Text(text = "Weekly", fontSize = 18.sp)
                }
                Button(onClick = { onClickButton(TimelineConfiguration.MONTHLY) },
                    border = BorderStroke(2.dp, if(configuration == TimelineConfiguration.MONTHLY) PrimaryBlue else DarkBlack),
                    colors = ButtonDefaults.buttonColors(containerColor = if(configuration == TimelineConfiguration.MONTHLY) PrimaryBlue else Color.Transparent)) {
                    Text(text = "Monthly", fontSize = 18.sp)
                }
            }
        }
    }
}