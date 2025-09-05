# Android Automation Project

This project automates Android app testing using Appium, Selenium, Cucumber, and Java.

---

## Project Structure

```
src/
  test/
    java/
      features/         # gherkin steps
      hooks/
      pages/            # page file
      runners/
      stepDefinitions/  # step definition of a page
      utils/
    resources/
```

## Prerequisites

Before running this project, make sure you have the following installed:

- latest Java 24
- Maven
- Appium
    - uiautomator2 driver
---

## Steps To Run

### 1. Clone the Repository

```sh
git clone https://github.com/naufalfajr/AUTOMATION-PERSONAL.git
cd AUTOMATION-PERSONAL
```

### 2. Add the APK File

Place your APK file in the following directory:

```
src/test/resources/
```

### 3. Start your Android Emulator

Open Android Studio and boot your Android Emulator

### 4. Configure Properties

- Copy the sample config file and rename it to `config.properties`.
- Edit `config.properties` with your desired configuration.

### 5. Install Dependencies

Maven will handle Java dependencies automatically, but ensure Appium is installed globally:

```sh
npm install -g appium
```
or using brew:
```sh
brew install appium
```

### 6. Start the Appium Server

Start Appium in a separate terminal window:

```sh
appium -pa /wd/hub
```

### 7. Run the Tests

Execute the tests using Maven:

```sh
mvn clean test
```

---

## Notes

- Make sure your Android device or emulator is running and accessible.
- Update the configuration in `config.properties` as needed for your environment.
- Test results and reports will be available in the `target` directory after execution.