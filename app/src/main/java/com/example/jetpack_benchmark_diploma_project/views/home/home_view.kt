import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.dp
import com.example.jetpack_benchmark_diploma_project.views.home.home_view_model
import com.example.jetpack_benchmark_diploma_project.widget_helper.UserTile

@Composable
fun HomeView(viewModel: home_view_model) {
    LaunchedEffect(Unit, block = {
        viewModel.getUserList()
    })

    if (viewModel.selectedIndex == null) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                horizontal = 20.dp,
                vertical = 10.dp
            )
        ) {
            items(
                viewModel.userList.count()
            ) { index ->
                UserTile(user = viewModel.userList[index]) {
                    viewModel.selectUser(index)
                }
            }
        }
    } else {
        UserView(user = viewModel.userList[viewModel.selectedIndex!!], onClick = {
            viewModel.selectUser(null)
        })
    }
}