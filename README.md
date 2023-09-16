# JajaburId

## Overview
"JajaburId" is a mobile application that allows users to buy or order snacks and food from the comfort of their homes. It provides a convenient way to explore a variety of available food items and place orders seamlessly.

## Current Features

- Provide list of best food 
- Give detailed food information

## Design

The app's user interface (UI) and user experience (UX) design can be found on Figma. You can view the design by following this [link](https://www.figma.com/file/gGtBViUegotifzOQ7XP7XT/Jajabur.id?type=design&node-id=0%3A1&mode=design&t=vsLVDp82UzZO1HZl-1).
![Figma Design](https://github.com/Syn57/Coder-Byte-C/blob/main/figma_jajabur.png?raw=true)

## App development
The development is integrated in Android Studio. The app contains 2 activity. First, Main activity to show list of food. Second, Detail Activity to give the detail information of certain spesific food. Here are the several informations about the app development. The app is built following the Model-View-ViewModel (MVVM) architecture pattern. This separation of concerns enhances code maintainability and testability.
- **Language:** Kotlin
- **Design Pattern and Architecture:** MVVM Design Pattern
- **Networking and Support:** Retrofit, Coroutines Flow, OkHTTP, Logging Interceptor for debug variants
- **View Support:** AndroidX, Ktx, Recycle View, Swipe Refresh
- **Jetpack:** ViewModel, LiveData, Android KTX, AppCompat
## Tech

JajaburId uses a number of open source libary:

- [Kotlin Flow and Coroutines](https://kotlinlang.org/docs/flow.html) - For asynchronous programming.
- [Koin](https://insert-koin.io/) - A lightweight dependency injection framework.
- [Glide](https://github.com/bumptech/glide) - For efficient image loading and caching.
- [Retrofit](https://square.github.io/retrofit/) - To make network requests.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - For data observation.
- [SwipeRefreshLayout](https://developer.android.com/reference/androidx/swiperefreshlayout/widget/SwipeRefreshLayout) - To implement pull-to-refresh functionality.
- [Shimmer](https://facebook.github.io/shimmer-android/) - For shimmering loading effects.

## API Reference
The API can be accesed [here](https://mocki.io/v1/52c41978-6e31-4ea3-b917-01899e3ed373).
#### Get food

```http
 GET /mocki.io/v1/52c41978-6e31-4ea3-b917-01899e3ed373
```

The Retrofit interface retrieves the response in the format of a list of food objects (FoodResponseItem).

```kotlin
@GET("52c41978-6e31-4ea3-b917-01899e3ed373")
suspend fun getFood(): List<FoodResponseItem?>?
```

```kotlin
data class FoodResponseItem(

	@field:SerializedName("cover")
	val cover: String? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("desc")
	val desc: String? = null
)
```

## How to Run the Project

To run the project locally, follow these steps:

1. Clone the repository to your local machine:
```sh
git clone https://github.com/Syn57/JajaburId.git
```
2. Open the project in Android Studio.

3. Build and run the app on an emulator or physical device.

## Demo


https://github.com/Syn57/JajaburId/assets/78636403/b7fcbdca-03b6-4c20-bfe2-5aa77503b378

