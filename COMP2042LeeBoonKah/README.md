# COMP2042_CW_hfybl2
1. Lee Boon Kah 20297564

2. Steps before running the code:

    a)  Search and download the folder that named javalib(for window user) in my repository which contain the platform-specific SDK for javafx or download the SDK by using the link: https://gluonhq.com/products/javafx/ with the respective operating system as shown below:
    
    <img width="573" alt="image" src="https://user-images.githubusercontent.com/96328144/207560438-e9a61265-dcc3-4a15-a846-6261762cee64.png">\
    
    b) Open the java compiler such as IntelliJ and navigate to the library's target in the project structure 
    
    <img width="183" alt="image" src="https://user-images.githubusercontent.com/96328144/207565473-8a8f6f5c-f010-45a0-ad85-709431c5395a.png">
    
    c) In the project structure, ensure the library's target in the project structure is javafx-sdk-19/lib which download from the link or the folder
    
    <img width="758" alt="image" src="https://user-images.githubusercontent.com/96328144/207567372-33473532-b49b-4c26-aaf2-031d54f6b52a.png">
    
    d) Download the folder of src and run in the Main
    
    <img width="968" alt="image" src="https://user-images.githubusercontent.com/96328144/207672423-5d082a60-4eef-446e-81a5-15909d1c2985.png">

3. The path to the Javadoc documentation: "COMP2042LeeBoonKah\javadoc\index.html"

4. List of features that are implemented and are working properly:

    a) The board size of the game can be change to 3x3, 4x4 and 5x5.
    
    b) All three of the game's backgrounds—the menu screen, in-game scene, and the end game scene share the same colour customization options.
    
    c) Warning to input name if user does not enter properly before to beginning game(Secure the Database).
    
    d) Help button that let the users to preview the game and teach them how to play.
    
    e) Correction made to the random spawning bug and score increase fault.
    
    f) Display the rank of the user.
    
    g) Check for duplicate usernames and change scores if new users score higher.
    
    h) Files have been separated into GameModel, View, Controller folders to better adhere 'Model View Controller’(MVC) principle.
    
    i) Challenge Mode in the game

5. A list of features that are implemented and are not working properly:
    
    a) Switching the picture in the Help page by using the file path instead of setvisble true and false.
    
    b) Sort the user with the game size but unable to complete it(Last minutes idea).

6.  Challenge mode with various level. I try to open a new Challenge class by duplicating code of game scene class and modify it but this lead my code to crash. 

7. A list of new Java classes:

   a) LeaderboardController 
    
   b) HelpController
   
8. A list of Java classes that you modified from the given code base:

   a) Controller ->(change to) MenuController
   
   b) GameScene
   
   c) EndGame
   
   d) Account
   
   e) TextMaker and Cell (Slightly change)

Unexpected problems:

There are a few bugs in the game, including the scoring bug and the spawning bug. The score problem included the score rising anytime any key was hit, even when no legal movements were executed. This was fixed with minor change of function of moveHorizontally, moveVertically and sumCellNumbersToScore in Gamescene class. The spawning problem caused blocks to spawn even when the user wasn't adding or moving blocks. When add or movement is true, only a block may spawn. Add was recognised when adder was invoked, and movement was identified by isArrowkey() and comparing the previous and present board states.In conclusion, it is crucial to comprehend the code in each class to solve the bug.
