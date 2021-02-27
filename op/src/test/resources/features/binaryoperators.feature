Feature: binary operators
    client wants to perform a binary operation

    Scenario Outline: add
        Given the client uses the /api/1.0.0 with precision 0.001
        When the client adds <a> and <b>
        Then the result should be <answer>

        Examples:
            | a    | b    | answer |
            | 1.3  | 1.7  | 3      |
            | 2.5  | 89.4 | 91.9   |
            | -0.3 | 9.1  | 8.8    |

    Scenario Outline: sub
        Given the client uses the /api/1.0.0 with precision 0.001
        When the client subtracts <a> from <b>
        Then the result should be <answer>

        Examples:
            | a    | b    | answer |
            | 1.3  | 1.7  | -0.4   |
            | 2.5  | 89.4 | -86.9  |
            | -0.3 | 9.1  | -9.4   |

    Scenario Outline: mul
        Given the client uses the /api/1.0.0 with precision 0.001
        When the client mutiplies <a> and <b>
        Then the result should be <answer>

        Examples:
            | a    | b    | answer |
            | 1.3  | 1.7  | 2.21   |
            | 2.5  | 89.4 | 223.5  |
            | -0.3 | 9.1  | -2.73  |

    Scenario Outline: div
        Given the client uses the /api/1.0.0 with precision 0.001
        When the client divides <a> with <b>
        Then the result should be <answer>

        Examples:
            | a    | b    | answer |
            | 1.3  | 1.7  | 0.765  |
            | 2.5  | 89.4 | 0.028  |
            | -0.3 | 9.1  | -0.033 |