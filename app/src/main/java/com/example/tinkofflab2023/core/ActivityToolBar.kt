package com.example.tinkofflab2023.core

import com.example.tinkofflab2023.di.Screen

interface ActivityToolBar {

    fun changeToolBarTitle(title: String)

    fun changeToolBar(Screen : Screen)

    fun changeTheme(isChecked: Boolean)
}
