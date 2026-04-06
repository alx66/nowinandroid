/*
 * Copyright 2026 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package lesson17

import com.google.samples.apps.nowinandroid.ui.lesson15.BaseClass
import com.google.samples.apps.nowinandroid.ui.lesson15.homework.MainScreen.searchButton
import com.google.samples.apps.nowinandroid.ui.lesson15.homework.MainScreen.toolbarTitle
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.components.composesupport.config.ComposeConfig
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import dagger.hilt.android.testing.HiltAndroidTest
import lesson16.homework.MainScreen
import org.junit.Test

abstract class ConfiguredComposeTestCase : TestCase(Kaspresso.Builder.withForcedAllureSupport().apply { ComposeConfig.Builder.default(this) {} })

@HiltAndroidTest
class AllureTest : ConfiguredComposeTestCase() {

    @Test
    fun checkAllureReport() {
        run{
            MainScreen {
                step("Step 1") {
                    toolbarTitle.assertTextEquals("Now in Android")
                }
                step("Проверка наличия кнопки поиска в навбаре(упадет)") {
                    searchButton.assertIsNotDisplayed()
                }
            }
        }
    }
}