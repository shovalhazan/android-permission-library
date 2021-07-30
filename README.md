# android-permission-library
 Android library that simplifies the process of requesting permissions at runtime.
 
 PERMISSION GROUPS:<br />
 CALENDAR<br />
 CAMERA&GALLRY(CAMERA&STORAGE)<br />
 CONTACT<br />
 LOCATION<br />
 MICROPHONE<br />
 PHONE<br />
 SENSOR<br />
 SMS<br />
 
Usage:<br />
1)If you are interested in asking once please call checkAndRequestPhonePermission in the appropriate place
For example :<br />
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PhonePermission.checkAndRequestPermission(this,Manifest.permission.CALL_PHONE,Manifest.permission.READ_PHONE_STATE);
    }

<br />
2)If you are interested in the case of deny ask again until allow:checkAndRequestPhonePermission should be exercised in onRequestPermissionsResult.<br /><br />
3)In the case of deny and do not ask me again to refer to the settings once:askForSettingPermission must be realized in the onRequestPermissionsResult.(after 1)<br />
For example :<br />

	@Override
    	public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        	super.onRequestPermissionsResult(requestCode, permissions, grantResults);
       		 CalendarPermission.askForSettingPermission(this,Manifest.permission.WRITE_CALENDAR,Manifest.permission.READ_CALENDAR);
    }


<br />
4)If you wish that until there is no confirmation of the settings insist,askForSettingPermission should be realized in onActivityResult.<br />


To get a the library into your build:<br />

GRADLE:<br />

Step 1. Add the JitPack repository to your build file<br />

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
 Step 2. Add the dependency<br />

 	dependencies {
	        implementation 'com.github.shovalhazan:android-permission-library:version'
	}
  
 MAVEN:<br />

  Step 1. Add the JitPack repository to your build file<br />

  	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
<br />

Step 2. Add the dependency<br />

	<dependency>
	    <groupId>com.github.shovalhazan</groupId>
	    <artifactId>android-permission-library</artifactId>
	    <version>Tag</version>
	</dependency>
  
