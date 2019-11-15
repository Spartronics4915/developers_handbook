# Starting with Bling

Spartronics has two projects for introducing Ardunio development using
bling.

* [Intro to Arduino](https://github.com/riyadth/IntroToArduino) is a
  simple introduction with step by step demonstration of adding new
  functionality.
* [Bling Demo](https://github.com/riyadth/BlingDemoSystem) uses Adafruit
  NeoPixel strip and ring components to enable students with a sandbox
  environment for experimentation.

Important: If this is your first time diving into Arduino, make sure to
walk through [Ladyada's Learn Arduino
Tutorials](https://learn.adafruit.com/series/ladyadas-learn-arduino). 

## Bling Demo
Introduction to bling development uses Adafruit NeoPixel strip and ring
components. Demo board also has a potentiometer for demonstrating sensor
interaction.

### Setup
For sketch code and hardware requirements see
[BlingDemoSystem Repo](https://github.com/riyadth/BlingDemoSystem)

* Board: Arduino Uno
* [Install Adafruit NeoPixel
  Library](https://learn.adafruit.com/adafruit-neopixel-uberguide/arduino-library-installation)
  to Arduino IDE
* If you need to install Arduino IDE, see instructions
  [here](./toolkit.md)
* If you need help w/ cloning BlingDemoSystem Repo, see instructions [here](../git_introduction/git_fundamentals.md#git-clone)

### Learning Path
Also see [Arduino Tutorial](https://www.tutorialspoint.com/arduino/) for
reference.
- Introduce [Arduino Uno
  board](https://www.tutorialspoint.com/arduino/arduino_board_description.htm),
  how to connect to power and computer, and general layout of the pins
- Give an overview of Arduino IDE (how to compile, upload, configure
  IDE, ...) and introduce the term *sketch* which
  is an Arduino program
- Review how sketch code is mapped to Arduino board and bling hardware:
  pins, NeoPixel configuration.
- Discuss [Arduino sketch code
  structure](https://www.tutorialspoint.com/arduino/arduino_program_structure.htm):
  `setup()` and `loop()` functions.
- Introduce [data types](https://www.tutorialspoint.com/arduino/arduino_data_types.htm), [variables](https://www.tutorialspoint.com/arduino/arduino_variables_and_constants.htm), [functions](https://www.tutorialspoint.com/arduino/arduino_functions.htm)
- Introduce
  [operators](https://www.tutorialspoint.com/arduino/arduino_operators.htm),
  [control statements](https://www.tutorialspoint.com/arduino/arduino_control_statements.htm) and [loops](https://www.tutorialspoint.com/arduino/arduino_loops.htm)
- Introduce simple debugging with `println()`
- Show how potentiometer sensor is read and how NeoPixel is controlled.
  Also discuss [Arduino I/O
  functions](https://www.tutorialspoint.com/arduino/arduino_io_functions.htm):
  `pinMode()`, `digitalWrite()` and
  `analogRead()` functions.

### Exercises and Code Experiments
- Understand RGB and pixel numbering by changing the `setup()` code on
  how the strip/ring is initialized. Experiment with online [RGB
  colors](https://htmlcolorcodes.com) and see how they perform on the NeoPixel.
- Write new functions for different blink patterns:
    - rainbow
    - use potentiometer to change intensity of the leds without changing
      the blink pattern
    - use potentiometer to control the number of pixels change color on
      the strip: 0 everything off to 255 all pixels are on
- Change blink rates and experiment with using light on/off as a
  communication tool.

### Adafruit NeoPixel Documentation
See [Adafruit NeoPixel
Uberguide](https://learn.adafruit.com/adafruit-neopixel-uberguide/arduino-library-use)
for documentation on how to use the library.

Key sections:
* Include library: `#include <Adafruit_Neopixel.h>`
* Specify `LED_PIN` and `LED_COUNT`
* Declare `Adafruit_NeoPixel` object -- can be a ring or a strip
```c
// Example for NeoPixel strip
#define STRIP_PIN       4       // i.e. LED_PIN
#define STRIP_PIXELS    30      // i.e. LED_COUNT
// *strip* is the Adafruit_NeoPixel object
Adafruit_NeoPixel strip = Adafruit_NeoPixel(STRIP_PIXELS, STRIP_PIN, NEO_GRB + NEO_KHZ800);
```
* When using the NeoPixel function, make sure to specify the
  Adafruit_NeoPixel object
* In `setup()` function call `begin()` to prepare data pin NeoPixel
  output
```c
void setup(void)
{
    // Configure the serial terminal for debug output and user input
    Serial.begin(9600);

    // Initialize the pixels to get them ready for use
    strip.begin();
}
```
* Common commands -- don't forget to specify the NeoPixel object in the command `strip.clear()`
  * LED pixels numbered along the strip starting from 0 closest to the
    Arduino board
  * setting pixel colors:
    * `setPixelColor(pixel_number, R, G, B)` and RGB brightness levels
      -- 0 is dimmest (off) and 255 max brightest
    * `setPixelColor(pixel_number, color)` where `color` is a 32-bit
      type that represents RGB

    ```c
    // Set up a rainbow pattern on the strip
    strip.setPixelColor(0, Adafruit_NeoPixel::Color(32, 0, 0));
    strip.setPixelColor(1, Adafruit_NeoPixel::Color(32, 32, 0));
    strip.setPixelColor(2, Adafruit_NeoPixel::Color(0, 32, 0));
    strip.setPixelColor(3, Adafruit_NeoPixel::Color(0, 32, 32));
    strip.setPixelColor(4, Adafruit_NeoPixel::Color(0, 0, 32));
    strip.setPixelColor(5, Adafruit_NeoPixel::Color(32, 0, 32));
    strip.setPixelColor(6, Adafruit_NeoPixel::Color(32, 32, 32));
    strip.show();

    // Setup a magenta color
    uint32_t magenta = strip_object.Color(255, 0, 255)
    ```
    * `fill()` function to set same color to multiple pixels
    * `clear()` function to turn off all pixels to 0 brightness
    * `getPixelColor()` to query existing pixel value
    * `setBrightness()` to specify brightness level of all pixels
* `show()` to push the color data to the NeoPixel object, otherwise
  color changes will not be displayed

## Bling Code Samples
- [Intro to Arduino](https://github.com/riyadth/IntroToArduino)
- [Spartronics Bling Code](https://github.com/Spartronics4915/Bling)