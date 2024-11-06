package com.uptc.whatsapp.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.uptc.whatsapp.R

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = 4.dp
    ) {
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_chats_black_24dp), contentDescription = "Chats", modifier = Modifier.size(24.dp).padding(2.dp)) },
            label = { Text("Chats") },
            selected = false,
            onClick = { navController.navigate("chats") }
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_status_black_24dp), contentDescription = "Status", modifier = Modifier.size(24.dp)) },
            label = { Text("Status") },
            selected = false,
            onClick = { navController.navigate("status") }
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_communities_black_24dp), contentDescription = "Communities", modifier = Modifier.size(24.dp)) },
            label = { Text("Communities") },
            selected = false,
            onClick = { navController.navigate("communities") }
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_calls_black_24dp), contentDescription = "Calls", modifier = Modifier.size(24.dp)) },
            label = { Text("Calls") },
            selected = false,
            onClick = { navController.navigate("calls") }
        )
    }
}