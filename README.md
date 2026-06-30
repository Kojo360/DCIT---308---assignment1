# DCIT 308 Individual Assignment

This is a Java console program that simulates request handling at a Ghana service centre. It uses a normal circular queue, a correction deque, an urgent priority queue, and an action stack.

## Requirements

- Java JDK installed
- `javac` and `java` available in your terminal

Check your Java installation:

```bash
javac -version
java -version
```

## How to Run

From the project root directory, compile all Java files:

```bash
javac src/*.java
```

On Windows PowerShell, this also works:

```powershell
javac src\*.java
```

Run the simulator with the sample CSV file:

```bash
java -cp src GhanaServiceSimulator data/requests_sample.csv
```

On Windows PowerShell:

```powershell
java -cp src GhanaServiceSimulator data\requests.csv
```

You can also run it from inside the `src` folder:

```bash
cd src
javac *.java
java GhanaServiceSimulator ../data/requests_sample.csv
```

## Input Data

The simulator expects a CSV file with this header:

```csv
requestId,arrivalOrder,location,serviceType,urgencyLevel,estimatedMinutes,needsCorrection,notes
```

Available example files are in the `data` folder:

- `data/requests_sample.csv`
- `data/requests_template.csv`
- `data/requests.csv`

To use your own dataset, replace the path in the run command:

```bash
java -cp src GhanaServiceSimulator data.csv
```

## Expected Output

The program prints each served request, then a final report showing total served requests, urgent/correction/normal counts, overflow count, remaining queue sizes, and average estimated minutes served.
