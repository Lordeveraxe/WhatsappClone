package com.uptc.whatsapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uptc.whatsapp.ui.calls.CallsScreen
import com.uptc.whatsapp.ui.chats.ChatsScreen
import com.uptc.whatsapp.ui.communities.CommunitiesScreen
import com.uptc.whatsapp.ui.navigation.BottomNavigationBar
import com.uptc.whatsapp.ui.status.StatusScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "chats",
            Modifier.padding(padding)
        ) {
            composable("chats") { ChatsScreen() }
            composable("status") { StatusScreen() }
            composable("communities") { CommunitiesScreen() }
            composable("calls") { CallsScreen() }
        }
    }
}