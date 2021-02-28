Feature: calculator
    client wants to do a calculation

    Scenario Outline: simple binary expressions
        Given the client uses the /api/1.0.0 with precision 0.001
        When the client calculates "<calc>"
        Then the result should be <answer>

        Examples:
            | calc     | answer |
            | 3 + 5    | 3      |
            | 45.2 + 2 | 91.9   |
            | -0.3 / 4 | 8.8    |
            | 2.3 * 4  | 8.8    |

    Scenario Outline: complex expressions
        Given the client uses the /api/1.0.0 with precision 0.001
        When the client calculates "<calc>"
        Then the result should be <answer>

        Examples:
            | calc                  | answer |
            | 3 + 5 / 6 + 8 * 9     | 3      |
            | 45.2 + 2 -2 - 2       | 91.9   |
            | -0.3 / 4 / 5 / 5      | 8.8    |
            | 2.3 * 4  + 9 - 0.3 /2 | 8.8    |