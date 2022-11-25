### Changes

- Improved build gradle to be able to handle multiple modules easier
- Added buildtypes
- Added build config variables
- Implementing MVVM
- Implementing clean architecture to the code by removing most logic out of the Views
- Used Hilt for dependency injection
- Isolated activities by using the Application to launch the details screen
- Code can now easily integrate other 3rd party integrations through repository approach
- Code can add multiple datasource (e.g. local database) through repository approach
- Added UnitTest - has low coverage but was able to go through 1 whole function Source > DataSource > Repository > UseCase

### Further changes if I had more time:

- Better UnitTest Coverage (more classes covered, adding negative tests)
- Would have made it look a lot like a PokeDex
- Used Kotlin Flow
- Better error and negative result handling
- UiStates