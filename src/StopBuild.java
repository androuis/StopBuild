/*
 * Copyright 2000-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package StopBuildPlugin.src;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import java.io.IOException;

/**
 * Created by andreibacalu on 10/04/2017.
 */
public class StopBuild extends AnAction {

  @Override
  public void actionPerformed(AnActionEvent e) {
    Runtime rt = Runtime.getRuntime();
      try {
        if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) {
          rt.exec("taskkill ");
        } else {
          rt.exec("ps -A | grep gradle | awk '{ print $1; }' | xargs kill -9");
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
  }
}
