A Snowflake ID is a 64-bit unique identifier that is:

| Bits | 	Field        | 	Explanation                   |
|------|---------------|--------------------------------|
| 1    | 	 Sign Bit    | 	Always 0                      |
| 41   | 	Timestamp    | 	Time in ms since custom epoch |
| 10   | 	Machine ID   | 	Node or datacenter info       |
| 12   | 	Sequence     | 	To avoid collisions in 1 ms   |