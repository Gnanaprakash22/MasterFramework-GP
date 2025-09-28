# Master Framework

A comprehensive test automation framework built with Java, Selenium, Appium, and REST Assured that supports Web, Mobile (Android/iOS), and API testing with multiple execution modes and cloud platforms.

## 🚀 Features

- **Multi-Platform Testing**: Web, Mobile (Android/iOS), and API testing capabilities
- **Multiple Execution Modes**: Local, Remote (Selenium Grid, Selenoid), and Cloud (BrowserStack, SauceLabs)
- **Cross-Platform Mobile Testing**: Native Android and iOS app testing with Appium
- **API Testing**: RESTful API testing with REST Assured
- **Page Object Model**: Clean and maintainable test structure
- **Thread-Safe Execution**: ThreadLocal-based driver management for parallel execution
- **Configuration Management**: Environment-based configuration with Owner library
- **Test Data Management**: Fixture Factory for test data generation
- **Reporting**: ExtentReports integration for detailed test reporting
- **Code Quality**: Checkstyle integration for code quality enforcement

## 🛠️ Technology Stack

### Core Testing Frameworks
- **Java 21**
- **Selenium WebDriver 4.35.0**
- **Appium Java Client 10.0.0**
- **REST Assured 5.5.6**
- **JUnit 5 (5.13.4)**
- **TestNG**

### Build & Dependency Management
- **Maven 3.6+**
- **Maven Surefire Plugin 3.0.0-M5**
- **Maven Checkstyle Plugin 3.2.0**

### Reporting & Utilities
- **ExtentReports 5.1.2**
- **AssertJ 3.27.6**
- **JavaFaker 1.0.2**

### Configuration & Data Management
- **Owner Library 1.0.12** - Configuration management
- **Jackson 2.13.1** - JSON processing
- **Fixture Factory 3.1.0** - Test data generation
- **Reflections 0.10.2** - Runtime reflection

### Code Quality & Utilities
- **Lombok 1.18.42** - Boilerplate reduction
- **Awaitility 4.3.0** - Asynchronous testing
- **NoException 1.9.1** - Functional error handling

### Cloud Platforms
- **BrowserStack** - Mobile testing
- **SauceLabs** - Cross-browser testing
- **Selenium Grid** - Local/remote execution
- **Selenoid** - Docker-based Selenium

## 📁 Project Structure

```
MasterFramework/
├── src/
│   ├── main/java/com/tmb/
│   │   ├── annotations/          # Custom test annotations
│   │   ├── api/                  # API testing components
│   │   │   ├── pojos/           # Data transfer objects
│   │   │   └── ReqresApi.java   # API client
│   │   ├── config/              # Configuration management
│   │   │   ├── converters/      # Type converters
│   │   │   └── factory/         # Configuration factories
│   │   ├── driver/              # WebDriver management
│   │   │   ├── factory/         # Driver factories
│   │   │   ├── manager/         # Driver managers
│   │   │   └── impl/            # Driver implementations
│   │   ├── enums/               # Framework enums
│   │   ├── fixtures/            # Test data fixtures
│   │   ├── pages/               # Page Object Model
│   │   │   ├── mobile/          # Mobile page objects
│   │   │   └── web/             # Web page objects
│   │   └── utils/               # Utility classes
│   └── test/java/com/tmb/tests/
│       ├── api/                 # API test cases
│       ├── mobile/              # Mobile test cases
│       └── web/                 # Web test cases
├── src/test/resources/
│   ├── config.properties        # Main configuration
│   ├── api-config.properties    # API configuration
│   ├── browser-stack.properties # BrowserStack config
│   ├── sauce-labs.properties    # SauceLabs config
│   └── requests/                # API request templates
├── config/checkstyle/           # Code quality configuration
├── android-app.apk             # Android test app
├── ios-app.zip                 # iOS test app
├── pom.xml                     # Maven configuration
└── testng.xml                  # TestNG configuration
```

## ⚙️ Configuration

### Environment Configuration

The framework supports multiple environments through configuration files:

- `config.properties` - Main configuration
- `dev-config.properties` - Development environment
- `staging-config.properties` - Staging environment

### Key Configuration Properties

```properties
# Browser Configuration
browser=chrome
runModeBrowser=local
browserRemoteMode=selenium

# Mobile Configuration
runModeMobile=local
mobileRemoteMode=browser_stack
mobilePlatformType=android

# Remote Execution
seleniumGridURL=http://localhost:4444/wd/hub
selenoidURL=http://localhost:4444/wd/hub

# API Configuration
api.baseurl=https://reqres.in/
```

## 🚀 Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6+
- Chrome/Firefox browser
- Android Studio (for Android testing)
- Xcode (for iOS testing)
- Appium Server

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd MasterFramework
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Configure your environment**
   - Update `src/test/resources/config.properties` with your settings
   - Add your cloud platform credentials (BrowserStack, SauceLabs)

### Running Tests

