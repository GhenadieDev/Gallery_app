# 📸 AppGallery

## Overview
**AppGallery** is a simple Android application built using **Jetpack Compose**. It displays a collection of images with captions and allows users to navigate through them using "Next" and "Previous" buttons. The app functions as a mini-gallery, demonstrating the basics of state management, resource handling, and UI design in Compose.

---

## Purpose
The main goals of this project are:

- Learn and practice **Jetpack Compose** and its declarative UI approach.
- Understand and implement **state management** to update the UI dynamically.
- Work with Android **resources**: images (`drawable`) and localized text (`string`).
- Implement simple **navigation within a component** (image browsing).
- Learn about **image optimization** to avoid runtime crashes (`Canvas: trying to draw too large bitmap`).

---

## Features
- Display images with captions.
- Navigate through images using **Next** and **Previous** buttons.
- Loop through the gallery (after the last image, it returns to the first one).
- Supports multiple resource types (`drawable` and `string`).

---

## Technologies and Concepts Used
- **Kotlin** — main programming language.
- **Jetpack Compose** — declarative UI framework:
    - `@Composable` functions.
    - Layouts: `Column`, `Row`, `Spacer`.
    - UI elements: `Image`, `Text`, `Button`.
    - `Modifier` for styling, sizing, and positioning.
- **State in Compose**:
    - `remember { mutableIntStateOf(...) }` to store the current image index.
    - Automatic UI recomposition when the state changes.
- **Resource management**:
    - `painterResource()` for images.
    - `stringResource()` for localized captions.
- **UI styling and decoration**:
    - `border`, `shadow`, `clip`, `ContentScale`.
    - Custom fonts: `FontFamily.Cursive`, `FontWeight.SemiBold`.

---

## How It Works
1. The app launches and displays the first image with its caption.
2. Pressing the **Next** button navigates to the next image.
3. Pressing the **Previous** button navigates to the previous image.
4. After reaching the last image, the gallery loops back to the first image (and vice versa).

---

## Possible Improvements
- Add **swipe gestures** (left/right) to navigate like a real gallery.
- Use **Coil** for efficient image loading and memory optimization.
- Move the image list to a **ViewModel** for a proper MVVM architecture.
- Enhance **responsiveness** for tablets and various screen sizes.
- Add animations for smoother transitions between images.
---

## License
This project is for educational purposes and personal use.