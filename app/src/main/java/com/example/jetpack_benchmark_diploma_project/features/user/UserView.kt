import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.jetpack_benchmark_diploma_project.models.UserModel
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun UserView(user: UserModel, onClick: () -> Unit) {
    LaunchedEffect(Unit, block = {
        val navigationEndTimestampFormat = SimpleDateFormat("'Date\n'dd-MM-yyyy '\n\nand\n\nTime\n'HH:mm:ss:ms")

        val navigationEndTimestamp = navigationEndTimestampFormat.format(Date())
        Log.d("Navigation End Timestamp: ", navigationEndTimestamp)
    })

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(vertical = 10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(Modifier
            .fillMaxWidth()) {
            IconButton(onClick = {
                onClick()
            }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Информация о приложении")
            }
        }
        Image(
            painter = rememberAsyncImagePainter(user.picture.large),
            contentDescription = "avatar",
            contentScale = ContentScale.Fit,// crop the image if it's not a square
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(2.dp, Color.Gray, CircleShape)
        )
        Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "First Name: ${user.name.first}",
                textAlign = TextAlign.Start,
                maxLines = 1,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start),
                fontSize = 24.sp,
                fontWeight = FontWeight(500),
            )
            Text(
                text = "Last Name: ${user.name.last}",
                textAlign = TextAlign.Start,
                maxLines = 1,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start),
                fontSize = 24.sp,
                fontWeight = FontWeight(500),
            )
            Text(
                text = "Email: ${user.email}",
                textAlign = TextAlign.Start,
                maxLines = 2,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start),
                fontSize = 24.sp,
                fontWeight = FontWeight(500),
            )
            Text(
                text = "Phone: ${user.phone}",
                textAlign = TextAlign.Start,
                maxLines = 1,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start),
                fontSize = 24.sp,
                fontWeight = FontWeight(500),
            )
            Text(
                text = "Gender: ${user.gender}",
                textAlign = TextAlign.Start,
                maxLines = 1,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start),
                fontSize = 24.sp,
                fontWeight = FontWeight(500),
            )
    }
}