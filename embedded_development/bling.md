# Starting with Bling

## Bling Demo System Setup
Introduction to bling development uses Adafruit NeoPixel strip and ring components. For sketch code and hardware requirements see [BlingDemoSystem Repo](https://github.com/riyadth/BlingDemoSystem)

* Board: Arduino Uno
* [Install Adafruit NeoPixel Library](https://learn.adafruit.com/adafruit-neopixel-uberguide/arduino-library-installation) to Arduino IDE

## Adafruit NeoPixel Documentation
See [Adafruit NeoPixel Uberguide](https://learn.adafruit.com/adafruit-neopixel-uberguide/arduino-library-use) for documentation on how to use the library.

Key sections:
* Include library: `#include <Adafruit_Neopixel.h>`
* Specify `LED_PIN` and `LED_COUNT`
* Declare `Adafruit_NeoPixel` object -- can be a ring or a strip
* In `setup()` function call `begin()` to prepare data pin NeoPixel output
* Common commands:
  * LED pixels numbered along the strip starting from 0 closest to the Arduino board
  * setting pixel colors -- note remember to use `show()` to push the color data to the neopixel object:
    * `setPixelColor(pixel_number, R, G, B)` and RGB brightness levels -- 0 is dimmest (off) and 255 max brightest
    * `setPixelColor(pixel_number, color)` where `color` is a 32-bit type that represents RGB `uint32_t magenta = strip_object.Color(255, 0, 255)`
    * `fill()` function to set same color to multiple pixels
    * `clear()` function to turn off all pixels to 0 brightness
    * `getPixelColor()` to query existing pixel value
    * `setBrightness()` to specify brightness level of all pixels

## Spartronics Clock with NeoMatrix
See [Spartronics Clock repo](https://github.com/riyadth/spartronics_clock) for code and instructions on how we track time till critical events.

* Documentation on [Adafruit NeoMatrix Library](https://learn.adafruit.com/adafruit-neopixel-uberguide/neomatrix-library)

## Bling Code Samples
- [Intro to Arduino](https://github.com/riyadth/IntroToArduino)
- [Spartronics Bling Code](https://github.com/Spartronics4915/Bling)