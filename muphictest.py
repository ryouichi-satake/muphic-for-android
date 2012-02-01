# Imports the monkeyrunner modules used by this program
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

# Connects to the current device, returning a MonkeyDevice object
device = MonkeyRunner.waitForConnection()

MonkeyRunner.sleep(1)

# Installs the Android package. Notice that this method returns a boolean, so you can test
# to see if the installation worked.
device.installPackage('C:muphicforAndroid/muphic-for-Android/bin/Muphic.apk')

MonkeyRunner.sleep(2)