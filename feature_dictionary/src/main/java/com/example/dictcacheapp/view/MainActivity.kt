package com.example.dictcacheapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dictcacheapp.ui.theme.DictCacheAppTheme
import com.example.dictcacheapp.view.WordInfoItem
import com.example.presentation.viewmodel.WordInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onStart

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DictCacheAppTheme {
                val viewModel: WordInfoViewModel = hiltViewModel()
                val state = viewModel.state.value
                val scaffoldState = rememberScaffoldState()
                val focusRequester = remember { FocusRequester() }
                val focusManager = LocalFocusManager.current

                LaunchedEffect(key1 = true) {
                    focusRequester.requestFocus()
                    viewModel.eventFlow.collectLatest { event ->
                        when (event) {
                            is com.example.common.UIEvent.ShowSnackbar -> {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = event.message
                                )
                            }
                        }
                    }
                }
                Scaffold(
                    scaffoldState = scaffoldState
                ) {
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colors.background)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                                .addFocusCleaner(focusManager)
                        ) {
                            TextField(
                                value = viewModel.searchQuery.value,
                                onValueChange = viewModel::onSearch,
                                modifier = Modifier.fillMaxWidth()
                                    .focusRequester(focusRequester),
                                placeholder = {
                                    Text("Search...")
                                })
                            Spacer(modifier = Modifier.height(16.dp))
                            LazyColumn(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                items(state.wordInfoItems.size) { i ->
                                    val wordInfo = state.wordInfoItems[i]
                                    if(i > 0) Spacer(modifier = Modifier.height(8.dp))

                                    WordInfoItem(wordInfo = wordInfo)

                                    if(i < state.wordInfoItems.size - 1) Divider()
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}

fun Modifier.addFocusCleaner(focusManager: FocusManager, doOnClear: () -> Unit = {}): Modifier {
    return this.pointerInput(Unit) {
        detectTapGestures(onTap = {
            doOnClear()
            focusManager.clearFocus()
        })
    }
}