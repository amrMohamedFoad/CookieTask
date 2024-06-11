# Most-active-cookie
This Java application processes a cookie log file and returns the most active cookie(s) for a specific date. The project is built using Spring Boot and Maven, and it is designed with an object-oriented, extendable architecture. 
The command-line interface allows users to specify the log file and the date for which they want to find the most active cookie(s).

## Example
Given a cookie log file in the following format:
~~~
cookie,timestamp
AtY0laUfhglK3lC7,2018-12-09T14:19:00+00:00
SAZuXPGUrfbcn5UA,2018-12-09T10:13:00+00:00
5UAVanZf6UtGyKVS,2018-12-09T07:25:00+00:00
AtY0laUfhglK3lC7,2018-12-09T06:19:00+00:00
SAZuXPGUrfbcn5UA,2018-12-08T22:03:00+00:00
4sMM2LxV07bPJzwf,2018-12-08T21:30:00+00:00
fbcn5UAVanZf6UtG,2018-12-08T09:30:00+00:00
4sMM2LxV07bPJzwf,2018-12-07T23:30:00+00:00
~~~
and we would like  to obtain the most active cookie for 9th Dec 2018, by using the command like this
~~~
$ ./[command] -f cookie_log.csv -d 2018-12-09
~~~

And it would write to console:
~~~
AtY0laUfhglK3lC7
~~~

## Assumptions
- If multiple cookies meet that criteria, return all of them on separate lines.
- Only use additional libraries for testing, logging and cli-parsing.
- assume -d parameter takes date in UTC time zone.
- have enough memory to store the contents of the whole file.
- Cookies in the log file are sorted by timestamp (most recent occurrence is the first line of the file).
  
## Features
- **Command-line Interface**: Easily specify the log file and the date.
- **Most Active Cookie**: Find the most active cookie(s) for a specified date.
- **Extendable Architecture**: Easily add new features or commands.
- **Error Handling**: Robust error handling for file parsing and invalid inputs.
  
## Prerequisites
- Java 8 or higher
- Maven 3.6 or higher

## Installation
1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/most-active-cookie.git
    cd most-active-cookie
    ```

2. **Build the project**:
    ```bash
    mvn clean install
    ```

## Usage
To run the application, use the following command:

```bash
java -jar target/cookie-0.0.1-SNAPSHOT.jar -f <log-file-name> -d <date>
```
Note: the log file should be added under resources/logs folder to be accessable

### Example
If your `cookie_log.csv` file is located in the `resources\logs` directory and you want to find the most active cookie(s) for December 9, 2018, use:

```bash
java -jar target/cookie-0.0.1-SNAPSHOT.jar -f cookie_log.csv -d 2018-12-09
```

## Testing

To run the tests, use the following command:

```bash
mvn test
```

The project includes unit tests for the key components to ensure correctness and reliability.
