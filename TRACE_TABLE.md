# Trace Table

Trace table generated from `data/requests.csv`.

## Parameters Used

- Normal circular queue capacity: 9
- Correction deque capacity: 11
- Urgency bonus: 1
- Service steps: 27
- Trace table length: 14
- Priority formula: `(urgencyLevel * 10) + urgencyBonus - estimatedMinutes - arrivalOrder`

The simulator first admits all requests, then serves requests. The index values below are zero-based array indexes.

## Initial State After Admissions

| Structure | State |
| --- | --- |
| Circular Queue Front | 0 |
| Circular Queue Rear | 8 |
| Deque Front | 0 |
| Deque Rear | 6 |
| Stack Top | 27 |
| Urgent Queue Size | 12 |
| Correction Deque Size | 7 |
| Normal Circular Queue Size | 9 |
| Overflow Count | 12 |

## Trace Table

| Step | Operation | Circular Queue Front | Circular Queue Rear | Deque Front | Deque Rear | Stack Top | Served Request |
| ---: | --- | ---: | ---: | ---: | ---: | --- | --- |
| 1 | Serve urgent request | 0 | 8 | 0 | 6 | SERVE PAT003, index 28 | PAT003 |
| 2 | Serve urgent request | 0 | 8 | 0 | 6 | SERVE PAT007, index 29 | PAT007 |
| 3 | Serve urgent request | 0 | 8 | 0 | 6 | SERVE PAT013, index 30 | PAT013 |
| 4 | Serve urgent request | 0 | 8 | 0 | 6 | SERVE PAT017, index 31 | PAT017 |
| 5 | Serve urgent request | 0 | 8 | 0 | 6 | SERVE PAT010, index 32 | PAT010 |
| 6 | Serve urgent request | 0 | 8 | 0 | 6 | SERVE PAT029, index 33 | PAT029 |
| 7 | Serve urgent request | 0 | 8 | 0 | 6 | SERVE PAT021, index 34 | PAT021 |
| 8 | Serve urgent request | 0 | 8 | 0 | 6 | SERVE PAT023, index 35 | PAT023 |
| 9 | Serve urgent request | 0 | 8 | 0 | 6 | SERVE PAT027, index 36 | PAT027 |
| 10 | Serve urgent request | 0 | 8 | 0 | 6 | SERVE PAT033, index 37 | PAT033 |
| 11 | Serve urgent request | 0 | 8 | 0 | 6 | SERVE PAT040, index 38 | PAT040 |
| 12 | Serve urgent request | 0 | 8 | 0 | 6 | SERVE PAT036, index 39 | PAT036 |
| 13 | Serve correction request | 0 | 8 | 1 | 6 | SERVE PAT005, index 40 | PAT005 |
| 14 | Serve correction request | 0 | 8 | 2 | 6 | SERVE PAT011, index 41 | PAT011 |

## Simulation Summary Table

| Step | Served Request | Source | Priority Score | Urgent Remaining | Correction Remaining | Normal Remaining | Served Total | Urgent Served | Correction Served | Normal Served | Overflow Count | Cumulative Minutes | Average Minutes |
| ---: | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| 1 | PAT003 | Urgent queue | 28 | 11 | 7 | 9 | 1 | 1 | 0 | 0 | 12 | 20 | 20.00 |
| 2 | PAT007 | Urgent queue | 19 | 10 | 7 | 9 | 2 | 2 | 0 | 0 | 12 | 35 | 17.50 |
| 3 | PAT013 | Urgent queue | 18 | 9 | 7 | 9 | 3 | 3 | 0 | 0 | 12 | 45 | 15.00 |
| 4 | PAT017 | Urgent queue | 16 | 8 | 7 | 9 | 4 | 4 | 0 | 0 | 12 | 63 | 15.75 |
| 5 | PAT010 | Urgent queue | 16 | 7 | 7 | 9 | 5 | 5 | 0 | 0 | 12 | 88 | 17.60 |
| 6 | PAT029 | Urgent queue | 10 | 6 | 7 | 9 | 6 | 6 | 0 | 0 | 12 | 100 | 16.67 |
| 7 | PAT021 | Urgent queue | 8 | 5 | 7 | 9 | 7 | 7 | 0 | 0 | 12 | 122 | 17.43 |
| 8 | PAT023 | Urgent queue | 1 | 4 | 7 | 9 | 8 | 8 | 0 | 0 | 12 | 139 | 17.38 |
| 9 | PAT027 | Urgent queue | -2 | 3 | 7 | 9 | 9 | 9 | 0 | 0 | 12 | 155 | 17.22 |
| 10 | PAT033 | Urgent queue | -6 | 2 | 7 | 9 | 10 | 10 | 0 | 0 | 12 | 179 | 17.90 |
| 11 | PAT040 | Urgent queue | -10 | 1 | 7 | 9 | 11 | 11 | 0 | 0 | 12 | 200 | 18.18 |
| 12 | PAT036 | Urgent queue | -10 | 0 | 7 | 9 | 12 | 12 | 0 | 0 | 12 | 215 | 17.92 |
| 13 | PAT005 | Correction deque | N/A | 0 | 6 | 9 | 13 | 12 | 1 | 0 | 12 | 225 | 17.31 |
| 14 | PAT011 | Correction deque | N/A | 0 | 5 | 9 | 14 | 12 | 2 | 0 | 12 | 234 | 16.71 |
