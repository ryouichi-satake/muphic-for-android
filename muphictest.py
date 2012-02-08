# Imports the monkeyrunner modules used by this program
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

# Connects to the current device, returning a MonkeyDevice object
device = MonkeyRunner.waitForConnection()

MonkeyRunner.sleep(1)

# Installs the Android package. Notice that this method returns a boolean, so you can test
# to see if the installation worked.
device.installPackage('C:/muphicforAndroid/muphic-for-Android/muphic-for-Android/bin/muphic-for-Android.apk')

MonkeyRunner.sleep(2)

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

MonkeyRunner.sleep(1)

# Takes a screenshot
result = device.takeSnapshot()

# TitleWindow
result.writeToFile('C:/muphicforAndroid/muphic-for-Android/Screenshot/shot1.png','png')

MonkeyRunner.sleep(0.3)

device.touch(787,363,MonkeyDevice.DOWN)
MonkeyRunner.sleep(0.1)
device.touch(787,363,MonkeyDevice.UP)

MonkeyRunner.sleep(1)

# Takes a screenshot
result = device.takeSnapshot()

# Story Create Window
result.writeToFile('C:/muphicforAndroid/muphic-for-Android/Screenshot/shot2.png','png')

MonkeyRunner.sleep(0.3)

device.touch(787,363,MonkeyDevice.DOWN)
MonkeyRunner.sleep(0.1)
device.touch(787,363,MonkeyDevice.UP)

MonkeyRunner.sleep(1)

# Takes a screenshot
result = device.takeSnapshot()

# Mushic Create Window
result.writeToFile('C:/muphicforAndroid/muphic-for-Android/Screenshot/shot3.png','png')

MonkeyRunner.sleep(0.3)

device.touch(1000,50,MonkeyDevice.DOWN)
MonkeyRunner.sleep(0.1)
device.touch(1000,50,MonkeyDevice.UP)

MonkeyRunner.sleep(0.3)

device.touch(1000,50,MonkeyDevice.DOWN)
MonkeyRunner.sleep(0.1)
device.touch(1000,50,MonkeyDevice.UP)

MonkeyRunner.sleep(1)

result=device.takeSnapshot()

#Back to Title from Story Create Window
result.writeToFile('C:/muphicforAndroid/muphic-for-Android/Screenshot/shot4.png','png')

MonkeyRunner.sleep(0.3)

device.press('KEYCODE_BACK',MonkeyDevice.DOWN_AND_UP)