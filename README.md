This is Universal Charter:

A program that is an all in one editor for various types of VSRG formats. 
Currently only supports .osu

Since this is unfinished, please run the main function in code.

Make sure to edit launch.json and settings.json to correctly use javafx:

Replace %PATH_TO_FILE% with the path of the lib folder of javafx

launch.json:
```
        "%PATH_TO_FILE%\\javafx.base.jar",
        "%PATH_TO_FILE%b\\javafx.controls.jar",
        "%PATH_TO_FILE%\\javafx.fxml.jar",
        "%PATH_TO_FILE%\\javafx.graphics.jar",
        "%PATH_TO_FILE%\\javafx.media.jar",
        "%PATH_TO_FILE%\\javafx.swing.jar",
        "%PATH_TO_FILE%\\javafx.web.jar",
        "%PATH_TO_FILE%\\javafx-swt.jar"
```

Add this argument to settings.json:
```
"vmArgs": "--module-path %PATH_TO_FILE% --add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web"
        
```

When you run the program, I have provided a sample chart in "Sample Files" folder. Using File>Open, choose the .osu file contained within the folders.