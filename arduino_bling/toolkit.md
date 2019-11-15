# Arduiono IDE: Installation and Setup

It takes just a few steps to start with Arduino development and
create fun projects with bling.

## Step 1: Install Arduino IDE
We use the Arduino Desktop IDE. Follow the
[instructions](https://www.arduino.cc/en/Guide/HomePage) to setup the
environment for your OS.

## Step 2: Configure IDE for the right board
Once your IDE is setup, specify the Arduino board: *Tools/Board* menu. There
are many different [Arduino boards](https://www.arduino.cc/en/Main/Products).
Make sure to specify the correct board you are using for your application.
Spartronics commonly uses Ardunio Uno.

## Step 3: Configure IDE for the programming port
In order to upload your code, IDE needs to be configured to specify the
port that is connected to the Arduino board. First connect your Arduino board
to your computer with the USB cable, and using the *Tools/Port* menu,
select the port where your board is connected.

## Step 4: Install the libraries needed
Your code likely depends on other libraries, such as Adafruit NeoPixel library
for our bling examples. *Tools/Manage Libraries...* menu to add necessary
libraries. The library requirements for a program should be listed in
the code comments.

## Step 5: Verify environment is correctly configured
The Arduino IDE comes with example sketches (programs). The Arduino Blink
example is an easy way to verify your IDE is correctly configured.
Load the Blink sketch code via *File/Examples/02.Basics/Blink*
and click the Upload button to put the program on your Arduino board.
After the programming is complete, the board should automatically start
running the program, and the on-board LED will blink on and off.
If it doesn't blink, ensure the `led` pin definition in the code is correctly
specified for your board type.