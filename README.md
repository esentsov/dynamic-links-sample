## Dynamic Links Sample

This repository is mainly a sample of integration [Firebase Dynamic Links ](https://firebase.google.com/docs/dynamic-links)
with [Navigation Component](https://developer.android.com/guide/navigation/navigation-deep-link) deep link handling.

The idea is to fetch a link from firebase with help of `FirebaseDynamicLinks` class and pass it
to `NavController` for handling.
Firebase link fetching code is asynchronous, so to avoid showing the start destination fragment
while link is being fetched, fetching code is moved to another activity `DeepLinkHandlingActivity`.
The only purpose of this activity is to show something nice (splash screen in my case) while
firebase is parsing the link. When the link is ready, it starts `MainActivity` passing the link,
so navigation component picks the link up and navigates to the right fragment immediately, without
showing default fragment.

This project shows also:
1. How to use kotlin-gradle-dsl
2. How to use buildSrc to share dependencies versions across all modules
3. How to create splash screen using windowBackground property, so it is displayed immediately on app launch.


