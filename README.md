# Spring Boot Weather Application

This Spring Boot application integrates with weather APIs to provide weather forecast information for different cities. It exposes RESTful endpoints to retrieve forecast summaries and hourly forecast details for a specified city.

## Tech Stack

- Java, Spring Boot
- Maven, Git

## Getting Started

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/spring-boot-weather-app.git
    ```

2. Navigate to the project directory:

    ```bash
    cd Backend
    ```

3. Replace the placeholder API keys in `src/main/resources/application.properties` with your actual API keys.

4. Build the project:

    ```bash
    mvn clean install
    ```

5. Run the application:

    ```bash
    mvn spring-boot:run
    ```

## Usage

### Forecast Summary Endpoint

- **URL**: `http://localhost:8080/weather/forecast-summary`
- **Method**: GET
- **Query Parameter**:
    - `city`: The name of the city for which you want to get the forecast summary.
- **Response**: JSON containing the forecast summary for the specified city.

Example Request:

```bash
  GET "http://localhost:8080/weather/forecast-summary?city=Delhi"
