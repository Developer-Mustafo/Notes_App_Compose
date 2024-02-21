package uz.coder.notesapp.navigation

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import uz.coder.notesapp.screen.AddScreen
import uz.coder.notesapp.screen.HomeScreen
import uz.coder.notesapp.screen.Notes
import uz.coder.notesapp.sealed.NotesScreens
import uz.coder.notesapp.viewModel.NotesViewModel

@Composable
fun MyNavHost(viewModel: NotesViewModel) {
    val navController = rememberNavController()
    Surface {
        NavHost(navController, startDestination = NotesScreens.Home.route)
        {
            composable(NotesScreens.Home.route){
                    HomeScreen(navController,viewModel)
            }
            composable(NotesScreens.Add.route){
                AddScreen(navController,viewModel)
            }
            composable(NotesScreens.Notes.route+"/{name}/{notes}", arguments = listOf(
                navArgument("name"){type = NavType.StringType},
                navArgument("notes"){type = NavType.StringType})){
                Notes(navController,it)
            }
        }

    }
}