# Arduiono IDE: Installation and Setup

It takes just a few steps to start with Arduino development and fun experiments
with bling.

## Step 1: Install Arduino IDE
We recommend installing Arduino Desktop IDE. Follow the
[instructions](https://www.arduino.cc/en/Guide/HomePage) to setup the
environment for your OS.

## Step 2: Configure IDE for the right board
Once your IDE is setup, specify the Arduino board: *Tools/Board* menu. There are
many different Arduino boards, see
[here](https://www.arduino.cc/en/main/boards). Make sure to specify the correct
board you are using for your application. Spartronics commonly uses Ardunio Uno.

## Step 3: Configure IDE for the upload port
In order to upload your code, IDE needs to be configured to specify the upload
port. Connect your Arduino board to your computer with the USB cable, and
*Tools/Port* menu will highlight the port where your board is connected.

## Step 4: Install the libraries needed
Your code likely depends on other libraries, such as Adafruit NeoPixel library
for our bling examples. *Tools/Manage Libraries...* menu to add necessary
libraries.

## Step 5: Verify environment is correctly configured
Arduino IDE comes with example sketches. Arduino Blink example is an easy way to
verify your IDE is correctly configured. Load Blink sketch code via
*File/Examples/02.Basics/Blink* and upload to your Arduino board to verify
builtin LED blinks. Ensure `led` pin is correctly specified for your board type.