#### Web Tests
```bash
# Run all web tests
mvn test -Dtest=com.tmb.tests.web.*

# Run specific test
mvn test -Dtest=AddUsersTest
```

#### Mobile Tests
```bash
# Run Android tests
mvn test -Dtest=com.tmb.tests.mobile.* -DmobilePlatformType=android

# Run iOS tests
mvn test -Dtest=com.tmb.tests.mobile.* -DmobilePlatformType=ios
```

#### API Tests
```bash
# Run API tests
mvn test -Dtest=com.tmb.tests.api.*
```

#### TestNG Suite
```bash
# Run TestNG suite
mvn test -DsuiteXmlFile=testng.xml
```

## 📱 Mobile Testing Setup

### Android Setup
1. Install Android Studio and SDK
2. Enable USB Debugging on your device
3. Install the test APK: `android-app.apk`
4. Start Appium server: `appium --port 4723`

### iOS Setup
1. Install Xcode and iOS Simulator
2. Install the test app from `ios-app.zip`
3. Start Appium server with iOS capabilities

## 🌐 Cloud Platform Integration

### BrowserStack
1. Add your credentials to `browser-stack.properties`
2. Set `mobileRemoteMode=browser_stack` in configuration

### SauceLabs
1. Add your credentials to `sauce-labs.properties`
2. Set `mobileRemoteMode=sauce_labs` in configuration

## 🧪 Writing Tests

### Web Test Example
```java
@ParameterizedTest
@EnumSource(value = AddUsersScenarioType.class, names = {"VALID"})
void testAddUsers(AddUsersScenarioType scenarioType) {
    boolean isMessageDisplayed = new LoginPage()
        .loginToApplication("Admin", "admin123")
        .navigateToSystemUsersPage()
        .getUserListComponent()
        .setAddButton()
        .fillDetails(scenarioType.getUserData(), scenarioType.getPredicate());
    
    Assertions.assertThat(isMessageDisplayed).isTrue();
}
```

### Mobile Test Example
```java
@AndroidTest
void testLoginAndroid() {
    HomeScreen.getHomeScreenInstance()
        .navigateToViewsScreen()
        .clickOnViewScreenElement(WEB_VIEW);
}
```

### API Test Example
```java
@Test
void postNewUser() throws IOException {
    UserDetails userDetails = UserTestData.getUserDetails();
    Response response = ReqresApi.postUsers(userDetails);
    
    ResponseAssert.assertThat(response)
        .statusCodeIs(201)
        .canBeDeserializedTo(UserResponseDetails.class)
        .hasKeyWithValue("job", "leader")
        .assertAll();
}
```

## 🔧 Custom Annotations

The framework provides custom annotations for better test organization:

- `@AndroidTest` - Run test only on Android
- `@IosTest` - Run test only on iOS
- Both annotations can be combined for cross-platform testing

## 📊 Reporting

The framework generates detailed test reports using ExtentReports. Reports are automatically generated after test execution and can be found in the `target/` directory.

## 🏗️ Architecture Highlights

### Driver Management
- Thread-safe driver management using ThreadLocal
- Support for both Web and Mobile drivers
- Automatic driver lifecycle management

### Configuration Management
- Environment-based configuration using Owner library
- Type-safe configuration with custom converters
- Support for system properties and environment variables

### Page Object Model
- Clean separation of test logic and page interactions
- Reusable page components
- Mobile-specific page objects for Android and iOS

## 🚀 Best Practices

1. **Use Page Object Model** for maintainable test code
2. **Leverage custom annotations** for platform-specific tests
3. **Use fixture factory** for test data generation
4. **Follow naming conventions** defined in checkstyle configuration
5. **Use appropriate assertions** with AssertJ for better error messages

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Run tests and ensure they pass
5. Submit a pull request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🚨 Troubleshooting

### Common Issues

#### 1. Checkstyle Violations
If you encounter Checkstyle errors during build:
```bash
# Check for specific violations
mvn checkstyle:check

# Common fixes:
# - Add whitespace after typecast: ((Type) (object))
# - Remove unused imports
# - Fix indentation and formatting
```

#### 2. Lombok Compatibility Issues
If you see `NoSuchFieldError` related to `JCTree$JCImport`:
- **Issue**: Lombok version incompatibility with Java version
- **Solution**: Update Lombok to version 1.18.24 or higher for Java 11+ compatibility

#### 3. Build Failures
```bash
# Skip checkstyle temporarily for testing
mvn test -Dcheckstyle.skip=true

# Clean and rebuild
mvn clean compile test
```

### Prerequisites Verification
```bash
# Check Java version
java -version

# Check Maven version
mvn -version

# Verify Lombok compatibility
mvn dependency:tree | grep lombok
```

## 🆘 Support

For questions and support, please open an issue in the repository or contact the development team.

---

**Note**: This framework is designed for educational and professional testing purposes. Make sure to update configuration files with your specific environment details before running tests.
