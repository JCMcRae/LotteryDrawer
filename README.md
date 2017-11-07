# LotteryDrawer
Java SWT application utilizing the [Lottery API]("www.github.com/jcmcrae/lottery", "Lottery API") to add and draw contestant names.

Requires Java 8.

## Introduction
In order to use this application, you need to compile this code.:

`javac LotteryDrawer.java`

Depending on your IDE of choice, if you so choose to use one, it will do it for you. You just need to figure out how to do that. After it compiles, you need to convert it to a runnable `.jar' file:

`jar -cf LotteryDrawer.jar LotteryDrawer.class`

If you have the means to turn the .jar into an .exe or whatever executable convention your computer takes, then by all means, go for it. But it needs to be at least a runnable .jar to run.

## How It Works
The interface is very simple and easy to use. Simply enter a name in the text box, and click add. Keep adding as many names as you need to. There will be a tracker on the side of the application that keeps note of the number of contestants entered. After that, you simply need to click select to get your winner.

The interface is so simple that you shouldn't even have to read this section of the readme. 
