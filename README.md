![Screenshot](https://github.com/JalogTeam/Jalog_Android_MinimalDemo/blob/main/doc/MinimalDemo_screenshot.jpg?raw=true  "Screenshot")
# Jalog_Android_MinimalDemo
**Application (using Jalog logic) to demonstrate interfacing**

1. Create Android Studio project
  * New Project
  * Empty Activity
    - Name: `MinimalDemo`
    - Package name: `jalog_demo.minimal_demo` 
         **NOTE**: Package name must be exactly right.
    - Save location: Choose a good location.
    - Language: `Java`

2. Install MinimalDemo package
  * From https://github.com/JalogTeam/Jalog_Android_MinimalDemo > Code > Download ZIP
  * Unzip `Jalog_Android_MinimalDemo-master.zip`
  * Copy unzipped directory `app` on top of `app` in Android Studio project
    - confirm merging, if asked

3. Install Jalog
  * From https://github.com/JalogTeam/Jalog > Code > Download ZIP
  * Unzip `Jalog-master.zip` 
  * Copy directory `io` from unzipped `Jalog-master/src/` to `app/src/main/java`
    - confirm merging, if asked

4 Build MinimalDemo
  * In Android Studio 
    - select Nexus S API 28 (tested with this)
    - Main menu > Build > Make Project
  
5 Run 
  * Run 
    - Should show text "MinimalDemo" near to the top of the display. The text "&lt;empty&gt;" and three buttons should be visible under the name.
  * Test behaviour by tapping buttons. 
    Text above buttons should change:
    - SUCCESS should show "Success".
    - FAIL should show "*fail".
    - EXIT should show "*exit 5".
    
