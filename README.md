# android-permission-library
 Android library that simplifies the process of requesting permissions at runtime.
 
 PERMISSION GROUPS:
 CALENDAR
 CAMERA&GALLRY(CAMERA&STORAGE)
 CONTACT
 LOCATION
 MICROPHONE
 PHONE
 SENSOR
 SMS
 
Usage:
1)If you are interested in asking once please call checkAndRequestPhonePermission in the appropriate place
For example :
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PhonePermission.checkAndRequestPermission(this,Manifest.permission.CALL_PHONE,Manifest.permission.READ_PHONE_STATE);
    }


2)If you are interested in the case of deny ask again until allow:checkAndRequestPhonePermission should be exercised in onRequestPermissionsResult.
3)In the case of deny and do not ask me again to refer to the settings once:askForSettingPermission must be realized in the onRequestPermissionsResult.(after 1)
For example :

   @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        CalendarPermission.askForSettingPermission(this,Manifest.permission.WRITE_CALENDAR,Manifest.permission.READ_CALENDAR);
    }

4)If you wish that until there is no confirmation of the settings insist,askForSettingPermission should be realized in onActivityResult.


To get a the library into your build:
GRADLE:

Step 1. Add the JitPack repository to your build file
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
 Step 2. Add the dependency
 dependencies {
	        implementation 'com.github.shovalhazan:android-permission-library:version'
	}
  
 MAVEN:
  Step 1. Add the JitPack repository to your build file
  	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

Step 2. Add the dependency
	<dependency>
  <dependency>
	    <groupId>com.github.shovalhazan</groupId>
	    <artifactId>android-permission-library</artifactId>
	    <version>Tag</version>
	</dependency>
  
