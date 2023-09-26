# Population Registry Spring Boot Application

This is a Java Spring Boot application that manages individual's information similar to a Finnish Population Registry.

## Entities

The application includes the following entities:

- **Person**: Represents an individual with basic information.
- **PersonMore**: Contains additional information about a person, such as marital status and gender.
- **Address**: Describes a person's address information.
- **Parents**: Stores information about a person's parents.
- **Permits**: Relates to a person's permit-related matters.

## Controllers

The application has the following controllers:

- **PersonController**: Manages actions related to individuals and provides REST endpoints for handling individual data.
- **AddressController**: Manages actions related to address information and provides REST endpoints for handling address data.

## Service Classes

The application has the following service classes:

- **PersonService**: Handles the business logic related to individuals, such as adding and updating individuals.
- **AddressService**: Manages the business logic related to address information, such as updating email data.

## Tests

The application includes comprehensive tests for the following components:

- **PersonController**: Each method in the PersonController has its own tests to ensure that the REST endpoints function as expected.
- **PersonService**: Methods in the PersonService class are tested to verify the correctness of individual data handling.
- **AddressService**: Methods in the AddressService class are tested to ensure the accuracy of address data handling.

Tests are implemented using the JUnit testing framework in conjunction with Mockito mocks.
