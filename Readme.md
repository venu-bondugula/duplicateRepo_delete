# Overview
Application for building few simple analytics on a small twitter dataset using the spring batch. This spring boot application is build and run using Maven. The application is configured to read a dataset from a CSV file and process it.

# Installation Steps
## Requirements:
- Java 17 or higher
- Maven

## Instructions:
1. **Fork this Repository:** Click the "Fork" button in the top right corner of this repository to create your copy.
2. **Create a Codespace:** Go to the GitHub Codespaces website and create a new codespace for your forked repository. This may take a few minutes to initialize.
3. **Compile and Build:** Once your Codespace is ready, open a terminal window and run the following commands:
- `mvn clean install`: This compiles and builds the project.
- `mvn spring-boot:run`: This runs the application and displays the output on the console.
  Please be patient as it may take several minutes for everything to start up.

## Configuration
Edit the configuration in `src/main/resources/application.properties`. Possible configuration changes
- `analytics.counter` - Number of results to be displayed per analytic.
- `analytics.twitterDatasetCSVFilePath` - Path of the dataset csv file.
- `analytics.chunkSize` - chunk size for processing.
