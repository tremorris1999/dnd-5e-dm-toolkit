# dnd-5e-dm-toolkit

Eclipse Instructions (assuming fresh clone of repo):

1.) In "File":
        >> "Open Projects From File System..." 
        >> "Directory" 
        >> Navigate to and select "dnd-5e-dm-toolkit/"
        >> "Open"

2.) In Project Explorer:
        >> Expand "dnd-5e-dm-toolkit" 
        >> Right-click "DM Toolkit" 
        >> "Build Path" 
        >> "Configure Build Path..." 
        >> Select "Classpath" 
        >> "Add Library" 
        >> Select "User Library" 
        >> "User Libraries"
        >> "New"
        >> Name whatever you'd like (e.g "JavaFX13")
        >> "Add External JARs"
        >> Navigate to the appropriate JavaFX SDK
        >> Navigate to /bin
        >> Select all the JAR files here.
        >> "Open"
        >> "Apply and Close"
        >> Check-in the checkbox for the new user library.
        >> "Finish"
        >> "Apply and Close"

3.) In "Run"
        >> "Run Configurations..."
        >> Right-click "Java Application"
        >> "New Configuration"
        >> Name appropriately (e.g "Main')
        >> In "Main Class" label, select "Search"
        >> Select "Main"
        >> "OK"
        >> Change to "Arguments" tab
        >> In "VM arguments", paste the following depending on OS:

            Windows:
                --module-path  "..\javafx-sdk-13.0.2\lib" --add-modules javafx.controls,javafx.fxml

            Linux:
                --module-path  "../javafx-sdk-13.0.2-linux/lib" --add-modules javafx.controls,javafx.fxml
        
        >> "Apply"
        >> "Run"

