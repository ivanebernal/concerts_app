# Concerts App
An app that uses the Ticketmaster API to find artist concerts

## How to run
### Ticketmaster API key
This app uses the [ticketmaster api](https://developer.ticketmaster.com/api-explorer/v2/) to explore artists and concerts. In order to use this code, you have to create an api key following the [instructions on the Ticketmaster webpage](https://developer-acct.ticketmaster.com/user/register). Once you have the API key, open your user's directory `~/.gradle/gradle.properties` and write the following:
```yaml
tm_api_key="<YOUR_API_KEY>"
```
### Google Maps API Key
In order to get google maps working, you have to create a google maps API key. Follow the instructions on the [Google Maps Platform site](https://developers.google.com/maps/documentation/android-sdk/get-api-key). Once you have it, create a file called `google_maps_api.xml` in the `app/src/debug/res/values/` directory. The contents of the file must be like this: 

```xml
<resources>
    <!--
    Once you have your key (it starts with "AIza"), replace the "google_maps_key"
    string in this file.
    -->
    <string name="google_maps_key" translatable="false" templateMergeStrategy="preserve">YOUR_MAPS_API_KEY</string>
</resources>
```
Then go to your app's `AndroidManifest.xml` and place the following inside the `<application>` tag:
```xml
<meta-data
      android:name="com.google.android.geo.API_KEY"
      android:value="@string/google_maps_key"/>
```
After doing this, you should be able to run the app on your machine.
## Screenshots

<img src="https://user-images.githubusercontent.com/16783519/60782541-e6260e80-a0fb-11e9-8f5b-d45c59ccb036.png" width=200> <img src="https://user-images.githubusercontent.com/16783519/60782375-423c6300-a0fb-11e9-9e43-3591e4b530de.png" width=200> <img src="https://user-images.githubusercontent.com/16783519/60782408-5718f680-a0fb-11e9-83ad-9df070ac62c6.png" width=200> <img src="https://user-images.githubusercontent.com/16783519/60782428-6e57e400-a0fb-11e9-9dc9-58747599eec2.png" width=200>
