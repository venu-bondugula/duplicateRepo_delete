# Overview
Application for building few simple analytics on a small twitter dataset using the spring batch. This spring boot application is build and run using Maven. The application is configured to read a dataset from a CSV file and process it.

# Installation Steps
## Requirements:
- Java 17 or higher
- Maven

## Instructions:
1. **Fork this Repository:** Click the "Fork" button in the top right corner of this repository to create your copy.
2. **Create a Codespace:**
    - From the GitHub project page,
     ![image](https://github.com/venu-bondugula/tweetAnalyzerSpringBatch/assets/12949458/9b7e564f-ab63-4412-b578-3f7237c39c4b)
    - click the `code` button
     ![image](https://github.com/venu-bondugula/tweetAnalyzerSpringBatch/assets/12949458/9f8bee9d-2655-4e0a-9106-0b5e6ff85d0b)
    - Select the `Codespaces` tab on the opened modal,
     ![image](https://github.com/venu-bondugula/tweetAnalyzerSpringBatch/assets/12949458/ee24b7f3-c898-4fe2-949f-f74638b2f4dc)
    - Click on the `+` button to create the codespace with default configuration.
     ![image](https://github.com/venu-bondugula/tweetAnalyzerSpringBatch/assets/12949458/43db7e0d-fc2b-4c07-918a-7cad7fea9171)
    - This may take a few minutes to initialize. For more instruction follow official documentation here - https://docs.github.com/en/codespaces/developing-in-a-codespace/creating-a-codespace-for-a-repository#creating-a-codespace-for-a-repository
4. **Compile and Build:** Once your Codespace is ready, open a terminal window and run the following commands:
- `mvn clean install`: This compiles and builds the project.
- `mvn spring-boot:run`: This runs the application and displays the output on the console.

## Configuration
Edit the configuration in `src/main/resources/application.properties`. Possible configuration changes
- `analytics.counter` - Number of results to be displayed per analytic.
- `analytics.twitterDatasetCSVFilePath` - Path of the dataset csv file.
- `analytics.chunkSize` - chunk size for processing.

test