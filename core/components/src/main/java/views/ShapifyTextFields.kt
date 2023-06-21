package views

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fitness.shapify.theme.properties.textFieldColors
import com.fitness.shapify.theme.properties.textFieldShape

@Preview
@Composable
private fun ElevatedTextFieldPreview(){
    ElevatedTextField(
        value = "First name",
        onValueChange = {},
        placeholder = {},
        modifier = Modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElevatedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    defaultElevation: Dp = 0.dp,
    pressedElevation: Dp = 0.dp,
    shape: Shape = textFieldShape(),
    colors: TextFieldColors = textFieldColors(),
    isError: Boolean = false,
    enabled: Boolean = true,
){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = defaultElevation, pressedElevation = pressedElevation),
        shape = shape,
        modifier = modifier) {
        TextField(
            value = value,
            leadingIcon = leadingIcon,
            onValueChange = onValueChange,
            label = label,
            placeholder = placeholder,
            keyboardOptions = keyboardOptions,
            singleLine = true,
            shape = shape,
            colors = colors,
            isError = isError,
            enabled = enabled
        )

    }
}