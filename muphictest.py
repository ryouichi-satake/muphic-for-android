# Imports the monkeyrunner modules used by this program
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

# Connects to the current device, returning a MonkeyDevice object
device = MonkeyRunner.waitForConnection()

MonkeyRunner.sleep(1)

# Installs the Android package. Notice that this method returns a boolean, so you can test
# to see if the installation worked.
device.installPackage('C:/muphicforAndroid/muphic-for-Android/muphic-for-Android/bin/muphic-for-Android.apk')

MonkeyRunner.sleep(1)

# sets a variable with the package's internal name
package = 'project.muphic.Rikitakelab'

# sets a variable with the name of an Activity in the package
activity = 'project.muphic.Rikitakelab.Muphic'

# sets the name of the component to start
runComponent = package + '/' + activity

# Runs the component
device.startActivity(component=runComponent)



dispWidth=int(device.getProperty('display.width'))
dispHeight=int(device.getProperty('display.height'))

MonkeyRunner.sleep(0.5)

# Takes a screenshot
result = device.takeSnapshot()

# TitleWindow
result.writeToFile('C:/muphicforAndroid/muphic-for-Android/Screenshot/Title.png','png')



device.touch(787,363,MonkeyDevice.DOWN)
MonkeyRunner.sleep(0.1)
device.touch(787,363,MonkeyDevice.UP)

MonkeyRunner.sleep(0.1)

# Takes a screenshot
result = device.takeSnapshot()

# Story Create Window
result.writeToFile('C:/muphicforAndroid/muphic-for-Android/Screenshot/StoryCreateWindow.png','png')



device.touch(dispWidth-10,290,MonkeyDevice.DOWN)
MonkeyRunner.sleep(0.1)
device.touch(dispWidth-10,290,MonkeyDevice.UP)

MonkeyRunner.sleep(0.1)

# Takes a screenshot
result = device.takeSnapshot()

# Music Create Window
result.writeToFile('C:/muphicforAndroid/muphic-for-Android/Screenshot/MusicCreateWindow.png','png')



device.touch(1000,50,MonkeyDevice.DOWN)
MonkeyRunner.sleep(0.1)
device.touch(1000,50,MonkeyDevice.UP)

device.touch(dispWidth-10,385,MonkeyDevice.DOWN)
MonkeyRunner.sleep(0.1)
device.touch(dispWidth-10,385,MonkeyDevice.UP)

MonkeyRunner.sleep(0.1)

# Takes a screenshot
result = device.takeSnapshot()

# BackGround Select
result.writeToFile('C:/muphicforAndroid/muphic-for-Android/Screenshot/BackGroundSelect.png','png')



device.touch(dispWidth-16,35,MonkeyDevice.DOWN)
MonkeyRunner.sleep(0.1)
device.touch(dispWidth-16,35,MonkeyDevice.UP)

MonkeyRunner.sleep(0.1)

# Takes a screenshot
result = device.takeSnapshot()

# BacktoStory
result.writeToFile('C:/muphicforAndroid/muphic-for-Android/Screenshot/BacktoStory.png','png')



device.touch(dispWidth-10,385,MonkeyDevice.DOWN)
MonkeyRunner.sleep(0.1)
device.touch(dispWidth-10,385,MonkeyDevice.UP)

device.touch(191,35,MonkeyDevice.DOWN)
MonkeyRunner.sleep(0.1)
device.touch(191,35,MonkeyDevice.UP)

MonkeyRunner.sleep(0.1)

# Takes a screenshot
result = device.takeSnapshot()

# Character Select
result.writeToFile('C:/muphicforAndroid/muphic-for-Android/Screenshot/CharacterSelect.png','png')



device.touch(21,75,MonkeyDevice.DOWN)
MonkeyRunner.sleep(0.1)
device.touch(21,75,MonkeyDevice.UP)

MonkeyRunner.sleep(0.1)

# Takes a screenshot
result = device.takeSnapshot()

# Push BoyButton
result.writeToFile('C:/muphicforAndroid/muphic-for-Android/Screenshot/PushBoyButton.png','png')



device.touch(16,35,MonkeyDevice.DOWN)
MonkeyRunner.sleep(0.1)
device.touch(16,35,MonkeyDevice.UP)

MonkeyRunner.sleep(0.1)

# Takes a screenshot
result = device.takeSnapshot()

# Back Back Ground Select
result.writeToFile('C:/muphicforAndroid/muphic-for-Android/Screenshot/BackBackGroundSelect.png','png')



device.touch(dispWidth-16,35,MonkeyDevice.DOWN)
MonkeyRunner.sleep(0.1)
device.touch(dispWidth-16,35,MonkeyDevice.UP)

device.touch(dispWidth-10,100,MonkeyDevice.DOWN)
MonkeyRunner.sleep(0.1)
device.touch(dispWidth-10,100,MonkeyDevice.UP)

MonkeyRunner.sleep(0.1)

result=device.takeSnapshot()

#Back to Title from Story Create Window
result.writeToFile('C:/muphicforAndroid/muphic-for-Android/Screenshot/BackTitle.png','png')



device.press('KEYCODE_BACK',MonkeyDevice.DOWN_AND_UP)