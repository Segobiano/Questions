'''
 * Method returns the greater version number.
 * A normal version number MUST take the form X.Y.Z where X, Y, Z are non-negative integer
 * Values increase numerically. For instance: 1.9.0 -> 1.10.0 -> 1.11.0.
 * If the input is invalid we should raise a SemanticVersionException
 * Must not contain leading zeroes
 * If the inputs are the same return that version
'''

class SemanticVersionQuestion:

    @staticmethod
    def get_greater_version(first_version: str, second_version: str) -> str:
        first_version_list = first_version.split('.')
        second_version_list = second_version.split('.')
        for first, second in zip(first_version_list, second_version_list):
            if first > second:
                return first_version
            elif first < second:
                return second_version
            else:
                continue
        return '0.0.0'


class SemanticVersionException(Exception):
    pass